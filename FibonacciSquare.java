import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class FibonacciSquare extends AbstractShape{
	
	private int quadrant, n;
	private final int NOFF = 1;
	private final int NOFFLAST = 0;
	private final int SIZE = 15;
	private final int BUFFER = 5;
	
	/**
	 * FibonacciSquare Constructor
	 * Constructor takes an x-coordinate, a y-coordinate, a Color Object, a Cartesian quadrant, and value n to calculate
	 * the Fibonacci Sequence.
	 * @param x
	 * @param y
	 * @param c
	 * @param quadrant
	 * @param n
	 */
	public FibonacciSquare(int x, int y, Color c, int quadrant, int n) {
		super(x,y,c);
		this.quadrant = quadrant;
		this.n = n;
		this.childrenShapes = new Shape[1];
		Point p = this.getNextCoord(quadrant, n);
		this.nextX = (int)p.getX();
		this.nextY = (int)p.getY();
		//System.out.println(nextX);
		//System.out.println(nextY);
	}
	
	/**
	 * drawShape Method
	 * Method takes a Graphics Object and a Color Object. It then calls
	 * commands to draw the FibonacciSquare Object on the Graphics Object with
	 * respect to the Cartesian quadrant of the FibonacciSquare Object.
	 * 
	 */
//	public void draw(Graphics g, Color bgColor) {
//		int size = SIZE * getFibonacciValue();
//		// Setting the color of the FibonacciSquare Object
//		g.setColor(c);
//		// Drawing the Box of the FibonacciSquare with the given (x, y) coordinates 
//		//		being in the the upper left corner of the FibonacciSquare when drawn
//		g.drawLine(this.x, this.y, this.x + size, this.y);
//		g.drawLine(this.x + size, this.y, this.x + size, this.y + size);
//		g.drawLine(this.x, this.y + size, this.x + size, this.y + size);
//		g.drawLine(this.x, this.y, this.x, this.y + size);
//		
//		// Drawing the arc of the FibonacciSquare Object based on Cartesian quadrant
//		switch (this.quadrant){
//			case 1: {
//				g.drawArc(this.x - size, this.y, 2*size, 2*size, 0, 90);
//				break;
//			}
//			case 2: {
//				g.drawArc(this.x, this.y, 2*size, 2*size, 90, 90);
//				break;
//			}
//			case 3: {
//				g.drawArc(this.x, this.y - size, 2*size, 2*size, 180, 90);
//				break;
//			}
//			case 4: {
//				g.drawArc(this.x - size, this.y - size, 2*size, 2*size, 270, 90);
//				break;
//			}
//		}
//	}
	
	public void draw(Graphics g, Color bgColor, int width, int height) {
		//if ( (width == 0 && height == 0) || (!(this.nextX < 0 || this.nextX > width) && !(this.nextY < 0 || this.nextY > height)) ) {
			int size = SIZE * getFibonacciValue();
			// Setting the color of the FibonacciSquare Object
			g.setColor(Color.blue);
			g.drawRect(this.x - 3, this.y - 3, 7, 7);
			g.setColor(c);
			
			// Drawing the arc of the FibonacciSquare Object based on Cartesian quadrant
			switch (this.quadrant){
				case 1: {
					g.drawLine(this.x, this.y, this.x - size, this.y);
					g.drawLine(this.x - size, this.y, this.x - size, this.y - size);
					g.drawLine(this.x - size, this.y - size, this.x, this.y - size);
					g.drawLine(this.x, this.y, this.x, this.y - size);
					g.drawArc(this.x - 2*size, this.y - size, 2*size, 2*size, 0, 90);
					break;
				}
				case 2: {
					g.drawLine(this.x, this.y, this.x - size, this.y);
					g.drawLine(this.x - size, this.y, this.x - size, this.y + size);
					g.drawLine(this.x - size, this.y + size, this.x, this.y + size);
					g.drawLine(this.x, this.y, this.x, this.y + size);
					g.drawArc(this.x - size, this.y, 2*size, 2*size, 90, 90);
					break;
				}
				case 3: {
					g.drawLine(this.x, this.y, this.x + size, this.y);
					g.drawLine(this.x + size, this.y, this.x + size, this.y + size);
					g.drawLine(this.x, this.y + size, this.x + size, this.y + size);
					g.drawLine(this.x, this.y, this.x, this.y + size);
					g.drawArc(this.x, this.y - size, 2*size, 2*size, 180, 90);
					break;
				}
				case 4: {
					g.drawLine(this.x, this.y, this.x + size, this.y);
					g.drawLine(this.x + size, this.y, this.x + size, this.y - size);
					g.drawLine(this.x + size, this.y - size, this.x, this.y - size);
					g.drawLine(this.x, this.y, this.x, this.y - size);
					g.drawArc(this.x - size, this.y - 2*size, 2*size, 2*size, 270, 90);
					break;
				}
			}
//		} else {
//			System.out.println("Can not draw outside the lines...");
//		}
	}
	
	/**
	 * getDeepCopy Method
	 * Method returns a Deep Copy of the FibonacciSquare Object.
	 */
//	public FibonacciSquare getDeepCopy() {
//		return new FibonacciSquare(this.x, this.y, this.c, this.quadrant, this.n);
//	}
	
	/**
	 * getFibonaccieValue Method
	 * Method calls overloaded method of getFibonacciValue with no parameters
	 * @param n
	 * @return
	 */
	public int getFibonacciValue() {
		return getFibonacciValue(this.n);
	}
	
	/**
	 * getFibonaccieValue Method
	 * Method calls overloaded method of getFibonacciValue with default parameters
	 * @param n
	 * @return
	 */
	public int getFibonacciValue(int n) {
		return getFibonacciValue(n, NOFF, NOFFLAST);
	}
	
	/**
	 * getFibonacciValue Method Overload
	 * Method recursively calculates the Fibonacci Number to the value of n using the
	 * constants NOFF and NOFFLAST as starting parameters.
	 * @param n
	 * @param nOfF
	 * @param nOfFLast
	 * @return
	 */
	public int getFibonacciValue(int n, int nOfF, int nOfFLast) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return nOfF;
		} else {
			int temp = nOfF;
			nOfF += nOfFLast;
			nOfFLast = temp;
		}
		return getFibonacciValue(n-1, nOfF, nOfFLast);
	}
	
	/**
	 * createChildren()
	 */
	public boolean createChildren(int width, int height) {
		if (checkNextSquare(width, height)) {
			//this.createChildren();
			//int nextN = n * getFibonacciValue();
			int nextQ = getNextQuadrant(this.quadrant);
			//Point p = getCoordinates(nextQ);
			//this.childrenShapes[0] = new FibonacciSquare( (int)p.getX(), (int)p.getY(), c, nextQ, n + 1);
			this.childrenShapes[0] = new FibonacciSquare( this.nextX, this.nextY, c, nextQ, n + 1);
			System.out.println("Created FibonacciSqaure Child");
			return true;
		} else {
			System.out.println("Can not draw outside the lines...");
			return false;
		}
	}
	
	private int getNextQuadrant(int quadrant) {
		if ( quadrant == 4) {
			quadrant = 1;
		} else {
			quadrant++;
		}
		return quadrant;
	}
	
	private Point getNextCoord(int q, int n) {
		Point p = new Point();
		int xNext = 0;
		int yNext = 0;
		int size = SIZE * getFibonacciValue(n);
		switch(this.getNextQuadrant(q)) {
			case 1: {
				xNext = this.x + size;
				yNext = this.y - size;
				break;
			}
			case 2: {
				xNext = this.x - size;
				yNext = this.y - size;
				break;
			}
			case 3: {
				xNext = this.x - size;
				yNext = this.y + size;
				break;
			}
			case 4: {
				xNext = this.x + size;
				yNext = this.y + size;
				break;
			}
		}
		p.setLocation(xNext, yNext);
		return p;
	}
	
	
	public boolean checkNextSquare(int width, int height) {
		//int nextSquareQuad = getNextQuadrant(this.quadrant);
		Point p = getNextCoord(this.quadrant, this.n + 1);
		int xNext = (int)p.getX();
		int yNext = (int)p.getY();
		return (width == 0 && height == 0) || (!(xNext < 0 || xNext > width) && !(yNext < 0 || yNext > height));
	}
	
	/**
	 * 
	 */
	public boolean checkCoord(int xCheck, int yCheck) {
		boolean result = false;
		
		switch(this.quadrant) {
		
		case 1: {
			if ((xCheck > this.nextX - BUFFER && xCheck < this.x + BUFFER) && (yCheck > this.nextY + BUFFER && yCheck < this.y - BUFFER)) {
				result = true;
			} else {
				result = false;
			}
//			if (yCheck > this.nextY + BUFFER && yCheck < this.y - BUFFER) {
//				result = true;
//			} else {
//				result = false;
//			}
			return result;
		}
		case 2: {
			if ((xCheck > this.nextX && xCheck < this.x) && (yCheck < this.nextY && yCheck > this.y)) {
				result = true;
			} else {
				result = false;
			}
//			if (yCheck < this.nextY && yCheck > this.y) {
//				result = true;
//			} else {
//				result = false;
//			}
			return result;
		}
		case 3: {
			if ((xCheck < this.nextX && xCheck > this.x) && (yCheck < this.nextY && yCheck > this.y)) {
				result = true;
			} else {
				result = false;
			}
//			if (yCheck < this.nextY && yCheck > this.y) {
//				result = true;
//			} else {
//				result = false;
//			}
			return result;
		}
		case 4: {
			if ((xCheck < this.nextX && xCheck > this.x) && (yCheck > this.nextY && yCheck < this.y)) {
				result = true;
			} else {
				result = false;
			}
//			if (yCheck < this.nextY && yCheck > this.y) {
//				result = true;
//			} else {
//				result = false;
//			}
			return result;
		}
		}
		
//		if ((Math.abs(this.x - nextX) > Math.abs(this.x - xCheck)) || (Math.abs(this.x - nextX) > Math.abs(this.nextX - xCheck))) {
//			result = true;
//		} else {
//			result = false;
//		}
//		if ((Math.abs(this.y - nextY) > Math.abs(this.y - yCheck)) || (Math.abs(this.y - nextY) > Math.abs(this.nextY - yCheck))) {
//			result = true;
//		} else {
//			result = false;
//		}
		return result;
	}
}
