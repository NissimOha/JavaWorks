import java.awt.Color;
import java.awt.Graphics;

/**
 * This MyOval represents a filled/unfilled oval segment in two points and color
 */

public class MyOval extends MyBoundedShape {

	/**
	 * default constractor - initilize the coordinate by zero and color to black
	 */
	public MyOval() {}
	
	/**
	 * 6 argument constractor - initilize the coordinate by user's points and color
	 * @param x1 - coordinate of first endpoint
	 * @param y1 - coordinate of first endpoint
	 * @param x2 - coordinate of second endpoint
	 * @param y2 - coordinate of second endpoint
	 * @param myColor color of this rectangle
	 * @param filled whether this shape is filled
	 */
	
	public MyOval(int x1, int y1, int x2, int y2, Color myColor, boolean filled) {
		super(x1,y1,x2,y2,myColor, filled);	
	}

	/**
	    * draws a oval in the specified color
	    */
	@Override
	public void draw(Graphics g) {
		g.setColor(getMyColor());
	      
	      if (isFilled())
	         g.fillOval(getUpperLeftX(), getUpperLeftY(),
	            getWidth(), getHeight());
	      else
	         g.drawOval(getUpperLeftX(), getUpperLeftY(),
	            getWidth(), getHeight());		
	}
}
