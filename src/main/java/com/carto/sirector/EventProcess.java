package com.carto.sirector;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class EventProcess<Event> implements Runnable, Cloneable {

	protected ScriptRuntime<Event> runtime;

	private final EventHandler<Event> eventHandler;

	private volatile int unsatisfiedDepdendings;

	private final List<EventHandler<Event>> dependedEventHandlers;

	private Event event;

	private Lock lock;

	/**
	 * @param eventHandler
	 * @param depending eventHandler依赖的handler数目，必须为0，eventHandler才能执行
	 * @param dependedEventHandlers 依赖eventHandler的handler list
	 */
	EventProcess(EventHandler<Event> eventHandler, int depending,
                 List<EventHandler<Event>> dependedEventHandlers) {
		this.eventHandler = eventHandler;
		this.unsatisfiedDepdendings = depending;
		this.dependedEventHandlers = dependedEventHandlers;
	}

	/**
	 * Initialize the object cloned from prototype.
	 *
	 * @param runtime
	 * @param t
	 */
	void init(ScriptRuntime<Event> runtime, Event t) {
		this.runtime = runtime;
		this.event = t;
	}

	public void run() {
		try {
			eventHandler.onEvent(event); // 这里执行，开始回调
			if (dependedEventHandlers != null) {
				boolean hasUsedSynRunTimeOnce = false;
				for (int i = 0; i < dependedEventHandlers.size(); i++) {
					EventProcess<Event> process = runtime
							.getProcess(dependedEventHandlers.get(i));
					// 无依赖项 -> run
					if (process.decreaseUnsatisfiedDependencies() == 0) {
						// 我理解这里应该是为了发挥多线程的作用，因为已经在当前线程执行了任务，所以第二个应该再起一个线程
						if (!hasUsedSynRunTimeOnce) {
							hasUsedSynRunTimeOnce = true;
							process.run();
						} else {
							runtime.startProcess(process);
						}
					}
				}
			}
		} catch (Exception e) {
			runtime.markAsError(e);
		}
	}

	/**
	 * @return 是否有未满足的依赖
	 */
	boolean hasUnsatisfiedDependencies() {
		lock.lock();
		try {
			return unsatisfiedDepdendings != 0;
		} finally {
			lock.unlock();
		}
	}

	private int decreaseUnsatisfiedDependencies() {
		lock.lock();
		try {
			return --unsatisfiedDepdendings;
		} finally {
			lock.unlock();
		}
	}

	@SuppressWarnings("unchecked")
	public Object clone() {
		try {
			EventProcess<Event> cloned = (EventProcess<Event>) super.clone();
			cloned.lock = new ReentrantLock();
			return cloned;
		} catch (Exception e) {
			throw new InternalError();
		}
	}

}
