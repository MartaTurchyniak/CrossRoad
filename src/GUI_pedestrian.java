public class GUI_pedestrian {
    private int x;
    private int y;

    private int global_x;
    private int global_y;

    public GUI_pedestrian(int x,int y){
        this.global_x = x;
        this.global_y = y;
        this.x = (x*50) + 25;
        this.y = (x*50) + 25;
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