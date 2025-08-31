package tp1.ejercicio9.TestBalanceo;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class TestBalanceo {
	private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
	
	private static boolean validar(String S) {
		Stack <Character> stack = new Stack<Character>();
		for (int i = 0; i < S.length(); i++) { // hacer con while
			char car  = S.charAt(i);
			if((car == '(') | (car == '{')  | (car == '[')){
				stack.push(car);
			}else if(stack.isEmpty()){
				return false;
			}else { 
				char aux = stack.pop();
				if(!isMatchingPair(aux, car)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    System.out.print("Ingrese un String:");
		//String s = scanner.nextLine();
	    String s = "(){}[]{";
		scanner.close(); // Cierro el objeto Scanner, libero el recurso.
		if(validar(s))
			System.out.println("La expresion " + s + " esta balanceada");
		else System.out.println("La expresion " + s + " no esta balanceada");
		}
	}
