/*
 * Metodos necesario: 
add(Ficha)
imprimirLista() ----> Con este formato “X:Y”  donde  ‘X’  y  ‘Y’  son  la  cantidad  de puntos en cada mitad de la ficha.
vaciarLista
pop()
popByIndice()

 */
package examendos;

/**
 *
 * @author emma
 */
public class ListaFichas {
    private Ficha cabeza;
    private Ficha cola;
    private int size;
    
    public ListaFichas(){
        this.cabeza=null;
        this.cola=null;
        this.size=0;
    }
    
    public void add(int valor1, int valor2){
        if(cabeza==null){
            cabeza=new Ficha(valor1, valor2);
            cola = cabeza;
        } else{
            cola.setSiguiente(new Ficha(valor1, valor2));
            cola = cola.getSiguiente();
        }
        size++;
    }
    
    /*
    Function: se hace cuando un jugador toma una ficha de todas las que quedan, esto hace que pase a el y por ende se debe eliminar de esta lista.
    */
    public Ficha pop(){
        Ficha ficha=null; //La ficha que se le va a dar al usuario.
        if(size>0){
            ficha = cabeza;
            cabeza = cabeza.getSiguiente();
            size--;
        }
        return ficha; //Regresa un null si la lista esta vacia o si ya no hay mas fichas por tomar.
    }
    
    public void vaciarLista(){
        cabeza = null;
        cola = cabeza;
        size=0;
    }
    
    public void imprimirLista(){
        System.out.println(toStringLista(cabeza, ""));
    }
    
    public Ficha popByIndice(int indice){
        Ficha ficha=null;
        if(indice<=size){ //Just happend if the index is smaller o same than the size of the list.
            if(indice==0){
                ficha = cabeza;
                cabeza = cabeza.getSiguiente(); //Unlink the head, putting there the next Element from the head.
            }else{
                ficha = getFichaIndice(cabeza, 0, indice);
                getFichaIndice(cabeza, 0, indice-1).setSiguiente(getFichaIndice(cabeza, 0, indice+1)); //Unlink (in Java that's detele) the index indicated.
            }
            size--;
        }
        return ficha;
    }
    
    public int getSize(){return size;}
    
    public void addAlPrincipio(int valor1, int valor2){
       Ficha nueva = new Ficha(valor1, valor2);
       if(size==0){
          cabeza = nueva;
          cola = cabeza;
       }
       else {
          nueva.setSiguiente(cabeza);
          cabeza = nueva;
       }
    }
    
    public Ficha getCabeza(){return cabeza;}
    
    public Ficha getCola(){return cola;}
    
    /*
    Function: va a servir para cuando trate de agregar una valor que ya existe, esto es solo para cuando se estan creando las fichas disponibles
    de esta forma se simula que se barajan las fichas.
    */
    public boolean contains(Ficha actual, int valor1, int valor2){
        if(actual!=null){
            return ((actual.getValor1()==valor1) && (actual.getValor2()==valor2)) ? true : contains(actual.getSiguiente(), valor1, valor2);
        } else {
            return false;
        }
    }
    
    private String toStringLista(Ficha actual, String texto){ return actual==null ? texto : toStringLista(actual.getSiguiente(), texto += actual.getValor1()+":"+actual.getValor2()+" - ");}
    private Ficha getFichaIndice(Ficha currentNodo, int currentIndex, int askedIndex){return (currentIndex==askedIndex)? currentNodo : getFichaIndice(currentNodo.getSiguiente(), currentIndex+1, askedIndex);}
}
