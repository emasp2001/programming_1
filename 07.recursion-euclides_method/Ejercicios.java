package ecci.laboratorio6;
import java.util.Arrays; //Lo importe porque me era mas facil para copiar el Array, en lugar de crear variables para copiar y manejar los rangos los lengths.

/*
 * Aqui es donde estan los ejercicios que se solicitan en la tarea.
 * Una solucion para trabajar con los vectores de tamano impar es recibirlo y si es impar volverlo par agregandole un cero, que voy a borrar una vez termine de ordenar.
 */

/**
 *
 * @author emma
 */
public class Ejercicios {
    Interfaz interfaz = new Interfaz();
    private int[] vectorArbitrario; //Vector para hacer el ejercicio de merge sort.
    
    public Ejercicios()
    {
        vectorArbitrario=new int[8];
        
        //Este es solo un vector de prueba para el ejercicio 3.
        vectorArbitrario[0]=7;
        vectorArbitrario[1]=2;
        vectorArbitrario[2]=5;
        vectorArbitrario[3]=3;
        vectorArbitrario[4]=8;
        vectorArbitrario[5]=4;
        vectorArbitrario[6]=9;
        vectorArbitrario[7]=1;
    }
    
    /*
    * Funcion: consiste en que el usuario piensa un numero y el programa trata de adivinarlo de forma recursiva en siete intentos.
    * Param: recibe la condicion (en formato int) sobre si adivino o no. Ademas de la cantidad de veces que se ha ejecutado, en forma incial es 0. Tambien recibe el numero que se piensa que es, se va a ir modificando segun avance el programa.
    * Condicion: -1 si el numero es menor, 1 si es mayor, 0 si ese es el numero.
    */
    public void adivinarNumero(int condicion, int numeroDeIntentos, int limiteSuperior, int limiteInferior)
    {
        int nSugerido=(limiteSuperior+limiteInferior)/2; //Numero que intenta adivinar. 
        if(numeroDeIntentos>=7)
        {
            interfaz.mensajeParaTramposos();
        } else {
            condicion=interfaz.preguntarSiAdivino(nSugerido);
            switch (condicion){
                case -1: //Para cuando el numero es MENOR.
                    numeroDeIntentos++;
                    adivinarNumero(condicion, numeroDeIntentos, nSugerido, limiteInferior); //Aqui aumento el limite SUPERIOR.
                    break;
                case 1: //Para cuando el numero es MAYOR.
                    numeroDeIntentos++;
                    adivinarNumero(condicion, numeroDeIntentos, limiteSuperior, nSugerido); //Aqui aumento el limite INFERIOR.
                case 0: //Para cuando ya se adivino no se hace nada y solo sale.
                break;
            }     
        }
    }
    
    /*
    * Funcion: metodo recursivo que aplica el algoritmo de Euclides para averiguar el Maximo Comun Divisor de dos numeros enteros. Se detiene cuando el residuo es cero.
    * Param: recibe ambas numeros con los que va a ejecutar el algoritmo.
    * Return: al final de todo el programa retorna el m.c.d.
    */
    public int averiguarMCD(int numero1, int numero2) //En este caso el n1 del dividendo y el n2 del divisor.
    {
        int cociente=numero1/numero2; //Resultado de la division de los dos enteros.
        int residuo=numero1%numero2; //Residuo de la division de ambos numeros.
        int maximoComunDivisor=residuo; //Este es el numero que se devuelve al final. Este seria el residuo de una vuelta antes de que finalice.
        
        if(residuo!=0){
            if(numero2%residuo!=0)
            {
                maximoComunDivisor=averiguarMCD(numero2, residuo);
            }
        }
        return maximoComunDivisor;
    }
    
    /*
    * Funcion: es el metodo principal recursivo para que se haga todo el merge sort.
    * Param: recibe el vector desordenado que se desea ordenar.
    * Return: no retorna nada ya que hace las modicaciones por referencia.
    */
    public void ordenarVector(int[] vector)
    {
        if(vector.length<=1) return;
        int mitadDeVector=(vector.length)/2;
        //int[] vectorUno=copiarVector(vector, 0, mitadDeVector);
        //int[] vectorDos=copiarVector(vector, mitadDeVector, vector.length);
        int vectorUno[]=Arrays.copyOfRange(vector, 0, mitadDeVector);
        int vectorDos[]=Arrays.copyOfRange(vector, mitadDeVector, vector.length);

        //Inicia el proceso recursivo.
        ordenarVector(vectorUno); //Se mete a divir el vector del lado IZQUIERDO.
        ordenarVector(vectorDos); //Se mete a dividir el vector del lado DERECHO.
        unirDosVectores(vector, vectorUno, vectorDos); //Ya una vez que han sido dividos se empieza a salir para unirlos.
    }
    
    /*
    * Funcion: se encarga de unir dos vectores en forma ordenada.
    * Param: recibe el vector principal en el que se van a unir los dos vectores que se necesitan ordenar.
    * Retrun: regresa el vector unido y ordenado.
    */
    private void unirDosVectores(int[] vectorPrincipal, int[] vectorIzquierda, int[] vectorDerecha)
    {
        int auxiliarA=0;
        int auxiliarB=0;
        for(int i=0; i<vectorPrincipal.length; i++){
            if(auxiliarA>=vectorIzquierda.length){
                vectorPrincipal[i]=vectorDerecha[auxiliarB];
                auxiliarB++;
                continue;
            }
            if(auxiliarB>=vectorDerecha.length){
                vectorPrincipal[i]=vectorIzquierda[auxiliarA];
                auxiliarA++;
                continue;
            }
            if(vectorIzquierda[auxiliarA]<vectorDerecha[auxiliarB]){
                vectorPrincipal[i]=vectorIzquierda[auxiliarA];
                auxiliarA++;
            }else{
                vectorPrincipal[i]=vectorDerecha[auxiliarB];
                auxiliarB++;
            }
        }
    }
    
    public int[] getVectorArbitrario()
    {
        return vectorArbitrario;
    }
    
    /*
    * Funcion: copiar la parte de un vector en otro.
    * Param: recibe el vectorOriginal, la posicion inicial, y la posicion final.
    * Return: retorna el vector copiado.
    */
    private int[] copiarVector(int[] vectorOriginal, int posInicial, int posFinal)
    {
        int[] nuevoVector=new int[(posFinal-posInicial)+1]; //Asegura tener la dimension correcta.
        
        //Copia el vector.
        for(int i=0; i<nuevoVector.length; i++)
        {
            nuevoVector[i]=vectorOriginal[posInicial];
            posInicial++;
        }
        
        return nuevoVector;
    }
}
