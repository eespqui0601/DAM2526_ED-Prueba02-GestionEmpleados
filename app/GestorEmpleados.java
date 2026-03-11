package app;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
			//Solicitar datos necesarios para el empleado.
		}
		else if (entradaUsuario == 2) {
			//Solicitar datos necesarios para el empleado.
		}
		else {
			System.out.println("ERROR: Debes seleccionar el 1 o el 2.");
		}
	}
	
	public void listarTodos() {
		plantilla.getEmpleadosPorNombre(filtroNombre);
		listarEmpleados();
		//Obtiene todos los empleados de la plantilla y los muestra. Usa plantilla.getEmpleadosPorNombre y listarEmpleados.
	}
	
	public void listarPorFiltro() {
		//Solicita al usuario un texto de filtro. 
		//Obtiene los empleados segun el filtro.
		//Muestra los empleados.
		//Usa plantilla.getEmpleadosPorNombre y listarEmpleados.
	}
	
	public void listarEmpleados() {
		int counter;
		List<Empleado> lista = ordenarPorNombre(listaEmpleados);
		System.out.printf("%d- %s %s %.f €", counter, getNombre(), getApellidos(), getSueldo());
		//Muestra una lista de empleados.
		//Formato con el que se deben mostra: N- Nombre Apellidos Sueldo €.
	}
	
	public void ordenarPorNombre(List<Empleado> empleados) {
		Collections.sort(plantilla.getEmpleadosPorNombre(filtroNombre), Comparator.comparing(Empleado::getNombre)); //Ordenar lista de empleados alfabeticamente por nombre. 
	}

}
