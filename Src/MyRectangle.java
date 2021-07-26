// Declaration of class MyRectangle.
import java.awt.Color;
import java.awt.Graphics;

/**
 * this class is a type of shape.
   MyRectangle extends from MyBoundedShape and actualize the abstract method of draw
 * {@link MyBoundedShape}
 */
public class MyRectangle extends MyBoundedShape
{
   // call default superclass constructor
    /**
     * Empty constructor
     */
   public MyRectangle()
   {
   	  //Here - Implicitly invoking parameterless constructor of MyBoundedShape
   	  // (which itself will invoke parameterless constructor of MyShape)
      
      //We provide a parameterless constructor for MyRectangle because the 
      //Java Compiler will NOT provide a default constructor in this case
      //because we provide a constructor with parameters (next)
   } 

   // call superclass constructor passing parameters
     /**
     * constructor that receives all the attributes of the shape and pass them using super to the constructor in MyShape.
     * @param x1 x coordinate of first endpoint
     * @param y1 y coordinate of first endpoint
     * @param x2 x coordinate of second endpoint
     * @param y2 y coordinate of second endpoint
     * @param color Color of this rectangle
     * @param filled if the rectangle is filled
     * {@link MyBoundedShape#MyBoundedShape}
     */
   public MyRectangle(int x1, int y1, int x2, int y2,
      Color color, boolean filled)
   {
      super(x1, y1, x2, y2, color, filled);
   }

   // draw rectangle
   /**
     * this method draws the rectangle.
     * @param g rectangle element to drow
     */
   public void draw(Graphics g)
   {
      g.setColor(getColor());
      
      if (isFilled())
         g.fillRect(getUpperLeftX(), getUpperLeftY(),
            getWidth(), getHeight());
      else
         g.drawRect(getUpperLeftX(), getUpperLeftY(),
            getWidth(), getHeight());
   } 
} // end class MyRectangle
