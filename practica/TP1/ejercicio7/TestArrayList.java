package tp1.ejercicio7;

import java.util.*;
import java.util.ArrayList; // import the ArrayList class
import tp1.ejercicio7.Estudiante;


public class TestArrayList {
	
	public static void acciones() {
		ArrayList<Estudiante> estudiante = new ArrayList<Estudiante>();
		ArrayList<Estudiante> estudiante2 = new ArrayList<Estudiante>();
		Estudiante [] vEstudiantes = new Estudiante[3];
		
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
		
		vEstudiantes[2]= new Estudiante();
		vEstudiantes[2].setNombre("Paul");
		vEstudiantes[2].setApellido("Andreatta");
		vEstudiantes[2].setComision("TM");
		vEstudiantes[2].setEmail("pandreatta@mail.com");
		vEstudiantes[2].setDireccion("Calle Sicardi");
		
		for (int i=0; i<3; i++) {
			estudiante.add(vEstudiantes[i]);
		}
		
		//estudiante2.addAll(estudiante); //hace una copia de la ArrayList estudiante pero se referencia a lo otro 
		
		for (Estudiante est : estudiante) {
			estudiante2.add(new Estudiante(est.getNombre()
					, est.getApellido(), est.getComision(), est.getEmail(), est.getDireccion()));
		} //acá instancio otro a partir de la original

		System.out.println(estudiante2);
		
		imprimir(estudiante,estudiante2);
		
		estudiante2.get(1).setNombre("Chechu");
		System.out.println("******** Modificando el nombre: *********");
		
		imprimir(estudiante,estudiante2);
		
		//System.out.println("Ingrese el nuevo alumno a incorporar:");
		Estudiante student = new Estudiante("Lautaro Tomás", "Budini", "TN","lbudini@mail.com","Varela City 456");
		
		if (existe(estudiante, student)) {
			System.out.println("Existe el alumno!");
		}else {
			System.out.println("No existe el alumno!");
			estudiante.add(student);
		}
		imprimir(estudiante,new ArrayList<Estudiante>());// creo una lista vacía porque no quiero que me imprima la copia
	}
	
	public static void imprimir(List<Estudiante> estudiante, List<Estudiante> estudiante2) {
		System.out.println("Lista original:");
		for(Estudiante est: estudiante)
			System.out.println(est.tusDatos());
			System.out.println(" ");

	
		System.out.println("Lista COPIA:");
		for(Estudiante est2: estudiante2)
			System.out.println(est2.tusDatos());
			System.out.println(" ");
	}
	
	public static boolean existe(List<Estudiante> estudiante,Estudiante student) {
		boolean esta = false;
		for (Estudiante est : estudiante) {
			if (est.equals(student)) {
				esta = true;
				break;// para no seguir iterando si ya lo encontré
			}
		}
		return esta;
	}
	
	public static boolean esCapicua(ArrayList<Integer> num) {
		boolean okCapicua = true;
		for(int i = 0; i < num.size()/2; i++) {
			if(num.get(i) != num.get(num.size()-1-i)) {
				okCapicua = false;
				break;
			}
		}
		return okCapicua;
	} //ver opcion con while
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		ArrayList<Integer> numbers = new ArrayList<Integer>(); // Create an ArrayList object
		for (String i : args) {// string porque el main recibe strings 
			numbers.add(Integer.parseInt(i));// parseint para castearlos
		}
		for (int i : numbers) {
			System.out.println(i); //imprimo iterando sobre cada elemtno 
		}
		//System.out.println(numbers);
		acciones();
		
		if(esCapicua(numbers)) {
			System.out.println("Es capicua!");
		}else {
			System.out.println("No es capicua!");
		}
	}
}
