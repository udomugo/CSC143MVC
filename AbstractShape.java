import java.awt.Color;
import java.awt.Graphics;

public class AbstractShape implements Shape{
	
	// fields of basic shape objects
	protected Color c;
	protected int x,y;
	protected Shape[] childrenShapes;
	
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

	@Override
	public void drawShape(Graphics g, Color c) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return "" + this.getClass();
	}
	
	public boolean addLevel() {
		if (!this.hasChildren()) {
			this.createChildren();
		} else {
			for (Shape s : childrenShapes) {
				if (s.hasChildren()) //{
					s.addLevel();
//				} else {
//					this.createChildren();
//				}
			}
		}
		return this.hasChildren();
	}
	
	public boolean removeLevel() {
		if (this.hasChildren()) {
			for (Shape s : childrenShapes) {
				s.removeLevel();
			}
		}
		return this.hasChildren();
	}
	
	public boolean hasChildren() {
		boolean children = true;
		for (Shape s : childrenShapes) {
			if (s == null) {
				children = false;
			}
		}
		return children;
	}
	
	public void createChildren() {
		this.createChildren();
	}
	
}
