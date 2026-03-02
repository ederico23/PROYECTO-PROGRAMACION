package vista;

import modelo.Jugador;
/**
 * Clase para imprimir mensajes, mostrar menu y mostrar el inventario
 * @author Mariano, Eder
 * @version 1.0
 */
public interface JuegoVista {
	public void mostrarMensaje(String mensaje);
	public int mostrarMenu (String[] menu, String jugadorAjugar);
	public void mostrarInventario(Jugador jugador);
}
