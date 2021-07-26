import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * this class extends JPanel and 
   lets the user create random shapes and
   counts the amount of shapes of each type.
 * {@link JPanel} 
*/
public class DrawPanel extends JPanel
{
   private MyShape[] shapes;
   private MyShape currentShape; 
   private final int MAXSHAPES = 100;
   private JLabel coordinatesLabel;
   private DrawFrame parentWindow;
   private boolean filled;
   private int shapesType;
   private Color color;
   private int shapeCount;                             
   
    /**
     * this method sets the background color to white
       and creates an array in a size of MAXSHAPES(100) of type MyShape
       it also sets the coordinates (x,y) displayed on the screen and shows the mouse place
       creates a mouse handler and sets a mouse listener and a motion listener. 
     * @param coordinatesLabel the place of the mouse on the screen (x,y).
     * @param parentWindow the actual window we are working on to create the shapes.
     * {@link JPanel#setBackground}
     * {@link JPanel#addMouseListener}
     * {@link JPanel#addMouseMotionListener}
     */
   public DrawPanel(JLabel coordinatesLabel,DrawFrame parentWindow)
   {
      setBackground(Color.WHITE);
      this.shapes = new MyShape[MAXSHAPES];
      this.coordinatesLabel = coordinatesLabel;
      this.parentWindow = parentWindow;
      MouseHandler handler = new MouseHandler();
      this.addMouseListener(handler);
      this.addMouseMotionListener(handler);
   } 

  /**
  * this method sets the oval/rectangle to filled or not filled.
  * @param filled if true the shape is filled if false the shape is not filled.
  */
   public void SetFilled(boolean filled)
   {
   	   this.filled = filled;
   }
   
  /**
  * when the button Undo is clicked the last drawn shape
    will be cleared from the drawing panel, but all the other shapes
    will remain exactly as they were! 
  * {@link JPanel#repaint}
  */   
   public void Undo()
   {
   	   if (shapeCount > 0)
   	   {
   	   	   shapeCount--;
   	   	   repaint();
   	   }
   }
   
  /**
  * when the button Clear is clicked the drawing panel
    will be cleared of ALL the shapes!
  * {@link JPanel#repaint}     
  */
   public void Clear()
   {
   	   shapeCount = 0;
   	   repaint();
   }
   
  /**
  * this method sets the color of the shape
  * @param color contains the color of the shape   
  */
   public void SetColor(Color color)
   {
   	   this.color = color;
   }
   
  /**
  * this method sets the type of the shape (line,rectangle or oval)
  * @param shapesType contains the type of the shape   
  */
   public void SetShapesType(int shapesType)
   {
   	this.shapesType = shapesType;
   }
   
   /**
   * this method prints the shapes.
   */
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      
      for (int i=0; i<shapeCount; i++)
      shapes[i].draw(g);
  	
  	  if (currentShape != null)
  	  {
  	  	  currentShape.draw(g);
  	  }
   } 
   
      /**
     * this method creates the shapes. recieves the shape type, color and wether the shape is filled.
     * @param shapeType the type of the shape to make.
     * @param color the color of the shape
     * @param filled wether the shape is filled or not
     * @param coordinates the coordinates of the shape using array or integers x1,y1,x2,y2
     * @return new MyShape
     */
   private MyShape createShape(int shapeType, Color color, boolean filled,int... coordinates)
   {
   	   int x1, y1, x2, y2;
   	   
   	   if(coordinates.length != 4)
   	   {
   	   	   return null;
   	   }
   	   
   	   x1 = coordinates[0]; 
   	   y1 = coordinates[1]; 
   	   x2 = coordinates[2];
   	   y2 = coordinates[3];
   	   
   	   switch (shapeType)
       {
       case 0: // line
       	   return new MyLine(x1, y1, x2, y2, color);
       
       case 1: // oval
       	   return new MyOval(x1, y1, x2, y2, color, filled);
            
       case 2: // rectangle
       	   return new MyRectangle(x1, y1, x2, y2, color, filled);
       } 
       
       return null;
   }
   
   /**
   * this class MouseHandler is responsible for the the mouse events 
     it extends MouseAdapter and implements MouseMotionListener
   */
   private class MouseHandler extends MouseAdapter implements MouseMotionListener
 {

    /**
   * this method manages the event in which the mouse is pressed
   * @param event the mouse event that happend(in this case a press) 
   * {@link #createShape}
   */
	@Override
	public void mousePressed(MouseEvent event)
	{
		if (event.getButton() == MouseEvent.BUTTON1)
		{
			if (shapeCount != MAXSHAPES)
				currentShape = createShape(shapesType,color,filled,event.getX(),event.getY(),event.getX(),event.getY());
			else
				JOptionPane.showMessageDialog(parentWindow,"Cannot exceed the current number of shapes: " + MAXSHAPES, "Capacity Overload" , JOptionPane.WARNING_MESSAGE);
		}
	}
	
   /**
   * this method manages the event in which the mouse is released
   * @param event the mouse event that happend(in this case a release) 
   * {@link #createShape}
   */
	@Override
	public void mouseReleased(MouseEvent event)
	{
		if (currentShape != null)
		{
			if (!((currentShape.getX1() == currentShape.getX2()) && (currentShape.getY1() == currentShape.getY2())))
			{
				shapes[shapeCount] = currentShape;
				shapeCount++;
			}
			currentShape = null;
		}
	}
	
   /**
   * this method manages the event in which the mouse is dragged
   * @param event the mouse event that happend(in this case a drag) 
   */
	@Override
	public void mouseDragged(MouseEvent event)
	{
		if (currentShape != null)
		{
			currentShape.setX2(event.getX());
			currentShape.setY2(event.getY());
		}
		repaint();
		mouseMoved(event);
	}
	
   /**
   * this method manages the event in which the mouse had moved
   * @param event the mouse event that happend(in this case a move) 
   */
	@Override
	public void mouseMoved(MouseEvent event)
	{
		coordinatesLabel.setText("(" + event.getX() + "," + event.getY() + ")");
	}
 }
} // end class DrawPanel

