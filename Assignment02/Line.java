/*
 * 	Programmers: Marcus Schaucher  (z1874458)
 * 	Programmers: Brayan Chacha     (z1861700)
 *
 * 	Class Name: Line
*******************************************************************    
This program demonstrates a simple "Line" class. Here, a Line class
 is defined with its properties and interface (i.e., its methods). 
A main method (in TestLine) then creates instances of this Line
 class and calls on the methods to demonstrate its behavior. 
*****************************************************************/
package chachalinepackage;
import java.lang.Math; // Use for square root of lengths 
import java.io.*;

public class Line
{

private int x1, y1, x2, y2; //coordinates of the line  
//Constructor 
//Receives 4 integers which are the Line's start and end points. 
public Line(int xOne, int yOne, int xTwo, int yTwo) 
{ 
// each of these validates its argument - see below. 
this.x1 = xOne;
this.y1 = yOne;
this.x2 = xTwo;
this.y2 = yTwo;
//setXOne(xOne); 
//setYOne(yOne); 
//setXTwo(xTwo); 
//setYTwo(yTwo);
} // end constructor

// 2nd Constructor 
// Receives 2 integers 
public Line(int x, int y)
{
this.x1 = x;
this.y1 = y;
this.x2 = x;
this.y2 = y;
} // end 2ns constructor 

//method draw() calls another method called drawLine(), 
//which is assumed to be a graphics primitive on the 
//system. However, since this program will be 
//run in console mode, a text description of the Line 
//will be displayed. // 
public void draw() 
{ 
drawLine(x1, y1, x2, y2);
}

//getline1 calls another method called lengthLine1,
//which it will print the length of the line 1
public void getline1()
{
lengthLine1(x1, y1, x2, y2); 
}

//getangle1 calls another method 
public void getangle1()
{
//angleLine1
angleLine1(x1, y1, x2, y2);
}

//getline2() calls another method called lengthLine2, 
//whuch it will print the length of the line 2
public void getline2()
{
lengthLine2(x1, y1, x2, y2);
}

public void getangle2()
{
angleLine2(x1, y1, x2, y2);
}


//method drawLine() simulates drawing of a line for console mode. 
//It should describe all the important attributes of the line. 
//In a graphics mode program, we would delete this and use the 
//system's Graphics library drawLine(). // 
private void drawLine(int x1, int y1, int x2, int y2) 
{ 
System.out.println("In drawline -draw a line from x of " + x1 + " and y of " + y1); 
System.out.println("to x of " + x2 + " and y of " + y2 + "\n");
}

//method getline1() calculates line 1 by calling getLength() method 
private void lengthLine1(int x1, int y1, int x2, int y2)
{
System.out.println("The length for line 1 is " + getLength()); 
}

//method getline2() calculates line 2 by calling getLength() method  
private void lengthLine2(int x1, int y1, int x2, int y2)
{
System.out.println("The length for line 2 is " + getLength() + "\n");
}

//method getangle1 calculates line 1 by calling getAngle() method 
private void angleLine1(int x1, int y1, int x2, int y2)
{
System.out.println("The angle for line 1 is " + getAngle());
}

//method getLine2 calculates angle 2 byt calling getAngle() method
private void angleLine2(int x1, int y1, int x2, int y2)
{
System.out.println("The angle for line 2 is " + getAngle() + "\n");
}

//Method setLine() allows user to change the points of the 
//already existing Line. 
public void setLine(int xOne, int yOne, int xTwo, int yTwo) 
{ 
  setXOne(xOne);
  setYOne(yOne);
  setXTwo(xTwo);
  setYTwo(yTwo);
} 
// -- the individual setXXXX methods that prevent 
//  any line's coordinate from being offscreen.  
//  In the event of an invalid (offscreen) value,  
//  that value is (silently) set to 0. 
public void setXOne(int xOne)
{
if (xOne < 0 || xOne > 639)
x1 = 0;
else
x1 = xOne;
} 
public void setYOne(int yOne) 
{    
if (yOne < 0 || yOne > 479)
y1 = 0;
else
y1 = yOne;
} 
public void setXTwo(int xTwo) 
{    
if (xTwo > 639 || xTwo < 0)
x2 = 0;
else
x2 = xTwo;
} 
public void setYTwo(int yTwo) 
{    
if (yTwo > 479 || yTwo < 0)
y2 = 0;
else
y2 = yTwo;
} 
//Now for some "get" Access methods to get individual values 
public int getXOne() 
{  return x1; 
}  
public int getYOne() 
{  
return y1; 
}  
public int getXTwo()
{
return x2; 
} 
public int getYTwo() 
{ 
return y2; 
}
// getLength(), will calculate and return the length of a line 
// based on its coordinates. This method will use a formula
// sprt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)) 
public double getLength()
{
	return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));	
} //end getLength 

// getAngele(), will calculate and return the angle of a line 
// based on its coordinates. This method will use a formula 
// asin((y2-y1)/lenth)
public double getAngle()
{
	return Math.asin((y2-y1)/getLength());
}

} // end class Line
