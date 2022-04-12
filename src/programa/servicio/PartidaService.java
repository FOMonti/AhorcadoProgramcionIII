package programa.servicio;

import programa.entidades.Juego;
import programa.entidades.Partida;

public class PartidaService {

	private static final JuegoService juegoService = new JuegoService();

	public PartidaService() {

	}

	public void actualizarPartida(Juego juego) {
		juego.setPartida(crearPartida(juego));
	}

	public Partida crearPartida(Juego juego) {
		String palabraRandom = juegoService.palabraRandom(juego.getPalabras().size(), juego.getPalabras());
		return new Partida(palabraRandom, 5);
	}

	public boolean resultadoPartida(Juego juego) {
		return juego.getPartida().resultado();
	}

	public boolean buscarLetraEnPalabra(Juego juego, String input) {
		if (input.length() == 1) {
			if (isLetraInPalabra(juego, input)) {
				sumarPuntosLetra(juego, input);
				if (juego.getPartida().resultado()) {
					juegoService.guardarRecord(juego);
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

	public boolean isLetraInPalabra(Juego juego, String input) {
		Partida partida = juego.getPartida();
		boolean ret = false;
		if (!(partida.getLetrasMarcadas().contains(input))) {
			String palabraJuego = partida.getPalabraEnJuego();
			char inputLetra = input.charAt(0);
			for (int i = 0; i < palabraJuego.length(); i++) {
				char letraEnPalabra = palabraJuego.charAt(i);
				if (letraEnPalabra == inputLetra) {
					partida.rellenarLetra(letraEnPalabra, i);
					partida.getLetrasMarcadas().add(input);
					ret = true;
				}
			}
		}
		return ret;
	}

	public void sumarPuntosLetra(Juego juego, String input) {
		Partida partida = juego.getPartida();
		for (int i = 0; i < partida.getPalabraEnJuego().length(); i++) {
			if (input.charAt(0) == partida.getPalabraEnJuego().charAt(i)) {
				partida.setPuntajeEnJuego(partida.getPuntajeEnJuego() + 50);
			}
		}
	}

	public void sumarPuntosPalabraCompleta(Juego juego) {
		Partida partida = juego.getPartida();
		int multiplicador = partida.contarLetrasFaltantes();
		partida.setPuntajeEnJuego(partida.getPuntajeEnJuego() + (100 * multiplicador));
	}

	public void restarIntento(Juego juego) {
		Partida partida = juego.getPartida();
		partida.setIntentos(partida.getIntentos() - 1);
	}

	public boolean sonIguales(Juego juego, String input) {
		Partida partida = juego.getPartida();
		return partida.getPalabraEnJuego().equals(input);
	}

	public boolean compararPalabraConInput(Juego juego, String input, String palabraJuego) {
		if (input.length() == palabraJuego.length()) {
			if (sonIguales(juego, input)) {
				sumarPuntosPalabraCompleta(juego);
				juego.getPartida().rellenarPalabraCompleta();
				juego.setMensaje("Adivinaste!");
				juego.getPartida().setIntentos(0);
				juego.setFinJuego(true);
				return true;
			} else {
				juego.getPartida().setIntentos(0);
				juego.setFinJuego(true);

			}
		}
		return false;
	}

	public String getLetrasPorCompletar(Juego juego) {
		Partida partida = juego.getPartida();
		StringBuilder sb = new StringBuilder();
		char[] letras = partida.getLetrasPorCompletar();
		for (int i = 0; i < partida.getPalabraEnJuego().length(); i++) {
			sb.append(letras[i]);
		}
		return sb.toString();
	}

	public String getPalabraJuego(Juego juego) {
		return juego.getPartida().getPalabraEnJuego();
	}

	public String getIntentos(Juego juego) {
		return "" + juego.getPartida().getIntentos();
	}

	public String getPuntaje(Juego juego) {
		return "" + juego.getPartida().getPuntajeEnJuego();
	}

}
