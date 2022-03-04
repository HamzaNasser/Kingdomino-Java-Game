import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.EtchedBorder;

public class GameGrid extends JPanel implements ActionListener {
    JPanel mainPanel, topPanel, mainCenterPanel;
    MainUI frame;
    JButton back;
    int numPlayers;
    
    public GameGrid(MainUI mainUI){
        super();
        this.frame = mainUI;
        numPlayers = 4;   //hardcoded the design for 4 for now, can potentially make it a parameter later on
//top panel with the menu
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        back = new JButton("Back");
        topPanel.add(back);
        back.addActionListener(this);
//holds the board
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setSize(100,100);
        
        JPanel centerPanel1 = makeCenterPanel();
        JPanel centerPanel2 = makeCenterPanel();
//two 1x4 blocks in boxlayout to represent dominos 
        mainCenterPanel = new JPanel();
        mainCenterPanel.setLayout(new BoxLayout(mainCenterPanel,BoxLayout.PAGE_AXIS));
        mainCenterPanel.add(centerPanel1);
        mainCenterPanel.add(centerPanel2);

        mainPanel.add(mainCenterPanel,BorderLayout.CENTER);
//creating a 5x5 grid for each player
        JPanel p1 = makePlayerGrid();
        mainPanel.add(p1,BorderLayout.NORTH);

        JPanel p2 = makePlayerGrid();
        mainPanel.add(p2,BorderLayout.SOUTH);

        if (numPlayers == 4){
            JPanel p3 = makePlayerGrid();
            mainPanel.add(p3,BorderLayout.EAST);
    
            JPanel p4 = makePlayerGrid();
            mainPanel.add(p4,BorderLayout.WEST);
        }

        setLayout(new BorderLayout(10,10));
        add(topPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        
    }

    private JPanel makePlayerGrid(){
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(5,5));
        playerPanel.setSize(50,50);
        for(int x = 0 ;x < 5; x++){
            for (int y = 0; y < 5; y++){
                JPanel square = new JPanel();
                square.setSize(10,10);
                square.setBackground(Color.white);
                playerPanel.add(square);
                square.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,Color.lightGray,Color.lightGray));
            }
        }
        return playerPanel;
    }

    private JPanel makeCenterPanel(){
        JPanel centerPanel = new JPanel();
        centerPanel.setSize(50,50);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.LINE_AXIS));
        centerPanel.add(Box.createRigidArea(new Dimension(10,10)));
        for (int y = 0; y < 4; y++){
            JPanel square = new JPanel();
            square.setSize(10,10);
            square.setBackground(Color.white);
            centerPanel.add(square);
            square.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,Color.lightGray,Color.lightGray));
            centerPanel.add(Box.createRigidArea(new Dimension(10,10)));
        }
        return centerPanel;
    }
//functionality of the back button    
    public void actionPerformed(ActionEvent event) {
		if ("Back".equals(event.getActionCommand())) {
			backpressed();
		}
    }
    public void backpressed(){
		JPanel mainMenu = new MainMenu(frame);
		frame.changePanel(mainMenu);
    }
}
