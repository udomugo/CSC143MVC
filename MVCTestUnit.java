import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class MVCTestUnit {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	/**
	 * testGetFibonacciValue Method
	 * Test checks that getFibonacciValue() in FibonacciSquare Class correctly
	 * calculates the Fibonacci Number to the value of n 
	 */
	@Test
	public void testGetFibonacciValue() {
		FibonacciSquare testShape = new FibonacciSquare(600, 50, Color.orange,1,60);
		int testResult1 = testShape.getFibonacciValue(6);
		System.out.println(testResult1);
		assertTrue(testResult1 == 8);
		
		int testResult2 = testShape.getFibonacciValue(2);
		System.out.println(testResult2);
		assertTrue(testResult2 == 1);
		
		int testResult3 = testShape.getFibonacciValue(0);
		System.out.println(testResult3);
		assertTrue(testResult3 == 0);
	}
	
	@Test
	public void testToString() {
		FibonacciSquare testShape1 = new FibonacciSquare(600, 50, Color.orange,1,60);
		System.out.println(testShape1);
		assertTrue(testShape1.toString().equals("class FibonacciSquare"));
		
		HShape testShape2 = new HShape(50,50,Color.green,90);
		System.out.println(testShape2);
		assertTrue(testShape2.toString().equals("class HShape"));
	}
	
	@Test
	public void testHasChildren() {
		FibonacciSquare testShape1 = new FibonacciSquare(600, 50, Color.orange,1,60);
		//System.out.println(testShape1);
		assertTrue(!testShape1.hasChildren());
		
		HShape testShape2 = new HShape(50,50,Color.green,90);
		//System.out.println(testShape2);
		assertTrue(!testShape2.hasChildren());
	}
	
	@Test
	public void testCreateChildren() {
		FibonacciSquare testShape1 = new FibonacciSquare(600, 50, Color.orange,1,60);
		//System.out.println(testShape1);
		assertTrue(!testShape1.hasChildren());
		
		HShape testShape2 = new HShape(50,50,Color.green,90);
		//System.out.println(testShape2);
		assertTrue(!testShape2.hasChildren());
		
		testShape1.createChildren();
		testShape2.createChildren();
		

		assertTrue(testShape1.hasChildren());
		assertTrue(testShape2.hasChildren());
	}
	
	@Test
	public void testAddLevel() {
		FibonacciSquare testShape1 = new FibonacciSquare(600, 50, Color.orange,1,60);
		assertTrue(!testShape1.hasChildren());
		
		HShape testShape2 = new HShape(50,50,Color.green,90);
		assertTrue(!testShape2.hasChildren());
		
		assertTrue(testShape1.addLevel());
		assertTrue(testShape1.hasChildren());
		
		assertTrue(testShape2.addLevel());
		assertTrue(testShape2.hasChildren());
	}

}
