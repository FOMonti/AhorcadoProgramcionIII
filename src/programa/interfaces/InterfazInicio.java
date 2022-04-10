package programa.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import programa.entidades.Juego;
import programa.servicio.JuegoService;

public class InterfazInicio {

	private Juego juego;
	private JuegoService juegoService = new JuegoService();
	private InterfazJuego interfazJuego;

	private JFrame frmInicio;
	private JLabel lblTituloInicio;
	private JLabel lblNombre;
	private JLabel lblDificultad;
	private JTextField nombreInput;
	private final ButtonGroup buttonGroupDificultad = new ButtonGroup();
	private JRadioButton rdbtnDificultadNormal;
	private JRadioButton rdbtnDificultadDificil;
	private JButton btnJugar;

	public InterfazInicio() {

	}

	public void menu(Juego juego, InterfazJuego interfazJuego) {
		this.juego = juego;
		this.interfazJuego = interfazJuego;

		inicializarInicio();

		inicializarBTNJugar();

		inicializarLabelDificultad();

		inicializarRadioBTNDificil();

		inicializarRadioBTNNormal();

		inicializarLabelNombre();

		inicializarTextFieldNombre();

		inicializarLabelTituloInicio();

		frmInicio.setVisible(true);

		btnJugar.addActionListener(new ActionListener() {

			// Cuando el usuario hace CLICK en el boton de Jugar
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarInicio();
			}
		});
	}

	public JFrame frameInicio() {
		return frmInicio;
	}

	private void cerrarInicio() {
		frmInicio.setVisible(false);
		interfazJuego.empezarJuego(nombreInput.getText());
		;
	}

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
		rdbtnDificultadNormal.setForeground(new Color(255, 255, 255));
		frmInicio.getContentPane().add(rdbtnDificultadNormal);
	}

	private void inicializarRadioBTNDificil() {
		rdbtnDificultadDificil = new JRadioButton("DIFICIL");
		buttonGroupDificultad.add(rdbtnDificultadDificil);
		rdbtnDificultadDificil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnDificultadDificil.setBounds(500, 300, 100, 23);
		rdbtnDificultadDificil.setBackground(new Color(0, 0, 51));
		rdbtnDificultadDificil.setForeground(new Color(255, 255, 255));
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
