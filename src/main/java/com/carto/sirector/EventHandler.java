package com.carto.sirector;

/**
 * Callback interface to be implemented for processing event.
 * 
 * @author chenfeng
 * 
 * @param <Event>
 *            event published by sirector
 */
public interface EventHandler<Event> {

	/**
	 * Called when event is published by {@link Sirector#publish(Object)}
	 * synchronously or {@link Sirector#publish(Object, Callback)}
	 * asynchronously.
	 * 
	 * @param event
	 *            event to be handled
	 */
	public void onEvent(Event event);

}
