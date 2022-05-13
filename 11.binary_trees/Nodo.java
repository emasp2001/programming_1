/*
 * 
 */
package ecci.lab10;

/**
 *
 * @author emma
 */
public class Nodo {
    private int identificador; //Forma de identificar cada palabra del diccionario.
    private int apariciones; //La cantidad de veces que aparece la palabra en todo el texto.
    private String texto; //La palabra que se quiere guardar en el nodo.
    private Nodo izquierdo; //El Nodo hijo de la izquierda.
    private Nodo derecho; //El Nodo hijo de la derecha.
    
    public Nodo(String palabra, int identifier){
        this.texto = palabra;
        this.apariciones = 1;
        this.identificador = identifier;
        this.izquierdo = null;
        this.derecho = null;
    }
    
    public void setApariciones(){apariciones++;}
    public void setNodoIzquierdo(Nodo hijo){izquierdo=hijo;}
    public void setNodoDerecho(Nodo hijo){derecho=hijo;}
    
    public String getPalabra(){return texto;}
    public int getIdentificador(){return identificador;}
    public int getApariciones(){return apariciones;}
    public Nodo getHijoIzquierdo(){return izquierdo;}
    public Nodo getHijoDerecho(){return derecho;}
}
