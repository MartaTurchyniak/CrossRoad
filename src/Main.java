import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MainWindow ex = new MainWindow();
        ex.setVisible(true);

        int n_fields = 3;
        Field field = new Field(n_fields,ex);

        /*EventQueue.invokeLater(() -> {
            PointsEx ex = new PointsEx();
            ex.setVisible(true);
        });*/



        //pointsEx.main1();

        Thread_car thread_car = new Thread_car(true,field);
        Thread_pedestrian thread_pedestrian = new Thread_pedestrian(true,field);
        Traffic_lights traffic_lights = new Traffic_lights(true,field);

        boolean stop = true;

        traffic_lights.start();
        thread_car.start();
        thread_pedestrian.start();
        while (stop){
            scanner.next();
            stop = false;

            traffic_lights.stop_light();
            thread_car.stop_thread();
            thread_pedestrian.stop_thread();
        }

        System.out.println("Hello World!");
    }
}

