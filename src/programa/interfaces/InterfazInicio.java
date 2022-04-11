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
	private String idioma;

	private JFrame frmInicio;
	private JLabel lblTituloInicio;
	private JLabel lblNombre;
	private JLabel lblDificultad;
	private JTextField nombreInput;
	private final ButtonGroup buttonGroupDificultad = new ButtonGroup();
	private final ButtonGroup buttonGroupIdioma = new ButtonGroup();
	private JRadioButton rdbtnDificultadNormal;
	private JRadioButton rdbtnDificultadDificil;
	private JRadioButton rdbtnEspaol;
	private JRadioButton rdbtnIngles;
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
					if(rdbtnEspaol.isSelected()) {
						idioma = "ESPANOL";
						cerrarInicio();
					} else if (rdbtnIngles.isSelected()) {
						idioma = "INGLES";
						cerrarInicio();
					}
					
				} else if (rdbtnDificultadDificil.isSelected() && !nombreInput.getText().isEmpty()) {
					// Setear dificultad dificil
					dificultad = "DIFICIL";
					if(rdbtnEspaol.isSelected()) {
						idioma = "ESPANOL";
						cerrarInicio();
					} else if (rdbtnIngles.isSelected()) {
						idioma = "INGLES";
						cerrarInicio();
					}
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
		interfazJuego.empezarJuego(nombreInput.getText(), dificultad, idioma);
		;
	}
	
	private void inicializarJFrame() {
		inicializarInicio();

		inicializarBTNJugar();

		inicializarLabelDificultad();

		inicializarLabelError();

		inicializarRadioBTNDificil();

		inicializarRadioBTNNormal();
		
		inicializarRadioBTNEspanol();
		
		inicializarRadioBTNIngles();

		inicializarLabelNombre();

		inicializarTextFieldNombre();

		inicializarLabelTituloInicio();
	}

	private void inicializarBTNJugar() {
		btnJugar = new JButton("Jugar");
		btnJugar.setBackground(Color.WHITE);
		btnJugar.setForeground(Color.DARK_GRAY);
		btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnJugar.setBounds(423, 395, 159, 50);
		frmInicio.getContentPane().add(btnJugar);
	}

	private void inicializarLabelDificultad() {
		lblDificultad = new JLabel("Ingrese la dificultad:");
		lblDificultad.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDificultad.setForeground(new Color(255, 255, 255));
		lblDificultad.setBounds(237, 241, 286, 66);
		frmInicio.getContentPane().add(lblDificultad);
	}

	private void inicializarRadioBTNNormal() {
		rdbtnDificultadNormal = new JRadioButton("NORMAL");
		buttonGroupDificultad.add(rdbtnDificultadNormal);
		rdbtnDificultadNormal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnDificultadNormal.setBounds(529, 267, 108, 23);
		rdbtnDificultadNormal.setBackground(new Color(0, 0, 51));
		rdbtnDificultadNormal.setForeground(new Color(255, 255, 255));
		frmInicio.getContentPane().add(rdbtnDificultadNormal);

	}

	private void inicializarRadioBTNDificil() {
		rdbtnDificultadDificil = new JRadioButton("DIFICIL");
		buttonGroupDificultad.add(rdbtnDificultadDificil);
		rdbtnDificultadDificil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnDificultadDificil.setBounds(639, 267, 93, 23);
		rdbtnDificultadDificil.setBackground(new Color(0, 0, 51));
		rdbtnDificultadDificil.setForeground(new Color(255, 255, 255));
		frmInicio.getContentPane().add(rdbtnDificultadDificil);
	}
	
	private void inicializarRadioBTNEspanol() {
		rdbtnEspaol = new JRadioButton("ESPAÑOL");
		buttonGroupIdioma.add(rdbtnEspaol);
		rdbtnEspaol.setForeground(Color.WHITE);
		rdbtnEspaol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnEspaol.setBackground(new Color(0, 0, 51));
		rdbtnEspaol.setBounds(498, 348, 108, 23);
		frmInicio.getContentPane().add(rdbtnEspaol);
	}
	
	private void inicializarRadioBTNIngles() {
		rdbtnIngles = new JRadioButton("INGLES");
		buttonGroupIdioma.add(rdbtnIngles);
		rdbtnIngles.setForeground(Color.WHITE);
		rdbtnIngles.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnIngles.setBackground(new Color(0, 0, 51));
		rdbtnIngles.setBounds(622, 348, 93, 23);
		frmInicio.getContentPane().add(rdbtnIngles);
	}

	private void inicializarTextFieldNombre() {
		nombreInput = new JTextField();
		nombreInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		nombreInput.setBounds(529, 169, 210, 42);
		frmInicio.getContentPane().add(nombreInput);
		nombreInput.setColumns(10);
	}

	private void inicializarLabelTituloInicio() {
		lblTituloInicio = new JLabel("MENU");
		lblTituloInicio.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTituloInicio.setForeground(new Color(255, 255, 255));
		lblTituloInicio.setBounds(449, 67, 113, 66);
		frmInicio.getContentPane().add(lblTituloInicio);
		
		JLabel lblIngreseElIdioma = new JLabel("Ingrese el idioma:");
		lblIngreseElIdioma.setForeground(Color.WHITE);
		lblIngreseElIdioma.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblIngreseElIdioma.setBounds(237, 318, 286, 66);
		frmInicio.getContentPane().add(lblIngreseElIdioma);

	}

	private void inicializarLabelError() {
		lblError = new JLabel("Complete y/o seleccione todos los campos.");
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblError.setForeground(Color.RED);
		lblError.setBounds(308, 456, 389, 66);
		lblError.setVisible(false);
		frmInicio.getContentPane().add(lblError);

	}

	private void inicializarLabelNombre() {
		lblNombre = new JLabel("Ingrese su nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setBounds(237, 155, 271, 66);
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
