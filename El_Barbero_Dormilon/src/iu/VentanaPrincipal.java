package iu;

import java.awt.EventQueue;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClasesBarberia.Barberia;
import ClasesBarberia.Barbero;
import ClasesBarberia.Cliente;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private panelBarberia_La_Corredoria panelB;
	private panelBarberia_La_Corredoria PanelB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panelB = new panelBarberia_La_Corredoria();
		//panelB.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelB);
		Barberia laBarberia = new Barberia(5, panelB);
		Barbero elBarbero = new Barbero(laBarberia);
		elBarbero.start();
		for(int i = 0; i<10; i++) {
			Cliente c = new Cliente(i + 1, laBarberia);
			c.start();
		}
	}

}
