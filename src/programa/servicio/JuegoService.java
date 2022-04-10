package programa.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import programa.entidades.Juego;
import programa.entidades.Jugador;
import programa.entidades.Record;

public class JuegoService {

	public Juego crearJuego(String dificultad) {
		List<String> palabras = cargarPalabras(dificultad);
		String palabraRandom = palabraRandom(palabras.size(), palabras);
		return new Juego(palabras, "Spanish", palabraRandom, dificultad);
	}

	public void guardarJugador(Juego juego, String nombre) {
		Jugador jugador = new Jugador(nombre);
		juego.setJugador(jugador);
	}

	public void guardarRecord(Juego juego) {
		Record record = new Record(juego.getPuntajeEnJuego(), juego.isJugadorWin(), juego.getPalabraEnJuego());
		juego.getJugador().agregarRecord(record);
	}

	public List<String> cargarPalabras(String dificultad) {
		List<String> palabras = new ArrayList<String>();
		if (dificultad.equals("NORMAL")) {
			palabras = Palabra.getPalabrasDificultadNormal();
		} else {
			palabras = Palabra.getPalabrasDificultadDificil();
		}
		return palabras;
	}

	public void jugar(Juego juego, String input) {
		String palabraJuego = juego.getPalabraEnJuego();
		input = input.toUpperCase();

		if (compararPalabraConInput(juego, input, palabraJuego))
			return;

		if (input.length() != 1 && input.length() != palabraJuego.length()) {
			restarIntento(juego);
			juego.setMensaje("Debes poner un caracter o intentar \n adivinar la palabra completa");
			return;
		}

		if (buscarLetraEnPalabra(juego, input))
			return;

		if (juego.getIntentos() == 0) {
			juego.setMensaje("Perdiste :(");
			juego.setFinJuego(true);
		}

		return;
	}

	private boolean buscarLetraEnPalabra(Juego juego, String input) {
		if (input.length() == 1) {
			if (isLetraInPalabra(juego, input)) {
				sumarPuntosLetra(juego, input);
				if (sonIguales(juego, getLetrasPorCompletar(juego))) {
					juego.setFinJuego(true);
					juego.setMensaje("Adivinaste!");
				} else {
					juego.setMensaje("Muy bien!");
				}
				return true;
			}
			juego.setMensaje("Fallaste :(");
			restarIntento(juego);
		}
		return false;
	}

	private boolean compararPalabraConInput(Juego juego, String input, String palabraJuego) {
		if (input.length() == palabraJuego.length()) {
			if (sonIguales(juego, input)) {
				sumarPuntosPalabraCompleta(juego);
				juego.rellenarPalabraCompleta();
				juego.setMensaje("Adivinaste!");
				juego.setIntentos(0);
				juego.setFinJuego(true);
				return true;
			} else {
				System.out.println("asdas");
				juego.setIntentos(0);
				juego.setFinJuego(true);

			}
		}
		return false;
	}

	private void restarIntento(Juego juego) {
		juego.setIntentos(juego.getIntentos() - 1);
	}

	private void sumarPuntosPalabraCompleta(Juego juego) {
		int multiplicador = contarLetrasFaltantes(juego);
		juego.setPuntajeEnJuego(juego.getPuntajeEnJuego() + (100 * multiplicador));
	}

	private void sumarPuntosLetra(Juego juego, String input) {
		for (int i = 0; i < juego.getPalabraEnJuego().length(); i++) {
			if (input.charAt(0) == juego.getPalabraEnJuego().charAt(i)) {
				juego.setPuntajeEnJuego(juego.getPuntajeEnJuego() + 50);
			}
		}
	}

	private boolean isLetraInPalabra(Juego juego, String input) {
		boolean ret = false;
		if (!juego.getLetrasMarcadas().contains(input)) {
			String palabraJuego = juego.getPalabraEnJuego();
			char inputLetra = input.charAt(0);
			for (int i = 0; i < palabraJuego.length(); i++) {
				char letra = palabraJuego.charAt(i);
				if (letra == inputLetra) {
					juego.rellenarLetra(letra, i);
					juego.getLetrasMarcadas().add(input);
					ret = true;
				}
			}
		}
		return ret;
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

	public String getLetrasPorCompletar(Juego juego) {
		StringBuilder sb = new StringBuilder();
		char[] letras = juego.getLetrasPorCompletar();
		for (int i = 0; i < juego.getPalabraEnJuego().length(); i++) {
			sb.append(letras[i]);
		}
		return sb.toString();
	}

	public String getPalabraJuego(Juego juego) {
		return juego.getPalabraEnJuego();
	}

	public String getIntentos(Juego juego) {
		return "INTENTOS: " + juego.getIntentos();
	}

	public String getPuntaje(Juego juego) {
		return "PUNTAJE: " + String.valueOf(juego.getPuntajeEnJuego());
	}

	public String getMensaje(Juego juego) {
		return "" + juego.getMensaje();
	}

	public String getNombreJugador(Juego juego) {
		return "JUGADOR: " + juego.getJugador().getNombre().toUpperCase();
	}

	public boolean finJuego(Juego juego) {
		return juego.isFinJuego();
	}
}
