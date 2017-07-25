import java.math.BigInteger;
import java.util.Scanner;

/*
 * (Factorial) Using the BigInteger class introduced in Section 10.9, you can     
 * find the factorial for a large number (e.g., 100!). Implement the factorial    
 * method using recursion. Write a program that prompts the user to enter an      
 * integer and displays its factorial.                                            
 * 
 */

public class Recursion_Factorial18_1 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		BigInteger number = input.nextBigInteger();
		
		System.out.print("The factorial of " + number + "! is " + factorial(number));
		
		input.close();
	}
	
	public static BigInteger factorial(BigInteger number)
	{
		if (number.equals(BigInteger.ONE))
			return BigInteger.ONE;
		
		else
			return (number.multiply(factorial(number.subtract(BigInteger.ONE))));
	} 
}