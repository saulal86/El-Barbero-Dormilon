package ClasesBarberia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import iu.panelBarberia_La_Corredoria;

public class Barberia {
	private int nSillasEspera = 0;
	private int nSillasEsperaOcupadas = 0;
	private boolean sillaBarberoOcupada = false;
	private boolean finAfeitado = false;
	private boolean barberoDormido = false;
	private panelBarberia_La_Corredoria PanelB;
	private int afeitados = 0;

	public Barberia(int nSillasEspera, panelBarberia_La_Corredoria PanelB) {
		this.nSillasEspera = nSillasEspera;
		this.PanelB = PanelB;
	}

	public synchronized boolean llegaCliente(int clienteId) throws InterruptedException {
		if (nSillasEsperaOcupadas == nSillasEspera) {
			// se va sin afeitarse ya que no hay sillas libres
			//System.out.println("El cliente " + clienteId + " se va sin afeitarse.");
			JOptionPane.showMessageDialog(null, "El cliente " + clienteId + " se va sin afeitarse.");
			PanelB.getLabelInfo().setText("El cliente " + clienteId + " se va sin afeitarse.");
			return false;
		} else {
			// El cliente espera en las sillas de espera si la silla del barbero esta
			// ocupada.
			nSillasEsperaOcupadas++;
			PanelB.ocuparSillasEspera(nSillasEsperaOcupadas);
			System.out.println("El cliente " + clienteId + " se sienta en la silla.");
			while (sillaBarberoOcupada) {
				wait();
			}

			if (barberoDormido) {
				//System.out.println("El cliente " + clienteId + " despierta al barbero.");
				PanelB.adaptarImagen(PanelB.getLabelBarberoDurmiendo(), "img/barberoAfeitando.jpg");
				notifyAll();
			}
			// proceso de afeitar al cliente.
			nSillasEsperaOcupadas--;
			PanelB.ocuparSillasEspera(nSillasEsperaOcupadas);
			PanelB.adaptarImagen(PanelB.getLabelSillonBarbero(), "img/sillaBarbero.jpg");
			// me siento en la silla del barbero
			sillaBarberoOcupada = true;
			finAfeitado = false;
			// espero a que me afeite
			System.out.println("El cliente " + clienteId + " en la silla del barbero.");
			while (!finAfeitado) {
				wait();
				// Thread.sleep(1000);
			}
			afeitados++;
			sillaBarberoOcupada = false;
			notifyAll();// activa los hilos que estan en "wait"
			PanelB.actualizaClientes(afeitados);
			System.out.println("El cliente " + clienteId + " se va afeitado");
			return true;
		}
	}

	public synchronized void esperaCliente() throws InterruptedException {
		// el barbero espera a que llegue un cliente
		barberoDormido = true;
		while (!sillaBarberoOcupada) {// mientras no se haya sentado un cliente
			System.out.println("Barbero esperando a cliente");
			wait();
		}
		barberoDormido = false;
		System.out.println("Barbero afeitando a un cliente");
	}

	public synchronized void acabarAfeitado() {
		finAfeitado = true;
		System.out.println("Barbero termina de afeitar a un cliente");
		notifyAll();
	}
}
