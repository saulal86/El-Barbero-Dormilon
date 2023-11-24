package iu;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jvnet.substance.SubstanceLookAndFeel;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Component;

public class panelBarberia_La_Corredoria extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panelNombre;
	private JPanel panelPrincipal;
	private JPanel panelBarberia;
	private JPanel panelClientes;
	private JPanel panelSillon;
	private JPanel panelSillas;
	private JPanel panelZonaBarbero;
	private JLabel LabelSillonBarbero;
	private JLabel LabelBarberoDurmiendo;
	private JLabel LabelInfo;
	private int sillas = 0;
	private int clientes = 0;

	/**
	 * Create the panel.
	 */
	public panelBarberia_La_Corredoria() {
		setLayout(new BorderLayout(0, 0));
		add(getPanel_2(), BorderLayout.NORTH);
		add(getPanel_1_1(), BorderLayout.CENTER);
		String preguntaSillas = JOptionPane.showInputDialog("Introduce el numero de sillas: ");
		sillas = Integer.parseInt(preguntaSillas);
		creaSillas(sillas);
		String preguntaClientes = JOptionPane.showInputDialog("Introduce el numero de clientes: ");
		clientes = Integer.parseInt(preguntaClientes);
		creaClientes(clientes);
		adaptarImagen(LabelBarberoDurmiendo, "img/BarberoDurmiendo.jpg");
		adaptarImagen(LabelSillonBarbero, "img/sillaBarbero.jpg");
	}

	public int getsillas() {
		return sillas;
	}
	public int getclientes() {
		return clientes;
	}

	private JPanel getPanel_2() {
		if (panelNombre == null) {
			panelNombre = new JPanel();
			panelNombre.add(getLabelInfo());
		}
		return panelNombre;
	}

	private JPanel getPanel_1_1() {
		if (panelPrincipal == null) {
			panelPrincipal = new JPanel();
			panelPrincipal.setLayout(new GridLayout(0, 2, 0, 0));
			panelPrincipal.add(getPanel_2_1());
			panelPrincipal.add(getPanelClientes());
		}
		return panelPrincipal;
	}

	private JPanel getPanel_2_1() {
		if (panelBarberia == null) {
			panelBarberia = new JPanel();
			panelBarberia.setLayout(new GridLayout(2, 0, 0, 0));
			panelBarberia.add(getPanelSillas());
			panelBarberia.add(getPanelSillon());
		}
		return panelBarberia;
	}

	private JPanel getPanelClientes() {
		if (panelClientes == null) {
			panelClientes = new JPanel();
		}
		return panelClientes;
	}

	private JPanel getPanelSillon() {
		if (panelSillon == null) {
			panelSillon = new JPanel();
			panelSillon.setLayout(new GridLayout(1, 2, 0, 0));
			panelSillon.add(getPanelZonaBarbero());
		}
		return panelSillon;
	}

	private JPanel getPanelSillas() {
		if (panelSillas == null) {
			panelSillas = new JPanel();
			panelSillas.setLayout(new GridLayout(1, 1, 0, 0));
		}
		return panelSillas;
	}

	private void creaSillas(int sillas) {
		for (int i = 0; i < sillas; i++) {
			JLabel silla = new JLabel();
			silla.setSize(50, 50);
			adaptarImagen(silla, "img/silla.jpg");
			panelSillas.add(silla);
		}
	}

	private void creaClientes(int clientes) {
		for (int i = 0; i < clientes; i++) {
			JLabel cliente = new JLabel();
			cliente.setSize(100, 100);
			adaptarImagen(cliente, "img/camporro.jpg");
			panelClientes.add(cliente);
		}
	}

	public void adaptarImagen(JLabel boton, String rutaImagen) {
		Image imgOriginal = null;
		try {
			imgOriginal = new ImageIcon(rutaImagen).getImage();
		} catch (Exception e) {
			imgOriginal = new ImageIcon(rutaImagen).getImage();
		}
		Image imgCarrito = imgOriginal.getScaledInstance((int) (boton.getWidth()), (int) (boton.getHeight()),
				Image.SCALE_FAST);

		boton.setIcon(new ImageIcon(imgCarrito));

		boton.setDisabledIcon(new ImageIcon(imgCarrito));
	}

	private JPanel getPanelZonaBarbero() {
		if (panelZonaBarbero == null) {
			panelZonaBarbero = new JPanel();
			panelZonaBarbero.setLayout(new GridLayout(0, 2, 0, 0));
			panelZonaBarbero.add(getLabelSillonBarbero());
			panelZonaBarbero.add(getLabelBarberoDurmiendo());
		}
		return panelZonaBarbero;
	}

	public JLabel getLabelSillonBarbero() {
		if (LabelSillonBarbero == null) {
			LabelSillonBarbero = new JLabel("");
			LabelSillonBarbero.setSize(50, 50);
			
		}
		return LabelSillonBarbero;
	}

	public JLabel getLabelBarberoDurmiendo() {
		if (LabelBarberoDurmiendo == null) {
			LabelBarberoDurmiendo = new JLabel("");
			LabelBarberoDurmiendo.setSize(50, 50);
			
		}
		return LabelBarberoDurmiendo;
	}

	public JLabel getLabelInfo() {
		if (LabelInfo == null) {
			LabelInfo = new JLabel("New label");
		}
		return LabelInfo;
	}

	public void ocuparSillasEspera(int nSillasEsperaOcupadas) {
		Component[] componentes = panelSillas.getComponents();
		for (int i = 0; i < componentes.length; i++) {
			JLabel silla = (JLabel) componentes[i];
			adaptarImagen(silla, "img/silla.jpg");
		}
		for (int i = 0; i < nSillasEsperaOcupadas; i++) {
			JLabel silla = (JLabel) componentes[i];
			adaptarImagen(silla, "img/SillaOcupada.jpg");
		}
	}

	public void actualizaClientes(int afeitados) {
		Component[] componentes = panelClientes.getComponents();
		for (int i = 0; i < componentes.length; i++) {
			JLabel clientes = (JLabel) componentes[i];
			adaptarImagen(clientes, "img/sinAfeitar.jpg");
		}
		for (int i = 0; i < afeitados; i++) {
			JLabel clientes = (JLabel) componentes[i];
			adaptarImagen(clientes, "img/Afeitado.jpg");
		}
	}
}
