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

		frmJuegoDelAhorcado = new JFrame();
		frmJuegoDelAhorcado.setTitle("Juego del Ahorcado - Programacion III");
		frmJuegoDelAhorcado.setForeground(new Color(0, 0, 0));
		frmJuegoDelAhorcado.setBackground(new Color(0, 0, 0));
		frmJuegoDelAhorcado.getContentPane().setEnabled(false);
		frmJuegoDelAhorcado.getContentPane().setBackground(new Color(0, 0, 51));
		frmJuegoDelAhorcado.setBounds(100, 100, 1024, 673);
		frmJuegoDelAhorcado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJuegoDelAhorcado.getContentPane().setLayout(null);

		labelUserInput = new JLabel("Ingrese Letra o Palabra:");
		labelUserInput.setBackground(new Color(255, 255, 255));
		labelUserInput.setForeground(new Color(255, 255, 255));
		labelUserInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 33));
		labelUserInput.setBounds(322, 444, 401, 101);
		frmJuegoDelAhorcado.getContentPane().add(labelUserInput);

		userInput = new JTextField();
		userInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		userInput.setBounds(413, 532, 186, 42);
		frmJuegoDelAhorcado.getContentPane().add(userInput);
		userInput.setColumns(10);

		palabraContainer = new JPanel();
		palabraContainer.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		palabraContainer.setBackground(new Color(51, 51, 102));
		palabraContainer.setBounds(230, 300, 549, 128);
		frmJuegoDelAhorcado.getContentPane().add(palabraContainer);

		palabraEnJuego = new JLabel(juegoService.getPalabraJuego(juego));
		palabraContainer.add(palabraEnJuego);
		palabraEnJuego.setHorizontalAlignment(SwingConstants.CENTER);
		palabraEnJuego.setForeground(new Color(255, 255, 255));
		palabraEnJuego.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));

		lblIntentos = new JLabel(juegoService.getIntentos(juego));
		lblIntentos.setForeground(new Color(204, 51, 51));
		lblIntentos.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lblIntentos.setBounds(10, 11, 345, 51);
		frmJuegoDelAhorcado.getContentPane().add(lblIntentos);

		btnReset = new JButton("REINICIAR");
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(51, 51, 102));
		btnReset.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnReset.setBounds(873, 15, 125, 51);
		frmJuegoDelAhorcado.getContentPane().add(btnReset);

		lblTituloDelJuego = new JLabel("Juego del Ahorcado");
		lblTituloDelJuego.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTituloDelJuego.setForeground(new Color(255, 255, 255));
		lblTituloDelJuego.setBounds(330, 191, 352, 66);
		frmJuegoDelAhorcado.getContentPane().add(lblTituloDelJuego);

		// Event listeners

		// ENTER DEL USUARIO
		userInput.addActionListener(new ActionListener() {
			// Cuando el usuario presiona ENTER al ingresar una palabra o letra
			@Override
			public void actionPerformed(ActionEvent e) {

				juegoService.buscarLetraOPalabraEnJuego(juego, userInput.getText());
				palabraEnJuego.setText(juegoService.getPalabraJuego(juego));
				limpiarInput();
				limpiarIntentos();

			}
		});

		// PRESIONAR BOTON RESET
		btnReset.addActionListener(new ActionListener() {

			// Cuando el usuario hace CLICK en el boton de REINICIAR
			@Override
			public void actionPerformed(ActionEvent e) {

				juego = juegoService.crearJuego();
				palabraEnJuego.setText(juegoService.getPalabraJuego(juego));

				limpiarInput();
				limpiarIntentos();

			}
		});
	}

	private void limpiarIntentos() {
		lblIntentos.setText(juegoService.getIntentos(juego));
	}

	private void limpiarInput() {
		userInput.setText("");
	}
}
