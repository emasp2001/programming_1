package ecci.laboratorio6;

/*
 * Permite la comunicacion con el usuario.
 */

/**
 *
 * @author emma
 */
import javax.swing.JOptionPane;
public class Interfaz {
    private final String MENSAJEPARATRAMPOSOS = "Usted es un tramposo, ha cambiado el numero.";
    /*
    * Funcion: se encarga de consultarle al usuario si la compu adivino el numero.
    * Param: recibe el numero que la computadora esta sugeriendo.
    * Return: regresa -1 si el numero es menor, 1 si es mayor, 0 si ese es el numero.
    */
    public int preguntarSiAdivino(int numeroPensado)
    {
        int condicion=-1; //Se refiere a la condicion de si la computadora adivino o no.
        try{
            condicion=Integer.parseInt(JOptionPane.showInputDialog(null, "El numero es: "+numeroPensado+"?\n Digite -1 si el numero es menor, 1 si es mayor, 0 si ese es el numero."));
            if(condicion>1 || condicion<-1) //Comprueba que el usuario ponga una opcion que hace que se me caiga el sistema.
            {
                JOptionPane.showMessageDialog(null, "Ingreso una opcion no valida.");
                condicion=preguntarSiAdivino(numeroPensado);
            }
        } catch(NumberFormatException e){ //En caso que el usuario digite lo que no se le pide, un int.
            JOptionPane.showMessageDialog(null, "Formato de numero incorrecto.");
            condicion=preguntarSiAdivino(numeroPensado);
        }
        return condicion;
    }
    
    /*
    * Funcion: se despliega este mensaje en caso de que el jugador haya hecho trampa en adivinar el numero. Si el usuario es sincero el programa lo va a averiguar en <=7 intentos.
    */
    public void mensajeParaTramposos()
    {
        JOptionPane.showMessageDialog(null, MENSAJEPARATRAMPOSOS);
    }
    
    /*
    * Funcion: se encarga de pedir el numero n que se necesita, principalmente para calcular el m.c.d de dos numeros.
    * Param: recibe un int solo para indicar que numero se esta pidiendo.  
    * Return: devuelve el numero que puso el usuario.
    */
    public int pedirNumeroN(int posicion)
    {
        int numero=-1; //Numero que ingreso el usuario
        try{
            numero=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero "+posicion+" que desea averiguar."));
        } catch(NumberFormatException e){ //En caso que el usuario digite lo que no se le pide, un int.
            JOptionPane.showMessageDialog(null, "Formato de numero incorrecto.");
            numero=preguntarSiAdivino(posicion);
        }
        return numero;
    }
    
    /*
    * Funcion: imprime el m.c.d ya averiguado en la otra clase (Ejercicios). 
    * Param: recibe el numero solucion.
    */
    public void imprimirMCD(int solucion)
    {
        JOptionPane.showMessageDialog(null, "El Maximo Comun Divisor (m.c.d) de los numeros que habia consultado es: "+solucion);
    }
    
    /*
    * Funcion: imprime un vector.
    * Param: recibe el vector que se quiere imprimir.
    */
    public void printVector(int[] vector)
    {
        String vectorTexto="";
        
        //Llena el String.
        for(int i=0; i<vector.length; i++)
        {
            vectorTexto+=vector[i]+", ";
        }
        
        //Imprime.
        JOptionPane.showMessageDialog(null, "El vector es: "+vectorTexto);
    }
    
    /*
    * Funcion: solo para ir anunciando el ejercicio que se va realizando.
    */
    public void anunciarEjercicio(int numeroEjercicio)
    {
        String objEj1="1: Averiguar el Maximo Comun Divisor de dos numeros, usando el algoritmo de Euclides.";
        String objEj2="2: Adivinar el numero que el usuario esta pensando.";
        String objEj3="3: Ordenar un vector segun el algoritmo de Merge Sort.";
        String mensajeUsar=null;
        
        switch(numeroEjercicio)
        {
            case 1:
                mensajeUsar=objEj1;
                break;
            case 2:
                mensajeUsar=objEj2;
                break;
            case 3:
                mensajeUsar=objEj3;
                break;
            default:
                mensajeUsar="No hay mas ejercicios por realizar.";
                break;
        }
        JOptionPane.showMessageDialog(null, "Ejercicio "+mensajeUsar);
    }
}
