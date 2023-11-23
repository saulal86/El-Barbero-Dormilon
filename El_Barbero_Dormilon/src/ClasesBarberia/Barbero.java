package ClasesBarberia;

public class Barbero extends Thread{
    private Barberia barberia = null;
    public Barbero(Barberia barberia){
        this.barberia=barberia;
    }

    @Override
    public void run() {
        while(true){
            try{
                barberia.esperaCliente();//recibe un cliente
                Thread.sleep(5000);
                barberia.acabarAfeitado();
                Thread.sleep(10000);
            }catch (InterruptedException e){//cojones33
            }
        }
    }
}
