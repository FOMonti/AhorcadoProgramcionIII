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

public class InterfazInicio {

	private InterfazJuego interfazJuego;
	private String dificultad;

	private JFrame frmInicio;
	private JLabel lblTituloInicio;
	private JLabel lblNombre;
	private JLabel lblDificultad;
	private JTextField nombreInput;
	private final ButtonGroup buttonGroupDificultad = new ButtonGroup();
	private JRadioButton rdbtnDificultadNormal;
	private JRadioButton rdbtnDificultadDificil;
	private JButton btnJugar;
	private JLabel lblError;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void menu(InterfazJuego interfazJuego) {
		this.interfazJuego = interfazJuego;

		inicializarJFrame();

		btnJugar.addActionListener(new ActionListener() {

			// Cuando el usuario hace CLICK en el boton de Jugar
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnDificultadNormal.isSelected() && !nombreInput.getText().isEmpty()) {
					// Setear dificultad normal
					dificultad = "NORMAL";
					cerrarInicio();
				} else if (rdbtnDificultadDificil.isSelected() && !nombreInput.getText().isEmpty()) {
					// Setear dificultad dificil
					dificultad = "DIFICIL";
					cerrarInicio();
				}

				// Si hay algo que el usuario no completo o selecciono...
				lblError.setVisible(true);

			}
		});
	}

	public JFrame frameInicio() {
		return frmInicio;
	}

	private void cerrarInicio() {
		frmInicio.setVisible(false);
		interfazJuego.empezarJuego(nombreInput.getText(), dificultad);
		;
	}
	
	private void inicializarJFrame() {
		inicializarInicio();

		inicializarBTNJugar();

		inicializarLabelDificultad();

		inicializarLabelError();

		inicializarRadioBTNDificil();

		inicializarRadioBTNNormal();

		inicializarLabelNombre();

		inicializarTextFieldNombre();

		inicializarLabelTituloInicio();
	}

	private void inicializarBTNJugar() {
		btnJugar = new JButton("Jugar");
		btnJugar.setBackground(Color.WHITE);
		btnJugar.setForeground(Color.DARK_GRAY);
		btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnJugar.setBounds(423, 396, 159, 50);
		frmInicio.getContentPane().add(btnJugar);
	}

	private void inicializarLabelDificultad() {
		lblDificultad = new JLabel("Ingrese la dificultad:");
		lblDificultad.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDificultad.setForeground(new Color(255, 255, 255));
		lblDificultad.setBounds(237, 280, 286, 66);
		frmInicio.getContentPane().add(lblDificultad);
	}

	private void inicializarRadioBTNNormal() {
		rdbtnDificultadNormal = new JRadioButton("NORMAL");
		buttonGroupDificultad.add(rdbtnDificultadNormal);
		rdbtnDificultadNormal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnDificultadNormal.setBounds(529, 306, 108, 23);
		rdbtnDificultadNormal.setBackground(new Color(0, 0, 51));
		rdbtnDificultadNormal.setForeground(new Color(255, 255, 255));
		frmInicio.getContentPane().add(rdbtnDificultadNormal);

	}

	private void inicializarRadioBTNDificil() {
		rdbtnDificultadDificil = new JRadioButton("DIFICIL");
		buttonGroupDificultad.add(rdbtnDificultadDificil);
		rdbtnDificultadDificil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnDificultadDificil.setBounds(639, 306, 93, 23);
		rdbtnDificultadDificil.setBackground(new Color(0, 0, 51));
		rdbtnDificultadDificil.setForeground(new Color(255, 255, 255));
		frmInicio.getContentPane().add(rdbtnDificultadDificil);
	}

	private void inicializarTextFieldNombre() {
		nombreInput = new JTextField();
		nombreInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		nombreInput.setBounds(529, 205, 210, 42);
		frmInicio.getContentPane().add(nombreInput);
		nombreInput.setColumns(10);
	}

	private void inicializarLabelTituloInicio() {
		lblTituloInicio = new JLabel("MENU");
		lblTituloInicio.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTituloInicio.setForeground(new Color(255, 255, 255));
		lblTituloInicio.setBounds(448, 99, 113, 66);
		frmInicio.getContentPane().add(lblTituloInicio);

	}

	private void inicializarLabelError() {
		lblError = new JLabel("Complete y/o seleccione todos los campos.");
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblError.setForeground(Color.RED);
		lblError.setBounds(309, 481, 389, 66);
		lblError.setVisible(false);
		frmInicio.getContentPane().add(lblError);

	}

	private void inicializarLabelNombre() {
		lblNombre = new JLabel("Ingrese su nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setBounds(237, 191, 271, 66);
		frmInicio.getContentPane().add(lblNombre);
	}

	private void inicializarInicio() {
		frmInicio = new JFrame();
		frmInicio.setResizable(false);
		frmInicio.getContentPane().setEnabled(false);
		frmInicio.setTitle("Menu");
		frmInicio.setForeground(new Color(0, 0, 0));
		frmInicio.setBackground(new Color(0, 0, 0));
		frmInicio.getContentPane().setBackground(new Color(0, 0, 51));
		frmInicio.setBounds(200, 100, 1024, 673);
		frmInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInicio.getContentPane().setLayout(null);
		frmInicio.setVisible(true);
	}
}
