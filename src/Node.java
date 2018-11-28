public class Node {

    private int x;
    private int y;
    private int x_global;
    private int y_global;
    private boolean is_empty;
    private boolean is_greenlight_car;
    private boolean is_greenlight_ped;

    public Node(int x,int y,boolean is_empty){
        this.x = x;
        this.y = y;
        this.is_empty = is_empty;
        is_greenlight_car = true;
        is_greenlight_ped = true;
        x_global = x*50;
    }
    public boolean is_available_car(){
        if (is_empty && is_greenlight_car){
            return true;
        }
        return false;
    }
    public boolean is_available_ped(){
        if (is_empty && is_greenlight_ped){
            return true;
        }
        return false;
    }
    public boolean check_xy(int x_c,int y_c){
        if (x == x_c && y == y_c){
            return true;
        }
        return false;
    }
    public void setIs_empty(boolean s){
        is_empty = s;
    }

    public void setIs_greenlight_car(boolean s){
        is_greenlight_car = s;
    }
    public void setIs_greenlight_ped(boolean s){
        is_greenlight_ped = s;
    }

}
