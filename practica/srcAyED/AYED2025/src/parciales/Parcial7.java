package parciales;
import java.util.*;
import tp3.ejercicio1.*;

public class Parcial7 {
	public List<List<Character>> caminosPares(GeneralTree<Character> arbol){
        List<List<Character>> resultado = new LinkedList<List<Character>>();
        if((arbol!=null)&& (!arbol.isEmpty())) {
            List<Character> camAct = new LinkedList<Character>();
            caminosParesRec(arbol, resultado, camAct, 0);
        }
        return resultado;
  }
        private static void caminosParesRec(GeneralTree<Character>  arbol,List<List<Character>> resultado, List<Character>camActual, int cantNodos){
        	camActual.add(arbol.getData());
        	cantNodos++;
          if(arbol.isLeaf()){
          	if(cantNodos % 2==0)
            	resultado.add (new LinkedList<Character>(camActual));

          }else{
          	for(GeneralTree<Character> child :arbol.getChildren()){
              	caminosParesRec(child, resultado, camActual, cantNodos);
            }
          }
          camActual.remove(camActual.size()-1);
        }
        
	 public static void main(String args[]) {
		 
		 Parcial7 p = new Parcial7();
	        
	        List<GeneralTree<Character>> subChildren1 = new LinkedList<GeneralTree<Character>>();
	        subChildren1.add(new GeneralTree<Character>('E'));
	        GeneralTree<Character> a1 = new GeneralTree<Character>('B', subChildren1);
	        
	        List<GeneralTree<Character>> subChildren2 = new LinkedList<GeneralTree<Character>>();
	        subChildren2.add(new GeneralTree<Character>('H'));
	        subChildren2.add(new GeneralTree<Character>('I'));
	        GeneralTree<Character> subAb1 = new GeneralTree<Character>('F', subChildren2);
	        List<GeneralTree<Character>> subChildren3 = new LinkedList<GeneralTree<Character>>();
	        subChildren3.add(subAb1);
	        subChildren3.add(new GeneralTree<Character>('G'));
	        GeneralTree<Character> a2 = new GeneralTree<Character>('C', subChildren3);
	        
	        List<GeneralTree<Character>> arbol = new LinkedList<GeneralTree<Character>>();
	        arbol.add(a1);
	        arbol.add(a2);
	        arbol.add(new GeneralTree<Character>('D'));
	        GeneralTree<Character> a = new GeneralTree<Character>('A', arbol);
	        
	        List<List<Character>> lis = p.caminosPares(a);
	        for(List<Character>l: lis) {
	            System.out.println(l);
	        }
	    }
	}