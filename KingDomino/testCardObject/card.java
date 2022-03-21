import java.awt.image.BufferedImage;
import java.io.file;
public class card {
    private int cardValue;
    private BufferedImage cardImage;
    public card(int cardValue, BufferedImage cardImage){
        this.cardValue = cardValue;
        this.cardImage = cardImage;
    }
    public int getCardValue(){
        return cardValue;
    }
}
