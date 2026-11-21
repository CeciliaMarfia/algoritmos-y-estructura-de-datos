package tp2.ejercicio3;
import java.util.*;
import tp2.ejercicio1.*;
public class ContadorArbol {
	private BinaryTree<Integer> arbol;

	public ContadorArbol(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}

	public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public LinkedList<Integer> numerosPares() {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		if((this.arbol!=null)&& (!this.arbol.isEmpty())) {
			recorridoInOrden(lista,this.arbol);
			recorridoPostOrden(lista,this.arbol);
		}
	return lista;
	}
	
	private void recorridoInOrden(LinkedList<Integer> lista,BinaryTree<Integer> arbol) {
			if(arbol.hasLeftChild()) {
				recorridoInOrden(lista,arbol.getLeftChild());
			}
			if(arbol.getData() % 2 ==0 ) {
					lista.add(arbol.getData());
			}
			if(arbol.hasRightChild()) {
				recorridoInOrden(lista,arbol.getRightChild());
			}
	}
	
	private void recorridoPostOrden(LinkedList<Integer> lista,BinaryTree<Integer> arbol) {
		if(arbol.hasLeftChild()) {
			recorridoPostOrden(lista,arbol.getLeftChild());
		}
		if(arbol.hasRightChild()) {
			recorridoPostOrden(lista,arbol.getRightChild());
		}
		if(arbol.getData() % 2 ==0 ) {
			lista.add(arbol.getData());
	}
}
}
