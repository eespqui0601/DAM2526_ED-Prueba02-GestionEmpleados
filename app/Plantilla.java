package app;

import java.util.List;

public class Plantilla {
	
	List<Empleado> empleados;
	
	public Plantilla() {
		
	}
	
	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
	public List<Empleado> getEmpleadosPorNombre(String filtroNombre) {
		List<Empleado> lista = empleados;
		if (filtroNombre == "") {
			return lista;
		} else {
			//Devolver lista de empleados cuyo nombre o apellidos contiene el texto indicado.
			//Se ignoran mayusculas y minusculas.
			return lista;
		}
	}

}
