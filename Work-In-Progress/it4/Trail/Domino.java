import javax.swing.*;

public class Domino {
    private String terrain_type_1, terrain_type_2;
    private ImageIcon dominoImg, firstHalfImg, secondHalfImg;
    private int domino_value,crown;
    private Boolean crownOnFirstHalf;
    //these are used when the game is saved/loaded, they'll be used to locate the dominos
    private Boolean inMiddlePanel, inPlayerGrid, discarded;
    private int[] middlePanelCoord; //might be an arrayccoordinate 
    private String playerName; //for now string might change it too Player
    private int[] playerGridCoord1, playerGridCoord2;

    public Domino(int dominoValue, int Crown, ImageIcon domino_img, ImageIcon first_half_img, ImageIcon second_half_img){
        crown = Crown;
        domino_value = dominoValue;
        dominoImg = domino_img;
        firstHalfImg = first_half_img;
        secondHalfImg = second_half_img;
        terrain_type_1 = "";
        terrain_type_2 = "";
        inMiddlePanel = false; 
        inPlayerGrid = false; 
        discarded = false;
        crownOnFirstHalf = null;
    }

    //getters and setters....
    public String getTerrain_type_1() {
        return this.terrain_type_1;
    }

    public void setTerrain_type_1(String terrain_type_1) {
        this.terrain_type_1 = terrain_type_1;
    }

    public String getTerrain_type_2() {
        return this.terrain_type_2;
    }

    public void setTerrain_type_2(String terrain_type_2) {
        this.terrain_type_2 = terrain_type_2;
    }

    public ImageIcon getDominoImg() {
        return this.dominoImg;
    }

    public void setDominoImg(ImageIcon dominoImg) {
        this.dominoImg = dominoImg;
    }

    public ImageIcon getFirstHalfImg() {
        return this.firstHalfImg;
    }

    public void setFirstHalfImg(ImageIcon firstHalfImg) {
        this.firstHalfImg = firstHalfImg;
    }

    public ImageIcon getSecondHalfImg() {
        return this.secondHalfImg;
    }

    public void setSecondHalfImg(ImageIcon secondHalfImg) {
        this.secondHalfImg = secondHalfImg;
    }

    public int getDomino_value() {
        return this.domino_value;
    }

    public void setDomino_value(int domino_value) {
        this.domino_value = domino_value;
    }

    public Boolean isInMiddlePanel() {
        return this.inMiddlePanel;
    }

    public Boolean getInMiddlePanel() {
        return this.inMiddlePanel;
    }

    public void setInMiddlePanel(Boolean inMiddlePanel) {
        this.inMiddlePanel = inMiddlePanel;
    }

    public Boolean isInPlayerGrid() {
        return this.inPlayerGrid;
    }

    public Boolean getInPlayerGrid() {
        return this.inPlayerGrid;
    }

    public void setInPlayerGrid(Boolean inPlayerGrid) {
        this.inPlayerGrid = inPlayerGrid;
    }

    public Boolean isDiscarded() {
        return this.discarded;
    }

    public Boolean getDiscarded() {
        return this.discarded;
    }

    public void setDiscarded(Boolean discarded) {
        this.discarded = discarded;
    }

    public int[] getMiddlePanelCoord() {
        return this.middlePanelCoord;
    }

    public void setMiddlePanelCoord(int[] middlePanelcoord) {
        this.middlePanelCoord = middlePanelcoord;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int[] getPlayerGridCoord1() {
        return this.playerGridCoord1;
    }

    public void setPlayerGridCoord1(int[] playerGridCoord1) {
        this.playerGridCoord1 = playerGridCoord1;
    }

    public int[] getPlayerGridCoord2() {
        return this.playerGridCoord2;
    }

    public void setPlayerGridCoord2(int[] playerGridCoord2) {
        this.playerGridCoord2 = playerGridCoord2;
    }

    public void setCrown(int crown) {
        this.crown = crown;
    }

    public int getCrown() {
        return crown;
    }

    public void setCrownOnFirstHalf(Boolean crownOnFirstHalf) {
        this.crownOnFirstHalf = crownOnFirstHalf;
    }
    public Boolean getCrownOnFirstHalf() {
        return crownOnFirstHalf;
    }




}
