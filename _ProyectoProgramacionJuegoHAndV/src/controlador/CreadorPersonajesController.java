package controlador;

import modelo.Jugador;
import modelo.Personaje;
import modelo.PersonajeFuerza;
import modelo.PersonajeInteligencia;
import modelo.PersonajeResistencia;
import modelo.PersonajeVelocidad;
import utilidades.Leer;

/**
 * clase que controla la geston de crear jugadores al iniciar el juego
 * 
 * pide el nombre que se quiere poner el usuario
 * eleccion entre personaje con stats predeterminads o personalizar stats con los repartos
 * de puntos a cada stats
 * 
 * @author Mariano, Eder
 * @version 1.0
 */
public class CreadorPersonajesController {

	/**
	 * puntos a repartir entre las stats de personalizacion
	 */
	private static final int REPARTIR_PUNTOS = 50;

	/**
	 * puntos minimos que puede tener una stt
	 */
	private static final int MIN_PTS_STAT = 1;

	/**
	 * vida que va a tener todos los personajes personalizados
	 * 2 opciones, o añadimos mas puntos en REPARTIR_PUNTOS 
	 * o menos puntos a repartir y dejamos la vida fija
	 */
	private static final double VIDA_CUSTOM = 100.0;

	/**
	 * metodo para crear el jugador, pide:
	 * nombre
	 * muestra opciones
	 * crea el jugador
	 * devuelve el jugador creado al completo
	 * 
	 * 
	 */
	public Jugador crearJugador() {

		//mensaje de bienvenida + pedir nombre
		String nombre = Leer.leerFrase("----BIENVENIDOS A H & V---- \n¿como quieres que se"
				+ " llame tu personaje del juego?");

		System.out.println("hola " + nombre + ", ahora que elige tu tipo de personaje");

		//elegir el tipo de personaje
		//creamos un array de Strings para poner el tipo de personaje
		String[] menuTipo = {
				"salir", //0
				"personaje predeterminado", //1
				"crear personaje" //2
		};

		int opcionTipo;

		//bucle
		do {
			System.out.println("¿que tipo de personaje quieres?");

			//recorremos el array
			for (int i = 1; i < menuTipo.length; i++) {
				System.out.println(i + ". " + menuTipo[i]);
			}

			opcionTipo = Leer.leerEntero("elige una opcion: ");
		} while (opcionTipo != 1 && opcionTipo != 2);

		//crear personaje 
		Personaje personaje;

		//que opcion quiere el jugador
		if (opcionTipo == 1) {
			//personaje predeterminadp
			personaje = elegirPersonajePredeterminado();

		} else {
			//personaje custom
			personaje = elegirPersonajeCustom();
		}

		//crear el personaje y devolver el jugador
		//nombre y personaje creados

		Jugador jugador = new Jugador(nombre, personaje, jugador.getMonedas());

		System.out.println("--PERSONAJE CREADO--");
		return jugador;	
	}

	/**
	 * metodo personaje predefinido 
	 */
	private Personaje elegirPersonajePredefinido() {
		System.out.println("PERSONAJES PREDEFINIDOS");

		System.out.println("1. tipo fuerza");
		System.out.println("2. tipo inteligencia");
		System.out.println("3. tipo resistencia");
		System.out.println("4. tipo velocidad");

		int opcion;

		//bucle hasta que elija uno de los 4
		do {

			opcion = Leer.leerEntero("elige tu personaje (1-4");

		} while (opcion < 1 || opcion > 4);

		switch(opcion) {
		case 1: 
			//eleccion personaje fuerza
			System.out.println("has elegido de tipo fuerza");
			return new PersonajeFuerza();

		case 2:
			//eleccion personaje inteligencia
			System.out.println("has elegido tipo inteligencia");
			return new PersonajeInteligencia();

		case 3:
			//eleccion personaje resistencia
			System.out.println("has elegido tipo resistencia");
			return new PersonajeResistencia();

		case 4: 
			//eleccion velocidad
			System.out.println("has elegido tipo velocidad");
			return new PersonajeVelocidad();

		default:
			System.out.println("opcion no valida");
		}

	}
	

	/**
	 * permite crear un personaje con caracterisiticas custom
	 * 
	 */
	private Personaje elegirPersonajeCustom() {
		System.out.println("--CREA TU PERSONAJE--");
		
	}


}
