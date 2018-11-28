public class Thread_car extends Thread {
    private Field field;
    private boolean stop;

    public Thread_car(boolean stop,Field field){
        this.stop = stop;
        this.field = field;
    }
    public void stop_thread(){
        stop = false;
    }

    @Override
    public void run() {
        while (stop){
            Car temp = new Car(true,field);
            temp.start();
            try {
                Thread.sleep(5000);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
