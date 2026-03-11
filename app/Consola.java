package app;

import java.util.Scanner;

public class Consola implements EntradaSalida{
	
	private Scanner sc = new Scanner(System.in);
	
	public Consola() {
		
	}
	
	public void imprimir(String texto) {
		System.out.print(texto);
	}
	
	public void imprimirLinea(String texto) {
		System.out.println(texto);
	}
	
	public String leerTexto(String mensaje) {
		System.out.println(mensaje);
		String entradaUsuario = sc.nextLine();
		//Capturar excepcion y mostrar mensaje de error. 
		return entradaUsuario;
	}
	
	public int leerEntero(String mensaje) {
		System.out.println(mensaje);
		int entradaUsuario = sc.nextInt();
		//Capturarar excepcion y mostrar mensaje de error.
		return entradaUsuario;
	}
	
	public double leerImporte(String mensaje) {
		System.out.println(mensaje);
		double entradaUsuario = sc.nextDouble();
		//Debe permitir tanto coma como punto como separador decimal.
		//Si el formato no es valido debe mostrar un mensaje de rror y volver a pedirle el dato al usuario. 
		return entradaUsuario;
	}
	
	public void mostrarMenu() {
		System.out.println("1- Contratar empleado ");
		System.out.println("2- Listar todos los empleados ");
		System.out.println("3- Listar empleados con filtro ");
		System.out.println("4- Salir");
		
	}
	
	public void limpiarPantalla() {
		int counter = 0;
		while(counter <= 50) {
			counter++;
			System.out.println(" ");
		}
	}
	
	public void pausa() {
		System.out.println("Pulse una tecla para continuar...");
		//Detener ejecucion del programa hasta que el usuario pulse una tecla.
	}
	
}
