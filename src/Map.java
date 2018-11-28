import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    Graphics[][] map;
    int amount;
    int size;

    public Map(int n){
        setSize(600,600);
        setVisible(true);


        this.amount=n*2+6;
        map = new Graphics[amount][amount];
        this.size = (int) Math.floor(600/amount);

        for(int i=0;i<amount;i++) {
            for(int j = 0;j<amount;j++){
                paintComponent(map[i][j],i*size,j*size,size);
            }
        }
    }

    public void paintComponent(Graphics g, int x, int y, int size) {
        super.paintComponent(g);
        // draw the rectangle here
        g.drawRect(x, y, size,size);
        g.setColor(Color.GREEN);
    }
}
