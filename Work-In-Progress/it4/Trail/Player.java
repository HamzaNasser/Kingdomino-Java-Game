import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;



public class Player {
    private String name;
    private Color color;
    private Tile[][] playerGrid;

    public Player(String name, Color color, Tile[][] playerGrid){
        this.name = name;
        this.color = color;
        this.playerGrid = playerGrid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Tile[][] getPlayerGrid() {
        return this.playerGrid;
    }

    public void setPlayerGrid(Tile[][] playerGrid) {
        this.playerGrid = playerGrid;
    }
    //enable = true --- disable = flase
    public void setPlayerGrid(Boolean bool){
        for (int x=0; x<5; x++){
            for(int y=0; y<5; y++){
                if (playerGrid[x][y].getOccupied() == true){
                    playerGrid[x][y].setEnabled(false);
                }
                else { playerGrid[x][y].setEnabled(bool);}
            }
        }
    }
    public void enableNeighbour(int[] coordinate){
        ArrayList<int[]> neighbouList = AddNeighbours(coordinate);
        for (int x=0; x<5; x++){
            for (int y=0; y<5; y++){
                int[] arr = {x,y};
                boolean contains = compareArray(neighbouList, arr);
                if (playerGrid[x][y].getOccupied() == false && contains){
                    playerGrid[x][y].setEnabled(true);
                }
                else{ playerGrid[x][y].setEnabled(false);}
            }
        }
    }
    //used for comparing a coordinate and elements in a neighbour list
    private boolean compareArray(ArrayList<int[]> list, int[] value){
        for (int[] element: list){
            if (Arrays.equals(value, element)) {return true;}
        }
        return false;
    }

    

    private ArrayList<int[]> AddNeighbours(int[] selectedTile){
        ArrayList<int[]> neighbourList = new ArrayList<>();
        int x = selectedTile[0];
        int y = selectedTile[1];
        AddCoordinate(neighbourList, x+1, y); // bottom square
        AddCoordinate(neighbourList, x-1, y); // top square
        AddCoordinate(neighbourList, x, y+1); // right square
        AddCoordinate(neighbourList, x, y-1); // left square
        return neighbourList;
    }

    private void AddCoordinate(ArrayList<int[]> neighbourList, int x, int y){
        //making sure the neighbouring squares are on the 5x5 grid
        if ((x >= 0 & x <= 4) & (y >= 0 & x <= 4 )){  
            //making an an ArrayList object that holds the coordinates of the square
            int[] cooordinate = new int[2];
            cooordinate[0] = x;
            cooordinate[1] = y;
            //adding the neighbouring square to the respective neighbouring ArrayList
            neighbourList.add(cooordinate);
        }
    }
    public void setTileColorWhite(){
        for(int x=0; x<5; x++){
            for (int y=0; y<5; y++){
                playerGrid[x][y].setBackground(Color.white);
            }
        }
    }

}
