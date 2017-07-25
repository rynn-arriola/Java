/*
(The ComparableCircle class) Define a class named ComparableCircle that extends
Circle and implements Comparable and implement the compareTo method to compare
the circles on the basis of area. Write a test class to find the larger of two instances of
ComparableCircle objects.
A. Sample main method:
public static void main(String[] args) {
 // Create two comarable rectangles
 ComparableCircle circle1 = new ComparableCircle(5);
 ComparableCircle circle2 = new ComparableCircle(15);
 // Display the max circle
 ComparableCircle circle3 = (ComparableCircle)Max.max(circle1, circle2);
 System.out.println("The max circle's radius is " + circle3.getRadius());
 System.out.println(circle3);
}
B. The sample output from the above main method:
The max circle's radius is 15.0
[Circle] radius = 15.0
Process completed.
*/

public class UNIT4_Exercise13_9
{

	public static void main(String[] args) 
	{
		Circle obj1 = new Circle(10);
		 Circle obj2 = new Circle(10);
		 System.out.println(obj1.equals(obj2));
		 System.out.println(obj1.compareTo(obj2));


	}

}
class ComparableCircle  extends Circle
{ // GeometricObject Implements compareTo

    ComparableCircle()
    {
    }

    ComparableCircle(double radius)
    {
        super(radius);
    }

}

abstract class GeometricObject implements Comparable<GeometricObject> {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    /** Construct a default geometric object */
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    /** Construct a geometric object with color and filled value */
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    /** Return color */
    public String getColor() {
        return color;
    }

    /** Set a new color */
    public void setColor(String color) {
        this.color = color;
    }

    /** Return filled. Since filled is boolean,
     *  the get method is named isFilled */
    public boolean isFilled() {
        return filled;
    }

    /** Set a new filled */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /** Get dateCreated */
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    /** Return a string representation of this object */
    

    @Override
    public int compareTo(GeometricObject o) {
        if (getArea() > o.getArea())
            return 1;
        else if (getArea() < o.getArea())
            return -1;
        else
            return 0;
    }

    public static GeometricObject max(GeometricObject o1, GeometricObject o2) {
        return (o1.compareTo(o2) >= 0) ? o1 : o2;
    }

    public static double sumArea(GeometricObject[] a) {
        double sum = 0;
        for (GeometricObject o : a) {
            sum += o.getArea();
        }
        return sum;
    }
    /** Abstract method getArea */
    public abstract double getArea();

    /** Abstract method getPerimeter */
    public abstract double getPerimeter();
}


class Circle extends GeometricObject 
{
	private double radius;

	public Circle()
	{

	}

	public Circle(double radius) 
	{
		this.radius = radius;
	}

	public Circle(double radius, String color, boolean filled)
	{
		this.radius = radius;
	setColor(color);
	setFilled(filled);
	}

	/** Return radius */
	public double getRadius() {
		return radius;
	}

	/** Set a new radius */
	public void setRadius(double radius)
	{
		this.radius = radius;
	}

	@Override /** Return area */
	public double getArea() 
	{
		return radius * radius * Math.PI;
	}

	/** Return diameter */
	public double getDiameter()
	{
		return 2 * radius;
	}

	@Override /** Return perimeter */
	public double getPerimeter() 
	{
		return 2 * radius * Math.PI;
	}
	public boolean equals (Circle circle)
	{
		if(compareTo(circle)==0)
			return false;
		else return true;
	}

	@Override /** Implement the toString method in GeometricObject */
	public String toString() 
	{
		
		return "\n[Circle]Radius: " + radius;
	}
	@Override
	public int compareTo(GeometricObject o)
	{
		if (o instanceof Circle && ((Circle )o).getRadius()==this.radius)
			return 1;
		else return 0;
	}
}


