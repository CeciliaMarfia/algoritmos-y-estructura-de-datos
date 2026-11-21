package tp2.ejercicio5;
import tp2.ejercicio1.*;
import tp1.ejercicio8.*;
public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;

	public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}

	public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int sumaElementosProfundidad (int nivel) {
        int suma = 0;
        int nivelActual = 0;
        BinaryTree<Integer> nodo;
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        cola.enqueue(this.arbol);
        cola.enqueue(null);
        while (!cola.isEmpty() && nivelActual <= nivel) {
            nodo = cola.dequeue();
            if (nodo != null) {//para ver si llegué a fin de nivel
                if (nivel == nivelActual) {
                    suma += nodo.getData(); // si es la profundidad sumo
                }
                if (nodo.hasLeftChild()) {
                    cola.enqueue(nodo.getLeftChild());
                }
                if (nodo.hasRightChild()) {
                    cola.enqueue(nodo.getRightChild());
                }
            } else if (!cola.isEmpty()) {
                cola.enqueue(null);
                nivelActual ++;
            }
        }
        return suma;
    }

	

}
