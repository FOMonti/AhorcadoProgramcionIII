package programa.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import programa.entidades.Juego;
import programa.servicio.JuegoService;

class JuegoTest {
	
	@Test
	void puntajeTest() {
		JuegoService juegoService = new JuegoService();
		Juego juego = juegoService.crearJuego();
		
		juegoService.buscarLetraOPalabraEnJuego(juego, "p");
		
		assertEquals(juego.getPuntajeEnJuego(), 50);
	}
	
	// ARREGLAR
	@Test
	void multiplicadorTest() {
		JuegoService juegoService = new JuegoService();
		Juego juego = juegoService.crearJuego();
		
		juegoService.buscarLetraOPalabraEnJuego(juego, "palabra"); //si la palabra esta en minuscula no la cuenta
		
		assertEquals(350, juego.getPuntajeEnJuego());
	}
	
	// ARREGLAR
	@Test
	void multiplicadorConMenosLetrasTest() {
		JuegoService juegoService = new JuegoService();
		Juego juego = juegoService.crearJuego();
		
		juegoService.buscarLetraOPalabraEnJuego(juego, "p");
		juegoService.buscarLetraOPalabraEnJuego(juego, "a"); //la "a" cuenta como una sola letra y son 3, por lo que el multiplicador no suma bien
		juegoService.buscarLetraOPalabraEnJuego(juego, "PALABRA");
		
		assertEquals(350, juego.getPuntajeEnJuego());
	}
	
	@Test
	void intentosTest() {
		JuegoService juegoService = new JuegoService();
		Juego juego = juegoService.crearJuego();
		
		assertEquals(5, juego.getIntentos());
		juegoService.buscarLetraOPalabraEnJuego(juego, "u");
		assertEquals(4, juego.getIntentos());
	}
	
	@Test
	void letrasMarcadasTest() {
		JuegoService juegoService = new JuegoService();
		Juego juego = juegoService.crearJuego();
		
		juegoService.buscarLetraOPalabraEnJuego(juego, "a");
		//palabra > plbr
		assertEquals(1, juego.getLetrasMarcadas().size());
	}
	
	@Test
	void letrasFaltantesTest() {
		JuegoService juegoService = new JuegoService();
		Juego juego = juegoService.crearJuego();
	}

}
