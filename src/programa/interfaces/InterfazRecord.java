package programa.interfaces;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;

import programa.entidades.Juego;
import programa.entidades.Jugador;
import programa.entidades.Record;
import programa.servicio.JuegoService;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class InterfazRecord {

	private JFrame frmRecord;
	private JTable table;
	private JLabel lblTitulo;
	private JButton btnVolver;
	private DefaultTableModel model = new DefaultTableModel();

	private static InterfazJuego interfazJuego;
	private Juego juego;
	private static final JuegoService juegoService = new JuegoService();

	/**
	 * @wbp.parser.entryPoint
	 */
	public InterfazRecord() {
		inicializarFrame();
		inicializarBTNVolver();
		inicializarTable();
	}

	public void mostarRecords(Juego juego, InterfazJuego interfazJuego) {
		this.juego = juego;
		InterfazRecord.interfazJuego = interfazJuego;
		llenarTabla();
		inicializarlblTitulo();
		frmRecord.setVisible(true);

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAJuego();
			}
		});

	}

	private void volverAJuego() {
		model = new DefaultTableModel();
		frmRecord.setVisible(false);
		interfazJuego.seguirConJuego(this);
	}

	private void inicializarFrame() {
		frmRecord = new JFrame();
		frmRecord.setTitle("Record");
		frmRecord.setForeground(new Color(0, 0, 0));
		frmRecord.setBackground(new Color(0, 0, 0));
		frmRecord.getContentPane().setEnabled(false);
		frmRecord.getContentPane().setBackground(new Color(0, 0, 51));
		frmRecord.getContentPane().setLayout(null);
		frmRecord.setBounds(200, 100, 1024, 673);
		frmRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void inicializarTable() {
		this.table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 88, 917, 493);
		frmRecord.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		this.table.setModel(model);
	}

	private void inicializarlblTitulo() {
		lblTitulo = new JLabel("¡Estos son tus records, " + juegoService.getNombreJugador(juego) + "!");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(51, 38, 762, 27);
		lblTitulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblTitulo.setForeground(Color.WHITE);
		frmRecord.getContentPane().add(lblTitulo);

	}

	private void inicializarBTNVolver() {
		btnVolver = new JButton("VOLVER");
		btnVolver.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(843, 26, 125, 51);
		frmRecord.getContentPane().add(btnVolver);
	}

	private void llenarTabla() {
		model.addColumn("Puntaje");
		model.addColumn("Resultado");
		model.addColumn("Palabra");
		this.table.setModel(model);
		Jugador jugador = juego.getJugador();
		List<Record> records = jugador.getRecords();
		for (Record record : records) {
			if (record.isGano())
				model.addRow(new String[] { "" + record.getPuntaje(), "Ganaste", record.getPalabra() });
			else
				model.addRow(new String[] { "" + record.getPuntaje(), "Perdiste", record.getPalabra() });
		}
	}
}
