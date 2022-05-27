package CollidingShapes;
////////////////////////////////////////////////////////////////////////////////////
//
//  C212
//
//  Lab7
//  @Author  
//  Explain: What does this class do?
///////////////////////////////////////////////////////////////////////////////////

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D.drawPolyline ; 


/*
 * Main application for random shape generator app
 * NOTE: You are encouraged to experiment and try out various approaches
 * The comments given here are just guidelines to get you started 
 * Possibly, this problem can be completed in many ways.
 */
public class ShapeWindow extends JFrame 
{

    //JPanel shapeDriver;

    public ShapeWindow() 
    {
        super();
        // TO-DO: set up the frame
		/*
		Create a ShapeDriver object here (which is a JPanel)
		and add it to ShapeWindow (which is a JFrame). Don't forget to setSize,
		setVisible and any other required attributes (you might want to add the ShapeDriver
		object to the ContentPane (using this.getContentPane()) instead of directly adding
		to ShapeWindow. Make sure the canvas is large enough to hold all clusters.
		
		You can initialize a Timer here (with appropriate milliseconds and your 
		ShapeDriver obj created above as params). Use the timer.start() method to start Timer.
		It is okay if you do not stop your timer. However, your program should stop drawing new
		shapes once all shape types have reached a count of 10
		
		*/
        
         
        
        ShapeDriver driver = new ShapeDriver() ; 
        this.add(driver) ; 
        this.setSize(1000,2000) ;
        
        this.addKeyListener(driver) ; 
        
        this.setVisible(true) ;
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Timer timer = new Timer(100,driver) ; 
        timer.start(); 
        try
        {
        	Thread.sleep(20000) ;
        }
        catch(InterruptedException ne)
        {
        	timer.stop(); 
        }
        
    }
    public static void main(String [] args)
    {
    	ShapeWindow sw = new ShapeWindow() ; 
    }
}