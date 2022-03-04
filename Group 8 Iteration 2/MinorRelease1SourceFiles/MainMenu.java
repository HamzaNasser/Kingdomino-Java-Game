import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MainMenu extends JPanel implements ActionListener{
		
	private JButton newGame, loadGame, options, exit;
	private MainUI frame;
	private OptionsMenu optionsMenu;
	
	//Set up the main menu panel
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
			JPanel gameGrid = new GameGrid(frame);
			frame.changePanel(gameGrid);
		}
		else if ("loadGame".equals(event.getActionCommand())) {
			//loadGame();
		}
		else if ("options".equals(event.getActionCommand())) {
			frame.changePanel(optionsMenu = new OptionsMenu(frame));
		}
		else if ("exit".equals(event.getActionCommand())) {
			System.exit(0);
		}
	}

}
