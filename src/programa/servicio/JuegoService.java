package programa.servicio;

import java.util.ArrayList;
import java.util.List;

import programa.entidades.Juego;

public class JuegoService {

	public Juego crearJuego() {

		List<String> palabras = cargarPalabras();

		return null;
	}

	public List<String> cargarPalabras() {
		List<String> palabras = new ArrayList<String>();
		palabras.add("Palabra");

		return palabras;
	}

	public boolean buscarLetraOPalabraEnJuego(Juego juego, String input) {
		if (juego.getPalabraEnJuego().length() != input.length()) {
			restarPuntos(juego);
		}
		return false;
	}

	public void restarPuntos(Juego juego) {

	}
}
