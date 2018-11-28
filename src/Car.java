import java.util.ArrayList;
import java.util.Random;

public class Car extends Thread{
    private ArrayList<Point> path;
    private int n_fields;

    private GUI_Car gui_car;

    private Field field;
    private boolean stop;

    public Car (boolean stop,Field field) {
        System.out.println("car");
        n_fields = field.getN_fields();
        int center = n_fields;
        this.stop = stop;
        this.field = field;
        path = new ArrayList<>();
        Point[][] paths = {
                {new Point(0, center + 4), new Point(center + 1,center + 4), new Point(center + 1,2 * center + 5)},
                {new Point(0, center + 3), new Point(center + 3,center + 3), new Point(center + 3,0)},
                {new Point(0, center + 3), new Point(center + 3,center + 3), new Point(2 * center + 5,center + 3)},

                {new Point(2 * center + 5, center + 1), new Point(center + 4,center + 1), new Point(center + 4,0)},
                {new Point(2 * center + 5, center + 2), new Point(center + 2,center + 2), new Point(0,center + 2)},
                {new Point(2 * center + 5, center + 2), new Point(center + 2,center + 2), new Point(center + 2,2 *  center + 5)},

                {new Point(center + 3, 2 * center + 5), new Point(center + 3,center + 2), new Point(center + 3,0)},
                {new Point(center + 3, 2 * center + 5), new Point(center + 3,center + 2), new Point(0,center + 2)},
                {new Point(center + 4, 2* center + 5), new Point(center + 4,center + 4), new Point(2* center + 5,center + 4)},

                {new Point(center + 1, 0), new Point(center + 1,center + 1), new Point(0,center + 1)},
                {new Point(center + 2, 0), new Point(center + 2,center + 3), new Point(0,center + 3)},
                {new Point(center + 2, 0), new Point(center + 2,center + 3), new Point(center + 2,2 * center + 5)},
        };
        Random r = new Random();
        Point[] tempPath = paths[r.nextInt(12)];
        while (tempPath[0].X != tempPath[1].X || tempPath[0].Y != tempPath[1].Y) {
            path.add(new Point(tempPath[0]));
            if(tempPath[0].X != tempPath[1].X) {
                tempPath[0].X += (tempPath[0].X < tempPath[1].X)? 1: -1;
            }
            if(tempPath[0].Y != tempPath[1].Y) {
                tempPath[0].Y += (tempPath[0].Y < tempPath[1].Y)? 1: -1;
            }
        }
        while (tempPath[1].X != tempPath[2].X || tempPath[1].Y != tempPath[2].Y) {
            path.add(new Point(tempPath[1]));
            if(tempPath[1].X != tempPath[2].X) {
                tempPath[1].X += (tempPath[1].X < tempPath[2].X)? 1: -1;
            }
            if(tempPath[1].Y != tempPath[2].Y) {
                tempPath[1].Y += (tempPath[1].Y < tempPath[2].Y)? 1: -1;
            }
        }
        path.add(tempPath[2]);
        for(int i = 0; i < path.size(); ++i) {
            System.out.println(path.get(i));
        }

        gui_car = new GUI_Car(path.get(0).X,path.get(0).Y);
    }

    @Override
    public void run() {
        for (int i = 0;i< path.size()-1;i++) {
            while (!field.is_available_car(path.get(i).X,path.get(i).Y)){
                try {
                    Thread.sleep(1000);
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            field.lock_avaliable(path.get(i).X,path.get(i).Y);
            if (i!=0) {
                field.unlock_avaliable(path.get(i - 1).X, path.get(i - 1).Y);
            }
            gui_car.get_next(path.get(i).X,path.get(i).Y);

            if (i!=0 && path.get(i-1).X == path.get(i).X && path.get(i+1).X != path.get(i).X){
                gui_car.rotate();
                //??????????????????? TO DO
            }
            if (i!=0 && path.get(i-1).Y == path.get(i).Y && path.get(i+1).Y != path.get(i).Y){
                gui_car.rotate();
                //??????????????????? TO DO
            }
        }
        field.unlock_avaliable(path.get(path.size()-2).X,path.get(path.size()-2).Y);
        gui_car.get_next(path.get(path.size()-1).X,path.get(path.size()-1).Y);
    }
}
