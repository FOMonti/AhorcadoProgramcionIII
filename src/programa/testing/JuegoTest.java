package programa.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import programa.entidades.Juego;
import programa.entidades.Jugador;
import programa.entidades.Partida;
import programa.servicio.JuegoService;
import programa.servicio.PartidaService;

class JuegoTest {

	JuegoService juegoService;
	Juego juego;
	PartidaService partidaService;
	Partida partida;
	

	@BeforeEach
	public void inicializar() {
		juegoService = new JuegoService();
		juego = juegoService.crearJuego("NORMAL");
		juego.setJugador(new Jugador("Tomas"));
		juego.getPartida().setPalabraEnJuego("PALABRA");
		juego.getPartida().getLetrasPorCompletar();
		
		
		
		
	}

	@Test
	public void puntajeTest() {
		juegoService.jugar(juego, "p");
		assertEquals("PUNTAJE: 50", juegoService.getPuntaje(juego));
	}

	@Test
	public void letraRepetidaTest() {
		juegoService.jugar(juego, "p");
		juegoService.jugar(juego, "p");
		assertEquals("PUNTAJE: 50", juegoService.getPuntaje(juego));
		assertEquals("INTENTOS: 4", juegoService.getIntentos(juego));
	}

	// ARREGLADO
	@Test
	public void multiplicadorTest() {
		juegoService.jugar(juego, "palabra");
		assertEquals(700, juegoService.getPuntaje(juego));
	}

	// ARREGLADO
	@Test
	public void multiplicadorConMenosLetrasTest() {
		juegoService.jugar(juego, "p");
		juegoService.jugar(juego, "a");
		juegoService.jugar(juego, "PALABRA");
		assertEquals(500, juegoService.getPuntaje(juego));
	}

	@Test
	public void restarIntentoTest() {
		juegoService.jugar(juego, "a");
		assertEquals("INTENTOS: 5", juegoService.getIntentos(juego));
		juegoService.jugar(juego, "u");
		assertEquals("INTENTOS: 4", juegoService.getIntentos(juego));
		assertFalse(juegoService.finJuego(juego));
	}

	@Test
	public void restarIntentosPalabraCompletaTest() {
		juegoService.jugar(juego, "WAKANDA"); // PALABRA
		assertEquals("INTENTOS: 0", juegoService.getIntentos(juego));
		assertTrue(juegoService.finJuego(juego));
	}

	@Test
	public void letrasMarcadasTest() {
		juegoService.jugar(juego, "a");
		assertEquals(1, partida.getLetrasMarcadas().size());
	}

	@Test
	public void letrasPorCompletarTest() {
		
		assertEquals(juego.getPartida().getPalabraEnJuego().length() , juego.getPartida().getLetrasPorCompletar().length);
		juegoService.jugar(juego, "a");
		assertEquals("-A-A--A", juego.getPartida().getLetrasPorCompletar());
	}

}
