import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class AbstractShape implements Shape{
	
	// fields of basic shape objects
	protected Color c;
	protected int x,y;
	protected Shape[] childrenShapes;
	protected int nextX;
	protected int nextY;
	//protected Point p;
	
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
		//this.p = new Point();
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
		return "" + this.getClass();
	}
	
	public boolean addLevel(int width, int height) {
		
		if (!this.hasChildren()) {
			//if ( (width == 0 && height == 0) || (!(this.nextX < 0 || this.nextX > width) && !(this.nextY < 0 || this.nextY > height)) ) {
				this.createChildren(width, height);
//			} else {
//				System.out.println("Can not draw outside the lines...");
//				return false;
//			}
		} else {
			for (Shape s : childrenShapes) {
				//if (s.hasChildren()) {
				s.addLevel(width, height);
				//}
//				else {
//					s.createChildren(width, height);
//				}
			}
		}
		return this.hasChildren();
	}
	
	public boolean removeLevel() {
		boolean isParent = this.hasChildren();
		if (isParent) {
			for (int i = 0; i < childrenShapes.length; i++) {
				if (childrenShapes[i].removeLevel()) {
					childrenShapes[i] = null;
				}
			}
		}
		return !isParent;
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
	
//	public boolean checkClick(int xCheck, int yCheck) {
//		boolean result = false;
//		if (!this.hasChildren()) {
//			result = this.checkCoord(xCheck, yCheck);
//		} else {
//			for (Shape s : childrenShapes) {
//				if(s.checkCoord(xCheck, yCheck)) {
//					result = true;
//					break;
//				} else {
//					result = s.checkClick(xCheck, yCheck);
//				}
//			}
//		}
//		return result;
//	}
	
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
