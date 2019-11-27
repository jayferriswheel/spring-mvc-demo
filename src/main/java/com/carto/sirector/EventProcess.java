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

	EventProcess(EventHandler<Event> eventHandler, int depdending,
                 List<EventHandler<Event>> dependedEventHandlers) {
		this.eventHandler = eventHandler;
		this.unsatisfiedDepdendings = depdending;
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
			eventHandler.onEvent(event);
			if (dependedEventHandlers != null) {
				boolean hasUsedSynRunTimeOnce = false;
				for (int i = 0; i < dependedEventHandlers.size(); i++) {
					EventProcess<Event> process = runtime
							.getProcess(dependedEventHandlers.get(i));
					if (process.decreaseUnsatisfiedDependencies() == 0) {
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
