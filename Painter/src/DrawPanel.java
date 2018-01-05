import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *DrawPanel class constitutes the smart panel of the application (hence it extends JPanel API class). 
 *This class is responsible to draw all the shapes by using MyShape class {@link MyShape} and control of all
 *the mouse events.
 */

public class DrawPanel extends JPanel {
	private MyShape[] shapes;
	private int ShapeCounter; 
	private MyShape currentShape;
	private Color currentColor;
	
	private int currentShapeType;
	private boolean currentIsFilled;
	private JLabel statusLabel;
	private JFrame frame;
	
	/**
	 * DrawPanel Constructor - initializes the frame and statusLabel that came from the DrawFrame class {@link DrawFrame},
	 * so it can be updated by the mouse coordinates.
	 * @param frame - the main frame of the DrawFrame.
	 * @param statusLabel - the Jlabel that shows the mouse coordinates in the south of the frame.
	 */
	public DrawPanel(JFrame frame,JLabel statusLabel) {
		setBackground(Color.WHITE);
		this.statusLabel = statusLabel;
		this.frame = frame;
		addMouseMotionListener(new MouseHandler());
		addMouseListener(new MouseHandler());
		shapes = new MyShape[100];
	}
	/**
	 * DrawPanel set method creat and initilaize the current shape that the user choose to draw.
	 * At first it updated by the coordinates of mousePressed.
	 * @param x1 - coordinate of first endpoint
	 * @param y1 - coordinate of first endpoint
	 * @param x2 - coordinate of second endpoint
	 * @param y2 - coordinate of second endpoint
	 */
	public void setCurrentShape(int x1, int y1, int x2, int y2) {
		switch(currentShapeType) {
        case 0 : currentShape = new MyLine(x1, y1, x2, y2, currentColor);
        	break;
        case 1 : currentShape = new MyOval(x1, y1, x2, y2, currentColor, currentIsFilled);
        	break;
        case 2 : currentShape = new MyRectangle(x1, y1, x2, y2, currentColor, currentIsFilled);
        	break;
		}
	}
	
	/**
	 * DrawPanel paintComponent method prints all the shape polymorphicly by using the paintComponent
	 * method of MyShape class {@link MyShape}.
	 */
	public void paintComponent(Graphics g)
	   {
		super.paintComponent(g);
	    for(int i=0 ; i < ShapeCounter ; i++) {
	    	shapes[i].draw(g);
	    }
	    if(currentShape!=null)
	    	currentShape.draw(g);
	   } 
	
	/**
	 * Set the type of the current shape, it updated from the JComboBox.
	 * @param currentShapeType - get integer value that means: 0->line , 1->oval , 2->rectangle.
	 */
	public void setCurrentShapeType(int currentShapeType) {
		this.currentShapeType = currentShapeType;
	}

	/**
	 * Set the color of the current shape, it updated from the JComboBox.
	 * @param currentColor - get a color object {@link java.awt.Color}
	 */
	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}

	/**
	 * Set if the current shape had to be filled or not, it updated from the JCheckBox.
	 * @param currentIsFilled - get boolean value.
	 */
	public void setCurrentIsFilled(boolean currentIsFilled) {
		this.currentIsFilled = currentIsFilled;
	}
	
	/**
	 * public method that activated from DrawFrame class when the user click on Undo JButton,
	 * this method delete the last shape that draw (actually it initilaize shape Array to index minus 1
	 * and draws all the shapes again until this index).
	 */
	public void Undo() {
		if(ShapeCounter>0) {
			ShapeCounter--;
			repaint();
		}
	}
	
	/**
	 * public method that activated from DrawFrame class when the user click on Clear JButton,
	 * this method delete all the shape that draw (actually it initilaize shape Array to index 0
	 * and draws all the shapes again until this index).
	 */
	public void Clear() {
		ShapeCounter=0;
		repaint();
	}
	
	/**
	 * This is a private inner class for DrawPanel class that implements the
	 * Mouse Adapter for ALL the mouse events,Notice that it extends the class MouseAdapter.
	 * {@link java.awt.event.MouseAdapter}. 
	 */
	private class MouseHandler extends MouseAdapter{
		/**
		 * mouseMoved responsible to update the statusLabel in the mouse coordinates.
		 */
		@Override
		public void mouseMoved(MouseEvent e){
			statusLabel.setText(String.format("(%d,%d)", e.getX(),e.getY()));
		}
		/**
		 * mouseDragged responsible to update the coordinates of the current shape by the sets methods of the
		 * MyShape class so the user could see it updated by the time he drag the mouse.
		 */
		@Override
		public void mouseDragged(MouseEvent e){
			mouseMoved(e);
			if(currentShape!=null) {
				currentShape.setX2(e.getX());
				currentShape.setY2(e.getY());
				repaint();
			}
		}
		/**
		 * mouseReleased responsible to draw the final shape after the user release the mouse button and update
		 * the shape Array, Notice that if the x1 and y1 coordinates equal to x2 and y2, the shape is not a
		 * real shape so it doesn't draw.
		 */
		@Override
		public void mouseReleased(MouseEvent e) {
			if(currentShape!=null) {
				if((currentShape.getX1()!=currentShape.getX2()) || (currentShape.getY1()!=currentShape.getY2())){
					shapes[ShapeCounter] = currentShape;
					ShapeCounter++;
					repaint();
				}
			}
			currentShape=null;
		}
		/**
		 * mousePressed responsible to call the setCurrentShape method and create the shape object,
		 * it started only if the user push on the left-mouse-click and if there is less than 100 shapes
		 * that draw so far.
		 */
		@Override
		 public void mousePressed(MouseEvent e) {
			if(e.getButton()==MouseEvent.BUTTON1) {
				if (ShapeCounter==shapes.length)
					JOptionPane.showMessageDialog(frame,String.format("Cannot exceed the current number of shapes: %d",ShapeCounter),"Capacity Overload", JOptionPane.WARNING_MESSAGE);
				setCurrentShape(e.getX(),e.getY(),e.getX(),e.getY());
			}
		}
	}
}
