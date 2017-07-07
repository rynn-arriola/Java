import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SineCosineFunction extends Application
{

    public static void main(String[] args)
    {

        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
    	Pane pane=new Pane();
    	
    	
    	 // {"-3\u03c0", "-2\u03c0", "-\u03c0", "0" , "\u03c0", "2\u03c0", "3\u03c0"};
    	//image for PI's	
    	
         Polyline polyline1 = new Polyline();
         polyline1.setStroke(Color.RED);
         
         
         ObservableList<Double> list = polyline1.getPoints();
        
         for (int x = -170; x <= 170; x++) {
             list.add((double) (x + 200));
             double y = 100 - 50 * Math.sin((x / 100.0) * 2 * Math.PI);
             list.add(y);

             

         }
         Polyline polyline2 = new Polyline();
         polyline2.setStroke(Color.BLUE);
         ObservableList<Double> list2 = polyline2.getPoints();
         
         for (int x = -170; x <= 170; x++) {
             list2.add((double) (x + 200));
             list2.add(100 - 50 * Math.cos((x / 100.0) * 2 * Math.PI));

         }
         Text Text3=new Text(40,115,"-3\u03c0");
         Text Text2=new Text(90,115,"-2\u03c0");
         Text Text1=new Text(145,115,"-\u03c0");
         Text Text0=new Text(200,115,"0");
         Text Text4=new Text(250,115,"\u03c0");
         Text Text5=new Text(305,115,"2\u03c0");
         Text Text6=new Text(350,115,"3\u03c0");
    	 
    	 
    	 // Draw x-axis 
        Line line1 = new Line(10, 100, 390, 100);
        Line line2 = new Line(390, 100, 370, 90);
        Line line3 = new Line(390, 100, 370, 110);

        // Draw y-axis
        Line line4 = new Line(200, 10, 200, 200);
        Line line5 = new Line(200, 10, 190, 30);
        Line line6 = new Line(200, 10, 210, 30);

        // Draw x, y axis labels
        Text textX = new Text(380, 70, "X");
        Text textY = new Text(220, 20, "Y");    
        
       
        pane.getChildren().addAll
        						(
        							line1,line2,line3,
        							textX,textY,
        							line4,line5,line6,
        							polyline1,polyline2,
        							Text0,Text2,Text1,Text3,Text4,Text5,Text6
        						);
    	
    	
    	Scene scene = new Scene(pane, 450, 200);           
        primaryStage.setTitle("Exercise14_9"); // Set the window title
        primaryStage.setScene(scene); // Place the scene in the window
        primaryStage.show(); // Display the window

    }

   

}