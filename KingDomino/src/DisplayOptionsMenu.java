import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DisplayOptionsMenu extends JPanel implements ActionListener{
	
	private JButton changeResolution, changeWindowMode, back;
	private MainUI frame;
	private JPanel optionsMenu;
	private String windowModeString;
	
	public DisplayOptionsMenu(MainUI mainUI) {
		super();
		this.frame = mainUI;
		if (!frame.fullScreen) {
			windowModeString = "Fullscreen";
		}
		else if (frame.fullScreen) {
			windowModeString = "Windowed Mode";
		}
		
		//changeResolution = new JButton("Change Resolution");
		//changeResolution.setActionCommand("resolution");
		
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
	
	public void actionPerformed(ActionEvent event) {
		//if ("resolution".equals(event.getActionCommand())) {
			//int answer = JOptionPane.showConfirmDialog(frame,
					//"Would you like to keep the changes?",
					//"Accept Changes?",
					//JOptionPane.YES_NO_OPTION);
			//if (answer == 1) {
				//frame.undo();
			//}
		//}
		if ("windowMode".equals(event.getActionCommand())) {
			frame.changeWindowMode(!frame.fullScreen);
			int answer = JOptionPane.showConfirmDialog(frame,
					"Would you like to keep the changes?",
					"Accept Changes?",
					JOptionPane.YES_NO_OPTION);
			if (answer == 1) {
				frame.changeWindowMode(!frame.fullScreen);
			}
			System.out.println(frame.fullScreen);
		}
		else if ("back".equals(event.getActionCommand())) {
			frame.changePanel(optionsMenu = new OptionsMenu(frame));
		}

	}
}
