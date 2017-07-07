
/*(Implement the String class) The String class is provided in the Java library.
Provide your own implementation for the following methods (name the new
class MyString2):
public MyString2(String s);
public int compare(String s);
public MyString2 substring(int begin);
public MyString2 toUpperCase();
public char[] toChars();
public static MyString2 valueOf(boolean b);
*/

public class MyStringClass2 {

	public static void main(String[] args) 
	{
		MyString2 str= new MyString2("Hello World");
		
		str.toUpperCase();
		str=str.substring(2);
		System.out.println(str.getString());
		System.out.print(str.compare("hello"));

	}

}
class MyString2
{
	public String s;
	
	public MyString2(String s)
	{
		this.s=s;
	}
	public int compare (String s)
	{
		for(int i=0; i<s.length();i++)
			
			if(this.s.charAt(i)!=s.charAt(i))
				if(this.s.charAt(i)>s.charAt(i))
				return 1;
			else
				return-1;
		
		return 0;
		
	}
	public MyString2 substring(int begin)
	{
		String temp="";
		
		for (int i=begin;i<s.length();i++)
			temp+=s.charAt(i);
		
		return new MyString2(temp);
	}
	public MyString2 toUpperCase()
	{
		s=s.toUpperCase();
		
		return new MyString2(s);
	}
	public char[] toChars()
	{
		char[] temp=new char[s.length()];
		
		for(int i=0;i<s.length();i++)
			temp[i]=s.charAt(i);
		
		return temp;
	}
	public static MyString2 valueOf(boolean b)
	{
		return new MyString2((b)? "true":"false");
	}
	public String getString()
	{
		return s;
	}
}
