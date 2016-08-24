package ver0;

public class Player 
{
	String m_name;
	int m_losses;
	int m_wins;
	int m_draws;
	static Player[] playerList=new Player[0];
	
	public static void initializePlayerList()
	{
		//pulls the player information from file
	}
	
	public Player(String name)
	{
		m_name=name;
		m_losses=0;
		m_wins=0;
		m_draws=0;
	}
	
	public static int addPlayer(String name)//returns the index of the player added
	{
		Player addPlayer = new Player(name);
		Player[] list2=new Player[playerList.length+1];
		for(int i=0;i<playerList.length;i++)
		{
			list2[i]=playerList[i];
		}
		list2[list2.length-1]=addPlayer;//adds the new player to the end of the list
		playerList=list2;
		return list2.length-1;
	}
	public static boolean checkIfPlayerExists(String name)
	{
		for(int i=0;i<playerList.length;i++)
		{
			if(playerList[i].m_name==name)
			{
				return true;
			}
		}
		return false;
	}
	
	public static int givePlayerIndex(String name)
	{
		for(int i=0; i<playerList.length;i++)
		{
			if(playerList[i].m_name==name);
			{
				return i;
			}
		}
		return 0;//indicates the player is not in the array
	}
	
	public static Player getPlayer(String name)
	{
		if(checkIfPlayerExists(name))
		{
			int index =givePlayerIndex(name);
			return playerList[index];
		}
		else
		{
			int index=addPlayer(name);
			return playerList[index];
		}
	}
}
