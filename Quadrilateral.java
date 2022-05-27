package CollidingShapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Quadrilateral extends Shape 
{
	private double sideLength1 = 0 ; 
	private double sideLength2 = 0 ; 

	public Quadrilateral(Color fillColor, Color borderColor, int x, int y, int randXSpeed,
			int randYSpeed, double sideLength1,double sideLength2) 
	{
		super(fillColor, borderColor, x, y, randXSpeed, randYSpeed) ;
		this.sideLength1 = sideLength1 ; 
		this.sideLength2 = sideLength2 ; 
	}
	
	public Quadrilateral(Color fillColor, int x, int y, double sideLength1,
			double sideLength2)
	{
		super(fillColor, x, y) ; 
		this.sideLength1 = sideLength1 ; 
		this.sideLength2 = sideLength2 ; 
	}
	
	public Quadrilateral(int x, int y, double sideLength1,
			double sideLength2)
	{
		super(x,y) ; 
		this.sideLength1 = sideLength1 ; 
		this.sideLength2 = sideLength2 ; 
	}

	@Override
	double getArea() 
	{
		double area = 0 ; 
		area = sideLength1 * sideLength2 ; 
		return area ; 
	}

	@Override
	double getPerimeter() 
	{
		double perimeter = 0 ; 
		perimeter = (sideLength1 * 2) + (sideLength2 * 2) ; 
		return perimeter;
	}
	
	public double getSideLength1()
	{
		return sideLength1 ; 
	}
	
	public double getSideLength2() 
	{
		return sideLength2 ; 
	}

	@Override
	void draw(Graphics g) 
	{
		g.setColor(getBorderColor());
		g.drawRect(this.getX(), this.getY(), (int)sideLength1, (int)sideLength2);
		g.setColor(getFillColor());
		g.fillRect(getX(), getY(), (int)sideLength1, (int)sideLength2);
		
	}
	@Override
	public String toString()
	{
		String res = "Quadrilateral" + "\nSide Length 1: " + getSideLength1() + "\nSide Length 2" + getSideLength2() + 
				"\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() ;  
		return res ; 
	}
	
	public boolean equals(Shape shape) //AI said to check obj type and area 
	{
		boolean equal = false ; 
		if(shape instanceof Quadrilateral && this.getPerimeter() == shape.getPerimeter() && this.getArea() == shape.getArea())
		{
			equal = true ; 
		}
		return equal ; 
	}

}

class Rhombus extends Quadrilateral
{
	public Rhombus(Color fillColor, Color borderColor, int x, int y,  int randXSpeed,
			int randYSpeed,double sideLength1) 
	{
		super(fillColor, borderColor, x, y, randXSpeed, randYSpeed,sideLength1, sideLength1) ;
		 
	}
	
	public Rhombus(Color fillColor, int x, int y, double sideLength1)
	{
		super(fillColor, x, y, sideLength1, sideLength1) ; 
		
	}
	
	public Rhombus(int x, int y, double sideLength1)
	{
		super(x, y, sideLength1, sideLength1) ; 
		 
		
	}
	@Override
	public double getArea()
	{
		double area = getSideLength1() * getSideLength1() ; 
		return area ; 
	}
	@Override
	public double getPerimeter()
	{
		int peri = (int) getSideLength1() * 4 ; 
		return peri ; 
	}
	@Override
	void draw(Graphics g)
	{
		int[] x = new int[4] ; 
		int[] y = new int[4] ; 
		
		x[0] = getX() ; 
		y[0] = getY() ; 
		
		x[1] = (int) (x[0] + this.getSideLength1()) ; 
		y[1] = y[0] ; 
		
		x[2] = x[1] + 20 ; 
		y[2] = (int) (y[1] + this.getSideLength1()) ; 
		
		x[3] = (int) (x[2] - this.getSideLength1()) ; 
		y[3] = y[2]  ; 
		
		
		g.setColor(getBorderColor());
		g.drawPolygon(x, y, 4) ;
		g.setColor(getFillColor()) ; 
		g.fillPolygon(x, y, 4) ; 
	}
	@Override
	public String toString()
	{
		
			String res = "Rhombus " + "\nSide Lengths: " + 
					getSideLength1()  + 
					"\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() ;  
			return res ; 
		
	}
	public boolean equals(Shape shape)
	{
		boolean equal = false ; 
		if(shape instanceof Rhombus && this.getPerimeter() == shape.getPerimeter() && this.getArea() == shape.getArea())
		{
			equal = true ; 
		}
		return equal ; 
	}
}

class Square extends Rhombus
{
	private Point center ; 
	public Square(Color fillColor, Color borderColor, int x, int y, int randXSpeed,
			int randYSpeed, double sideLength) 
	{
		super(fillColor, borderColor, x, y, randXSpeed, randYSpeed,sideLength) ;
		double centerX = x + (.5 * sideLength) ; 
		double centerY = y + (.5 * sideLength) ; 
		this.center = new Point((int)centerX , (int)centerY) ;
		//System.out.println(center.x + "hello") ; 
		//System.out.println(center.y) ; 
	}
	
	public Square(Color fillColor, int x, int y, double sideLength)
	{
		super(fillColor, x, y, sideLength) ; 
	}
	
	public Square(int x, int y, double sideLength)
	{
		super(x,y, sideLength) ; 
		
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
	
	void draw(Graphics g) 
	{
		g.setColor(getBorderColor());
		g.drawRect(this.getX(), this.getY(), (int)getSideLength1(), (int)getSideLength2());
		g.setColor(getFillColor());
		g.fillRect(getX(), getY(), (int)getSideLength1(), (int)getSideLength2());
	}
	
	
	@Override
	public String toString()
	{
		String res = "Square" + "\nSide Lengths: " + 
				getSideLength1() + 
				"\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() ;  
		return res ; 
	}
	@Override
	public boolean equals(Shape shape)
	{
		boolean equal = false ; 
		if(shape instanceof Square && this.getPerimeter() == shape.getPerimeter() && this.getArea() == shape.getArea())
		{
			equal = true ; 
		}
		return equal ; 
	}
	
	public static void main(String[] args)
	{
		/*
		 * Square squ = new Square(Color.yellow, Color.yellow, 50, 40, 60) ;
		 * System.out.println(squ.getArea()) ; System.out.println(squ.getArea()) ;
		 */ 
	}
	
}
