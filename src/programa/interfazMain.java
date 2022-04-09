package programa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import programa.entidades.Juego;
import programa.servicio.JuegoService;

public class interfazMain {

	private JFrame frmJuegoDelAhorcado;
	private JTextField userInput;
	private JLabel lblTituloDelJuego;
	private JLabel palabraEnJuego;
	private JButton btnReset;
	private JLabel lblIntentos;
	private JLabel lblPuntaje;
	private JLabel labelUserInput;
	private JPanel palabraContainer;

	private Juego juego;
	private JuegoService juegoService = new JuegoService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazMain window = new interfazMain();
					window.frmJuegoDelAhorcado.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		juego = juegoService.crearJuego();

		inicializarFrameJuego();

		inicializarLabelUserInput();

		inicializarTextFieldInput();

		inicializarPalabraContainer();

		inicializarLabelPalabraEnJuego();

		inicializarLabelIntentos();
		
		inicializarLabelPuntaje();

		inicializarBTNReiniciar();

		inicializarLabelTitulo();

		// Event listeners

		// ENTER DEL USUARIO
		userInput.addActionListener(new ActionListener() {
			// Cuando el usuario presiona ENTER al ingresar una palabra o letra
			@Override
			public void actionPerformed(ActionEvent e) {

				juegoService.buscarLetraOPalabraEnJuego(juego, userInput.getText());
				palabraEnJuego.setText(juegoService.getLetrasPorCompletar(juego));
				actualizarInput();
				actualizarIntentos();
				actualizarPuntaje();
				ocultarJuego(juegoService.finJuego(juego));
			}
		});

		// PRESIONAR BOTON RESET
		btnReset.addActionListener(new ActionListener() {

			// Cuando el usuario hace CLICK en el boton de REINICIAR
			@Override
			public void actionPerformed(ActionEvent e) {
				juego = juegoService.crearJuego();
				palabraEnJuego.setText(juegoService.getLetrasPorCompletar(juego));
				actualizarInput();
				actualizarIntentos();
				actualizarPuntaje();
			}
		});
	}

	private void ocultarJuego(boolean ocultar) {
		if (ocultar) {
			userInput.setVisible(false);
			palabraEnJuego.setText(juegoService.getPalabraJuego(juego));
			lblIntentos.setVisible(false);
			labelUserInput.setVisible(false);
		}

	}

//	  Metodos de limpiar variables

	private void actualizarIntentos() {
		lblIntentos.setText(juegoService.getIntentos(juego));
	}
	
	private void actualizarPuntaje() {
		lblPuntaje.setText(juegoService.getPuntaje(juego));
	}

	private void actualizarInput() {
		userInput.setText("");
	}

	// Metodos de inicializar variables

	private void inicializarTextFieldInput() {
		userInput = new JTextField();
		userInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		userInput.setBounds(413, 532, 186, 42);
		frmJuegoDelAhorcado.getContentPane().add(userInput);
		userInput.setColumns(10);
	}

	private void inicializarLabelUserInput() {
		labelUserInput = new JLabel("Ingrese Letra o Palabra:");
		labelUserInput.setBackground(new Color(255, 255, 255));
		labelUserInput.setForeground(new Color(255, 255, 255));
		labelUserInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 33));
		labelUserInput.setBounds(322, 444, 401, 101);
		frmJuegoDelAhorcado.getContentPane().add(labelUserInput);
	}

	private void inicializarPalabraContainer() {
		palabraContainer = new JPanel();
		palabraContainer.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		palabraContainer.setBackground(new Color(51, 51, 102));
		palabraContainer.setBounds(230, 300, 549, 128);
		frmJuegoDelAhorcado.getContentPane().add(palabraContainer);
	}

	private void inicializarLabelPalabraEnJuego() {
		palabraEnJuego = new JLabel(juegoService.getLetrasPorCompletar(juego));
		palabraContainer.add(palabraEnJuego);
		palabraEnJuego.setHorizontalAlignment(SwingConstants.CENTER);
		palabraEnJuego.setForeground(new Color(255, 255, 255));
		palabraEnJuego.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
	}

	private void inicializarLabelIntentos() {
		lblIntentos = new JLabel(juegoService.getIntentos(juego));
		lblIntentos.setForeground(new Color(204, 51, 51));
		lblIntentos.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lblIntentos.setBounds(10, 11, 345, 51);
		frmJuegoDelAhorcado.getContentPane().add(lblIntentos);
	}
	
	private void inicializarLabelPuntaje() {
		lblPuntaje = new JLabel(juegoService.getPuntaje(juego));
		lblPuntaje.setForeground(new Color(51, 204, 51));
		lblPuntaje.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lblPuntaje.setBounds(430, 11, 345, 51);
		frmJuegoDelAhorcado.getContentPane().add(lblPuntaje);
	}

	private void inicializarLabelTitulo() {
		lblTituloDelJuego = new JLabel("Juego del Ahorcado");
		lblTituloDelJuego.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTituloDelJuego.setForeground(new Color(255, 255, 255));
		lblTituloDelJuego.setBounds(330, 191, 352, 66);
		frmJuegoDelAhorcado.getContentPane().add(lblTituloDelJuego);
	}

	private void inicializarBTNReiniciar() {
		btnReset = new JButton("REINICIAR");
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(51, 51, 102));
		btnReset.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnReset.setBounds(873, 15, 125, 51);
		frmJuegoDelAhorcado.getContentPane().add(btnReset);
	}

	private void inicializarFrameJuego() {
		frmJuegoDelAhorcado = new JFrame();
		frmJuegoDelAhorcado.setTitle("Juego del Ahorcado - Programacion III");
		frmJuegoDelAhorcado.setForeground(new Color(0, 0, 0));
		frmJuegoDelAhorcado.setBackground(new Color(0, 0, 0));
		frmJuegoDelAhorcado.getContentPane().setEnabled(false);
		frmJuegoDelAhorcado.getContentPane().setBackground(new Color(0, 0, 51));
		frmJuegoDelAhorcado.setBounds(100, 100, 1024, 673);
		frmJuegoDelAhorcado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJuegoDelAhorcado.getContentPane().setLayout(null);
	}
}
