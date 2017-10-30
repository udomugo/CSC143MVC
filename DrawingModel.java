import java.util.ArrayList;
import java.util.List;

public class DrawingModel {
	
	private List<Shape> shapes = new ArrayList<Shape>();
	private Viewer viewer;
	
	/**
	 * addViewer Method
	 * Method takes a Viewer Object and stores it.
	 * It then updates the new view with the current model.
	 * @param v
	 */
	public void addViewer(Viewer v) {
		// Adding a Viewer Object
		this.viewer = v;
		// Calling the Viewer Object to update
		viewer.update(this);
	}
	
	/**
	 * addShape Method
	 * Method takes a Shape Object and stores it in the shapes ArrayList.
	 * It then updates the stored Viewer Object with the current model.
	 * @param shape
	 */
	public void addShape(Shape shape) {
		// Adding the Shape Object to the ArrayList
		this.shapes.add(shape);
		// Calling the Viewer Object to update
		viewer.update(this);
	}
	
	/**
	 * getShapes Method
	 * Method returns a Deep Copy ArrayList of the current collection of 
	 * Shape Objects of the model.
	 * @return
	 */
	public ArrayList<Shape> getShapes() {
		
		// Creating Deep Copy of the ArrayList of Shape Objects
		ArrayList<Shape> deepCopy = new ArrayList<Shape>();
		for (Shape s : shapes) {
			deepCopy.add(s.getDeepCopy());
		}
		return deepCopy;
	}
}
