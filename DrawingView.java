import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class DrawingView extends JPanel implements View{
	
	private DrawingModel model;
	//private int width;
	//private int height;
	//private ArrayList<Rectangle> clickArea;
	
	/**
	 * Viewer Constructor
	 * Creates the Viewer Object and sets the background color.
	 */
	public DrawingView() {
		// Setting the background color
		setBackground(Color.darkGray);
	}
	
	/**
	 * update Method
	 * Method takes a DrawingModel Object and sets it to the new model.
	 * It then calls repaint() Method.
	 */
	public void update(DrawingModel model) {
		this.model = model;
		//JOptionPane.showMessageDialog(this, "Viewer Updated");
		//this.width = this.getWidth();
		//this.height = this.getHeight();
		//System.out.println(width);
		//System.out.println(height);
		repaint(); 
	}
	
	/**
	 * paintComponent Method
	 * Method takes a Graphics Object. It then loops through the current DrawingModel
	 * Object's Shape ArrayList calling drawShape Method of each Shape Object in the
	 * ArrayList.
	 * 
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Retrieving the current collection of Shape Objects from the model
		List<Shape> shapes = this.model.getShapes();
		// Looping through ArrayList of Shape Objects calling each Shape Object's drawShape Method
		for (Shape s : shapes) {
			s.drawShape(g, this.getBackground());
		}
	}
}
