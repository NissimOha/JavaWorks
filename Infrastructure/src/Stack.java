/**
 * This Class implements the state and behaviour of Stack infrastructure. 
 * It inherits from DDLinkedList class. Likewise, it is now implemented as a Generic Class. 
 * Notice that this class inherits the "toString" method of DDLinkedList, which is exactly what Stack needs - no need to override it here!
 * @author nissimOhayon
 */
public class Stack<T> extends DDLinkedList<T> {

	/**
	 * push an element to the top of the Stack.
	 * @param val the generic-type value to be added to the top of the Stack.
	 */
	public void push(T val) {
		addToHead(val);
	}
	
	/**
	 * pop an element from the top of the Stack.
	 * @return the generic-type value of the element popped from the top of the Stack. If the Stack is empty, returns null.
	 */
	public T pop() {
		T top = removeFromHead();
		return top;
	}
}
