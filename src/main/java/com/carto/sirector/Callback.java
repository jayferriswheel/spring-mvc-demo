package com.carto.sirector;

/**
 * Callback interface to be implemented to be noticed of the transaction
 * complete and error.
 * 
 * @author chenfeng
 * 
 * @param <Event>
 *            event type
 */
public interface Callback<Event> {

	/**
	 * Called when the whole event transaction is completed successfully.
	 * 
	 * @param event
	 *            event which has been handled by all event handlers of the
	 *            transaction.
	 */
	public void onSuccess(Event event);

	/**
	 * Called when error occurred in the current transaction corresponding to
	 * the event.
	 * 
	 * @param event
	 *            the event the event handler is handling when exception is
	 *            throwed
	 * @param throwable
	 *            exception throwed by one of event handler of current
	 *            transaction.
	 */
	public void onError(Event event, Throwable throwable);

}
