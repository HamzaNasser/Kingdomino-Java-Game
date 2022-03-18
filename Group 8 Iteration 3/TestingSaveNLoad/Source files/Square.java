import java.io.Serializable;
import javax.swing.*;
import java.awt.*;

public class Square extends JButton implements Serializable  {
    Color color;
    int x,y;
    private static final long serialVersionUID= 1L;

    public Square(Color color, int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;
    }

}
