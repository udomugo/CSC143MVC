import java.util.ArrayList;
import java.util.List;

public class DrawingModel {
	
	private List<Shape> shapes = new ArrayList<Shape>();
	private ArrayList<Viewer> viewers = new ArrayList<Viewer>();
	
	/**
	 * addViewer Method
	 * Method takes a Viewer Object and stores it.
	 * It then updates the new view with the current model.
	 * @param v
	 */
	public void addViewer(Viewer v) {
		// Adding a Viewer Object
		this.viewers.add(v);
		// Calling the Viewer Object to update
		for (Viewer view : viewers)
			view.update(this);
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
		for (Viewer view : viewers)
			view.update(this);
	}
	
	/**
	 * getShapes Method
	 * Method returns a Deep Copy ArrayList of the current collection of 
	 * Shape Objects of the model.
	 * @return
	 */
	public ArrayList<Shape> getShapes() {
		
		ArrayList<Shape> copy = new ArrayList<Shape>();
		for (Shape s : shapes) {
			copy.add(s);
		}
		return copy;
		
		// Creating Deep Copy of the ArrayList of Shape Objects
//		ArrayList<Shape> deepCopy = new ArrayList<Shape>();
//		for (Shape s : shapes) {
//			deepCopy.add(s.getDeepCopy());
//		}
//		return deepCopy;
	}
	
	public void addLevel() {
		for (Shape s : shapes) {
			s.addLevel();
		}
		for (Viewer view : viewers) {
			view.update(this);
		}
	}
	
	public void removeLevel() {
		for (Shape s : shapes) {
			s.removeLevel();
		}
		for (Viewer view : viewers) {
			view.update(this);
		}
	}
}
