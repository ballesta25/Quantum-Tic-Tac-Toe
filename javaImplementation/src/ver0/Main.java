/*	@file:	Main.java
 *  @author:Austin Bailey
 *  @date:	8/24/2016
 *  @purpose:	Implementation of Tic-Tac-Toe methods 
 */
package ver0;
import java.util.Scanner;
public class Main 
{
	static Scanner myScanner = new Scanner(System.in);
	static boolean exit=false;
	public static void main(String[] args)
	{
		System.out.println("Welcome to Quantum-Tic-Tac-Toe!");
		while(!exit)
		{
			System.out.println("What would you like to do?");
			System.out.println("1)new game\n2)View GameLog[not implemented]\n3)Exit");
			int choice=verify(3);
			if(choice==1)
			{
				Game myGame = new Game();
			}
			//TODO finish choice block
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
