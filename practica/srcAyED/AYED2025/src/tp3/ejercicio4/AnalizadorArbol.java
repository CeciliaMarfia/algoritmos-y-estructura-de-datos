package tp3.ejercicio4;
import tp3.ejercicio1.*;
import tp1.ejercicio8.*;
import java.util.LinkedList;
import java.util.List;
public class AnalizadorArbol {
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		double proMax;
		if((arbol !=null) && (!arbol.isEmpty())
				promMax = devolverMaximoPromedioXNivel(arbol);
		return promMax;
	}
	
	private static double devolverMaximoPromedioXNivel(GeneralTree<AreaEmpresa> arbol) {
		double promMax;
		int totalNodos;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		GeneralTree<AreaEmpresa> aux;
		cola.enqueue(arbol);
		cola.enqueue(null);
		
		promMax = arbol.getData().getTardanza();
		while(!cola.isEmpty()) {
			totalNodos = 0;
			aux = cola.dequeue();
			if(aux !=null) {
				List <GeneralTree<AreaEmpresa>> children = aux.getChildren();
				for(GeneralTree<AreaEmpresa> child: children){
					cola.enqueue(child);
					totalNodos+= child.getData().getTardanza();
				}
			totalNodos = totalNodos/ children.size();
			if(totalNodos >promMax)
				promMax = totalNodos;
			}else {
				if(!cola.isEmpty()){
					cola.enqueue(null);
				}
			}
		}
	}
	
}