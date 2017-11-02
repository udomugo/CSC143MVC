import java.awt.Color;

import javax.swing.JFrame;
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
		frame.setSize(1000, 800);
		
		// Terminates process when window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Adding a viewer object to the frame
		Viewer v = new Viewer();
		frame.add(v);
		
		// Adding the Drawing Model
		DrawingModel model = new DrawingModel();
		
		// Adding the Viewer Object to the Model Object
		model.addViewer(v);
		
		// Adding HShape Objects of varying sizes
		model.addShape(new HShape(50,50,Color.green,90));
		model.addShape(new HShape(50,150,Color.green,180));
		model.addShape(new HShape(50,350,Color.green,270));
		
		// Adding FibonacciSquare Objects of varying sizes and arc quadrants
		model.addShape(new FibonacciSquare(600, 50, Color.orange,1,60));
		model.addShape(new FibonacciSquare(400, 50, Color.orange,2,30));
		model.addShape(new FibonacciSquare(400, 250, Color.orange,3,120));
		model.addShape(new FibonacciSquare(600, 250, Color.orange,4,240));
		
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
