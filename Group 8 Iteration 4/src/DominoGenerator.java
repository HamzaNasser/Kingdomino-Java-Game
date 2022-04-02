import java.util.*;
import javax.swing.*;

// imports the dominos
public class DominoGenerator {
    private ArrayList<Domino> deck;
    private String [] imgList = { "Resources\\tile1.png", "Resources\\tile1a.png", "Resources\\tile1b.png", "Resources\\tile2.png", "Resources\\tile2a.png", "Resources\\tile2b.png",
    "Resources\\tile3.png", "Resources\\tile3a.png", "Resources\\tile3b.png", "Resources\\tile4.png", "Resources\\tile4a.png", "Resources\\tile4b.png", "Resources\\tile5.png",
    "Resources\\tile5a.png", "Resources\\tile5b.png", "Resources\\tile6.png", "Resources\\tile6a.png", "Resources\\tile6b.png", "Resources\\tile7.png", "Resources\\tile7a.png",
    "Resources\\tile7b.png", "Resources\\tile8.png", "Resources\\tile8a.png", "Resources\\tile8b.png", "Resources\\tile9.png", "Resources\\tile9a.png", "Resources\\tile9b.png", 
    "Resources\\tile10.png", "Resources\\tile10a.png", "Resources\\tile10b.png", "Resources\\tile11.png", "Resources\\tile11a.png", "Resources\\tile11b.png", "Resources\\tile12.png",
    "Resources\\tile12a.png", "Resources\\tile12b.png", "Resources\\tile13.png", "Resources\\tile13a.png", "Resources\\tile13b.png", "Resources\\tile14.png", "Resources\\tile14a.png",
    "Resources\\tile14b.png", "Resources\\tile15.png", "Resources\\tile15a.png", "Resources\\tile15b.png", "Resources\\tile16.png", "Resources\\tile16a.png", "Resources\\tile16b.png",
    "Resources\\tile17.png", "Resources\\tile17a.png", "Resources\\tile17b.png", "Resources\\tile18.png", "Resources\\tile18a.png", "Resources\\tile18b.png", "Resources\\tile19.png", 
    "Resources\\tile19a.png", "Resources\\tile19b.png", "Resources\\tile20.png", "Resources\\tile20a.png", "Resources\\tile20b.png", "Resources\\tile21.png", "Resources\\tile21a.png",
    "Resources\\tile21b.png", "Resources\\tile22.png", "Resources\\tile22a.png", "Resources\\tile22b.png", "Resources\\tile23.png", "Resources\\tile23a.png", "Resources\\tile23b.png",
    "Resources\\tile24.png", "Resources\\tile24a.png", "Resources\\tile24b.png", "Resources\\tile25.png", "Resources\\tile25a.png", "Resources\\tile25b.png", "Resources\\tile26.png", 
    "Resources\\tile26a.png", "Resources\\tile26b.png", "Resources\\tile27.png", "Resources\\tile27a.png", "Resources\\tile27b.png", "Resources\\tile28.png", "Resources\\tile28a.png",
    "Resources\\tile28b.png", "Resources\\tile29.png", "Resources\\tile29a.png", "Resources\\tile29b.png", "Resources\\tile30.png", "Resources\\tile30a.png", "Resources\\tile30b.png",
    "Resources\\tile31.png", "Resources\\tile31a.png", "Resources\\tile31b.png", "Resources\\tile32.png", "Resources\\tile32a.png", "Resources\\tile32b.png", "Resources\\tile33.png",
    "Resources\\tile33a.png", "Resources\\tile33b.png", "Resources\\tile34.png", "Resources\\tile34a.png", "Resources\\tile34b.png", "Resources\\tile35.png", "Resources\\tile35a.png",
    "Resources\\tile35b.png", "Resources\\tile36.png", "Resources\\tile36a.png", "Resources\\tile36b.png", "Resources\\tile37.png", "Resources\\tile37a.png", "Resources\\tile37b.png",
    "Resources\\tile38.png", "Resources\\tile38a.png", "Resources\\tile38b.png", "Resources\\tile39.png", "Resources\\tile39a.png", "Resources\\tile39b.png", "Resources\\tile40.png",
    "Resources\\tile40a.png", "Resources\\tile40b.png", "Resources\\tile41.png", "Resources\\tile41a.png", "Resources\\tile41b.png", "Resources\\tile42.png", "Resources\\tile42a.png",
    "Resources\\tile42b.png", "Resources\\tile43.png", "Resources\\tile43a.png", "Resources\\tile43b.png", "Resources\\tile44.png", "Resources\\tile44a.png", "Resources\\tile44b.png",
    "Resources\\tile45.png", "Resources\\tile45a.png", "Resources\\tile45b.png", "Resources\\tile46.png", "Resources\\tile46a.png", "Resources\\tile46b.png", "Resources\\tile47.png",
    "Resources\\tile47a.png", "Resources\\tile47b.png", "Resources\\tile48.png", "Resources\\tile48a.png", "Resources\\tile48b.png"   
    };
    private String [] terrainNames = { "desert", "forest", "lake", "pasture", "swamp", "mine"};
    private final int numOfDominos = 48;

    public DominoGenerator(){
        deck = new ArrayList<>();
        for (int i = 0; i < numOfDominos; i++){
            //ImageIcon dominoImg = new ImageIcon(imgList[(i*3)]);
            ImageIcon dominoImg = new  ImageIcon(getClass().getResource(imgList[i*3]));
            //ImageIcon firstHalfImg = new ImageIcon(imgList[(i*3)+1]);
            ImageIcon firstHalfImg = new  ImageIcon(getClass().getResource((imgList[i*3+1])));
            //ImageIcon secondHalfImg = new ImageIcon(imgList[(i*3)+2]);
            ImageIcon secondHalfImg = new ImageIcon(getClass().getResource((imgList[i*3+2])));
            Domino domino = new Domino(i+1,0,dominoImg,firstHalfImg,secondHalfImg);
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
        
        deck.get(8).setTerrain_type_1(terrainNames[2]);
        deck.get(8).setTerrain_type_2(terrainNames[2]);

        deck.get(9).setTerrain_type_1(terrainNames[3]);
        deck.get(9).setTerrain_type_2(terrainNames[3]);
        deck.get(10).setTerrain_type_1(terrainNames[3]);
        deck.get(10).setTerrain_type_2(terrainNames[3]);

        deck.get(11).setTerrain_type_1(terrainNames[4]);
        deck.get(11).setTerrain_type_2(terrainNames[4]);

        deck.get(12).setTerrain_type_1(terrainNames[0]);
        deck.get(12).setTerrain_type_2(terrainNames[1]);

        deck.get(13).setTerrain_type_1(terrainNames[0]);
        deck.get(13).setTerrain_type_2(terrainNames[2]);

        deck.get(14).setTerrain_type_1(terrainNames[0]);
        deck.get(14).setTerrain_type_2(terrainNames[3]);

        deck.get(15).setTerrain_type_1(terrainNames[0]);
        deck.get(15).setTerrain_type_2(terrainNames[4]);

        deck.get(16).setTerrain_type_1(terrainNames[1]);
        deck.get(16).setTerrain_type_2(terrainNames[2]);

        deck.get(17).setTerrain_type_1(terrainNames[1]);
        deck.get(17).setTerrain_type_2(terrainNames[3]);

        deck.get(18).setTerrain_type_1(terrainNames[0]);
        deck.get(18).setTerrain_type_2(terrainNames[1]);
        deck.get(18).setCrownOnFirstHalf(1);
        deck.get(18).setCrown(1);
        
        deck.get(19).setTerrain_type_1(terrainNames[0]);
        deck.get(19).setTerrain_type_2(terrainNames[2]);
        deck.get(19).setCrownOnFirstHalf(1);
        deck.get(19).setCrown(1);

        deck.get(20).setTerrain_type_1(terrainNames[0]);
        deck.get(20).setTerrain_type_2(terrainNames[3]);
        deck.get(20).setCrownOnFirstHalf(1);
        deck.get(20).setCrown(1);

        deck.get(21).setTerrain_type_1(terrainNames[0]);
        deck.get(21).setTerrain_type_2(terrainNames[4]);
        deck.get(21).setCrownOnFirstHalf(1);
        deck.get(21).setCrown(1);

        deck.get(22).setTerrain_type_1(terrainNames[0]);
        deck.get(22).setTerrain_type_2(terrainNames[5]);
        deck.get(22).setCrownOnFirstHalf(1);
        deck.get(22).setCrown(1);

        deck.get(23).setTerrain_type_1(terrainNames[1]);
        deck.get(23).setTerrain_type_2(terrainNames[0]);
        deck.get(23).setCrownOnFirstHalf(1);
        deck.get(23).setCrown(1);
        
        deck.get(24).setTerrain_type_1(terrainNames[1]);
        deck.get(24).setTerrain_type_2(terrainNames[0]);
        deck.get(24).setCrownOnFirstHalf(1);
        deck.get(24).setCrown(1);

        deck.get(25).setTerrain_type_1(terrainNames[1]);
        deck.get(25).setTerrain_type_2(terrainNames[0]);
        deck.get(25).setCrownOnFirstHalf(1);
        deck.get(25).setCrown(1);

        deck.get(26).setTerrain_type_1(terrainNames[1]);
        deck.get(26).setTerrain_type_2(terrainNames[0]);
        deck.get(26).setCrownOnFirstHalf(1);
        deck.get(26).setCrown(1);

        deck.get(27).setTerrain_type_1(terrainNames[1]);
        deck.get(27).setTerrain_type_2(terrainNames[2]);
        deck.get(27).setCrownOnFirstHalf(1);
        deck.get(27).setCrown(1);

        deck.get(28).setTerrain_type_1(terrainNames[1]);
        deck.get(28).setTerrain_type_2(terrainNames[3]);
        deck.get(28).setCrownOnFirstHalf(1);
        deck.get(28).setCrown(1);

        deck.get(29).setTerrain_type_1(terrainNames[2]);
        deck.get(29).setTerrain_type_2(terrainNames[0]);
        deck.get(29).setCrownOnFirstHalf(1);
        deck.get(29).setCrown(1);

        deck.get(30).setTerrain_type_1(terrainNames[2]);
        deck.get(30).setTerrain_type_2(terrainNames[0]);
        deck.get(30).setCrownOnFirstHalf(1);
        deck.get(30).setCrown(1);

        deck.get(31).setTerrain_type_1(terrainNames[2]);
        deck.get(31).setTerrain_type_2(terrainNames[1]);
        deck.get(31).setCrownOnFirstHalf(1);
        deck.get(31).setCrown(1);
        //
        deck.get(32).setTerrain_type_1(terrainNames[2]);
        deck.get(32).setTerrain_type_2(terrainNames[1]);
        deck.get(32).setCrownOnFirstHalf(1);
        deck.get(32).setCrown(1);

        deck.get(33).setTerrain_type_1(terrainNames[2]);
        deck.get(33).setTerrain_type_2(terrainNames[1]);
        deck.get(33).setCrownOnFirstHalf(1);
        deck.get(33).setCrown(1);

        deck.get(34).setTerrain_type_1(terrainNames[2]);
        deck.get(34).setTerrain_type_2(terrainNames[1]);
        deck.get(34).setCrownOnFirstHalf(1);
        deck.get(34).setCrown(1);

        deck.get(35).setTerrain_type_1(terrainNames[0]);
        deck.get(35).setTerrain_type_2(terrainNames[3]);
        deck.get(35).setCrownOnFirstHalf(0);
        deck.get(35).setCrown(1);

        deck.get(36).setTerrain_type_1(terrainNames[2]);
        deck.get(36).setTerrain_type_2(terrainNames[3]);
        deck.get(36).setCrownOnFirstHalf(0);
        deck.get(36).setCrown(1);

        deck.get(37).setTerrain_type_1(terrainNames[0]);
        deck.get(37).setTerrain_type_2(terrainNames[4]);
        deck.get(37).setCrownOnFirstHalf(0);
        deck.get(37).setCrown(1);

        deck.get(38).setTerrain_type_1(terrainNames[3]);
        deck.get(38).setTerrain_type_2(terrainNames[4]);
        deck.get(38).setCrownOnFirstHalf(0);
        deck.get(38).setCrown(1);

        deck.get(39).setTerrain_type_1(terrainNames[5]);
        deck.get(39).setTerrain_type_2(terrainNames[0]);
        deck.get(39).setCrownOnFirstHalf(1);
        deck.get(39).setCrown(1);

        deck.get(40).setTerrain_type_1(terrainNames[0]);
        deck.get(40).setTerrain_type_2(terrainNames[3]);
        deck.get(40).setCrownOnFirstHalf(0);
        deck.get(40).setCrown(2);
        
        deck.get(41).setTerrain_type_1(terrainNames[2]);
        deck.get(41).setTerrain_type_2(terrainNames[3]);
        deck.get(41).setCrownOnFirstHalf(0);
        deck.get(41).setCrown(2);

        deck.get(42).setTerrain_type_1(terrainNames[0]);
        deck.get(42).setTerrain_type_2(terrainNames[4]);
        deck.get(42).setCrownOnFirstHalf(0);
        deck.get(42).setCrown(2);

        deck.get(43).setTerrain_type_1(terrainNames[3]);
        deck.get(43).setTerrain_type_2(terrainNames[4]);
        deck.get(43).setCrownOnFirstHalf(0);
        deck.get(43).setCrown(2);

        deck.get(44).setTerrain_type_1(terrainNames[5]);
        deck.get(44).setTerrain_type_2(terrainNames[0]);
        deck.get(44).setCrownOnFirstHalf(1);
        deck.get(44).setCrown(2);

        deck.get(45).setTerrain_type_1(terrainNames[4]);
        deck.get(45).setTerrain_type_2(terrainNames[5]);
        deck.get(45).setCrownOnFirstHalf(0);
        deck.get(45).setCrown(2);

        deck.get(46).setTerrain_type_1(terrainNames[4]);
        deck.get(46).setTerrain_type_2(terrainNames[5]);
        deck.get(46).setCrownOnFirstHalf(0);
        deck.get(46).setCrown(2);

        deck.get(47).setTerrain_type_1(terrainNames[0]);
        deck.get(47).setTerrain_type_2(terrainNames[5]);
        deck.get(47).setCrownOnFirstHalf(0);
        deck.get(47).setCrown(3);
        
        //deck.get(0).setCrownOnFirstHalf(1);
        //deck.get(0).setCrown(5);
        //deck.get(1).setCrownOnFirstHalf(0);
        //deck.get(1).setCrown(3);
        


    }
    public ArrayList<Domino> getDeck() {
        //shuffle the deck 
        Collections.shuffle(deck);
        return deck;
    }
    public void removeHalfOfDeck(ArrayList<Domino> deck){ //for a 2 player game
        for (int i=0; i<23; i++){
            deck.remove(0);
        }
    }
}