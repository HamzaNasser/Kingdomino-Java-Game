import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MainMenu extends JPanel implements ActionListener{
		
	private JButton newGame, loadGame, options, exit;
	private MainUI frame;
	private GameSizeMenu gameSizeMenu;
	private DisplayOptionsMenu displayOptionsMenu;
	
	//MainMenu constructor
	public MainMenu(MainUI mainUI) {
		super();
		this.frame = mainUI;
		
		newGame = new JButton("New Game");
		newGame.setActionCommand("newGame");
			
		loadGame = new JButton("Load Game");
		loadGame.setActionCommand("loadGame");
			
		options = new JButton("Options");
		options.setActionCommand("options");
		
		exit = new JButton("Exit Game");
		exit.setActionCommand("exit");
			
		newGame.addActionListener(this);
		loadGame.addActionListener(this);
		options.addActionListener(this);
		exit.addActionListener(this);
			
		add(newGame);
		add(loadGame);
		add(options);
		add(exit);
	}
	
	//Action events for buttons
	public void actionPerformed(ActionEvent event) {
		if ("newGame".equals(event.getActionCommand())) {
			frame.changePanel(gameSizeMenu = new GameSizeMenu(frame));
		}
		else if ("loadGame".equals(event.getActionCommand())) {
			/*
			 * Save and Load game not implemented
			 * This is test code that sets up a custom playerGrid for testing purposes.
			Tile[][] testGrid = new Tile[5][5];
			testGrid[0][0] = new Tile(0,0,"forest",false);
			testGrid[0][0].setCrowns(2);
			testGrid[0][1] = new Tile(0,1,"lake",false);
			testGrid[0][1].setCrowns(3);
			testGrid[0][2] = new Tile(0,2,"forest",false);
			testGrid[0][2].setCrowns(1);
			testGrid[0][3] = new Tile(0,3,"desert",false);
			testGrid[0][3].setCrowns(1);
			testGrid[0][4] = new Tile(0,4,"desert",false);
			testGrid[0][4].setCrowns(2);
			testGrid[1][0] = new Tile(1,0,"forest",false);
			testGrid[1][0].setCrowns(3);
			testGrid[1][1] = new Tile(1,1,"",false);
			testGrid[1][1].setCrowns(0);
			testGrid[1][2] = new Tile(1,2,"",false);
			testGrid[1][2].setCrowns(0);
			testGrid[1][3] = new Tile(1,3,"lake",false);
			testGrid[1][3].setCrowns(0);
			testGrid[1][4] = new Tile(1,4,"lake",false);
			testGrid[1][4].setCrowns(0);
			testGrid[2][0] = new Tile(2,0,"lake",false);
			testGrid[2][0].setCrowns(3);
			testGrid[2][1] = new Tile(2,1,"lake",false);
			testGrid[2][1].setCrowns(4);
			testGrid[2][2] = new Tile(2,2,"castle",false);
			testGrid[2][2].setCrowns(0);
			testGrid[2][3] = new Tile(2,3,"lake",false);
			testGrid[2][3].setCrowns(1);
			testGrid[2][4] = new Tile(2,4,"lake",false);
			testGrid[2][4].setCrowns(3);
			testGrid[3][0] = new Tile(3,0,"forest",false);
			testGrid[3][0].setCrowns(3);
			testGrid[3][1] = new Tile(3,1,"desert",false);
			testGrid[3][1].setCrowns(4);
			testGrid[3][2] = new Tile(3,2,"",false);
			testGrid[3][2].setCrowns(0);
			testGrid[3][3] = new Tile(3,3,"",false);
			testGrid[3][3].setCrowns(0);
			testGrid[3][4] = new Tile(3,4,"desert",false);
			testGrid[3][4].setCrowns(2);
			testGrid[4][0] = new Tile(4,0,"forest",false);
			testGrid[4][0].setCrowns(3);
			testGrid[4][1] = new Tile(4,1,"desert",false);
			testGrid[4][1].setCrowns(1);
			testGrid[4][2] = new Tile(4,2,"desert",false);
			testGrid[4][2].setCrowns(1);
			testGrid[4][3] = new Tile(4,3,"desert",false);
			testGrid[4][3].setCrowns(1);
			testGrid[4][4] = new Tile(4,4,"desert",false);
			testGrid[4][4].setCrowns(2);
			Player test = new Player("Test", Color.red, testGrid);
			System.out.println(test.calculateScore());
			*/
		}
		else if ("options".equals(event.getActionCommand())) {
			frame.changePanel(displayOptionsMenu = new DisplayOptionsMenu(frame));
		}
		else if ("exit".equals(event.getActionCommand())) {
			System.exit(0);
		}
	}

}
