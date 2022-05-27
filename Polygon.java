package CollidingShapes;

import java.awt.Color;
import java.awt.Graphics;

public class Polygon extends Shape
{  
	private double sideLength ; 
	private int numSides ;
	
	public Polygon(Color fillColor, Color borderColor, int x, int y, int randXSpeed,
			int randYSpeed,int numSides, double sideLength)
	{
		super(fillColor, borderColor, x, y, randXSpeed, randYSpeed) ; 
		this.numSides = numSides ; 
		this.sideLength = sideLength ; 
		//theta = Math.toRadians((2 * 3.14) / numSides) ; 
		
	}
	
	public Polygon(Color fillColor, int x, int y, int numSides, double sideLength)
	{
		super(fillColor, x, y) ;
		this.numSides = numSides ; 
		this.sideLength = sideLength ; 
		//theta = (2 * 3.14) / numSides ; 
	}
	
	public Polygon(int x, int y, int numSides, double sideLength)
	{
		super(x, y) ; 
		this.numSides = numSides ; 
		this.sideLength = sideLength ;
		//theta = (2 * 3.14) / numSides ; 
	}
	
	public int getNumSides()
	{
		return this.numSides ; 
	}
	
	
	
	public double getSideLength()
	{
		return this.sideLength ; 
	}
	
	
	
	@Override
	void draw(Graphics g)
	{
		int[] x = new int[numSides] ; 
		int[] y = new int[numSides] ; 
		
		double theta = (2 * 3.14) / numSides ; 
		
		for(int i = 0 ; i < numSides ; i++)
		{
			x[i] = getX() + (int)(this.sideLength * Math.cos((theta * i))) ; 
			//System.out.println(this.sideLength * Math.cos(this.theta * i)) ; 
			//System.out.println(this.theta ) ; 
			///System.out.println(x[i]) ; 
		}
		//System.out.println() ; 
		for(int j = 0 ; j < numSides ; j++)
		{
			y[j] = getY() + (int)(this.sideLength * Math.sin(theta * j)) ; 
			//System.out.println(y[j]) ; 
		}
		
		g.setColor(getBorderColor());
		g.drawPolygon(x, y, numSides);
		g.setColor(getFillColor()) ; 
		g.fillPolygon(x, y, numSides);
	}

	@Override
	double getArea() 
	{
		double area = 0 ; 
		area = (sideLength * sideLength) * (numSides / 4) * Math.tan(180 / numSides) ; 
		return area ; 
	}

	@Override
	double getPerimeter() 
	{
		double perimeter = 0 ; 
		perimeter = sideLength * numSides ; 
		return perimeter ;
	}
	@Override
	public String toString()
	{
		String str = "" ; 
		
		str = "Polygon" + "\nSide Length: " + sideLength + "\nNumber of Sides: " + numSides + 
				"\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() ; 
		
		
		return str ; 
	}
	
	public boolean equals(Shape shape) //AI said to check obj type and area 
	{
		boolean equal = false ; 
		if(shape instanceof Polygon && this.getPerimeter() == shape.getPerimeter() && this.getArea() == shape.getArea())
		{
			equal = true ; 
		}
		return equal ; 
	}
	
	public static void main(String[] args)
	{
		//Polygon poly = new Polygon(Color.red, Color.red, 100, 200, 8, 30) ; 
		
		//poly.draw();
		
		//System.out.println(poly.getTheta()) ; 
	}
}

class Octagon extends Polygon
{
	public Octagon(Color fillColor, Color borderColor, int x, int y, 
			int randXSpeed, int randYSpeed ,double sideLength)
	{
		super(fillColor, borderColor, x, y,randXSpeed, randYSpeed,8, sideLength) ; 
	}
	
	public Octagon(Color fillColor, int x, int y, double sideLength)
	{
		super(fillColor, x, y, 8, sideLength) ; 
	}
	
	public Octagon(int x, int y, double sideLength)
	{
		super(x, y, 8, sideLength) ; 
	}
	@Override
	void draw(Graphics g)
	{
		super.draw(g) ; 
	}
	@Override
	public String toString()
	{
		String res = "Octagon: " + "\nsideLength: " + getSideLength() + "\nNumber of Sides: " + getNumSides() + 
				"\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() ;  
		return res ; 
	}
	@Override 
	public boolean equals(Shape shape) //AI said to check obj type and area 
	{
		boolean equal = false ; 
		if(shape instanceof Octagon && this.getPerimeter() == shape.getPerimeter() && this.getArea() == shape.getArea())
		{
			equal = true ; 
		}
		return equal ; 
	}
	
}