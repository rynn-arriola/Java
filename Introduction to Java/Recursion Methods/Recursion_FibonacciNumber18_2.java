import java.util.Scanner;

/*
 * (Fibonacci numbers) Rewrite the fib method in Listing 18.2 using iterations.   
 * Hint: To compute fib(n) without recursion, you need to obtain fib(n - 2) and   
 * fib(n - 1) first. Let f0 and f1 denote the two previous Fibonacci numbers. The 
 * current Fibonacci number would then be f0 + f1. The algorithm  can be          
 * described as follows:                                                          
 *                                                                               
 * f0 = 0; // For fib(0)                                                          
 * f1 = 1; // For fib(1)                                                          
 *                                                                                
 * for (int i = 1; i <= n; i++) {                                                 
 * 		currentFib = f0 + f1;                                                    
 * 		f0 = f1;                                                                   
 * 		f1 = currentFib;                                                           
 * }                                                                              
 * // After the loop, currentFib is fib(n)                                        
 *                                                                                
 * Write a test program that prompts the user to enter an index and displays its  
 * Fibonacci number.                                          
 * 
 */


public class Recursion_FibonacciNumber18_2 
{

	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		
		System.out.println("Enter the index of the Fibonacci number: ");
		int index=input.nextInt();
		
		System.out.println("The Fibonacci number at index "+index+" is "+getFibonacci(index));

		input.close();
		
	}
	public static long getFibonacci(int index)
	{
		long f0 = 0;       
		long f1 = 1; 
		long currentFib = 0;  

		if (index == 0)
			return f0;
		else if (index == 1)
			return f1;       
      else 
      {
			for (int i = 1; i < index; i++)
			{
				currentFib = f0 + f1;     
				f0 = f1;                  
				f1 = currentFib;          
			} 
			return currentFib;                            
      }                       
	}

}
