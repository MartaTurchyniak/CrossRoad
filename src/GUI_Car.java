import javax.swing.*;
import java.awt.*;

public class GUI_Car extends JPanel {
    private int x = 25;
    private int y = 25;

    private int global_x;
    private int global_y;

    public GUI_Car(int x,int y){
        this.global_x = x;
        this.global_y = y;
        this.x = (x*50) + 25;
        this.y = (x*50) + 25;
    }
    public void rotate(){
        System.out.println("rotate");
    }
    public void get_next(int x,int y){
        if (this.x == x){
            global_y = y;
            for (int i = 0;i<50;i++){
                this.y+= (this.y>y)?-1:1;
            }
        }
        else{
            global_x = x;
            for (int i = 0;i<50;i++){
                this.x+= (this.x>x)?-1:1;
            }
        }
    }

    @Override
    public void paintComponents(Graphics g) {
        System.out.println("start graphics car");
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle r = new Rectangle(x-25,y-25,25,25);
        g2.fill(r);
    }

    public int X() {
        return x;
    }

    public void X(int x) {
        this.x = x;
    }

    public int Y() {
        return y;
    }

    public void Y(int y) {
        this.y = y;
    }
}
