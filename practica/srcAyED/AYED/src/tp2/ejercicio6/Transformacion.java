package tp2.ejercicio6;

import tp2.ejercicio4.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> tree;
	
	
	
	public BinaryTree<Integer> getTree() {
		return tree;
	}

	public void setTree(BinaryTree<Integer> tree) {
		this.tree = tree;
	}

	private int sum(BinaryTree a) {
		int suma = 0;
		if (a.isLeaf()) { //si está en la hoja, en suma me guardo el valor del nodo y le asigna el valor 0
			suma = a.getData();
			a.setData(0);
			return suma;
		} else { //sino, si tiene HI hago lo mismo pero recorriendo la rama izq
			if (a.hasLeftChild()) {
				suma += (this.sum(a.getLeftChild()));
			}
			if (a.hasRightChild()) { //si tiene HD hago lo mismo pero recorriendo la rama der
				suma += (this.sum(a.getRightChild()));
			}
			int x = a.getData();
			a.setData(suma);
			return (suma + x);
		}
	}

	public BinaryTree suma() {
		this.sum(this.getTree());
		return (this.getTree());
	}
}