import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
        mainPanel.setLayout(new GridBagLayout());
        //mainPanel.setSize(500,500);
        GridBagConstraints c = new GridBagConstraints(); //need this for adding components in a gridbag layout
//two 1x4 blocks in boxlayout to represent dominos 
        JPanel centerPanel1 = makeCenterPanel();
        JPanel centerPanel2 = makeCenterPanel();
        mainCenterPanel = new JPanel();
        mainCenterPanel.setLayout(new BoxLayout(mainCenterPanel,BoxLayout.PAGE_AXIS));
        mainCenterPanel.add(centerPanel1);
        mainCenterPanel.add(centerPanel2);
// placing this panel in the center, (1,1)
        c.gridx = 1;
        c.gridy = 1;
        mainCenterPanel.setPreferredSize(new Dimension(500,500));
        mainPanel.add(mainCenterPanel,c);
//creating a 5x5 grid for each player
        JPanel p1 = makePlayerGrid();
//adjusting the constraints before adding each player grids
        c.weightx = 0.5; //effects the resizing of components
        c.weighty = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        p1.setPreferredSize(new Dimension(200,200));
        mainPanel.add(p1,c);

        JPanel p2 = makePlayerGrid();
        c.gridx = 1;
        c.gridy = 2;
        p2.setPreferredSize(new Dimension(200,200));
        mainPanel.add(p2,c);

        if (numPlayers == 4){
            JPanel p3 = makePlayerGrid();
            c.gridx = 0;
            c.gridy = 1;
            p3.setPreferredSize(new Dimension(200,200));
            mainPanel.add(p3,c);
    
            JPanel p4 = makePlayerGrid();
            c.gridx = 2;
            c.gridy = 1;
            p4.setPreferredSize(new Dimension(200,200));
            mainPanel.add(p4,c);
        }

        setLayout(new BorderLayout(10,10));
        //setSize(1000,1000);
        add(topPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        //frame.setSize(1000,1000);
    }

    private JPanel makePlayerGrid(){
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(5,5));
        playerPanel.setSize(50,50);
        //playerPanel.setPreferredSize(new Dimension(50,50));
        for(int x = 0 ;x < 5; x++){
            for (int y = 0; y < 5; y++){
                JPanel square = new JPanel();
                square.setSize(10,10);
                square.setBackground(Color.white);
                square.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,Color.lightGray,Color.lightGray));
                playerPanel.add(square);
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
