import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class MainClass {
	/**
	 * MainClass Method
	 * Creates the top level JFrame Object, creates the Viewer, DrawingModel, and Shape Class Objects.
	 */
	public MainClass(){
		
		// Creating the Top Level JFrame Object
		JFrame frame = new JFrame("Fibonacci^2");
		
		// Setting JFrame Object width and height
		frame.setSize(1440, 1000);
		
		// Terminates process when window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// Adding south panel
		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.darkGray);
		frame.add(southPanel, BorderLayout.SOUTH);
		
		// Adding a button to reset shapes displayed
		JButton buttonReset = new JButton ("Reset Shapes");
		southPanel.add(buttonReset);
		
		// Adding a button to reset shapes displayed
		JRadioButton radioAddLevel = new JRadioButton("Add Level", true);
		radioAddLevel.setActionCommand("RadioAddLevel");
		southPanel.add(radioAddLevel);
		
		JRadioButton radioRemoveLevel = new JRadioButton("Remove Level");
		radioRemoveLevel.setActionCommand("RadioRemoveLevel");
		southPanel.add(radioRemoveLevel);
		
		// Adding radio buttons to a button group
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(radioAddLevel);
		radioGroup.add(radioRemoveLevel);
		//southPanel.add(level);
		
		//Rectangle testRec = new Rectangle(50,350,270,270);
		
		
		// Adding a viewer object to the frame
		Viewer v = new Viewer();
		frame.add(v);
		
		// Adding the Drawing Model
		DrawingModel model = new DrawingModel();
		
		// Adding the Viewer Object to the Model Object
		model.addViewer(v);
		
		// Adding the DrawingModel and Viewer Objects to the Controller Object
		Controller controller = new Controller(model, v);
		//ControllerRemove actionRemove = new ControllerRemove(model, v);
		
		// Adding HShape Objects of varying sizes
		//model.addShape(new HShape(50,50,Color.green,90));
		//model.addShape(new HShape(50,150,Color.green,180));
		model.addShape(new HShape(50,225,Color.green,360));
		
		// Adding FibonacciSquare Objects of varying sizes and arc quadrants
		model.addShape(new FibonacciSquare(1000, 200, Color.orange,1,1));
		//model.addShape(new FibonacciSquare(400, 50, Color.orange,2,30));
		//model.addShape(new FibonacciSquare(400, 250, Color.orange,3,120));
		model.addShape(new FibonacciSquare(1000, 600, Color.orange,4,1));
		
		// ActionListener for the Add Level button
		//buttonAdd.addActionListener(controller);
		//buttonRemove.addActionListener(controller);
		buttonReset.addActionListener(controller);
		frame.addMouseListener(controller);
		radioAddLevel.addActionListener(controller);
		radioRemoveLevel.addActionListener(controller);
		
		// Setting JFrame Object to visible
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainClass();
			};
		});
	}
	
	

}
