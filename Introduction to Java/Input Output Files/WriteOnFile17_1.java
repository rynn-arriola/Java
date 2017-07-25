import java.io.*;
import java.util.*;

/*
 * (Create a text file) Write a program to create a file named Exercise17_01.txt if  
 * it does not exist. Append new data to it if it already exists. Write 100 integers 
 * created randomly into the file using text I/O. Integers are separated by a space. 
 * 
 */


public class WriteOnFile17_1
{

	public static void main(String[] args) throws IOException 
	{
		File file = new File("Exercise17_01.txt");
		if (!file.exists())
		{
			System.out.println("File does not exist, generating file...");
			file.createNewFile();
		}
		
		
		
		
		try (FileOutputStream output = new FileOutputStream(file))
		{
			System.out.println("Genererating 100 integers");
			
			Random rand = new Random();
		
			for (int i = 1; i <= 100; i++)
			{
				if (i % 10 == 0)
					output.write((String.valueOf(rand.nextInt(100)) + "\n").getBytes());
				else
					output.write((String.valueOf(rand.nextInt(100)) + " ").getBytes());
			}
		}

	}

}
