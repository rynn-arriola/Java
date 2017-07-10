import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;



/*
 * (Compare loans with various interest rates) Rewrite Programming Exercise
5.21 to create a GUI, as shown in Figure 16.41b. Your program should let the
user enter the loan amount and loan period in the number of years from text
fields, and it should display the monthly and total payments for each interest
rate starting from 5 percent to 8 percent, with increments of one-eighth, in a
text area.
 */


public class LoanTable16_13 extends Application
{
	TextField LoanAmount=new TextField();
	TextField NumOfYears=new TextField();
	TextArea  Table= new TextArea();

	public static void main(String[] args) 
	{
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		
		Button button=new Button("Show Table");
		
		HBox hbox=new HBox(10);
		
		
		
		Label LoanLabel=new Label("Loan Amount", LoanAmount);
		LoanLabel.setContentDisplay(ContentDisplay.RIGHT);
		
		Label YearsLabel= new Label("Number of Years", NumOfYears);
		YearsLabel.setContentDisplay(ContentDisplay.RIGHT);
		
		button.setOnAction(e->{printTable();});
		
		hbox.getChildren().addAll(LoanLabel,YearsLabel,button);
		
		BorderPane MainPane= new BorderPane();
		MainPane.setCenter(Table);
		MainPane.setTop(hbox);
		
		
		
		Scene scene = new Scene(MainPane);
		primaryStage.setTitle("Exercise_16_13"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
		
	}
	private void printTable()
	{
		
		double monthlyPayment;
		double monthlyInterest;
		double totalPayment;
		
		
		double loan_amount= Double.parseDouble(LoanAmount.getText());
		double num_years= Double.parseDouble(NumOfYears.getText());
		
		String table=String.format("%-1s%20s%20s\n", "Interest Rate","Monthly Payment", "Total Payment");
		
		for(double interestRate=5;interestRate<=8;interestRate+=0.125)
		{
			monthlyInterest=interestRate/1200;
			
			monthlyPayment= loan_amount*(monthlyInterest/(1 - 1 / Math.pow(1 + monthlyInterest, num_years * 12)));
			
			totalPayment=monthlyPayment*num_years*12;
		
			String s="";
			table+= String.format("%-1.3f%s%23.2f%34.2f \n", interestRate,s,monthlyPayment,totalPayment);
		}
		Table.setText(table);
		
	}

}
