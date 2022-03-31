import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Player {
	
	private String name;
	private int score;
	private Color color;
	
	public Player(String name, Color color) {
		this.name = name;
		score = 0;
		this.color = color;
	}
	
	public void setPlayerName(String name) {
		this.name = name;
	}
	
	public void setPlayerColor(Color color) {
		this.color = color;
	}
	
}
