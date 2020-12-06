/*
 	Programmer: Brayan Chacha Gonzalez (Z1861700) 
 	    Course: CSCI 470, Programming in Java
 	Assignment: Assingment05
 	  Due Date: 11/15/20
 	  
 	Class Name: DesignLayout
 				In this class we will define out patches and labels that will be used on the frame. 
 				We will also define the actions for the patches and the "reset" button that will be 
 				placed in the center of the South Panel. 
			
				Final Revised Copy 
*/
package mainframe;

import java.awt.Color;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;

public class DesignLayout2 extends JPanel implements ActionListener
{
	// Declaring the .gifs
	static final String[] IMAGESTRINGNAMEA = {"pat1[1].gif","pat2[1].gif", "pat3[1].gif", "pat4[1].gif", "pat5[1].gif"};
	
	// Label that will be on the Frame 
	private final JLabel LABEL1 = new JLabel("  1. Pick A Patch, from the toolbar to your left."); 
	private final JLabel LABEL2 = new JLabel("2. Click on the grid to draw!" + "\n");
	 
	// Creating an image array that will hold the patches 
	static Image[] imageA = new Image[5];
	
	// Creating the buttons for the each patch image
	JButton pat1BT, pat2BT, pat3BT, pat4BT, pat5BT;
	
	// Reset button at middle of JFrame 
	JButton resetBT;
	
	// Calling TileCanvas to create a grid 
	// so the user knows where to draw in the center of the canvas 
	final TileCanvas2 centerCanvas = new TileCanvas2();
	
	// Constructor of DesignLayout() 
	public DesignLayout2()
	{
		// Set BorderLayout container, arranging and resizing its components to fit in 5 reasons 
		// REMEMBER 5 REGIONS -> NORTH SOUTH EAST WEST CENTER
		super.setLayout(new BorderLayout());
		
		// Adding content to frame
		super.add(centerCanvas, BorderLayout.CENTER);
		
		// Label for the user can Understand the ToolBar
		centerCanvas.add(LABEL2);

		// Calling these two methods from "TileCanvas"
		centerCanvas.ResetGridTile();
		centerCanvas.createMouseListener();
		
		// Creating the GREEN border 
		LineBorder lineBorder;
		
		lineBorder = (LineBorder) BorderFactory.createLineBorder(Color.GREEN);
		
		centerCanvas.setBorder(lineBorder);
		
		// Creating the SOUTH panel 
		// in this panel we will find the "reset" button
		JPanel SouthPanel = new JPanel();
		
		// Set BorderLayout container, arranging and resizing its components to fit in 5 reasons 
		// REMEMBER 5 REGIONS -> NORTH SOUTH EAST WEST CENTER
		SouthPanel.setLayout(new FlowLayout());
		
		// Adding content to the Panel
		super.add(SouthPanel, BorderLayout.SOUTH);
		
		// Setting Color
		SouthPanel.setBackground(Color.PINK);
		
		// Adding the "Reset" button 
		resetBT = new JButton("RESET");
		
		// Adding content to the Panel
		SouthPanel.add(resetBT);
		
		// Loading the patches from the array 
		centerCanvas.patchArray();
		
		// Pointer to the top tool bar from main panel 
		JToolBar MainPanelToolBar  = new JToolBar();
		
		// Adding Patch1 and button 
		pat1BT = new JButton(new ImageIcon(imageA[0]));
		MainPanelToolBar.add(pat1BT);
		
		// Adding Patch2 and button 
		pat2BT = new JButton(new ImageIcon(imageA[1]));
		MainPanelToolBar.add(pat2BT);
		
		// Adding Patch3 and button 
		pat3BT = new JButton(new ImageIcon(imageA[2]));
		MainPanelToolBar.add(pat3BT);
		
		// Adding Patch4 and button 
		pat4BT = new JButton(new ImageIcon(imageA[3]));
		MainPanelToolBar.add(pat4BT);
		
		// Adding Patch5 and button 
		pat5BT = new JButton(new ImageIcon(imageA[4]));
		MainPanelToolBar.add(pat5BT);
		
		// Placing the tool-bar on the panel
		super.add(MainPanelToolBar,  BorderLayout.NORTH);
		
		// Setting the Color 
		MainPanelToolBar.setBackground(Color.ORANGE);
		
		// Setting the Label so User can have a better understanding 
		MainPanelToolBar.add(LABEL1);
		
		addListeners();
		
	}
	
	
	// A c t i o n P e r f o r m e d   f u n c t i o n 
	
	//This method will handle what buttons were clicked and what was chosen
	@Override 
	public void actionPerformed(ActionEvent e) 
	{
		// Erase canvas when user uses "Reset" button 
		// getSourse -> will go back to initial stage
		if(e.getSource() == resetBT) {
			centerCanvas.ResetGridTile();
			centerCanvas.selectedTile = -1;
		}
		// When the user selects a patch
				// it selects a value that will be used in mouse listener 
		if(e.getSource() == pat1BT){
			centerCanvas.selectedTile = 0;	
		}
				
		// Patch #2
		if(e.getSource() == pat2BT) {
			centerCanvas.selectedTile = 1;
		}
		// Patch #3
		if(e.getSource() == pat3BT) {
			centerCanvas.selectedTile = 2;	
		}
		// Patch #4
		if(e.getSource() == pat4BT) {
			centerCanvas.selectedTile = 3;	
		}		
		// Patch #5
		if(e.getSource() == pat5BT) {
			centerCanvas.selectedTile = 4;	
		}
	}
	
	// a d d L i s t e n e r s   f u c t i o n 
	
	// Hooking up the listener to the buttons that were created
	public void addListeners() 
	{
		// Patch #1
		pat1BT.addActionListener(this);
		
		// Patch #2
		pat2BT.addActionListener(this);
		
		// Patch #3
		pat3BT.addActionListener(this);
		
		// Patch #4
		pat4BT.addActionListener(this);
		
		// Patch #5
		pat5BT.addActionListener(this);
		
		// Reset Button 
		resetBT.addActionListener(this);
		
	}//End Listeners	
}