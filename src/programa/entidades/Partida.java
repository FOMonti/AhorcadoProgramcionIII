package programa.entidades;

import java.util.HashSet;
import java.util.Set;

public class Partida {

	private char[] letrasPorCompletar;
	private Set<String> letrasMarcadas;
	private String palabraEnJuego;
	private int puntajeEnJuego;
	private int intentos;

	public Partida(String palabraEnJuego, int intentos) {
		this.palabraEnJuego = palabraEnJuego;
		this.puntajeEnJuego = 0;
		this.intentos = 5;
		this.setLetrasMarcadas(new HashSet<String>());
		rellenarVacio(palabraEnJuego.length());
	}

	public boolean resultado() {
		for (int i = 0; i < letrasPorCompletar.length; i++) {
			if (letrasPorCompletar[i] != palabraEnJuego.charAt(i))
				return false;
		}
		return true;
	}

	public int contarLetrasFaltantes() {
		int cont = 0;
		for (int i = 0; i < palabraEnJuego.length(); i++) {
			char letra = palabraEnJuego.charAt(i);
			if (letra != letrasPorCompletar[i]) {
				cont++;
			}
		}
		return cont;
	}

	public void reiniciarPartida(String palabraEnJuego) {
		this.intentos = 5;
		this.setLetrasMarcadas(new HashSet<String>());
		this.palabraEnJuego = palabraEnJuego;
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

	public char[] getLetrasPorCompletar() {
		return letrasPorCompletar;
	}

	public void setLetrasPorCompletar(char[] letrasPorCompletar) {
		this.letrasPorCompletar = letrasPorCompletar;
	}

	public Set<String> getLetrasMarcadas() {
		return letrasMarcadas;
	}

	public void setLetrasMarcadas(Set<String> letrasMarcadas) {
		this.letrasMarcadas = letrasMarcadas;
	}

	public String getPalabraEnJuego() {
		return palabraEnJuego;
	}

	public void setPalabraEnJuego(String palabraEnJuego) {
		this.palabraEnJuego = palabraEnJuego;
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

}
