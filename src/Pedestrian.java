import java.util.ArrayList;
import java.util.Random;

public class Pedestrian extends Thread {
    private Point startPoint;
    private Point endPoint;
    private ArrayList<Point> path;
    private int n_fields;

    private GUI_pedestrian gui_pedestrian;
    private Field field;
    private boolean stop;

    public Pedestrian(boolean stop,Field field) {
        n_fields=field.getN_fields();
        Point[] points = new Point[] {new Point(n_fields,0), new Point(0,n_fields), new Point(n_fields+5,0), new Point(n_fields*2 + 5,n_fields),
                new Point(0,n_fields+5), new Point(n_fields,n_fields*2 + 5), new Point(n_fields+5,n_fields*2 + 5), new Point(n_fields*2 + 5,n_fields+5)};
        this.startPoint = points[getRandom(points)];
        this.endPoint = points[getRandom(points)];
        while (this.endPoint == this.startPoint){
            System.out.println(startPoint+";"+endPoint);
            this.endPoint = points[getRandom(points)];
        }
        this.path = new ArrayList<Point>();
        this.setPath();
        this.field = field;
        this.stop = stop;

        this.gui_pedestrian = new GUI_pedestrian(path.get(0).X,path.get(0).Y);
    }

    public void print(){
        for (Point x:path) {
            System.out.println(x.X + "=X" + x.Y + "=Y");
        }

    }

    public void setPath() {
        path.add(new Point(startPoint));
        System.out.println("StartPoint: " + startPoint.toString());
        System.out.println("EndPoint: " + endPoint.toString());
        Point end = this.startPoint;
        boolean angle = false;
        while (this.endPoint.X != end.X || this.endPoint.Y != end.Y) {
            System.out.println(end.toString());
            if (end.X == n_fields && end.Y == n_fields+5 && !angle) {
                angle = true;
            } else if (end.X == n_fields && end.Y == n_fields && !angle){
                angle = true;
            } else if (end.X == n_fields+5 && end.Y == n_fields && !angle){
                angle = true;
            } else if (end.X == n_fields+5 && end.Y == n_fields+5 && !angle){
                angle = true;
            }
            if (!angle) {
                if (end.X < n_fields) {
                    end.X++;
                    path.add(new Point(end));
                } else if (end.X > n_fields+5) {
                    end.X--;
                    path.add(new Point(end));
                } else if (end.Y < n_fields) {
                    end.Y++;
                    path.add(new Point(end));
                } else if (end.Y > n_fields+5) {
                    end.Y--;
                    path.add(new Point(end));
                }
            } else {
                //System.out.println("Here");
                if (endPoint.Y == end.Y) {
                    if (endPoint.X > end.X) {
                        end.X++;
                        path.add(new Point(end));
                    } else {
                        end.X--;
                        path.add(new Point(end));
                    }
                } else if (endPoint.X == end.X) {
                    if (endPoint.Y > end.Y) {
                        end.Y++;
                        path.add(new Point(end));
                    } else {
                        end.Y--;
                        path.add(new Point(end));
                    }
                } else if (endPoint.X < end.X && endPoint.Y > end.Y) {
                    end.Y++;
                    path.add(new Point(end));
                } else if (endPoint.X > end.X && endPoint.Y > end.Y) {
                    end.X++;
                    path.add(new Point(end));
                } else if (endPoint.X < end.X && endPoint.Y < end.Y) {
                    end.X--;
                    path.add(new Point(end));
                } else if (endPoint.X > end.X && endPoint.Y < end.Y) {
                    end.Y--;
                    path.add(new Point(end));
                } else if (endPoint.Y == end.Y && endPoint.X > end.X) {
                    end.X--;
                    path.add(new Point(end));
                } else if (endPoint.Y == end.Y && endPoint.X < end.X) {
                    end.X++;
                    path.add(new Point(end));
                } else if (endPoint.X == end.X && endPoint.Y > end.Y) {
                    end.Y--;
                    path.add(new Point(end));
                } else if (endPoint.X == end.X && endPoint.Y < end.Y) {
                    end.Y++;
                    path.add(new Point(end));
                }
            }
        }
    }

    public int getRandom(Object[] array) {
        int rnd = new Random().nextInt(array.length);
        return rnd;
    }

    @Override
    public void run() {
        for (int i = 0;i< path.size()-1;i++) {
            while (!field.is_available_ped(path.get(i).X,path.get(i).Y)){
                try {
                    Thread.sleep(1000);
                }
                catch (Exception e){
                    System.out.println(e);
                }
                gui_pedestrian.get_next(path.get(i).X,path.get(i).Y);
            }
            gui_pedestrian.get_next(path.get(path.size()-1).X,path.get(path.size()-1).Y);
        }


    }
}
