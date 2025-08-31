package tp2.ejercicio9;
public class ParcialArboles {

	public BinaryTree <SumaResta> SumAndDif(BinaryTree<Integer> arbol){
		BinaryTree <SumaResta> nuevoArbol= new BinaryTree<SumaResta>();
		if (arbol != null && !arbol.isEmpty()) {
			SumAndDifRec(arbol, nuevoArbol,0,0); //le paso 0 porque si declaro int suma = 0 no tien sentido porque no lo voy a usar acá
		}
		return nuevoArbol;
	}
	private void SumAndDifRec(BinaryTree<Integer> arbol, BinaryTree<SumaResta> nuevoArbol, int suma, int resta) {
		SumaResta objetoNodo = new SumaResta(suma+arbol.getData(), arbol.getData()- resta);
		nuevoArbol.setData(objetoNodo);
		if(arbol.hasLeftChild()) {
			BinaryTree <SumaResta> hijoIzquierdo= new BinaryTree<SumaResta>();
			nuevoArbol.addLeftChild(hijoIzquierdo);
			SumAndDifRec(arbol.getLeftChild(),nuevoArbol.getLeftChild(),suma+arbol.getData(),resta-arbol.getData());
		}
		if(arbol.hasRightChild()) {
			BinaryTree <SumaResta> hijoDerecho= new BinaryTree<SumaResta>();
			nuevoArbol.addRightChild(hijoDerecho);
			SumAndDifRec(arbol.getRightChild(),nuevoArbol.getRightChild(),suma+arbol.getData(),resta-arbol.getData());
		}
	}
	
}
