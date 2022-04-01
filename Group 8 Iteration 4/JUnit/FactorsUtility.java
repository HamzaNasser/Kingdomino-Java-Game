import java.util.ArrayList;

/*
 * provides functionality on the theme of factors
 * a very simple class built for JUnit testing
 * 
 * @author mhatcher October 2020
 */
public class FactorsUtility
{
	/**
	 * @param	a, b	integers
	 * @return	true if b is a factor of a; otherwise false 
	 * @throws	IllegalArgumentException if a < 0 or b < 1
	 */
	public static boolean factor( int a, int b ) throws IllegalArgumentException
	{
		if	( a < 0 || b < 1 )	{ throw new IllegalArgumentException();	}
		
	    return a%b == 0;
	}
	
	/**
	 * @param	a	an integer
	 * @return	factors of a, not including itself ; list is empty if a = 0 or a  1
	 * @throws	IllegalArgumentException if a < 0
	 */
	public static ArrayList<Integer> getFactors(int a) throws IllegalArgumentException
	{
		if	( a < 0 )	{ throw new IllegalArgumentException();	}
		
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int index = 1; index <= a/2; index ++)
		{
			if (factor(a, index))	{ factors.add(index); }
		}
		return factors;
	}
	
	/**
	 * @param	a	an integer
	 * @return	true if a is a perfect number, otherwise false 
	 * @throws	IllegalArgumentException if a < 1
	 */
	public static boolean perfect(int a) throws IllegalArgumentException
	{
		if	( a < 1 )	{ throw new IllegalArgumentException();	}
		
		ArrayList<Integer> factors = getFactors(a);
		int sum  = 0;
		
		for (Integer i : factors)
		{
			sum += i;
		}
		
		return sum == a;
	}
}
