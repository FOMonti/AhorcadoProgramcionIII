package programa.servicio;

import programa.entidades.Juego;
import programa.entidades.Partida;
import programa.entidades.Record;

public class RecordSerivce {

	public Record crearRecord(Juego juego) {
		Partida partida = juego.getPartida();
		return new Record(partida.getPuntajeEnJuego(), partida.resultado(), partida.getPalabraEnJuego());
	}

}
