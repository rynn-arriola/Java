/**
 * Sum series
 * Write a recursive method to compute the following series:
 * Write a test program that displays m(i) for i = 1, 2, . . ., 10.
 * 
 * 
 * 
 *
 */


public class Recursion_SumSeries18_6 
{

	public static void main(String[] args) 
	{
	
		
		for(int i=1;i<=10;i++)
		{
		
			System.out.print(String.format("%2d%8.2f\n", i, sumSeries(i)));
		
		}
	}
	public static double sumSeries(int number)
	{
		if(number<=0)
		{
			
			return (0);
		}
		else
			
		
		return ((number / (number + 1.0)) + sumSeries(--number));
	}

}

