package programa.entidades;

import java.util.List;

public class Juego {

	private List<String> palabras;
	private String palabraEnJuego;
	private char[] letrasPorCompletar;
	private Usuario usuario;
	private String idioma;
	private int puntajeEnJuego;
	private int intentos;
	private boolean estadoJuego;

	public Juego() {

	}

	public Juego(List<String> palabras, Usuario usuario, String idioma, String palabraEnJuego) {
		this.palabras = palabras;
		this.usuario = usuario;
		this.idioma = idioma;
		this.palabraEnJuego = palabraEnJuego;
		this.letrasPorCompletar = new char[palabraEnJuego.length()];
		this.puntajeEnJuego = 0;
		this.intentos = 10;
		this.estadoJuego = true;
	}

	public List<String> getPalabras() {
		return palabras;
	}

	public void setPalabras(List<String> palabras) {
		this.palabras = palabras;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public boolean isEstadoJuego() {
		return estadoJuego;
	}

	public void setEstadoJuego(boolean estadoJuego) {
		this.estadoJuego = estadoJuego;
	}

}
