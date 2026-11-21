package tp3.ejercicio2;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.*;
import tp3.ejercicio1;

/*Ejercicio 2
a) Implemente en la clase RecorridosAG los siguientes métodos:
public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,
Integer n)
Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
pasados como parámetros, recorrido en preorden.
public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,
Integer n)
Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
pasados como parámetros, recorrido en inorden.
public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,
Integer n)
Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
pasados como parámetros, recorrido en postorden.
public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,
Integer n)
Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
pasados como parámetros, recorrido por niveles.*/
public class RecorridosAG {
	private GeneralTree<Integer> a;
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> resultado = new LinkedList<Integer>();
		 if(a != null && !a.isEmpty())
			 numerosImparesMayoresQuePreOrdenRec(a,resultado,n);
		return resultado;
		
	}
	
	private static void numerosImparesMayoresQuePreOrdenRec(GeneralTree <Integer> a, List<Integer> resultado, int n) {

		if ((a.getData() %2 ==1) && a.getData() > n)
			resultado.add(a.getData());
		
		List<GeneralTree<Integer>> children = a.getChildren();
		for (GeneralTree<Integer> child: children) 
			numerosImparesMayoresQuePreOrdenRec(child,resultado,n);
			
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> resultado = new LinkedList<Integer>();
		 if(a != null && !a.isEmpty())
			 numerosImparesMayoresQueInOrdenRec(a,resultado,n);
		return resultado;
	}
	
	private static void numerosImparesMayoresQueInOrdenRec(GeneralTree <Integer> a, List<Integer> resultado, int n) {
		List<GeneralTree<Integer>> children = a.getChildren(); //obtengo la listade hijos
	    int mitad = children.size() / 2; //como noes con AB que puedo procesar HI raiz HD, separo la mitad de lo que tengo de mi lista de hijos.

	    // Recorrer la primera mitad de los hijos
	    for (int i = 0; i < mitad; i++) {
	        numerosImparesMayoresQueInOrdenRec(children.get(i), resultado, n);
	    }

		if ((a.getData() %2 ==1) && a.getData() > n)
			resultado.add(a.getData());
		
		 // Recorrer la segunda mitad de los hijos
	    for (int i = mitad; i < children.size(); i++) {
	        numerosImparesMayoresQueInOrdenRec(children.get(i), resultado, n);
	    }
	}
	    
	    public List<Integer> numerosImparesMayoresQuePosOrden(GeneralTree <Integer> a, Integer n){
			List<Integer> resultado = new LinkedList<Integer>();
			 if(a != null && !a.isEmpty())
				 numerosImparesMayoresQuePosOrdenRec(a,resultado,n);
			return resultado;
			
		}
		
		private static void numerosImparesMayoresQuePosOrdenRec(GeneralTree <Integer> a, List<Integer> resultado, int n) {
			
			List<GeneralTree<Integer>> children = a.getChildren();
			for (GeneralTree<Integer> child: children) 
				numerosImparesMayoresQuePreOrdenRec(child,resultado,n);
			
			if ((a.getData() %2 ==1) && a.getData() > n)
				resultado.add(a.getData());
		}
		
		public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n) {
	        List<Integer> resultado = new LinkedList<Integer>();
	        GeneralTree<Integer> aux;
	        Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
	        queue.enqueue(a);
	        while(!queue.isEmpty()) {
	            aux = queue.dequeue();
	            if(!aux.isEmpty()) {
	                int dato = (Integer) a.getData();
	                if(dato %2 != 0 && dato > n) resultado.add(dato);
	            }
	            List<GeneralTree<Integer>> children = aux.getChildren();
	            for(GeneralTree<Integer> child: children) {
	                queue.enqueue(child);
	            }
	        }
	        return resultado;
	    }
	}


