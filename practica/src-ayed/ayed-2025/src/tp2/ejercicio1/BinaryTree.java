package tp2.ejercicio1;
import tp1.ejercicio8.*;
public class BinaryTree <T>{
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	
	//inicializa un árbol con el dato pasado como parámetro y ambos hijos nulos.

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	
	
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	
	//agrega un hijo como hijo izquierdo o derecho del árbol.
	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	
	
	//eliminan el hijo correspondiente.
	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	
	//indica si el árbol está vacío
	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	
    // indica si no tiene hijos.

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
	
	
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	
	
	@Override
	public String toString() {
		return this.getData().toString();
	}

	
	
	//Ejercicio 2 completar estos metodos. 
	
	public  int contarHojas() {
	    int cantH = 0;
	    
	    if (this.isEmpty()) {
			return cantH; //si está vacío devuelve 0
			
	    }else if(this.isLeaf()) {
			return 1; //si no tiene hijos retorno 1
		}else
			//si tiene hijo izquierdo , se posiciona en ese hijo y hace la recursion, hasta llegar a la hoja
			if(this.hasLeftChild()) {
				cantH += this.getLeftChild().contarHojas();			}
		    
		    //si tiene hijo derecho , se posiciona en ese hijo y hace la recursion, hasta llegar a la hoja
		    if (this.hasRightChild()) {
		    	cantH += this.getRightChild().contarHojas();
		    }
		return cantH; 
		
	}
		
		
    	 
    public BinaryTree<T> espejo(){
       BinaryTree <T> espejo = new BinaryTree<T>();
       if((this!= null) && (!this.isEmpty())){
    	   espejo = helper(this);
       }
       return espejo;
   }
    
    private BinaryTree<T> helper(BinaryTree<T> arbolOriginal){
    	BinaryTree <T> nodoNuevo = new BinaryTree<T>();
    	nodoNuevo.setData(arbolOriginal.getData());
    	if(arbolOriginal.hasLeftChild()) {
    		//si tiene hijo izquierdo se agrega al arbol nuevo el hijo derecho llamando a la recursión
    		nodoNuevo.addRightChild(helper(arbolOriginal.getLeftChild()));
    	}
    	if(arbolOriginal.hasRightChild()) {
    		//si tiene hijo derecho se agrega al arbol nuevo el hijo izquierdo llamando a la recursión
    		nodoNuevo.addLeftChild(helper(arbolOriginal.getRightChild()));
    	}
    	return nodoNuevo;
    }
    
    public void entreNiveles(int n, int m){
		BinaryTree<T> ab = null;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		
		int nivelAct = 0;
		while(!cola.isEmpty() && nivelAct <=m) {
			ab = cola.dequeue();
			if(ab != null) {
				if(nivelAct >= n)
					System.out.print(ab.getData() + " ");
				if (ab.hasLeftChild()) 
					cola.enqueue(ab.getLeftChild());
				if (ab.hasRightChild()) 
					cola.enqueue(ab.getRightChild());
			}
			else if (!cola.isEmpty()) {
				cola.enqueue(null);
				nivelAct ++;
			}
		}
   }


    

public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	System.out.println("Test metodos Arboles");
    BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
    ab.addLeftChild(new BinaryTree<Integer>(2));
    ab.addRightChild(new BinaryTree<Integer>(6));
    ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
    ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
    ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
    ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
    
    System.out.println(ab.contarHojas());
    System.out.println("Arbol original: ");

    System.out.println("Arbol espejo: ");


    System.out.println("Impresion Arbol por niveles 0 y 1");
    ab.entreNiveles(0, 2);
}
}
