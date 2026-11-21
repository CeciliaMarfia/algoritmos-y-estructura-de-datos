package tp1.ejercicio2;

import java.util.Scanner;

public class ejercicio2 {

    // Método de clase (estático) para calcular los primeros múltiplos
    public static int[] primerosMultiplos(int n) {
        int[] vector = new int[n];
        
        // Cargar el arreglo con los múltiplos
        for (int i = 0; i < vector.length; i++) {
            vector[i] = n * (i + 1);
        }
        return vector;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // lector

        System.out.print("Ingrese el valor de n: ");
        int n = scanner.nextInt();
        
        if (n > 1) {
            int[] v = primerosMultiplos(n); // llamo al método estático
            System.out.println("------- VECTOR RESULTANTE -------");
            for (int i = 0; i < v.length; i++) {
                System.out.print(v[i]);
                if (i < v.length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println(); // Para el salto de línea al final
        } else {
            System.out.println("Error, el valor debe ser mayor a 1!");
        }

        // Cierra el objeto Scanner para liberar recursos
        scanner.close();
    }
}

