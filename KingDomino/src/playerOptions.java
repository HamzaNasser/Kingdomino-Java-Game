import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class playerOptions extends JPanel implements ActionListener {
	
    JButton changeDifficulty, back, backButton, confirmButton;
    JRadioButton easyButton, mediumButton, hardButton;
    JTextField nameField;
    ButtonGroup difficultyButtons;
    JLabel nameLabel, difficultyLabel, optionLabel, confirmLabel;
    private MainUI frame;
    JPanel panel, optionsPanel;
    
    public playerOptions(MainUI mainUI){
        super();
		this.frame = mainUI;
		
        optionLabel = new JLabel("Settings");
        optionLabel.setFont(new Font(null, Font.ITALIC, 40));
        
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
        easyButton = new JRadioButton("Easy");
        easyButton.addActionListener(this);
        mediumButton = new JRadioButton("Medium");
        mediumButton.addActionListener(this);
        hardButton = new JRadioButton("Hard");
        hardButton.addActionListener(this);
        difficultyButtons.add(easyButton);
        difficultyButtons.add(mediumButton);
        difficultyButtons.add(hardButton);

        optionLabel.setBounds(60, 0, 220, 120);
        nameLabel.setBounds(60,110,140,40);
        nameField.setBounds(170,110,240,40);
        difficultyLabel.setBounds(60,190,140,40);
        easyButton.setBounds(170, 190, 140, 20);
        mediumButton.setBounds(170, 215, 140, 20);
        hardButton.setBounds(170, 240, 140, 20);
        confirmButton.setBounds(190, 280, 100, 20);
        backButton.setBounds(290, 280, 100, 20);
        confirmLabel.setBounds(170,310,340,40);

        add(backButton);
        add(confirmButton);
        add(optionLabel);
        add(nameLabel);
        add(nameField);
        add(difficultyLabel);
        setLayout(null);
        add(easyButton);
        add(mediumButton);
        add(hardButton);  
        add(confirmLabel);      
        setSize(400, 400);
        
    

/*
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(changeDifficulty);
        add(panel, BorderLayout.SOUTH);
*/
        
    }
 













    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == easyButton){
            System.out.println("Easy button selected.");
        }
        else if(e.getSource() == mediumButton){
            System.out.println("Medium button selected");
        }
        else if(e.getSource() == hardButton){
            System.out.println("Hard Button selected");
        }
        if(e.getSource() == backButton){
            frame.changePanel(optionsPanel = new OptionsMenu(frame));
        }
        if(e.getSource() == confirmButton){
            confirmLabel.setText("Settings Confirmed. Press Back to return to menu.");
        }
        
    }
    
}