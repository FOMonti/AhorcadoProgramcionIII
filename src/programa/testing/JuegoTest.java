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
		juego = juegoService.crearJuego("TEST", "TEST");
		juego.setJugador(new Jugador("Test"));
		juego.getPartida().setPalabraEnJuego("PALABRA");
	}
	
	public int puntaje() {
		return juego.getPartida().getPuntajeEnJuego();
	}
	
	public int intentos() {
		return juego.getPartida().getIntentos();
	}
	
	public String palabra() {
		return juego.getPartida().getPalabraEnJuego();
	}
	
	public String letrasPorCompletar() {
		String str = "";
		for(char c: juego.getPartida().getLetrasPorCompletar()) {
			str = str + c;
		}
		return str;
	}


	@Test
	public void puntajeTest() {
		juegoService.jugar(juego, "p");
		assertEquals(50, puntaje());
	}

	@Test
	public void letraRepetidaTest() {
		juegoService.jugar(juego, "p");
		juegoService.jugar(juego, "p");
		assertEquals(50, puntaje());
		assertEquals(4, intentos());
	}

	// ARREGLADO
	@Test
	public void multiplicadorTest() {
		juegoService.jugar(juego, "PALABRA");
		assertEquals(700, puntaje());
	}

	// ARREGLADO
	@Test
	public void multiplicadorConMenosLetrasTest() {
		juegoService.jugar(juego, "p");
		juegoService.jugar(juego, "a");
		juegoService.jugar(juego, "PALABRA");
		assertEquals(500, puntaje());
	}

	@Test
	public void restarIntentoTest() {
		juegoService.jugar(juego, "a");
		assertEquals(5, intentos());
		juegoService.jugar(juego, "u");
		assertEquals(4, intentos());
		assertFalse(juegoService.finJuego(juego));
	}

	@Test
	public void restarIntentosPalabraCompletaTest() {
		juegoService.jugar(juego, "WAKANDA"); // PALABRA
		assertEquals(0, intentos());
		assertTrue(juegoService.finJuego(juego));
	}

	@Test
	public void letrasMarcadasTest() {
		juegoService.jugar(juego, "a");
		assertEquals(1, juego.getPartida().getLetrasMarcadas().size());
	}

	@Test
	public void letrasPorCompletarTest() {
		assertEquals(palabra().length(), letrasPorCompletar().length());
		juegoService.jugar(juego, "a");
		assertEquals("-A-A--A", letrasPorCompletar());
	}

}
