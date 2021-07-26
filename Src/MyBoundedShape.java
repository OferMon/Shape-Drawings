// Declaration of class MyBoundedShape.
import java.awt.Color;
import java.awt.Graphics;

/**
 * MyBoundedShape is an abstact class represents all the bounded shapes.
 * {@link MyShape}
 */
public abstract class MyBoundedShape extends MyShape
{
   private boolean filled; // whether this shape is filled
   
   // call default superclass constructor
   /**
   *empty constuctor that sets filled to false
   */
   public MyBoundedShape()
   {
   	  //Here - Implicitly invoking parameterless constructor of MyShape
      
      //We provide a parameterless constructor for MyBoundedShape because the 
      //Java Compiler will NOT provide a default constructor in this case
      //because we provide a constructor with parameters (next)
      filled = false;
   } 

   // call superclass constructor passing parameters
    /**
     * constructor the received all the attributes of the shape and pass them using super to the constructor in MyShape.
     * @param x1 x coordinate of first endpoint
     * @param y1 y coordinate of first endpoint
     * @param x2 x coordinate of second endpoint
     * @param y2 y coordinate of second endpoint
     * @param color Color of the shape
     * @param filled if the shape is filled or not
     * {@link MyShape#MyShape}
     */
   public MyBoundedShape(int x1, int y1, int x2, int y2,
      Color color, boolean filled)
   {
      super(x1, y1, x2, y2, color);
      this.filled = filled;
   } 

   // get upper left x coordinate
    /**
    * get upper left x coordinate
    * @return upper left x coordinate
    * {@link MyShape#getX1}
    * {@link MyShape#getX2}
    */
   public int getUpperLeftX()
   {
      return Math.min(getX1(), getX2());
   } 

   // get upper left y coordinate
    /**
    * get upper left y coordinate
    * @return upper left y coordinate
    * {@link MyShape#getY1}
    * {@link MyShape#getY2}
    */
   public int getUpperLeftY()
   {
      return Math.min(getY1(), getY2());
   } 

   // get shape width
    /**
    * get shape width
    * @return shape width
    * {@link MyShape#getX1}
    * {@link MyShape#getX2}
    */
   public int getWidth()
   {
      return Math.abs(getX2() - getX1());
   }

   // get shape height
   /**
    * get shape height
    * @return shape height
    * {@link MyShape#getY1}
    * {@link MyShape#getY2}
    */
   public int getHeight()
   {
      return Math.abs(getY2() - getY1());
   } 

   // determines whether this shape is filled
    /**
     * Gets the state of filled.
     * @return the state of filled. 
     */

   public boolean isFilled()
   {
      return filled;
   } 

   // sets whether this shape is filled
    /**
     * set the boolean filled.
     * @param filled sets if the shape is filled or not.
     */
   public void setFilled(boolean filled)
   {
      this.filled = filled;
   } 
} // end class MyBoundedShape
