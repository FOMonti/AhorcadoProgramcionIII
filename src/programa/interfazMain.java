package programa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class interfazMain {

	private JFrame frmJuegoDelAhorcado;
	private JTextField textField;

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
		frmJuegoDelAhorcado = new JFrame();
		frmJuegoDelAhorcado.setTitle("Juego del Ahorcado - Programaci\u00F3n III");
		frmJuegoDelAhorcado.setForeground(new Color(0, 0, 0));
		frmJuegoDelAhorcado.setBackground(new Color(0, 0, 0));
		frmJuegoDelAhorcado.getContentPane().setEnabled(false);
		frmJuegoDelAhorcado.getContentPane().setBackground(new Color(0, 0, 51));
		frmJuegoDelAhorcado.setBounds(100, 100, 1024, 673);
		frmJuegoDelAhorcado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJuegoDelAhorcado.getContentPane().setLayout(null);
		
		JLabel labelUserInput = new JLabel("Ingrese Letra o Palabra:");
		labelUserInput.setBackground(new Color(255, 255, 255));
		labelUserInput.setForeground(new Color(255, 255, 255));
		labelUserInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 33));
		labelUserInput.setBounds(322, 444, 401, 101);
		frmJuegoDelAhorcado.getContentPane().add(labelUserInput);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		textField.setBounds(413, 532, 186, 42);
		frmJuegoDelAhorcado.getContentPane().add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(51, 51, 102));
		panel.setBounds(230, 300, 549, 128);
		frmJuegoDelAhorcado.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("PA-A--A");
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		
		
		JLabel lblNewLabel_1 = new JLabel("INTENTOS: 10");
		lblNewLabel_1.setForeground(new Color(204, 51, 51));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(10, 11, 345, 51);
		frmJuegoDelAhorcado.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("REINICIAR");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 51, 102));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnNewButton.setBounds(873, 15, 125, 51);
		frmJuegoDelAhorcado.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Juego del Ahorcado");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(330, 191, 352, 66);
		frmJuegoDelAhorcado.getContentPane().add(lblNewLabel_2);
	}
}
