
public class exam4p1
{
  public static void main(String[] args) 
  {
    try
    {
    	new MyLoan(7.5, 30, -100000); 
      //  MyLoan m = new MyLoan(-1, 5, 30000); 
        //new MyLoan(7.5, -30, 20000);
    }
    catch (Exception e)
    {
      System.out.println(e);
    
    System.out.println("End of program");
  }
    
  }
}

class MyLoan 
{
  private double annualInterestRate;
  private int numOfYears;
  private double loanAmount;

  
  public MyLoan() 
  {
    this(7.5, 30, 100000);
  }

  /** Construct a NewLoan with specified annual interest rate,
      number of years and loan amount
    */
  public MyLoan(double annualInterestRate, int numOfYears, double loanAmount) 
  {
	 
	  if(numOfYears<=0) 
		  throw new IllegalArgumentException("Number of Years must be Positive");
	  
	  if(loanAmount<=0) 
		  throw new IllegalArgumentException("Loan Amount Interest must be Positive");

	  if(annualInterestRate<=0) 
		  throw new IllegalArgumentException("Loan Amount Interest must be Positive");
	  
	  this.annualInterestRate=annualInterestRate;
	  this.numOfYears=numOfYears;
	  this.loanAmount=loanAmount;
	  
	  
  }

  public double getAnnualInterestRate()
  {
    return annualInterestRate;
  }

  /** Set a new annualInterestRate */
  public void setAnnualInterestRate(double annualInterestRate) 
  {
	//Complete this constructor
	 
	  if(annualInterestRate<=0) 
		  throw new IllegalArgumentException("Annual Interest must be Positive");
	  
	  this.annualInterestRate=annualInterestRate;
  }

  public int getNumOfYears() 
  {
    return numOfYears;
  }

  /** Set a new numOfYears */
  public void setNumOfYears(int numOfYears) 
  {
	  if(numOfYears<=0) 
		  throw new IllegalArgumentException("Number of Years must be Positive");
	  
	  this.numOfYears=numOfYears;
  }

  public double getLoanAmount()
  {
    return loanAmount;
  }

  
  public void setLoanAmount(double loanAmount)
  {
    if (loanAmount <= 0)
      throw new IllegalArgumentException("Loan amount must be positive.");
    this.loanAmount = loanAmount;
  }


  public double monthlyPayment()
  {
    double monthlyInterestRate = annualInterestRate / 1200;
    return loanAmount * monthlyInterestRate / (1 -
      (Math.pow(1 / (1 + monthlyInterestRate), numOfYears * 12)));
  }

  
  public double totalPayment() 
  {
    return monthlyPayment() * numOfYears * 12;
  }
  
}

