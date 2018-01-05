import java.awt.Color;
import java.awt.Graphics;

/**
 *  This Class implements the state and behaviour of the Shape.
 */
public abstract class MyShape {
	
	private int x1; // x coordinate of first endpoint
	private int y1; // y coordinate of first endpoint
	private int x2; // x coordinate of second endpoint
	private int y2; // y coordinate of second endpoint
	private Color myColor; // Color of this rectangle
	
	/**
	 * default constractor - initilize the coordinate by zero and color to black
	 */
	public MyShape() {
		myColor=Color.BLACK;
	}
	
	/**
	  * 5 argument constractor - initilize the coordinate by user's points and color
	 * @param x1 - coordinate of first endpoint
	 * @param y1 - coordinate of first endpoint
	 * @param x2 - coordinate of second endpoint
	 * @param y2 - coordinate of second endpoint
	 * @param myColor - color of the line
	 */
	public MyShape(int x1, int y1, int x2, int y2, Color myColor) {
		this.x1 = (x1 >= 0 ? x1 : 0);
	    this.y1 = (y1 >= 0 ? y1 : 0);
	    this.x2 = (x2 >= 0 ? x2 : 0);
	    this.y2 = (y2 >= 0 ? y2 : 0);
	    this.myColor = myColor; 
	}
	
	public abstract void draw(Graphics g);

	   /**
	    * set the x-coordinate of the first point
	    * @param x1 coordinate of the first point
	    */
	   public void setX1(int x1)
	   {
	      this.x1 = (x1 >= 0 ? x1 : 0);
	   } 

	   /**
	    * get the x-coordinate of the first point
	    * @return x1
	    */
	   public int getX1()
	   {
	      return x1;
	   } 

	   /**
	    * set the x-coordinate of the second point
	    * @param x2 coordinate of the second point
	    */
	   public void setX2(int x2)
	   {
	      this.x2 = (x2 >= 0 ? x2 : 0);
	   } 

	   /**
	    * get the x-coordinate of the second point
	    * @return x2
	    */
	   public int getX2()
	   {
	      return x2;
	   } 

	   /**
	    * set the y-coordinate of the first point
	    * @param y1 coordinate of the first point
	    */
	   public void setY1(int y1)
	   {
	      this.y1 = (y1 >= 0 ? y1 : 0);
	   } 

	   /**
	    * get the y-coordinate of the first point
	    * @return y1
	    */
	   public int getY1()
	   {
	      return y1;
	   }

	   /**
	    * set the y-coordinate of the second point
	    * @param y2 coordinate of the second point
	    */
	   public void setY2(int y2)
	   {
	      this.y2 = (y2 >= 0 ? y2 : 0);
	   } 

	   /**
	    * get the y-coordinate of the first point
	    * @return y2
	    */
	   public int getY2()
	   {
	      return y2;
	   }
	   
	   /**
	    * get the color of the shape
	    * @return myColor
	    */
		public Color getMyColor() {
			return myColor;
		}
		
		/**
		 * set the color of the shape
		 * @param myColor the color of the shape
		 */
		public void setMyColor(Color myColor) {
			this.myColor = myColor;
		}
}
