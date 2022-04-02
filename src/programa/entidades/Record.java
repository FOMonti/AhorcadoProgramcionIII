package programa.entidades;

public class Record {

	private int puntaje;
	private boolean gano;

	public Record(int puntaje, boolean gano) {
		this.puntaje = puntaje;
		this.gano = gano;
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

}
