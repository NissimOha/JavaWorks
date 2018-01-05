/**
 * his Class implements the state and behaviour of Queue infrastructure. 
 * It inherits from DDLinkedList class. Likewise, it is now implemented as a Generic Class. 
 * Notice that this class inherits the "toString" method of DDLinkedList, which is exactly what Queue needs - no need to override it here!
 * @author nissimOhayon
 *
 */
public class Queue<T> extends DDLinkedList<T> {

	/**
	 * enqueue an element to the Back of the Queue.
	 * @param val the generic-type value to be added to the Back of the Queue.
	 */
	public void enqueue(T val) {
		addToTail(val);
	}
	
	/**
	 * dequeue an element from the Front of the Queue.
	 * @return the generic-type value of the element dequeued from the Front of the Queue. If the Queue is empty, returns null.
	 */
	public T dequeue() {
		T top = removeFromHead();
		return top;
	}
}

