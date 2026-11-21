package tp2.ejercicio6;

import tp2.ejercicio1.*;

public class Transformacion {
	BinaryTree<Integer> arbol;

	public Transformacion(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}

	BinaryTree<Integer> suma() {
		if (arbol != null && !arbol.isEmpty()) {
			return suma(arbol);
		}
		return null;
	}

	private BinaryTree<Integer> suma(BinaryTree<Integer> arbol2) {
		if (arbol2.isLeaf()) {
			return new BinaryTree<Integer>(0);
		} else {
			Integer cuentaHi = 0;
			Integer cuentaHd = 0;

			BinaryTree<Integer> nuevo = new BinaryTree<Integer>(cuentaHi + cuentaHd);

			if (arbol2.hasLeftChild()) {
				cuentaHi = contar(arbol2.getLeftChild());
				nuevo.addLeftChild(suma(arbol2.getLeftChild()));
			}

			if (arbol2.hasRightChild()) {
				cuentaHd = contar(arbol2.getRightChild());
				nuevo.addRightChild(suma(arbol2.getRightChild()));
			}

			nuevo.setData(cuentaHd + cuentaHi);

			return nuevo;
		}
	}

	private Integer contar(BinaryTree<Integer> a) {
		if(a == null || a.isEmpty()) {
			return 0;
		}
		if( a.isLeaf()) {
			return a.getData();
		}else {
			return a.getData() + contar(a.getLeftChild()) + contar(a.getRightChild());
		}
	}
}
