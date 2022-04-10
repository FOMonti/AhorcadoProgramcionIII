package programa.entidades;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

	private String nombre;
	private List<Record> records;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.records = new ArrayList<Record>();
	}

	public void agregarRecord(Record record) {
		this.records.add(record);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

}
