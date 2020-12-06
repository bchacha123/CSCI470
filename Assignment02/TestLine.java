/*
 *	Programmer: Marcus Schumacher      (z1874458)
 *	Programmer: Brayan Chacha Gonzalez (z1861700)
 *	    Course: CSCI 470, Programming in Java 
 *	Assignment: Assignment02
 *	  Date Due: 9/16/20
 *
 *	Class Name: TestLine
******************************************************************** 
 Now we will define a driver program below called TestLine with 
 main() where execution will begin. It is this class, and this code,
 that will create instances of the Line and call its methods. As a 
 test module, this code would be improved with additional 
 System.out.println() statements that explain what is being attempted
 and what the results should be, for example: "About to change l1 to
 an invalid value and then redraw it. Line position 
 should not change: "
********************************************************************
*/
import chachalinepackage.*;
class TestLine 
{ 

public static void main(String args[]) 
{ 
Line l1 = null, l2 = null; 
//declare 2 instances of Line class 
//create 1 Line object 
l1 = new Line (10, 10, 100, 100); 
//draw it 
l1.draw();
//change start point with valid values, THIS IS LINE 1  
l1.setLine(5, 5, l1.getXTwo(), l1.getYTwo()); 
//draw it again with new start point 
l1.draw();
//l1.getline1();
//try to change xOne (x1) to an illegal value 
l1.setXOne(3000); 
//draw the line...x1 should now be zero 
l1.draw(); 
//create a second Line instance, or object 
l2 = new Line(100, 100, 400, 400); 
//draw 2nd line 
l2.draw(); 
//set a new valid yTwo for line 2 
l2.setYTwo(479); 
//draw 2nd line again 
l2.draw();

//get length line 1
//setting line 1
l1.setLine(5, 5, l1.getXTwo(), l1.getYTwo());
l1.getangle1();
l2.getangle2();
l1.getline1();

//get length line 2
l2.setLine(100, 100, 400, 479);
l2.getline2();

// Tsting the constructor 
System.out.println("test 2D point Constructor X1 = " + "\n");
System.out.println("test 2D point Constructor X2 = " + "\n");
System.out.println("test 2D point Constructor Y1 = " + "\n");
System.out.println("test 2D point Constructor Y2 = " + "\n");
} // end of main

}  // end class TestLine
