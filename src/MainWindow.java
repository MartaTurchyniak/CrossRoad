import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public DrawPanel drawPanel;
    public MainWindow() {

        initUI();
    }

    private void initUI() {

        drawPanel = new DrawPanel();
        add(drawPanel);

        setSize(600, 640);
        setTitle("Points");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}
