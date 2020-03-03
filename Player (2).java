import java.util.Random;
import java.util.Scanner;

public abstract class Player {
	public String name = "";
	public static int [] [] generalScoreCard = {



			//  0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16

			{ 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
			{ 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 0}};


	Player()

	{



	}


	public void rollDice(Dice diceRolls, boolean debug, String mCGVersion)
	// Pre : Receives a Dice Object and a debug option
	// Post : Rolls the dice and prints out the results
	{



		diceRolls.changeDie(debug, mCGVersion);
		if (mCGVersion.equals("MCG"))
		{

		}
		else
		{diceRolls.toString();
		}



	}


	abstract void chooseDiceToKeep();

	abstract String chooseCategory(Score object);


	abstract void playOneTurn(String firstName, boolean isDebugMode, Score scoreCardObjectHuman, Dice diceObjectHuman);




}


class Human extends Player
{


	public int [][] Human2dArray= new int [1][15];








	public Human(String setName)
	{

		super.name = setName;


	}







	public void playOneTurn(String firstname, boolean debug, Score newScoreCard, Dice newDiceRoll)
	// Pre : Receives the user's first name, a debug option, a scorecard object and a dice object
	// Post : Plays one turn for the user
	{

		for (int i = 0; i<2; i++)
		{
			super.rollDice(newDiceRoll, debug, "");
			newDiceRoll.theDiceRolls = chooseDiceToKeep(newDiceRoll.returnDice());
		}
		super.rollDice(newDiceRoll, debug, ""); // 3rd roll no need for user input
		newScoreCard.calculatePotentialScore(newDiceRoll.theDiceRolls, "");
		//super.printScoreCard(potential);
		String choice = chooseCategory(newScoreCard);
		String human = "human";
		generalScoreCard = newScoreCard.checkAndAssignScores(choice,newDiceRoll.theDiceRolls, human, "");
		//current = scoreCardObject.updateScoreCard();
		System.out.println(this.name+", your score card is below");
		newScoreCard.printScoreCard(generalScoreCard);
		System.out.println("");
		System.out.println("----------------------------");
		clearingTheDice(newDiceRoll);

	}




	public int[][] chooseDiceToKeep(int[][] theDiceRolls)
	// Pre : Receives a 2d array of dice rolls
	// Post : Returns a combination of dice to keep and reroll
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("For each die, put a K for keep or R for reroll");
		System.out.println("Die 1 ("+theDiceRolls[1][0]+") :");
		String dieRoll1 = sc.nextLine();
		System.out.println("Die 2 ("+theDiceRolls[1][1]+") :");
		String dieRoll2 = sc.nextLine();
		System.out.println("Die 3 ("+theDiceRolls[1][2]+") :");
		String dieRoll3 = sc.nextLine();
		System.out.println("Die 4 ("+theDiceRolls[1][3]+") :");
		String dieRoll4 = sc.nextLine();
		System.out.println("Die 5 ("+theDiceRolls[1][4]+") :");
		String dieRoll5 = sc.nextLine();
		if (dieRoll1.equalsIgnoreCase("K"))
		{
			theDiceRolls[0][0] = 1;
		}
		if(dieRoll1.equalsIgnoreCase("R"))
		{
			theDiceRolls[0][0] = 0;
		}

		if (dieRoll2.equalsIgnoreCase("K"))
		{
			theDiceRolls[0][1] = 1;
		}
		if(dieRoll2.equalsIgnoreCase("R"))
		{
			theDiceRolls[0][1] = 0;
		}
		if (dieRoll3.equalsIgnoreCase("K"))
		{
			theDiceRolls[0][2] = 1;
		}
		if(dieRoll3.equalsIgnoreCase("R"))
		{
			theDiceRolls[0][2] = 0;
		}
		if (dieRoll4.equalsIgnoreCase("K"))
		{
			theDiceRolls[0][3] = 1;
		}
		if(dieRoll4.equalsIgnoreCase("R"))
		{
			theDiceRolls[0][3] = 0;
		}
		if (dieRoll5.equalsIgnoreCase("K"))
		{
			theDiceRolls[0][4] = 1;
		}
		if(dieRoll5.equalsIgnoreCase("R"))
		{
			theDiceRolls[0][4] = 0;
		}


		return theDiceRolls;

	}


	public String chooseCategory(Score theScore)
	// Pre : Receives a Score object
	// Post : Chooses a category to score the diceroll
	{
		Scanner sc = new Scanner(System.in);
		String userChoice = "";
		boolean reRandomize = false;
		while(reRandomize == false)
		{
			System.out.println("Choose an empty category to score your dice.\n" + 
					"\n" + 
					"1: ones  2: twos  3: threes  4: fours   5: fives  6: sixes  3K: 3 of a Kind  4K: 4 of a Kind  \n" + 
					"FH: Full House  SS: Small Straight  LS: Large Straight  Y:   Yahtzee  C:    Chance\n" + 
					"");

			System.out.println("Which option do you want to pick?");
			userChoice = sc.next();	
			if (userChoice.equals("1"))
			{
				if (theScore.generalScoreCard[0][0] != 9 )
				{
					reRandomize = true;
				}
			}
			if (userChoice.equals("2"))
			{
				if (theScore.generalScoreCard[0][1] != 9 )
				{
					reRandomize = true;
				}
			}
			if (userChoice.equals("3"))
			{
				if (theScore.generalScoreCard[0][2] != 9 )
				{
					reRandomize = true;
				}
			}
			if (userChoice.equals("4"))
			{
				if (theScore.generalScoreCard[0][3] != 9 )
				{
					reRandomize = true;
				}
			}
			if (userChoice.equals("5"))
			{
				if (theScore.generalScoreCard[0][4] != 9 )
				{
					reRandomize = true;
				}
			}
			if (userChoice.equals("6"))
			{
				if (theScore.generalScoreCard[0][5] != 9 )
				{
					reRandomize = true;
				}
			}
			if (userChoice.equalsIgnoreCase("3k"))
			{
				if (theScore.generalScoreCard[0][6] != 9 )
				{
					reRandomize = true;
				}
			}
			if (userChoice.equalsIgnoreCase("4k"))
			{
				if (theScore.generalScoreCard[0][7] != 9 )
				{
					reRandomize = true;
				}
			}
			if (userChoice.equalsIgnoreCase("FH"))
			{
				if (theScore.generalScoreCard[0][8] != 9 )
				{
					reRandomize = true;
				}
			}
			if (userChoice.equalsIgnoreCase("SS"))
			{
				if (theScore.generalScoreCard[0][9] != 9 )
				{
					reRandomize = true;
				}
			}
			if (userChoice.equalsIgnoreCase("LS"))
			{
				if (theScore.generalScoreCard[0][10] != 9 )
				{
					reRandomize = true;
				}
			}
			if (userChoice.equalsIgnoreCase("Y"))
			{
				if (theScore.generalScoreCard[0][11] != 9 )
				{
					reRandomize = true;
				}
			}
			if (userChoice.equalsIgnoreCase("C"))
			{
				if (theScore.generalScoreCard[0][12] != 9 )
				{
					reRandomize = true;
				}
			}



		}
		return userChoice;
	}


	void chooseDiceToKeep() {


	}
	private void clearingTheDice(Dice newDiceRoll) {
		// Pre : Receives the dice rolls
		// Post : Clears the dice rolls in preparation for the new round
		for(int i = 0; i<5; i++)
		{
			newDiceRoll.theDiceRolls[0][i] = 0;
		}
	}


















}

class Computer extends Player
{
	public String MCGVersion;

	public Computer(String firstName, String mSGVersion) {

		super.name = firstName;
		MCGVersion = mSGVersion;
	}
	public static int[][] scoreCardForComputer = {



			//  0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16

			{ 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
			{ 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 0}};

	public static int [] [] possibleScoreCard = {


			{ 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
			{ 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 0}};





	public int [][] Computer2dArray= new int [2][16];












	public int[][] chooseDiceToKeep(int [] [] diceRolls, boolean debug, String mCGVersion2) 
	// Pre : Receives a 2d array of dice rolls
		// Post : Returns a combination of dice to keep and reroll
	{
		Random rand = new Random();
		if (debug  == false)
		{


			for (int i = 0; i<diceRolls[1].length;i++)
			{
				diceRolls[0][i] = rand.nextInt(2);
				if (diceRolls[0][i] == 0)
				{
					int j = i+1;
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("The computer chose to reroll dice "+j+".");
					}
				}
				if (diceRolls[0][i] == 1)
				{
					int j = i+1;
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("The computer chose to keep dice "+j+".");
					}
				}

			}
		}

		return diceRolls;

	}


	public String chooseCategory(Score Object, String mCGVersion2) {
		// Pre : Receives a Score object
		// Post : Chooses a category to score the diceroll
		Random rand = new Random();
		String compChoice = "nochoice";
		boolean reRandomize = false;
		int highestPointTotalForTopCategory = 0;
		int associatedCategory = 0;
		while (reRandomize == false)
		{
			int randomChoice = 1+rand.nextInt(13);

			if (possibleScoreCard[0][11] == 1)
			{
				compChoice = "Y";
				reRandomize = true;
				break;
			}

			if (possibleScoreCard[0][10] == 1)
			{
				compChoice = "LS";
				reRandomize = true;
				break;
			}

			if(possibleScoreCard[0][9] == 1)
			{
				//scoreCard 14
				compChoice = "SS";
				reRandomize = false;
				break;

			}
			if (possibleScoreCard[0][7] == 1)
			{
				compChoice = "4k";
				reRandomize = false;
				break;
			}
			if (possibleScoreCard[0][8] == 1)
			{
				compChoice = "FH";
				reRandomize = false;
				break;
			}

			for (int i = 0; i<5; i++)
			{
				if (possibleScoreCard[0][i] == 1)
				{

					if(possibleScoreCard[1][i] >highestPointTotalForTopCategory)
					{
						associatedCategory = i;
						highestPointTotalForTopCategory = possibleScoreCard[1][i];
					}
				}

			}

			if (possibleScoreCard[1][12]>highestPointTotalForTopCategory && possibleScoreCard[0][12] == 1)
			{
				associatedCategory = 12;
				highestPointTotalForTopCategory = possibleScoreCard[1][12];
			}
			if (possibleScoreCard[1][6]>highestPointTotalForTopCategory && possibleScoreCard[0][6] == 1)
			{
				associatedCategory = 6;
				highestPointTotalForTopCategory = possibleScoreCard[1][6];
			}


			if (highestPointTotalForTopCategory>0)
			{
				if (associatedCategory == 0)
				{
					compChoice = "1";
					reRandomize = false;
					break;
				}
				if (associatedCategory == 1)
				{
					compChoice = "2";
					reRandomize = false;
					break;
				}
				if (associatedCategory == 2)
				{
					compChoice = "3";
					reRandomize = false;
					break;
				}
				if (associatedCategory == 3)
				{
					compChoice = "4";
					reRandomize = false;
					break;
				}
				if (associatedCategory == 4)
				{
					compChoice = "5";
					reRandomize = false;
					break;
				}
				if (associatedCategory == 5)
				{
					compChoice = "6";
					reRandomize = false;
					break;
				}

				if (associatedCategory == 6)
				{
					compChoice = "3k";
					reRandomize = false;
					break;
				}
			}
			if (associatedCategory == 12)
			{
				compChoice = "C";
				reRandomize = false;
				break;
			}




			if (randomChoice == 1)
			{

				if (possibleScoreCard[0][0] == 9)
				{

				}
				if (possibleScoreCard[0][0] != 9)
				{
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("The computer chose ones as its category");
					}
					compChoice = "1";
					reRandomize = true;
				}

			}
			if (randomChoice == 2)
			{

				if (possibleScoreCard[0][1] == 9)
				{

				}
				if (possibleScoreCard[0][1] != 9)
				{ 
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("The computer chose twos as its category");
					}
					compChoice = "2";
					reRandomize = true;
				}
			}
			if (randomChoice == 3)
			{

				if (possibleScoreCard[0][2] == 9)
				{

				}
				if (possibleScoreCard[0][2] != 9)
				{
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("The computer chose threes as its category");
					}
					compChoice = "3";
					reRandomize = true;
				}
			}
			if (randomChoice == 4)
			{

				if (possibleScoreCard[0][3] == 9)
				{

				}
				if (possibleScoreCard[0][3] != 9)
				{
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("The computer chose fours as its category");
					}
					compChoice = "4";
					reRandomize = true;
				}
			}
			if (randomChoice == 5)
			{

				if (possibleScoreCard[0][4] == 9)
				{

				}
				if (possibleScoreCard[0][4] != 9)
				{
					if (!mCGVersion2.equals("MCG"))
					{
						System.out.println("The computer chose fives as its category");
					}
					compChoice = "5";
					reRandomize = true;
				}
			}
			if (randomChoice == 6)
			{

				if (possibleScoreCard[0][5] == 9)
				{

				}
				if (possibleScoreCard[0][5] != 9)
				{
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("The computer chose sixes as its category");
					}
					compChoice = "6";
					reRandomize = true;
				}
			}
			if (randomChoice == 7)
			{

				if (possibleScoreCard[0][6] == 9)
				{

				}
				if (possibleScoreCard[0][6] != 9)
				{
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("The computer chose three of a kind as its category");
					}
					compChoice = "3k";
					reRandomize = true;
				}
			}
			if (randomChoice == 8)
			{

				if (possibleScoreCard[0][7] == 9)
				{

				}
				if (possibleScoreCard[0][7] != 9)
				{
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("The computer chose four of a kind as its category");
					}
					compChoice = "4k";
					reRandomize = true;
				}
			}
			if (randomChoice == 9)
			{

				if (possibleScoreCard[0][8] == 9)
				{

				}
				if (possibleScoreCard[0][8] != 9)
				{
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("The computer chose full house as its category");
					}
					compChoice = "FH";
					reRandomize = true;
				}
			}
			if (randomChoice == 10)
			{

				if (possibleScoreCard[0][9] == 9)
				{

				}
				if (possibleScoreCard[0][9] != 9)
				{
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("The computer chose small straights as its category");
					}
					compChoice = "SS";
					reRandomize = true;
				}
			}
			if (randomChoice == 11)
			{

				if (possibleScoreCard[0][10] == 9)
				{

				}
				if (possibleScoreCard[0][10] != 9)
				{
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("The computer chose Large Straights as its category");
					}
					compChoice = "LS";
					reRandomize = true;
				};
			}
			if (randomChoice == 12)
			{

				if (scoreCardForComputer[0][11] == 9)
				{

				}
				if (scoreCardForComputer[0][11] != 9)
				{
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("The computer chose Yahtzee as its category");
					}
					compChoice = "Y";
					reRandomize = true;
				}
			}

			if (randomChoice == 13)
			{

				if (scoreCardForComputer[0][12] == 9)
				{

				}
				if (scoreCardForComputer[0][12] != 9)
				{
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("The computer chose chance as its category");
					}
					compChoice = "C";
					reRandomize = true;
				}
			}
		}
		return compChoice;
	}


	protected void playOneTurn(String firstName, boolean isDebugMode, Score newScoreCard, Dice newDiceRoll) 
	// Pre : Receives a firs tname, a boolean for debug, a score object and a dice object
	// Post : Plays one turn fo the game for the computer
	{

		String choice = null; 

		for (int i = 0; i<3; i++)
		{
			super.rollDice(newDiceRoll, isDebugMode, MCGVersion);
			newDiceRoll.theDiceRolls = chooseDiceToKeep(newDiceRoll.returnDice(), isDebugMode, MCGVersion);
			newDiceRoll.theDiceRolls = diceChangingifNeeded(newDiceRoll, MCGVersion);
			possibleScoreCard = newScoreCard.calculatePotentialScore(newDiceRoll.theDiceRolls, MCGVersion);
			choice = chooseCategory(newScoreCard, MCGVersion);
			if (choice.equals("Y") || choice.equals("LS") || choice.equals("FH")) {break;}


		}
		if (generalScoreCard[0][14] == 7)
		{
			generalScoreCard[0][14] = 9;
			generalScoreCard[1][14] = 0;
		}
		if (generalScoreCard[0][13] == 11)
		{
			generalScoreCard[0][13] = 9;
			generalScoreCard[1][13] = 0;
		}
		String comp = "comp";
		scoreCardForComputer = newScoreCard.checkAndAssignScores(choice, newDiceRoll.theDiceRolls, comp, MCGVersion);
		//current = scoreCardObject.updateScoreCard();
		
		if (!MCGVersion.equals("MCG"))
		{
			System.out.println(this.name+" score card is below");
		}
		if (!MCGVersion.equals("MCG"))
		{
			newScoreCard.printScoreCard(scoreCardForComputer);
		}
		clearingTheDice(newDiceRoll);






	}


	private void clearingTheDice(Dice newDiceRoll) {
		// Pre : Receives a set of dice
		// Post : Clears the dice for next round
		for(int i = 0; i<5; i++)
		{
			newDiceRoll.theDiceRolls[0][i] = 0;
		}
	}


	@Override
	void chooseDiceToKeep() {
		// TODO Auto-generated method stub

	}


	public static int [] [] diceChangingifNeeded(Dice diceRoll, String mCGVersion2)
	// Pre : Receives a dice object and a quiet mode String
	// Post : Makes any necessary dice corrections for 4 of a kind and Small Straight
	{

		if (possibleScoreCard[0][14] == 7)
		{

			for(int i = 0; i<5; i++)
			{
				if (i == possibleScoreCard[1][14])
				{
					diceRoll.theDiceRolls[0][possibleScoreCard[1][14]] = 0;
				}
				else
				{
					diceRoll.theDiceRolls[0][i] = 1;
				}

			}
		}

		if (possibleScoreCard[0][13] == 11)
		{
			for (int i = 0; i<5; i++)
			{
				if (i == possibleScoreCard[1][13])
				{


					diceRoll.theDiceRolls[0][possibleScoreCard[1][13]] = 0;
				}

				else
				{
					diceRoll.theDiceRolls[0][i] = 1;
				}
			}
		}

		return diceRoll.theDiceRolls;


	}

	public static void print2dArray (int [] [] diceRoll)
// Pre : Receives a 2d array
// Post : Prints the given 2d array	
	{
		for (int[] x : diceRoll)
		{
			for (int y : x)
			{
				System.out.print(y + ", ");
			}
			System.out.println();
		}



	}


	@Override
	String chooseCategory(Score object) {
		// TODO Auto-generated method stub
		return null;
	}





}
