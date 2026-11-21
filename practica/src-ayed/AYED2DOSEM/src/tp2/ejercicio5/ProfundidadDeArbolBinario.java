package tp2.ejercicio5;
import tp1.ejercicio8.*;
import tp2.ejercicio1.*;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;

	public int sumaElementosProfundidad(int nivel) {
		int suma =0; 
		Queue<BinaryTree<Integer>> cola = new Queue<>(); //con la cola voy a encolar y desencolar
		BinaryTree<Integer> nodo;
		int nivelActual = 0; //en 0 porque el arbol empieza en 0
		cola.enqueue(this.arbol);// encolo el arbol
		cola.enqueue(null);//encolo la marca de fin de nivel
		while(!cola.isEmpty() && nivelActual != nivel) { //eso lo hago para no seguir recorriendo al llegar al nivel que me pide
			nodo = cola.dequeue();//como hay un elemento lo saco
			if(nodo !=null) {//si no llegué al fin de nivel
				if( nivelActual == nivel) { //si estoy en el nivel que me dan
					suma+= nodo.getData(); //sumo los nodos
				}
				if(nodo.hasLeftChild()) {
					cola.enqueue(nodo.getLeftChild()); //encolo los hijos para procesar luego
				}
				if(nodo.hasRightChild()) {
					cola.enqueue(nodo.getRightChild());
				}
			}else if(!cola.isEmpty()) {
				cola.enqueue(null);// agrego la marca del fin de nivel
				nivelActual++;
			}
		}
		return suma;
	}

}