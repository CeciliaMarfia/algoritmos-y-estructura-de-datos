package tp2.ejercicio4;
import tp2.ejercicio1.*;
public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;
	
	
	public RedBinariaLlena(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}


	public BinaryTree<Integer> getArbol() {
		return arbol;
	}


	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}


	public int retardoReenvio() {
		if((this.arbol!=null)&&(!this.arbol.isEmpty())) {
			return auxiliar(this.arbol);
		}else
			return -1;

	}
	
	private int auxiliar(BinaryTree<Integer> ab) {
		int suma = 0; int retardoHI = 0; int retardoHD = 0;
		
		suma =+ ab.getData();
		
		if(ab.hasLeftChild()) {
			retardoHI= auxiliar(ab.getLeftChild());
		}
		
		if(ab.hasRightChild()) {
			retardoHD= auxiliar(ab.getRightChild());
		}
		
		if(retardoHI > retardoHD) {
			return suma+=retardoHI;
		}else
			return suma += retardoHD;
		
	}
}
