/*
*
* Programmers: Brayan Chacha Gonzalez  (z1861700)
* Programmers: Marcus Schumacher       (z1874458)
*      Course: CSCI 470, Programming in Java 
*  Assignmnet: Assignment01  
*    Date Due: 9/5/20
*
*  Class Name: DriverTest
*  	       In this DriverTest we will test the Employee 
*  	       and class Functionality 
*/

// Creating DriverTest class 
public class DriverTest
{
	public static void main(String[] args)
	{

		// Creating 2 employees 
		Employee e1 = new Employee("Dave", "Smith", 3000.00);
		Employee e2 = new Employee("Brian", "Donohue", 1000.00);
		
		// Print their current yearly slaries
		System.out.printf("Yearly Salary of E1: %.2f \n", e1.getMonthlySalary());
		System.out.printf("Yearly Salary of E2: %.2f \n", e2.getMonthlySalary());

		// Give both employees a raise of 10%
		e1.setMonthlySalary(e1.getMonthlySalary() * 1.10); 
		e2.setMonthlySalary(e2.getMonthlySalary() * 1.10); 

		System.out.println("After 10% raise ---------------------");

		// Print their new employee salaries
		System.out.printf("Yearly Salary of E1: %.2f \n", e1.getMonthlySalary());
		System.out.printf("Yearly Salary of E2: %.2f \n", e2.getMonthlySalary());


		// Make a new date object
		Date d = new Date(4,5,1999);

		// Display the date in the instance
		System.out.println("Time to display the date right after we constucted it!");
		d.displayDate();

		System.out.println("I wonder if our getters work");

		// Make sure the getters work
		System.out.println("Month: " + Integer.toString(d.getMonth()));
		System.out.println("Day: " + Integer.toString(d.getDay()));
		System.out.println("Year: " + Integer.toString(d.getYear()));

		System.out.println("");
		System.out.println("Cool! What about our setters? I'll set the date to 10/10/2010 and see what happens when I run d.displayDate() again!");

		// Testing the setters
		d.setMonth(10);
		d.setDay(10);
		d.setYear(2010);

		d.displayDate();

	}
}






