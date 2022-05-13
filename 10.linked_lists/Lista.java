/*
 * Implemente su propia clase Lista que permita almacenar datos de tipo entero, cumpliendo las siguientes restricciones:

Metodos: 
    1. Implemente un método que permita vaciar la lista.
    2. Implemente un método que permita insertar un valor en una posición de la lista, si la lista tiene un tamaño menor a la posición solicitada,
       agréguelo al final de la lista. Ejemplo: si tenemos una lista [1, 3, 5] y se inserta 2 en la posición 1, [1, 2, 3, 5].
    3. Implemente un método que permita remover el valor en una posición de la lista. Ejemplo: si tenemos una lista [1, 3, 5] y se remueve la posición 1, [1, 5].
    4. Implemente un método que retorne si un valor se encuentra contenido o no en su lista.

 */
package ecci.lab9;

/**
 *
 * @author emma
 */
public class Lista {
    private int size; //The size of the list.
    private Nodo head; //Principal element of the list, from this are unfold the other elements.
    
    public Lista(){
        this.size=0;
        this.head=null;
    }
    
    /*
    * Function: Add an element to the list.
    */
    public void addElement(int element){
        if(head==null){ //In case the list is empty.
            head=new Nodo(element);
        } else { //In case isn't empty, look for the last item in order to linked it.
            getLastElement(head).setNext(element); //Once that it's found, link the other element.
        }
        size++;
    }
    
    /*
    * Function: delete all the element of the list.
    */
    public void clearOutList(){
        this.head=null;
        size=0;
    }
    
    /*
    * Function: get the last element of the list. 
    */
    private Nodo getLastElement(Nodo currentNodo){return (currentNodo.getNext()==null)? currentNodo : getLastElement(currentNodo.getNext());} //Make the recursive function in one line. Credits: Pablo Sauma.
    
    /*
    * Function: get the Nodo index of the list.
    */
    private Nodo getIndexNodo(Nodo currentNodo, int currentIndex, int askedIndex){
        //Search the Nodo, recursively, that has been asked.
        return (currentIndex==askedIndex)? currentNodo : getIndexNodo(currentNodo.getNext(), currentIndex+1, askedIndex);
    }
    
    /*
    Function: insertar un valor en una posición de la lista, si la lista tiene un tamaño menor a la posición solicitada,
              agréguelo al final de la lista. Ejemplo: si tenemos una lista [1, 3, 5] y se inserta 2 en la posición 1, [1, 2, 3, 5].
    */
    public void addInIndex(int valor, int indice){
        if(indice>size){ //In case the index is bigger than the size of the list.
            getLastElement(head).setNext(valor); 
        } else {
            if(indice==0){
                //Swip the elements.
                Nodo temp=head; //Temporal Nodo for link the Elements.
                head=new Nodo(valor);
                head.setNextNodo(temp);
            } else {
                Nodo searched = getIndexNodo(head, 0, indice-1); //I get an index before the one that I need in order to make the swip.
                Nodo temp = searched.getNext();
                
                //Swip the element adding the new one.
                Nodo newNodo = new Nodo(valor);
                searched.setNextNodo(newNodo);
                newNodo.setNextNodo(temp);
            }
        }
        size++;
    }
    
    /*
    * Function: remover el valor en una posición de la lista. Ejemplo: si tenemos una lista [1, 3, 5] y se remueve la posición 1, [1, 5].
    */
    public void deleteIndex(int indice){
        if(indice<=size){ //Just happend if the index is smaller o same than the size of the list.
            if(indice==0){
                head = head.getNext(); //Unlink the head, putting there the next Element from the head.
            }else{
                getIndexNodo(head, 0, indice-1).setNextNodo(getIndexNodo(head, 0, indice+1)); //Unlink (in Java that's detele) the index indicated.
            }
            size--;
        }
    }
    
    /*
    * Function: retorna si un valor se encuentra contenido o no en su lista.
    */
    public boolean existElement(int valor){
        boolean exist = false; //I presume that it doesn't exist.
        if(head!=null){ //It goes only if the list is no empty.
            Nodo currentNodo = head; //Nodo in which I'm working.
            //Search the element.
            while(exist==false || currentNodo.getNext()!=null){ //It suppose to stop if I'm in the end of the list or if I found the element.
                if(currentNodo.getValue()==valor){
                    exist=true;
                } else {
                    if(currentNodo.getNext()==null){
                        break;
                    } else {
                        currentNodo = currentNodo.getNext();
                    }
                }
            }
        }
        return exist;
    }
    
    /*
    * Function: print the list in order to debug the Lab.
    */
    public void printList(){
        if(head==null){ //In case that the list is empty.
            System.out.println("The list is empty.");
        } else{
            System.out.println(toStringList("[", head)+getLastElement(head).getValue()+"]");
        }
    }
    
    /*
    * Function: get a String of the list.
    */
    private String toStringList(String currentString, Nodo currentNodo){
        //Go thrught the list recursively.
        return (currentNodo.getNext()==null)? currentString : toStringList(currentString+=currentNodo.getValue() + ", ", currentNodo.getNext()); 
    }
}
