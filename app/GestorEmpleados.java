package app;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GestorEmpleados {
	
	private Plantilla plantilla;
	private EntradaSalida consola;
	
	public GestorEmpleados(Plantilla plantilla, EntradaSalida consola) {
		this.plantilla = plantilla;
		this.consola = consola;
	}
	
	public void ejecutar() {
		boolean salir = false;
		while(salir = false) {
			consola.mostrarMenu();
			consola.pausa();
			int entradaUsuario = consola.leerEntero("Seleccione una de las opciones introduciendo el numero correspondiente: ");
			if (entradaUsuario == 1) {
				consola.limpiarPantalla();
				contratarEmpleado();
			} 
			else if (entradaUsuario == 2) {
				consola.limpiarPantalla();
				listarTodos();
			}
			else if (entradaUsuario == 3) {
				consola.limpiarPantalla();
				listarPorFiltro();
			}
			else if (entradaUsuario == 4) {
				consola.limpiarPantalla();
				salir = true;
			}
			else {
				System.out.println("ERROR: debes introducir un numero del 1 al 4.");
			}
		}
	}
	
	public void contratarEmpleado() {
		System.out.println("Seleccione el tipo de empleado: \n1- Tecnico \n2- Comercial");
		consola.pausa();
		int entradaUsuario = consola.leerEntero("Seleccione una de las opciones introduciendo el numero correspondiente: ");
		if(entradaUsuario == 1) {
			String dni = consola.leerTexto("Introduzca el dni: ");
			String nombre = consola.leerTexto("Introduzca el nombre: ");
			String apellidos = consola.leerTexto("Introduzca el apellido: ");
			double sueldo = consola.leerImporte("Introduzca el sueldo: ");
			int categoria = consola.leerEntero("Introduzca la categoria: ");
			Tecnico tecnico = new Tecnico(dni, nombre, apellidos, sueldo, categoria);
		}
		else if (entradaUsuario == 2) {
			String dni = consola.leerTexto("Introduzca el dni: ");
			String nombre = consola.leerTexto("Introduzca el nombre: ");
			String apellidos = consola.leerTexto("Introduzca el apellido: ");
			double sueldo = consola.leerImporte("Introduzca el sueldo: ");
			double ventas = consola.leerImporte("Introduzca el numero de ventas: ");
			Comercial comercial = new Comercial(dni, nombre, apellidos, sueldo, ventas); 
		}
		else {
			consola.imprimir("ERROR: Debes seleccionar el 1 o el 2.");
		}
	}
	
	public void listarTodos() {
		String entradaUsuario = consola.leerTexto("Introduzca el filtro por el que quiere buscar los empleados: "); //Solicita al usuario un texto de filtro.
		listarEmpleados(plantilla.getEmpleadosPorNombre(entradaUsuario)); //Obtiene todos los empleados de la plantilla y los muestra.
	}
	
	public void listarPorFiltro() { 
		String entradaUsuario = consola.leerTexto("Introduzca el filtro por el que quiere buscar los empleados: "); //Solicita al usuario un texto de filtro.
		listarEmpleados(plantilla.getEmpleadosPorNombre(entradaUsuario)); //Obtiene los empleados segun el filtro y los muestra. 
	}
	
	public void listarEmpleados(List<Empleado> empleados) {
		int counter = 0;
		ordenarPorNombre(empleados);
		ListIterator<Empleado> iterator = empleados.listIterator();
		while(iterator.hasNext()) {
			counter++;
			String nombre = iterator.next().getNombre();
			String apellido = iterator.previous().getApellidos();
			double sueldo = iterator.next().getSueldo();
			System.out.printf("%d- %s %s %.2f €", counter, nombre, apellido, sueldo);
		}
		//Muestra una lista de empleados.
		//Formato con el que se deben mostrar: N- Nombre Apellidos Sueldo €.
	}
	
	public void ordenarPorNombre(List<Empleado> empleados) {
		String entradaUsuario = consola.leerTexto("Introduzca el filtro por el que quiere buscar los empleados: ");  //Solicita al usuario un texto de filtro.
		Collections.sort(plantilla.getEmpleadosPorNombre(entradaUsuario), Comparator.comparing(Empleado::getNombre)); //Ordenar lista de empleados alfabeticamente por nombre. 
	}

}
