import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DisplayOptionsMenu extends JPanel implements ActionListener{
	
	private JButton changeResolution, changeWindowMode, back;
	private MainUI frame;
	private JPanel mainMenu;
	private String windowModeString;
	
	//Setup the DisplayOptionsMenu panel
	public DisplayOptionsMenu(MainUI mainUI) {
		super();
		this.frame = mainUI;
		if (!frame.fullScreen) {
			windowModeString = "Fullscreen";
		}
		else if (frame.fullScreen) {
			windowModeString = "Windowed Mode";
		}
		
		/*
		changeResolution = new JButton("Change Resolution");
		changeResolution.setActionCommand("resolution");
		*/
		
		changeWindowMode = new JButton("Change to "+ windowModeString);
		changeWindowMode.setActionCommand("windowMode");
		
		back = new JButton("Back");
		back.setActionCommand("back");
		
		//changeResolution.addActionListener(this);
		changeWindowMode.addActionListener(this);
		back.addActionListener(this);
		
		//add(changeResolution);
		add(changeWindowMode);
		add(back);	
	}
	
	//Action events for the buttons
	public void actionPerformed(ActionEvent event) {
		//Calls the method to change the JFrame from full screen to windowed, or visa versa
		if ("windowMode".equals(event.getActionCommand())) {
			frame.changeWindowMode(!frame.fullScreen);
			if (!frame.fullScreen) {
				windowModeString = "Full Screen";
			}
			else if (frame.fullScreen) {
				windowModeString = "Windowed Mode";
			}
			changeWindowMode.setText("Change to " + windowModeString);
			//I can't get the dialog to stay at the front, at least on my machine
			int answer = JOptionPane.showConfirmDialog(frame,
					"Would you like to keep the changes?",
					"Accept Changes?",
					JOptionPane.YES_NO_OPTION);
			if (answer == JOptionPane.NO_OPTION) {
				frame.changeWindowMode(!frame.fullScreen);
				if (!frame.fullScreen) {
					windowModeString = "Fullscreen";
				}
				else if (frame.fullScreen) {
					windowModeString = "Windowed Mode";
				}
				changeWindowMode.setText("Change to " + windowModeString);
			}
		}
		else if ("back".equals(event.getActionCommand())) {
			frame.changePanel(mainMenu = new MainMenu(frame));
		}

	}
}
