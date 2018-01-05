import javax.swing.JOptionPane;

/**
 * This Class inherits from the abstract class "GeneralHandler" - it defines two overloaded constructors, 
 * in order to match the overloaded constructors in "GeneralHandler" class. Each of these constructors simply invokes the appropriate 
 * "super" (super class constructor) constructor and pass it the corresponding reference to Integer Queue/Stack respectively. 
 * It then implements "processRequest" to acquire input from the user via showInputDialog method of JOptionPane Java swing class (input dialog GUI). 
 * validate the input and if valid puts it in the Queue/Stack respectively.
 */
public class EnqueuePushHandler extends GeneralHandler{
	
	private String action;
	private String className;
	/**
	 * EnqueuePushHandler constructor, initializes a new EnqueuePushHandler with a reference to a Queue of Integers 
	 * (the Stack reference will be initialized to null by default) - passed via the super constructor.
	 * @param intQ reference to the Queue of Integers
	 */
	public EnqueuePushHandler(Queue<Integer> intQ) {
		super(intQ);
		action = "Enqueue";
		className = "Queue";
	}
	/**
	 * EnqueuePushHandler overloaded constructor, initializes a new EnqueuePushHandler with a reference to a Stack of Integers 
	 * (the Queue reference will be initialized to null by default) - passed via the super constructor.
	 * @param intSt reference to the Stack of Integers
	 */
	public EnqueuePushHandler(Stack<Integer> intSt) {
		super(intSt);
		action = "Push";
		className = "Stack";
	}
	/**
	 * This method implements the abstact method "processRequest", inherited from GeneralHandler class. 
	 * This method acquires input from the user via showInputDialog method of JOptionPane Java swing class (input dialog GUI). 
	 * validate the input and if valid puts it in the Queue/Stack respectively. ALL user messages are performed via showMessageDialog method of JOptionPane 
	 * Java swing class (message dialog GUI), and ALL inputs are performed via showInputDialog method of JOptionPane Java swing class (input dialog GUI).
	 */
	public void processRequest() {
		String input = JOptionPane.showInputDialog(String.format("Please Enter a number to %s the %s", action, className));
		try {
		Integer val = Integer.parseInt(input);
		if (intQ != null) {
			intQ.enqueue(val);
			JOptionPane.showMessageDialog(null,String.format("Enqueue operation of %d succesfully complete!",val));
		}
		else {
			intSt.push(val);
			JOptionPane.showMessageDialog(null,String.format("Push operation of %d succesfully completed!",val));
		}
		} catch (NumberFormatException e) {
			if (input!=null)
				JOptionPane.showMessageDialog(null,String.format("%s is Not numeric, operation aborted!",input));
		}
	}
}