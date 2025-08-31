/* Ejercicio 1
Considere la siguiente especificación de la clase GeneralTree (con la representación de Lista de Hijos)
El constructor GeneralTree(T data) inicializa un árbol que tiene como raíz un nodo y este nodo tiene
el dato pasado como parámetro y una lista vacía.
El constructor GeneralTree (T data, List<GeneralTree <T>> children) inicializa un árbol que
tiene como raíz a un nodo y este nodo tiene el dato pasado como parámetro y como hijos children.
El método getData():T retorna el dato almacenado en la raíz del árbol.
El método getChildren():List<GeneralTree <T>>, retorna la lista de hijos de la raíz del árbol.
El método addChild(GeneralTree <T> child) agrega un hijo al final de la lista de hijos del árbol
El método removeChild(GeneralTree <T> child) elimina del árbol el hijo pasado como parámetro.
El método hasChildren() devuelve verdadero si la lista de hijos del árbol no es null y tampoco es
vacía
El método isEmpty() devuelve verdadero si el dato del árbol es null y además no tiene hijos.
Los métodos altura(), nivel(T) y ancho() se resolverán en el ejercicio 3.
Analice la implementación en JAVA de la clase GeneralTree brindada por la cátedra. */

package tp3.ejercicio1;

import tp1.ejercicio8.*;
import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

    private T data;
    private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();
    
    public GeneralTree() {	
	
    }
    public GeneralTree(T data) {
        this.data = data;
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
        this(data);
	this.children = children;
    }	
    
    public T getData() {
	return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GeneralTree<T>> getChildren() {
        return this.children;
    }
	
    public void setChildren(List<GeneralTree<T>> children) {
        if (children != null)
            this.children = children;
    }
	
    public void addChild(GeneralTree<T> child) {
        this.getChildren().add(child);
    }

    public boolean isLeaf() {
        return !this.hasChildren();
    }
	
    public boolean hasChildren() {
        return !this.children.isEmpty();
    }
	
    public boolean isEmpty() {
        return this.data == null && !this.hasChildren();
    }

    public void removeChild(GeneralTree<T> child) {
        if (this.hasChildren())
            children.remove(child);
    }
}
        
