package tp5.ejercicio1;

import tp5.ejercicio1.*;
import tp5.ejercicio1.AdjList.AdjListGraph;

import java.util.*;

public class Mapa {
	private Graph<String> mapaCiudades;

	public Mapa(Graph<String> mapaCiudades) {
		super();
		this.mapaCiudades = mapaCiudades;
	}

	/*
	 * Ejercicio 3 1. devolverCamino (String ciudad1, String ciudad2): List<String>
	 * Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a
	 * ciudad2 en caso de que se pueda llegar, si no retorna la lista vacía. (Sin
	 * tener en cuenta el combustible).
	 */
	public List<String> devolverCamino(String ciudad1, String ciudad2) {
		if ((this.mapaCiudades != null) && (!this.mapaCiudades.isEmpty())) { // verifico que el grafo esté inicializado
																				// y no esté vacío
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);// busco si existe el vertice el origen
			if (origen != null) {// si no es null el origen
				Vertex<String> destino = this.mapaCiudades.search(ciudad2);// busco si existe el vertice el destino
				if (destino != null) {// si no es null
					List<String> camino = new LinkedList<String>();// acá voy a guardar el camino si es que lo hay
					devolverCaminoDFS(origen, destino, camino, new boolean[this.mapaCiudades.getSize()]);// disparo el
																											// dfs
																											// creando
																											// un array
																											// de
																											// booleanos
																											// parra
																											// marcar
																											// los
																											// vertices
																											// visitados
					return camino;
				}
			}
		}
		return null;
	}

	/*
	 * 2. devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String>
	 * ciudades): List<String> Retorna la lista de ciudades que forman un camino
	 * desde ciudad1 a ciudad2, sin pasar por las ciudades que están contenidas en
	 * la lista ciudades pasada por parámetro, si no existe camino retorna la lista
	 * vacía. (Sin tener en cuenta el combustible).
	 */

	// La idea es devolver el PRIMER CAMINO ENCONTRADO, conviene recorrer con un
	// WHILE ya que no seria necesario devolver cada camino que se encuentre y usar
	// un for ;)
	private boolean devolverCaminoDFS(Vertex<String> origen, Vertex<String> destino, List<String> camino,
			boolean[] marcas) {
		boolean encontre = false;
		marcas[origen.getPosition()] = true; // Marca el vértice como visitado para no recorrerlo nuevamente
		camino.add(origen.getData());// agrego el vértice al camino
		if (origen == destino) { // si ya llegamos al destino, devolvemos true
			return true;

		} else {
			List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);// se obtienen los vecinos del vértice actual
			Iterator<Edge<String>> it = ady.iterator(); // voy a recorrer uno por uno
			while (it.hasNext() && !encontre) { // mientras tenga siguiente y no encontré el destino
				Vertex<String> v = it.next().getTarget(); // Retorna el vértice vecino destino de la arista.
				int j = v.getPosition();// devuelve la posición del vértice v en la lista de vértices del grafo.
				if (!marcas[j]) {
					encontre = devolverCaminoDFS(v, destino, camino, marcas);
				}
			}
		} // BACKTRACKINGGGGG, si no se encontró el camino por este nodo, se deshace el
			// último agregado
		if (!encontre) {
			camino.remove(camino.size() - 1); // marcas[origen.getPosition()] = false; Cuando haya encontrado el camino
												// hacia destino, deja marcadas las posiciones del vector de marcas
		} // acá voy a desmarcar pero no es necesario
		marcas[origen.getPosition()] = false; // Deja desmarcadas todas las posiciones del vector de marcas
		return encontre;

	}

	/*
	 * 3. caminoMasCorto(String ciudad1, String ciudad2): List<String> Retorna la
	 * lista de ciudades que forman el camino más corto para llegar de ciudad1 a
	 * ciudad2, si no existe camino retorna la lista vacía. (Las rutas poseen la
	 * distancia).
	 */

	public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
		if ((this.mapaCiudades != null) && (!this.mapaCiudades.isEmpty())) { // verifico que el grafo esté inicializado
																				// y no esté vacío
			Vertex<String> origen = mapaCiudades.search(ciudad1);// busco si existe el vertice el origen
			if (origen != null) {// si no es null el origen
				Vertex<String> destino = mapaCiudades.search(ciudad2);// busco si existe el vertice el destino
				if (destino != null) {// si no es null
					List<String> camino = new LinkedList<String>();// acá voy a guardar el camino si es que lo hay
					boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
					marcarRestringidos(ciudades, marcas);// los marco como visitados entonces los voy a saltear.
					devolverCaminoDFS(origen, destino, camino, marcas);// disparo el dfs creando un array de booleanos
																		// parra marcar los vertices visitados
					return camino;
				}
			}
		}
		return null;
	}

	private void marcarRestringidos(List<String> lugaresRestringidos, boolean[] marcas) {
		for (String nom : lugaresRestringidos) {
			Vertex<String> v = this.mapaCiudades.search(nom);
			if (v != null) {
				marcas[v.getPosition()] = true;
			}
		}
	}

	public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
		if ((this.mapaCiudades != null) && (!this.mapaCiudades.isEmpty())) { // verifico que el grafo esté inicializado
																				// y no esté vacío
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);// busco si existe el vertice el origen
			if (origen != null) {// si no es null el origen
				Vertex<String> destino = this.mapaCiudades.search(ciudad2);// busco si existe el vertice el destino
				if (destino != null) {// si no es null
					List<String> camino = new LinkedList<String>();// acá voy a guardar el camino si es que lo hay
					caminoMasCortoDFS(origen, destino, camino, new LinkedList<String>(),
							new boolean[this.mapaCiudades.getSize()], 0, Integer.MAX_VALUE);// disparo el dfs creando un
																							// array de booleanos parra
																							// marcar los vertices
																							// visitados
					// 0 por el peso acumulado del camino que estamos recorriendo, y el max el mejor
					// peso encontrado hasta ahora (es decir para calcular el minimo)
					return camino;
				}
			}
		}
		return null;
	}

	// Este método busca recursivamente el camino más corto por peso entre dos
	// vértices.
	private int caminoMasCortoDFS(Vertex<String> origen, Vertex<String> destino, List<String> caminoMinimo,
			List<String> caminoActual, boolean[] marcas, int pesoTotal, int pesoMin) {
		marcas[origen.getPosition()] = true; // Marca el vértice como visitado para no recorrerlo nuevamente
		caminoActual.add(origen.getData());// añado el vértice visitado al camino actual que se está armando.
		if (origen == destino) { // si ya llegamos al destino...
			if (pesoTotal < pesoMin) { // y si el peso del camino actual es menor que el mínimo conocido...
				pesoMin = pesoTotal;// Actualizamos el mínimo encontrado.
				caminoMinimo.removeAll(caminoMinimo);// Reemplazamos el contenido de caminoMinimo con el camino actual
														// porque es el mejor que encontramos hasta ahora.
				caminoMinimo.addAll(caminoActual);
			}
		} else {// Si todavía no llegamos al destino, seguimos explorando vecinos.
			for (Edge<String> arista : this.mapaCiudades.getEdges(origen)) {// Iteramos sobre todas las aristas que
																			// salen del vértice origen.
				int posAdy = arista.getTarget().getPosition();// Obtenemos la posición del vértice vecino (usado para
																// consultar si ya fue visitado).
				if (!marcas[posAdy]) {// Si el vecino no está marcado (o sea, no fue visitado aún)...
					int aux = pesoTotal + arista.getWeight();// Sumamos el peso de la arista al total acumulado.
					pesoMin = caminoMasCortoDFS(arista.getTarget(), destino, caminoMinimo, caminoActual, marcas, aux,
							pesoMin);
					// Llamada recursiva con el vértice vecino como nuevo origen, el nuevo peso
					// total aux, y el mínimo actual pesoMin
				}
			}

		}
		caminoActual.remove(caminoActual.size() - 1);// Backtracking: saco la última ciudad del camino actual para
														// explorar otras alternativas.
		marcas[origen.getPosition()] = false;// Desmarco el vértice para permitir otras posibles rutas en futuras
												// llamadas recursivas.
		return pesoMin;// Devuelvo el mejor peso encontrado hasta ahora.
	}

	/*
	 * 4. caminoSinCargarCombustible(String ciudad1, String ciudad2, int
	 * tanqueAuto): List<String> Retorna la lista de ciudades que forman un camino
	 * para llegar de ciudad1 a ciudad2. El auto no debe quedarse sin combustible y
	 * no puede cargar. Si no existe camino retorna la lista vacía.
	 */
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		if ((this.mapaCiudades != null) && (!this.mapaCiudades.isEmpty())) { // verifico que el grafo esté inicializado
																				// y no esté vacío
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);// busco si existe el vertice el origen
			if (origen != null) {// si no es null el origen
				Vertex<String> destino = this.mapaCiudades.search(ciudad2);// busco si existe el vertice el destino
				if (destino != null) {// si no es null
					List<String> camino = new LinkedList<String>();// acá voy a guardar el camino si es que lo hay
					caminoSinCargarCombustibleDFS(origen, destino, camino, new boolean[this.mapaCiudades.getSize()],
							tanqueAuto);// disparo el dfs creando un array de booleanos parra marcar los vertices
										// visitados
					return camino;
				}
			}
		}
		return null;
	}
	
//AYUDAAAAAA
	private List<String> caminoSinCargarCombustibleDFS(Vertex<String> origen, Vertex<String> destino, List<String> camino,boolean []marcas, int tanqueAuto) {
		marcas[origen.getPosition()] = true; //Marca el vértice como visitado para no recorrerlo nuevamente
		camino.add(origen.getData());//añado el vértice visitado al camino actual que se está armando.
		if(origen == destino) {//si llegué a destino, retormo el camino.
			if(tanqueAuto>=0) {
				return camino;
			}
		}else {
			for(Edge<String> adyacente = this.mapaCiudades.getEdges(origen)) {
				int posAdy = adyacente.getTarget().getPosition();
				int combustible = adyacente.getWeight();
				if (!marcas[posAdy]){
                    if (tanqueAuto >= combustible) {
                    	caminoSinCargarCombustibleDFS(adyacente.getTarget(), destino, marcas, camino, tanqueAuto - combustible);
                    }
			}
		}
			camino.remove(camino.size()-1);//Backtracking: saco la última ciudad del camino actual para explorar otras alternativas.
		    marcas[origen.getPosition()] = false;//Desmarco el vértice para permitir otras posibles rutas en futuras llamadas recursivas.
	}
	}

	/* 5. caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto): List<String> Retorna la lista de ciudades que forman un camino
	  para llegar de ciudad1 a ciudad2 teniendo en cuenta que el auto debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en
	 medio de una ruta, además puede completar su tanque al llegar a cualquier ciudad. Si no existe camino retorna la lista vacía.
	 */
	
	public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		if ((this.mapaCiudades != null) && (!this.mapaCiudades.isEmpty())) { // verifico que el grafo esté inicializado
																				// y no esté vacío
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);// busco si existe el vertice el origen
			if (origen != null) {// si no es null el origen
				Vertex<String> destino = this.mapaCiudades.search(ciudad2);// busco si existe el vertice el destino
				if (destino != null) {// si no es null
					List<String> camino = new LinkedList<String>();// acá voy a guardar el camino si es que lo hay
					caminoConMenorCargaDeCombustibleDFS(origen, destino, camino, new boolean[this.mapaCiudades.getSize()],tanqueAuto);// disparo el dfs creando un array de booleanos parra marcar los vertices visitados
					return camino;
				}
			}
		}
		return null;
	}
	
	private int caminoConMenorCargaDeCombustibleDFS(Vertex<String> origen, Vertex<String> destino, List<String> caminoMinimo,
			List<String> caminoActual, boolean[] marcas, int pesoTotal, int pesoMin) {
		marcas[origen.getPosition()] = true; // Marca el vértice como visitado para no recorrerlo nuevamente
		caminoActual.add(origen.getData());// añado el vértice visitado al camino actual que se está armando.
		if (origen == destino) { // si ya llegamos al destino...
			if (tanqueAuto >= 0 ) { // y si el peso del camino actual es menor que el mínimo conocido...
				camino.removeAll(caminoMinimo);// Reemplazamos el contenido de caminoMinimo con el camino actual porque es el mejor que encontramos hasta ahora.
				caminoMinimo.addAll(caminoActual);
			}
		} else {// Si todavía no llegamos al destino, seguimos explorando vecinos.
			for (Edge<String> arista : this.mapaCiudades.getEdges(origen)) {// Iteramos sobre todas las aristas que
																			// salen del vértice origen.
				int posAdy = arista.getTarget().getPosition();// Obtenemos la posición del vértice vecino (usado para
																// consultar si ya fue visitado).
				if (!marcas[posAdy]) {// Si el vecino no está marcado (o sea, no fue visitado aún)...
					int aux = pesoTotal + arista.getWeight();// Sumamos el peso de la arista al total acumulado.
					pesoMin = caminoConMenorCargaDeCombustibleDFS(arista.getTarget(), destino, caminoMinimo, caminoActual, marcas, aux,
							pesoMin);
					// Llamada recursiva con el vértice vecino como nuevo origen, el nuevo peso
					// total aux, y el mínimo actual pesoMin
				}
			}

		}
		caminoActual.remove(caminoActual.size() - 1);// Backtracking: saco la última ciudad del camino actual para
														// explorar otras alternativas.
		marcas[origen.getPosition()] = false;// Desmarco el vértice para permitir otras posibles rutas en futuras
												// llamadas recursivas.
		return pesoMin;// Devuelvo el mejor peso encontrado hasta ahora.
	}


	public static void main(String[] args) {
		Graph<String> mapaCiudades = new AdjListGraph<String>();
		Vertex<String> v1 = mapaCiudades.createVertex("La Plata");
		Vertex<String> v2 = mapaCiudades.createVertex("Ensenada");
		Vertex<String> v3 = mapaCiudades.createVertex("Berisso");
		Vertex<String> v4 = mapaCiudades.createVertex("City Bell");
		Vertex<String> v5 = mapaCiudades.createVertex("Elisa Village");
		Vertex<String> v6 = mapaCiudades.createVertex("Veinticinco de Mayo");
		Vertex<String> v7 = mapaCiudades.createVertex("Saladillo");
		mapaCiudades.connect(v1, v2, 4);
		mapaCiudades.connect(v2, v1, 4);
		mapaCiudades.connect(v1, v3, 3);
		mapaCiudades.connect(v3, v1, 3);
		mapaCiudades.connect(v1, v4, 4);
		mapaCiudades.connect(v4, v1, 4);
		mapaCiudades.connect(v2, v5, 15);
		mapaCiudades.connect(v5, v2, 15);
		mapaCiudades.connect(v3, v5, 3);
		mapaCiudades.connect(v5, v3, 3);
		mapaCiudades.connect(v4, v3, 4);
		mapaCiudades.connect(v3, v4, 4);
		mapaCiudades.connect(v4, v5, 11);
		mapaCiudades.connect(v5, v4, 11);
		mapaCiudades.connect(v4, v6, 10);
		mapaCiudades.connect(v6, v4, 10);
		mapaCiudades.connect(v4, v3, 4);
		mapaCiudades.connect(v3, v4, 4);
		mapaCiudades.connect(v5, v7, 4);
		mapaCiudades.connect(v7, v5, 4);
		mapaCiudades.connect(v6, v7, 9);
		mapaCiudades.connect(v7, v6, 9);

		Mapa mapa = new Mapa(mapaCiudades);

		System.out.print("LISTA DEVOLVER CAMINO: ");
		System.out.print(mapa.devolverCamino("La Plata", "Elisa Village"));

		System.out.println("");

		System.out.print("LISTA DEVOLVER CAMINO EXCEPTUANDO LUGARES:");
		List<String> restringidos = new LinkedList<String>();
		restringidos.add("Ensenada");
		restringidos.add("Berisso");
		System.out.print(mapa.devolverCaminoExceptuando("La Plata", "Elisa Village", restringidos));

		System.out.println("");

		System.out.print("LISTA CAMINO MAS CORTO (SEGUN DISTANCIA): ");
		// System.out.print(mapa.caminoMasCorto("La Plata", "Elisa Village"));

		System.out.println("");

		System.out.print("LISTA CAMINO SIN CARGAR COMBUSTIBLE: ");
		// System.out.print(mapa.caminoSinCargarCombustible("La Plata", "Elisa Village",
		// 30));

		System.out.println("");

		System.out.print("LISTA CAMINO CON MENOR CARGAS DE COMBUSTIBLE: ");
		// System.out.print(mapa.caminoConMenorCargaCombustible("La Plata", "Elisa
		// Village", 10));

		System.out.println("");
	}
}
