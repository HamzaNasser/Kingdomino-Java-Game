import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainUI extends JFrame{
	
	private JPanel mainMenu = new MainMenu(this);
	protected boolean fullScreen;
	
	public MainUI() {
		fullScreen = false;
		getContentPane().add(mainMenu);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	
	public void changePanel(JPanel panel) {
		getContentPane().removeAll();
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().doLayout();
		revalidate();
		repaint();
		pack();
	}
	
	public void changeWindowMode(boolean fullScreen) {
		if (fullScreen) {
			device.setFullScreenWindow(this);
		}
		else if (!fullScreen) {
			device.setFullScreenWindow(null);
		}
	}
	
	public static void main(String[] args) {
		new MainUI();
	}
}
	

