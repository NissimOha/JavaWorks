import javax.swing.JOptionPane;
/**
 * This Class inherits from the abstract class "GeneralHandler" - it create new Queue object in order to match the overloaded constructors in "GeneralHandler" class. 
 * It then implements "processRequest" that present "Good bye" massage on a GUI message dialog and then Exit from the proggram safty.
 */
public class ExitHandler extends GeneralHandler{
	/**
	 * ExitHandler constructor, initializes a new ExitHandler with a reference to a Queue of Integers - passed via the super constructor.
	 */
	public ExitHandler() {
		super(new Queue<>());
	}
	/**
	 *  This method implements the abstract method "processRequest", inherited from GeneralHandler class. 
	 *  This method present "Good bye" massage on a GUI message dialog and then Exit from the proggram safty.
	 */
	@Override
	public void processRequest() {
		JOptionPane.showMessageDialog(null,"Good Bye!");
		System.exit(1);
	}
}
