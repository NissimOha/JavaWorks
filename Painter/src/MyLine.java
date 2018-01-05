import java.awt.Color;
import java.awt.Graphics;

/**
 * This MyLine represents a line segment in two points and color
 */
public class MyLine extends MyShape{

	/**
	 * default constractor - initilize the coordinate by zero and color to black
	 */
	public MyLine() {}
	
	/**
	 * 5 argument constractor - initilize the coordinate by user's points and color
	 * @param x1 - coordinate of first endpoint
	 * @param y1 - coordinate of first endpoint
	 * @param x2 - coordinate of second endpoint
	 * @param y2 - coordinate of second endpoint
	 * @param myColor - color of the line
	 */
	public MyLine(int x1, int y1, int x2, int y2, Color myColor) {
		super(x1,y1,x2,y2,myColor);	
	}
	
	/**
	 * draw the line in the specified color
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(getMyColor());
	    g.drawLine(getX1(), getY1(), getX2(), getY2());
	}

}
