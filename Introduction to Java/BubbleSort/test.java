package BubbleSort;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		
		
		Event [] event =new Event[8];
		
		event[0]=new Event("a222",30,"3024651640",1);
		
		event[1]=new Event("a111",30,"3024651640",1);
		
		event[2]=new Event("a100",30,"3024651640",1);
		
		event[3]=new Event("a113",30,"3024651640",1);
		
		event[4]=new Event("a123",30,"3024651640",1);
		
		event[5]=new Event("b101",30,"3024651640",1);
		event[6]=new Event("b123",30,"3024651640",1);
		event[7]=new Event("a123",30,"3024651640",1);
	
		
		
		int choice;
		
		
		Scanner scanner = new Scanner(System.in);
		
		carlysBanner(); 
		printAllObjects(event);
		do
		{
			System.out.println("\n0. Exit\r\n"
					+ "1. Sort by event number\r\n"
					+ "2. Sort by number of guests\r\n"
					+ "3. Sort by event type");
			
			
			choice = scanner.nextInt();
			
			carlysBanner(); 
	
			switch(choice)
			{
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
			}
			
			if(choice<0||choice>=4)
			{
				System.out.println("\n\n[ERROR] Please enter a valid number!!! ");
			}
		
		}while (choice>0||choice<=4);
		
		
		//rentalDetails(rental);
	
		
		
		scanner.close();
	}
	public static void eventDetails(Event e)
	{
		
		/*
		this is a method to print all the details of the event
		*/
		
		/*
		get all the values using the get method from the class of Events()
		*/
		if(e.isLargeEvent()==true)
			System.out.println("\nEVENT DETAILS"
					+"\nEvent Type: "+e.getEventType()
					+"\nEvent Number: "+e.getEventNumber()
					+"\nNumber of Guest: "+e.getNumOfGuest()
					+"\nPhone Number: "+e.getPhoneNum()
					+"\nThis is a large event. Price per Guest:"+e.getPricePerGuest()
					+"\nTotal Price: "+e.getPrice());
		else
			System.out.println("\nEVENT DETAILS"
					+"\nEvent Type: "+e.getEventType()
					+"\nEvent Number: "+e.getEventNumber()
					+"\nNumber of Guest: "+e.getNumOfGuest()
					+"\nPhone Number: "+e.getPhoneNum()
					+"\nThis is a small eventt. Price per Guest:"+e.getPricePerGuest()
					+"\nTotal Price: "+e.getPrice());
			
	}
	
	
	
	public static void printAllObjects(Event [] e)
	{
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
