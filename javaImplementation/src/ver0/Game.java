package ver0;
import java.util.Scanner;
public class Game 
{
	Player p1;
	Player p2;
	boolean recorded;
	boolean quantum;
	int dimensions;
	int sidelength;
	static Scanner myScanner = new Scanner(System.in);
	public Game()
	{
		boolean exit=false;//used to control the while loops
		while(!exit)
		{
			System.out.println("Would you like your game to be recorded\n1) Yes\n2) No");
			int choice=verify(2);
			if(choice==1)
			{
				recorded=true;
				exit=true;
			}
			else
			{
				recorded=false;
				exit=true;
			}
		}
		exit=false;//sets the boolean expression to false for the next while loop
		
		String first;//string that holds the name of the first player
		String second;//string that holds the name of the second player
		if(recorded==true)//gets the names to record
		{
			System.out.println("What is the first Players Name?");
			first=myScanner.next();
			System.out.println("What is the second Players Name?");
			second=myScanner.next();
			
			p1=Player.getPlayer(first);
			p2=Player.getPlayer(second);
		}

		while(!exit)
		{
			System.out.println("Would you like to play Quantum?\n1) Yes[not implemented]\n2) No");
			int choice=verify(2);
			if(choice==1)
			{
				quantum=true;
				exit=true;
			}
			else
			{
				quantum=false;
				exit=true;
			}
		}
		exit=false;//sets the boolean expression to false for the next loop
		
		while(!exit)
		{
			System.out.println("How many Dimensions?\n1) 2\n2) 3\n3) 4[warning, long game]");
			int choice=verify(3);
			if(choice==1)
			{
				dimensions=2;
				exit=true;
			}
			else if(choice==2)
			{
				dimensions=3;
				exit=true;
			}
			else if(choice==3)
			{
				dimensions=4;
				exit=true;
			}
		}
		exit=false;
		
		while(!exit)
		{
			System.out.println("What is the sidelength?\n1) 3\n2) 4\n3) 5");
			int choice = verify(3);
			if(choice==1)
			{
				sidelength=3;
				exit=true;
			}
			else if(choice==2)
			{
				sidelength=4;
				exit=true;
			}
			else if(choice==3)
			{
				sidelength=5;
				exit=true;
			}
		}
	}
	public static int verify(int answerCeiling)//the answerCeiling refers to the larges acceptable integer that will be accepted
	{
		String num=myScanner.next();
		try
		{
			int choice=Integer.parseInt(num);//tries to parse the string as an integer, if it fails, the catch clause is triggered, which returns a 0 for bad value
			if(choice<1||choice>answerCeiling)
			{
				System.out.println("Please enter a number between 1 and " + answerCeiling);
				return 0;
			}
			else
			{
				return choice;
			}
		}
		catch(Exception e)
		{
			System.out.println("Please only input the numbers cooresponding to the choices");
			return 0;//stands for error
		}
	}
}
