package programa.interfaces;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;

import programa.entidades.Juego;
import programa.entidades.Jugador;
import programa.entidades.Record;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class InterfazRecord {

	private JFrame frmRecord;
	private Juego juego;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();

	/**
	 * @wbp.parser.entryPoint
	 */
	public void mostrarRecords(Juego juego) {
		this.juego = juego;
		inicializarFrame();
		inicializarTable();
		frmRecord.setVisible(true);
	}

	private void inicializarFrame() {
		frmRecord = new JFrame();
		frmRecord.setTitle("Record");
		frmRecord.setForeground(new Color(0, 0, 0));
		frmRecord.setBackground(new Color(0, 0, 0));
		frmRecord.getContentPane().setEnabled(false);
		frmRecord.getContentPane().setBackground(new Color(0, 0, 51));
		frmRecord.getContentPane().setLayout(null);

	}

	private void inicializarTable() {

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 88, 917, 493);
		frmRecord.getContentPane().add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		frmRecord.setBounds(200, 100, 1024, 673);
		frmRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		llenarTabla();
	}

	private void llenarTabla() {
		model.addColumn("Puntaje");
		model.addColumn("Resultado");
		model.addColumn("Palabra");
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
