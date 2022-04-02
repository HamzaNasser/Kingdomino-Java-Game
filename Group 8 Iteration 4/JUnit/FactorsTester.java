import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class FactorsTester {

	@Test
	void testPerfect1()
	{	
		// TEST 1: should throw the exception because the parameter value is less than 1
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.perfect(0));
	}
	
	@Test
	void testPerfect2()
	{	
		// TEST 2: should succeed because 1 is a valid parameter value, but is not a perfect number
		assertFalse(FactorsUtility.perfect(1));
	}
	
	@Test
	void testPerfect3()
	{	
		// TEST 3: should succeed because 6 is a valid parameter value, and is a perfect number
		assertTrue(FactorsUtility.perfect(6));
	}
	
	@Test
	void testPerfect4()
	{	
		// TEST 4: should succeed because 7 is a valid parameter value, but is not a perfect number
		// I've coded this using assertEquals to show that there's often more than one way to write a test 
		boolean expected = false;
		assertEquals(expected, FactorsUtility.perfect(7));
	}

	@Test
	public void testgetFactors1()
	{	
		// TEST 1: should succeed because 2 is a valid parameter value, returns an array list with [1]
		ArrayList<Integer> expected = new ArrayList<Integer>();
// Adding arraylist expected values
		expected.add(1);
		assertEquals(expected, FactorsUtility.getFactors(2));
	}

	@Test
	public void testgetFactors2()
	{	
		// TEST 2: should succeed because 1 is a valid parameter value, returns an empty array list  []
		ArrayList<Integer> expected = new ArrayList<Integer>();
		assertEquals(expected, FactorsUtility.getFactors(1));
	}
	@Test
	public void testgetFactors3()
	{	
		// TEST 3: should succeed because 0 is a valid parameter value, returns an empty array list  []
		ArrayList<Integer> expected = new ArrayList<Integer>();
		assertEquals(expected, FactorsUtility.getFactors(0));
	}
	@Test
	public void testgetFactors4()
	{	
		// TEST 4: should succeed because -1 is a invalid parameter value, throws an IllegalArgumentException
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.getFactors(-1));
	}
	@Test
	public void testgetFactors5()
	{	
		// TEST 5: should succeed because 12 as a parameter for get factors returns [1,2,3,4,6]
		ArrayList<Integer> expected = new ArrayList<Integer>();
		// Adding arraylist expected values
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		expected.add(6);
		assertEquals(expected, FactorsUtility.getFactors(12));
	}

	@Test
	public void testFactor()
	{	
		// TEST 1: should succeed because -1 is a invalid parameter value for a and 0 is invalid for b, throws an IllegalArgumentException
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.factor(-1,0));
	}

}
