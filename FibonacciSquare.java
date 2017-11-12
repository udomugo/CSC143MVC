import java.awt.Color;
import java.awt.Graphics;

public class FibonacciSquare extends AbstractShape{
	
	private int quadrant, n;
	private final int NOFF = 1;
	private final int NOFFLAST = 0;
	
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
	}
	
	/**
	 * drawShape Method
	 * Method takes a Graphics Object and a Color Object. It then calls
	 * commands to draw the FibonacciSquare Object on the Graphics Object with
	 * respect to the Cartesian quadrant of the FibonacciSquare Object.
	 * 
	 */
	public void drawShape(Graphics g, Color bgColor) {
		// Setting the color of the FibonacciSquare Object
		g.setColor(c);
		// Drawing the Box of the FibonacciSquare with the given (x, y) coordinates 
		//		being in the the upper left corner of the FibonacciSquare when drawn
		g.drawLine(this.x, this.y, this.x + this.n, this.y);
		g.drawLine(this.x + this.n, this.y, this.x + this.n, this.y + this.n);
		g.drawLine(this.x, this.y + this.n, this.x + this.n, this.y + this.n);
		g.drawLine(this.x, this.y, this.x, this.y + this.n);
		
		// Drawing the arc of the FibonacciSquare Object based on Cartesian quadrant
		switch (this.quadrant){
			case 1: {
				g.drawArc(this.x - this.n, this.y, 2*n, 2*n, 0, 90);
				break;
			}
			case 2: {
				g.drawArc(this.x, this.y, 2*n, 2*n, 90, 90);
				break;
			}
			case 3: {
				g.drawArc(this.x, this.y - this.n, 2*n, 2*n, 180, 90);
				break;
			}
			case 4: {
				g.drawArc(this.x - this.n, this.y - this.n, 2*n, 2*n, 270, 90);
				break;
			}
		}
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
	public void createChildren() {
		
		this.childrenShapes[0] = new FibonacciSquare( x + 100, y, c, quadrant, n);
		System.out.println("Created FibonacciSqaure Child");
	}
}
