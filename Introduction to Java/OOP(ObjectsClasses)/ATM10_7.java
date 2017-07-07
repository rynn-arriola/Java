
import java.util.Scanner;

/*
(Game: ATM machine) Use the Account class created in Programming Exercise
9.7 to simulate an ATM machine. Create ten accounts in an array with id
0, 1, . . . , 9, and initial balance $100. The system prompts the user to enter an
id. If the id is entered incorrectly, ask the user to enter a correct id. Once an id
is accepted, the main menu is displayed as shown in the sample run. You can
enter a choice 1 for viewing the current balance, 2 for withdrawing money, 3 for
depositing money, and 4 for exiting the main menu. Once you exit, the system
will prompt for an id again. Thus, once the system starts, it will not stop.
*/

public class ATM10_7
{


	public static void main(String[] args) 
	{
		
		Scanner input= new Scanner(System.in);
		Account1[] accounts= new Account1[10];
		
		for(int i=0;i<accounts.length;i++)
		{
			accounts[i]= new Account1(i,100);
		}
		
		while(true)
		{
			System.out.println("Enter your id: ");
			int id=input.nextInt();
			
			while(id<0 ||id>9)
			{
				System.out.println("ID is incorrect please enter a valid ID");
				id=input.nextInt();
			}
			while(true)
			{
				System.out.println("Main Menu "
							+ "\n1: Check Balance"
							+ "\n2: Withdraw"
							+ "\n3: Deposit"
							+ "\n4: Exit"
							+ "\nEnter a choice: ");
				
				if(!useMenu(accounts[id], input))
				{
					System.out.println();
					break;
				}
				System.out.println("\n");
			}
		}
	}
	public static boolean useMenu(Account1 account,Scanner input)
	{
		int choice=input.nextInt();
		
		if(choice==4)
			return false;
		
		else if(choice == 1)
		{
			System.out.print("The balance is "+account.getBalance());
			return true;
		}
		else if(choice==2)
		{
			System.out.print("Enter an amount to withdraw ");
			account.withdraw(input.nextDouble());
			return true;
		}
		else if(choice==3)
		{
			System.out.print("Enter an amount you want to deposit ");
			account.deposit(input.nextDouble());
			return true;
		}
		else
			System.out.println("Invalid Choice, Please Enter number 1-4");
		return true;
		
	}

}

class Account1
{
	private int id;
	private double balance;
		
	public Account1()
	{
		setId(0);
		setBalance(0);
		
	}
	public Account1(int id, double balance)
	{
		this.id=id;
		this.balance=balance;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public double getBalance() 
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	public double withdraw(double withdraw)
	{
		balance=balance-withdraw;
		return(getBalance()-withdraw);
	}
	public double deposit(double deposit)
	{
		balance=balance+deposit;
		
		return(getBalance()+deposit);
	}
	
}