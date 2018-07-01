import java.awt.Color;
import java.awt.Graphics;

public class AbstractShape implements Shape{
	
	// fields of basic shape objects
	protected Color c;
	protected int x,y;
	protected Shape[] childrenShapes;
	protected int nextX;
	protected int nextY;
	protected static int level=0;
	
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
	public void draw(Graphics g, Color c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawShape(Graphics g, Color c) {
		// TODO Auto-generated method stub
		this.draw(g, c);
		if (this.hasChildren()) {
			for (Shape s : childrenShapes) {
				s.drawShape(g, c);
			}
		} 
	}
	
	public String toString() {
		return "" + this.getClass() + "Level: " + level;
	}
	
	public boolean addLevel(int width, int height) {
		boolean result = false;
		if (!this.hasChildren()) {
			result = this.createChildren(width, height);
			if(result) {
				level++;
			}
		} else {
			for (Shape s : childrenShapes) {
				result = s.addLevel(width, height);
			}
		}
		return result;
	}
	
	public boolean removeLevel() {
		boolean isParent = this.hasChildren();
		if (isParent) {
			for (int i = 0; i < childrenShapes.length; i++) {
				if (childrenShapes[i].removeLevel()) {
					childrenShapes[i] = null;
					return false;
				}
			}
		}
		return !isParent;
		//return !isParent;
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
	
	public boolean createChildren(int width, int height) {
		return this.createChildren(width, height);
	}

	public boolean reset() {
		for (int i = 0; i< childrenShapes.length; i++) {
			childrenShapes[i] = null;
		}
		return true;
	}
	
	public boolean checkClick(int xCheck, int yCheck) {
		boolean result = false;
		if (this.checkCoord(xCheck, yCheck)) {
			return true;
		}
		if (this.hasChildren()) {
			for (Shape s : childrenShapes) {
				if(s.checkCoord(xCheck, yCheck)) {
					result = true;
					break;
				} else {
					result = s.checkClick(xCheck, yCheck);
				}
			}
		}
		return result;
	}

	@Override
	public boolean checkCoord(int xCheck, int yCheck) {
		return (xCheck < this.nextX && xCheck > this.x) && (yCheck < this.nextY && yCheck > this.y);
	}
}
