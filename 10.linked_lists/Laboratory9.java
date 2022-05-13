/*
 * Main class
 */
package ecci.lab9;

/**
 *
 * @author emma
 */
public class Laboratory9 {
    public static void main(String[] argv){
        Lista list = new Lista();
        
        list.addElement(0);
        list.printList();
        
        list.addElement(1);
        list.printList();
        
        list.addElement(2);
        list.printList();
        
        list.addElement(4);
        list.printList();
        
        list.addElement(5);
        list.printList();
        
        list.addInIndex(3, 3);
        list.printList();
        
        int delete = 5;
        System.out.println("The number: "+delete+" was deleted.");
        list.deleteIndex(delete);
        list.printList();
        
        int contains = 7;
        System.out.println("Contains "+contains+"? "+list.existElement(contains));
        
        list.clearOutList();
        list.printList();
    }
}
