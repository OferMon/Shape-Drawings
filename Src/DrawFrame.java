import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.BorderLayout;
import java.awt.Color;            
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPanel;


/**
* this class creates the window interface in which the user will there pick the drawing he will want to make
* {@link JFrame}
*/
public class DrawFrame extends JFrame implements ItemListener,ActionListener
{
	private JButton undoButton,clearButton;
	private JComboBox<String> colorComboBox,shapeComboBox;
	private JCheckBox filledCheckBox;
	private JLabel coordinatesLabel;
	private JPanel buttonsPanel;
	private DrawPanel panel;
	private static final String[] colorsNames = {"Black","Blue","Cyan","Dark Gray","Gray","Green","Light Gray","Magenta","Orange","Pink","Red","White","Yellow"};
	private static final Color[] colors = {Color.BLACK,Color.BLUE,Color.CYAN,Color.DARK_GRAY,Color.GRAY,Color.GREEN,Color.LIGHT_GRAY,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED,Color.WHITE,Color.YELLOW};
	private static final String[] shapeNames = {"Line","Oval","Rectangle"};
	

    /**
    * this method creates the window (adds bottons and names)
    */
	public DrawFrame()
   {
    super("Shape Drawings");
    buttonsPanel = new JPanel();
    
   	undoButton = new JButton("Undo");
   	undoButton.addActionListener(this);
   	buttonsPanel.add(undoButton);
   	
    clearButton = new JButton("Clear");
   	clearButton.addActionListener(this);
   	buttonsPanel.add(clearButton);
   	
   	colorComboBox = new JComboBox<String>(colorsNames);
   	colorComboBox.setMaximumRowCount(8);
   	colorComboBox.addItemListener(this);
   	buttonsPanel.add(colorComboBox);
   	
   	shapeComboBox = new JComboBox<String>(shapeNames);
   	shapeComboBox.addItemListener(this);
   	buttonsPanel.add(shapeComboBox);
   	
   	filledCheckBox = new JCheckBox("Filled");
   	filledCheckBox.addItemListener(this);
   	buttonsPanel.add(filledCheckBox);
   	add(buttonsPanel,BorderLayout.NORTH);
  
   	coordinatesLabel = new JLabel("");
   	add(coordinatesLabel,BorderLayout.SOUTH);
   	
   	panel = new DrawPanel(coordinatesLabel,this);
   	add(panel,BorderLayout.CENTER);
   } 
   
   /**
   * this method will activate an event (undo and clear)
   * @param event containes what event just happend
   */
   @Override
    public void actionPerformed(ActionEvent event)
   {
   	  if (event.getSource() == undoButton)
   	  {
   	  	  panel.Undo();
   	  }
   	  if (event.getSource() == clearButton)
   	  {
   	  	  panel.Clear();
   	  }
   }
   
   /**
   * this method will activate an event (color, shape type or filled box)
   * @param event containes what event just happend
   */
   @Override
   public void itemStateChanged(ItemEvent event)
   {
   	  if (event.getSource() == colorComboBox)
   	  {
   	  	  panel.SetColor(colors[colorComboBox.getSelectedIndex()]);
   	  }
   	  if (event.getSource() == shapeComboBox)
   	  {
   	  	  panel.SetShapesType(shapeComboBox.getSelectedIndex());
   	  }
   	  if (event.getSource() == filledCheckBox)
   	  {
   	  	  panel.SetFilled(filledCheckBox.isSelected());
   	  }
   }
}