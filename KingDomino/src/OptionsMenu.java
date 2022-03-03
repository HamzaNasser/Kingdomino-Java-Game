import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OptionsMenu extends JPanel implements ActionListener{
	
	private JButton playerOptions, displayOptions, back;
	private MainUI frame;
	private JPanel displayOptionsMenu, mainMenu;
	
	public OptionsMenu(MainUI mainUI) {
		super();
		this.frame = mainUI;
		
		playerOptions = new JButton("Player Options");
		playerOptions.setActionCommand("playerOptions");
		
		displayOptions = new JButton("Display Options");
		displayOptions.setActionCommand("displayOptions");
		
		back = new JButton("Back");
		back.setActionCommand("back");
		
		playerOptions.addActionListener(this);
		displayOptions.addActionListener(this);
		back.addActionListener(this);
		
		add(playerOptions);
		add(displayOptions);
		add(back);
	}
	
	public void actionPerformed(ActionEvent event) {
		if ("playerOptions".equals(event.getActionCommand())) {
			System.out.println("Player Options");
		}
		else if ("displayOptions".equals(event.getActionCommand())) {
			frame.changePanel(displayOptionsMenu = new DisplayOptionsMenu(frame));
		}
		else if ("back".equals(event.getActionCommand())) {
			frame.changePanel(mainMenu = new MainMenu(frame));
		}
		
	}

}
