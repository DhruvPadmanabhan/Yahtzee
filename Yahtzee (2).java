//module workingYahtzee {
//module NewYahtzeeFinal {
//module YahtzeeFinal {
//module Yahtzee {
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.*;
public class Yahtzee
{
	public String gameModeUserChoice;
	public String Name;
	public static int[][] diceroll ={ 
			{ 0, 0, 0 ,0 ,0 },
			{ 0 ,0 ,0 ,0 ,0 }};
	public static boolean isDebugMode;
	public static int turncounter = 0;

	public static void main(String []args){

		Scanner sc = new Scanner(System.in);
		isDebugMode = false;
		ArrayList<Integer> scores = new ArrayList<Integer>( ); 
		int roundScore = 0;
		double totalScore = 0;
		double average = 0;
		System.out.println("Welcome to YAHTZEE");
		System.out.println("What is your name?");
		String firstName = sc.next();
		System.out.println(firstName+", welcome to the main menu. The options are below");
		System.out.println("");
		System.out.println("R: print the RULES of Yahtzee");
		System.out.println("O: play a ONE PERSON game");
		System.out.println("OD: play a ONE PERSON game with DEBUGGING");
		System.out.println("T: play a TWO PERSON game against the computer");
		System.out.println("TD: play a TWO PERSON game against the computer with DEBUGGING");
		System.out.println("CS: watch the COMPUTER play SOLITAIRE");
		System.out.println("CSD: watch the COMPUTER play SOLITAIRE with DEBUGGING");
		System.out.println("MCG: watch the COMPUTER play multiple games");
		System.out.println("Q: quit");
		System.out.println("Which Game would you like to play");
		String chosenGameMode = sc.next();
		System.out.println("Chosen Game = "+chosenGameMode);
		if (chosenGameMode.equalsIgnoreCase("OD")||chosenGameMode.equalsIgnoreCase("TD")|| chosenGameMode.equalsIgnoreCase("CSD"))
		{
			isDebugMode = true;
		}
		if (chosenGameMode.equals("R"))
		{
			rules();
		}
		if (chosenGameMode.equalsIgnoreCase("Q"))
		{
			System.out.println("Next time I hope that you want to play Yahtzee");
			System.out.println("GoodBye Human");


		}
		if (chosenGameMode.equalsIgnoreCase("O") || chosenGameMode.equalsIgnoreCase("OD"))
		{
			Player humanPlayer = new Human (firstName);
			System.out.println("Welcome to your solo Yahtzee!");
			Score scoreCardObjectHuman = new Score ();
			Dice diceObjectHuman = new Dice ();
			for(int i = 0; i<13; i++)
			{
				humanPlayer.playOneTurn(firstName, isDebugMode, scoreCardObjectHuman, diceObjectHuman);
			}


			//if ()
		}
		if (chosenGameMode.equalsIgnoreCase("T") || chosenGameMode.equalsIgnoreCase("TD")) 
		{
			Player humanVs = new Human (firstName);
			String MSGNot = "N";
			Score scoreCardObjectComp = new Score ();
			Dice diceObjectComp = new Dice ();
			Score scoreCardObjectHuman = new Score ();
			Dice diceObjectHuman = new Dice ();
			Computer compVs = new Computer ("Ned the bot", MSGNot);
			for (int i = 0; i<13; i++)
			{
				humanVs.playOneTurn(firstName, isDebugMode, scoreCardObjectHuman, diceObjectHuman);
				compVs.playOneTurn(firstName, isDebugMode, scoreCardObjectComp,diceObjectComp );
			}


		}

		if (chosenGameMode.equalsIgnoreCase("CS") || chosenGameMode.equalsIgnoreCase("CSD"))
		{
			firstName = "Ned the bot";
			Score scoreCardObjectComp = new Score ();
			Dice diceObjectComp = new Dice ();
			String MSGNot = "N";
			Computer soloComputer = new Computer (firstName, MSGNot);
			System.out.println("Starting Computer Yahtzee Bee Boop Bee Boop");
			for (int i = 0; i<13; i++)
			{
				soloComputer.playOneTurn(firstName, isDebugMode, scoreCardObjectComp, diceObjectComp);
			}
			checkForHighScore(scoreCardObjectComp.sumOfArray(scoreCardObjectComp.generalScoreCard));




		}

		if (chosenGameMode.equalsIgnoreCase("MCG"))
		{
			DecimalFormat df = new DecimalFormat("#0.00");
			System.out.println("How many times would you like to play a game?");
			int NumberOfTimes = sc.nextInt();
			System.out.println("Put in N for printing the moves or MCG for quiet modes.");
			String MCGorNot = sc.next();
			System.out.println("Starting Computer Yahtzee Bee Boop Bee Boop");
			for(int i = 0; i<NumberOfTimes; i++)
			{
				firstName = "Ned";
				Score scoreCardMCG = new Score ();
				Dice diceObjectMCG = new Dice ();
				Computer soloComputerMSG = new Computer (firstName, MCGorNot);
				for (int m = 0; m<13; m++)
				{
					soloComputerMSG.playOneTurn(firstName, isDebugMode, scoreCardMCG, diceObjectMCG);

				}
				roundScore = sumOfArray(scoreCardMCG.generalScoreCard);
				scores.add(roundScore);
				
			}
			
			totalScore = sumOfArrayList(scores);
			average = totalScore/NumberOfTimes;
			System.out.println("The list of scores is as follows :");
			printArrayList(scores);
			System.out.println("The average of the scores is "+df.format(average));
			int[] scoresButArray = new int [scores.size()];
			 for (int i =0; i < scores.size(); i++)
			 {
				 scoresButArray[i] = scores.get(i); 
			 }
			 Arrays.sort(scoresButArray);
			 int middle = scoresButArray.length/2;
			 int medianValue = 0; //declare variable 
			 if (scoresButArray.length%2 == 1) 
			     medianValue = scoresButArray[middle];
			 else
			    medianValue = (scoresButArray[middle-1] + scoresButArray[middle]) / 2;
			 System.out.println("The Median Value is "+df.format(medianValue));
		}


	}







	public static void rules()
	// Pre : Nothing received
	// Post : Prints the rules of Yahtzee
	
	{
		System.out.println(" On each turn a player rolls the five dice."
				+ "\n After they have rolled, "
				+ "\n they can roll again if they want,"
				+ "\n choosing which dice to keep and which ones to roll again."
				+ "\n They can roll a total of three times on each turn, and they can "
				+ " \n keep as few or as many of the dice as they want on each roll.\n" + 
				"\n" + 
				"Once they have either decided to keep all five dice"
				+ "\n or used all three rolls, they must then enter their"
				+ " \nscore onto the scorecard.\n" + 
				"\n" + 
				"A Yahtzee scorecard has a total of 13 boxes, "
				+ "\n and on each turn a player must decide which box to"
				+ "\n  enter their score."
				+ " \n Each box is a different category and the score is "
				+ "\n calculated in different ways for each one.\n" + 
				"\n" + 
				"During a game every participating player gets a total of "
				+ "\n 13 turns, and they must"
				+ " \n enter one score into a different box on each turn.");


	}








	public static int sumOfArray (int [] [] theRolls)
	// Pre : Receives a 2d array of the five dice rolls
	// Post : Returns an int with the sum of the bottom row of the array
	{
		int totalSum = 0;
		for (int i =0; i<theRolls[0].length; i++)
		{
			totalSum = totalSum + theRolls[1][i];	
		}
		return totalSum;
	}





	private static void checkForHighScore(int currentScore)
	// Receives an int with the current score of the round for the computer
	// Checks and accordingly sets a high score basaed on the computer score
	{
		File inputFile = new File("./HighScores");
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		int reverse = 5;
		try {
			sc2 = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

		}

		while (sc2.hasNext())
		{
			int [] highScores = new int [5];
			int i = 0;
			while (sc2.hasNextInt())
			{
				highScores[i++] = sc2.nextInt();
			}
			Arrays.sort(highScores);
			if (currentScore>highScores[0])
			{
				highScores[0] = currentScore;
				if (currentScore>highScores[4])
				{
					System.out.println("Comp just broke the highest score!");
				}
				else
				{
					System.out.println("Comp just got a top 5 score!");
				}

			}
			else {
				System.out.println("No high score this round");
			}
			Arrays.sort(highScores);

			System.out.println("The current high scores:");
			for(int count = 0; count<5;count++ )
			{

				System.out.println(reverse+". "+highScores[count]);
				reverse--;
				System.out.println("");
			}

			FileWriter outFile = null;
			try {
				outFile = new FileWriter("./HighScores");
			} catch(IOException e1) {
				e1.printStackTrace();
			}

			PrintWriter writeFile = new PrintWriter(outFile);
			for (int count = 0; count<5; count++)
			{
				writeFile.println(highScores[count]);
			}

			writeFile.close();
		}

	}
	
	public static void printArrayList(ArrayList toPrint)
	// Pre : Receives an Array List
	// Post : Prints the Array List
	
	{
		for (int i=0; i<toPrint.size(); i++)
		{
			System.out.println(toPrint.get(i));
		}
	}
	
	public static int sumOfArrayList(ArrayList<Integer> m)
	// Pre : Receives an Array List
	// Post : Finds the sum of all the elements in the array list
	{
		int sum = 0;
		for(int i = 0; i < m.size(); i++)
		{
		    sum = sum + m.get(i);
		    
		}
		return sum;
	}


}


