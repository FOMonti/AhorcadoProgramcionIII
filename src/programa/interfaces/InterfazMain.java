package programa.interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import programa.entidades.Juego;
import programa.servicio.JuegoService;

public class InterfazMain {

	private JFrame frmInicio;
	private JLabel lblTituloInicio;
	private JLabel lblNombre;
	private JLabel lblDificultad;
	private JTextField nombreInput;
	private final ButtonGroup buttonGroupDificultad = new ButtonGroup();
	private JRadioButton rdbtnDificultadNormal;
	private JRadioButton rdbtnDificultadDificil;
	private JButton btnJugar;

	private JFrame frmJuegoDelAhorcado;
	private JLabel lblNombreJugador;
	private JLabel lblTituloDelJuego;
	private JLabel palabraEnJuego;
	private JLabel lblIntentos;
	private JLabel lblPuntaje;
	private JLabel lblMensaje;
	private JLabel labelUserInput;
	private JTextField userInput;
	private JButton btnReset;
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
					InterfazMain window = new InterfazMain();
					// window.frmJuegoDelAhorcado.setVisible(true);
					window.frmInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		juego = juegoService.crearJuego();

		inicializarInicio();

		inicializarBTNJugar();

		inicializarLabelDificultad();

		inicializarRadioBTNDificil();

		inicializarRadioBTNNormal();

		inicializarLabelNombre();

		inicializarTextFieldNombre();

		inicializarLabelTituloInicio();

		inicializarFrameJuego();

		inicializarLabelUserInput();

		inicializarTextFieldInput();

		inicializarPalabraContainer();

		inicializarLabelPalabraEnJuego();

		inicializarLabelIntentos();

		inicializarLabelPuntaje();

		inicializarLabelMensaje();

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
				actualizarMensaje();
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
				actualizarMensaje();
				actualizarInput();
				actualizarIntentos();
				actualizarPuntaje();
				userInput.setVisible(true);
				lblIntentos.setVisible(true);
				labelUserInput.setVisible(true);
			}
		});

		btnJugar.addActionListener(new ActionListener() {

			// Cuando el usuario hace CLICK en el boton de Jugar
			@Override
			public void actionPerformed(ActionEvent e) {
				juegoService.guardarJugador(juego, nombreInput.getText());
				inicializarLabelNombreJugador();
				empezarJuego();
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

	private void empezarJuego() {
		juegoService.guardarJugador(juego, nombreInput.getText());
		frmInicio.setVisible(false);
		frmJuegoDelAhorcado.setVisible(true);
		;
	}

//	  Metodos de limpiar variables

	private void actualizarIntentos() {
		lblIntentos.setText(juegoService.getIntentos(juego));
	}

	private void actualizarPuntaje() {
		lblPuntaje.setText(juegoService.getPuntaje(juego));
	}

	private void actualizarMensaje() {
		lblMensaje.setText(juegoService.getMensaje(juego));
	}

	private void actualizarInput() {
		userInput.setText("");
	}

	// Metodos de inicializar variables
	// Frame Juego
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

	private void inicializarLabelMensaje() {
		lblMensaje = new JLabel(juegoService.getMensaje(juego));
		lblMensaje.setForeground(new Color(151, 204, 151));
		lblMensaje.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lblMensaje.setBounds(450, 100, 345, 51);
		frmJuegoDelAhorcado.getContentPane().add(lblMensaje);
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
		frmJuegoDelAhorcado.setBounds(200, 100, 1024, 673);
		frmJuegoDelAhorcado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJuegoDelAhorcado.getContentPane().setLayout(null);
	}

	private void inicializarLabelNombreJugador() {
		lblNombreJugador = new JLabel(juegoService.getNombreJugador(juego));
		lblNombreJugador.setForeground(new Color(204, 51, 51));
		lblNombreJugador.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lblNombreJugador.setBounds(10, 50, 345, 51);
		frmJuegoDelAhorcado.getContentPane().add(lblNombreJugador);
	}

	// FrameInicio
	private void inicializarBTNJugar() {
		btnJugar = new JButton("Jugar");
		btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnJugar.setBounds(405, 350, 150, 35);
		frmInicio.getContentPane().add(btnJugar);
	}

	private void inicializarLabelDificultad() {
		lblDificultad = new JLabel("Ingrese la dificultad:");
		lblDificultad.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDificultad.setForeground(new Color(255, 255, 255));
		lblDificultad.setBounds(100, 280, 352, 66);
		frmInicio.getContentPane().add(lblDificultad);
	}

	private void inicializarRadioBTNNormal() {
		rdbtnDificultadNormal = new JRadioButton("NORMAL");
		buttonGroupDificultad.add(rdbtnDificultadNormal);
		rdbtnDificultadNormal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnDificultadNormal.setBounds(383, 300, 120, 23);
		rdbtnDificultadNormal.setBackground(new Color(0, 0, 51));
		frmInicio.getContentPane().add(rdbtnDificultadNormal);
	}

	private void inicializarRadioBTNDificil() {
		rdbtnDificultadDificil = new JRadioButton("DIFICIL");
		buttonGroupDificultad.add(rdbtnDificultadDificil);
		rdbtnDificultadDificil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnDificultadDificil.setBounds(500, 300, 100, 23);
		rdbtnDificultadDificil.setBackground(new Color(0, 0, 51));
		frmInicio.getContentPane().add(rdbtnDificultadDificil);
	}

	private void inicializarTextFieldNombre() {
		nombreInput = new JTextField();
		nombreInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		nombreInput.setBounds(383, 200, 186, 42);
		frmInicio.getContentPane().add(nombreInput);
		nombreInput.setColumns(10);
	}

	private void inicializarLabelTituloInicio() {
		lblTituloInicio = new JLabel("MENU");
		lblTituloInicio.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTituloInicio.setForeground(new Color(255, 255, 255));
		lblTituloInicio.setBounds(413, 100, 352, 66);
		frmInicio.getContentPane().add(lblTituloInicio);
	}

	private void inicializarLabelNombre() {
		lblNombre = new JLabel("Ingrese su nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setBounds(120, 180, 352, 66);
		frmInicio.getContentPane().add(lblNombre);
	}

	private void inicializarInicio() {
		frmInicio = new JFrame();
		frmInicio.setTitle("Menu");
		frmInicio.setForeground(new Color(0, 0, 0));
		frmInicio.setBackground(new Color(0, 0, 0));
		frmInicio.getContentPane().setEnabled(false);
		frmInicio.getContentPane().setBackground(new Color(0, 0, 51));
		frmInicio.setBounds(200, 100, 1024, 673);
		frmInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInicio.getContentPane().setLayout(null);
	}
}
