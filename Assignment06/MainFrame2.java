/*
 	Programmer: Brayan Chacha Gonzalez (Z1861700) 
 	    Course: CSCI 470, Programming in Java
 	Assignment: Assingment05
 	  Due Date: 11/15/20
 	  
 	Class Name: MainFrame
 				Create a frame that has a “Mainpanel” covering it and the class MainPanel.java consists of a 
 				toolbar, and two subpanels. Choose different colors for the items.
			
				Final Revised Copy 
*/ 
package mainframe;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MainFrame2 extends JFrame
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
		MainFrame2 frame = new MainFrame2();

		// Exit the frame 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Size of the Frame when it opens
		frame.setSize(600,600);
		
		// Turning the flag to on
		frame.setVisible(true);
		
	}
	
	
	
	
	// M a i n F r a m e    F u n c t i o n 
	public MainFrame2()
	{
		// Adding to the title 
		super("Assignment 6 - Thread/Ball Application");
		
		//Creating an object where the actions will be performed 
		DesignLayout2 mainPanelPtr  = new DesignLayout2();
		

		// Adding content to frame
		super.add(mainPanelPtr, BorderLayout.WEST);
		
		//Creating an object where the action will be performed for the ball animation
		BallAnimation mainPanelPtr2 = new BallAnimation();
		
		// Adding content to frame 
		super.add(mainPanelPtr2, BorderLayout.EAST);
	
	}
	
}// End MainFrame