package Practica01;
public class Contador {
/*
 Escriba un método de clase que dado un número n devuelva un nuevo arreglo de tamaño n
 con los n primeros múltiplos enteros de n mayores o iguales que 1.
Ejemplo: f(5) = [5; 10; 15; 20; 25]; f(k) = {n*k donde k : 1..k}
*/
public static int[] primerosMultiplos(int n) {
	// Creo un arreglo para almacenar los multiplos de n
    int[] vector = new int[n];
 // Llenar el arreglo con los n primeros múltiplos de n
    for (int i = 0; i < vector.length; i++) {
    	vector[i] = (i + 1) * n;
    }

    return vector; 
}
}
