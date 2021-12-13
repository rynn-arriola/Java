/*
		RYNN ARRIOLA
		UNIT 9 CASE PROBLEM PART 2
*/

package BubbleSort;
import java.util.Scanner;

public class RentalDemo {

public static void main(String[] args) {
		
		
		Rental rental[]=new Rental[8]; // rental objects
		Scanner scanner= new Scanner(System.in);
		Scanner scanner2= new Scanner(System.in);
		Scanner scanner3=new Scanner(System.in);
		Scanner scanner4=new Scanner(System.in);
		Scanner scanner5=new Scanner(System.in);
		
		String phoneNum;
		int equipmentType;
		int numOfMinutes;
		int choice;
		boolean loop = true;
		
		
		
		for (int x=0;x<rental.length;x++)
		{
			/*
			Ask user to input values for each rentals
			*/
			do
			{
				System.out.println("Please enter the contract number for Rental: ");
				String contractNum = scanner.nextLine();
				
				do 
				{
					System.out.println("Please enter the number of minutes for Rental: ");
					numOfMinutes=scanner2.nextInt();
					
					if(numOfMinutes<60||numOfMinutes>7200)
					{
						System.out.println("\n\n[ERROR!!!]Number of minutes must be between 60-7200\n");
					}
				}while(numOfMinutes<60||numOfMinutes>7200);
				
				
				System.out.println("Please enter the phone number: ");
				phoneNum= scanner3.nextLine();

				System.out.println("\nPlease enter the equipment type of the RENTAL {1: personal watercraft, 2: pontoon boat, 3: rowboat, 4: canoe, 5: kayak, 6: beach chair, 7: umbrella, 8: other}: ");
				equipmentType = scanner4.nextInt();
				
				
					/*
					store all the values in each object
					*/
					rental[x]=new Rental(contractNum,numOfMinutes,phoneNum,equipmentType);
			
			}while(numOfMinutes<60||numOfMinutes>7200);
		}
		
		
		/*
		print all details for each object
		*/
		
		printAllObjects(rental);
		
		
		/*
		-do while loop so I can get the users input on what type of sorting they want
		-used method for each sorting methods so the program is easy to understand
		*/
		
		do
		{
			System.out.println("\n0. Exit\r\n"
					+ "1. Sort by contract number \r\n"
					+ "2. Sort by price\r\n"
					+ "3. Sort by equipment type");
			
			
			choice = scanner.nextInt();
			
	
			
			switch(choice)
			{
			case 0:
				loop= false;
				break;
			case 1:
				sortContractNumber(rental);
				printAllObjects(rental);
				break;
			case 2:
				sortPriceNumber(rental);
				printAllObjects(rental);
				break;
			case 3:
				sortEquipmentType(rental);
				printAllObjects(rental);
				break;
		
			default:	
				System.out.println("\n\n[ERROR] Please enter a valid number!!! ");
				break;
			}
			
			
		
		}while (loop);
		
		scanner.close();
		scanner2.close();
		scanner3.close();
		scanner4.close();
		scanner5.close();
		
		
	
	
	}
	 				
	public static void rentalDetails(Rental r)
	{
		
		/*
		this is a method to print all the details of the rentals
	
		get all the values using the get method from the class of Rentals()
		*/
		System.out.println("\nContract number: "+r.getContractNumber()
		+"\nPhone Number: "+r.getPhoneNum()
		+"\nEquipment Name: "+r.getEquipmentType()
		+"\nRental time: "+r.getrentalHours() + " hours and "+ r.getnumberOfMinutes()%Rental.MINUTES + " minutes"
		+"\nTotal rent: $"+r.getPrice());
		
	}
	public static void printAllObjects(Rental [] r)
	{
		sammysBanner(); 
		/*
		print all the objects
		*/
		for(int i=0;i<r.length;i++)
		{
			rentalDetails(r[i]);
			System.out.println();
		}
	}
	public static void sammysBanner()
	{
		/*
		print the banner
		*/
		System.out.println();
		for(int i=0;i<36;i++)
		{
			System.out.print("S");
		}
		System.out.println("\nS Sammy's makes it fun in the sun. S");
		for(int i=0;i<36;i++)
		{
			System.out.print("S");
		}
		System.out.println();
	}
	public static void sortContractNumber(Rental [] r)
	{
		int returnNum;
		/*
		sort the contract number
		*/
		Rental temp =r[0];
		for (int i = 0; i < r.length; i++) 
		 {
			 for (int j = 0; j < r.length; j++) {
				 /*
					if return num is -1 then the index will swap, returnNum -1 means 1st obj is less than the obj we are comparing,
					if it is less then it will initiate a swap of index
				  */
				 returnNum=r[i].getContractNumber().compareTo(r[j].getContractNumber());
				 if(returnNum<0)
				 {
					 temp = r[i];
					 r[i] = r[j];
					 r[j] = temp;
				 }
			 }
		 }
	}
	public static void sortPriceNumber(Rental [] r)
	{
		/*
		sort the Price
		*/
		Rental temp =r[0];
		for (int i = 0; i < r.length; i++) 
		{
			for (int j = 0; j < r.length; j++) 
			{
				if(r[i].getPrice() < r[j].getPrice())
				{
					temp = r[i];
					r[i] = r[j];
					r[j] = temp;
				}
			}
		}
		
	}
	public static void sortEquipmentType(Rental [] r)
	{
		/*
		sort the equipment
		*/
		
		Rental temp =r[0];
		for (int i = 0; i < r.length; i++) 
		{
			for (int j = 0; j < r.length; j++) 
			{
				if(r[i].getEquipmentType().charAt(0) < r[j].getEquipmentType().charAt(0))
				{
					temp = r[i];
					r[i] = r[j];
					r[j] = temp;
				}
			}
		}
		
	}

}
