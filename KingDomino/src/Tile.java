import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
public class Tile {
    private int tileValue, crownValue;
    private String imageFile;
    private ImageIcon tileImage;
    public Tile(int tileValue, ImageIcon tileImage, int crownValue){
        this.tileValue = tileValue;
        this.tileImage = tileImage;
        this.crownValue = crownValue;
    }
    public Tile(int tileValue, String imageFile, int crownValue){
        this.tileValue = tileValue;
        this.imageFile = imageFile;
        this.crownValue = crownValue;
    }
    public int getTileValue(){
        return tileValue;
    }
/*    public static List<String> getTileNames(){

    }
*/
}