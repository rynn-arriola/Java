import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/*
 * (Create a binary data file) Write a program to create a file named             
 * Exercise17_02.dat if it does not exist. Append new data to it if it already    
 * exists. Write 100 integers created randomly into the file using binary I/O.    
 * 
 */



public class WriteOnFile2 

{

	public static void main(String[] args) throws IOException 
	{

		File file = new File("Exercise17_02.dat");
		if (!file.exists())
		{
			System.out.println("File does not exist, generating file...");
			file.createNewFile();
		}
		
		try (FileOutputStream output = new FileOutputStream("Exercise17_02.dat", true))
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
