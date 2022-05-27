package CollidingShapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Triangle extends Shape 
{
	private double sideLength ; 

	public Triangle(Color fillColor, Color borderColor, int x, int y, 
			int randXSpeed, int randYSpeed, double sideLength) 
	{
		super(fillColor, borderColor, x, y, randXSpeed, randYSpeed);
		this.sideLength = sideLength ; 
		
	}
	
	public Triangle(Color fillColor, int x, int y, int sideLength)
	{
		super(fillColor, x, y) ;
		this.sideLength = sideLength ; 
	}
	
	public Triangle(int x, int y, int sideLength)
	{
		super(x,y) ; 
		this.sideLength = sideLength ; 
	}
	
	
	

	@Override
	double getArea() 
	{
		double area = 0 ; 
		area = sideLength * sideLength * 1 / 2  ; 
		return area;
	}

	@Override
	double getPerimeter() 
	{
		double perimeter = 0 ; 
		double hypotenuse = Math.sqrt(2 * Math.pow(sideLength, 2)) ; 
		perimeter = sideLength + sideLength + hypotenuse ; 
		perimeter = Math.round(perimeter) ; 
		return perimeter ;
	}

	//@Override
	void draw(Graphics g) 
	{
		int x1 = this.getX() ; 
		int y1 = this.getY() ; 
		
		int x2 = (int) (x1 + sideLength) ; 
		int y2 = y1  ; 
		
		int x3 = x2 ; 
		int y3 = (int) (y2 + sideLength) ; //draws right triangle 
		
		int[] x = {x1, x2, x3} ; 
		int[] y = {y1, y2, y3} ;
		
		for(int i = 0 ; i < x.length ; i++)
		{
			//System.out.println(x[i]) ;
			//System.out.println(y[i]) ; 
		}
		g.setColor(getBorderColor());
		g.drawPolygon(x,y,3);
		g.setColor(getFillColor());
		g.fillPolygon(x, y, 3);
		
	}
	@Override
	public String toString()
	{
		String res = "Triangle" + "\nSide Length: " + sideLength  + 
				"\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() ;  
		return res ; 
	}
	public boolean equals(Shape shape)
	{
		boolean equal = false ; 
		if(shape instanceof Triangle && this.getPerimeter() == shape.getPerimeter() && this.getArea() == shape.getArea())
		{
			equal = true ; 
		}
		return equal ; 
	}
	
	public static void main(String[] args)
	{
		//Triangle tri = new Triangle(Color.black, Color.black, 100, 200, 10) ; 
		System.out.println(tri.getArea()) ; 
		System.out.println(tri.getPerimeter()) ; 
		System.out.println(tri.toString()) ; 
		//tri.draw();  
	}

	

}
