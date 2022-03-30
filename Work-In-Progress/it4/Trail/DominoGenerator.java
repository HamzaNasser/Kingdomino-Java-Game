import java.util.*;
import javax.swing.*;


public class DominoGenerator {
    private ArrayList<Domino> deck;
    private String [] imgList = { "Resources\\tile1.png", "Resources\\tile1a.png", "Resources\\tile1b.png", "Resources\\tile2.png", "Resources\\tile2a.png", "Resources\\tile2b.png",
    "Resources\\tile3.png", "Resources\\tile3a.png", "Resources\\tile3b.png", "Resources\\tile4.png", "Resources\\tile4a.png", "Resources\\tile4b.png", "Resources\\tile5.png",
    "Resources\\tile5a.png", "Resources\\tile5b.png", "Resources\\tile6.png", "Resources\\tile6a.png", "Resources\\tile6b.png", "Resources\\tile7.png", "Resources\\tile7a.png",
    "Resources\\tile7b.png", "Resources\\tile8.png", "Resources\\tile8a.png", "Resources\\tile8b.png"
    };
    private String [] terrainNames = { "desert", "forest", "lake", "pasture", "swamp", "mine"};
    private final int numOfDominos = 8;

    public DominoGenerator(){
        deck = new ArrayList<>();
        for (int i = 0; i < numOfDominos; i++){
            ImageIcon dominoImg = new ImageIcon(imgList[(i*3)]);
            ImageIcon firstHalfImg = new ImageIcon(imgList[(i*3)+1]);
            ImageIcon secondHalfImg = new ImageIcon(imgList[(i*3)+2]);
            Domino domino = new Domino(0,i+1,dominoImg,firstHalfImg,secondHalfImg);
            deck.add(domino);
        }
        deck.get(0).setTerrain_type_1(terrainNames[0]);
        deck.get(0).setTerrain_type_2(terrainNames[0]);
        deck.get(1).setTerrain_type_1(terrainNames[0]);
        deck.get(1).setTerrain_type_2(terrainNames[0]);

        deck.get(2).setTerrain_type_1(terrainNames[1]);
        deck.get(2).setTerrain_type_2(terrainNames[1]);
        deck.get(3).setTerrain_type_1(terrainNames[1]);
        deck.get(3).setTerrain_type_2(terrainNames[1]);
        deck.get(4).setTerrain_type_1(terrainNames[1]);
        deck.get(4).setTerrain_type_2(terrainNames[1]);
        deck.get(5).setTerrain_type_1(terrainNames[1]);
        deck.get(5).setTerrain_type_2(terrainNames[1]);

        deck.get(6).setTerrain_type_1(terrainNames[2]);
        deck.get(6).setTerrain_type_2(terrainNames[2]);
        deck.get(7).setTerrain_type_1(terrainNames[2]);
        deck.get(7).setTerrain_type_2(terrainNames[2]);
    }
    public ArrayList<Domino> getDeck() {
        return deck;
    }
}
