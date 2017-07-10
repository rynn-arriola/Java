import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class Color_Slider16_17 extends Application
{
	Text text=new Text("Show Colors");
	Slider RedSlider=new Slider();
	Slider GreenSlider= new Slider();
	Slider BlueSlider= new Slider();
	Slider OpacitySlider=new Slider();

	public static void main(String[] args) 
	{
		
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		
		HBox textPane=new HBox(text);
		textPane.setAlignment(Pos.CENTER);
		text.setStyle("-fx-font-weight: bold");
		
		GridPane gPane=new GridPane();
		gPane.setAlignment(Pos.CENTER);
		gPane.setVgap(5);
		gPane.setHgap(5);
		
		
		Label RedLabel=new Label("Red");
		Label GreenLabel=new Label("Green");
		Label BlueLabel= new Label("Blue");
		Label OpacityLabel=new Label("Opacity");

		
		RedSlider.setMin(0.0);
		RedSlider.setMax(1.0);
		GreenSlider.setMin(0.0);
		GreenSlider.setMax(1.0);
		BlueSlider.setMin(0.0);
		BlueSlider.setMax(1.0);
		OpacitySlider.setMin(0.0);
		OpacitySlider.setMax(1.0);
		
		gPane.add(RedLabel,0,1);
		gPane.add(GreenLabel, 0, 2);
		gPane.add(BlueLabel, 0, 3);
		gPane.add(OpacityLabel, 0, 4);
		
		gPane.add(RedSlider, 1, 1);
		gPane.add(GreenSlider, 1, 2);
		gPane.add(BlueSlider, 1, 3);
		gPane.add(OpacitySlider, 1, 4);
		
		RedSlider.valueProperty().addListener(	e	->	Colors());
		GreenSlider.valueProperty().addListener(e	->	Colors());
		BlueSlider.valueProperty().addListener(	e	->	Colors());
		OpacitySlider.valueProperty().addListener(	e	->	Colors());
		OpacitySlider.setValue(1);
		
		
		
		BorderPane MainPane= new BorderPane();
		MainPane.setCenter(gPane);
		MainPane.setTop(textPane);
		BorderPane.setMargin(textPane, new Insets(30,20,20,20));
		MainPane.setPrefSize(250, 170);
		
		Scene scene = new Scene(MainPane);
		primaryStage.setTitle("Exercise_16_17");
		primaryStage.setScene(scene);
		primaryStage.show(); 
	}
	private void Colors()
	{
		text.setFill(new Color
				(
				RedSlider.getValue(),
				GreenSlider.getValue(),
				BlueSlider.getValue(), 
				OpacitySlider.getValue())
				);
	}

}
