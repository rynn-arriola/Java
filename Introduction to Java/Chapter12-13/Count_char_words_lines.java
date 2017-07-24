import java.util.*;
import java.io.*;

public class Count_char_words_lines
{

	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("Text_File");
		Scanner input= new Scanner(file);
		
		int characters= 0;
		int words= 0;
		int lines = 0;
		
		while(input.hasNext())
		{
			String s=input.nextLine();
			lines++;
			
			String[] split =s.split(" ");
			
			for(int i=0;i<split.length;i++)
			{
				if(split[i].length()==1)
				
					characters++;
					
				else
						words++;
			}
		}
		
		System.out.println(	"The file has \n "+
							"\nCharacters: "	+ characters+
							"\nWords: "			+ words+
							"\nLines: "			+lines);
		input.close();
	}

}
