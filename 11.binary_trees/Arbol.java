/*
 * Arbol de tipo binario. Nercesita los metodos:
add(String, int identificador) Que anada un nuevo elemento al diccionario.
getPalabra(String)
getApariciones(String)
getgetIdentificador(String)

 */
package ecci.lab10;

/**
 *
 * @author emma
 */
public class Arbol {
    private Nodo cabeza; //La cabeza de todo el arbol.
    
    public Arbol(){
        this.cabeza=null;
    }
    
    /*
    Agrega un elemento al diccionario y se coloca segun las reglas de agregar en diccionarios binarios.
    
    **Credits: esta implementacion del codigo lleva la misma idea que la de @pablo_sauma(profesor).
    */
    public void add(String palabra, int identificador){
        if(cabeza==null){ //En caso que el arbol este vacio.
            cabeza = new Nodo(palabra, identificador);
        } else{
            Nodo actual = cabeza;
            while((palabra.compareTo(actual.getPalabra()) <0 && actual.getHijoIzquierdo()!=null) || (palabra.compareTo(actual.getPalabra()) >0 && actual.getHijoDerecho()!=null)){ //Mientras que se pueda mover en uno que NO este vacio.
                if(palabra.compareTo(actual.getPalabra()) == 0){ //En caso de que haya una palabra repetida.
                    actual.setApariciones(); //Esto aumenta en uno la cantidad de apariciones.
                    break; //Me salgo del ciclo.
                }
                //En caso de que no sea una palabra que ya existe.
                if(palabra.compareTo(actual.getPalabra()) <0){
                    actual = actual.getHijoIzquierdo();
                } else {
                    actual = actual.getHijoDerecho();
                }
            }
            if(palabra.compareTo(actual.getPalabra()) <0){
                actual.setNodoIzquierdo(new Nodo(palabra, identificador));
            } else {
                actual.setNodoDerecho(new Nodo(palabra, identificador));
            }
        }
    }
    
    /*
    Function: busca si contiene una palabra en el arbol, en caso de contenerla regresa la cantidad de veces que este aparace.
    */
    public int contiene(String palabra){
        int apariciones = 0; //Cantidad de veces que aparece la palabra.
        if(cabeza != null){ //Solo busca si el arbol no esta vacio.
            Nodo actual = cabeza;
            while(actual!=null && actual.getPalabra().compareTo(palabra) != 0){
                if(actual.getPalabra().compareTo(palabra) <0){
                    actual = actual.getHijoIzquierdo();
                } else {
                    actual = actual.getHijoDerecho();
                }
            }
            if(actual!=null){
                apariciones = actual.getApariciones();
            }
        }
        return apariciones;
    }
    
    public String toStringArbol(Nodo actual, String hileraActual){
        if(actual.getHijoIzquierdo()!=null && actual.getHijoDerecho()!=null){
            hileraActual += actual.getPalabra() + ", ";
            hileraActual += toStringArbol(actual.getHijoIzquierdo(), hileraActual);
            hileraActual += toStringArbol(actual.getHijoDerecho(), hileraActual);
        }
        return hileraActual;
    }
    
    public Nodo getCabeza(){return cabeza;}
}
