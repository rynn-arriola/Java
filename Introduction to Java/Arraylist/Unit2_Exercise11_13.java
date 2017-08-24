import java.util.Scanner;
import java.util.ArrayList;

public class Unit2_Exercise11_13 {
	/** Main method */
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner input = new Scanner(System.in);

		


		System.out.print("Enter 10 Numbers: ");
		for (int i = 0; i < 10; i++) 
		{
			list.add(input.nextInt());
		}

	
		removeDuplicate(list);

	
		System.out.print("The distinct integers are ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}

	
	public static void removeDuplicate(ArrayList<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) == list.get(j))
					list.remove(j);
			}
		}
	}
}