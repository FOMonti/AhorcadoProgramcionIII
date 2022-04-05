package programa.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import programa.entidades.Juego;

public class JuegoService {

	public static void main(String[] args) {
		JuegoService juegoService = new JuegoService();
		Juego juego = juegoService.crearJuego();
		// System.out.println(juego.getPalabraEnJuego());
		System.out.println(juego.getIntentos());
		juegoService.buscarLetraOPalabraEnJuego(juego, "p");
		System.out.println(juego.getPuntajeEnJuego());
		System.out.println(juego.getIntentos());
		System.out.println(juego.getLetrasPorCompletar());
	}

	public Juego crearJuego() {
		List<String> palabras = cargarPalabras();
		String palabraRandom = palabraRandom(palabras.size(), palabras);
		return new Juego(palabras, "español", palabraRandom);
	}

	public List<String> cargarPalabras() {
		List<String> palabras = new ArrayList<String>();
		palabras.add("PALABRA");
		palabras.add("PALABRA");
		palabras.add("PALABRA");
		return palabras;
	}

	public boolean buscarLetraOPalabraEnJuego(Juego juego, String input) {
		String palabraJuego = juego.getPalabraEnJuego();
		if (input.length() == palabraJuego.length())
			if (sonIguales(juego, input)) {
				sumarPuntosPalabraCompleta(juego, input);
				juego.rellenarPalabraCompleta();
				juego.setEstadoJuego(false);
				return true;
			}
		if (input.length() == 1)
			if (!(posiciones(juego, input).isEmpty())) {
				sumarPuntos(juego, 1);
				return true;
			}
		restarIntentos(juego);
		if (perdio(juego))
			juego.setEstadoJuego(false);
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
		juego.setPuntajeEnJuego(juego.getPuntajeEnJuego() + (50 * multiplicador));
	}

	public List<Integer> posiciones(Juego juego, String input) {
		List<Integer> posiciones = new ArrayList<Integer>();
		if (!juego.getLetrasMarcadas().contains(input)) {
			String palabraJuego = juego.getPalabraEnJuego();
			char inputLetra = Character.toUpperCase(input.charAt(0));
			for (int i = 0; i < palabraJuego.length(); i++) {
				char letra = palabraJuego.charAt(i);
				if (letra == inputLetra) {
					juego.rellenarLetra(letra, i);
					juego.getLetrasMarcadas().add(input);
					posiciones.add(i);
				}
			}
		}
		return posiciones;
	}

	private boolean sonIguales(Juego juego, String input) {
		return juego.getPalabraEnJuego().equals(input);
	}

	private int contarLetrasFaltantes(Juego juego) {
		String palabraJuego = juego.getPalabraEnJuego();
		int cont = 0;
		char[] letrasPorCompletar = juego.getLetras();
		for (int i = 0; i < palabraJuego.length(); i++) {
			char letra = palabraJuego.charAt(i);
			if (letra != letrasPorCompletar[i]) {
				cont++;
			}
		}
		return cont;
	}

	private String palabraRandom(int max, List<String> palabras) {
		final int min = 0;
		Random random = new Random();
		int valorRandom = random.nextInt(max + min) + min;
		return palabras.get(valorRandom);
	}

}
