package parciales;
import java.util.*;
import tp3.ejercicio1.*;
public class Parcial22 {
private GeneralTree<Integer> arbol;
    
public Parcial22(GeneralTree<Integer> arbol) {
    this.arbol = arbol;
}
public List<Integer> camino (int num) {
    List<Integer> cam = new LinkedList<Integer>();
    if(!this.arbol.isEmpty()) {
    	caminoRec(arbol, cam, num);
    }
    return cam;
}

private boolean caminoRec(GeneralTree<Integer> arbol, List<Integer> resultado, int num) {
    boolean encontre = false;
    resultado.add(arbol.getData());
    if(arbol.isLeaf()) {
    	encontre = true;
        return encontre;
    } else {
        List<GeneralTree<Integer>> children = arbol.getChildren();
        if(resultado.size() >= num) {
            Iterator<GeneralTree<Integer>> iterador = children.iterator();
            while(iterador.hasNext() && !encontre) {
            	GeneralTree<Integer> child = iterador.next();
                encontre = caminoRec(child, resultado, num);
                }
        }
    }
    if (!encontre)
    	resultado.remove(resultado.size()-1);
    return encontre;
}
    
    public static void main(String args[]) {
        GeneralTree<Integer> arbol = new GeneralTree<Integer>(10);
        
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(5);
        subAb1.addChild(new GeneralTree<Integer>(-6));
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(22);
        subAb2.addChild(new GeneralTree<Integer>(28));
        subAb2.addChild(new GeneralTree<Integer>(55));
        subAb2.addChild(new GeneralTree<Integer>(18));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(8);
        a1.addChild(subAb1);
        a1.addChild(subAb2);
        
        arbol.addChild(a1);
        arbol.addChild(new GeneralTree<Integer>(42));
        
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(19);
        subAb3.addChild(new GeneralTree<Integer>(4));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(-5);
        a2.addChild(subAb3);
        a2.addChild(new GeneralTree<Integer>(-9));
        
        arbol.addChild(a2);
        
        Parcial22 p = new Parcial22(arbol);
        
        System.out.println(p.camino(2));
        System.out.println(p.camino(3));
    }
}
