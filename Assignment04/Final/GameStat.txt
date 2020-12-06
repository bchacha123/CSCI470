package pdgameappgui;
/*
	Programmer: Brayan Chacha Gonzalez (Z1861700) 
	    Course: CSCI 470, Programming in Java
	Assignment: Assingment03 
	  Due Date: 09/30/20
	  
	Class Name: Game Stat
				This class has private ints that track the player and computer 
				sentence/years and the number of rounds played. 
				
				
				Added rounds function 
				Final Revised Copy 
*/

public class GameStat {

//Variables for GameStat class
String computer_strategy;
int user_sentence;
int computer_sentence;

//ADDED ASSIGNMENT4 
int rounds;

//Increments the stats and is called from PDGame
public void update(int user_sentence, int computer_sentence)
{
	this.user_sentence += user_sentence;
	this.computer_sentence += computer_sentence;
	
	//ADDED ASSINGMENT04
	rounds++;
}

//Constructor
public GameStat()
{
	//initializing the variables
	user_sentence = 0;
	computer_sentence = 0;
	
	rounds = 0;
}

//Getters -> getCompStrategy
public String getCompStrategy() 
{
    return computer_strategy;
}

//Getters -> getWinner 
public String getWinner()
{
    if (user_sentence < computer_sentence) 
    {
        return " player";
        
    } else if (computer_sentence < user_sentence) 
    {
        return " computer";
        
    } else {
        return " none!";
    }
}

//Getters -> getuser_sentence
public int getuser_sentence() {
	return user_sentence;
}

//Getters -> getcomputer_sentence
public int getcomputer_sentence() {
	return computer_sentence;
}

//Setters -> setCompStrategy
public void setCompStrategy(String computer_strategy) {
	this.computer_strategy = computer_strategy;
}


public int getRounds() 
{
	return rounds;
}//End Get Rounds
}