import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Tile extends JButton{
    private int x_coord;
    private int y_coord;
    private int crowns;
    private String terrain;
    private Domino domino;
    private Boolean inMiddleGrid, occupied;
    
    //Custom JPanel that also stores x and y coordinate
    public Tile(int x, int y, String terrain, Boolean inMiddleGrid){
        super();
        //setSize(125,125);
        x_coord = x;
        y_coord = y;
        this.terrain = terrain;
        crowns = 0;
        this.inMiddleGrid = inMiddleGrid;
        occupied = false;
    }

    // returns an ArrayList of the coordinates
    public ArrayList<Integer> getCoord(){
        ArrayList<Integer> coordinate = new ArrayList<>();
        coordinate.add(x_coord);
        coordinate.add(y_coord);
        return coordinate;
    }
    //this function is used to place dominos into the game board
    public void placeDomino(Domino domino, int flag){
        Dimension d = this.getSize();
        if (flag == 0){
            ImageIcon img = domino.getDominoImg();
            img.setImage(img.getImage().getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH));
            JLabel pic = new JLabel(img);
            this.add(pic);
        }
        else if (flag == 1){
            ImageIcon img = domino.getFirstHalfImg();
            img.setImage(img.getImage().getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH));
            JLabel pic = new JLabel(img);
            this.add(pic);
        }
        else if (flag == 2){
            ImageIcon img = domino.getSecondHalfImg();
            img.setImage(img.getImage().getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH));
            JLabel pic = new JLabel(img);
            this.add(pic);
        }
    }
    public void placeCastle(){
        Dimension d = this.getSize();
        ImageIcon img = new ImageIcon("Resources\\castle.png");
        img.setImage(img.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH));
        JLabel pic = new JLabel(img);
        this.add(pic);
    }

    // setters and getters........
    public void setXcoord(int value){ 
        x_coord = value; }

    public void setYcoord(int value){ 
        y_coord = value; 
    }
    public int getXcoord(){ 
        return x_coord; 
    }
    public int getYcoord(){ 
        return y_coord; 
    }
    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
    public String getTerrain() {
        return terrain;
    }
    public int getCrowns() {
        return crowns;
    }
    public void setCrowns(int crowns) {
        this.crowns = crowns;
    }
    public Domino getDomino() {
        return domino;
    }
    public void setDomino(Domino domino) {
        this.domino = domino;
    }
    public Boolean getInMiddleGrid() {
        return inMiddleGrid;
    }
    public void setInMiddleGrid(Boolean inMiddleGrid) {
        this.inMiddleGrid = inMiddleGrid;
    }
    public Boolean getOccupied() {
        return occupied;
    }
    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

}