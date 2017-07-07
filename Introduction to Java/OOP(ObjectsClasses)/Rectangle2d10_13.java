/*
 * (Geometry: the MyRectangle2D class) Define the MyRectangle2D class that
contains:
# Two double data fields named x and y that specify the center of the rectangle
with getter and setter methods. (Assume that the rectangle sides are
parallel to x- or y- axes.)
# The data fields width and height with getter and setter methods.
# A no-arg constructor that creates a default rectangle with (0, 0) for (x, y) and
1 for both width and height.
# A constructor that creates a rectangle with the specified x, y, width, and
height.
Programming Exercises 405
# A method getArea() that returns the area of the rectangle.
# A method getPerimeter() that returns the perimeter of the rectangle.
# A method contains(double x, double y) that returns true if the
specified point (x, y) is inside this rectangle (see Figure 10.24a).
# A method contains(MyRectangle2D r) that returns true if the specified
rectangle is inside this rectangle (see Figure 10.24b).
# A method overlaps(MyRectangle2D r) that returns true if the specified
rectangle overlaps with this rectangle (see Figure 10.24c).
*/

public class Rectangle2d10_13
{

	public static void main(String[] args)
	{
		myRectangle2D rec=new myRectangle2D(2,2,5.5,4.9);
		
		System.out.println("Area: "+ rec.getArea() +
							"\nPerimeter:  "+ rec.getPerimeter()+ 
							"\nContains Point: "+ rec.contains(3,3)+
							"\nContains Rectangle: "+rec.contains(new myRectangle2D(4,5,10.5,3.2))+
							"\nOverlaps: "+ rec.overlaps(new myRectangle2D(3,5,2.3,5.4)));

	}

}
class myRectangle2D
{
	private double x;
	private double y;
	private double width;
	private double height;
	
	public myRectangle2D()
	{
		this(0,0,1,1);
	}
	public myRectangle2D(double x, double y,double width, double height)
	{
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	public boolean contains(double x, double y)
	{
		return(width>0 &&
				height>0 &&
				x>getX() &&
				x<(getX()+width)&&
				y>=getY()&&
				y<(getY()+height));
	}
	public boolean contains (myRectangle2D r)
	{
		return(width>0 &&
				height>0 &&
				r.getX()>x &&
				r.getX()<(x+width) &&
				r.getY()>=y &&
				r.getY()<(y+height));
	}
	public boolean overlaps(myRectangle2D r)
	{
		return(x < r.x+r.width) &&
				(x + width > r.x ) &&
				(y < r.y + r.height) &&
				(y + height > r.y);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	public double getArea()
	{
		return(getWidth()*getHeight());
	}
	public double getPerimeter()
	{
		return((getWidth()*2)+(getHeight()*2));
	}
	
	
}

