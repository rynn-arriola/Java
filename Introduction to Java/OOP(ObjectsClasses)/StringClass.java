import java.util.Arrays;

/*
(Implement the String class) The String class is provided in the Java library.
Provide your own implementation for the following methods (name the new
class MyString1):
public MyString1(char[] chars);
public char charAt(int index);
public int length();
public MyString1 substring(int begin, int end);
public MyString1 toLowerCase();
public boolean equals(MyString1 s);
public static MyString1 valueOf(int i);
*/

public class StringClass
{
	

	public static void main(String[] args) 
	{
		System.out.println(MyString1.valueOf(12345).charAt(0));
		System.out.println(MyString1.valueOf(12345).length());
		

	}

}
class MyString1
{
	private char[] chars;
	
	public MyString1(char[] chars)
	{
		this.chars= new char[chars.length];
		System.arraycopy(chars, 0, this.chars, 0, chars.length);
	}
	public char charAt(int index)
	{
		return chars[index];
	}
	public int length()
	{
		return chars.length;
	}
	public MyString1 substring(int begin,int end)
	{
		char[] tempChar= new char[end-begin];
		
		for(int i=begin;i<end;i++)
			tempChar[i-begin]=chars[i];
		
		return new MyString1(tempChar);
	}
	public MyString1 toLowerCase()
	{
		char[] tempChar= new char[chars.length];
		
		for(int i=0;i<chars.length;i++)
			tempChar[i]=Character.toLowerCase(chars[i]);
		
		return new MyString1(tempChar);
	}
	public boolean equals(MyString1 s)
	{
		return Arrays.equals(s.chars,chars);
		
		/*
		if(s.chars.length != chars.length)
			return false;
		
		for(int i=0;i<chars.length;i++)		//long method 
		if(s.chars[i]!=chars[i])
			return false;
		
		return true;
		*/	
	}
	public static MyString1 valueOf(int i)
	{
		char[] temp= new char[40];
		int size=0;
		
		while(i!=0)
		{
			int number =i%10;
			i/=10;
			
			temp[size]=(char)(number+'0');
			size++;
		}
		char[] temp2= new char[size];
		
		for(int k=size-1;k>=0;k--)
			temp2[k]=temp[size-k-1];
		
		return new MyString1(temp2);
	}
}

