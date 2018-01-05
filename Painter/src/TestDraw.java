import javax.swing.JFrame;
/**
 * This Class implements main method that creates the paint's main window.
 * @author Nissim Ohayon
 */
public class TestDraw {
	/**
	    * main Method that creates the paint's main window. Notice that it 
	    * defines the window to be LocationRelativeTo center of the screen.
	    * See method: {@link  java.awt.Frame#setLocationRelativeTo}.
	    */
	public static void main(String[] args) {
		DrawFrame frame = new DrawFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
