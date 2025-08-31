package Practica01;
import java.util.Scanner;
public class p1ej2 {

	public static void main(String[] args) {
		// Crea un objeto Scanner para leer la entrada del teclado
        Scanner scanner = new Scanner(System.in);
        Contador vec = new Contador();
 
        System.out.println("Ingrese un número entero para generar el vector:");
        int n = scanner.nextInt();
        if(n > 1) {
        	int [] v = Contador.primerosMultiplos(n);
        	for(int i=0;i<n;i++) {
        		System.out.print(v[i]+"|");
        	}
        	
        }else
        	System.out.print("Error, el valor debe ser mayor a 1!");
     // Cierra el objeto Scanner para liberar recursos
	    scanner.close();
	}

}
