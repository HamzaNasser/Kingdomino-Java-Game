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
    private JLabel turnLabel;
    private Tile firstTile;

    public Controller(GameUI view){
        gameUI = view;
        playerList = gameUI.getPlayerList();
        middleGrid = gameUI.getMiddleGrid();
        buttonsList = gameUI.getButtons();

        deck = new DominoGenerator().getDeck();

        frame = gameUI.getFrame();
        turnLabel = gameUI.getTurnLabel();

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
                if (flag ==0){  //first tile clicked
                    firstTile = tile;
                    tile.setBackground(Color.lightGray);
                    currentPlayer.enableNeighbour(tile.getCoord());
                    flag++;
                }
                else if (flag == 1){ //second tile clicked
                    if (tile != firstTile){ //prevent the user for clicking the same tile twice.
                        tile.setBackground(Color.lightGray);
                        //check if valid blah blah blah
                        removeMiddleTile();
                        //setting the fields
                        firstTile.setTerrain(currentDomino.getTerrain_type_1());
                        tile.setTerrain(currentDomino.getTerrain_type_2());
                        firstTile.setOccupied(true);
                        firstTile.setInMiddleGrid(false);
                        tile.setOccupied(true);
                        tile.setInMiddleGrid(false);
                        //need to set crown but later...
                        //placing dominos
                        firstTile.placeDomino(currentDomino,1);
                        tile.placeDomino(currentDomino, 2);
                        //post turn actions
                        currentPlayer.setPlayerGrid(false);
                        getPlayerTurn();
                        setMiddleGrid(true);
                        flag = 0;
                    }
                }

            }
        }


        if (selected.equals(buttonsList.get(1))){ //unpack the button
            //disable player grid
            removeMiddleTile();
            setMiddleGrid(true);
            getPlayerTurn(); //if returns false ----start up next round--- enable draw dominos
        }
        if (selected.equals(buttonsList.get(0))){
            withdrawDominos();
            JFrame frame = gameUI.getFrame();
            frame.revalidate(); //without this the dominos aren't visble unless if the window is resized!
            
            
        }
    }
    private void disableGrid(Tile[][] playergrid){
        for(int x=0; x<5;x++){
            for (int y=0; y<5; y++){
                playergrid[x][y].setEnabled(false);
            }
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

    private void withdrawDominos(){
        Domino[] dominoList = new Domino[4];
        for (int i = 0; i<4; i++){
            deck.get(0).setInMiddlePanel(true);
            dominoList[i] = deck.get(0);
            deck.remove(0);
        }
        //first round //if top row is blank
        if (middleGrid[0][0].getBorder() == BorderFactory.createEmptyBorder()){
            for (int x =0; x <4; x++){
                Tile tile = middleGrid[0][x];
                Domino domino = dominoList[x];
                tile.placeDomino(domino, 0);
                tile.setDomino(domino);
            }
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

    }
    private void printArray(Tile[] array){
        for (int x =0; x< array.length; x++){
            System.out.print(array[x].getDomino().getTerrain_type_1() + " "+ array[x].getDomino().getTerrain_type_2() +"\n");
        }
    }
    









    public static void main(String[] args) {
        GameUI gui = new GameUI();
        new Controller(gui);
    }
}
