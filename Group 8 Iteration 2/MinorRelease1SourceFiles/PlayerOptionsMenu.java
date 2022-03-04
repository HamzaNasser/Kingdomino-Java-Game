import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

public class PlayerOptionsMenu extends JPanel implements ActionListener {
	
    JButton changeDifficulty, back, backButton, confirmButton, chooseColor;
//    JRadioButton easyButton, mediumButton, hardButton;
    JTextField nameField;
    ButtonGroup difficultyButtons;
    JLabel nameLabel, difficultyLabel, optionLabel, confirmLabel,colorLabel;
    private MainUI frame;
    JPanel panel, optionsPanel;
    
    public PlayerOptionsMenu(MainUI mainUI){
        super();
		this.frame = mainUI;
		
        optionLabel = new JLabel("Settings");
        optionLabel.setFont(new Font(null, Font.ITALIC, 40));
        colorLabel = new JLabel("Choose Color: ");
		chooseColor = new JButton("Select Color");
		chooseColor.addActionListener(this);        
        //frame.setLayout(new BorderLayout());
        panel = new JPanel();
        confirmLabel = new JLabel("");
        difficultyButtons = new ButtonGroup();
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        nameLabel = new JLabel("Change Name: ");
        difficultyLabel = new JLabel("Select Difficulty: ");
        nameField = new JTextField();
        
        //changeDifficulty = new JButton("Change Difficulty");
/*        
        easyButton = new JRadioButton("Easy");
        easyButton.addActionListener(this);
        mediumButton = new JRadioButton("Medium");
        mediumButton.addActionListener(this);
        hardButton = new JRadioButton("Hard");
        hardButton.addActionListener(this);
        difficultyButtons.add(easyButton);
        difficultyButtons.add(mediumButton);
        difficultyButtons.add(hardButton);
*/        

        optionLabel.setBounds(60, 0, 220, 120);
        nameLabel.setBounds(60,110,140,40);
        nameField.setBounds(170,110,240,40);
//        difficultyLabel.setBounds(60,190,140,40);
/*        
        easyButton.setBounds(170, 190, 140, 20);
        mediumButton.setBounds(170, 215, 140, 20);
        hardButton.setBounds(170, 240, 140, 20);
*/        
        confirmButton.setBounds(190, 310, 100, 20);
        backButton.setBounds(290, 310, 100, 20);
        confirmLabel.setBounds(170,330,340,40);
        colorLabel.setBounds(60,190,140,40);
        chooseColor.setBounds(170, 190, 240, 40);

        add(colorLabel);
        add(chooseColor);
        add(backButton);
        add(confirmButton);
        add(optionLabel);
        add(nameLabel);
        add(nameField);
        add(difficultyLabel);
        setLayout(null);
/*        
        add(easyButton);
        add(mediumButton);
        add(hardButton); 
*/ 
        add(confirmLabel);      
        setSize(450, 450);
        
    

/*
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(changeDifficulty);
        add(panel, BorderLayout.SOUTH);
*/
        
    }
 













    @Override
    public void actionPerformed(ActionEvent e) {
/*
        if(e.getSource() == easyButton){
            System.out.println("Easy button selected.");
        }
        else if(e.getSource() == mediumButton){
            System.out.println("Medium button selected");
        }
        else if(e.getSource() == hardButton){
            System.out.println("Hard Button selected");
        }
 */       
        if(e.getSource() == backButton){
            frame.changePanel(optionsPanel = new OptionsMenu(frame));
        }

        if(e.getSource() == confirmButton){
            confirmLabel.setText("Settings Confirmed. Press Back to return to menu.");
        }
        if(e.getSource() == chooseColor){
            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null, "Pick a color ", Color.YELLOW);

        }
    }
    
}