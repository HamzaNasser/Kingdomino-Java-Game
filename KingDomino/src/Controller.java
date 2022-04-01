import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;



public class Controller implements ActionListener{
    
    private GameUI gameUI;
    private Tile[][] middleGrid;
    private Player[] playerList;
    private int flag = 0;
    private Player currentPlayer;
    private Domino currentDomino;
    private ArrayList<JButton> buttonsList;
    private ArrayList<Domino> deck;
    private JFrame frame;
    //private MainUI frame;
    private JLabel turnLabel;
    private JButton drawDomino;
    private Tile firstTile;

    public Controller(GameUI view){
        gameUI = view;
        playerList = gameUI.getPlayerList();
        middleGrid = gameUI.getMiddleGrid();
        buttonsList = gameUI.getButtons();

        //if 2 players removeHalf
        deck = new DominoGenerator().getDeck();

        frame = gameUI.getFrame();
        turnLabel = gameUI.getTurnLabel();
        drawDomino = gameUI.getDraw();

        getPlayerTurn();
        disableEverything();
        setMiddleGrid(true);

    }



    public void actionPerformed(ActionEvent event){
        Object selected = event.getSource();
        //middle grid tile selected
        if (selected instanceof Tile){
            Tile tile = (Tile) selected;
            if (tile.getInMiddleGrid() == true && tile.getBorder() == BorderFactory.createEmptyBorder()){
                tile.setBorder( BorderFactory.createLineBorder(currentPlayer.getColor(),5));
                setMiddleGrid(false);
                currentPlayer.setPlayerGrid(true); //enabling player grid
                System.out.println("Tile in the middle grid has been clicked!!!");
            }
            // player grid tile selected
            else if (tile.getInMiddleGrid() ==false){
                if (flag == 0){  //first tile clicked
                    firstTile = tile;
                    tile.setBackground(Color.lightGray);
                    currentPlayer.enableNeighbour(tile.getCoord());
                    flag++;
                }
                else if (flag == 1){ //second tile clicked
                    if (tile != firstTile){ //prevent the user for clicking the same tile twice.
                        tile.setBackground(Color.lightGray);
                        //check if valid blah blah blah
                        checkValidity(currentPlayer, firstTile, tile);
                        //post round actions
                        currentPlayer.setPlayerGrid(false);
                        if (getPlayerTurn() == false){drawDomino.setEnabled(true);}
                        setMiddleGrid(true);
                        flag = 0;
                    }
                }
            }
        }
        if (selected.equals(drawDomino)){
            withdrawDominos();
            JFrame frame = gameUI.getFrame();
            frame.revalidate(); //without this the dominos aren't visble unless if the window is resized!
            drawDomino.setEnabled(false);
            
            
        }
    }
    private Boolean getPlayerTurn(){
        Tile[] list = middleGrid[1];
        for (int i=0; i < 4; i++){
            Tile currTile = list[i];
            if (currTile.getBorder() != BorderFactory.createEmptyBorder()){
                currentDomino = currTile.getDomino();
                LineBorder border = (LineBorder) currTile.getBorder();
                Color color = border.getLineColor();
                for (Player player: playerList){
                    if (player.getColor() == color){
                        currentPlayer = player;
                        turnLabel.setText("It's " + currentPlayer.getName() + "'s Turn" );;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private void disableEverything(){
        for (int p=0; p<2; p++){
            for (int q=0; q < 4; q++){
                middleGrid[p][q].setEnabled(false);;
            }
        }
        //adding actionListener to each tile in playergrid for each player
        for (Player player : playerList){
            Tile[][] playerGrid = player.getPlayerGrid();
            for (int x = 0; x < 5; x++ ){
                for (int y=0; y<5; y++){
                    playerGrid[x][y].setEnabled(false);;
                }
            }
        }
    }
    //pass in true to enable or false to disable, only top 4 dominos will be affected
    private void setMiddleGrid(Boolean bool){
        Tile[] topGrid = middleGrid[0];
        for (Tile tile : topGrid){
            tile.setEnabled(bool);
        }
    }
    private void removeMiddleTile(){ 
        Tile[] list = middleGrid[1];
        for (int i=0; i < 4; i++){
            Tile currTile = list[i];
            if (currTile.getBorder() != BorderFactory.createEmptyBorder()){
                currTile.removeAll();
                currTile.setBorder(BorderFactory.createEmptyBorder());
                //currTile.setDomino(null);
                break;
            }
        }
    }

    private boolean withdrawDominos(){
        if (deck.size() ==0){ //empty deck
            System.out.println("END GAME!!");
            return false;

        }
        Domino[] dominoList = new Domino[4];
        for (int i = 0; i <4; i++){
            deck.get(0).setInMiddlePanel(true);
            dominoList[i] = deck.get(0);
            deck.remove(0);
        }
        Arrays.sort(dominoList, Comparator.comparingInt(Domino::getDomino_value)); //orders the dominos in ascending order.
        //first round //if top row is blank
        if (middleGrid[0][0].getBorder() == BorderFactory.createEmptyBorder()){
            for (int x =0; x <4; x++){
                Tile tile = middleGrid[0][x];
                Domino domino = dominoList[x];
                tile.placeDomino(domino, 0);
                tile.setDomino(domino);
                
            }
            return true;
        }
        //other rounds //move top row to the bottom, and the bottom row to the top and then populate!
        else if (middleGrid[0][0].getBorder() != BorderFactory.createEmptyBorder()){
            Tile[] topTiles = middleGrid[0].clone();
            Tile[] bottomTiles = middleGrid[1].clone();
            //swap
            middleGrid = new Tile[2][4];
            middleGrid[0] = bottomTiles;
            middleGrid[1] = topTiles;
            for (int x =0; x <4; x++){
                Tile tile = middleGrid[0][x];
                Domino domino = dominoList[x];
                tile.placeDomino(domino, 0);
                tile.setDomino(domino);
            }
        gameUI.updateMiddleGrid(middleGrid); //to swap it in the UI
        getPlayerTurn();
        disableEverything();
        setMiddleGrid(true);
        }
        return true;


    }
    //Rules for placing the tile
    private void checkValidity(Player currentPlayer, Tile tile1, Tile tile2){
        tile1.setTerrain(currentDomino.getTerrain_type_1());
        tile2.setTerrain(currentDomino.getTerrain_type_2());
        boolean result_1 = currentPlayer.isPlacementValid(tile1, tile2);
        boolean result_2 = currentPlayer.isPlacementValid(tile2, tile1);
        if (result_1 && result_2){
            System.out.println("1");
            removeMiddleTile();
            //setting the fields
            tile1.setTerrain(currentDomino.getTerrain_type_1());
            tile2.setTerrain(currentDomino.getTerrain_type_2());
            //adding crowns to the tiles 
            if (currentDomino.getCrownOnFirstHalf() == 1){
                tile1.setCrowns(currentDomino.getCrown());
            }
            else if (currentDomino.getCrownOnFirstHalf() == 0){
                tile2.setCrowns(currentDomino.getCrown());
            }
            tile1.setOccupied(true);
            tile1.setInMiddleGrid(false);
            tile2.setOccupied(true);
            tile2.setInMiddleGrid(false);
            //need to set crown but later...
            //placing dominos
            tile1.placeDomino(currentDomino,1);
            tile2.placeDomino(currentDomino, 2);
            //enable swap here ------------------------------------ (optional)
        }
        else if (result_1 == true && result_2 == false){
            System.out.println("2");
            removeMiddleTile();
            //setting the fields
            tile1.setTerrain(currentDomino.getTerrain_type_1());
            tile2.setTerrain(currentDomino.getTerrain_type_2());
            //adding crowns to the tiles 
            if (currentDomino.getCrownOnFirstHalf() == 1){
                tile1.setCrowns(currentDomino.getCrown());
            }
            else if (currentDomino.getCrownOnFirstHalf() == 0){
                tile2.setCrowns(currentDomino.getCrown());
            }
            tile1.setOccupied(true);
            tile1.setInMiddleGrid(false);
            tile2.setOccupied(true);
            tile2.setInMiddleGrid(false);
            //need to set crown but later...
            //placing dominos
            tile1.placeDomino(currentDomino,1);
            tile2.placeDomino(currentDomino, 2);
        }
        else if (result_1==false && result_2 ==true){
            System.out.println("3");
            removeMiddleTile();
            //setting the fields   //swap
            tile2.setTerrain(currentDomino.getTerrain_type_1());
            tile1.setTerrain(currentDomino.getTerrain_type_2());
            //adding crowns to the tiles 
            if (currentDomino.getCrownOnFirstHalf() == 1){
                tile2.setCrowns(currentDomino.getCrown());
            }
            else if (currentDomino.getCrownOnFirstHalf() == 0){
                tile1.setCrowns(currentDomino.getCrown());
            }
            tile2.setOccupied(true);
            tile2.setInMiddleGrid(false);
            tile1.setOccupied(true);
            tile1.setInMiddleGrid(false);
            //need to set crown but later...
            //placing dominos
            tile2.placeDomino(currentDomino,1);
            tile1.placeDomino(currentDomino, 2);
        }
        else{
            //discard here--------------------
            System.out.println("4");
            removeMiddleTile();
            currentPlayer.setTileColorWhite();
        }
        System.out.println("first_tile crown: "+ tile1.getCrowns() + " second_tile_crowns " +tile2.getCrowns());

    }
    









    public static void main(String[] args) {
        //testing code main code wrriten for testing purposes
        Tile[][] l1 = new Tile[5][5];
        Tile[][] l2 = new Tile[5][5];
        Tile[][] l3 = new Tile[5][5];
        Tile[][] l4 = new Tile[5][5];

        
        Player player1 = new Player("Bob", Color.red, l1);
        Player player2 = new Player("Tom", Color.green, l2);
        Player player3 = new Player("Jim", Color.blue, l3);
        Player player4 = new Player("Rob",Color.yellow,l4);

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);


        GameUI gui = new GameUI(players);
        new Controller(gui);
    }
}
