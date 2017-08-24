
import java.util.ArrayList;
import java.util.Random;

public class Unit2_Exercise11_12 
{
	
	
	/** Main method */
	public static void main(String[] args) {

		Random rand=new Random();
	

	
		ArrayList<Double> list = new ArrayList<Double>();


		System.out.println("Add 10 Random Numbers ");
		for (int i = 0; i < 10; i++) {
			
			list.add((double) rand.nextInt(6));
			System.out.println(	list.get(i));
		}
		

		System.out.println("Sum of list: " + sum(list));
	}

	/** Returns the sum of all numbers in an ArrayList */
	public static double sum(ArrayList<Double> list) {
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}
}