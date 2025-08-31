package tp2.ejercicio6;
import tp1.ejercicio8.*;
import tp2.ejercicio1.*;
/*
 Cree una clase Java llamada Transformacion que tenga como variable de instancia un árbol
binario de números enteros y un método de instancia suma (): BinaryTree<Integer> el cuál
devuelve el árbol en el que se reemplazó el valor de cada nodo por la suma de todos los
elementos presentes en su subárbol izquierdo y derecho. Asuma que los valores de los subárboles
vacíos son ceros.*/

public class Transformacion {
	private BinaryTree<Integer> arbol;
	
	
	public Transformacion(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}

	public BinaryTree<Integer> suma(){
		 if (this.arbol != null && !this.arbol.isEmpty()) {
			 return sumaRec(this.arbol);
		}else
			return null;
	}
	
	private BinaryTree<Integer>  sumaRec(BinaryTree<Integer> nodo) {
		BinaryTree<Integer> nuevoNodo = new BinaryTree<Integer>(); //instancio el nuevo nodo
		
		if(nodo.isLeaf()) {
			nuevoNodo.setData(0);
			
		}else {
			BinaryTree<Integer>  aux;
			int suma = 0;
			if(nodo.hasLeftChild()) {
				aux = sumaRec(nodo.getLeftChild());
				nuevoNodo.addLeftChild(aux);
				suma+= nodo.getLeftChild().getData();
			}
			if(nodo.hasRightChild()) {
				aux = sumaRec(nodo.getRightChild());
				nuevoNodo.addRightChild(aux);
				suma+= nodo.getRightChild().getData();
			}
			nuevoNodo.setData(suma);
			
		}return nuevoNodo;
	}
}
	