import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class MVCTestUnit {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void testGetFibonacciValue() {
		FibonacciSquare testShape = new FibonacciSquare(600, 50, Color.orange,1,60);
		int testResult1 = testShape.getFibonacciValue(6);
		System.out.println(testResult1);
		assertTrue(testResult1 == 8);
		
		int testResult2 = testShape.getFibonacciValue(20);
		System.out.println(testResult2);
		assertTrue(testResult2 == 6765);
	}

}
