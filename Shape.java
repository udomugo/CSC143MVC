import java.awt.Color;
import java.awt.Graphics;

public interface Shape{
	
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
	 * toString Method
	 * returns the dynamic class type of the Shape Object
	 * @return
	 */
	String toString();
	
	boolean removeLevel();
	
	boolean addLevel(int width, int height);
	
	boolean createChildren(int width, int height);
	
	boolean hasChildren();
	
	boolean reset();
	
	boolean checkClick(int xCheck, int yCheck);
	
	boolean checkCoord(int xCheck, int yCheck);
	
}
