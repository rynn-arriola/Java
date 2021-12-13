/*
		RYNN ARRIOLA
		UNIT 9 CASE PROBLEM PART 2
*/

package BubbleSort;

public class Rental
{

	public final static int MINUTES= 60;
	public final static int RENTAL_RATE= 40;
	
	private int rentalHours;
	private int numOfMinutes;
	private int price;
	private String contractNumber;
	private String phoneNum;
	private int equipmentType;
	final String [] equipmentTypeOption = {"personal watercraft","pontoon boat","rowboat","canoe","kayak","beach chair","umbrella","other"};
	
	public Rental(String contractNumber,int numOfMinutes)
	{
		setContractNumber(contractNumber);
		setHoursandMinutes(numOfMinutes);
		
	}
	public Rental(String contractNumber,int numOfMinutes,String phoneNum, int equipmentType)
	{
		setContractNumber(contractNumber);
		setHoursandMinutes(numOfMinutes);
		setPhoneNum(phoneNum);
		setEquipmentType(equipmentType);
	}
	public Rental()
	{
		this("A000",0);
	}
	
	public void setEquipmentType( int equipmentType)
	{
		
		/*
		 If the equipment type is less that 0 or greater the the size of the event type array it will return other
		 otherwise it will return the input value
		*/
		if(equipmentType<=0 ||equipmentType>=equipmentTypeOption.length)
		{
			this.equipmentType= equipmentTypeOption.length-1;
		}
		else
		{
			this.equipmentType=equipmentType-1;
		}
	}
	
	public void setContractNumber(String contractNumber)
	{
char ch1 = contractNumber.charAt(0);
		
		if(contractNumber.length()!=4 ||!Character.isLetter(ch1))
		{
			this.contractNumber="A000";
		}
		else
		{
			char ch2,ch3,ch4;
		
			ch2 = contractNumber.charAt(1);
			ch3 = contractNumber.charAt(2);
			ch4 = contractNumber.charAt(3);
		
		
			if(contractNumber.length()== 4 && Character.isLetter(ch1)&&Character.isDigit(ch2)&&Character.isDigit(ch3)&&Character.isDigit(ch4))
			{
				this.contractNumber=contractNumber.toUpperCase();
			}
			else
			{
				this.contractNumber="A000";
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
	public void setHoursandMinutes(int numOfMinutes)
	{
		this.numOfMinutes=numOfMinutes;
		
		calculate(numOfMinutes);
	}
	public String getContractNumber()
	{
		return contractNumber;	
	}
	public int getrentalHours()
	{
		return rentalHours;	
	}
	public int getnumberOfMinutes()
	{
		return numOfMinutes;	
	}
	public int getPrice()
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
	public double calculate(int numOfMinutes)
	{
		int additionalMinutes;
			
			rentalHours = numOfMinutes/MINUTES;
			additionalMinutes = numOfMinutes%MINUTES;
			
			if(additionalMinutes>=40)
			{ 
				price = (rentalHours+1)*RENTAL_RATE;
			}
			else
			{
				price = rentalHours*RENTAL_RATE + additionalMinutes;	
			}
			
			return price;
	}
	/*
	  This will return the value of the rental type, we use the integer for rental type to be the index 
	  so we can get the actual value and not the index
	*/
	public String getEquipmentType()
	{
		return equipmentTypeOption[equipmentType];
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
