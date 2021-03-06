/*
 	Programmer: Brayan Chacha Gonzalez (Z1861700) 
 	    Course: CSCI 470, Programming in Java
 	Assignment: Assingment05
 	  Due Date: 11/15/20
 	  
 	Class Name: MainFrame
 				Create a frame that has a �Mainpanel� covering it and the class MainPanel.java consists of a 
 				toolbar, and two subpanels. Choose different colors for the items.
			
				Final Revised Copy 
*/ 
package mainframe;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MainFrame extends JFrame
{
	public static void main(String[] args) 
	{
		// Calling your GUI
		createAndShowGUI();
		
	}// End Main

	
	// c r e a t e A n d S h o w G U I    F u n c t i o n 
	
	// Here we will create the GUI 
	public static void createAndShowGUI() 
	{
		// Create our frame and constructor puts 
		// large main panel over the entire 
		MainFrame frame = new MainFrame();
		
		// Exit the frame 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Size of the Frame when it opens
		frame.setSize(490,400);
		
		// Turning the flag to on
		frame.setVisible(true);
		
	}
	
	
	// M a i n F r a m e    F u n c t i o n 
	public MainFrame()
	{
		// Adding to the title 
		super("Canvas Application");
		
		//Creating an object where the actions will be performed 
		DesignLayout mainPanelPtr  = new DesignLayout();
		
		// Set BorderLayout container, arranging and resizing its components to fit in 5 reasons 
		// REMEMBER 5 REGIONS -> NORTH SOUTH EAST WEST CENTER
		super.setLayout(new BorderLayout());


		// Adding content to frame
		super.add(mainPanelPtr, BorderLayout.CENTER);
	}
}// End MainFrame