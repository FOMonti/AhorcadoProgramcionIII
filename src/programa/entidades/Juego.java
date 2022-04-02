package programa.entidades;

import java.util.List;

public class Juego {

	private List<String> palabras;
	private String palabraEnJuego;
	private Usuario usuario;
	private String idioma;

	public Juego() {

	}

	public Juego(List<String> palabras, Usuario usuario, String idioma, String palabraEnJuego) {
		this.palabras = palabras;
		this.usuario = usuario;
		this.idioma = idioma;
		this.palabraEnJuego = palabraEnJuego;
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

}
