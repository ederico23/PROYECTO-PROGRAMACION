package vista;

import utilidades.Leer;

public class CrearMenuPrueba {
	public static void main(String[] args) {
		int opcion;
		String[] menu= {"Salir","Introducir mensaje","Mostrar mensaje",
				"Mostrar palabras del mensaje","Contar palabras clave",
				"Ejecutar proceso completo"};
		do {
			opcion=mostrarMenu(menu);
			switch(opcion) {
			case 1: //Introducir mensaje
				break;
			case 2: //Mostrar mensaje
				break;
			case 3: //Mostrar palabras del mensaje
				break;
			case 4: //Contar palabras clave
				break;
			case 5: //Ejecutar proceso completo
				
			}//fin-switch
			
		}while (opcion!=0);
		System.out.println("FIN PROGRAMA");
		
	}//fin-main
	
	public static int mostrarMenu(String[] menu) {
		int opcion;
		do {
			System.out.println("MENÚ");
			for(int i=1;i<menu.length;i++){
				System.out.println(i+". "+menu[i]);
			}
			System.out.println(0+". "+menu[0]);
			opcion=Leer.leerEntero("");
		}while(opcion<0||opcion>=menu.length);
		return opcion;
	}//fin-mostrarMenu
	
}//fin-class

