/*
	Programmer: Brayan Chacha Gonzalez (Z1861700) 
	    Course: CSCI 470, Programming in Java
	Assignment: Assingment03 
	  Due Date: 09/30/20
	  
	Class Name: PDGame 
				This class represents the game itself and controls the 
				logic for it. It contains an ArrayList for keeping the 
				user history, an array or ArrayList of strings for each
				of the strategies you implement below, a GameStat null 
				reference object that when filled in will record the 
				game stats, a Scanner, and an integer to determine the 
				strategy the computer is using.
				
				FINAL REVISED COPY
*/
package pdgameappgui;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class PDGame {

//ArrayList holding the User history 
private ArrayList<Integer> UserHistory = new ArrayList<>();

//ArrayList holding the strategies 
private ArrayList<String> AllComputerStrategies = new ArrayList<>();

//GameStat null reference object, will record the game stats
private GameStat stats = new GameStat();

//Variable for user strategy
private int Strategy;

//Scanner object
private Scanner scan1;

//Creating a constructor that initialize the scanner to 
//read from a file that contains 1s and 2s 
public PDGame(String file)
{
	//Adding the Strategies to the ArraList 
	AllComputerStrategies.add("Computer Reads Strategy From Input File ");
	AllComputerStrategies.add("Random Choice by Computer ");
	AllComputerStrategies.add("Tit-For-Tat ");
	
	//Check if file is available 
    try 
    {
    	//open input.txt
        File input = new File(file);   
        
        //Pointer to begging of file -> input.txt
        scan1 = new Scanner(input);  
        
      //File doesn't exist   
    } catch (FileNotFoundException e) 
    {
    	//Display to User message 
        System.out.println("File Not Found, try again! "); 
        
        //Close program 
        System.exit(0);
        
    }//End try/catch

}//End Constructor 

//playRound generates the computer's decision based on the strategy selected,
//Determines the outcome based on the two decisions, and updated the GameStat obj
//According to the scoring above.
public String playRound(int userDesicion)
{
	//Variables will hold sentences 
	int User;
	int Computer;
	
	//The computer decision is computed by another method below 
	int computer_decision = figureDesicion();
	
	//Add the Users decision to the ArrayList -> UserHistory 
	UserHistory.add(userDesicion);
	
	//Scoring for User and Computer 
	if(userDesicion == 1 && computer_decision == 1) 
	{
		//Prison Sentence 
		User = 2;
		Computer = 2;
		
		//Updating GameStat 
		stats.update(User,Computer);
		
		//Display game to User 
		return "You and your partner remain sielnt. \n" + "You both get 2 years in prison. \n";
	}else if (userDesicion == 2 && computer_decision == 1) 
	{
		//Prison Sentence 
		User = 1;
		Computer = 5;
		
		//Updating GameStat
		stats.update(User,Computer);
		
		//Display game to User 
		return "You testify against your partner and they remain silent. \n" + "You get 1 year in prison and they get 5. \n";
	}else if (userDesicion == 1 && computer_decision == 2) 
	{
		//Prison Sentence 
		User = 5;
		Computer = 1;
		
		//Updating GameStat
		stats.update(User,Computer);
		
		//Display game to User 
		return "You remain silent and your partner testifies against you. \n" + "You get 5 year in prison and they get 1. \n";
	}else 
	{
		//Prison Sentence 
		User = 3;
		Computer = 3;
		
		//Updating GameStat
		stats.update(User,Computer);
		
		//Display game to User 
		return "You both testify against each other \n" + "You both get 3 years in prison\n";
	}
	
}//End playRound(int userDesicion)

//FigureDesicion -> This method find the computer decision 
private int figureDesicion()
{
	//From File - Cooperates and betray based on input file has 1s and 2s
	if (Strategy == 1)
	{
		//Return num from file 
		return scan1.nextInt();
	
	 //Random num generated 
	} else if (Strategy == 2) 
	{
		//Generate 1 or 2 
		return(int)(Math.random() * 2 + 1);
		
	  //Tit-For-Tat - Cooperate on the first move, otherwise play the player's last move 	
	} else if (UserHistory.isEmpty()) 
	{
		return 1;	
	
	  //Return previous value of user 
	} else 
	{
		int previous_desicion = UserHistory.get(UserHistory.size() -1);
		return previous_desicion;	
	}
	
}//end figureDesition

//Getters that accessed the private members 
// -> strategies, scores, stats
public ArrayList<String> getStrategies()
{
	return AllComputerStrategies;
}

//GetScores
public String getScores()
{
	return "Your prison sentince is " + stats.getuser_sentence() + "\n" + 
           "Your partners prison sentence is " + stats.getcomputer_sentence();
}

//GetStats
public GameStat getStat()
{
	return stats;
}

//Setter for setStrategy
public void setStrategy(int Strategy) {
    this.Strategy = Strategy;
    
    // call the GameStat setter to set stratergy in its object 
    stats.setCompStrategy(AllComputerStrategies.get(Strategy - 1));
}

}//End Class PDGame