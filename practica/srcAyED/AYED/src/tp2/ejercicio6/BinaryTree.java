package tp2.ejercicio6;

public class BinaryTree<T> {
	private T Data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;
	
	/*El constructor BinaryTree(T data) inicializa un árbol con el dato pasado como parámetro y
	ambos hijos nulos.*/
	public BinaryTree(T data) {
        this.Data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

	public T getData() {
		return Data;
	}

	public void setData(T data) {
		Data = data;
	}
	
	/*Los métodos getLeftChild():BinaryTree<T> y getRightChild():BinaryTree<T>, retornan
	los hijos izquierdo y derecho respectivamente del árbol. Si no tiene el hijo tira error*/

	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTree<T> leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTree<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTree<T> rightChild) {
		this.rightChild = rightChild;
	}
	
	/*El método addLeftChild(BinaryTree<T> child) y addRightChild(BinaryTree<T> child)
agrega un hijo como hijo izquierdo o derecho del árbol.*/
	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}
	
	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}
	
	//El método removeLeftChild() y removeRightChild(), eliminan el hijo correspondiente.
	
	public void removeLeftChild() {
		 this.leftChild = null;
	 }
	
	 public void removeRightChild() {
		 this.rightChild = null;
	 }
	
	 /*El método isEmpty() indica si el árbol está vacío y el método isLeaf() indica si no tiene
hijos.*/
	 public boolean isLeaf() {
		 return (!this.hasLeftChild() && !this.hasRightChild());
		 }
	 
	 public boolean isEmpty(){
		 return (this.isLeaf() && this.getData() == null);
	}
	 /* El método hasLeftChild() y hasRightChild() devuelve un booleano indicando si tiene
dicho hijo el árbol receptor del mensaje.*/
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
//contarHojas():int Devuelve la cantidad de árbol/subárbol hojas del árbol receptor
	public int contarHojas() {
		if (this.isEmpty()) { //si está vacío... retorna 0
	        return 0;
	    } else if (this.isLeaf()) {// si es una hoja... retorna 1
	        return 1;
	    } else { //sino inicializo el contador, me voy fijando, si tiene HI voy llamando recursivo hasta llegar al a hoja y sumo e idem HD
	        int count = 0;
	        if (this.hasLeftChild()) {
	            count += this.getLeftChild().contarHojas();
	        }
	        if (this.hasRightChild()) {
	            count += this.getRightChild().contarHojas();
	        }
	        return count;
	    }
	
	}

	
}

