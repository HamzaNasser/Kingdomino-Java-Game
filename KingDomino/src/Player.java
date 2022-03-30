import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Player {
	
	private String name;
	private int score;
	private Color color;
	private ArrayList<Territory> territories;
	
	public Player(String name, Color color) {
		this.name = name;
		score = 0;
		this.color = color;
	}
	
	public void addTerritory(Territory territory) {
		territories.add(territory);
		score = calculateScore();
	}

	private int calculateScore() {
		int scoreCount = 0;
		for (Territory territory : territories) {
			scoreCount += territory.getTerritoryPoints();
		}
		return scoreCount;
	}
}
