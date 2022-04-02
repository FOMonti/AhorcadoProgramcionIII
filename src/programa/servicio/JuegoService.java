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
		String palabraJuego = juego.getPalabraEnJuego();
		if (palabraJuego.length() != input.length() && input.length() != 1) {
			restarIntentos(juego);
			return false;
		}
		if (sonIguales(juego, input)) {
			sumarPuntosPalabraCompleta(juego, input);
			// Accionar
		} else {
			restarIntentos(juego);
		}

		if (buscar(juego, input)) {
			sumarPuntos(juego, 1);
			return true;
		} else {
			restarIntentos(juego);
		}
		return false;
	}

	private void restarIntentos(Juego juego) {
		juego.setIntentos(juego.getIntentos() - 1);
	}

	public boolean perdio(Juego juego) {
		return juego.isEstadoJuego();
	}

	private void sumarPuntosPalabraCompleta(Juego juego, String input) {
		int cantLetrasFaltantes = contarLetrasFaltantes(juego);
		sumarPuntos(juego, cantLetrasFaltantes);
	}

	private void sumarPuntos(Juego juego, int multiplicador) {
		juego.setPuntajeEnJuego(juego.getPuntajeEnJuego() + 50);
	}

	private boolean buscar(Juego juego, String input) {
		String palabraJuego = juego.getPalabraEnJuego();
		char inputLetra = input.charAt(0);
		for (int i = 0; i < palabraJuego.length(); i++) {
			char letra = palabraJuego.charAt(i);
			if (letra == inputLetra) {
				return true;
			}
		}
		return false;

	}

	private boolean sonIguales(Juego juego, String input) {
		return juego.getPalabraEnJuego().equals(input);
	}

//	private boolean soloQuedabaUnaLetra(Juego juego) {
//		if (contarLetrasFaltantes(juego) == (juego.getPalabraEnJuego().length() - 1)) {
//			return true;
//		}
//		return false;
//	}

	private int contarLetrasFaltantes(Juego juego) {
		String palabraJuego = juego.getPalabraEnJuego();
		int cont = 0;
		char[] letrasPorCompletar = juego.getLetras();
		for (int i = 0; i < palabraJuego.length(); i++) {
			char letra = palabraJuego.charAt(i);
			if (letra == letrasPorCompletar[i]) {
				cont++;
			}
		}
		return cont;
	}
}
