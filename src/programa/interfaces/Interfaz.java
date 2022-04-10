package programa.interfaces;

import java.awt.EventQueue;

import javax.swing.UIManager;

import programa.entidades.Juego;
import programa.servicio.JuegoService;

public class Interfaz {

	private Juego juego;
	private static final JuegoService juegoService = new JuegoService();
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
		this.juego = juegoService.crearJuego();
		interfazInicio.menu(juego, interfazjuego);
		interfazjuego.iniciarJuego();
	}

}
