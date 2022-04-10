package programa.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import programa.entidades.Juego;
import programa.servicio.JuegoService;

class JuegoTest {

	JuegoService juegoService;
	Juego juego;

	@BeforeEach
	public void inicializar() {
		juegoService = new JuegoService();
		juego = new Juego(null, "español", "PALABRA", "NORMAL");
	}

	@Test
	public void puntajeTest() {
		juegoService.jugar(juego, "p");
		assertEquals(50, juego.getPuntajeEnJuego());
	}

	@Test
	public void letraRepetidaTest() {
		juegoService.jugar(juego, "p");
		juegoService.jugar(juego, "p");
		assertEquals(50, juego.getPuntajeEnJuego());
		assertEquals(4, juego.getIntentos());
	}

	// ARREGLADO
	@Test
	public void multiplicadorTest() {
		juegoService.jugar(juego, "palabra");
		assertEquals(700, juego.getPuntajeEnJuego());
	}

	// ARREGLADO
	@Test
	public void multiplicadorConMenosLetrasTest() {
		juegoService.jugar(juego, "p");
		juegoService.jugar(juego, "a");
		juegoService.jugar(juego, "PALABRA");
		assertEquals(500, juego.getPuntajeEnJuego());
	}

	@Test
	public void restarIntentoTest() {
		juegoService.jugar(juego, "a");
		assertEquals(5, juego.getIntentos());
		juegoService.jugar(juego, "u");
		assertEquals(4, juego.getIntentos());
		assertFalse(juegoService.finJuego(juego));
	}

	@Test
	public void restarIntentosPalabraCompletaTest() {
		juegoService.jugar(juego, "WAKANDA"); // PALABRA
		assertEquals(0, juego.getIntentos());
		assertTrue(juego.isFinJuego());
	}

	@Test
	public void letrasMarcadasTest() {
		juegoService.jugar(juego, "a");
		assertEquals(1, juego.getLetrasMarcadas().size());
	}

	@Test
	public void letrasPorCompletarTest() {
		assertEquals("-------", juegoService.getLetrasPorCompletar(juego));
		juegoService.jugar(juego, "a");
		assertEquals("-A-A--A", juegoService.getLetrasPorCompletar(juego));
	}

}
