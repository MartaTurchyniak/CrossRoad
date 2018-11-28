import java.awt.*;

public class Thread_pedestrian extends Thread {
    private Field field;
    private boolean stop;

    public Thread_pedestrian(boolean stop,Field field){
        this.stop = stop;
        this.field = field;
    }
    public void paint(Graphics g){
        g.setFont(new Font("Serif",Font.ITALIC,30));
        g.drawString("Hellp",20,20);
    }
    public void stop_thread(){
        stop = false;
    }
    @Override
    public void run() {
        while (stop){
            Pedestrian pd = new Pedestrian(true,field);
            pd.start();
            try {
                Thread.sleep(3000);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
