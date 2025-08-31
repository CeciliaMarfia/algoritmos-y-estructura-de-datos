package tp2.ejercicio6;

import tp2.ejercicio1.*;

public class tp2Ejercicio6 {

	public static void main(String[] args) {
		BinaryTree<Integer> arbol1 = new BinaryTree<Integer>(1);
		BinaryTree<Integer> arbol2 = new BinaryTree<Integer>(2);
		BinaryTree<Integer> arbol3 = new BinaryTree<Integer>(3);
		BinaryTree<Integer> arbol4 = new BinaryTree<Integer>(4);
		BinaryTree<Integer> arbol5 = new BinaryTree<Integer>(5);
		BinaryTree<Integer> arbol6 = new BinaryTree<Integer>(6);
		BinaryTree<Integer> arbol7 = new BinaryTree<Integer>(7);
		BinaryTree<Integer> arbol8 = new BinaryTree<Integer>(8);

		arbol1.addLeftChild(arbol2);
		arbol1.addRightChild(arbol3);

		arbol2.addRightChild(arbol4);

		arbol3.addLeftChild(arbol5);
		arbol3.addRightChild(arbol6);

		arbol5.addLeftChild(arbol7);
		arbol5.addRightChild(arbol8);

		Transformacion t = new Transformacion(arbol1);
		BinaryTree<Integer> bt = t.suma();
		System.out.println(bt);

	}

}
