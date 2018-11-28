import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class DrawPanel extends JPanel {
    int x = 312,y=312,velX = 25,velY = 25;

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        //g2d.setColor(Color.red);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src//backmap.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        g2d.drawImage(img,0,0,this);

        //g2d.setColor(Color.RED);
        //g2d.fillRect(x,y,25,25);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        //Graphics2D g2 = (Graphics2D) g;
        //Rectangle r = new Rectangle(312,312,25,25);
        //g2.fill(r);
    }

    public void actionPerformed(ActiveEvent e){
        x += velX;
        repaint();
    }


}
