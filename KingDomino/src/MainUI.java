import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainUI extends JFrame{
	
private JPanel mainMenu = new MainMenu(this);
	
	public MainUI() {
		getContentPane().add(mainMenu);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		revalidate();
		repaint();
	}
	
	public void changePanel(JPanel panel) {
		getContentPane().removeAll();
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().doLayout();
		revalidate();
		repaint();
		pack();
	}
	

	public static void main(String[] args) {
		MainUI mainUI = new MainUI();
		mainUI.pack();
		mainUI.setVisible(true);
	}
}
	

