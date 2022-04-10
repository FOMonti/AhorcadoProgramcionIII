package programa.entidades;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Juego {

	private List<String> palabras;
	private Set<String> letrasMarcadas;
	private String palabraEnJuego;
	private char[] letrasPorCompletar;
	private Jugador jugador;
	private String idioma;
	private int puntajeEnJuego;
	private int intentos;
	private boolean finJuego;
	private String mensaje;
	private String dificultad;

	public Juego(List<String> palabras, String idioma, String palabraEnJuego) {
		this.palabras = palabras;
		this.idioma = idioma;
		this.palabraEnJuego = palabraEnJuego;
		this.puntajeEnJuego = 0;
		this.intentos = 5;
		this.finJuego = false;
		this.mensaje = " ";
		this.dificultad = "Normal"; // default
		this.setLetrasMarcadas(new HashSet<String>());
		rellenarVacio(palabraEnJuego.length());
	}

	private void rellenarVacio(int longitud) {
		this.letrasPorCompletar = new char[longitud];
		for (int i = 0; i < longitud; i++) {
			letrasPorCompletar[i] = '-';
		}
	}

	public void rellenarLetra(char letra, int posicion) {
		this.letrasPorCompletar[posicion] = letra;
	}

	public void rellenarPalabraCompleta() {
		for (int i = 0; i < letrasPorCompletar.length; i++) {
			letrasPorCompletar[i] = palabraEnJuego.charAt(i);
		}
	}

	public boolean isJugadorWin() {
		for (int i = 0; i < letrasPorCompletar.length; i++) {
			if (letrasPorCompletar[i] != palabraEnJuego.charAt(i)) {
				return false;
			}
		}
		return true;
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

	public String getPalabraEnJuego() {
		return palabraEnJuego;
	}

	public void setPalabraEnJuego(String palabraEnJuego) {
		this.palabraEnJuego = palabraEnJuego;
	}

	public char[] getLetras() {
		return letrasPorCompletar;
	}

	public void setLetras(char[] letras) {
		this.letrasPorCompletar = letras;
	}

	public char[] getLetrasPorCompletar() {
		return letrasPorCompletar;
	}

	public void setLetrasPorCompletar(char[] letrasPorCompletar) {
		this.letrasPorCompletar = letrasPorCompletar;
	}

	public int getPuntajeEnJuego() {
		return puntajeEnJuego;
	}

	public void setPuntajeEnJuego(int puntajeEnJuego) {
		this.puntajeEnJuego = puntajeEnJuego;
	}

	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	public boolean isFinJuego() {
		return finJuego;
	}

	public void setFinJuego(boolean estadoJuego) {
		this.finJuego = estadoJuego;
	}

	public Set<String> getLetrasMarcadas() {
		return letrasMarcadas;
	}

	public void setLetrasMarcadas(Set<String> letrasMarcadas) {
		this.letrasMarcadas = letrasMarcadas;
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
