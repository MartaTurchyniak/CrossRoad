import java.util.ArrayList;
import java.util.Random;

public class Point {
    public int X;
    public int Y;

    public Point(int x,int y){
        this.X = x;
        this.Y = y;
    }
    public Point (Point p) {
        this.X= p.X;
        this.Y = p.Y;
    }

    @Override
    public String toString() {
        return X + " " + Y;
    }

}



