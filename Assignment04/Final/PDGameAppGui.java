/*
 	Programmer: Brayan Chacha Gonzalez (Z1861700) 
 	    Course: CSCI 470, Programming in Java
 	Assignment: Assingment04 
 	  Due Date: 10/27/20
 	  
 	Class Name: PDGameAppGUI
 				This class provides an interface for user input. 
 				Within the main() method you will need a Scanner
 				to retrieve the input from the console, a PDGame 
 				object that will control the play of each game, 
 				and a HashMap to store the GameStat objects from 
 				each PDGame.
			
				Final Revised Copy 
*/ 
package pdgameappgui;

import java.util.Date;
import java.util.HashMap;

import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PDGameAppGUI extends JFrame implements ActionListener, ListSelectionListener 
{
	// Instance Variables for PDGameApp, all methods can be access here 
	// Default List model is standard "mode for how a JList will be operated, will put in next statement below 
	//private final DefaultListModel<String> listModelPtr = new DefaultListModel<String>();
	
    private final DefaultListModel<String> listModelPtr = new DefaultListModel<>();
	
	// This is the large text area on right where the user will see the output depending 
    // On what the user presses 
	private final JTextArea gameResultsTA = new JTextArea(15,30);
	
	// This will be filled in by the choice made by user in combo box 
	private int computerStrategy = 1;
	
	// This is a list on top left side and will show times of games played that user will click to see stats of a game 
	// private JList<String> finishedGamesListPtr= new JList<String>(listModelPtr);
    private final JList<String> finishedGamesListPtr;
	
	// Keep same hashmap for games played
	HashMap<String, GameStat> hashMap1 = new HashMap<>();
	
	// Combo box on right side, pointer will be filled in constructor 
	private JComboBox<Object> computerStrategyCB=null; 
	private PDGame currentPDGame = null;
	private String gameStartTimeStr = null;
	
	//These text declarationg will be used to display the stats 
	//after the user has played a game 
	private final JTextField roundsTF = new JTextField(10);
	private final JTextField computerStrategyTF = new JTextField(10);
	private final JTextField computerSentenceTF = new JTextField(10);
	private final JTextField playerSentenceTF = new JTextField(10);
	private final JTextField winnerTF = new JTextField(10);
	
	private final JButton startB = new JButton("Start New Game");  // Button next to combo box
	private final JButton LbuttonB = new JButton("Remain Silent"); // Button next to "Your for this round?"
	private final JButton RbuttonB = new JButton("Testify");       // Button next to LButton 
	
	private final JLabel rightroundDecisionL = new JLabel("Your decision this round?"); // Label next to the buttons to remain silent/Testify
	private final JLabel leftroundsPlayedL = new JLabel("Rounds Played");
	private final JLabel leftcomputerStrategyL = new JLabel("Computer Strategy");
	private final JLabel leftplayerSentanceL = new JLabel("Player Sentence");
	private final JLabel leftcomputerSentence = new JLabel("Computer Sentence");
	private final JLabel leftWinner = new JLabel("Winner");
	
	private final JLabel rightComboBoxComputerStrategyL = new JLabel("Computer Strategy");

	private final int NUM_ROUNDS = 5;
	
	public static void main(String[] args)
	{
		createAndShowGUI();
	}
	
	//C r e a t e A n d S h o w G U I    f u n c t i o n 
	
	// Here we will turn on the GUI
	public static void createAndShowGUI()
	{
		// Create the frame 
		PDGameAppGUI pdg1 = new PDGameAppGUI(); // Call constructor below to set the window to user 
		
		// Method will add listener to button  NEED TO IMPLEMENT!!!       
		pdg1.addListeners(); 
		
		// Exit the application (game) 
		pdg1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Display the window and pack together all panels, etc 
		pdg1.pack();
		pdg1.setVisible(true);
		
	}//End CreateAndShowGUI
	
	public PDGameAppGUI()
	{
		// Fills in the menu at top of JFrame with message
		super("Prisoner's Dilemma");
		
		// Need the file name when choosing option -> Read from input file 
		currentPDGame = new PDGame("input.txt");
		
		// Declaring color 
		Color c1 = new Color(149, 57, 210);  
		Color c2 = new Color(57, 119, 210);
		
		// Set BorderLayout container, arranging and resizing its components to fit in 5 reasons 
		// REMEMBER 5 REGIONS -> NORTH SOUTH EAST WEST 
		super.setLayout(new BorderLayout());
		
		// Set up left blue panel
		JPanel panel1 = new JPanel(new BorderLayout());
		
		// Adding content to frame, 
		super.add(panel1,BorderLayout.WEST);
		
		// Setting list for Game entries 
		finishedGamesListPtr = new JList<>(listModelPtr);
		
		//Set up JList and put it in a scroll panel for scrolling 
		finishedGamesListPtr.setFont(new Font("SansSeif", Font.BOLD, 24));
		finishedGamesListPtr.setVisibleRowCount(10);
		finishedGamesListPtr.setFixedCellWidth(550);
		finishedGamesListPtr.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel1.add(new JScrollPane(finishedGamesListPtr), BorderLayout.NORTH);
		
		//Setting background 
		panel1.setBackground(c2);
		
		//Creating the second panel 
		JPanel panel2 = new JPanel();
		
		//Bottom left results layout 
		//Rows, columns, hgap and vgap 
		panel2.setLayout(new GridLayout(5, 2, 5, 5));
		
		//HEADERS FOR THE LEFT SOUTH AREA 
		//FIRST FOUNDS PLAYED
		
		//Title "Rounds Played"
		panel2.add(leftroundsPlayedL);	
		panel2.add(roundsTF);
		
		//setEditable -> this is used to prevent the user from entering
		//text into the wrong text field
		roundsTF.setEditable(false);
		
		//HEADERS FOR THE LEFT SOUTH AREA 
		//SECOND COMPUTER STRATEGY 
		
		//Title "Computer Strategy"
		panel2.add(leftcomputerStrategyL);
		panel2.add(computerStrategyTF);
		
		//setEditable -> this is used to prevent the user from entering
		//text into the wrong text field
		computerStrategyTF.setEditable(false);
		
		//HEADERS FOR THE LEFT SOUTH AREA 
		//SECOND COMPUTER STRATEGY 
		
		//Title "Player Sentence"
		panel2.add(leftplayerSentanceL);
		panel2.add(playerSentenceTF);
		
		//setEditable -> this is used to prevent the user from entering
		//text into the wrong text field
		playerSentenceTF.setEditable(false);
		
		//HEADERS FOR THE LEFT SOUTH AREA 
		//SECOND COMPUTER STRATEGY 
				
		//Title "Computer Sentence"
		panel2.add(leftcomputerSentence);
		panel2.add(computerSentenceTF);
		
		//setEditable -> this is used to prevent the user from entering
		//text into the wrong text field
		computerSentenceTF.setEditable(false);
		
		//HEADERS FOR THE LEFT SOUTH AREA 
		//SECOND COMPUTER STRATEGY 
				
		//Title "Winner"
		panel2.add(leftWinner);
		panel2.add(winnerTF);
		
		//setEditable -> this is used to prevent the user from entering
		//text into the wrong text field
		winnerTF.setEditable(false);		
		
		//Setting background 
		panel2.setBackground(c2);
		
		//Adding it to the JFrame(Panel1) 
		panel1.add(panel2, BorderLayout.SOUTH);
		
		//TITLE: FOR GAMES THE USER PLAYED 
		//Creating a titledBorder instance 
		TitledBorder title;
		
		//Creating a title and the border for panel1
		title = BorderFactory.createTitledBorder("List of Games");
		
		//Setting it to the JFrame(Panel1)
		panel1.setBorder(title);
		
		//      C R E A T I N G   R I G H T   P A N E L S 
		
		
		//PANEL 3 
		JPanel panel3 = new JPanel(new BorderLayout());
		
		//Adding content to frame, 
		super.add(panel3,BorderLayout.EAST);
		
		
		
		//PANEL 4 
		//Creating panel for the user to pick the strategy and to "begin game"
		JPanel panel4 = new JPanel();
		
		//Creating layout 2 by 1 
		panel4.setLayout(new GridLayout(2, 1));
		
		
		
		//PANEL 5 
		//Creating panel that will go on top of PANEL 4
		//FlowLayout -> object with a centered alignment and horizontal and vertical 
		// gaps with the default size of 5 pixels 
		JPanel panel5 = new JPanel(new FlowLayout());
		
		//Adding Combo box title next to left side of combo box
		panel5.add(rightComboBoxComputerStrategyL);
		
		//COMBO-BOX
		//Two statements below prepare the combo box with computer strategies,
		//need to convert the strategies array, and then it gets placed in combo box 
		
		//Convert ALL to array
		Object[] strategyArray = currentPDGame.getStrategies().toArray();
		
		//Place array into combo-box
		computerStrategyCB = new JComboBox<>(strategyArray);
		computerStrategyCB.setEditable(false);
		
		//This sets starting value to first string in array
		computerStrategyCB.setSelectedIndex(0);
		
		//ADDING TO PANEL5 -> Combo box, Button
		//Adding Combo-box to JFrame (Panel5) and button
		panel5.add(computerStrategyCB);
		
		//Adding the button "Start New Game"
		panel5.add(startB);
		
		//Setting background 
		panel5.setBackground(c1);
		
		// B O T T O M    P A N E L   A F T E R   C O M B O - B O X  
		//			A N D   S T A R T   B U T T O N 
		
		//PANEL 6 
		//This panel will be used to set up the decision of the user 
		JPanel panel6 = new JPanel(new FlowLayout());
		
		//Adding the label "Your Decision this round?"
		panel6.add(rightroundDecisionL);
		
		//Setting background 
		panel6.setBackground(c1);
		
		//Adding the buttons that user will use 
		panel6.add(LbuttonB);
		panel6.add(RbuttonB);
		
		//ADDING THE PANELS 
		
		//Adding Combo-box and headers to Panel4
		panel4.add(panel5);
		
		//Adding decision buttons and label to Panel4
		panel4.add(panel6);
		
		//Adding panel 4 to original frame -> Panel3 
		panel3.add(panel4, BorderLayout.NORTH);
		
		//Current games in progress -> AS ORIGINAL ASSIGNEMNT 
		panel3.add(new JScrollPane(gameResultsTA), BorderLayout.SOUTH);
		
		//Setting restricting to the user, so they don't change anything 
		gameResultsTA.setEditable(false);
		LbuttonB.setEnabled(false);
		RbuttonB.setEnabled(false);
		startB.setEnabled(true);

	} // End PDGameAppGUI
	
	
	
	//A d d l i s t e n e r s   f u c t i o n 
	
	//Hooking up the listener to the buttons that were created
	public void addListeners()
	{
		//Combo-Box action 
		computerStrategyCB.addActionListener(this);
		
		//Start button 
		startB.addActionListener(this);
		
		//Remain Silent button (left) 
		LbuttonB.addActionListener(this);
		
		//Testify Button (right)
		RbuttonB.addActionListener(this);
		
		//Game list 
		finishedGamesListPtr.addListSelectionListener(this);
		
	}//End addListeneres()
	
	
	
	
	//A c t i o n P e r f o r m e d   f u n c t i o n 
	
	//This method will handle what buttons were clicked and what was chosen 
	//by combo-box and will make the appropiate methods 
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == startB) 
		{
			startGame();
		}
		else if (e.getSource() == LbuttonB) 
		{
			cooperate();
		}
		else if (e.getSource() == RbuttonB) {
			betray();
		}
		else if(e.getSource() == computerStrategyCB) {
	         computerStrategy = computerStrategyCB.getSelectedIndex() + 1; //fills in this variable up top		
	    }
		
	}//End actionPerformed(ActionEvent e)
	


	
	
	//S t a r t G a m e   f u n c t i o n 
	
	//This method will start the game and read from and input file called -> input.txt
	//also, will the buttons so the user doesn't change anything 
	public void startGame() 
	{
		//Opening file
		currentPDGame = new PDGame("input.txt");
		
		currentPDGame.setStrategy(computerStrategy);
		
		//Creating current time(date) and converting it to String(key) 
		gameStartTimeStr = (new Date()).toString();
		
		//gameResultsTA.append("***Prisoner's Dilemma*** \n");
		gameResultsTA.append("***Prisoner's Dilemma***" + "\n");
		
		//Preventing User to change any data 
		LbuttonB.setEnabled(true);
		RbuttonB.setEnabled(true);
		startB.setEnabled(false);
		
		//Asking the User for its -> call prompPlayer function 
		prompPlayer();
		
	}//End startGame
	
	
	
	
	
	
	//C o o p e r a t e   f u n c t i o n 
	
	//This method will output when the User or Computer remained silent 
	//by pressing the "Remain Silent" button 
	public void cooperate() {
		
		//Returning the results of each round
		String Round_Results = currentPDGame.playRound(1);
		
		//Placing the results on the screen
		gameResultsTA.append(Round_Results + "\n");
		
		//Loop -> Maximum number of 5 games else end the game 
		if(currentPDGame.getStat().getRounds() >= NUM_ROUNDS) {
			
			//End the Game
			endGame();
		
			} else {
	
				//Ask the user -> to press buttons (Remain Silent) or (Testify) 
				prompPlayer();	
			}
	}//End cooperate 
	
	
	
	
	
	
	//B e t r a y   f u n c t i o n 
	
	//This method will output when the User or Computer remained silent 
	//by pressing the "Testify" button 
	public void betray() {
		
		//Returning the results of each round
		String Round_Results = currentPDGame.playRound(2);
		
		//Placing the results on the screen
		gameResultsTA.append(Round_Results + "\n");
		
		//Loop -> Maximum number of 5 games else end the game 
		if(currentPDGame.getStat().getRounds() >= NUM_ROUNDS) {
			
			//End the Game
			endGame();
		
			} else {
	
				//Ask the user -> to press buttons (Remain Silent) or (Testify) 
				prompPlayer();	
			}
		
	}//End betray
	
	
	
	//P r o m p P l a y e r   f u n c t i o n 
	
	//This function will display the decision the user can pick
	public void prompPlayer() {
		String UserPromt = "\n1. Cooperate with your partner and remain silent." + "\n"
							+ "2. Betray and testify against your partner" + "\n\n" + 
							"What is your decision this round?" + "\n\n";
		
		//Displaying  
		gameResultsTA.append(UserPromt);
		
	}//End prompPlayer

	
	
	
	
	//E n d g a m e   f u n c t i o n 
	
	//This function will end the game 
	public void endGame() {
		
		//Setting up end of the scores 
		String FinalScores = currentPDGame.getScores(); 
		
		//Displaying final scores to gameResultsTA
		gameResultsTA.append(FinalScores + "\n");
		
		//Refresh the HashMap
		hashMap1.put(gameStartTimeStr, currentPDGame.getStat());
		
		//Updating the list 
		listModelPtr.addElement(gameStartTimeStr);
		
		//Preventing User to change any data 
		LbuttonB.setEnabled(false);
		RbuttonB.setEnabled(false);
		startB.setEnabled(true);
		
	}//End endGame
	
	
	
	
	
	//V a l u e c h a n g e d    f u n c t i o n 
	
	//This function will allow the user to click on the finished 
	//games in the upper left JList box and will show the results of the game
	public void valueChanged(ListSelectionEvent e){
		
		//Declaring a key 
		String Search_Key;
		
		//isSelectionEmpty -> will return true if no indices are selected 
		if(!finishedGamesListPtr.isSelectionEmpty()){
			
			//Search the hash map 
			Search_Key = (String) finishedGamesListPtr.getSelectedValue();
			
			//Getting values from the hashMap
			GameStat GameStatInformation;
			
			GameStatInformation = hashMap1.get(Search_Key);
			
			//ROUNDS PLAYED 
			//Displaying the number of rounds played, getting it from the getters
			roundsTF.setText(Integer.toString(GameStatInformation.getRounds()));
			
			
			//COMPUTER STATEGY 
			//Getting the information from the getters
			String computerStrategy = GameStatInformation.getCompStrategy();
			
			//Displaying the Computer Strategy 
			computerStrategyTF.setText(String.format("%s", computerStrategy));
			
			
			//PLAYER SENTENCE 
			//Getting the information from the getters
			int playerSentence = GameStatInformation.getuser_sentence();
			
			//Displaying the Player Sentence 
			playerSentenceTF.setText(String.format("%d %s", playerSentence, 
									((playerSentence > 1) ? " years" : " years")));
			
			//COMPUTER SENTENCE 
			//Getting the information from the getters
			int computerSentence = GameStatInformation.getcomputer_sentence();
			
			//Displaying the Computer Sentence 
			computerSentenceTF.setText(String.format("%d %s", computerSentence, 
									((computerSentence > 1) ? " years" : " years")));
			
			//WINNER 
			//Getting the information from the getters 
			String winner = GameStatInformation.getWinner();
			
			//Displaying the Winner 
			winnerTF.setText(String.format("%s", winner));

		}//End loop
		
	}//End valueChanged 
	
}// End PDGameAppGUI