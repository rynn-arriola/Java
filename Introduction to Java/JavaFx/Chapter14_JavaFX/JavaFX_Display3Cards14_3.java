import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.geometry.Pos;

/*
 (Display three cards) Write a program that displays three cards randomly
selected from a deck of 52, as shown in Figure 14.43c. The card image files
are named 1.png, 2.png, …, 52.png and stored in the image/card directory.
All three cards are distinct and selected randomly. Hint: You can select random
cards by storing the numbers 1–52 to an array list, perform a random shuffle
introduced in Section 11.12, and use the first three numbers in the array list as
the file names for the image.
*/


public class JavaFX_Display3Cards14_3 extends Application
{
	
	static ArrayList<Integer> deck = new ArrayList<>();
	static int [] threeNums= new int[3];
	 
	
	
	public static void main(String[] args) 
	{
		store52Numbers();
		
		Collections.shuffle(deck);
		
		threeRandomNums(threeNums);
		
		display(threeNums);
		
		Application.launch(args);

	}
	@Override
	public void start(Stage stage) throws Exception 
	{
		
		Pane hbox=new HBox(7);
		((HBox) hbox).setAlignment(Pos.CENTER);
		
		
		for (int i=0;i<threeNums.length;i++)
		{
			Image card= new Image("image/cards/"+ (threeNums[i])+".GIF");
			hbox.getChildren().add(new ImageView(card));
			
		}
		Scene scene= new Scene(hbox, 238, 100);
		stage.setScene(scene);
		stage.setTitle("Random Cards");
		stage.show();
		
		
	}
	public static void display(int[] threeNums)
	{
		for(int i=0;i<threeNums.length;i++)
		{
			System.out.print(threeNums[i]+" ");
		}
	}
	
	public static void store52Numbers()
	{
		for(int i=0;i<=52;i++)
		{
			deck.add(i);
			
		}
	}
	
	public static void threeRandomNums(int [] threeNums)
	{
		Random rand= new Random();
		
		int num ;
		
		for(int i=0;i<threeNums.length;i++)
		{
			
			num=rand.nextInt(deck.size());	
			
				threeNums[i]=deck.get(num);		//the 3 nums that u generate here, its going to be pass on the deck.
			
		
		}
	}
	
	

}