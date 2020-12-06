/*
 	Programmer: Brayan Chacha Gonzalez (Z1861700) 
 	    Course: CSCI 470, Programming in Java
 	Assignment: Assingment05
 	  Due Date: 11/15/20
 	  
 	Class Name: TileCanvas
				This class contain the functional of how the frame and canvas will work.
				In this class you will find how to reset the canvas and it will set up the 
				grid of the user to paint on the canvas. 
				We are using an implementation of MouseListner so we are calling the functions 
				that we didn't used at the end. 
				
				Final Revised Copy 
*/
package mainframe;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TileCanvas2 extends JPanel implements MouseListener
{
	// this is set to 0-4 when user clicks on a button in toolbar in mainpanel
	public int selectedTile = -1;
	
	static final int squareSide = 25;
	
	// Declaring the grid that will be printed for user to use  
	final int gridRows = 5; 
	final int gridCols = 5;
	
	int gwidth, gheight, beginX, beginY;
	
	//we take gifs in here and draw in tilegrid
	Image[][] gif2dArray = new Image[gridRows][gridCols];
	

	
	// Constructor of TileCanvas
	public TileCanvas2() {
		
		// Setting Color to YELLOW
		this.setBackground(Color.YELLOW);
	}
	
	
	
	// p a t c h A r r a y   f u n c t i o n 
	// This method will store the patches from the array 
	public void patchArray()
	{
		for (int i = 0; i < DesignLayout2.imageA.length; i++) 
		{
			DesignLayout2.imageA[i] = (Image) Toolkit.getDefaultToolkit().getImage(DesignLayout2.IMAGESTRINGNAMEA[i]);
		}
	}// End patchArray
	
	
	
	
	// p a i n t C o m p o n e n t    f u n c t i o n 
	// This method will paint the grid with elements in 2D-Array
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Creating more variables 
        // need to find center area of the center panel
        gwidth = gridCols * squareSide;  
        gheight = gridRows * squareSide;
        
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        
        // Beginning our starting point 
        beginX = (panelWidth - gwidth) / 2;
        beginY = (panelHeight - gheight) / 2;
        
        int row, col;
        
        // Drawing our grid 
        for (row = 0; row < gridRows; row++) 
        {
            for (col = 0; col < gridCols; col++) 
            {
                // Using drawRect to draw grid
                g.drawRect(beginX + (squareSide * row), beginY + (squareSide * col), squareSide, squareSide);
            }
        } // end grid drawing 

        // Placing patch to  the grid 
        for (row = 0; row < gridRows; row++) 
        {
            for (col = 0; col < gridCols; col++) 
            {
                // Using drawImage to draw image using the grid 
                g.drawImage(gif2dArray[row][col], beginX + (squareSide * row), beginY + (squareSide * col), this);
            }
        } 
    } // end paintComponent
	
	
	
	
	
	// m o u s e C l i c k e d     f u n c t i o n 
	//This method will allow the user to click on the yellow center panel
	@Override 
	public void mouseClicked(MouseEvent e)
	{
		if(selectedTile >= 0)
		{
			int x = e.getX();
			int y = e.getY();
			
			if(x >= beginX && x <= beginX + gwidth && y >= beginY && y <= beginY + gheight) 
			{
                int xin = (x - beginX) / squareSide; 
                int yin = (y - beginY) / squareSide;
                
                // Placing patch to the correct position 
                gif2dArray[xin][yin] = DesignLayout2.imageA[selectedTile]; 
                
                this.repaint(); 
			}
		}
	}// End mouseClicked
	
	
	// r e s e t   f u n c t i o n
	// This method will erase the entire canvas
	public void ResetGridTile() {
		for (int i = 0; i < gridRows; i++) 
		{
			for(int j = 0; j < gridCols; j++) {
				gif2dArray[i][j] = null;
			}
		}
		this.repaint();
		
	}// End ResetGridTile 
	
	
	
	
	public void createMouseListener()
	{
		addMouseListener(this);
	}

	// These methods at the bottom weren't use in our prog but since we are using 
	// an implementation of MouseEvenet we need to declare them 
    @Override
    public void mousePressed(MouseEvent e) 
    {

    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {

    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {

    }

    @Override
    public void mouseExited(MouseEvent e) 
    {

    }
}// End TileCanvas