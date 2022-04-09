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
		juego = new Juego(null, "español", "PALABRA");
	}
	
	@Test
	public void puntajeTest() {
		juegoService.buscarLetraOPalabraEnJuego(juego, "p");
		assertEquals(50, juego.getPuntajeEnJuego());
	}
	
	@Test
	public void letraRepetidaTest() {
		juegoService.buscarLetraOPalabraEnJuego(juego, "p");
		juegoService.buscarLetraOPalabraEnJuego(juego, "p");
		assertEquals(50, juego.getPuntajeEnJuego());
		assertEquals(4, juego.getIntentos());
	}
	
	// ARREGLADO
	@Test
	public void multiplicadorTest() {
		juegoService.buscarLetraOPalabraEnJuego(juego, "palabra");
		assertEquals(700, juego.getPuntajeEnJuego());
	}
	
	// ARREGLADO
	@Test
	public void multiplicadorConMenosLetrasTest() { 
		juegoService.buscarLetraOPalabraEnJuego(juego, "p");
		juegoService.buscarLetraOPalabraEnJuego(juego, "a"); 
		juegoService.buscarLetraOPalabraEnJuego(juego, "PALABRA");
		assertEquals(500, juego.getPuntajeEnJuego());
	}
	
	@Test
	public void restarIntentoTest() {
		juegoService.buscarLetraOPalabraEnJuego(juego, "a");
		assertEquals(5, juego.getIntentos());
		juegoService.buscarLetraOPalabraEnJuego(juego, "u");
		assertEquals(4, juego.getIntentos());
	}
	
	@Test
	public void restarIntentosPalabraCompletaTest() {
		juegoService.buscarLetraOPalabraEnJuego(juego, "WAKANDA");
		assertEquals(0, juego.getIntentos());
		assertTrue(juego.isFinJuego());
	}
	
	@Test
	public void letrasMarcadasTest() {
		juegoService.buscarLetraOPalabraEnJuego(juego, "a");
		assertEquals(1, juego.getLetrasMarcadas().size());
	}
	
	@Test
	public void letrasPorCompletarTest() {
		assertEquals("-------", juegoService.getLetrasPorCompletar(juego));
		juegoService.buscarLetraOPalabraEnJuego(juego, "a");
		assertEquals("-A-A--A", juegoService.getLetrasPorCompletar(juego));
	}
	

}
