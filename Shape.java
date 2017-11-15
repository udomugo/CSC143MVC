import java.awt.Color;
import java.awt.Graphics;

public interface Shape {
	
	/**
	 * drawShape Method
	 * Method takes a Graphics Object and a Color object. The Color Object is recommended to be the background color of the
	 * container.
	 * @param g
	 * @param c
	 */
	void drawShape(Graphics g, Color c);
	
	void draw(Graphics g, Color c);
	
	/**
	 * getDeepCopy Method
	 * Method returns a Deep Copy of the Shape Object
	 * @return
	 */
	//Shape getDeepCopy();
	
	/**
	 * toString Method
	 * returns the dynamic class type of the Shape Object
	 * @return
	 */
	String toString();
	
	boolean removeLevel();
	
	boolean addLevel();
	
	boolean createChildren();
	
	boolean hasChildren();
	
}
