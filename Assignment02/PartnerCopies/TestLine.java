/*
 *	Programmer: Marcus Schumacher      (z1874458)
 *	Programmer: Brayan Chacha Gonzalez (z1861700)
 *	    Course: CSCI 470, Programming in Java 
 *	Assignment: Assignment02
 *	  Date Due: 9/16/20
 *
 *	Class Name: TestLine
 *
 *  Class Purpose: Test making Line objects and using Line 
 *                 methods, as well as practice exception
 *                 handling
/*************************************************************** 
Now we will define a driver program below called TestLine with 
main() where execution will begin. It is this class, and this code,
 that will create instances of the Line and call its methods. As a 
test module, this code would be improved with additional 
System.out.println() statements that explain what is being attempted
 and what the results should be, for example: "About to change l1 to
 an invalid value and then redraw it. Line position 
should not change: "*/
//********************************************************* 

import chachalinepackage.*;

class TestLine 
{ 

    public static void main(String args[]) 
    { 
        //declare 2 instances of Line class 
        Line l1 = null, l2 = null; 

        //create l1 Line object 
        try
        {
            l1 = new Line (10, 10, 100, 100); 
        }
        catch(Exception e)
        {
            System.exit(88);
        }

        //draw it 
        l1.draw(); 


        System.out.println("About to change values in l1");

        //change start point with valid values 
        try
        {
            l1.setLine(5, 5, l1.getXTwo(), l1.getYTwo()); 
            System.out.println("SUCCESS \n");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        //draw it again with new start point 
        l1.draw(); 

        System.out.println("About to try changing x1 in l1 to an illegal value");
        //try to change xOne (x1) to an illegal value 
        try
        {
            l1.setXOne(3000); 
            System.out.println("SUCCESS \n");
        }
        catch(Exception e)
        {
            System.out.println("EXCEPTION: My try catch caught a generic exception in a set method for a bad value of x1 for an existing line. This line can still be used but the bad value was not set.");
            System.out.println(e + "\n");
        }


        //draw the line...x1 should now be zero 
        l1.draw(); 

        System.out.println("About to create l2");

        //create a second Line instance, or object 
        try
        {
            l2 = new Line(100, 100, 400, 400); 
            System.out.println("SUCCESS \n");
        }
        catch(Exception e)
        {
            System.exit(88);
        }

        //draw 2nd line 
        l2.draw(); 

        System.out.println("About to set l2's y2 to a new valid value");
        //set a new valid yTwo for line 2 
        try
        {
            l2.setYTwo(479); 
            System.out.println("SUCCESS \n");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        //draw 2nd line again 
        l2.draw(); 

        // Testing getLength method
        System.out.println("About to test the getLength method: ");
        System.out.printf("Length of l1 is: %f \n", l1.getLength());
        System.out.printf("Length of l2 is: %f \n", l2.getLength());
        System.out.println("");

        // Testing getAngle method
        System.out.println("About to test the getAngle method: ");
        System.out.printf("Angle of l1 is: %f radians \n", l1.getAngle());
        System.out.printf("Angle of l2 is: %f radians \n", l2.getAngle());
        System.out.println("");

        // Testing constructor with TwoDPointt

        System.out.println("About to construct two TwoDPoints with:");
        System.out.println("X1 = 2");
        System.out.println("X2 = 10");
        System.out.println("Y1 = 8");
        System.out.println("Y2 = 20");

        TwoDPoint point1 = new TwoDPoint(2, 8);
        TwoDPoint point2 = new TwoDPoint(10, 20);
        System.out.println("SUCCESS \n");

        System.out.println("About to send TwoDPoints to Line constructor");

        // Try making a new line with two TwoDPoints
        try
        {
            Line l3 = new Line(point1, point2);
            System.out.println("SUCCESS \n");
        }
        catch(Exception e)
        {   
            System.exit(88);
        }

        System.out.println("About to try making a line l4 with an invalid y1 value");

        // Try making a new line l4 with an invalid y1 value
        try
        {
            Line l4 = new Line(5, 500, 50, 100);
        }
        catch(Exception e)
        {
            System.out.println("EXCEPTION: This try catch caught a Generic Exception for a bad constructor - Failed to create a line with 4 invalid values - leaving with rc of 88");
            System.exit(88);
        }

    } // end of main

}  // end class TestLine











