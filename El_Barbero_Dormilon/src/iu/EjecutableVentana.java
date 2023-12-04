package iu;

import java.awt.EventQueue;
import java.util.Iterator;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;

import ClasesBarberia.Barberia;
import ClasesBarberia.Barbero;
import ClasesBarberia.Cliente;

public class EjecutableVentana extends JFrame {

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
					EjecutableVentana frame = new EjecutableVentana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EjecutableVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 644);
		panelB = new panelBarberia_La_Corredoria();
		// panelB.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelB);
		Barberia laBarberia = new Barberia(panelB.getsillas(), panelB);
		Barbero elBarbero = new Barbero(laBarberia);
		elBarbero.start();
		for (int i = 0; i < panelB.getclientes(); i++) {
			Cliente c = new Cliente(i + 1, laBarberia);
			c.start();
		}
	}

}
