
//module ScoreFinal {
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Score 
{

	public static int roundCount = 0;


	public int[] [] generalScoreCard = {



			//  0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16

			{ 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
			{ 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 0}};



	public String userChoice = "";



	public int[][] calculatePotentialScore(int [][]diceRoll, String mCGVersion)
	// Pre : Receives a 2d array of dice rolls and a String booleaan for quiet mode
	// Post : Calculates which categories can work for the user and the computer
	{

		int points = 0;
		boolean yahtzeeWorks = false;
		boolean straightIsValid = false;

		if (generalScoreCard[0][0]!=9)
		{
			for(int column = 0; column<5; column++)
			{
				if (diceRoll[1][column] == 1)
				{
					points++;
				}


			}

			if (points>0)
			{
				generalScoreCard[0][0] = 1;
				generalScoreCard[1][0] = points;
			}

		}

		if (generalScoreCard[0][1] != 9)
		{
			points = 0;
			for (int column = 0; column<5; column++)
			{
				if (diceRoll[1][column] == 2)
				{
					points++;

				}
			}



			points = points*2;
			if (points>0)
			{
				generalScoreCard[0][1] = 1;
				generalScoreCard[1][1] = points;
			}


		}


		if (generalScoreCard[0][2] != 9)
		{
			points = 0;
			for (int column = 0; column<5; column++)
			{
				if (diceRoll[1][column] == 3)
				{
					points++;

				}
			}



			points = points*3;
			if (points>0)
			{
				generalScoreCard[0][2] = 1;
				generalScoreCard[1][2] = points;
			}


		}

		if (generalScoreCard[0][3] != 9)
		{
			points = 0;
			for (int column = 0; column<5; column++)
			{
				if (diceRoll[1][column] == 4)
				{
					points++;

				}
			}



			points = points*4;
			if (points>0)
			{
				generalScoreCard[0][3] = 1;
				generalScoreCard[1][3] = points;
			}


		}

		if (generalScoreCard[0][4] != 9)
		{
			points = 0;
			for (int column = 0; column<5; column++)
			{
				if (diceRoll[1][column] == 5)
				{
					points++;

				}
			}



			points = points*5;
			if (points>0)
			{
				generalScoreCard[0][4] = 1;
				generalScoreCard[1][4] = points;
			}


		}
		if (generalScoreCard[0][5] != 9)
		{
			points = 0;
			for (int column = 0; column<5; column++)
			{
				if (diceRoll[1][column] == 6)
				{
					points++;

				}
			}



			points = points*6;
			if (points>0)
			{
				generalScoreCard[0][5] = 1;
				generalScoreCard[1][5] = points;
			}


		}

		if (generalScoreCard[0][6] != 9)
		{
			points = 0;
			boolean threeOfKind = false;
			for (int i = 0; i < diceRoll[0].length; i++) {
				int count = 0;
				for (int j = 0; j < diceRoll[0].length; j++) {
					{
						if (diceRoll[1][i] == diceRoll[1][j]) {
							count++;
						}

					}
					if (count >= 3) {
						threeOfKind = true;
					}
				}
			}


			if (threeOfKind == true)
			{

				points = sumOfArray(diceRoll);
			}
			if (threeOfKind == false)
			{
				points = 0;
			}



			if (points>0)
			{
				generalScoreCard[0][6] = 1;
				generalScoreCard[1][6] = points;
			}


		}


		if (generalScoreCard[0][7] != 9)
		{
			points = 0;
			int wrongValue = 0;
			boolean fourOfKind = false;
			for (int i = 0; i < diceRoll[0].length; i++) {
				int count = 0;
				for (int j = 0; j < diceRoll[0].length; j++) {
					{
						if (diceRoll[1][i] == diceRoll[1][j]) {
							count++;
						}
						else if (diceRoll[1][i] != diceRoll[1][j]) {
							wrongValue = j;
						}

					}
					if (count >= 4) {
						fourOfKind = true;

					}
				}
			}


			if (fourOfKind == true)
			{

				points = sumOfArray(diceRoll);
				int count1 = 1, tempCount;
				int popular =diceRoll[1][0];
				int temp = 0;
				for (int m = 0; m < (diceRoll[1].length - 1); m++)
				{
					temp = diceRoll[1][m];
					tempCount = 0;
					for (int n = 1; n < diceRoll[1].length; n++)
					{
						if (temp == diceRoll[1][n])
							tempCount++;
					}
					if (tempCount > count1)
					{
						popular = temp;
						count1 = tempCount;
					}
				}
				for (int q = 0; q<diceRoll[1].length; q++)
				{
					if (diceRoll[1][q] != popular)
					{
						wrongValue = q;
						break;
					}
				}


				generalScoreCard[1][13] = wrongValue;
				generalScoreCard[0][13] = 11;



			}
			if (fourOfKind == false)
			{
				points = 0;


			}



			if (points>0)
			{
				generalScoreCard[0][7] = 1;
				generalScoreCard[1][7] = points;
			}


		}
		if (generalScoreCard[0][8] != 9)
		{
			diceRoll = ascendingDiceOrdering(diceRoll);
			points = 0;
			if (diceRoll[1][0] == diceRoll [1][1] && diceRoll [1] [2] == diceRoll [1] [3] && diceRoll [1] [2] == diceRoll [1] [4])
			{
				points = 25;

			}

			else if (diceRoll[1][0] == diceRoll [1][1] && diceRoll [1][0] == diceRoll[1][2] && diceRoll[1][3] == diceRoll [1][4])
			{
				points = 25;

			}
			else
			{
				points = 0;

			}




			if (points>0)
			{
				generalScoreCard[0][8] = 1;
				generalScoreCard[1][8] = points;
			}


		}

		if (generalScoreCard[0][9] != 9)
		{
			diceRoll = ascendingDiceOrdering(diceRoll);
			points = 0;


			String straightOrNot = "no";
			ArrayList<Integer> list = new ArrayList<Integer>(5);
			for (int i = 0; i<5; i++)

			{
				list.add(i, diceRoll[1][i]);

			}

			for (int i = 0; i<list.size()-1;i++)
			{
				if (list.get(i) == list.get(i+1))
				{
					list.remove(i);
				}
			}


			int count = 0;
			for (int i = 0; i < list.size()-1; i++) {
				if (list.get(i)+1 == (list.get(i + 1))) {
					count++;

				}

				if (count == 3)
				{

					straightOrNot = "yes";
					break;
				}
			}

			if (straightOrNot.equals("yes"))
			{

				points = 30;
			}
			else 
			{

				points = 0;
			}

			if (points>0)
			{
				generalScoreCard[0][9] = 1;
				generalScoreCard[1][9] = points;
			}


		}

		if (generalScoreCard[0][10] != 9)
		{
			diceRoll = ascendingDiceOrdering(diceRoll);
			points = 0;
			String straightOrNot = "no";
			ArrayList<Integer> list = new ArrayList<Integer>(5);
			for (int i = 0; i<5; i++)

			{
				list.add(i, diceRoll[1][i]);

			}

			for (int i = 0; i<list.size()-1;i++)
			{
				if (list.get(i) == list.get(i+1))
				{
					generalScoreCard[1][14] = i;
					generalScoreCard[0][14] = 7;
					straightIsValid = true;
					list.remove(i);
				}
			}


			int count = 0;
			for (int i = 0; i < list.size()-1; i++) {
				if (list.get(i)+1 == (list.get(i + 1))) {
					count++;

				}

				if (count == 4)
				{

					straightOrNot = "yes";
					break;
				}
			}

			if (straightOrNot.equals("yes"))
			{
				points = 40;
			}
			else 
			{

				points = 0;
			}

			if (points>0)
			{
				generalScoreCard[0][10] = 1;
				generalScoreCard[1][10] = points;
			}
			if (straightIsValid == false)
			{
				generalScoreCard[1][14] = 4;
				generalScoreCard[0][14] = 7;
			}


		}


		if (generalScoreCard[0][11] != 9)
		{
			points = 0;
			yahtzeeWorks = true;
			int value = diceRoll[1][0];
			for (int i = 0; i<diceRoll[0].length; i++)
			{
				if (diceRoll[1][i] != value)
				{
					yahtzeeWorks = false;
				}


			}



			if (yahtzeeWorks == true)
			{
				points = 50;
			}



			if (points>0)
			{
				generalScoreCard[0][11] = 1;
				generalScoreCard[1][11] = points;
			}

		}





		if (generalScoreCard[0][12] != 9)
		{
			points = 0;
			points = sumOfArray(diceRoll);

			if (points>0)
			{
				generalScoreCard[0][12] = 1;
				generalScoreCard[1][12] = points;
			}
		}
		if(!mCGVersion.equals("MCG"))
		{
			if (generalScoreCard[0][0] == 1)
			{
				System.out.println("Ones works and you would get "+generalScoreCard[1][0]+" points!");
			}
			if (generalScoreCard[0][1] == 1)
			{
				System.out.println("Twos works and you would get "+generalScoreCard[1][1]+" points!");
			}
			if (generalScoreCard[0][2] == 1)
			{
				System.out.println("Threes works and you would get "+generalScoreCard[1][2]+" points!");
			}
			if (generalScoreCard[0][3] == 1)
			{
				System.out.println("Fours works and you would get "+generalScoreCard[1][3]+" points!");
			}
			if (generalScoreCard[0][4] == 1)
			{
				System.out.println("Fives works and you would get "+generalScoreCard[1][4]+" points!");
			}
			if (generalScoreCard[0][5] == 1)
			{
				System.out.println("Sixes works and you would get "+generalScoreCard[1][5]+" points!");
			}
			if (generalScoreCard[0][6] == 1)
			{
				System.out.println("Three Of A Kind works and you would get "+generalScoreCard[1][6]+" points!");
			}
			if (generalScoreCard[0][7] == 1)
			{
				System.out.println("Four Of A Kind works and you would get "+generalScoreCard[1][7]+" points!");
			}
			if (generalScoreCard[0][8] == 1)
			{
				System.out.println("Full House works and you would get "+generalScoreCard[1][8]+" points!");
			}
			if (generalScoreCard[0][9] == 1)
			{
				System.out.println("Small Straight works and you would get "+generalScoreCard[1][9]+" points!");
			}
			if (generalScoreCard[0][10] == 1)
			{
				System.out.println("Large Straight works and you would get "+generalScoreCard[1][10]+" points!");
			}
			if (generalScoreCard[0][11] == 1)
			{
				System.out.println("Yahtzee works and you would get "+generalScoreCard[1][11]+" points!");
			}
			if (generalScoreCard[0][12] == 1)
			{
				System.out.println("Chance works and you would get "+generalScoreCard[1][12]+" points!");
			}
		}

		return generalScoreCard;

	}





	public int[][] clearingTheBoard(int[][] scoreboard) {
		// Pre : Receives a scoreboard with boolean 1's for potential score
		// Post : Removes the ones and possible values in prep for assigning the score
		for (int column = 0; column<16; column++)
		{
			if (scoreboard[0][column] == 1)
			{
				scoreboard[0][column] = 0;
				scoreboard[1][column] = 0;
			}
		}

		return scoreboard;
	}





	public int[][] checkAndAssignScores(String choice, int [] [] diceRoll, String compOrHuman, String mCGVersion2)
	{
		// Pre : Receives a choice from either user or computer
		// Post : Prints and returns the points for the individual round after checking
		generalScoreCard = clearingTheBoard(generalScoreCard);
		Scanner sc = new Scanner(System.in);
		//diceRoll = ascendingDiceOrdering(diceRoll);

		boolean gameOver = false;
		int pointTotalForRound = 0;
		boolean needToReroll = true;




		if (choice.equalsIgnoreCase("1"))
		{
			if (!mCGVersion2.equals("MCG"))
			{
				System.out.println("Choice is ones.");
			}
			if (generalScoreCard[0][0] == 9)
			{
				if (!mCGVersion2.equals("MCG"))
				{
					System.out.println("Sorry you have already picked this square.");
				}
				pointTotalForRound = 0;
			}
			if (generalScoreCard[0][0] == 0)
			{
				for (int column = 0; column<5; column++)
				{
					if (diceRoll[1][column] == 1)
					{
						pointTotalForRound++;
					}
				}

				pointTotalForRound = pointTotalForRound*1;
				generalScoreCard[0][0] = 9;
				generalScoreCard[1][0] = pointTotalForRound;
				needToReroll = false;

			}

		}

		if (choice.equalsIgnoreCase("2"))
		{
			if (!mCGVersion2.equals("MCG"))
			{
				System.out.println("Choice is twos.");
			}
			if (generalScoreCard[0][1] == 9)
			{
				if (!mCGVersion2.equals("MCG"))
				{
					System.out.println("Sorry you have already picked this square. ");
				}
				pointTotalForRound = 0;
			}
			if (generalScoreCard[0][1] == 0)
			{
				for (int column = 0; column<5; column++)
				{
					if (diceRoll[1][column] == 2)
					{
						pointTotalForRound++;

					}
				}

				pointTotalForRound = pointTotalForRound*2;
				generalScoreCard[0][1] = 9;
				generalScoreCard[1][1] = pointTotalForRound;
				needToReroll = false;
			}

		}

		if (choice.equalsIgnoreCase("3"))
		{
			if (!mCGVersion2.equals("MCG"))
			{
				System.out.println("Choice is threes.");
			}
			if (generalScoreCard[0][2] == 9)
			{
				if (!mCGVersion2.equals("MCG"))
				{
					System.out.println("Sorry you have already picked this square. ");
				}
				pointTotalForRound = 0;
			}
			if (generalScoreCard[0][2] == 0)
			{
				for (int column = 0; column<5; column++)
				{
					if (diceRoll[1][column] == 3)
					{
						pointTotalForRound++;
					}
				}

				pointTotalForRound = pointTotalForRound*3;
				generalScoreCard[0][2] = 9;
				generalScoreCard[1][2] = pointTotalForRound;
				needToReroll = false;

			}

		}

		if (choice.equalsIgnoreCase("4"))
		{
			if (!mCGVersion2.equals("MCG"))
			{
				System.out.println("Choice is fours.");
			}
			if (generalScoreCard[0][3] == 9)
			{
				if (!mCGVersion2.equals("MCG"))
				{
					System.out.println("Sorry you have already picked this square. ");
				}
				pointTotalForRound = 0;
			}
			if (generalScoreCard[0][3] == 0)
			{
				for (int column = 0; column<5; column++)
				{
					if (diceRoll[1][column] == 4)
					{
						pointTotalForRound++;

					}
				}


				pointTotalForRound = pointTotalForRound*4;
				generalScoreCard[0][3] = 9;
				generalScoreCard[1][3] = pointTotalForRound;
				needToReroll = false;
			}


		}


		if (choice.equalsIgnoreCase("5"))
		{
			if (!mCGVersion2.equals("MCG"))
			{
				System.out.println("Choice is fives.");
			}
			if (generalScoreCard[0][4] == 9)
			{
				if (!mCGVersion2.equals("MCG"))
				{
					System.out.println("Sorry you have already picked this square. ");
				}
				pointTotalForRound = 0;
			}
			if (generalScoreCard[0][4] == 0)
			{
				for (int column = 0; column<5; column++)
				{
					if (diceRoll[1][column] == 5)
					{
						pointTotalForRound++;

					}
				}

				pointTotalForRound = pointTotalForRound*5;
				generalScoreCard[0][4] = 9;
				generalScoreCard[1][4] = pointTotalForRound;
				needToReroll = false;
			}


		}

		if (choice.equalsIgnoreCase("6"))
		{
			if (!mCGVersion2.equals("MCG"))
			{
				System.out.println("Choice is sixes.");
			}
			if (generalScoreCard[0][5] == 9)
			{
				if (!mCGVersion2.equals("MCG"))
				{
					System.out.println("Sorry you have already picked this square. ");
				}
				pointTotalForRound = 0;
			}
			if (generalScoreCard[0][5] == 0)
			{
				for (int column = 0; column<5; column++)
				{
					if (diceRoll[1][column] == 6)
					{
						pointTotalForRound++;

					}
				}

				pointTotalForRound = pointTotalForRound*6;
				generalScoreCard[0][5] = 9;
				generalScoreCard[1][5] = pointTotalForRound;
				needToReroll = false;
			}


		}

		if (choice.equalsIgnoreCase("3k"))
		{
			boolean threeOfKind = false;
			if (!mCGVersion2.equals("MCG"))
			{
				System.out.println("Choice is 3 of a kind.");
			}
			if (generalScoreCard[0][6] == 9)
			{
				if (!mCGVersion2.equals("MCG"))
				{
					System.out.println("Sorry you have already picked this square. ");
				}
				pointTotalForRound = 0;
			}
			if (generalScoreCard[0][6] == 0)
			{
				for (int i = 0; i < diceRoll[0].length; i++) {
					int count = 0;
					for (int j = 0; j < diceRoll[0].length; j++) {
						{
							if (diceRoll[1][i] == diceRoll[1][j]) {
								count++;
							}

						}
						if (count >= 3) {
							threeOfKind = true;
						}
					}
				}



				if (threeOfKind == true)
				{

					pointTotalForRound = sumOfArray(diceRoll);
					generalScoreCard[0][6] = 9;
					generalScoreCard[1][6] = pointTotalForRound;
				}

				if (threeOfKind == false)
				{

					pointTotalForRound = 0;
					generalScoreCard[0][6] = 9;
					generalScoreCard[1][6] = pointTotalForRound;
				}
				if (threeOfKind == true)
				{
					if (!mCGVersion2.equals("MCG"))
					{

						System.out.println("This works! you get "+pointTotalForRound+" points!");
					}
				}
				if (threeOfKind == false)
				{
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("This does not work. You get 0 points");
					}
					}
				needToReroll = false;

			}

		}

		if (choice.equalsIgnoreCase("4k"))
		{
			boolean fourOfKind = false;
			if (!mCGVersion2.equals("MCG"))
			{
			System.out.println("Choice is 4 of a kind.");
			}
			if (generalScoreCard[0][7] == 9)
			{
				if (!mCGVersion2.equals("MCG"))
				{
				System.out.println("Sorry you have already picked this square. ");
				}
				pointTotalForRound = 0;
			}
			if (generalScoreCard[0][7] == 0)
			{
				for (int i = 0; i < diceRoll[0].length; i++) {
					int count = 0;
					for (int j = 0; j < diceRoll[0].length; j++) {
						{
							if (diceRoll[1][i] == diceRoll[1][j]) {
								count++;
							}

						}
						if (count >= 4) {
							fourOfKind = true;

						}

					}
				}
				if (fourOfKind == true)
				{
					pointTotalForRound = sumOfArray(diceRoll);

					generalScoreCard[0][7] = 9;
					generalScoreCard[1][7] = pointTotalForRound;
				}

				if (fourOfKind == false)
				{

					pointTotalForRound = 0;
					generalScoreCard[0][7] = 9;
					generalScoreCard[1][7] = pointTotalForRound;
				}
				if (fourOfKind == true)
				{
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("This works! you get "+pointTotalForRound+" points!");
					}
					}
				if (fourOfKind == false)
				{
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("This does not work. You get 0 points");
					}
					}
			}

			needToReroll = false;





		}   


		if (choice.equalsIgnoreCase("FH"))
		{
			diceRoll = ascendingDiceOrdering(diceRoll);
			if (!mCGVersion2.equals("MCG"))
			{
				System.out.println("Choice is full house.");
			}
			if (generalScoreCard[0][8] == 9)
			{
				if (!mCGVersion2.equals("MCG"))
				{
				System.out.println("Sorry you have already picked this square. ");
				}
				pointTotalForRound = 0;
			}
			if (generalScoreCard[0][8] == 0)
			{
				if (diceRoll[1][0] == diceRoll [1][1] && diceRoll [1] [2] == diceRoll [1] [3] && diceRoll [1] [2] == diceRoll [1] [4])
				{
					pointTotalForRound = 25;
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("This works! you get "+pointTotalForRound+" points!");
					}
					}

				else if (diceRoll[1][0] == diceRoll [1][1] && diceRoll [1][0] == diceRoll[1][2] && diceRoll[1][3] == diceRoll [1][4])
				{
					pointTotalForRound = 25;
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("This works! you get "+pointTotalForRound+" points!");
					}
					}
				else
				{
					pointTotalForRound = 0;
					if (!mCGVersion2.equals("MCG"))
					{
					System.out.println("This does not work. You get 0 points");
					}
					}
				generalScoreCard[0][8] = 9;
				generalScoreCard[1][8] = pointTotalForRound;
				needToReroll = false;
			}



		}

		if (choice.equalsIgnoreCase("SS"))
		{
			diceRoll = ascendingDiceOrdering(diceRoll);
			pointTotalForRound = 0;
			if (!mCGVersion2.equals("MCG"))
			{
				System.out.println("Choice is small straight.");
			}
			if (generalScoreCard[0][9] == 9)
			{
				if (!mCGVersion2.equals("MCG"))
				{
					System.out.println("Sorry you have already picked this square. ");
				}
				pointTotalForRound = 0;
			}
			if (generalScoreCard[0][9] == 0)
			{
				String straightOrNot = "no";
				ArrayList<Integer> list = new ArrayList<Integer>(5);
				for (int i = 0; i<5; i++)

				{
					list.add(i, diceRoll[1][i]);

				}

				for (int i = 0; i<list.size()-1;i++)
				{
					if (list.get(i) == list.get(i+1))
					{
						list.remove(i);
					}
				}


				int count = 0;
				for (int i = 0; i < list.size()-1; i++) {
					if (list.get(i)+1 == (list.get(i + 1))) {
						count++;

					}

					if (count == 3)
					{

						straightOrNot = "yes";
						break;
					}
				}

				if (straightOrNot.equals("yes"))
				{
					if (!mCGVersion2.equals("MCG"))
					{
						System.out.println("This works! you have gained 30 points");
					}
					pointTotalForRound = 30;
				}
				else 
				{
					if (!mCGVersion2.equals("MCG"))
					{
						System.out.println("This does not work. You get 0 points");
					}
					pointTotalForRound = 0;
				}
				generalScoreCard[0][9] = 9;
				generalScoreCard[1][9] = pointTotalForRound;
				needToReroll = false;
			}

		}
		if (choice.equalsIgnoreCase("LS"))
		{
			diceRoll = ascendingDiceOrdering(diceRoll);
			pointTotalForRound = 0;
		
			if (!mCGVersion2.equals("MCG"))
			{
				System.out.println("Choice is large straight.");
			}
			if (generalScoreCard[0][10] == 9)
			{
				if (!mCGVersion2.equals("MCG"))
				{
					System.out.println("Sorry you have already picked this square. ");
				}
				pointTotalForRound = 0;
			}
			if (generalScoreCard[0][10] == 0)
			{
				String straightOrNot = "no";
				ArrayList<Integer> list = new ArrayList<Integer>(5);
				for (int i = 0; i<5; i++)

				{
					list.add(i, diceRoll[1][i]);

				}

				for (int i = 0; i<list.size()-1;i++)
				{
					if (list.get(i) == list.get(i+1))
					{
						list.remove(i);
					}
				}


				int count = 0;
				for (int i = 0; i < list.size()-1; i++) {
					if (list.get(i)+1 == (list.get(i + 1))) {
						count++;

					}

					if (count == 4)
					{

						straightOrNot = "yes";
						break;
					}
				}

				if (straightOrNot.equals("yes"))
				{
					if (!mCGVersion2.equals("MCG"))
					{
						System.out.println("This works! you have gained 40 points");
					}
					pointTotalForRound = 40;
				}
				else 
				{
					if (!mCGVersion2.equals("MCG"))
					{
						System.out.println("This does not work. You get 0 points");
					}
					pointTotalForRound = 0;
				}
			}
			if (pointTotalForRound == 0)
			{
				if (!mCGVersion2.equals("MCG"))
				{
					System.out.println("This did not work. You get 0 points");
				}
			}

			generalScoreCard[0][10] = 9;
			generalScoreCard[1][10] = pointTotalForRound;
			needToReroll = false;
		}





		if (choice.equalsIgnoreCase("Y"))
		{
			pointTotalForRound = 0;
			boolean itWorks = true;
			int value = diceRoll[1][0];
			if (!mCGVersion2.equals("MCG"))
			{
				System.out.println("Choice is Yahtzee.");
			}
			if (generalScoreCard[0][11] == 9)
			{
				if (!mCGVersion2.equals("MCG"))
				{
					System.out.println("Sorry you have already picked this square.")	;			
				}
				pointTotalForRound = 0;
			}
			if (generalScoreCard[0][11] == 0)
			{

				for (int i = 0; i<diceRoll[0].length; i++)
				{
					if (diceRoll[1][i] != value)
					{
						itWorks = false;
					}


				}

				if (itWorks == true)
				{
					if (!mCGVersion2.equals("MCG"))
					{
						System.out.println("YAHTZEE!!! You get 50 points");
					}
					pointTotalForRound = 50;
				}
				if (itWorks == false)
				{
					if (!mCGVersion2.equals("MCG"))
					{
						System.out.println("This did not work. You get 0 points");
					}
				}
				generalScoreCard[0][11] = 9;
				generalScoreCard[1][11] = pointTotalForRound;
				needToReroll = false;
			}




		}

		if (choice.equalsIgnoreCase("C"))
		{
			if (!mCGVersion2.equals("MCG"))
			{
				System.out.println("Choice is Chance.");
			}
			if (generalScoreCard[0][12] == 9)
			{
				if (!mCGVersion2.equals("MCG"))
				{
					System.out.println("Sorry you have already picked this square.");
				}
				pointTotalForRound = 0;
			}
			if (generalScoreCard[0][12] == 0)
			{
				pointTotalForRound = sumOfArray(diceRoll);
				generalScoreCard[0][12] = 9;
				generalScoreCard[1][12] = pointTotalForRound;
				needToReroll = false;
			}

		} 


		if (generalScoreCard[1][0]>0 && generalScoreCard[1][1]>0 && generalScoreCard[1][2]>0 && generalScoreCard[1][3]>0 && generalScoreCard[1][4]>0 && generalScoreCard[1][5]>0 && generalScoreCard[1][15]<35)
		{
			int totalOfTopRow = generalScoreCard[1][0]+generalScoreCard[1][1]+generalScoreCard[1][2]+generalScoreCard[1][3]+generalScoreCard[1][4]+generalScoreCard[1][5];
			if (totalOfTopRow>=63)
			{
				if (!mCGVersion2.equals("MCG"))
				{
					System.out.println("You have got the bonus! You have been awarded 35 extra points!");
				}
				generalScoreCard[0][15] = 35;
				generalScoreCard[0][15] = 9;
			}

		}
		generalScoreCard[0][13] = 9;
		generalScoreCard[1][13] = 0;
		generalScoreCard[0][14] = 9;
		generalScoreCard[1][14] = 0;


		for(int i = 0; i<generalScoreCard[1].length; i++)
		{
			if (generalScoreCard[0][i]==9)
			{
				gameOver = true;
			}
			if (generalScoreCard[0][i] != 9)
			{
				gameOver = false;
				break;
			}
		}
		if (gameOver == true)
		{
			if (!mCGVersion2.equals("MCG"))
			{
				System.out.println("");
			}
			if (!mCGVersion2.equals("MCG"))
			{
				System.out.println("The game is over");
			}
			needToReroll = false;
		}

		if (!mCGVersion2.equals("MCG"))
		{
			System.out.println("");
		}
		if (!mCGVersion2.equals("MCG"))
		{
			System.out.println("The score for the round is "+pointTotalForRound);
		}

		roundCount++;
		if (!mCGVersion2.equals("MCG"))
		{
			System.out.println("---------------------------");
		}
		if (!mCGVersion2.equals("MCG"))
		{
			System.out.println("YOU HAVE FINISHED ROUND "+roundCount);
		}
		if (!mCGVersion2.equals("MCG"))
		{
			System.out.println("---------------------------");
		}


		return generalScoreCard;
	}





	public static int [] [] ascendingDiceOrdering(int [] [] rolls)
	// Pre : Gets a 2d array of dice
	// Post : Sorts the dice into ascending order
	
	{
		int temp;
		int rows = rolls.length;
		int columns = rolls[1].length;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i <= columns; i++) 
		{
			for (int j = i + 1; j < rolls[1].length; j++) 
			{    
				if (rolls[1][i] > rolls[1][j]) 
				{
					temp = rolls[1][i];
					rolls[1][i] = rolls[1][j];
					rolls[1][j] = temp;
				}

			}

		}
		return rolls;
	}





	public static int sumOfArray (int [] [] theRolls)
	{
		int totalSum = 0;
		for (int i =0; i<theRolls[0].length; i++)
		{
			totalSum = totalSum + theRolls[1][i];	
		}
		return totalSum;
	}


	public int[][] calculatePotentialScore() {
		// TODO Auto-generated method stub
		return null;
	}


	public int[][] updateScoreCard() {
		// TODO Auto-generated method stub
		return null;
	}

	public void printScoreCard(int [] [] scoreCard) 
	{
		System.out.println("\n "
				+ "Ones----------------- "+scoreCard[1][0]+" points"
				+ "\n "
				+ "\n Twos----------------- "+scoreCard[1][1]+" points"
				+ "\n "
				+ "\n Threes--------------- "+scoreCard[1][2]+" points"
				+ "\n "
				+ "\n Fours---------------- "+scoreCard[1][3]+" points"
				+ "\n "
				+ "\n Fives---------------- "+scoreCard[1][4]+" points"
				+ "\n "
				+ "\n Sixes---------------- "+scoreCard[1][5]+" points"
				+ "\n "
				+ "\n Three Of a Kind------ "+scoreCard[1][6]+" points"
				+ "\n "
				+ "\n Four Of a Kind------- "+scoreCard[1][7]+" points"
				+ "\n "
				+ "\n Full House----------- "+scoreCard[1][8]+" points"
				+ "\n "
				+ "\n Small Straight------- "+scoreCard[1][9]+" points"
				+ "\n "
				+ "\n Large Straight------- "+scoreCard[1][10]+" points"
				+ "\n "
				+ "\n Yahtzee-------------- "+scoreCard[1][11]+" points"
				+ "\n "
				+ "\n Chance--------------- "+scoreCard[1][12]+" points"
				+ "\n"
				+ "\n Bonus---------------- "+scoreCard[1][15]+" points");											

		System.out.println("");
		System.out.println("Your total Score is "+sumOfArray(scoreCard));


	}

	public int[][] removingRedundantNumbers(int [] [] diceRolls)
	{
		int j = 0; 


		for (int i = 0; i < diceRolls[1].length-1; i++) 
			if (diceRolls[1][i] != diceRolls[1][i+1]) 
				diceRolls[1][j++] = diceRolls[1][i]; 

		diceRolls[1][j++] = diceRolls[1][diceRolls[1].length-1]; 

		return diceRolls;
	}




















}
