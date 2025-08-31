package Practica01;
import java.util.Scanner;
public class p1e1 {

	public static void main(String[] args) {
		 // Crea un objeto Scanner para leer la entrada del teclado
        Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese el primer valor: ");
		int valor1= scanner.nextInt();
		System.out.print("Ingrese el segundo valor: ");
		int valor2= scanner.nextInt();
		
			System.out.println("-> con For:");
			hacerConFor(valor1, valor2);
			System.out.println("----------------------------------");
			System.out.println("-> con while:");
			hacerConWhile(valor1, valor2);
			System.out.println("----------------------------------");
			System.out.println("-> con Recursión:");
			hacerRecursivo(valor1, valor2);
			
			// Cierra el objeto Scanner para liberar recursos
		    scanner.close();
	}
	
	public static void hacerConFor(int a, int b) {
		if (a <= b) {
			for (int i = a; i <= b; i++) {
	            System.out.println(i);
	        }
		}else
			System.out.println("Rango incorrecto!");
	}

	public static void hacerConWhile(int a, int b) {
		if (a <= b) {
			int i = a;
			while (i<= b) {
	            System.out.println(i);
	            i++;
	        }
		}else
			System.out.println("Rango incorrecto!");
	}
	
	public static void hacerRecursivo(int a, int b) {
		if (a <= b) {
			System.out.println(a);
			hacerRecursivo(a+1, b);
	   }
		else 
			System.out.println("Rango incorrecto!");
		
	}

	 
}
