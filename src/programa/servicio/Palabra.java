package programa.servicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palabra {

	private static final List<String> palabrasDificultadNormal = new ArrayList<String>(
			Arrays.asList("PERRO", "GATO", "IGLESIA", "ESCUELA", "GRAFO", "CONEXO", "ARISTA", "ARBOL", "JAVA"));

	private static final List<String> palabrasDificultadDificil = new ArrayList<String>(
			Arrays.asList("DINOSAURIO", "UNIVERSIDAD", "ORANGUTAN", "MURCIELAGO", "ESCALERA", "ESQUELETO", "TECLADO",
					"COMPLEJIDAD", "PROGRAMACION", "DESARROLLADOR", "INGENIERIA"));
	
	private static final List<String> palabrasDificultadNormalIngles = new ArrayList<String>(
			Arrays.asList("DOG", "CAT", "BAT", "CHURCH", "SCHOOL", "GRAPH", "RELATED", "EDGE", "TREE", "JAVA"));
	
	private static final List<String> palabrasDificultadDificilIngles = new ArrayList<String>(
			Arrays.asList("DINOSAUR", "COLLEGE", "SKELETON", "COMPLEXITY", "PROGRAMMING", "KEYBOARD", "DEVELOPER", "ENGINEERING"));
	
	private static final List<String> palabrasTest = new ArrayList<String>(Arrays.asList("PALABRA"));

	public static List<String> getPalabrasDificultadNormal() {
		return palabrasDificultadNormal;
	}

	public static List<String> getPalabrasDificultadDificil() {
		return palabrasDificultadDificil;
	}
	
	public static List<String> getPalabrasDificultadNormalIngles() {
		return palabrasDificultadNormalIngles;
	}
	public static List<String> getPalabrasDificultadDificilIngles() {
		return palabrasDificultadDificilIngles;
	}
	
	public static List<String> getPalabrasTest() {
		return palabrasTest;
	}

}
