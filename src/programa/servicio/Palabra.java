package programa.servicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palabra {

	private static final List<String> palabrasDificultadNormal = new ArrayList<String>(
			Arrays.asList("PERRO", "GATO", "IGLESIA", "ESCUELA", "GRAFO", "CONEXO", "ARISTA", "ARBOL", "JAVA"));

	private static final List<String> palabrasDificultadDificil = new ArrayList<String>(
			Arrays.asList("DINOSAURIO", "UNIVERSIDAD", "ORANGUTAN", "MURCIELAGO", "ESCALERA", "ESQUELETO", "TECLADO",
					"COMPLEJIDAD", "PROGRAMACION"));

	public static List<String> getPalabrasDificultadNormal() {
		return palabrasDificultadNormal;
	}

	public static List<String> getPalabrasDificultadDificil() {
		return palabrasDificultadDificil;
	}

}
