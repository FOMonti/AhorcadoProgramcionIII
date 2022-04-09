package programa.entidades;

import java.util.List;

public class Usuario {

	private String nombre;
	private List<Record> records;

	public Usuario(String nombre, List<Record> records) {

		this.nombre = nombre;
		this.records = records;
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
