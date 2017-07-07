import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;




public class FourCards15_1 extends Application 
{
	
	static ArrayList<Integer> deck = new ArrayList<>();
	static int [] fourNums= new int[4];
	 
	
	
	public static void main(String[] args) 
	{
		store52Numbers();
		
		Collections.shuffle(deck);
		
		threeRandomNums(fourNums);
			
		Application.launch(args);

	}
	@Override
	public void start(Stage stage) throws Exception 
	{
		
		HBox hbox=new HBox(7); 				//spacing (7)
		VBox vbox=new VBox(4);				//spacing(7)
		
		Button button=new Button("Refresh");
		button.setPrefHeight(30);	 			//height of the button container
		button.setPrefWidth(100);    			//width of the button container
		
		
		hbox.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		
		
		
		
		
		
		for (int i=0;i<fourNums.length;i++)
		{
			Image card= new Image("image/cards/"+ (fourNums[i])+".GIF");
			hbox.getChildren().add(new ImageView(card));
			
		}
		button.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent event)
					{
						for (int i=0;i<fourNums.length;i++)
						{
							Image card= new Image("image/cards/"+ (fourNums[i])+".GIF");
							hbox.getChildren().add(new ImageView(card));
							
						}
						
					}
			
				});
		
		Scene scene= new Scene(vbox,320,150);
		stage.setScene(scene);
		stage.setTitle("Random Cards");
		stage.show();
		
		vbox.getChildren().addAll(hbox,button);
		
	}
	public static void store52Numbers()
	{
		for(int i=0;i<=52;i++)
		{
			deck.add(i);
			
		}
	}
	
	public static void threeRandomNums(int [] fourNums)
	{
		Random rand= new Random();
		
		int num ;
		
		for(int i=0;i<fourNums.length;i++)
		{
			
			num=rand.nextInt(deck.size());	
			
				fourNums[i]=deck.get(num);		//the 3 nums that u generate here, its going to be pass on the deck.
			
		
		}
	}
	
	

}