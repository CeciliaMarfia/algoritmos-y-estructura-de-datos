package tp5.ejercicio6;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.adjMatrix.*;
import tp5.ejercicio1.*;
import java.util.*;

public class BuscadorDeCaminos {
	private Graph<String> bosque;
	
	public List < List <String>> recorridosMasSeguro(){
		if((this.bosque != null) && (!this.bosque.isEmpty())){//si el grafo no es null y no está vacío
			Vertex<String> origen = this.bosque.search("Casa Caperucita");//busco origen
			if(origen != null){
				Vertex<String> destino = this.bosque.search("Casa Abuelita"); //busco destino
				if(destino != null) {
					List<List<String>> listaCaminos = new LinkedList<List<String>>();//declaro la lista de caminos
					dfs(origen,destino,listaCaminos,new LinkedList<String>(),new boolean[bosque.getSize()]);
					//no le mando el grafo porque está en la clase, la llamo con this; new LinkedList<List<String>>() sera el camino actual
				}
			}
		}
		return listaCaminos;
	}
	
	private void dfs(Vertex<String> actual, Vertex<String> destino, List<List<String>> listaCaminos, LinkedList<String> caminoActual, boolean[] marca) {
		marca[actual.getPosition()]=true; //marco como visitado
		caminoActual.add(actual.getData()); // Si entro a la recursion es xq cumple entonces agrego al camino actual
		if(origen == destino){ // Si llegue a mi destino agrego todo el camino actual
			listaCaminos.add(caminoActual);
		}else for(Edge<String> arista = this.bosque.getEdges(actual)){
			Vertex<String> adyacente = arista.getTarget();
			int pesoAdy = arista.getWeight();
			if(!marca(adyacente.getPosition())&& pesoAdy<5) {
				dfs(adyacente,destino,listaCaminos,caminoActual,marca);
			}
			
		}
		marca[actual.getPosition()]=false; //desmarco el visitado
		caminoActual.remove(caminoActual.size()-1);
	}
	
	public static void main (String[] args) {
	       Graph<String> bosque = new AdjListGraph<String>();
	       Vertex<String> v1 = bosque.createVertex("Casa Caperucita");
	       Vertex<String> v2 = bosque.createVertex("Claro 3");
	       Vertex<String> v3 = bosque.createVertex("Claro 1");
	       Vertex<String> v4 = bosque.createVertex("Claro 2");
	       Vertex<String> v5 = bosque.createVertex("Claro 5");
	       Vertex<String> v6 = bosque.createVertex("Claro 4");
	       Vertex<String> v7 = bosque.createVertex("Casa Abuelita");
	       bosque.connect(v1, v2, 4);
	       bosque.connect(v2, v1, 4);
	       bosque.connect(v1, v3, 3);
	       bosque.connect(v3, v1, 3);
	       bosque.connect(v1, v4, 4);
	       bosque.connect(v4, v1, 4);
	       bosque.connect(v2, v5, 15);
	       bosque.connect(v5, v2, 15);
	       bosque.connect(v3, v5, 3);
	       bosque.connect(v5, v3, 3);
	       bosque.connect(v4, v3, 4);
	       bosque.connect(v3, v4, 4);
	       bosque.connect(v4, v5, 11);
	       bosque.connect(v5, v4, 11);
	       bosque.connect(v4, v6, 10);
	       bosque.connect(v6, v4, 10);
	       bosque.connect(v4, v3, 4);
	       bosque.connect(v3, v4, 4);
	       bosque.connect(v5, v7, 4);
	       bosque.connect(v7, v5, 4);
	       bosque.connect(v6, v7, 9);
	       bosque.connect(v7, v6, 9);
	       BuscadorDeCaminos bosquecito = new BuscadorDeCaminos(bosque);
	       
	       
	       System.out.println(bosquecito.RecorridosMasSeguros());
}
