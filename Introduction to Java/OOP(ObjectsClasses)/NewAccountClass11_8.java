import java.util.ArrayList;
import java.util.Date;


/*(New Account class) An Account class was specified in Programming
Exercise 9.7. Design a new Account class as follows:
# Add a new data field name of the String type to store the name of the
customer.
# Add a new constructor that constructs an account with the specified name, id,
and balance.
# Add a new data field named transactions whose type is ArrayList
that stores the transaction for the accounts. Each transaction is an instance
of the Transaction class. The Transaction class is defined as shown in
Figure 11.6.
*/

public class NewAccountClass11_8
{

	public static void main(String[] args)
	{
		Account2.setAnnualinterestRate(5.5);
		Account2 account=new Account2("George", 1122, 1000);
		
		//deposits
		account.deposit(30);
		account.deposit(40);
		account.deposit(50);
		//withdraws
		account.withdraw(5);
		account.withdraw(4);
		account.withdraw(2);
		
		System.out.println("Name: "+ account.getName());
		System.out.println("Annual Interest Rate: "+ Account2.getAnnualinterestRate());
		System.out.println("Balance: "+account.getBalance());
		
		ArrayList<Transaction>list=account.getTransactions();
		
		System.out.printf("%-32s%-10s%-10s%-10s\n", "Date","Type", "Amount","Balance");
		
		for(int i=0;i<list.size();i++)
		{
			
			Transaction transaction=(list.get(i));
			
			System.out.printf("%-32s%-10s%-10s%-10s\n",transaction.getDate(), transaction.getType(), transaction.getAmount(), transaction.getBalance());
		}
		
		
	}

}
class Account2
{
	private int id;
	private String name;
	private double balance;
	private static double annualinterestRate;
	private Date dateCreated;
	private ArrayList<Transaction>transactions = new ArrayList<>();
	
	public Account2()
	
	{
		dateCreated= new Date();
	}
	
	public Account2(String name, int id, double balance )
	{
		this.id=id;
		this.setName(name);
		this.balance=balance;
		dateCreated= new Date();
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public double getBalance() 
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public static double getAnnualinterestRate()
	{
		return annualinterestRate;
	}
	public static void setAnnualinterestRate(double annualinterestRate)
	{
		Account2.annualinterestRate=annualinterestRate;
	}
	public double getMonthlyInterest()
	{
		return balance*(annualinterestRate/1200);
	}
	public Date getDateCreated()
	{
		return dateCreated;
	}
	public ArrayList<Transaction>getTransactions()
	{
		return transactions;
	}
	public void withdraw(double amount)
	{
		balance=balance-amount;
		transactions.add(new Transaction('W', amount, balance, ""));
	}
	public void deposit(double amount)
	{
		balance=balance+amount;
		transactions.add(new Transaction('D', amount, balance, ""));
	}
}
class Transaction extends Account2
{
	private Date date;
	private char type;
	private double amount;
	private double balance;
	private String description;
	
	public Transaction()
	{
		this('N',0,0,"Default");
	}
	public Transaction(char type, double amount, double balance, String description)
	{
		date=new Date();
		this.type=type;
		this.amount=amount;
		this.balance=balance;
		this.description=description;
	}
	public Date getDate()
	{
		return date;
	}
	public char getType()
	{
		return type;
	}
	public double getAmount()
	{
		return amount;
	}
	public double getBalance()
	{
		return balance;
	}
	public String getDescription()
	{
		return description;
	}
}
