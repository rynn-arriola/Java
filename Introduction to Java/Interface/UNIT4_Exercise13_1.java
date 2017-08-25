/*
 (Triangle class) Design a new Triangle class that extends the abstract
GeometricObject class. Draw the UML diagram for the classes Triangle
and GeometricObject and then implement the Triangle class. Write a test
program that prompts the user to enter three sides of the triangle, a color, and a
Boolean value to indicate whether the triangle is filled. The program should create
a Triangle object with these sides and set the color and filled properties using
the input. The program should display the area, perimeter, color, and true or false
to indicate whether it is filled or not.
 
 */

import java.util.Scanner;

public class UNIT4_Exercise13_1
{
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		
		System.out.print("Enter three sides of the triangle: ");
		double side1 = input.nextDouble();
		double side2 = input.nextDouble();
		double side3 = input.nextDouble();

		System.out.print("Enter a color: ");
		String color = input.next();

		System.out.print("Is the triangle filled (true / false)? ");
		boolean filled = input.nextBoolean();

		// Create a Triangle
		Triangle triangle = new Triangle(side1, side2, side3, color, filled);

		System.out.println(triangle);
	}
}


abstract class GeometricObject
{
	  private String color = "white";
	  private boolean filled;

	  /**Default construct*/
	  protected GeometricObject() {
	  }

	  /**Construct a geometric object*/
	  protected GeometricObject(String color, boolean filled) 
	  {
	    this.color = color;
	    this.filled = filled;
	  }

	  /**Getter method for color*/
	  public String getColor() {
	    return color;
	  }

	  /**Setter method for color*/
	  public void setColor(String color) {
	    this.color = color;
	  }

	  /**Getter method for filled. Since filled is boolean,
	     so, the get method name is isFilled*/
	  public boolean isFilled() {
	    return filled;
	  }

	  /**Setter method for filled*/
	  public void setFilled(boolean filled) {
	    this.filled = filled;
	  }
	  @Override
		public String toString() {
			return  "\ncolor: " + color +
				"\nfilled: " + filled;
		}

	  /**Abstract method findArea*/
	  public abstract double getArea();

	  /**Abstract method getPerimeter*/
	  public abstract double getPerimeter();
	}



class Triangle extends GeometricObject 
{
	private double side1; 
	private double side2; 
	private double side3;

	public Triangle(){
	} 

	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public Triangle(double side1, double side2, double side3, 
		String color, boolean filled) {
		this(side1, side2, side3);
		setColor(color);
		setFilled(filled); 
	}

	/** Return side1 */
	public double getSide1() {
		return side1;
	}

	/** Set side1 to a new lentgh */
	public void setSide1(double side1) {
		this.side1 = side1;
	}

	/** Return side2 */
	public double getSide2() {
		return side2;
	}

	/** Set side2 to a new lentgh */
	public void setSide2(double side2) {
		this.side2 = side2;
	}

	/** Return side3 */
	public double getSide3() {
		return side3;
	}

	/** Set side3 to a new lentgh */
	public void setSide3(double side3) {
		this.side3 = side3;
	}

	@Override /** Return area of this Triangle */
	public double getArea() {
		double s = (side1 + side2 + side3) / 2;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}

	@Override /** Return perimeter of this triangle */
	public double getPerimeter() {
		return side1 + side2 + side3;
	}

	@Override /** Return a string discription of the object */
	public String toString() {
		return super.toString() + "\nArea: " + getArea() + 
			"\nPerimeter: " + getPerimeter(); 
	}
}
