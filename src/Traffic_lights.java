public class Traffic_lights extends Thread{

    private boolean stop;
    private Field field;
    private int n_fields;

    public Traffic_lights(boolean stop,Field field){
        n_fields = field.getN_fields();
        this.stop = stop;
        this.field = field;
        set_light();
    }
    public void stop_light(){
        this.stop = false;
    }
    private void iteration_1(){
        field.set_redlight_car(n_fields+2,n_fields);
        field.set_redlight_car(n_fields+4,n_fields+5);

        field.set_redlight_ped(n_fields,n_fields+1);
        field.set_redlight_ped(n_fields,n_fields+2);
        field.set_redlight_ped(n_fields,n_fields+3);
        field.set_redlight_ped(n_fields,n_fields+4);

        try {
            Thread.sleep(5000);
        }
        catch (Exception e){
            System.out.println(e);
        }

        field.set_greenlight_car(n_fields,n_fields+3);
        field.set_greenlight_car(n_fields+5,n_fields+1);

        field.set_greenlight_ped(n_fields+1,n_fields+5);
        field.set_greenlight_ped(n_fields+2,n_fields+5);
        field.set_greenlight_ped(n_fields+3,n_fields+5);
        field.set_greenlight_ped(n_fields+4,n_fields+5);
    }
    private void iteration_2(){
        field.set_redlight_car(n_fields,n_fields+3);
        field.set_redlight_car(n_fields+5,n_fields+1);

        field.set_redlight_ped(n_fields+1,n_fields+5);
        field.set_redlight_ped(n_fields+2,n_fields+5);
        field.set_redlight_ped(n_fields+3,n_fields+5);
        field.set_redlight_ped(n_fields+4,n_fields+5);

        try {
            Thread.sleep(5000);
        }
        catch (Exception e){
            System.out.println(e);
        }


        field.set_greenlight_car(n_fields+3,n_fields+5);
        field.set_greenlight_car(n_fields+1,n_fields);

        field.set_greenlight_ped(n_fields+5,n_fields+1);
        field.set_greenlight_ped(n_fields+5,n_fields+2);
        field.set_greenlight_ped(n_fields+5,n_fields+3);
        field.set_greenlight_ped(n_fields+5,n_fields+4);

    }
    private void iteration_3(){
        field.set_redlight_car(n_fields+3,n_fields+5);
        field.set_redlight_car(n_fields+1,n_fields);

        field.set_redlight_ped(n_fields+5,n_fields+1);
        field.set_redlight_ped(n_fields+5,n_fields+2);
        field.set_redlight_ped(n_fields+5,n_fields+3);
        field.set_redlight_ped(n_fields+5,n_fields+4);

        try {
            Thread.sleep(5000);
        }
        catch (Exception e){
            System.out.println(e);
        }

        field.set_greenlight_car(n_fields+5,n_fields+2);
        field.set_greenlight_car(n_fields,n_fields+4);

        field.set_greenlight_ped(n_fields+1,n_fields);
        field.set_greenlight_ped(n_fields+2,n_fields);
        field.set_greenlight_ped(n_fields+3,n_fields);
        field.set_greenlight_ped(n_fields+4,n_fields);

    }
    private void iteration_4(){
        field.set_redlight_car(n_fields+5,n_fields+2);
        field.set_redlight_car(n_fields,n_fields+4);

        field.set_redlight_ped(n_fields+1,n_fields);
        field.set_redlight_ped(n_fields+2,n_fields);
        field.set_redlight_ped(n_fields+3,n_fields);
        field.set_redlight_ped(n_fields+4,n_fields);

        try {
            Thread.sleep(5000);
        }
        catch (Exception e){
            System.out.println(e);
        }

        field.set_greenlight_car(n_fields+2,n_fields);
        field.set_greenlight_car(n_fields+4,n_fields+5);

        field.set_greenlight_ped(n_fields,n_fields+1);
        field.set_greenlight_ped(n_fields,n_fields+2);
        field.set_greenlight_ped(n_fields,n_fields+3);
        field.set_greenlight_ped(n_fields,n_fields+4);
    }

    public void set_light(){
        field.set_redlight_car(n_fields,n_fields+3);
        field.set_redlight_car(n_fields,n_fields+4);

        field.set_redlight_car(n_fields+5,n_fields+1);
        field.set_redlight_car(n_fields+5,n_fields+2);

        field.set_redlight_car(n_fields+1,n_fields);
        field.set_redlight_car(n_fields+2,n_fields);

        field.set_redlight_car(n_fields+3,n_fields+5);
        field.set_redlight_car(n_fields+4,n_fields+5);

        field.set_redlight_ped(n_fields,n_fields+1);
        field.set_redlight_ped(n_fields,n_fields+2);
        field.set_redlight_ped(n_fields,n_fields+3);
        field.set_redlight_ped(n_fields,n_fields+4);

        field.set_redlight_ped(n_fields+5,n_fields+1);
        field.set_redlight_ped(n_fields+5,n_fields+2);
        field.set_redlight_ped(n_fields+5,n_fields+3);
        field.set_redlight_ped(n_fields+5,n_fields+4);

        field.set_redlight_ped(n_fields+1,n_fields);
        field.set_redlight_ped(n_fields+2,n_fields);
        field.set_redlight_ped(n_fields+3,n_fields);
        field.set_redlight_ped(n_fields+4,n_fields);

        field.set_redlight_ped(n_fields+1,n_fields+5);
        field.set_redlight_ped(n_fields+2,n_fields+5);
        field.set_redlight_ped(n_fields+3,n_fields+5);
        field.set_redlight_ped(n_fields+4,n_fields+5);
    }
    @Override
    public void run() {
        System.out.println("Traffic lights on");
        while (this.stop){
            System.out.println("It 1");
            iteration_1();
            try {
                Thread.sleep(10000);
            }
            catch (Exception e){
                System.out.println(e);
            }
            System.out.println("It 2");
            iteration_2();
            try {
                Thread.sleep(10000);
            }
            catch (Exception e){
                System.out.println(e);
            }
            System.out.println("It 3");
            iteration_3();
            try {
                Thread.sleep(10000);
            }
            catch (Exception e){
                System.out.println(e);
            }
            System.out.println("It 4");
            iteration_4();
            try {
                Thread.sleep(10000);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        System.out.println("Traffic lights off");
    }
}
