import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Viewer extends JPanel implements View{
	
	private DrawingModel model;
	
	/**
	 * Viewer Constructor
	 * Creates the Viewer Object and sets the background color.
	 */
	public Viewer() {
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
		ArrayList<Shape> shapes = this.model.getShapes();
		// Looping through ArrayList of Shape Objects calling each Shape Object's drawShape Method
		for (Shape s : shapes) {
			s.drawShape(g, this.getBackground());
		}
	}
}
