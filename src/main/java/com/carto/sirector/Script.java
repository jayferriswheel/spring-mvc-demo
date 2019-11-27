package com.carto.sirector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

class Script<Event> {

	// 一个标志位
	private boolean ready = false;

	private final IdentityHashMap<EventHandler<Event>, List<EventHandler<Event>>> dependedHandlers = new IdentityHashMap<EventHandler<Event>, List<EventHandler<Event>>>();

	synchronized EventHandlerGroup<Event> after(
			final EventHandler<Event>... handlers) {
		if (ready) {
			throw new IllegalStateException(
					"script is ready, cannot be edit any more.");
		}
		for (EventHandler<Event> handler : handlers) {
			if (!dependedHandlers.containsKey(handler)) {
				throw new IllegalStateException(
						"event handler is not in script yet.");
			}
		}
		return start(handlers);
	}

	synchronized EventHandlerGroup<Event> start(
			final EventHandler<Event>... handlers) {
		if (ready) {
			throw new IllegalStateException(
					"script is ready, cannot be edit any more.");
		}
		EventHandlerGroup<Event> clips = new EventHandlerGroup<Event>(this,
				Arrays.asList(handlers));
		return clips;
	}

	synchronized Map<EventHandler<Event>, List<EventHandler<Event>>> getDependedEventHandlers() {
		return dependedHandlers;
	}

	synchronized void ready() {
		ready = true;
	}

	synchronized boolean isReady() {
		return ready;
	}

	void addDependency(EventHandler<Event> from, EventHandler<Event> to) {
		if (!dependedHandlers.containsKey(from)) {
			dependedHandlers.put(from, new ArrayList<EventHandler<Event>>(0));
		}
		if (to != null && !dependedHandlers.get(from).contains(to)) {
			dependedHandlers.get(from).add(to);
		}
	}

}
