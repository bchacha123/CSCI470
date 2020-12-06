
/*
 *   Programmer: Brayan Chacha Gonzalez (z1861700)
 *   Programmer: Marcus Schumacher      (z1874458) 
 *
 *   Class Name: Employee 
 *   		 This class will store information about a specific employee
 *   		 utilize getters and setters.          
 */

//Creating Employee class 
public class Employee
{

	// Employee first and last name 
	String firstName, lastName;

	// Monthly salary 
	double monthlySalary;

	// Constructor initializing 
	public Employee(String firstName, String lastName, double monthlySalary)
	{
		// Setting first name 
		this.firstName = firstName;

		// Setting last name 
		this.lastName = lastName;
		

		// The monthly salary can't be negative! 
		if(monthlySalary >= 0)
		{
			// Setting salary 
			this.monthlySalary = monthlySalary;
		}
		else
		{
			// Message -> Employee salary set to 0
			System.out.println("Salary can't be negative. Employee salary is set to 0.");

			// Setting Salary to  0
			this.monthlySalary = 0;
		}
	}


	// Setters
	// Set method for employee first name 
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	// Set method for employee last name 
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	// Set method for employee salary 
	public void setMonthlySalary(double monthlySalary)
	{
		this.monthlySalary = monthlySalary;
	}

	// Getters
	// Get method for employee first name 
	public String getFirstName()
	{
		return this.firstName;
	}

	// Get method for employee last name 
	public String getLastName()
	{
		return this.lastName;
	}

	// Get method for employee salary 
	public double getMonthlySalary()
	{
		return this.monthlySalary;
	}
}




















