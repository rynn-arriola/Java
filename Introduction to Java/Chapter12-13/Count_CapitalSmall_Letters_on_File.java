import java.util.*;
import java.io.*;


public class Count_Letters_On_File 
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
		
		int []letterCount=new int[52];
		
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
				String fileLine=reader.nextLine();
				
				for(int i=0;i<fileLine.length();i++)
				{
					if(Character.isAlphabetic(fileLine.charAt(i)))
						
						if(fileLine.charAt(i)<=90)		//refer to the ASCII table
							
							letterCount[fileLine.charAt(i)-65]++;
						
						else if(fileLine.charAt(i)<=122)	
							
							letterCount[fileLine.charAt(i)-71]++;	
					
					/*-71 because 122-71+26 =97
					that means its gonna start on
					small letter "a" then end with small "z"*/
				}
			}
		}
		
	}
	public static void display(int[] letterCount)
	{
		for(int i=0;i<26;i++)
		{
			System.out.println((char)(i+'A')+"'s is: "+ letterCount[i]);
		}
		
		System.out.println();
		for(int i=26;i<52;i++)
		{
			System.out.println((char)(i+71)+"'s is: "+ letterCount[i]);
		}
	}

}
