import java.awt.Color;

public class AbstractShape {
	
	// fields of basic shape objects
	protected Color c;
	protected int x,y;
	
	/**
	 * AbstractShape Constructor
	 * Takes a x-coordinate, y-coordinate, and a color
	 * @param x
	 * @param y
	 * @param c
	 */
	public AbstractShape(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
}
