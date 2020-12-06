package mainframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Graphics;
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

public class BallAnimation extends JPanel implements Runnable, ActionListener
{
	// Creating the bottom 2 buttons 
	JButton startRight, stopRight;
	
	Thread threadObjPtr = null;
	
	boolean runFlag; 
	
	// Variables for the circle1
	int radius = 15;
	int x = 300; int y = 200;
	int dx = 5; int dy = 5;
	
	// Variables for the circle2
	int radius2 = 30;
	int x2 = 140; int y2 = 100;
	int dx2 = 5; int dy2 = 5;
	
	// Variables for the circle3
	int radius3 = 15;
	int x3 = 150; int y3 = 169;
	int dx3 = 16; int dy3 = 18;
	
	// Variables for the circle4
	int radius4 = 40;
	int x4 = 100; int y4 = 20;
	int dx4 = 60; int dy4 = 100;
	
	// Variables for the circle5
	int radius5 = 76;
	int x5 = 89; int y5 = 89;
	int dx5 = 5; int dy5 = 5;
	
	// Variables for the circle6
	int radius6 = 49;
	int x6 = 60; int y6 = 49;
	int dx6 = 30; int dy6 = 35;
	
	// Variables for the circle1
	int radius7 = 34;
	int x7 = 23; int y7 = 12;
	int dx7 = 5; int dy7 = 34;


	//Ball Animation, on here we will create the 
	//the jframe and add them to our GUI
	public BallAnimation()
	{
		//Creating the JPanel for the bottom
		JPanel SouthPanel2 = new JPanel();
		
		//Adding color to the background  
		SouthPanel2.setBackground(Color.PINK);
		SouthPanel2.setLayout(new FlowLayout());
		
		//Adding the buttons to the lower part of the frame 
		startRight = new JButton("Start");
		stopRight = new JButton("Stop");
		
		//Adding it to the Frame 
		this.setLayout(new BorderLayout());
		super.add(SouthPanel2, BorderLayout.SOUTH);
		
		//Action listener 
		startRight.addActionListener(this);
		stopRight.addActionListener(this);
		
		SouthPanel2.add(startRight);
		SouthPanel2.add(stopRight);
		
		addListeners();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == startRight) 
			{
				if(threadObjPtr == null) 
					{	System.out.println("Start was pressed!");
						runFlag = true;
				
						threadObjPtr = new Thread(this);
						threadObjPtr.start();
					}
			}
		
		else if (e.getSource() == stopRight)
		{
			runFlag = false;
			
			threadObjPtr = null;
		}
		
	}
	
	// a d d L i s t e n e r s   f u c t i o n 
	// Hooking up the listener to the buttons that were created
	public void addListeners() 
	{
		// button 1
		startRight.addActionListener(this);
		
		// button 2
		stopRight.addActionListener(this);
		
		
	}//End Listeners
	
	// Running the threads 
	public void run() 
	{
		while (runFlag == true)
		{
			try
			{
				Thread.sleep(2000);
			}
			catch(InterruptedException e) 
			{
				System.out.println("ERROR! EXCEPTION OCCURED");
				
			}
			this.repaint();
		}
		
	}//END RUN
	
	// Here we will create the balls and pain them to our white dimension 
	@Override 
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		
		Dimension dimPtr = new Dimension(1050,450);
		this.setPreferredSize(dimPtr);
		this.setBackground(Color.WHITE);
		
			
		g.setColor(Color.BLUE);
		g.fillOval(x,y,2*radius,2*radius);
		
		if (this.x <= 0 || this.x >= ( dimPtr.width - (2 * radius)) )
			dx = -dx;
		if (this.y <= 0 || this.y >= ( dimPtr.height - (3 * radius)) )
			dy = -dy;
		x+=dx;
		y+=dy;
		
		g.setColor(Color.RED);
		g.fillOval(x2,y2,2*radius2,2*radius2);
		
		if (this.x2 <= 0 || this.x2 >= ( dimPtr.width - (2 * radius2)) )
			dx = -dx;
		if (this.y2 <= 0 || this.y2 >= ( dimPtr.height - (3 * radius2)) )
			dy2 = -dy2;
		x2+=dx2;
		y2+=dy2;
		
		g.setColor(Color.GREEN);
		g.fillOval(x3,y3,2*radius3,2*radius3);
		
		if (this.x3 <= 0 || this.x3 >= ( dimPtr.width - (2 * radius3)) )
			dx3 = -dx3;
		if (this.y <= 0 || this.y >= ( dimPtr.height - (3 * radius)) )
			dy = -dy;
		x3+=dx3;
		y3+=dy3;
		
		g.setColor(Color.YELLOW);
		g.fillOval(x4,y4,2*radius4,2*radius4);
		
		if (this.x4 <= 0 || this.x4 >= ( dimPtr.width - (2 * radius4)) )
			dx4 = -dx4;
		if (this.y4 <= 0 || this.y4 >= ( dimPtr.height - (3 * radius4)) )
			dy4 = -dy4;
		x4+=dx4;
		y4+=dy4;
		
		g.setColor(Color.MAGENTA);
		g.fillOval(x5,y5,2*radius5/2,2*radius5/2);
		
		if (this.x5 <= 0 || this.x5 >= ( dimPtr.width - (2 * radius5)) )
			dx5 = -dx5;
		if (this.y5 <= 0 || this.y5 >= ( dimPtr.height - (3 * radius5)) )
			dy5 = -dy5;
		x5+=dx5;
		y5+=dy5;
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(x6,y6,2*radius6,2*radius6);
		
		if (this.x6 <= 0 || this.x6 >= ( dimPtr.width - (2 * radius6)) )
			dx6 = -dx6;
		if (this.y6 <= 0 || this.y6 >= ( dimPtr.height - (3 * radius6)) )
			dy6 = -dy6;
		x6+=dx6;
		y6+=dy6;
		
		g.setColor(Color.ORANGE);
		g.fillOval(x7,y7,2*radius7/2,2*radius7/2);
		
		if (this.x7 <= 0 || this.x7 >= ( dimPtr.width - (2 * radius7)) )
			dx7 = -dx7;
		if (this.y7 <= 0 || this.y7 >= ( dimPtr.height - (3 * radius7)) )
			dy7 = -dy7;
		x7+=dx7;
		y7+=dy7;
	}


}
