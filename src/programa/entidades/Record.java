package programa.entidades;

public class Record {

	private int puntaje;
	private boolean gano;
	private String palabra;

	public Record(int puntaje, boolean gano, String palabra) {
		this.puntaje = puntaje;
		this.gano = gano;
		this.palabra = palabra;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public boolean isGano() {
		return gano;
	}

	public void setGano(boolean gano) {
		this.gano = gano;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

}
