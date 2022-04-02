import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameSizeMenu extends JPanel implements ActionListener {
	
	private JButton twoPlayer, fourPlayer, back;
	private MainUI frame;
	private JPanel mainMenu, gamePlayerMenu;
	
	//GameSizeMenu constructor
	public GameSizeMenu(MainUI mainUI) {
		super();
		this.frame = mainUI;
		
		twoPlayer = new JButton("2 Players");
		twoPlayer.setActionCommand("twoPlayer");
		
		fourPlayer = new JButton("4 Players");
		fourPlayer.setActionCommand("fourPlayer");
		
		back = new JButton("Back");
		back.setActionCommand("back");
		
		twoPlayer.addActionListener(this);
		fourPlayer.addActionListener(this);
		back.addActionListener(this);
		
		add(twoPlayer);
		add(fourPlayer);
		add(back);
	}
	
	//Action event for the buttons
	public void actionPerformed(ActionEvent event) {
		if ("twoPlayer".equals(event.getActionCommand())) {
			GameSettings game = new GameSettings();
			game.setGameSize(2);
			frame.changePanel(gamePlayerMenu = new GamePlayersMenu(frame, game));
		}
		else if ("fourPlayer".equals(event.getActionCommand())) {
			GameSettings game = new GameSettings();
			game.setGameSize(4);
			frame.changePanel(gamePlayerMenu = new GamePlayersMenu(frame, game));
		}
		else if ("back".equals(event.getActionCommand())) {
			frame.changePanel(mainMenu = new MainMenu(frame));
		}
	}
}