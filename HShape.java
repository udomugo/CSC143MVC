import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class HShape extends AbstractShape{
	
	private static int smallestSize;
	private int size;
	
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
		smallestSize = size;
		this.childrenShapes = new Shape[7];
		this.nextX = this.x + size;
		this.nextY = this.y + size;
	}
	
	/**
	 * drawShape Method
	 * Method takes a Graphics Object and a Color Object, it is recommend
	 * that this be the background color of container. It then calls
	 * commands to draw the HShape Object on the Graphics Object.
	 * 
	 */
	public void draw(Graphics g, Color bgColor) {
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
	
	public boolean addLevel(int width, int height) {
		boolean result = false;
		if (smallestSize <= 3){
			System.out.println("Level not added. They would be so tiny!");
		} else {
			result = super.addLevel(width, height);
		}
		return result;
	}
	
	public boolean removeLevel() {
		if (!this.hasChildren()) {
			smallestSize *= 3;
			return true;
		} else {
			super.removeLevel();
		}
		return false;
	}
	
	public boolean createChildren(int width, int height) {
		boolean result = false;
		if (smallestSize <= 3){
			System.out.println("Children Not Created. They would be so tiny!");
			//JOptionPane.showMessageDialog(null, "Children Not Created. They would be so tiny!");
		} else {
			for (int i = 0; i < childrenShapes.length; i++) {
				Point p = getCoordinates(i);
				childrenShapes[i] = new HShape( (int)p.getX(), (int)p.getY(), c, size/3);
				//System.out.println("Created HShape Child #" + i);
				result = true;
			}
		}
		return result;
	}
	
	private Point getCoordinates(int i) {
		Point p = new Point();
		int xNext = 0;
		int yNext = 0;
		switch(i) {
			case 0: {
				xNext = this.x;
				yNext =this.y;
				break;
			}
			case 1: {
				xNext = this.x;
				yNext =this.y + this.size/3;
				break;
			}
			case 2: {
				xNext = this.x;
				yNext =this.y + 2*(this.size/3);
				break;
			}
			case 3: {
				xNext = this.x + this.size/3;
				yNext =this.y + this.size/3;
				break;
			}
			case 4: {
				xNext = this.x + 2*(this.size/3);
				yNext =this.y;
				break;
			}
			case 5: {
				xNext = this.x + 2*(this.size/3);
				yNext =this.y + this.size/3;
				break;
			}
			case 6: {
				xNext = this.x + 2*(this.size/3);
				yNext =this.y + 2*(this.size/3);
				break;
			}
		}
		p.setLocation(xNext, yNext);
		return p;
	}
	
	public boolean checkClick(int xCheck, int yCheck) {
		return this.checkCoord(xCheck, yCheck);
	}
	
	public boolean reset() {
		 smallestSize = this.size;
		 return super.reset(); 
	}
}
