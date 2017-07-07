import javax.swing.JOptionPane;
public class PerfectNumbers3 {

	public static void main(String[] args) {
		int n;
		int m;

		
		n=Integer.parseInt(JOptionPane.showInputDialog("Please enter the first number: "));
		m=Integer.parseInt(JOptionPane.showInputDialog("Please enter the second number: "));

		while(n<m)
		{
		
		
		if(isPerfect(n))
			JOptionPane.showMessageDialog(null, n+"  is the Perfect number");
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
