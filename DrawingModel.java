import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DrawingModel {
	
	private List<Shape> shapes = new ArrayList<Shape>();
	private List<View> views = new ArrayList<View>();
	
	/**
	 * addViewer Method
	 * Method takes a Viewer Object and stores it.
	 * It then updates the new view with the current model.
	 * @param v
	 */
	public void addView(View v) {
		// Adding a Viewer Object
		this.views.add(v);
		// Calling the Viewer Object to update
		for (View view : views)
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
		for (View view : views)
			view.update(this);
	}
	
	/**
	 * getShapes Method
	 * Method returns a Deep Copy ArrayList of the current collection of 
	 * Shape Objects of the model.
	 * @return
	 */
	public List<Shape> getShapes() {
		//return this.shapes;
		List<Shape> copy = new ArrayList<Shape>();
		for (Shape s : shapes) {
			copy.add(s);
		}
		return copy;
	}
	
	public void addLevel(Shape s) {
		if (!s.addLevel(views.get(0).getWidth(), views.get(0).getHeight())) {
			JOptionPane.showMessageDialog((DrawingView)views.get(0), "Reached Max Level. Can not add any more levels");
		}
		for (View view : views) {
			view.update(this);
		}
	}
	
	public void removeLevel(Shape s) {
		if (s.removeLevel()) {
			JOptionPane.showMessageDialog((DrawingView)views.get(0), "Reached Base Level. Can not remove any more levels");
		}
		for (View view : views) {
			view.update(this);
		}
	}
	
	public void resetShapes() {
		for (Shape s : shapes) {
			s.reset();
		}
		for (View view : views) {
			view.update(this);
		}
	}
}
