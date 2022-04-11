package programa.entidades;

import java.util.List;

public class Juego {

	private List<String> palabras;
	private Jugador jugador;
	private String idioma;
	private boolean finJuego;
	private String mensaje;
	private String dificultad;
	private Partida partida;

	public static final int INTENTOS = 5;

	public Juego(List<String> palabras, String idioma, String dificultad) {
		this.palabras = palabras;
		this.idioma = idioma;
		this.finJuego = false;
		this.mensaje = " ";
		this.dificultad = dificultad;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public void reiniciarJuego(String palabraEnJuego) {
		this.finJuego = false;
		this.mensaje = " ";
	}

	public List<String> getPalabras() {
		return palabras;
	}

	public void setPalabras(List<String> palabras) {
		this.palabras = palabras;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public boolean isFinJuego() {
		return finJuego;
	}

	public void setFinJuego(boolean estadoJuego) {
		this.finJuego = estadoJuego;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

}
