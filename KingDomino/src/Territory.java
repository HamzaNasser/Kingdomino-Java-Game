import java.util.ArrayList;

public class Territory {
	
	private int territoryPoints;
	private String name;
	private ArrayList<Tile> tiles;
	
	public Territory(String name) {
		
		this.name = name;
		territoryPoints = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getTerritoryPoints() {
		return territoryPoints;
	}
	
	public void addTile(Tile tile) {
		tiles.add(tile);
		territoryPoints = tiles.size() * calculateTerritoryPoints();
	}
	
	public int calculateTerritoryPoints() {
		int territoryPointsCount = 0;
		for (Tile tile : tiles) {
			territoryPointsCount += tile.getCrownValue();
		}
		return territoryPointsCount;
	}
}