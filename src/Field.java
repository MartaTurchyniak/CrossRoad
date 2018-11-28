import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Field {
    private volatile Node[][] nodeArrayList;
    private int n_fields;
    private MainWindow mainWindow;

    public MainWindow getMainWindow(){
        return mainWindow;
    }
    public void setMainWindow(MainWindow mainWindow){
        this.mainWindow = mainWindow;
    }

    public int getN_fields(){
        return n_fields;
    }
    public Field(int n_fields,MainWindow mainWindow){
        this.mainWindow = mainWindow;
        this.n_fields = n_fields;
        nodeArrayList = new Node[n_fields*2+6][n_fields*2+6];
        for (int i = 0;i<n_fields*2+6;i++){
            for (int j = 0;j<n_fields*2+6;j++){
                boolean is_avaliable = true;
                if (i<n_fields-1 && j<n_fields-1){is_avaliable = false;}
                if (i>n_fields+6 && j>n_fields+6){is_avaliable = false;}
                if (i<n_fields-1 && j>n_fields+6){is_avaliable = false;}
                if (i>n_fields+6 && j<n_fields-1){is_avaliable = false;}
                nodeArrayList[i][j] = new Node(i,j,is_avaliable);
            }
        }
    }
    public boolean is_available_car(int x,int y){
        try {
            //System.out.println("Error, Field.java is_available_car() return false");
            return nodeArrayList[y][x].is_available_car();
        }
        catch (Exception e){System.out.println(e);}
        finally {
            return true;
        }
    }
    public boolean is_available_ped(int x,int y){
        try {
            //System.out.println("Error, Field.java is_available_car() return false");
            return nodeArrayList[y][x].is_available_ped();
        }
        catch (Exception e){System.out.println(e);}
        finally {
            return true;
        }
    }
    public void lock_avaliable(int x,int y){
        //System.out.println("Error, Field.java lock_avaliable() Node not found");
        nodeArrayList[y][x].setIs_empty(false);
    }
    public void unlock_avaliable(int x,int y){
        nodeArrayList[y][x].setIs_empty(true);
        //System.out.println("Error, Field.java unlock_avaliable() Node not found");
    }
    public void set_greenlight_car(int x,int y){
        nodeArrayList[y][x].setIs_greenlight_car(true);
        //System.out.println("Error, Field.java set_greenlight_car() Node not found");
    }
    public void set_redlight_car(int x,int y){
        nodeArrayList[y][x].setIs_greenlight_car(false);
        //System.out.println("Error, Field.java set_redlight_car() Node not found");
    }
    public void set_greenlight_ped(int x,int y){
        nodeArrayList[y][x].setIs_greenlight_ped(true);
        //System.out.println("Error, Field.java set_greenlight_ped() Node not found");
    }
    public void set_redlight_ped(int x,int y){
        nodeArrayList[y][x].setIs_greenlight_ped(false);
        //System.out.println("Error, Field.java set_redlight_ped() Node not found");
    }

}

