import javafx.collections.ObservableList;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.geometry.Insets;


public class DisplayRunningFan15_28 extends Application {

	public static void main(String[] args)
	{
		Application.launch(args);
	}
	@Override 
	public void start(Stage primaryStage) {
		FanPane fanPane = new FanPane();
		
		
		Button Pause = new Button("Pause");
		Button Resume = new Button("Resume");
		Button Reverse = new Button("Reverse");
		HBox hBox = new HBox(5);
		hBox.setAlignment(Pos.CENTER);
		

		
		hBox.getChildren().addAll(Pause, Resume, Reverse);


		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(fanPane);
		borderPane.setPrefSize(250, 250);
		BorderPane.setMargin(fanPane, new Insets(20,20,20,20));
		borderPane.setBottom(hBox);

		Pause.setOnAction(e -> 
		{
			fanPane.pause();
		});

		Resume.setOnAction(e ->
		{
			fanPane.play();
		});

		Reverse.setOnAction(e -> 
		{
			fanPane.reverse();
		});

		
		Scene scene = new Scene(borderPane);
		primaryStage.setTitle("Exercise_15_28"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
		
		fanPane.requestFocus();
	}

}
class FanPane extends Pane
{
	private double startAngle=15;
	private Arc[] blades=new Arc[4];
	private double angle=30;
	private Timeline fan;
	
	
	public FanPane()
	{
		
		
		KeyFrame keyFrame = new KeyFrame(Duration.millis(10), e-> spin());
		fan=new Timeline(keyFrame);
		fan.setCycleCount(Timeline.INDEFINITE);
		fan.play(); // Start animation
		
		
		Circle c = new Circle();
		c.setRadius(100);
		c.setCenterX(100);
		c.setCenterY(100);
		c.setStroke(Color.BLACK);
		c.setFill(Color.WHITE);

		for(int i=0;i<4;i++)
		{
			blades[i]=new Arc(100,100,90,90,angle+90,35);
			blades[i].setFill(Color.BLACK);
			blades[i].setType(ArcType.ROUND);
			angle+=90;
		}
		
		getChildren().addAll(c);
		getChildren().addAll(blades);	
	}
	private void spin()
	{
		for(int i=0;i<blades.length;i++)
		{
			Arc a=blades[i];
			a.setStartAngle(a.getStartAngle() + startAngle);
		}
	}
	
	public void pause() {
		fan.pause();
	}

	
	public void play() {
		fan.play();
	}

	
	protected void reverse() {
		startAngle *= -1;
	}
	
	
}