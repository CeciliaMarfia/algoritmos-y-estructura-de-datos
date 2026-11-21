package tp1.ejercicio8;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> extends Sequence{
private List<T> data;
    
//Constructor de la clase
    public Queue(){
    	data=new LinkedList<T>();
    }
    
//Retorna la cantidad de elementos de la cola
    public int size() {
    	return data.size();
    }
    
 //Retorna verdadero si la cola no tiene elementos y falso en caso contrario
    public boolean isEmpty() {
    	return data.size()==0;
    }
  
//Inserta elementos al final de la cola
    public void enqueue(T dato){
    	data.add(dato);
    }
//Elimina el elemento del frente de la cola y lo retorna. Si la cola está vacía se produce un error   
    public T dequeue() {
    	T dato=data.get(0);
    	data.remove(0);
    	return dato;
    }
 //Retorna el elemento del frente de la cola.Si la cola está vacía se produce un error
    public T head() {
    	return data.get(0);
    }
  
 //Retorna los elementos de la cola en un String
    public String toString() {
    	String rta="";
    	for (T dato:data)
    		rta+=dato+" ";
    	return rta;
    }
}
