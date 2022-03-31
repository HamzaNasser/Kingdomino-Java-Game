import java.util.ArrayList;

public class GameSettings {
	
	private int gameSize;
	private ArrayList<Player> players;
	
	public GameSettings() {
		players = new ArrayList<Player>();
	}
	
	public void setGameSize(int gameSize) {
		this.gameSize = gameSize;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public int getGameSize() {
		return gameSize;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
}