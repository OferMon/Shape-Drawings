// Declaration of class MyLine.
import java.awt.Color;
import java.awt.Graphics;

/**
 * this class is a type of shape.
   MyLine extends from MyShape and actualize the abstract method of draw
 * {@link MyShape}
 */
public class MyLine extends MyShape
{
   // call default superclass constructor
   /**
    * Empty constructor
    */
   public MyLine()
   {
      //Here - Implicitly invoking parameterless constructor of MyShape
      
      //We provide a parameterless constructor for MyLine because the 
      //Java Compiler will NOT provide a default constructor in this case
      //because we provide a constructor with parameters (next)
   } 

   // call superclass constructor passing parameters
    /**
    * constructor the received all the attributes of the shape and pass them using super to the constructor in MyShape.
    * @param x1 x coordinate of first endpoint
    * @param y1 y coordinate of first endpoint
    * @param x2 x coordinate of second endpoint
    * @param y2 y coordinate of second endpoint
    * @param color Color of the line
    * {@link MyShape#MyShape}
    */
   public MyLine(int x1, int y1, int x2, int y2, Color color)
   {
      super(x1, y1, x2, y2, color);
   } 

   // draw line in specified color
   /**
    * the method draws the line.
    * @param g line element to draw
    */
   public void draw(Graphics g)
   {
      g.setColor(getColor());
      g.drawLine(getX1(), getY1(), getX2(), getY2());
   } 
} // end class MyLine
