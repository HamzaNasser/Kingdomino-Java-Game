import javax.swing.*;
import java.awt.*;
import javax.swing.border.EtchedBorder;
import java.util.*;
import java.awt.event.*;
import java.io.Serializable;


public class Main extends JPanel implements ActionListener{
    JPanel topPanel,mainPanel;
    JButton save, load, placeSquare;
    ArrayList<Square> squareList;
    ArrayList<ArrayList> usedCoordinates;
    ArrayList<Color> colors;
    JButton[][] grid;
    

    public Main(){
        grid = new JButton[5][5];
        setLayout(new BorderLayout());
        setSize(500,500);

        usedCoordinates = new ArrayList<>();
        squareList = new ArrayList<>();
        colors = new ArrayList<>();

        //top panel
        JPanel topPanel = new JPanel();
        save = new JButton("Save");
        load = new JButton("Load");
        placeSquare = new JButton("Place Square");
        save.addActionListener(this);
        load.addActionListener(this);
        placeSquare.addActionListener(this);
        topPanel.add(save);
        topPanel.add(load);
        topPanel.add(placeSquare);
        //main panel
        mainPanel = makePlayerGrid();
        mainPanel.setPreferredSize(new Dimension(200,200));
        add(topPanel,BorderLayout.NORTH);
        add(mainPanel,BorderLayout.CENTER);
        //array of color used for choosing random colors for squares.
        colors.add(Color.RED);
        colors.add(Color.CYAN);
        colors.add(Color.BLUE);
        colors.add(Color.PINK);
        colors.add(Color.GREEN);
        colors.add(Color.ORANGE);
    }

    public void actionPerformed(ActionEvent event){
        Object selected= event.getSource();
        if (selected.equals(placeSquare)){
            placeASquare();
        }
        else if (selected.equals(save)){
            Save(squareList,"data.txt");
        }
        else if (selected.equals(load)){
            Load("data.txt");
        }

    }
//creates the 5x5 panel
    private JPanel makePlayerGrid(){
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(5,5));
        playerPanel.setSize(50,50);
        //playerPanel.setPreferredSize(new Dimension(50,50));
        for(int x = 0 ;x < 5; x++){
            for (int y = 0; y < 5; y++){
                JButton square = new JButton();
                grid[x][y] = square; 
                square.setSize(10,10);
                square.setBackground(Color.white);
                square.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,Color.lightGray,Color.lightGray));
                playerPanel.add(square);
            }
        }
        return playerPanel;
    }
    //creating a simple simulation, chooses a random square and changes its color. 
    private void placeASquare(){
        ArrayList<Integer> coord = new ArrayList<Integer>();
        Random rand = new Random();
        int x = rand.nextInt(5);
        int y = rand.nextInt(5);
        coord.add(x);
        coord.add(y);
        if (!usedCoordinates.contains(coord)){
            int num = rand.nextInt(6);
            Square square = new Square(colors.get(num),x,y);
            squareList.add(square);
            grid[x][y].setBackground(square.color);
            usedCoordinates.add(coord);
        }    
    }
    private void Save(Serializable data, String filename){
        try{
            ResourceManager.save(data,"data.txt");
        }
        catch (Exception ee){
            System.out.println("Cannot Save...");
        }
    }
    private void Load(String filename){
        try{
            ArrayList<Square> loadedList = (ArrayList<Square>) ResourceManager.load("data.txt"); 
            for (int count=0 ;count < loadedList.size(); count++){
                Square square = loadedList.get(count);
                grid[square.x][square.y].setBackground(square.color);
            }
        }
        catch (Exception ee){
            System.out.println("Cannot load");
        }
    }

    public static void main(String[] args){
        Main Main = new Main();
        JFrame jf = new JFrame();
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.add(Main);
        jf.pack();
    }
}
