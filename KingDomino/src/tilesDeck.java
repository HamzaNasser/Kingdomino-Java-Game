import java.util.ArrayList;
public class tilesDeck {
    private ArrayList<Tile> deck;
    Tile farm, forest, grassLand, mine, sea, swamp,
    forestFarm, farmSea, farmGrass, farmSwamp, forestSea,
    forestGrassland, farmForest, millSea, millGrassland,
    millSwamp,millMine;
    public tilesDeck(){

    }
    public void createDeck(){
        //Creating farmland
        for(int i = 1; i < 3; i++){
            farm = new Tile(i, "1.png", 0); 
            deck.add(farm);          
        }
        //Creating forest
        for(int i = 3; i < 7;i++){
            forest = new Tile(i,"3.png",0);
            deck.add(forest);
        }
        //Creating Sea
        for(int i = 7; i < 10; i++){
            sea = new Tile(i, "7.png", 0);
            deck.add(sea);
        }
        //Creating swamp
        swamp = new Tile(12, "12.png", 0);
        forestFarm = new Tile(13, "13.png",0);
        deck.add(forestFarm);
        farmSea = new Tile(14, "14.png", 0);
        deck.add(farmSea);
        farmGrass = new Tile(15, "15.png",0);
        deck.add(farmGrass);
        farmSwamp = new Tile(16, "16.png",0);
        deck.add(farmSwamp);
        forestSea = new Tile(17, "17.png",0);
        deck.add(forestSea);
        forestGrassland = new Tile(18, "18.png",0);
        deck.add(forestGrassland);
        farmForest = new Tile(19, "19.png",0);
        deck.add(farmForest);
        millSea = new Tile(20,"20.png",0);
        deck.add(millSea);
        millGrassland = new Tile(21, "21.png",0);
        deck.add(millGrassland);

    }

}
