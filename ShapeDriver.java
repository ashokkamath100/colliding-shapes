package CollidingShapes;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Dimension;

public class ShapeDriver extends JPanel implements ActionListener, KeyListener 
{

    
    public final int FRAME_WIDTH = 2000;
    public final int FRAME_HEIGHT = 1000;

    private Random random;

    ArrayList<Shape> shapes = new ArrayList<Shape>() ;
   
   
    public ShapeDriver() 
    {
        super(); 

        
        JPanel jpanel = new JPanel() ; 
        
    }

    @Override
    /**
     * Method calls super class paintComponent
     * and goes through list of shapes to draw each of 
     * them as long as the index is not null 
     * @param Graphics g in order to draw shapes
     */
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        for(int i = 0 ; i < shapes.size() ; i++)
        {
        	if(shapes.get(i) instanceof Shape)
        	{
        		shapes.get(i).draw(g) ; 
        	}
        }
        
    }
    /**
     * Method gets called automatically 
     * whenever the timer runs out
     * @param ActionEvent e is when the timer hit
     */
    public void actionPerformed(ActionEvent e)
    {
		/*
		  This method gets invoked automatically whenever Timer runs out.
		  Calling this.repaint() at the end, so that paintComponent() is invoked
		  and new Shape is picked up from the data structure and drawn.
		*/

    	
    	for(int i = 0 ; i < shapes.size() ; i++)
    	{
    		if(shapes.get(i) instanceof Shape)
    		{
    			shapes.get(i).moveLocation(shapes.get(i).getXSpeed(), shapes.get(i).getYSpeed()) ;
    		}
    	}
    	for(int i = 0 ; i < shapes.size() ; i++)
    	{
    		for(int j = 0 ; j < shapes.size() ; j++)
    		{
    			if(i != j && shapes.get(i) instanceof Shape && shapes.get(j) instanceof Shape)
    			{
    				Shape s1 = shapes.get(i) ; 
    				Color color1 = shapes.get(i).getFillColor() ; 
    				Shape s2 = shapes.get(j) ;
    				Color color2 = shapes.get(j).getFillColor() ; 
    				if(s1 instanceof Circle && s2 instanceof Circle)
    				{
    					Circle c1 = (Circle)shapes.get(i) ; 
    					Circle c2 = (Circle)shapes.get(j) ; 
    					double component1 = Math.pow(c1.getCenterX() - c2.getCenterX(), 2) ;
    					double component2 = Math.pow(c1.getCenterY() - c2.getCenterY(), 2) ;
    					double distance = Math.sqrt(component1 + component2) ; 
    					
    					boolean collide = false ; 
    					if(distance <= (c1.getRadius() + c2.getRadius()) )
    					{
    						collide = true ;
    						//System.out.println("after collide is true") ; 
    						if(collide && (c1.getFillColor() == c2.getFillColor()) )
    						{
    							double newArea = 3 * ((shapes.get(j).getArea() + shapes.get(i).getArea())/2) ;
    							double newRadius = Math.sqrt(newArea / Math.PI) ; 	
    							
    							Circle collideCirc = new Circle(c1.getFillColor(), c1.getBorderColor(), 
    									c1.getCenterX() + c1.getYSpeed(), c1.getCenterY(),c1.getXSpeed(),c1.getYSpeed(),
    									newRadius) ; 
    							shapes.set(i, null) ; 
    							shapes.set(j, null) ; 

    							shapes.add(collideCirc) ; 

    						}
    						else if(collide && (c1.getFillColor()!= c2.getFillColor()))
    						{
    							
    							Circle newWSwap1 = new Circle(c2.getFillColor(), c2.getBorderColor(), c1.getX()
    									+ c1.getXSpeed(), c1.getY() + c1.getXSpeed(), 
    									c1.getXSpeed(), c1.getYSpeed(), c1.getRadius()) ; 
    							
    							Circle newWSwap2 = new Circle(c1.getFillColor(), c1.getBorderColor(),
    									c2.getX() + c2.getXSpeed()
    							, c2.getY()+c2.getYSpeed(), c2.getXSpeed(), c2.getYSpeed(), c2.getRadius()) ;
    							
    							shapes.set(i, null) ; 
    							shapes.set(j, null) ; 

    						    shapes.add(newWSwap1) ; 
    							shapes.add(newWSwap2) ; 

    						}
    						
    					}
     				}
    				else if(s1 instanceof Square && s2 instanceof Square)
    				{
    					
    					Square sq1 = (Square)shapes.get(i) ; 
    					Square sq2 = (Square)shapes.get(j) ; 
    					double component1 = Math.pow(sq1.getCenterX() - sq2.getCenterX(), 2) ;
    					double component2 = Math.pow(sq1.getCenterY() - sq2.getCenterY(), 2) ;
    					double distance = Math.sqrt(component1 + component2) ; 
    					
    					boolean collide = false ; 
    					if(distance < ((sq1.getSideLength1()/2) + (sq2.getSideLength2()/2)) )
    					{
    						collide = true ;

    						if(collide && (sq1.getFillColor() == sq2.getFillColor()) )
    						{
    							double newArea = 3 * ((shapes.get(j).getArea() + shapes.get(i).getArea())/2) ;
    							double newSideLen = Math.sqrt(newArea) ; 	
    							
    							Square collideSq = new Square(sq1.getFillColor(), sq1.getBorderColor(), 
    									sq1.getCenterX(), sq1.getCenterY(), sq1.getXSpeed(),
    									sq1.getYSpeed(), newSideLen) ; 
    							shapes.set(i, null) ; 
    							shapes.set(j, null) ;
    							shapes.add(collideSq) ; 
    						}
    						else if(collide && (sq1.getFillColor()!= sq2.getFillColor()))
    						{
    							Square newWSwap1 = new Square(sq2.getFillColor(), sq2.getBorderColor(), sq1.getX()
    									+ (int)(1.5 * sq1.getXSpeed()), sq1.getY() + (int)(sq1.getXSpeed()), 
    									sq1.getXSpeed(), sq1.getYSpeed(), sq1.getSideLength1()) ; 
    							
    							Square newWSwap2 = new Square(sq1.getFillColor(), sq1.getBorderColor(),
    									sq2.getX() + (int)(sq2.getXSpeed())
    							, (int)(sq2.getY()+sq2.getYSpeed()), sq2.getXSpeed(), sq2.getYSpeed(), sq2.getSideLength1()) ;
    							
    							shapes.set(i, null) ; 
    							shapes.set(j, null) ; 
 
    						    shapes.add(newWSwap1) ; 
    							shapes.add(newWSwap2) ; 
    						}
    					}
    				}
    			}
    		}
    	}
		this.repaint() ;
	}
    /**
     * Chooses random color from ArrayList 
     * of colors and return the color 
     * @return random Color
     */
	public Color chooseRandColor()
	{
		ArrayList<Color> color = new ArrayList<Color>() ; 
		color.add(Color.black) ; 
		color.add(Color.yellow) ; 
		color.add(Color.red) ; 
		color.add(Color.blue) ; 
		color.add(Color.green) ; 
		color.add(Color.cyan) ; 
		color.add(Color.pink) ; 
		
		int randColor = (int)(Math.random() * 6) ; 
		
		Color rand = color.get(randColor) ; 
		return rand ; 
	}
	/**
	 * Chooses random size ranging from -20 to 20 
	 * @return random size 
	 */
	public double chooseRandSize()
	{
		double size = 0 ; 
		
		size = (Math.random() * 40) + 20 ; 
		
		return size ; 
	}
	/**
	 * Chooses random x-coordinate ranging from 40 to 900 
	 * @return random x coord
	 */
	public int chooseRandX() 
	{
		int x = 0 ; 
		x = (int) (Math.random() * 900) ; 
		
		if(x < 40)
		{
			x = x + 50 ; 
		}
		
		return x ; 
	}
	/**
	 * Chooses random y-coordinate ranging from 0 to 800 
	 * @return random y coor
	 */
	public int chooseRandY()
	{
		int y = 0 ; 
		y = (int) (Math.random() * 800) ; 
		if(y < 50)
		{
			y = y + 50 ; 
		}
		
		return y ; 
	}
	/**
	 * Chooses random speed ranging from 20 to -15 
	 * @return random speed 
	 */
	public int chooseRandSpeed()
	{
		int move = (int)((Math.random() * 30) - 15 ) ; 
		 
		if(move == 0 )
		{
			move = 20 ; 
		}
		
		return move ; 
		
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
		
	}
	
	@Override
	/**
	 * When a key is pressed, this method is called
	 * and it creates a Shape object that matches the 
	 * key pressed and adds it to the ArrayList 
	 * @param key event object 
	 */
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_V)
		{
			
			Shape oval = new Oval(chooseRandColor(), chooseRandColor(), chooseRandX(),
					chooseRandY(), chooseRandSpeed(), chooseRandSpeed(), chooseRandSize(), chooseRandSize()) ; 
			shapes.add(oval) ; 
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_C)
		{
			Shape circle = new Circle(chooseRandColor(), chooseRandColor(), chooseRandX(),
					chooseRandY(), chooseRandSpeed(), chooseRandSpeed(),2 * chooseRandSize())  ;
			shapes.add(circle) ; 
		}
		else if(e.getKeyCode() == KeyEvent.VK_P)
		{
			
			Shape polygon = new Polygon(chooseRandColor(), chooseRandColor(), chooseRandX(),
					chooseRandY(), chooseRandSpeed(), chooseRandSpeed(), 10, chooseRandSize())  ;
			shapes.add(polygon) ; 
		}
		else if(e.getKeyCode() == KeyEvent.VK_O)
		{
			Shape octagon = new Octagon(chooseRandColor(), chooseRandColor(), chooseRandX(),
					chooseRandY(), chooseRandSpeed(), chooseRandSpeed(), chooseRandSize())  ;
			shapes.add(octagon) ; 
		}
		else if(e.getKeyCode() == KeyEvent.VK_Q)
		{
			int randY = chooseRandY() ; 
			Shape quad = new Quadrilateral(chooseRandColor(), chooseRandColor(), chooseRandX(),
					chooseRandY(), chooseRandSpeed(), chooseRandSpeed(),chooseRandSize(), chooseRandSize())  ;
			shapes.add(quad) ;
		}
		else if(e.getKeyCode() == KeyEvent.VK_R)
		{
			Shape rhom = new Rhombus(chooseRandColor(), chooseRandColor(), chooseRandX(),
					chooseRandY(), chooseRandSpeed(), chooseRandSpeed(),chooseRandSize())  ;
			shapes.add(rhom) ; 
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
			Shape square = new Square(chooseRandColor(), chooseRandColor(), chooseRandX(),
					chooseRandY(), chooseRandSpeed(), chooseRandSpeed(), 2 * chooseRandSize())  ;
			shapes.add(square) ; 
		}
		else if(e.getKeyCode() == KeyEvent.VK_T)
		{
			Shape triangle = new Triangle(chooseRandColor(), chooseRandColor(), chooseRandX(),
					chooseRandY(), chooseRandSpeed(), chooseRandSpeed(),chooseRandSize())  ;
			shapes.add(triangle) ; 
		}
	}
		
	

	@Override
	public void keyReleased(KeyEvent e) 
	{
		
		
	}
	
	
}