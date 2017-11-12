import java.awt.Color;
import java.awt.Graphics;

public class HShape extends AbstractShape{
	
	private int size;
	private final int SCALE = 30;
	
	/**
	 * HShape Constructor
	 * Constructor takes an x-coordinate, a y-coordinate, a Color Object, a size value.
	 * @param x
	 * @param y
	 * @param c
	 * @param size
	 */
	public HShape(int x, int y, Color c, int size) {
		super(x,y,c);
		this.size = size;
		this.childrenShapes = new Shape[7];
	}
	
	/**
	 * drawShape Method
	 * Method takes a Graphics Object and a Color Object, it is recommend
	 * that this be the background color of container. It then calls
	 * commands to draw the HShape Object on the Graphics Object.
	 * 
	 */
	public void drawShape(Graphics g, Color bgColor) {
		// Setting the color of the HShape Object
		g.setColor(c);
		// Filling Square using the (x,y) coordinates and the length of the size value
		g.fillRect(this.x, this.y, this.size, this.size);
		// Setting the color to the background of the the container
		g.setColor(bgColor);
		// Filling the smaller square in the middle column, top row of FibonacciSquare Object
		g.fillRect(x + size/3, y, size/3, size/3);
		// Filling the smaller square in the middle column, bottom row of FibonacciSquare Object
		g.fillRect(x + size/3, y + 2*(size/3), size/3, size/3);
	}
	
	/**
	 * getDeepCopy Method
	 * Method returns a Deep Copy of the HShape Object.
	 */
//	public HShape getDeepCopy() {
//		return new HShape(this.x, this.y, this.c, this.size);
//	}
	
	public void createChildren() {
		for (int i = 0; i < childrenShapes.length; i++) {
			childrenShapes[i] = new HShape( x, y, c, size);
			System.out.println("Created HShape Child #" + i);
		}
	}
}
