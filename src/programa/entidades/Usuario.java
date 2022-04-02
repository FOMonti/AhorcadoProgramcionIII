package programa.entidades;

import java.util.List;

public class Usuario {

	private String nombre;
	private String contrase�a;
	private List<Record> records;

	public Usuario(String nombre, String contrase�a, List<Record> records) {

		this.nombre = nombre;
		this.contrase�a = contrase�a;
		this.records = records;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

}
