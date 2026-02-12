package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Clase de utilidad para introducir tipos de valores por teclado 
 * @author Mariano
 * @version 1.1 - 26/01/2026
 */
public class Leer {
	/**
	 * Atributo de Scanner para inicializar
	 */
	public static Scanner sc = new Scanner(System.in);
	
	/**
	 * Metodo estatico para introducir una frase por teclado 
	 * @param mensaje a introducir para establecer instrucciones al usuario
	 * @return un valor de tipo String
	 */
	public static String leerFrase(String mensaje) {
		boolean controlValor = false;
		do {
			try {
				System.out.println(mensaje);
				String s = sc.nextLine();
				controlValor = true;
				return s;
			} catch(Exception e) {
				System.out.println("Ha ocurrido un error");
				controlValor = false;
				sc.nextLine();
			}
		} while (!controlValor);
		return "";
	}
	/**
	 * Metodo estatico para introducir un valor entero por teclado 
	 * @param mensaje a introducir para establecer instrucciones al usuario
	 * @return un valor de tipo entero
	 */
	public static int leerEntero(String mensaje) {
		boolean controlValor = false;
		do {
			try {
				System.out.println(mensaje);
				int n = sc.nextInt();
				sc.nextLine();
				controlValor = true;
				return n;
			} catch(NumberFormatException e) {
				System.out.println("No has introducido un valor numerico");
				controlValor = false;
				sc.nextLine();
			} catch(InputMismatchException e) {
				System.out.println("No has introducido un valor entero");
				controlValor = false;
				sc.nextLine();
			}
		} while (!controlValor);
		return 0;
	}
	/**
	 * Metodo estatico para introducir un valor decimal por teclado 
	 * @param mensaje a introducir para establecer instrucciones al usuario
	 * @return un valor de tipo decimal
	 */
	public static double leerDouble(String mensaje) {
		boolean controlValor = false;
		do {
			try {
				System.out.println(mensaje);
				double d = sc.nextDouble();
				controlValor = true;
				sc.nextLine();
				return d;
			} catch(NumberFormatException e) {
				System.out.println("No has introducido un valor numerico");
				controlValor = false;
				sc.nextLine();
			} catch(InputMismatchException e) {
				System.out.println("No has introducido un valor decimal");
				controlValor = false;
				sc.nextLine();
			}
		} while (!controlValor);
		return 0.0;
	}
	/**
	 * Metodo estatico para introducir un valor booleano por teclado 
	 * @param mensaje a introducir para establecer instrucciones al usuario
	 * @return un valor de tipo booleano
	 */
	public static boolean leerBoolean(String mensaje) {
		boolean controlValor = false;
		do {
			try {
				System.out.println(mensaje);
				boolean d = sc.nextBoolean();
				controlValor = true;
				sc.nextLine();
				return d;
			} catch(InputMismatchException e) {
				System.out.println("No has introducido un valor booleano");
				controlValor = false;
				sc.nextLine();
			}
		} while (!controlValor);
		return false;
	}
	/**
	 * Metodo para cerrar el escaner
	 */
	public static void cerrarScanner() {
		sc.close();
	}
}
