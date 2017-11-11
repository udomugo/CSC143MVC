import java.awt.Color;
import java.awt.Graphics;

public class FibonacciSquare extends AbstractShape implements Shape{
	
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
	public FibonacciSquare getDeepCopy() {
		return new FibonacciSquare(this.x, this.y, this.c, this.quadrant, this.n);
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
	
	public int getFibonacciValue(int n, int nOfF, int nOfFLast) {
		if (n == 1) {
			return nOfF;
		} else {
		//if(n > 1) {
			int temp = nOfF;
			nOfF += nOfFLast;
			nOfFLast = temp;
		}
		return getFibonacciValue(n-1, nOfF, nOfFLast);
	}
}
