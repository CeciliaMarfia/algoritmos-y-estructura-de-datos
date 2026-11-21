package tp3.ejercicio9;
import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;
import java.util.*;
public class ParcialArboles {
	
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {

		if((arbol !=null) && (!arbol.isEmpty()))
			return esDeSeleccionRec(arbol);
		else
			return false;
	}
	
	private static boolean esDeSeleccionRec(GeneralTree<Integer> arbol) {
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		 boolean ok = false;
		 GeneralTree<Integer> aux;
	     cola.enqueue(arbol);
		 cola.enqueue(null);

			while(!cola.isEmpty() && (!ok)) {
				aux = cola.dequeue();
				if(aux !=null) {
					int min = Integer.MAX_VALUE;
					List <GeneralTree<Integer>> children = aux.getChildren();
					for(GeneralTree<Integer> child: children){
						cola.enqueue(child);
						min = Math.min(min, child.getData());
					}
					if(min == arbol.getData())
						ok = true;
				}else {
					if(!cola.isEmpty()){
						cola.enqueue(null);
					}
				}
			}
			return ok;
	}
	public static void main(String[] args) {
        List <GeneralTree<Integer>> subChildren1 = new LinkedList <GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(35));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(35, subChildren1);
        
        List <GeneralTree<Integer>> subChildren2 = new LinkedList <GeneralTree<Integer>>();
        subChildren2.add(subAb1);
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(35, subChildren2);
        
        List <GeneralTree<Integer>> subChildren3 = new LinkedList <GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(35));
        subChildren3.add(new GeneralTree<Integer>(83));
        subChildren3.add(new GeneralTree<Integer>(90));
        subChildren3.add(new GeneralTree<Integer>(33));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(33, subChildren3);
        
        List <GeneralTree<Integer>> subChildren4 = new LinkedList <GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(14));
        subChildren4.add(new GeneralTree<Integer>(12));
        //subChildren4.add(new GeneralTree<Integer>(18));
        subChildren4.add(subAb3);
        GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(12, subChildren4);
        //GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(18, subChildren4);
        
        List <GeneralTree<Integer>> subArbIzq = new LinkedList <GeneralTree<Integer>>();
        subArbIzq.add(subAb2);
        subArbIzq.add(subAb4);
        GeneralTree<Integer> arbIzq = new GeneralTree<Integer>(12, subArbIzq);
        
        List <GeneralTree<Integer>> subArbDer = new LinkedList <GeneralTree<Integer>>();
        subArbDer.add(new GeneralTree<Integer>(25));
        GeneralTree<Integer> arbDer = new GeneralTree<Integer>(25, subArbDer);
        
        List <GeneralTree<Integer>> arbol = new LinkedList <GeneralTree<Integer>>();
        arbol.add(arbIzq);
        arbol.add(arbDer);
        GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol); 
        
        System.out.println("Es de seleccion el primer arbol: " + esDeSeleccion(a));
}
	}
