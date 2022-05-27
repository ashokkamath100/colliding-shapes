package CollidingShapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;  
abstract class Shape 
{ 
	private Color fillColor;
	private Color borderColor;
	private Boolean isFilled;
	private Point location; 
	private int xSpeed ;
	private int ySpeed ; 
	
	// the three constructors initialize the instance fields
	public Shape(Color fillColor, Color borderColor, int x, int y, int randXSpeed, 
			int randYSpeed)
	{ 
		this.fillColor = fillColor ; 
		this.borderColor = borderColor ; 
		this.location = new Point(x,y) ; 
		this.xSpeed = randXSpeed ; 
		this.ySpeed = randYSpeed ; 
		
		
		
	} 
	
	// set borderColor to Black since not provided in this constructor
	public Shape(Color fillColor, int x, int y)
	{
		this.fillColor = fillColor ; 
		this.location = new Point(x,y) ;
	}
	
	// set fillColor to white and border color to black  
	public Shape(int x, int y) 
	{ 
		this.location = new Point(x,y) ;
	}    
	
	// getters and setters for Fill/Border color for this Shape

	public void setFillColor(Color c) 
	{ 
		this.fillColor = c ; 
		//System.out.println("ee"); 
	}
	public Color getFillColor() 
	{ 
		return this.fillColor ; 
	}
	public void setBorderColor(Color c)
	{ 
		this.borderColor = c ; 
	}
	public Color getBorderColor() 
	{ 
		return this.borderColor ; 
	}
	// setters and getters for Shape’s current location (uses Point object)
	public void setLocation(Point pt) 
	{ 
		this.location = pt ; 
	} 
	public Point getLocation() 
	{ 
		return this.location ; 
	}
	// Note:  subclasses of Shape do not inherit private members so we need methods the subclasses    
	// can use to get the x and y values from the private Point instance field
	public int getX() 
	{ 
		return this.location.x ; 
	}
	public void setX(int x) 
	{ 
		this.location.x = x ; 
	} 
	public int getY() 
	{ 
		return this.location.y ; 
	}
	public void setY(int y) 
	{ 
		this.location.y = y ; 
	} 
	
	public int getXSpeed()
	{
		return xSpeed ; 
	}
	
	public int getYSpeed()
	{
		return ySpeed ; 
	}
	
	// if fillColor is white returns true, else returns false  – you can choose not to use this for this Lab
	public boolean isFilled()
	{ 
		boolean isFilled = false ; 
		if(fillColor == Color.white)
		{
			isFilled = true ; 
		}
		return isFilled ; 
	} 
	// moves location by dx and dy – you can choose not to use this for this Lab
	public void moveLocation(int dx, int dy)
	{ 
		this.location.x = this.location.x + dx ; 
		this.location.y = this.location.y + dy ; 
		if(this instanceof Circle)
		{
			Circle c = (Circle) this ; 
			c.setCenterX(c.getCenterX() + dx) ;
			c.setCenterY(c.getCenterY() + dy) ;
		}
		else if(this instanceof Square)
		{
			Square s = (Square) this ; 
			s.setCenterX(s.getCenterX() + dx) ;
			s.setCenterY(s.getCenterY() + dy) ;
		}
		
	}
	abstract double getArea();
	abstract double getPerimeter(); 
	// You have to update methods as described above. Don’t forget the abstract draw() method!
	
	abstract void draw(Graphics g) ; 
	
}