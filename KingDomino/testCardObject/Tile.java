import java.awt.image.BufferedImage;
import java.io.File;
public class Tile {
    private int tileValue;
    private BufferedImage tileImage;
    public Tile(int tileValue, BufferedImage tileImage){
        this.tileValue = tileValue;
        this.tileImage = tileImage;
    }
    public int getTileValue(){
        return tileValue;
    }
}
