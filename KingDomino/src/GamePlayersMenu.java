import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePlayersMenu extends JPanel implements ActionListener {
	
	private JButton oneHuman, twoHumans, threeHumans, fourHumans, back;
	private MainUI frame;
	private JPanel gameSizeMenu, gameGrid, playerOptionsMenu;
	private GameSettings game;
	
	//GamePlayerMenu constructor
	public GamePlayersMenu(MainUI mainUI, GameSettings game) {
		super();
		this.frame = mainUI;
		this.game = game;
		
		oneHuman = new JButton("1 Person");
		oneHuman.setActionCommand("oneHuman");
		
		twoHumans = new JButton("2 People");
		twoHumans.setActionCommand("twoHumans");
		
		threeHumans = new JButton("3 People");
		threeHumans.setActionCommand("threeHumans");
		
		fourHumans = new JButton("4 People");
		fourHumans.setActionCommand("fourHumans");
		
		back = new JButton("Back");
		back.setActionCommand("back");
		
		oneHuman.addActionListener(this);
		twoHumans.addActionListener(this);
		threeHumans.addActionListener(this);
		fourHumans.addActionListener(this);
		back.addActionListener(this);
		
		add(oneHuman);
		add(twoHumans);
		if (game.getGameSize() == 4) {
			add(threeHumans);
			add(fourHumans);
		}
		add(back);
	}
	
	//Action event methods
	public void actionPerformed(ActionEvent event) {
		if ("oneHuman".equals(event.getActionCommand())) {
			Player playerOne = new Player(null, null, null);
			game.addPlayer(playerOne);
			frame.changePanel(playerOptionsMenu = new PlayerOptionsMenu(frame, game));
		}
		else if ("twoHumans".equals(event.getActionCommand())) {
			Player playerOne = new Player(null, null, null);
			game.addPlayer(playerOne);
			Player playerTwo = new Player(null, null, null);
			game.addPlayer(playerTwo);
			frame.changePanel(playerOptionsMenu = new PlayerOptionsMenu(frame, game));
		}
		else if ("threeHumans".equals(event.getActionCommand())) {
			Player playerOne = new Player(null, null, null);
			game.addPlayer(playerOne);
			Player playerTwo = new Player(null, null, null);
			game.addPlayer(playerTwo);
			Player playerThree = new Player(null, null, null);
			game.addPlayer(playerThree);
			frame.changePanel(playerOptionsMenu = new PlayerOptionsMenu(frame, game));
		}
		else if ("fourHumans".equals(event.getActionCommand())) {
			Player playerOne = new Player(null, null, null);
			game.addPlayer(playerOne);
			Player playerTwo = new Player(null, null, null);
			game.addPlayer(playerTwo);
			Player playerThree = new Player(null, null, null);
			game.addPlayer(playerThree);
			Player playerFour = new Player(null, null, null);
			game.addPlayer(playerFour);
			frame.changePanel(playerOptionsMenu = new PlayerOptionsMenu(frame, game));
		}
		else if ("back".equals(event.getActionCommand())) {
			frame.changePanel(gameSizeMenu = new GameSizeMenu(frame));
		}
	}
}