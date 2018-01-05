/**
 * Since an interface cannot hold "data members", we create an abstract class to hold the reference of either the Queue or the Stack, 
 * in order to be able to perform the given menu operation on it. 
 * This reference is provided into the constructor: the idea is to use constructor overloading, so that an object of such (inherited) class, 
 * will be able to hold a reference to either a Stack or a Queue - but not both! Either of these constructors MUST be used, 
 * in order to create an object - this guarantees that EXATLY ONE reference (Queue/Stack) is there to work with! Which one? 
 * The one that is NOT null (one will be initialized by the constructor), whereas the other one will be initialized to null by default 
 * (default initialization for instanse/class variables of "reference type"). In this way, we can have generic operation,
 *  like adding an item, but the implementation will need to check which element is being served (Stack or a Queue), 
 *  while the other one will be null! The reason for creating this class, and letting all the other handler classes inherit from it 
 *  (rather than having each of the handlers implement the "IntQueueStackHandler" interface) is prevention of repetitions/redundancy: 
 *  If we didn't have this class, then each one of the handlers would need to implement the "IntQueueStackHandler" interface and define two references 
 *  (Queue and Stack references) on its own! In this abstract class way, we define these two references once, 
 *  then get all the other handlers simply inherit from it - thus, no duplications in the definition of the handlers! 
 *  All the handlers inheriting from it need to do is simply to initialize these two references, by invoking the "super" constructor, 
 *  and, in addition, to implement the abstract method processRequest with their own specific implementation!
 */
public abstract class GeneralHandler implements IntQueueStackHandler {
	protected Queue<Integer> intQ;
	protected Stack<Integer> intSt;
	/**
	 * GeneralHandler constructor, initializes a new GeneralHandler with a reference to a Queue of Integers (the Stack reference will be initialized to null by default).
	 * @param intQ reference to the Queue of Integers
	 */
	public GeneralHandler(Queue<Integer> intQ) {
		this.intQ = intQ;
	}
	/**
	 * GeneralHandler overloaded constructor, initializes a new GeneralHandler with a reference to a Stack of Integers (the Queue reference will be initialized to null by default).
	 * @param intSt reference to the Stack of Integers
	 */
	public GeneralHandler(Stack<Integer> intSt) {
		this.intSt = intSt;
	}
}
