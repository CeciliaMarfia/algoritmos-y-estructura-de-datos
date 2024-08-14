package tp1.ejercicio3;

public class Test {

	public static void main(String[] args) {
	Estudiante [] vEstudiantes = new Estudiante[2]; 
	vEstudiantes[0]= new Estudiante();
	vEstudiantes[0].setNombre("Sol Justina");
	vEstudiantes[0].setApellido("Arroyo Tabari");
	vEstudiantes[0].setComision("TM");
	vEstudiantes[0].setEmail("stabari@mail.com");
	vEstudiantes[0].setDireccion("P. Sherman calle Wallaby 42, Sydney");
	
	vEstudiantes[1]= new Estudiante();
	vEstudiantes[1].setNombre("Cecilia");
	vEstudiantes[1].setApellido("Marfia");
	vEstudiantes[1].setComision("TM");
	vEstudiantes[1].setEmail("cmarfia@mail.com");
	vEstudiantes[1].setDireccion("Avenida siempreviva 742");
	
	Profesor [] vProfesores = new Profesor[3];
	vProfesores[0] = new Profesor();
	vProfesores[0].setNombre("Laura");
	vProfesores[0].setApellido("Fava");
	vProfesores[0].setEmail("lfava@mail.com");
	vProfesores[0].setCatedra("AyED");
	vProfesores[0].setFacultad("Informática");
			
	vProfesores[1] = new Profesor();
	vProfesores[1].setNombre("Rodolfo");
	vProfesores[1].setApellido("Bertone");
	vProfesores[1].setEmail("rbertone@mail.com");
	vProfesores[1].setCatedra("FOD");
	vProfesores[1].setFacultad("Informática");
	
	vProfesores[2] = new Profesor();
	vProfesores[2].setNombre("Sofía");
	vProfesores[2].setApellido("Martín");
	vProfesores[2].setEmail("smartin@mail.com");
	vProfesores[2].setCatedra("Seminario de lenguajes: Python");
	vProfesores[2].setFacultad("Informática");
	
	//Imprimo lxs Estudiantes
	System.out.println("** ESTUDIANTES **");
	for(int i=0; i<vEstudiantes.length;i++) {
		System.out.println(vEstudiantes[i].tusDatos());
		System.out.println("");
	}
	System.out.println("---------------------------------------");
	//Imprimo lxs Profesores
	System.out.println("** PROFESORES **");
	for(int i=0; i<vProfesores.length;i++) {
		System.out.println(vProfesores[i].tusDatos());
		System.out.println("");
	}
	
	}
}
	
	
