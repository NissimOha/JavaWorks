import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * This Class implements the state and behaviour of the Manager. It uses a "Polymorphic" array, that holds references to 6 class objects that implement the 
 * "IntQueueStackHandler" interface. Each implements the "processRequest" abstract method, in a way that will serve the menu item needed. 
 * This substantially simplifies the menu handler.
 * @author nissimOhayon
 */

public class Manager {
	
	private Queue<Integer> q;
 	private Stack<Integer> st;
 	private IntQueueStackHandler[] handlers;
 	private String[] menu;
/**
 * Manager no-argument constructor, initializes a new Stack object and a new Queue object (of Integer type).
 */
	public Manager() {
		JOptionPane.showMessageDialog(null,"Hello, Wellcome to the Infrastructure-Manager");
		int ch=0; 
		initMenu();
		initQueueStack();
		initHandlers();
		Scanner input = new Scanner(System.in);
		do {
		displayMenu();
		try{
			ch = input.nextInt() - 1; // handlers started at 0
			handlers[ch].processRequest();
		}catch(IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null,String.format("%d is an invalid choice! Please try again.", ch+1));
		}catch(InputMismatchException e) {
			input.nextLine();
			JOptionPane.showMessageDialog(null,String.format("Input not numeric, invalid choice! Please try again."));
		}
		}while(ch!=7);
		
		input.close();
	}
	
	private void initMenu(){
		menu = new String[10];
		menu[0] = "\n\n-----------------------------Main-Menu-----------------------------\n\n";
		menu[1] = "[1] - Enqueue.";
		menu[2] = "[2] - Dequeue.";
		menu[3] = "[3] - Display Queue.";
		menu[4] = "[4] - Push.";
		menu[5] = "[5] - Pop.";
		menu[6] = "[6] - Display Stack.";
		menu[7] = "[7] - Exit.";
		menu[8] = "What would you like to do?";
		menu[9] = "\n\n-------------------------------------------------------------------\n\n";
	}
	
	private void initQueueStack() {
		q= new Queue<Integer>();
		st= new Stack<Integer>();		
	}
	
	private void initHandlers() {
		handlers = new IntQueueStackHandler[7];
		handlers[0] = new EnqueuePushHandler(q);
		handlers[1] = new DequeuePopHandler(q);
		handlers[2] = new DisplayHandler(q);
		handlers[3] = new EnqueuePushHandler(st);
		handlers[4] = new DequeuePopHandler(st);
		handlers[5] = new DisplayHandler(st);
		handlers[6] = new ExitHandler();
	}
	
	private void displayMenu() {
		for(String sentence : menu) {
			System.out.println(sentence);
		}
	}
	

	/**
	 * static main method simply defines and initializes a new manager object. This would invoke its constructor, 
	 * which then invokes the displayMenu to handle the user choices.
	 */
	public static void main(String[] args) {
		Manager mngr = new Manager();
	}

}
