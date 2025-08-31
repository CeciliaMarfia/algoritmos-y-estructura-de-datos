package tp5.ejercicio1;
import java.util.*;
public class parcialJulio2022 {
	public List<String> recorrido(Graph<String> grafo, int cantLocalidades, int cantNafta, List<String> localidadesExceptuadas) {
		List<String> camino = new LinkedList<String>();
        if(!grafo.isEmpty()) {
            Vertex<String> origen = grafo.search("Mendoza");
            if(origen != null) {
                boolean [] marcas = new boolean [grafo.getSize()];
                marcarLocalidades(grafo, marcas, localidadesExceptuadas);
                dfs(grafo, origen,camino, new LinkedList<String> ,marcas, cantLocalidades, cantNafta, marcas);
            }
        }
        return camino;
    }
	}
	
	private void marcarLocalidades(Graph<String> grafo, boolean[] marcas, List<String> localidades) {
        for(String l: localidades) {
            Vertex<String> v = grafo.search(l);
            if(v != null) {
                marcas[v.getPosition()] = true;
            }
        }
    }
	 public static void main(String args[]) {
	        Graph<String> grafo = new AdjListGraph<String>();
	        Vertex<String> v1 = grafo.createVertex("Mendoza");
	        Vertex<String> v2 = grafo.createVertex("Tunuyán");
	        Vertex<String> v3 = grafo.createVertex("San Martin");
	        Vertex<String> v4 = grafo.createVertex("La Paz");
	        Vertex<String> v5 = grafo.createVertex("Santa Rosa");
	        Vertex<String> v6 = grafo.createVertex("San Rafael");
	        Vertex<String> v7 = grafo.createVertex("Malargue");
	        Vertex<String> v8 = grafo.createVertex("General Alvear");
	        
	        grafo.connect(v1, v2, 10);
	        grafo.connect(v1, v3, 6);
	        grafo.connect(v2, v3, 10);
	        grafo.connect(v3, v4, 8);
	        grafo.connect(v4, v5, 2);
	        grafo.connect(v3, v6, 13);
	        grafo.connect(v6, v2, 11);
	        grafo.connect(v6, v8, 7);
	        grafo.connect(v2, v7, 12);
	        grafo.connect(v8, v7, 6);
	        
	        List<String> localidadesExceptuadas = new LinkedList<String>();
	        localidadesExceptuadas.add("General Alvear");
	        localidadesExceptuadas.add("La Paz");
	        
	        Parcial p = new Parcial();
	        
	        System.out.println(p.recorrido(grafo, 5, 80, localidadesExceptuadas));
	    }
	}
}
