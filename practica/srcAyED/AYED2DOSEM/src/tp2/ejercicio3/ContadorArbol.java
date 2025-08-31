package tp2.ejercicio3;
import tp2.ejercicio1.*;
import java.util.*;
/*
 Defina una clase Java denominada ContadorArbol 
 cuya función principal es proveer métodos de validación sobre árboles binarios
  de enteros. Para ello la clase tiene como variable de instancia un 
  BinaryTree<Integer>. Implemente en dicha clase un método denominado numerosPares() 
  que devuelve en una estructura adecuada (sin ningún criterio de orden) 
  todos los elementos pares del árbol (divisibles por 2).
  
a) Implemente el método realizando un recorrido InOrden. 
b) Implemente el método realizando un recorrido PostOrden.
 */
public class ContadorArbol {
	private BinaryTree<Integer> arbol;
	
	public LinkedList<Integer> numerosPares() {
		LinkedList<Integer> numeros = new LinkedList<Integer>(); //declaro la nueva lista
		if (this.arbol != null && !this.arbol.isEmpty()) {
			numerosParesRec(this.arbol,numeros);//este es el helper
			numerosParesRec2(this.arbol,numeros);
		}
		return numeros;
		}
		
	private void numerosParesRec(BinaryTree<Integer> nodo, LinkedList<Integer> numeros) {  //los auxiliares siempre son privados
		if (nodo == null || nodo.isEmpty()) {
			return; //es el caso base, se terminó el arbol
		}
		if (nodo.hasLeftChild()) {
			numerosParesRec(nodo.getLeftChild(), numeros); //proceso HI
		}
		if(nodo.getData() %2 == 0) { //con esto queda la raíz procesada
			numeros.add(nodo.getData());
		}
		if (nodo.hasRightChild()) {
			numerosParesRec(nodo.getRightChild(), numeros); //proceso HD
		}
	}
	
	private void numerosParesRec2(BinaryTree<Integer> nodo, LinkedList<Integer> numeros) {  //los auxiliares siempre son privados
		if (nodo == null || nodo.isEmpty()) {
			return; //es el caso base, se terminó el arbol
		}
		if (nodo.hasLeftChild()) {
			numerosParesRec2(nodo.getLeftChild(), numeros); //proceso HI
		}
		if (nodo.hasRightChild()) {
			numerosParesRec2(nodo.getRightChild(), numeros); //proceso HD
		}
		
		if(nodo.getData() %2 == 0) { //con esto queda la raíz procesada
			numeros.add(nodo.getData());
		}
	}
}
