import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu extends JPanel implements ActionListener{
		
	private JButton newGame, loadGame, options;
	private MainUI frame;
	private JPanel optionsMenu;
		
	public MainMenu(MainUI mainUI) {
		super();
		this.frame = mainUI;
		
		newGame = new JButton("New Game");
		newGame.setActionCommand("newGame");
			
		loadGame = new JButton("Load Game");
		loadGame.setActionCommand("loadGame");
			
		options = new JButton("Options");
		options.setActionCommand("options");
			
		newGame.addActionListener(this);
		loadGame.addActionListener(this);
		options.addActionListener(this);
			
		add(newGame);
		add(loadGame);
		add(options);
	}

	public void newGame() {
		System.out.println("New Game");
	}
		
	public void loadGame() {
		System.out.println("Load Game");
	}
		
	public void options() {
		System.out.println("Options");
	}
		
	public void actionPerformed(ActionEvent event) {
		if ("newGame".equals(event.getActionCommand())) {
			newGame();
		}
		else if ("loadGame".equals(event.getActionCommand())) {
			loadGame();
		}
		else if ("options".equals(event.getActionCommand())) {
			frame.changePanel(optionsMenu = new playerOptions(frame));
		}
	}

}
