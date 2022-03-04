import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainUI extends JFrame{
	
	private JPanel mainMenu = new MainMenu(this);
	//private JPanel gameGrid = new GameGrid(this);
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
	}
	
	public void changeWindowMode(boolean fullScreen) {
		if (fullScreen) {
			device.setFullScreenWindow(this);
		}
		else if (!fullScreen) {
			device.setFullScreenWindow(null);
		}
		revalidate();
		repaint();
	}
	
	public static void main(String[] args) {
		new MainUI();
	}
}
	

