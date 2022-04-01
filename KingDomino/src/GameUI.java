import javax.swing.*;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.awt.GridBagConstraints;
import java.awt.*;
import javax.swing.border.*;


public class GameUI extends JPanel{
    private MainUI frame;//
    private JPanel p1, p2, p3, p4, mainPanel, mainCenterPanel, topPanel;
    private Tile [][]  l1, l2, middleSquares, l3, l4;
    private Player player1, player2, player3, player4;
    private Controller controller;
    private JButton save, load, draw, test;
    private JLabel turnLabel;
    private ArrayList<Player> players;
    
    public GameUI(ArrayList<Player> players, MainUI mainUI){

        this.frame = mainUI;
        setLayout(new BorderLayout());
        setSize(500,500);
        this.players = players;

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0.5;
        c.weighty = 0.5;
        //top panel
        topPanel = new JPanel();
        save = new JButton("Save");
        load = new JButton("Load");
        draw = new JButton("Draw Dominos");
        test = new JButton("Test");

        topPanel.add(save);
        topPanel.add(load);
        topPanel.add(draw);
        topPanel.add(test);

        topPanel.add(Box.createRigidArea(new Dimension(10,10)));
        turnLabel = new JLabel("Welcome to KING DOMINO!!!");
        topPanel.add(turnLabel);


        //main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        setSize(500,500);

        ArrayList<Tile[][]> listOfGrid = new ArrayList<>();
        l1 = new Tile[5][5];
        l2 = new Tile[5][5];
        p1 = makePlayerGrid(l1); /////////////////////
        p2 = makePlayerGrid(l2);
        listOfGrid.add(l1);
        listOfGrid.add(l2);
        if (players.size() == 4){
            l3 = new Tile[5][5];
            l4 = new Tile[5][5];
            p3 = makePlayerGrid(l3);
            p4 = makePlayerGrid(l4);
            listOfGrid.add(l3);
            listOfGrid.add(l4);
        }
        // setting the player grid for each player
        for (int x =0; x < players.size(); x++){
            players.get(x).setGrid(listOfGrid.get(x));
        }

        //player1 = new Player("Bob", Color.red, l1);
        //player2 = new Player("Tom", Color.green, l2);
        //player3 = new Player("Jim", Color.blue, l3);
        //player4 = new Player("Rob",Color.yellow,l4);
        //////////////////////////////////////////////////////////////////////
        //center panel
        middleSquares = new Tile[2][4];
        JPanel centerPanel = makeCenterPanel(middleSquares);
        mainCenterPanel = new JPanel();
        //mainCenterPanel.setLayout(new BoxLayout(mainCenterPanel,BoxLayout.PAGE_AXIS));
        //mainCenterPanel.add();
        mainCenterPanel.setLayout(new BorderLayout());
        mainCenterPanel.add(centerPanel,BorderLayout.CENTER);
        

        //b1 = new JButton("b1");
        p1.setPreferredSize(new Dimension(200,200));
        c.gridx =1;
        c.gridy = 0;
        mainPanel.add(p1,c);

        p2.setPreferredSize(new Dimension(200,200));
        c.gridx =1;
        c.gridy = 2;
        mainPanel.add(p2,c);

        if (players.size() == 4){
            c.gridx = 0;
            c.gridy = 1;
            p3.setPreferredSize(new Dimension(200,200));
            mainPanel.add(p3,c);
    
            c.gridx = 2;
            c.gridy = 1;
            p4.setPreferredSize(new Dimension(200,200));
            mainPanel.add(p4,c);
        }


        mainCenterPanel.setPreferredSize(new Dimension(500,200));
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(mainCenterPanel,c);

        add(topPanel,BorderLayout.NORTH);
        add(mainPanel,BorderLayout.CENTER);
        ////////////////////////////////////////////////////////////////////////////////////////////////
        controller = new Controller(this, frame);
        this.addController();
        test.addActionListener(controller);
        draw.addActionListener(controller);
///////////////////////////////////////////////////////////////////
        //for testing
        //frame = new JFrame();
        //frame.setSize(500,500);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().add(this);
        //frame.pack();
        //frame.setVisible(true);
//////////////////////////////////////////////////////////////////////////////////////////////
    }
    


    private JPanel makePlayerGrid(Tile[][] list){
        JPanel playerPanel = new JPanel();
        //
        //GridLayout GL = new GridLayout(5,5);
        //GL.setHgap(10);
        //playerPanel.setLayout(GL);
        playerPanel.setLayout(new GridLayout(5,5));
        playerPanel.setSize(50,50);
        //playerPanel.setPreferredSize(new Dimension(50,50));
        for(int x = 0 ;x < 5; x++){
            for (int y = 0; y < 5; y++){
                Tile square = new Tile(x,y,"",false);
                square.setSize(10,10);
                square.setBackground(Color.white);
                square.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,Color.lightGray,Color.lightGray));
                list[x][y] = square;
                playerPanel.add(square);
            }
        }
        return playerPanel;
    }

    private JPanel makeCenterPanel(Tile[][] list){
        JPanel centerPanel = new JPanel();
        centerPanel.setSize(50,50);
        GridLayout GL = new GridLayout(2,4);
        GL.setHgap(10);
        GL.setVgap(10);
        centerPanel.setLayout(GL);
        for (int x = 0; x < 2; x++){
            for (int y = 0; y < 4; y++){
                Tile square = new Tile(x,y,"",true);
                square.setSize(100,100);
                square.setBackground(Color.white);
                centerPanel.add(square);
                square.setBorder(BorderFactory.createEmptyBorder());                
                centerPanel.add(Box.createRigidArea(new Dimension(10,10)));
                list[x][y] = square;
            }
        }
        return centerPanel;
    }
    public void updateMiddleGrid(Tile[][] middleGrid){
        JPanel centerPanel = new JPanel();
        centerPanel.setSize(50,50);
        GridLayout GL = new GridLayout(2,4);
        GL.setHgap(10);
        GL.setVgap(10);
        centerPanel.setLayout(GL);
        for (int x = 0; x < 2; x++){
            for (int y = 0; y < 4; y++){
                Tile tile = middleGrid[x][y];
                centerPanel.add(tile);
                centerPanel.add(Box.createRigidArea(new Dimension(10,10)));
            }
        }
        mainCenterPanel.removeAll();
        mainCenterPanel.add(centerPanel,BorderLayout.CENTER);
        frame.revalidate();
    }

    
    //--------------------------------------------------------------------------------------------------------//
    public ArrayList<Player> getPlayerList(){
        return players;
    }
    public Tile[][] getMiddleGrid() {
        return middleSquares;
    }
    private void addController(){
        //adding ActionListener to the middle grid
        Tile[][] middleGrid = this.getMiddleGrid();
        for (int p=0; p<2; p++){
            for (int q=0; q < 4; q++){
                middleGrid[p][q].addActionListener(controller);
            }
        }
        //adding actionListener to each tile in playergrid for each player
        //Player[] playerList = this.getPlayerList();
        for (Player player : players){
            Tile[][] playerGrid = player.getPlayerGrid();
            for (int x = 0; x < 5; x++ ){
                for (int y=0; y<5; y++){
                    playerGrid[x][y].addActionListener(controller);
                }
            }
        }
    }
    public ArrayList<JButton> getButtons(){
        //might make a list of buttons
        ArrayList <JButton> buttonsList = new ArrayList<>();
        buttonsList.add(draw);
        buttonsList.add(test);
        return buttonsList;
    }
    ///////////////////////////////////////------------------/////////////////////////////
    //public JFrame getFrame() {
        //return frame;
    //}
    public MainUI getFrame() {
        return frame;
    }
    public JLabel getTurnLabel() {
        return turnLabel;
    }
    public JButton getDraw() {
        return draw;
    }
    
}
