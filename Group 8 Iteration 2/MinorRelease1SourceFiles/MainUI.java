import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainUI extends JFrame{
	
	private JPanel mainMenu = new MainMenu(this);
	protected boolean fullScreen;
	
	public MainUI() {
		this.setPreferredSize(new Dimension(600, 400)); //First number is left-right, second number is up-down, current numbers are placeholders
		fullScreen = false;
		getContentPane().add(mainMenu);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	//This line gets the screen size of the host device and is used for setting the frame to full screen
	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	
	//Method used to swap between the various panels
	public void changePanel(JPanel panel) {
		getContentPane().removeAll();
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().doLayout();
		revalidate();
		repaint();
	}
	
	//Method used to change the frame from full screen to windowed, or visa versa
	public void changeWindowMode(boolean fullScreen) {
		if (fullScreen) {
			device.setFullScreenWindow(this);
			this.fullScreen = true;
			revalidate();
			repaint();
		}
		else if (!fullScreen) {
			device.setFullScreenWindow(null);
			this.fullScreen = false;
			revalidate();
			repaint();
		}
		revalidate();
		repaint();
	}
	
	public static void main(String[] args) {
		new MainUI();
	}
}
	

