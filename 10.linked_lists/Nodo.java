/*
 * Clase donde va a ir el Nodo(elemento individual de la lista).

   Metodos necesarios: 
    setSiguiente();
    getDato();
    getSiguiente();
 */
package ecci.lab9;

/**
 *
 * @author emma
 */
public class Nodo {
    private int value; //Must save an integer number.
    private Nodo next; //The next Nodo linked to this one.
    
    public Nodo(int valor){
        this.value=valor;
        next=null; //When it is created it doesnt have a next element.
    }
    
    /*
    * Function: Create and link a next Element.
    */
    public void setNext(int valor){
        this.next = new Nodo(valor);
    }
    
    /*
    * Return this value.
    */
    public int getValue(){
        return value;
    }
    
    /*
    * Returns the next element.
    */
    public Nodo getNext(){
        return next;
    }
    
   /*
    * Function: set a new Nodo in the next postition, unlike setNext() this one received a Nodo.
    */
    public void setNextNodo(Nodo nuevo){
        this.next=nuevo;
    }
}
