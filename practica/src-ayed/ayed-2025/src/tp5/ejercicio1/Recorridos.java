package tp5.ejercicio1;
import tp1.ejercicio8.Queue;
import tp5.ejercicio1.AdjList.*;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import java.util.*;
import java.util.*;
public class Recorridos {

	 public List<T> recorridoDFS(Graph<T> grafo) {
	        List<T> resultado = new LinkedList<>(); //Instancio una lista "resultado" donde se irán agregando los nodos recorridos en orden DFS
	        boolean[] marcas = new boolean[grafo.getSize()];//Este arreglo sirve para marcar qué vértices ya fueron visitados y tiene el tamaño igual a la cantidad de vértices del grafo
	        for(int i = 0; i < grafo.getSize(); i++) {//Itero sobre todos los vértices del grafo, desde el índice 0 hasta el último
	            if(!marcas[i]) {//Si el vértice i no fue visitado aún
	                dfs(i,grafo,marcas,resultado); //disparo el dfs
	            }
	        }
	        return resultado;//Retorna la lista con el recorrido completo del grafo en profundidad.
	    }
	 
	 
	 private void dfs(int actual, Graph<T> grafo, boolean[] marcas, List<T> lista) {
	        marcas[actual] = true; //Marca el vértice actual como visitado para no recorrerlo nuevamente
	        Vertex<T> v = grafo.getVertex(actual);//Obtiene el objeto vértice correspondiente a la posición actual en el grafo
	        lista.add(v.getData());//Agrega el dato almacenado en el vértice (v.getData()) a la lista de recorrido. Ojo, son losdatos y no el vértice
	        for(Edge<T> e : grafo.getEdges(v)) {//Este for permite recorrer todos los vecinos (adyacentes) del vértice actual. Es decir sobre las aristasque salen del vértice v.
	            int targetPos = e.getTarget().getPosition();//Obtiene la posición (índice) del vértice destino (el vecino) al que apunta la arista e
	            if(!marcas[targetPos])//si el vértice destino no fue visitado aún...
	                dfs(targetPos,grafo,marcas,lista);//disparo nuevamente el DFS, mandándole el siguiente, el grafo, las marcas y la lista
	        }
	    }
	 
	 
	 public List<T> bfs(Graph<T> grafo) {
	        boolean[] marcas = new boolean[grafo.getSize()];//Este arreglo sirve para marcar qué vértices ya fueron visitados y tiene el tamaño igual a la cantidad de vértices del grafo
	        List<T> resultado = new LinkedList<>();//Instancio una lista "resultado" donde se irán agregando los nodos recorridos en orden BFS
	        for(int i = 0; i < grafo.getSize(); i++) {//Recorre todos los vértices del grafo desde el índice 0 hasta el último.
	            if(!marcas[i])//Si el vértice i no fue visitado...
	                bfs(i,grafo,marcas,resultado); //se digue el recorrido en BFS
	        }
	        return resultado;//Retorna la lista con el recorrido completo del grafo en "anchura".
	    }
	 
	 // i es desde donde arranca el recorrido
	 private void bfs(int i, Graph<T> grafo, boolean[] marcas, List<T> lista) {
	        Queue<Vertex<T>> cola = new Queue<>();//BFS es como un recorrido x nivel instancio una cola de vértices, que se usará para llevar el orden de los vértices por visitar.
	        cola.enqueue(grafo.getVertex(i));//Encola el vértice de posición i (el vértice desde el cual arranca el recorrido).
	        marcas[i] = true;//marco que fue visitado

	        while(!cola.isEmpty()) {//Mientras haya vértices pendientes en la cola (es decir, todavía hay nodos por visitar)...
	            Vertex<T> w = cola.dequeue(); //saco de la cola
	            lista.add(w.getData());//Agrega el dato almacenado en el vértice w a la lista de resultados (lista).
	            for(Edge<T> e : grafo.getEdges(w)) {//Recorre todas las aristas que salen del vértice w (es decir, sus vecinos o adyacentes).
	                int targetPos = e.getTarget().getPosition();//Obtiene la posición (índice) del vértice destino (al que apunta la arista).
	                if(!marcas[targetPos]) {//Si ese vértice vecino no fue visitado aún...
	                    marcas[targetPos] = true;//Se marca como visitado
	                    cola.enqueue(e.getTarget());//Y lo encolamos, para que más adelante se procese y se exploren sus vecinos.

	                }
	            }
	        }
	    }
	 
	 
	 public static void main(String[] args) {
	        Graph<Integer> grafo = new AdjListGraph<>();

	        Vertex<Integer> v1 = grafo.createVertex(1);
	        Vertex<Integer> v2 = grafo.createVertex(2);
	        Vertex<Integer> v3 = grafo.createVertex(3);
	        Vertex<Integer> v4 = grafo.createVertex(4);
	        Vertex<Integer> v5 = grafo.createVertex(5);
	        Vertex<Integer> v6 = grafo.createVertex(6);
	        Vertex<Integer> v7 = grafo.createVertex(7);
	        Vertex<Integer> v8 = grafo.createVertex(8);

	        grafo.connect(v1,v5); // adyacentes de v1

	        grafo.connect(v2,v1); // adyacentes de v2
	        grafo.connect(v2,v3);
	        grafo.connect(v2,v7);

	        grafo.connect(v3,v4); // adyacentes de v3
	        grafo.connect(v3,v7);

	        grafo.connect(v4,v1); // adyacentes de v4
	        grafo.connect(v4,v6);

	        grafo.connect(v5,v6); // adyacentes de v5

	        grafo.connect(v6,v8); // adyacentes de v6

	        grafo.connect(v8,v7); // adyacentes de v8

	        grafo.printAdjacencies();

	        Recorridos<Integer> r = new Recorridos<>();
	        System.out.println("Recorrido en profundidad (DFS): " + r.dfs(grafo));
	        System.out.println("Recorrido por niveles (BFS): " + r.bfs(grafo));
	    }
	}

}
