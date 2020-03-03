import java.util.Random;
import java.util.Scanner;

public class Dice {
	public boolean theDebug;
	public int rollCounter = 0;
	public int[][] theDiceRolls ={

			{ 0, 0, 0 ,0 ,0 },
			{ 0 ,0 ,0 ,0 ,0 }};

	

	public Dice() {
		// TODO Auto-generated constructor stub




	}


	public int [] [] returnDice()
	// Pre : Receives the dice
	// Post : Returns the dice
	{
		return theDiceRolls;


	}


	public void changeDie(boolean debug, String mCGVersion)
	// Pre : Receives a boolean debug and a String boolean for quiet mode
	// Post : Changes the dice depending on whether the user/computer wants to reroll or not
	{
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		if (mCGVersion.equals("MCG"))
		{
			debug = false;
		}
		if (theDiceRolls[0][0] == 0)
		{
			if (debug == true)
			{
				System.out.println("What would you like the value of dice 1 to be?");
				int debugvalue = sc.nextInt();
				theDiceRolls[1][0] = debugvalue;
			}
			else 
			{
				theDiceRolls[1][0] = 1+rand.nextInt(6);
			}
		}
		if (theDiceRolls[0][1] == 0)
		{
			if (debug == true)
			{
				System.out.println("What would you like the value of dice 2 to be?");
				int debugvalue = sc.nextInt();
				theDiceRolls[1][1] = debugvalue;
			}
			else 
			{
				theDiceRolls[1][1] = 1+rand.nextInt(6);
			}
		}
		if (theDiceRolls[0][2] == 0)
		{
			if (debug == true)
			{
				System.out.println("What would you like the value of dice 3 to be?");
				int debugvalue = sc.nextInt();
				theDiceRolls[1][2] = debugvalue;
			}
			else 
			{
				theDiceRolls[1][2] = 1+rand.nextInt(6);
			}
		}
		if (theDiceRolls[0][3] == 0)
		{
			if (debug == true)
			{
				System.out.println("What would you like the value of dice 4 to be?");
				int debugvalue = sc.nextInt();
				theDiceRolls[1][3] = debugvalue;
			}
			else 
			{
				theDiceRolls[1][3] = 1+rand.nextInt(6);
			}
		}
		if (theDiceRolls[0][4] == 0)
		{
			if (debug == true)
			{
				System.out.println("What would you like the value of dice 5 to be?");
				int debugvalue = sc.nextInt();
				theDiceRolls[1][4] = debugvalue;
			}
			else 
			{
				theDiceRolls[1][4] = 1+rand.nextInt(6);
			}
		}
	}






public String toString()

{
	System.out.println("Die 1 is a "+theDiceRolls[1][0]+" ");
	System.out.println("Die 2 is a "+theDiceRolls[1][1]+"");
	System.out.println("Die 3 is a "+theDiceRolls[1][2]+"");
	System.out.println("Die 4 is a "+theDiceRolls[1][3]+"");
	System.out.println("Die 5 is a "+theDiceRolls[1][4]+"");
	//pre : Does not recieve anything
	//Post : Converts the dice roll into a string and sends it back to the method
	return "yes";
}














}
