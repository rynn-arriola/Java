/*
Rynn Arriola
Unit 9 Part 1		
*/


package BubbleSort;
import java.util.Scanner;



public class EventDemo {

	public static void main(String[] args) {
		
		
		Event[] event=new Event[8]; 
		int guestNum;
		String eventNum;
		String phoneNum;
		int eventType;
		int choice;
		boolean loop= true;
	
		Scanner scanner=new Scanner(System.in);
		
		
		
		for(int x=0;x<event.length;x++)
		{	
			/*
			Ask user to input values for each events
			*/
			
			do
			{
				
				
				System.out.println("Please enter the event number for EVENT: ");
				eventNum = scanner.nextLine();
				
				do
				{
					
				System.out.println("Please enter the guest number: ");
				guestNum = Integer.parseInt(scanner.nextLine());
				if(guestNum<5||guestNum>100)
				{
					System.out.println("[ERROR!!!]Number of guest must be between 5-100\n");	
				}
				
				}while(guestNum<5||guestNum>100);
				
				System.out.println("Please enter the phone number: ");
				phoneNum= scanner.nextLine();
				
				System.out.println("Please enter the event type of the EVENT {1: wedding, 2: baptism, 3: birthday, 4: corporate, 5: other}: ");
				eventType = Integer.parseInt(scanner.nextLine());
				
				
					/*
					store all the values in each object
					*/
					event[x]=new Event(eventNum,guestNum,phoneNum,eventType);
				
				/*
				The program will ask the above question again if the condition is true
				*/
			}while(guestNum<5||guestNum>100);
			
		}
		
		/*
		Print all the details of each objects
		*/
	
		printAllObjects(event);
		
		/*
		-do while loop so I can get the users input on what type of sorting they want
		-used method for each sorting methods so the program is easy to understand
		*/
		
		do
		{
			System.out.println("\n0. Exit\r\n"
					+ "1. Sort by event number\r\n"
					+ "2. Sort by number of guests\r\n"
					+ "3. Sort by event type");
			
			
			choice = scanner.nextInt();
			
			
	
			switch(choice)
			{
			case 0:
					loop=false;
					break;
			case 1:
				 sortEventNumber(event);
				 printAllObjects(event);
				 break;
			case 2:
				sortGuestNumber(event);
				printAllObjects(event);
				break;
			case 3:
				sortEventType(event);
				printAllObjects(event);
				break;
			default:
				System.out.println("\n\n[ERROR] Please enter a valid number!!! ");
				break;
			}
			
			
		
		}while (loop);
		
		/*
		closed scanner
		*/
		scanner.close();
		
	}
	
	public static void eventDetails(Event e)
	{
		
		/*
		this is a method to print all the details of the event
		
		get all the values using the get method from the class of Events()
		*/
		if(e.isLargeEvent()==true)
			System.out.println("\nEVENT DETAILS"
					+"\nEvent Number: "+e.getEventNumber()
					+"\nPhone Number: "+e.getPhoneNum()
					+"\nEvent Type: "+e.getEventType()
					+"\nNumber of Guest: "+e.getNumOfGuest()
					+"\nThis is a large event. Price per Guest:"+e.getPricePerGuest()
					+"\nTotal Price: "+e.getPrice());
		else
			System.out.println("\nEVENT DETAILS"
					+"\nEvent Number: "+e.getEventNumber()
					+"\nPhone Number: "+e.getPhoneNum()
					+"\nEvent Type: "+e.getEventType()
					+"\nNumber of Guest: "+e.getNumOfGuest()
					+"\nThis is a small event. Price per Guest:"+e.getPricePerGuest()
					+"\nTotal Price: "+e.getPrice());
			
	}
	public static void printAllObjects(Event [] e)
	{
		carlysBanner(); 
		/*
		Print all the objects
		*/
		for(int i=0;i<e.length;i++)
		{
			eventDetails(e[i]);
			System.out.println();
		}
	}
	public static void sortEventNumber(Event [] event)
	{
		int returnNum;
		Event temp =event[0];
		for (int i = 0; i < event.length; i++) 
		 {
			 for (int j = 0; j < event.length; j++) {
				 
				 /*
					if return num is -1 then the index will swap, returnNum -1 means 1st obj is less than the obj we are comparing,
					if it is less then it will initiate a swap of index
				  */
				 returnNum= event[i].getEventNumber().compareTo(event[j].getEventNumber());
				 if(returnNum<0)
				 {
					 temp = event[i];
					 event[i] = event[j];
					 event[j] = temp;
				 }
			 }
		 }
	}
	public static void sortGuestNumber(Event [] e)
	{
		/*
		sort guest numbers of objects
		*/
		Event temp =e[0];
		for (int i = 0; i < e.length; i++) 
		{
			for (int j = 0; j < e.length; j++) 
			{
				if(e[i].getNumOfGuest() < e[j].getNumOfGuest())
				{
					temp = e[i];
					e[i] = e[j];
					e[j] = temp;
				}
			}
		}
		
	}
	public static void sortEventType(Event [] e)
	{
		/*
		sort event types numbers of objects
		*/
		Event temp =e[0];
		for (int i = 0; i < e.length; i++) 
		{
			for (int j = 0; j < e.length; j++) 
			{
				if(e[i].getEventType().charAt(0) < e[j].getEventType().charAt(0))
				{
					temp = e[i];
					e[i] = e[j];
					e[j] = temp;
				}
			}
		}
		
	}
	public static void carlysBanner()
	{
		/*
		print the banner
		*/
		System.out.println();
		for(int i=0;i<47;i++)
		{
			System.out.print("*");
		}
		System.out.println("\n*Carly's makes the food that makes it a party.*");
		for(int i=0;i<47;i++)
		{
			System.out.print("*");
		}
	}
	
	

}
