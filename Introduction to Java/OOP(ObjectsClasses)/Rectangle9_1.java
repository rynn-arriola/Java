/*(The Rectangle class) Following the example of the Circle class in Section 9.2,
design a class named Rectangle to represent a rectangle. The class contains:
- Two double data fields named width and height that specify the width and
height of the rectangle. The default values are 1 for both width and height.
- A no-arg constructor that creates a default rectangle.
- A constructor that creates a rectangle with the specified width and height.
- A method named getArea() that returns the area of this rectangle.
- A method named getPerimeter() that returns the perimeter.
Draw the UML diagram for the class and then implement the class. Write a test
program that creates two Rectangle objects—one with width 4 and height 40
and the other with width 3.5 and height 35.9. Display the width, height, area,
and perimeter of each rectangle in this order.*/

public class Rectangle9_1
{
	public static void main(String[]args)
	{
		Rectangle rectangle1= new Rectangle();
		Rectangle []rectangleTest= new Rectangle[2];
		rectangleTest[0]=new Rectangle(4,40);
		rectangleTest[1]=new Rectangle(3.5,35.9);
		
		System.out.println("\n Width= "+rectangle1.width
				+"\n Height= "+rectangle1.height
				+"\n Area= "+rectangle1.getArea()
				+"\n Perimeter= "+rectangle1.getPerimeter()+"\n");
		
		for(int i=0;i<2;i++)
		{
			System.out.println("Rectangle TEST " + (i+1) +":");
            System.out.print("Area = " + rectangleTest[i].getArea());
            System.out.println(" Perimeter = " +  rectangleTest[i].getPerimeter() +"\n");
			
		}
	}
		
}
//define the class with two constructors
class Rectangle
{
	double width;
	double height;
	
	
	Rectangle () //no arg constructor
	{
		width=1;
		height=1;
	}
	Rectangle(double width, double height) //second constructor
	{
		this.width=width;
		this.height=height;
	}
	double getArea()			//get area
	{
		return(width*height);
	}
	double getPerimeter()		//get perimeter
	{
		return(2*(width+height));
	}
	
}