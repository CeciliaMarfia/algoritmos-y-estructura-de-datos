package tp2.ejercicio4;


public class RedBinariaLlena {
	private BinaryTree<Integer> raiz;

	 // Constructor
	public RedBinariaLlena(BinaryTree<Integer> raiz) {
		this.raiz = raiz;
	}
	
	//GETTERS & SETTERS

	public BinaryTree<Integer> getRaiz() {
		return raiz;
	}

	public void setRaiz(BinaryTree<Integer> raiz) {
		this.raiz = raiz;
	}
	
    // Método auxiliar para realizar el recorrido en profundidad
    private void dfs(BinaryTree<Integer> nodo, int retardoActual, int[] maxRetardo) {
        // Si el nodo es nulo, terminamos la recursión
        if (nodo == null) {
            return;
        }

        // Actualizamos el retardo acumulado
        retardoActual += nodo.getData();

        // Si es una hoja, actualizamos el máximo retardo encontrado hasta el momento
        if (nodo.isLeaf()) {
            maxRetardo[0] = Math.max(maxRetardo[0], retardoActual);
            return;
        }

        // Llamamos recursivamente a los hijos
        dfs(nodo.getLeftChild(), retardoActual, maxRetardo);
        dfs(nodo.getRightChild(), retardoActual, maxRetardo);
    }

    // Método para calcular el mayor retardo en un camino desde la raíz hasta una hoja
    public int retardoReenvio() {
        // Inicializamos el máximo retardo como 0
        int[] maxRetardo = new int[]{0};
        
        // Realizamos un recorrido en profundidad desde la raíz
        dfs(raiz, 0, maxRetardo);

        // Retornamos el máximo retardo encontrado
        return maxRetardo[0];
    }
}
