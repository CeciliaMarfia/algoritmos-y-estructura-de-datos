package tp2.ejercicio3;
import java.util.ArrayList;
import java.util.List;

public class ContadorArbol {
	private BinaryTree<Integer> arbol;

	
	//constructor
	public ContadorArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	//este método retorna una lista con los elementos pares de los nodos
	public List<Integer> numerosParesInOrden() {
        List<Integer> pares = new ArrayList<>();
        numerosPares(arbol, pares);
        return pares;
    }

    private void numerosPares(BinaryTree<Integer> nodo, List<Integer> pares) {
    	if(nodo != null) { //si el nodo no está vacío
    		numerosPares(nodo.getLeftChild(), pares); //llamo recursivamente por la izquierda
    		if(nodo.getData() % 2 == 0) { //si es par lo sumo a la lista
    			pares.add(nodo.getData());
    		} 
    		numerosPares(nodo.getRightChild(), pares); //llamo recursivamente por la derecha
   		}
    }
    
    
    public ArrayList<Integer> numerosParesPostOrden() { //HI,HD,R
		ArrayList <Integer> pares = new ArrayList<>();
		numerosPostOrden(this.arbol,pares);
		return(pares);
	}
	private void numerosPostOrden (BinaryTree<Integer> nodo, ArrayList<Integer> pares) { // metodo recursivo
		if (nodo == null) {  // si el nodo esta vacio salgo
			return;
		}
		if (nodo.hasLeftChild()) {
			numerosPostOrden(nodo.getLeftChild(),pares);
		}
		if (nodo.hasRightChild()) {
			numerosPostOrden(nodo.getRightChild(),pares);
		}
		if (nodo.getData() % 2 == 0) { // si es par lo agrego a la lista
			pares.add(nodo.getData());
		}
	}
    
}
