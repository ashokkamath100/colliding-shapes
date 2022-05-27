package CollidingShapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class Oval extends Shape
{
	
	private double width ; 
	private double height ; 

	public Oval(Color fillColor, Color borderColor, int x, int y, int randXSpeed,
			int randYSpeed,double width, double height
			) 
	{
		super(fillColor, borderColor, x, y, randXSpeed, randYSpeed) ;
		this.width = width ; 
		this.height = height ; 
	}
	
	public Oval(Color fillColor, int x, int y, double width, double height)
	{
		super(fillColor, x, y) ; 
		this.width = width ; 
		this.height = height ; 
	}
	
	public Oval(int x, int y, double width, double height)
	{
		super(x,y) ; 
		this.width = width ; 
		this.height = height ; 
	}

	@Override
	double getArea()
	{
		double area = 0 ; 
		area = Math.PI * (width/2) * (height/2) ; 
		area = Math.round(area) ; 
 		return area ; 
		
	}

	@Override
	double getPerimeter()
	{
		double circum = 0 ; 
		double a = Math.pow(width/2, 2) ; 
		double b = Math.pow(height/2, 2) ; 
		circum = (2 * Math.PI) * Math.sqrt((a+b)/2) ; 
		circum = Math.round(circum) ; 
		return circum;
	}

	@Override
	void draw(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g ; 
		
		g2.setColor(this.getBorderColor());
		Ellipse2D.Double ellipse = new Ellipse2D.Double(this.getX(),this.getY(),width,height) ; 
		g2.draw(ellipse); 
		g2.setColor(this.getFillColor());
		g2.fill(ellipse);

		
	}
	@Override
	public String toString()
	{
		String str = "" ; 
		
		str = "Oval" + "\nWidth: " + width + "\nHeight: " + height + 
				"\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() ; 
		
		
		return str ; 
	}
	

	public boolean equals(Shape shape) //AI said to check obj type and area 
	{
		boolean equal = false ; 
		if(shape instanceof Oval && this.getPerimeter() == shape.getPerimeter() && this.getArea() == shape.getArea())
		{
			equal = true ; 
		}
		return equal ; 
	}
	
	public static void main(String[] args)
	{
		/*
		Oval oval = new Oval(Color.red, Color.red, 10,
				10, 20, 30) ; 
		System.out.println(oval.getArea() + " " + oval.getPerimeter()) ;
		*/
	}
	

}
class Circle extends Oval 
{
	private double radius ; 
	private Point center ; 
	
	public Circle(Color fillColor, Color borderColor, int x, int y,int randXSpeed,
			int randYSpeed, double radius) 
	{
		super(fillColor, borderColor, x, y, randXSpeed, randYSpeed,radius * 2, radius * 2) ;
		
		double centerX = x + (Math.cos(Math.toRadians(45))) * (radius) ; 
		double centerY = y + (Math.sin(Math.toRadians(45))) * (radius) ; 
		//System.out.println(x) ; 
		//System.out.println(y) ; 
		//System.out.println(centerX) ;
		//System.out.println(centerY) ; 
		this.center = new Point((int)centerX , (int)centerY) ; 
		
		this.radius = radius ; 
	}
	
	public Circle(Color fillColor, int x, int y, double radius) 
	{
		super(fillColor, x, y, radius * 2, radius * 2) ; 
		
		this.radius = radius ; 
	}
	
	public Circle(int x, int y, double radius)
	{
		super(x, y, radius * 2, radius * 2) ; 
		
		this.radius = radius ; 

	}
	
	public int getCenterX()
	{
		return center.x ; 
	}
	
	public int getCenterY() 
	{
		return center.y ; 
	}
	
	public void setCenterX(int x)
	{
		center.x = x  ; 
	}
	
	public void setCenterY(int y)
	{
		center.y = y ; 
	}
	
	public double getRadius()
	{
		return radius ; 
	}
	
	@Override 
	double getArea() 
	{
		double area = 0 ; 
		area = radius * radius * Math.PI ; 
		return area ; 
	}
	
	@Override
	double getPerimeter()
	{
		double perimeter = 0 ; 
		perimeter = Math.PI * 2 * radius ; 
		return perimeter ; 
	}
	@Override
	void draw(Graphics g)
	{
		super.draw(g); 	
	}
	@Override
	public String toString()
	{
		String str = "" ; 
		
		str = "Circle" + "\nRadius: " + radius +  
				"\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() ; 
		
		
		return str ; 
	}
	@Override 
	public boolean equals(Shape shape)
	{
		boolean equal = false ; 
		if(shape instanceof Circle && this.getPerimeter() == shape.getPerimeter() && this.getArea() == shape.getArea())
		{
			equal = true ; 
		}
		return equal ; 
	}

	

}
