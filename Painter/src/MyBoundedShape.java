import java.awt.Color;

/**
 *This Class implements the state and behaviour of the MyBoundedShape - Rectangle and Oval.
 */

public abstract class MyBoundedShape extends MyShape{
	
	private boolean filled; // whether this shape is filled
	
	/**
	 * default constractor - initilize the coordinate by zero and color to black
	 */
	public MyBoundedShape() {}
	
	/**
	 * 6 argument constractor - initilize the coordinate by user's points and color
	 * @param x1 - coordinate of first endpoint
	 * @param y1 - coordinate of first endpoint
	 * @param x2 - coordinate of second endpoint
	 * @param y2 - coordinate of second endpoint
	 * @param myColor - color of the line
	 * @param filled - whether this shape is filled
	 */
	public MyBoundedShape(int x1, int y1, int x2, int y2, Color myColor, boolean filled) {
		super(x1,y1,x2,y2,myColor);
		this.filled = filled;		
	}
	
	 	/**
	    *  get upper left x coordinate
	    * @return min(getX1(), getX2())
	    */
	   public int getUpperLeftX()
	   {
	      return Math.min(getX1(), getX2());
	   }	

	   /**
	    *  get upper left y coordinate
	    * @returnmin(getY1(), getY2())
	    */
	   public int getUpperLeftY()
	   {
	      return Math.min(getY1(), getY2());
	   } 

	   /**
	    *  get shape width
	    * @return abs(getX2() - getX1())
	    */
	   public int getWidth()
	   {
	      return Math.abs(getX2() - getX1());
	   }

	   /**
	    * get shape height
	    * @return abs(getY2() - getY1())
	    */
	   public int getHeight()
	   {
	      return Math.abs(getY2() - getY1());
	   } 
	   
	   /**
	    * determines whether this shape is filled
	    * @return true if filled or faulse else
	    */
	   public boolean isFilled()
	   {
	      return filled;
	   } 

	   /**
	    * sets whether this shape is filled
	    * @param filled true if filled or faulse else
	    */
	   public void setFilled(boolean filled)
	   {
	      this.filled = filled;
	   }
}
