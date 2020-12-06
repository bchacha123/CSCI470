/*
 *   Programmer: Marcus Schuchacher     (z1874458)
 *   Programmer: Brayan Chacha Gonzalez (Z1861700)
 *
 *   Class Name: Date 
 *   		 This class will hold three instance variables to record a date 
 *   		 using getters and setters (get & set) to a specific variables. 
 */

// Creating Date class 
public class Date
{
	// initilizing date month, day, year
	int month;
	int day;
	int year;

	// Constructor initializing 
	public Date(int month, int day, int year)
	{
		// Setting month 
		this.month = month;

		// Setting day 
		this.day = day;

		// Setting year
		this.year = year;
	}


	// Just print out the value of the three instance variables, slightly formated
	public void displayDate()
	{
		System.out.println("\n" + this.month + "/" + this.day + "/" + this.year + "\n");
	}
	
	// Get and Set methods 
	// Get mothod for month
	public int getMonth()
	{
		return this.month;
	}

	// Set method for month
	public void setMonth(int month)
	{
		this.month = month;
	}

	// Get method for day  
	public int getDay()
	{
		return this.day;
	}

	// Set method for day 
	public void setDay(int day)
	{
		this.day = day;
	}

	// Get method for year 
	public int getYear()
	{
		return this.year;
	}

	// Set method for year 
	public void setYear(int year)
	{
		this.year = year;
	}

}































