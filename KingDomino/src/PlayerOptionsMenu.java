import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.Color;

public class PlayerOptionsMenu extends JPanel implements ActionListener {
	
    private JButton confirmButton, chooseColor;
    private JTextField nameField;
    private JLabel nameLabel, optionLabel, confirmLabel, colorLabel;
    private MainUI frame;
    private JPanel panel, gameGrid, playerOptionsMenu;
    private Color color;
    private ArrayList<Player> players;
    private int placeInArray;
    
    public PlayerOptionsMenu(MainUI mainUI, ArrayList<Player> players){
        super();
		this.frame = mainUI;
		this.players = players;
		placeInArray = 0;
		
        optionLabel = new JLabel("Player " + String.valueOf(placeInArray+1));
        optionLabel.setFont(new Font(null, Font.ITALIC, 40));
        colorLabel = new JLabel("Choose Color: ");
		chooseColor = new JButton("Select Color");
		chooseColor.addActionListener(this);        
        panel = new JPanel();
        confirmLabel = new JLabel("");
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);
        nameLabel = new JLabel("Change Name: ");
        nameField = new JTextField();      

        optionLabel.setBounds(60, 0, 220, 120);
        nameLabel.setBounds(60,110,140,40);
        nameField.setBounds(170,110,240,40);
    
        confirmButton.setBounds(190, 310, 100, 20);
        confirmLabel.setBounds(170,330,340,40);
        colorLabel.setBounds(60,190,140,40);
        chooseColor.setBounds(170, 190, 240, 40);

        add(colorLabel);
        add(chooseColor);
        add(confirmButton);
        add(optionLabel);
        add(nameLabel);
        add(nameField);
        setLayout(null);

        add(confirmLabel);      
        setSize(450, 450);    
    }
 
    public PlayerOptionsMenu(MainUI mainUI, ArrayList<Player> players, int placeInArray){
        super();
		this.frame = mainUI;
		this.players = players;
		this.placeInArray = placeInArray;
		
        optionLabel = new JLabel("Player " + String.valueOf(placeInArray+1));
        optionLabel.setFont(new Font(null, Font.ITALIC, 40));
        colorLabel = new JLabel("Choose Color: ");
		chooseColor = new JButton("Select Color");
		chooseColor.addActionListener(this);        
        panel = new JPanel();
        confirmLabel = new JLabel("");
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);
        nameLabel = new JLabel("Change Name: ");
        nameField = new JTextField();      

        optionLabel.setBounds(60, 0, 220, 120);
        nameLabel.setBounds(60,110,140,40);
        nameField.setBounds(170,110,240,40);
    
        confirmButton.setBounds(190, 310, 100, 20);
        confirmLabel.setBounds(170,330,340,40);
        colorLabel.setBounds(60,190,140,40);
        chooseColor.setBounds(170, 190, 240, 40);

        add(colorLabel);
        add(chooseColor);
        add(confirmButton);
        add(optionLabel);
        add(nameLabel);
        add(nameField);
        setLayout(null);

        add(confirmLabel);      
        setSize(450, 450);    
    }
    
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == confirmButton){
        	players.get(placeInArray).setPlayerName(nameField.getText());
        	players.get(placeInArray).setPlayerColor(color);
            if (placeInArray == (players.size()-1)) {
            	frame.changePanel(gameGrid = new GameGrid(frame));
            }
            else {
            	placeInArray++;
            	frame.changePanel(playerOptionsMenu = new PlayerOptionsMenu(frame, players, placeInArray));
            }
        }
        if(e.getSource() == chooseColor){
            color = JColorChooser.showDialog(null, "Pick a color ", Color.YELLOW);

        }
    }
    
}