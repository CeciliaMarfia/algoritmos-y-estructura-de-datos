package tp2.ejercicio5;

import tp2.ejercicio4.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> BT;

	
	//CONSTRUCTOR
	public ProfundidadDeArbolBinario(BinaryTree<Integer> BT) {
		this.BT = BT;
	}
	
	//le envio la profundidad como argumento
	public int sumaElementosProfundidad (int p) {
		// inicio en 0 la suma
		int suma = 0;
		int nivel = 0;
		sumaRecursivaProfundidad(this.BT,p,nivel,suma);
		return suma;
	}
	private void sumaRecursivaProfundidad(BinaryTree<Integer> nodo, int p, int nivel, int suma) {
		// si el nodo es nulo o superamos la profundidad, salimos
		if (nodo == null || nivel > p) {
			return;
		}
		else if (nivel == p) {
			suma += nodo.getData();
			sumaRecursivaProfundidad(nodo.getLeftChild(),p,nivel+1,suma);
			sumaRecursivaProfundidad(nodo.getRightChild(),p,nivel+1,suma);
		}
	}
}