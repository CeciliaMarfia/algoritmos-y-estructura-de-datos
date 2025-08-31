package tp5.ejercicio5;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;
import java.util.*;
import tp1.ejercicio8.*;

//<>

public class BancoItau {
	public List<Persona> ListarmandoCartera(Graph<Persona> grafo,Persona empleado, int distancia) {
		Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();// genero una cola de personas
		List<Jubilado> jubilados = new LinkedList<Jubilado>(); //la lista que voy a retornar
		if((grafo != null)&& (!grafo.isEmpty())){
			Vertex<Persona> empleadoOrigen = buscarEmpleado(grafo, empleado.getNombre());
			if(empleado != null) {
                Queue<Vertex<Persona>> c = new Queue<Vertex<Persona>>();
                boolean[] marcas = new boolean[grafo.getSize()];
                marcas[empleado.getPosition()] = true;
                c.enqueue(empleado);
                c.enqueue(null);
                while(!c.isEmpty() && distancia > 0 && jubilados.size() <= 40) {
                    Vertex<Persona> v = c.dequeue();
                    if(v!=null) {
                        List<Edge<Persona>> adys = grafo.getEdges(v);
                        Iterator <Edge<Persona>> it = adys.iterator();
                        while(it.hasNext() && jubilados.size() < maxList) {
                            Vertex<Persona> vertDestino = it.next().getTarget();
                            int posDestino = vertDestino.getPosition();
                            if(!marcas[posDestino]) {
                                marcas[posDestino] = true;
                                c.enqueue(vertDestino);
                                if(vertDestino.getData().cumple()) {
                                    jubilados.add(new Persona(vertDestino.getData().getNombre(), vertDestino.getData().getDireccion));
                                }
                            }
                        }
                    } 
                    else if (!c.isEmpty()) {
                    	distancia--;
                        c.enqueue(null);
                   }
                }
            }
        }
        return jubilados;
    }
	private Vertex<Persona> buscarEmpleado(Graph<Persona> grafo, String nomEmpleado) {
        List<Vertex<Persona>> vertices = grafo.getVertices();
        Iterator<Vertex<Persona>> it = vertices.iterator();
        Vertex<Persona> per = null;
        boolean sigo = true;
        while ((it.hasNext()) && (sigo)) {
            Vertex<Persona> aux = it.next();
            if(aux.getData().getNombre().equals(nomEmpleado)) {
                per = aux;
                sigo = false;
            }
        }
        return per;
    }
	
	public static void main(String[] args) {
        Graph<Persona> grafo = new AdjListGraph<>();
        Vertex<Persona> v1 = grafo.createVertex(new Persona("Empleado", "lauti", "capital", true));
        Vertex<Persona> v2 = grafo.createVertex(new Persona("Jubilado", "marcos", "bosques", false));
        Vertex<Persona> v3 = grafo.createVertex(new Persona("Jubilado", "juti", "lp", false));
        Vertex<Persona> v4 = grafo.createVertex(new Persona("Empleado", "sofi", "lp", true));
        Vertex<Persona> v5 = grafo.createVertex(new Persona("Jubilado", "juan", "bosques", true));
        Vertex<Persona> v6 = grafo.createVertex(new Persona("Empleado", "lola", "lp", false));
        Vertex<Persona> v7 = grafo.createVertex(new Persona("Jubilado", "chechu", "lp", false));
        Vertex<Persona> v8 = grafo.createVertex(new Persona("Jubilado", "sol", "lp", false));
        Vertex<Persona> v9 = grafo.createVertex(new Persona("Jubilado", "more", "lp", false));
        
        
 
        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);
        grafo.connect(v1, v9);
        grafo.connect(v9, v1);
        grafo.connect(v9, v8);
        grafo.connect(v8, v9);
        
        grafo.connect(v1, v4);
        grafo.connect(v4, v1);
        grafo.connect(v1, v6);
        grafo.connect(v6, v1);
        grafo.connect(v4, v5);
        grafo.connect(v5, v4);
        grafo.connect(v5, v7);
        grafo.connect(v7, v5);
        
          
        BancoItau prueba = new BancoItau();
        Persona persona1 = new Persona("carla","34 563","jubilado",true);
        
        System.out.println(prueba.ListarmandoCartera(grafo, persona1, 2));

	}
}
