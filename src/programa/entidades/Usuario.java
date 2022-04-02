package programa.entidades;

import java.util.List;

public class Usuario {

	private String nombre;
	private String contraseña;
	private List<Record> records;

	public Usuario(String nombre, String contraseña, List<Record> records) {

		this.nombre = nombre;
		this.contraseña = contraseña;
		this.records = records;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

}
