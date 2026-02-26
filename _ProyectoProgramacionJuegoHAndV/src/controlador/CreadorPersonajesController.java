package controlador;


import modelo.Jugador;
import modelo.Personaje;
import modelo.PersonajeFuerza;
import modelo.PersonajeInteligencia;
import modelo.PersonajePersonalizado;
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
	 * puntos minimos que puede tener una stat
	 */
	private static final int MIN_PTS_STAT = 2;

	/**
	 * monedas que tiene el jugador al empezar
	 */
	private static final int MONEDAS_INICIALES = 100;

	/**
	 * vida que va a tener todos los personajes personalizados
	 */
	private static final double VIDA_CUSTOM = 100.0;

	/**
	 * metodo para crear el jugador, pide:
	 * nombre
	 * muestra opciones
	 * crea el jugador
	 * devuelve el jugador creado al completo
	 */
	public Jugador crearJugador() {

		// mensaje de bienvenida + pedir nombre
		String nombre = Leer.leerFrase("----BIENVENIDOS A H & V---- \n¿como quieres que se"
				+ " llame tu personaje del juego?");

		System.out.println("hola " + nombre + ", ahora que elige tu tipo de personaje");

		// elegir el tipo de personaje
		// creamos un array de Strings para poner el tipo de personaje
		String[] menuTipo = {
				"salir",               // 0
				"personaje predeterminado", // 1
				"crear personaje"       // 2
		};

		int opcionTipo;

		// bucle
		do {
			System.out.println("¿que tipo de personaje quieres?");

			// recorremos el array desde 1 (el 0 es salir)
			for (int i = 0; i < menuTipo.length; i++) {
				System.out.println(i + ". " + menuTipo[i]);
			}

			opcionTipo = Leer.leerEntero("elige una opcion: ");
		} while (opcionTipo != 0 && opcionTipo != 1 && opcionTipo != 2);

		// crear personaje
		Personaje personaje;

		// que opcion quiere el jugador
		if (opcionTipo == 1) {
			// personaje predeterminado
			
			personaje = elegirPersonajePredefinido();
			Jugador jugador = new Jugador(nombre, personaje, MONEDAS_INICIALES);

			System.out.println("--PERSONAJE CREADO--");
			System.out.println(jugador);
			return jugador;

		} else if (opcionTipo == 2){
			// personaje custom
			personaje = elegirPersonajeCustom();
			Jugador jugador = new Jugador(nombre, personaje, MONEDAS_INICIALES);

			System.out.println("--PERSONAJE CREADO--");
			System.out.println(jugador);
			return jugador;
		}else {
			System.out.println("Has salido del juego");
			return null;
		}	
	}

	/**
	 * metodo personaje predefinido
	 * 
	 * @return Personaje elegido por el usuario
	 */
	private Personaje elegirPersonajePredefinido() {
		System.out.println("PERSONAJES PREDEFINIDOS");

		System.out.println("1. tipo fuerza");
		System.out.println("2. tipo inteligencia");
		System.out.println("3. tipo resistencia");
		System.out.println("4. tipo velocidad");

		int opcion;

		// bucle hasta que elija uno de los 4
		do {
			
			opcion = Leer.leerEntero("elige tu personaje (1-4):");

		} while (opcion < 1 || opcion > 4);

		switch (opcion) {
		case 1:
			System.out.println("has elegido de tipo fuerza");
			return new PersonajeFuerza();

		case 2:
			System.out.println("has elegido tipo inteligencia");
			return new PersonajeInteligencia();

		case 3:
			System.out.println("has elegido tipo resistencia");
			return new PersonajeResistencia();

		case 4:
			System.out.println("has elegido tipo velocidad");
			return new PersonajeVelocidad();

		default:
		
			System.out.println("opcion no valida, asignando fuerza por defecto");
			return new PersonajeFuerza();
		}
	}

	/**
	 * permite crear un personaje con caracterisiticas custom
	 * 
	 * @return Personaje con las stats elegidas por el usuario
	 */
	private Personaje elegirPersonajeCustom() {
		System.out.println("--CREA TU PERSONAJE--");

		System.out.println("tienes " + REPARTIR_PUNTOS + " puntos a repartir entre tus stats");
		System.out.println("cada stat tiene que tener minimo " + MIN_PTS_STAT + " punto");
		System.out.println("al crearlo custom tienes " + VIDA_CUSTOM + " HP");

		// variable que cuenta los puntos que le quedan al usuario
		int puntosRestantes = REPARTIR_PUNTOS;

		// variables para cada stat
		double statAtaque = 0;
		double statDefensa = 0;
		double statInteligencia = 0;
		double statFuerza = 0;
		double statVelocidad = 0;
		double statResistencia = 0;

		// array con los nombres de las stats
		String[] nombresStats = {
				"ataque",       // 0
				"defensa",      // 1
				"inteligencia", // 2
				"fuerza",       // 3
				"velocidad",    // 4
				"resistencia"   // 5
		};

		// array para guardar los valores que elija el usuario
		double[] valoresStats = new double[6];

		// recorremos las 6 stats
		for (int i = 0; i < nombresStats.length; i++) {

			// numero de stats que quedan DESPUES de esta (no contando la actual)
			int statsRestantes = nombresStats.length - 1 - i;

			int maxAsignar = puntosRestantes - (statsRestantes * MIN_PTS_STAT);

			// guarda los pts que asigna a una stat
			int puntosAsignados;

			do {
				// muestra cuantos pts quedan
				System.out.println("puntos restantes: " + puntosRestantes);
				System.out.println("stats restantes: " + (statsRestantes + 1) + " incluyendo esta");

				// pedir los puntos para esta stat
				puntosAsignados = Leer.leerEntero("puntos para " + nombresStats[i]
						+ " (min: " + MIN_PTS_STAT + ", max: " + maxAsignar + "):");

				// si el valor no es valido se repite el bucle
				if (puntosAsignados < MIN_PTS_STAT || puntosAsignados > maxAsignar) {
					System.out.println("valor no valido, introduce un valor entre: "
							+ MIN_PTS_STAT + " y " + maxAsignar);
				}

			} while (puntosAsignados < MIN_PTS_STAT || puntosAsignados > maxAsignar);

			// guardamos el valor en el array en la posicion i, casteado a double
			valoresStats[i] = (double) puntosAsignados;

			// restamos los puntos usados del disponible
			puntosRestantes -= puntosAsignados;

			// confirmacion
			System.out.println(nombresStats[i] + " -> " + puntosAsignados + " puntos");
		}

		// asignar variables desde el array
		statAtaque       = valoresStats[0];
		statDefensa      = valoresStats[1];
		statInteligencia = valoresStats[2];
		statFuerza       = valoresStats[3];
		statVelocidad    = valoresStats[4];
		statResistencia  = valoresStats[5];

		// resumen de las stats
		System.out.println("----RESUMEN DE TU PERSONAJE----");
		System.out.println("vida : " + VIDA_CUSTOM);

		for (int i = 0; i < nombresStats.length; i++) {
			System.out.println(nombresStats[i] + ": " + valoresStats[i]);
		}

		// creamos y devolvemos el personaje custom
		return new PersonajePersonalizado(
				VIDA_CUSTOM,
				statAtaque,
				statDefensa,
				statInteligencia,
				statFuerza,
				statVelocidad,
				statResistencia
				);
	}
}