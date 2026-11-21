package tp1.ejercicio7;
import java.util.*;
import java.util.Scanner;

public class EjercicioSucesion {

	
	public static ArrayList<Integer>calcularSucesion(int num){
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(num);
		if (num ==  1){
			return  numbers;
		}
		if((num % 2) == 0) {
			numbers.addAll(calcularSucesion(num / 2));
            return numbers;
        } else {
        	numbers.addAll(calcularSucesion(3 * num + 1));
            return numbers;
        }
	}
	
	public static void invertirArrayList(ArrayList<Integer> numbers) {
		invertirArrayListRecursivo(numbers,0,numbers.size()-1);
	}
	
	private static void invertirArrayListRecursivo(ArrayList<Integer> numbers,int start,int end) {
		if (start > end) {
			for (int i: numbers){
				System.out.print(i + " ");
			}
		}else {
			int aux = numbers.get(start);
			numbers.set(start, numbers.get(end));
			numbers.set(end, aux);
			invertirArrayListRecursivo(numbers,start+1, end-1);
			}
	}
	public int sumarLinkedList(LinkedList<Integer> numbers) {
		return sumarLinkedListRecursivo(numbers,numbers.size()-1);
		
	}
	
	private static int sumarLinkedListRecursivo(LinkedList<Integer> numbers,int indice){
		if(indice < 0) {
			return 0;
		}else {
			return numbers.get(indice) + sumarLinkedListRecursivo(numbers,indice-1);
		}
	}
	
	//public  ArrayList<Integer> combinarOrdenado(ArrayList<Integer> numbers1,ArrayList<Integer> numbers2){
		
//	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese un número:");
		int num = scanner.nextInt();
		
		ArrayList<Integer> numbers = calcularSucesion(num);
		for (int i : numbers) {
            System.out.print(i + " ");
        }
		System.out.println("");
		invertirArrayList(numbers);
		
		LinkedList<Integer> numbers2 = new LinkedList<>(numbers);
		System.out.println("Total: "+ sumarLinkedList(numbers2));
		  scanner.close();
	}

}
