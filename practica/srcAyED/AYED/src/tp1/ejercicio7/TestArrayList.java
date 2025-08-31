package tp1.ejercicio7;
import java.util.ArrayList;

import Practica01.Estudiante;
public class TestArrayList {

	public static void main(String[] args) {
		// Verificar que se hayan proporcionado argumentos
        if (args.length == 0) {
            System.out.println("Por favor, proporciona al menos un número como argumento.");
            return;
        }
		// Crear una nueva lista de tipo ArrayList
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        
     // Agregar números a la lista desde los argumentos de la línea de comandos
        
        for (String arg : args) {
            // Convertir el argumento a un número entero y agregarlo a la lista
            int numero = Integer.parseInt(arg);
            listaNumeros.add(numero);
        }

        // Imprimir el contenido de la lista
        System.out.println("Contenido de la lista:");
        for (int numero : listaNumeros) {
            System.out.println(numero);
        }
        
     // Crear una nueva lista de tipo ArrayList la cual almacenara estudiantes
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
        
        for (Estudiante estudiante : args) {
            // Convertir el argumento a un número entero y agregarlo a la lista
            Estudiante est = Estudiante.class(arg);
            listaNumeros.add(numero);
        }
    }
}