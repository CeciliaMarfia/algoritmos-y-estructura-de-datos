package tp2.ejercicio4;
import tp2.ejercicio1.*;

public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;
	
	public int retardoReenvio(){
		if (this.arbol != null && !this.arbol.isEmpty()) {
			return retardoReenvioRec(this.arbol);
		}else
			return -1;
	}
	
	private int retardoReenvioRec(BinaryTree<Integer> nodo) {
		if (nodo == null || nodo.isEmpty()) {
			return 0; //es el caso base, se terminó el arbol
		}
		int suma = 0; int retardoIzq=0; int retardoDer=0;
		
		if(nodo.hasLeftChild()) {
			retardoIzq = retardoReenvioRec(nodo.getLeftChild()); //procesoHI
		}
		if(nodo.hasRightChild()) {
			retardoDer = retardoReenvioRec(nodo.getRightChild());// procesoHD
		}
		
		suma+= nodo.getData(); //proceso raiz
		
		if(retardoIzq > retardoDer) {
			return suma +=retardoIzq;
		}else
			return suma+=retardoDer;
		
	}
}
