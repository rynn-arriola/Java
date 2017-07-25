/*
(Enable Circle comparable) Rewrite the Circle class in Listing 13.2 to extend
GeometricObject and implement the Comparable interface. Override the equals
method in the Object class. Two Circle objects are equal if their radii are the same.
A. Sample main method:
public static void main(String[] args) {
 Circle13_09 obj1 = new Circle13_09();
 Circle13_09 obj2 = new Circle13_09();
 System.out.println(obj1.equals(obj2));
 System.out.println(obj1.compareTo(obj2));
}
B. The sample output from the above main method:
true
0
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


