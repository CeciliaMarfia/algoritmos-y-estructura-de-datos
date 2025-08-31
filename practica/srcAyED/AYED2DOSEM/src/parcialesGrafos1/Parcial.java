package parcialesGrafos1;

import tp5.ejercicio1.*;
import java.util.*;

public class Parcial {
	
	public int resolver(Graph<Recinto> sitios, int tiempo) {
		int cant = 0; //sera la cantidad de recinos que se pueden visitar en el tiempo solicitado
		
		if(!sitios.isEmpty()) {//si el grafo no está vacío. Si está vacío, no hay nada que recorrer, y el método simplemente retornaría cant = 0.
			Vertex<Recinto> origen = this.buscar(sitios);// para encontrar el vértice de inicio
			if(origen != null) {//si el origen no es null
				int tiempoOrigen = origen.getData().getMinutos();//me guardo los minutos del recorrido de ese vértice
				if (tiempoOrigen <= tiempo) {
					cant=this.dfs(sitios, tiempo,,new boolean[sitios.getSize()]);
				}
			}
		}
		return cant;
	}
		
		private Vertex<Recinto> buscar(Graph<Recinto> sitios) {
	        Vertex<Recinto> rec = null;
	        Iterator<Vertex<Recinto>> it = sitios.getVertices().iterator();
	        while(it.hasNext() && rec == null) {
	            Vertex<Recinto> aux = it.next();
	            if(aux.getData().getNombre().equals("Entrada")) {
	                rec = aux;
	            }
	        }
	        return rec;
	    }
	}
	public static void main(String args[]) {
        Graph<Recinto> grafo = new AdjListGraph<Recinto>();
        Vertex<Recinto> Entrada = grafo.createVertex(new Recinto("Entrada", 15));
        Vertex<Recinto> Cebras = grafo.createVertex(new Recinto("Cebras", 10));
        Vertex<Recinto> Tigres = grafo.createVertex(new Recinto("Tigres", 10));
        Vertex<Recinto> Flamencos = grafo.createVertex(new Recinto("Flamencos", 10));
        Vertex<Recinto> Murcielagos = grafo.createVertex(new Recinto("Murciélagos", 20));
        Vertex<Recinto> Wallabies = grafo.createVertex(new Recinto("Wallabies", 30));
        Vertex<Recinto> Tortugas = grafo.createVertex(new Recinto("Tortugas", 10));
        Vertex<Recinto> Pumas = grafo.createVertex(new Recinto("Pumas", 10));
        
        grafo.connect(Entrada, Cebras, 10);
        grafo.connect(Cebras, Entrada, 10);
        grafo.connect(Entrada, Tigres, 10);
        grafo.connect(Tigres, Entrada, 10);
        grafo.connect(Entrada, Murcielagos, 20);
        grafo.connect(Murcielagos, Entrada, 20);
        grafo.connect(Entrada, Flamencos, 25);
        grafo.connect(Flamencos, Entrada, 25);
        
        grafo.connect(Tigres, Cebras, 8);
        grafo.connect(Cebras, Tigres, 8);
        grafo.connect(Cebras, Tortugas, 10);
        grafo.connect(Tortugas, Cebras, 10);
        grafo.connect(Flamencos, Murcielagos, 25);
        grafo.connect(Murcielagos, Flamencos, 25);
        grafo.connect(Murcielagos, Wallabies, 10);
        grafo.connect(Wallabies, Murcielagos, 10);
        grafo.connect(Wallabies, Tortugas, 10);
        grafo.connect(Tortugas, Wallabies, 10);
        grafo.connect(Tortugas, Pumas, 15);
        grafo.connect(Pumas, Tortugas, 15);
        
        Parcial p = new Parcial();
        
        System.out.println(p.resolver(grafo, 100));
        System.out.println(p.resolver(grafo, 30));
    }
}