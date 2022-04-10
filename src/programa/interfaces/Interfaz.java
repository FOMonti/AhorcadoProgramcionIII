package programa.interfaces;

import java.awt.EventQueue;

import javax.swing.UIManager;

public class Interfaz {

	private static final InterfazInicio interfazInicio = new InterfazInicio();
	private static final InterfazJuego interfazjuego = new InterfazJuego();

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					Interfaz window = new Interfaz();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interfaz() {
		initialize();
	}

	private void initialize() {
		interfazInicio.menu(interfazjuego);
		interfazjuego.iniciarJuego();
	}

}
