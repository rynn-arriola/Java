import java.util.*;
import java.io.*;


public class UNIT4_Exercise12_30
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner input= new Scanner(System.in);
		
		System.out.print("Enter The name of the file: ");
		
		File file=new File(input.nextLine());
		
		
		//check if file exist
		if (!file.exists()) {
			System.out.println("File " + file.getName() + " does not exist");
			System.exit(0);
		}
		
		int []letterCount=new int[26];
		
		countLetters(file, letterCount);
		display(letterCount);
		
		
		input.close();

	}
	public static void countLetters(File file, int[]letterCount)throws FileNotFoundException
	{
		try(Scanner reader=new Scanner(file)) //input the file that you're reading
		{
			while(reader.hasNextLine())			//it goes through the whole file
			{
				String fileLine=reader.nextLine().toUpperCase(); //convert ALL to UpperCase so u can count all Letters
				
				for(int i=0;i<fileLine.length();i++)
				{
					if(Character.isAlphabetic(fileLine.charAt(i)))
						
						if(fileLine.charAt(i)<=90)		//refer to the ASCII table
							
							letterCount[fileLine.charAt(i)-65]++;
						
				}
			}
		}
		
	}
	public static void display(int[] letterCount)
	{
		for(int i=0;i<26;i++)
		{
			System.out.println((char)(i+65)+"'s is: "+ letterCount[i]);
		}
		
	}

}
