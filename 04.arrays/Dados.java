/*
 * Juego donde debo tratar de adivinar la suma del resultado de los cuatro dados.

/**
 *
 * @author emma
 */
public class Dados {
    private final int CANTIDADDECARAS;
    private final int CANTIDADDEDADOS;
    private final int CANTIDADDESIMULACIONESDESEADAS;
    private final int ARRAYSIZE;
    private int[][] numerosPosibles; //La primer fila son los numeros posibles y la segunda son su frecuencia.
    
    public Dados(int cantidadDados, int cantidadCaras, int cantidadSimulaciones)
    {
        this.CANTIDADDECARAS=cantidadCaras;
        this.CANTIDADDEDADOS=cantidadDados;
        this.CANTIDADDESIMULACIONESDESEADAS=cantidadSimulaciones;
        
        final int numeroMinimoPosible=cantidadDados;
        final int numeroMaximoPosible=CANTIDADDECARAS*CANTIDADDEDADOS;
        final int cantidadNumerosPosibles=numeroMaximoPosible-numeroMinimoPosible;
        
        numerosPosibles=new int[cantidadNumerosPosibles+1][2];
        ARRAYSIZE=numerosPosibles.length;
        int numeroPosible=numeroMinimoPosible; //Esta variable se crea para que con esta se pueda ir llenando el array.
        
        for (int i=0; i<ARRAYSIZE; i++) //Esto se hace para que en la primera fila se encuentren todos los numeros posibles ordenados desde el mas pequeno.
        {
            numerosPosibles[i][0]=numeroPosible;
            numeroPosible++;
            for(int j=0; j<ARRAYSIZE; j++) //Esto asigna la frecuencia inicial a cada valor posible.
            {
                numerosPosibles[j][1]=0;
            }
        }
        simularLanzamientoDeDados();
    }
    private void asignarFrecuencia(int numeroSacado)
    {
        int contador=0;
        while(numerosPosibles[contador][0]!=numeroSacado)
        {
            if(numerosPosibles[contador][0]==numeroSacado)
            {
                numerosPosibles[contador][1]++; //Esto aumenta el tamano de la frecuencia.
            }
            contador++;
        }
    }
    public void simularLanzamientoDeDados() //Crea una simulacion de lanzar los dados n veces para averiguar cual es el mas posible.
    {
        int numeroSimulado=-1;
        for(int i=0; i==CANTIDADDESIMULACIONESDESEADAS; i++)
        {
            for (int j=0; j==CANTIDADDEDADOS; j++){
                numeroSimulado+=((int)((Math.random()*CANTIDADDECARAS)+1));
            }
            asignarFrecuencia(numeroSimulado);
        }
    }
    public int getNumeroConMayorFrecuencia()
    {
        int mayorFrecuencia=numerosPosibles[0][1];
        int coordenada=0;
        for (int i=0; i<numerosPosibles.length; i++)
        {
            if(numerosPosibles[i][1]>mayorFrecuencia)
            {
                mayorFrecuencia=numerosPosibles[i][1];
                coordenada=i;
            }
        }
        return numerosPosibles[coordenada][0];
    }
}
