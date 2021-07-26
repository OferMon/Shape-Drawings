// Declaration of class MyOval.
import java.awt.Color;
import java.awt.Graphics;

/**
 * this class is a type of shape.
   MyOval extends from MyShape and actualize the abstract method of draw
 * {@link MyBoundedShape}
 */
public class MyOval extends MyBoundedShape
{
   // call default superclass constructor
    /**
     * Empty constructor
     */
   public MyOval()
   {
   	  //Here - Implicitly invoking parameterless constructor of MyBoundedShape
   	  // (which itself will invoke parameterless constructor of MyShape)
      
      //We provide a parameterless constructor for MyOval because the 
      //Java Compiler will NOT provide a default constructor in this case
      //because we provide a constructor with parameters (next)
   } 

   // call superclass constructor passing parameters
    /**
     * constructor the received all the attributes of the shape and pass them using super to the constructor in MyBoundedShape.
     * @param x1 x coordinate of first endpoint
     * @param y1 y coordinate of first endpoint
     * @param x2 x coordinate of second endpoint
     * @param y2 y coordinate of second endpoint
     * @param color Color of the oval
     * @param filled if the oval is filled
     * {@link MyBoundedShape#MyBoundedShape}
     */
   public MyOval(int x1, int y1, int x2, int y2,
      Color color, boolean filled)
   {
      super(x1, y1, x2, y2, color, filled);
   } 

   // draw oval
   /**
     * this method draws the oval.
     * @param g oval element to drow
     */
   public void draw(Graphics g)
   {
      g.setColor(getColor());
      
      if (isFilled())
         g.fillOval(getUpperLeftX(), getUpperLeftY(),
            getWidth(), getHeight());
      else
         g.drawOval(getUpperLeftX(), getUpperLeftY(),
            getWidth(), getHeight());
   } 
} // end class MyOval
