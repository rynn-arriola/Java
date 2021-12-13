/*
Rynn Arriola
Unit 9 Part 1		
*/

package BubbleSort;


public class Event 
{
	public final static int LOW_PRICE= 32;
	public final static int REGULAR_PRICE= 35;
	public final static int CUT_OFF= 50;
	
	private String eventNumber;
	private int numberOf_guest;
	private double price;
	private double pricePerGuest;
	private String phoneNum;
	private int eventType;
	final String eventTypeOption []= {"wedding","baptism","birthday","corporate","other"};
	
	public Event(String eventNumber,int numberOf_guest)
	{
		setEventNumber(eventNumber);
		setNumOfGuest(numberOf_guest);
		
	}
	/*
	Overloaded the constructor so I can easily store the field values by just passing the arguments
	*/
	public Event(String eventNumber,int numberOf_guest, String phoneNum, int eventType)
	{
		setEventNumber(eventNumber);
		setNumOfGuest(numberOf_guest);
		setPhoneNum(phoneNum);
		setEventType(eventType);
	}
	public Event(String eventNumber,int numberOf_guest, int eventType)
	{
		setEventNumber(eventNumber);
		setNumOfGuest(numberOf_guest);
		setEventType(eventType);
	}
	/*
	Default constructor
	*/
	public Event()
	{
		this("A000",0);
	}
	
	public void setEventType( int eventType)
	{
		
		/*
		 If the event type is less that 0 or greater the the size of the event type array it will return other
		 otherwise it will return the input value
		*/
		if(eventType<=0 ||eventType>=eventTypeOption.length)
		{
			this.eventType= eventTypeOption.length-1;
		}
		else
		{
			this.eventType=eventType-1;
		}
	}
	public void setEventNumber(String eventNumber)
	{
		char ch1 = eventNumber.charAt(0);
		
		if(eventNumber.length()!=4 ||!Character.isLetter(ch1))
		{
			this.eventNumber="A000";
			
		}
		else
		{
	
			char ch2,ch3,ch4;
		
			ch2 = eventNumber.charAt(1);
			ch3 = eventNumber.charAt(2);
			ch4 = eventNumber.charAt(3);
		
		
			if(eventNumber.length()== 4 && Character.isLetter(ch1)&&Character.isDigit(ch2)&&Character.isDigit(ch3)&&Character.isDigit(ch4))
			{
				this.eventNumber=eventNumber.toUpperCase();
			}
			else
			{
				this.eventNumber="A000";
			}
		
		}
		
	}
	public void setPhoneNum(String phoneNum)
	{
		phoneNum=getOnlyDigits(phoneNum);
		
		if(phoneNum.length()==10)
		{
				this.phoneNum=phoneNum;	
		}
		else
		{
			this.phoneNum="0000000000";
		}
	}
	public void setNumOfGuest(int numberOf_guest)
	{
		this.numberOf_guest=numberOf_guest;
		
		if(isLargeEvent())
		{
			pricePerGuest=LOW_PRICE;
			price=numberOf_guest*pricePerGuest;
		}
		else
		{
			pricePerGuest=REGULAR_PRICE;
			price=numberOf_guest*pricePerGuest;
		}
	}
		
	public String getEventNumber()
	{
		return eventNumber;
	}
	/*
	  This will return the value of the event type, we use the integer for event type to be the index 
	  so we can get the actual value and not the index
	*/
	public String getEventType()
	{
		return eventTypeOption[eventType];
	}
	
	public int getNumOfGuest()
	{
		return numberOf_guest;	
	}
	public double getPrice()
	{
		return price;
	}
	public String getPhoneNum()
	{
		String phone;
		String start= "(" + phoneNum.substring(0,3)+") ";
		String mid= phoneNum.substring(3,6)+"-";
		String end= phoneNum.substring(6,10);
		
		phone= start + mid + end;
		
		return phone;
	}
	public double getPricePerGuest()
	{
		return pricePerGuest;
	}
	public boolean isLargeEvent()
	{
		if(getNumOfGuest()>=50)
		
			return true;
		else
			return false;	
	}
	private String getOnlyDigits(String phoneNum) 
	{
	    StringBuilder builder = new StringBuilder();
	    for (int i = 0; i < phoneNum.length(); i++) {
	        char ch = phoneNum.charAt(i);
	        if (Character.isDigit(ch)) {
	            builder.append(ch);
	        }
	    }
	    return builder.toString();
	}

}
