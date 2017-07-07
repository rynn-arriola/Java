import java.util.Scanner;
public class PerfectNumbers2 {

	public static void main(String[] args) {
		int n;
		int m;

		System.out.println(" Enter two numbers: ");
		
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();		

		while(n<m)
		{
		
		
		if(isPerfect(n))
			System.out.println(n+" It is a Perfect number");
		n++;
		
		}

	}
	public static boolean isPerfect(int n)
	{
		int sum=0;
		
		for(int i=1;i<n;i++)
		{
			if(n%i==0)
				sum=sum+i;
		}
		if(n==sum)
			return true;
		return false;
		
	}

}
