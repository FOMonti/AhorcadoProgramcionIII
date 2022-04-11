package programa.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import programa.entidades.Juego;
import programa.entidades.Jugador;
import programa.entidades.Record;

public class JuegoService {

	public static final PartidaService partidaService = new PartidaService();
	public RecordSerivce recordSerivce = new RecordSerivce();

	public JuegoService() {

	}

	public Juego crearJuego(String dificultad) {
		List<String> palabras = cargarPalabras(dificultad);
		Juego juego = new Juego(palabras, "Spanish", dificultad);
		actualizarJuego(juego);
		return juego;
	}

	public void actualizarJuego(Juego juego) {
		juego.setPartida(partidaService.crearPartida(juego));
		juego.setFinJuego(false);
	}

	public void guardarJugador(Juego juego, String nombre) {
		Jugador jugador = new Jugador(nombre);
		juego.setJugador(jugador);
	}

	public void guardarRecord(Juego juego) {
		Record record = recordSerivce.crearRecord(juego);
		List<Record> records = juego.getJugador().getRecords();
		records.add(record);
		juego.getJugador().setRecords(records);
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
		String palabraJuego = juego.getPartida().getPalabraEnJuego();
		input = input.toUpperCase();
		if (partidaService.compararPalabraConInput(juego, input, palabraJuego)) {
			guardarRecord(juego);
			return;
		}
		if (input.length() != 1 && input.length() != palabraJuego.length()) {
			partidaService.restarIntento(juego);
			juego.setMensaje("Debes poner un caracter o intentar \n adivinar la palabra completa");
			return;
		}

		if (partidaService.buscarLetraEnPalabra(juego, input))
			return;

		if (juego.getPartida().getIntentos() == 0) {
			juego.setMensaje("Perdiste :(");
			guardarRecord(juego);
			juego.setFinJuego(true);
		}

		return;
	}

	public String palabraRandom(int max, List<String> palabras) {
		final int min = 0;
		Random random = new Random();
		int valorRandom = random.nextInt(max + min) + min;
		return palabras.get(valorRandom);
	}

	public String getPalabraJuego(Juego juego) {
		return partidaService.getPalabraJuego(juego);
	}

	public String getIntentos(Juego juego) {
		return partidaService.getIntentos(juego);
	}

	public String getPuntaje(Juego juego) {
		return partidaService.getPuntaje(juego);
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

	public String getLetrasPorCompletar(Juego juego) {
		return partidaService.getLetrasPorCompletar(juego);
	}
}
