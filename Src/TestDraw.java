// Test application to display a DrawPanel
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * this class runs the project 
 */
public class TestDraw
{
   /**
   * Creating a JFrame to display a DrawPanel.
   */
   public static void main(String[] args)
   {
      DrawFrame frame = new DrawFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(500, 500);
      frame.setVisible(true);
   } 
} // end class TestDraw
