import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Swap2ShapesPosition extends Application
{
	static PathTransition path= new PathTransition();
	static PathTransition path1= new PathTransition();
	
    public static void main(String[] args)
    {

        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
    	Pane pane=new Pane();
    	
    	BorderPane MainPane=new BorderPane();
    	
       
       Line line =new Line();
       Line line1 =new Line();
       
       Button button=new Button("Switch");
       
      
       
       line.setStartX(100);
       line.setStartY(100);
       line.setEndX(300);
       line.setEndY(100);
       
       line1.setStartX(200);
       line1.setStartY(100);
       line1.setEndX(390);
       line1.setEndY(100);
       
       Ellipse circle = new Ellipse(); 
       circle.setCenterX(320);
       circle.setCenterY(100);		
       circle.setRadiusX(80);
       circle.setRadiusY(80);
       circle.setFill(Color.RED);
       
       path.setNode(circle);		
       path.setPath(line);					
       path.setDuration(Duration.millis(1));			
       path.setCycleCount(1);
       
     path.play();
       
       
       Ellipse circle1 = new Ellipse();
       circle1.setCenterX(120);
       circle1.setCenterY(100);
       circle1.setRadiusX(120);
       circle1.setRadiusY(70);
       circle1.setFill(Color.BLUE);
       
       path1.setNode(circle1);		
       path1.setPath(line);					
       path1.setDuration(Duration.millis(1));			
       path1.setCycleCount(1);	
       path1.setRate(-1);
       
       path1.play();
       
       
       button.setOnAction(e-> 
       
       {
       		
       		path.play();
       		path1.play();
       		path.setRate(reverse(1));
       		path1.setRate(reverse(1));
       		
       		
       });
      
       
        

      
        
       
        pane.getChildren().addAll
        						(line,circle,circle1);
        
        MainPane.setCenter(pane);
        MainPane.setBottom(button);
        BorderPane.setAlignment(button, Pos.CENTER);
        BorderPane.setMargin(pane, new Insets(40,40,40,40));
    	
    	Scene scene = new Scene(MainPane, 450, 300);           
        primaryStage.setTitle("Switch Shapes"); // Set the window title
        primaryStage.setScene(scene); // Place the scene in the window
        primaryStage.show(); // Display the window

    }
    public static double reverse(double num)
	{
		 double value = path.getRate();
		
		num=value*=-1;
		
		return num;
	}
   
    

   

}