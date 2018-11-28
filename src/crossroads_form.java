import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class crossroads_form extends JFrame{

    private JPanel panel1;
    private JLabel ImageLogo;

    public crossroads_form(){
        setTitle("crossroads");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        ImageLogo = new JLabel(new ImageIcon("src\\backmap.png"));
        System.out.println("ImageIcon");
    }
}

