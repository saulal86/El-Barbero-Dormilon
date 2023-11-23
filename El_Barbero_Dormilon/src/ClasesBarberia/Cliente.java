package ClasesBarberia;

public class Cliente extends Thread{
    private int idCliente;
    private Barberia barberia = null;
    private boolean afeitado = false;

    public Cliente(int numeroCliente, Barberia barberia) {
        this.idCliente = numeroCliente;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while(true) {
            try{
                Thread.sleep(3000);
                afeitado = barberia.llegaCliente(idCliente);
                //afeitarse
                if (afeitado){
                    System.out.println("El cliente " + idCliente + " se va sin afeitarse.");
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}