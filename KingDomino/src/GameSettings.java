import java.util.ArrayList;

public class GameSettings {
	
	private int gameSize;
	private ArrayList<Player> players;
	
	//GameSettings constructor
	public GameSettings() {
		players = new ArrayList<Player>();
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Getters and Setters
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setGameSize(int gameSize) {
		this.gameSize = gameSize;
	}
	
	
	public int getGameSize() {
		return gameSize;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}