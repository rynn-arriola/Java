import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.animation.PathTransition;
import javafx.util.Duration;


public class Animation extends Application{

	
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		EllipsePane elPane= new EllipsePane();
		
		BorderPane MainPane=new BorderPane();
		
		HBox hbox=new HBox(5);
		
		hbox.setAlignment(Pos.CENTER);
		
		Button play=new Button("play");
		Button pause=new Button("pause");
		Button reverse= new Button("reverse");
		Button ellipse = new Button("ellipse");
		
		
        
         
         play.setOnAction(e-> elPane.play());
         pause.setOnAction(e->elPane.pause());
         reverse.setOnAction(e->elPane.reverse());
         
         ellipse.setOnAction(e->
         {
        	
         });
         
         
        hbox.getChildren().addAll(play,pause,reverse,ellipse); 
		
	
		
		MainPane.setCenter(elPane);
		MainPane.setBottom(hbox);
		
		
		Scene scene = new Scene(MainPane, 400,400);
		primaryStage.setTitle("Exercise_16_18"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
	
	
	
	
}class EllipsePane extends Pane
{
	
	PathTransition path = new PathTransition();
	public EllipsePane()
	{
		
				
		Ellipse c= new Ellipse();	
		c.setRadiusX(100);
		c.setRadiusY(100);
		c.setCenterX(1);
		c.setCenterY(1);
		c.setLayoutX(200);
		c.setLayoutY(200);
		c.setStroke(Color.BLACK);
		c.setFill(Color.LIGHTBLUE);
		
		Rectangle r =new Rectangle();
		
		r.setX(200);
		r.setY(200);
		r.setWidth(30);
		r.setHeight(10);
		
		
		path.setPath(c);
		path.setNode(r);
		path.setDuration(Duration.millis(4000));			
        path.setCycleCount(PathTransition.INDEFINITE);
		
        getChildren().addAll(c,r);
	}
	
	public void pause()
	{
		path.pause();
	}
	public void play()
	{
		path.play();
	}
	public void reverse()
	{
		 double value = path.getRate();
		
		double num=value*=-1;
		
		path.setRate(num);
	}
}


