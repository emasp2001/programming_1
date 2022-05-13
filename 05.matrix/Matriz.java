/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio4;

/**
 *
 * @author emanu
 */
public class Matriz {
    private int filaSize; //El valor de las dimensiones lo voy a necesitar para otro ejercicio.
    private int columnaSize;
    private int[][] matrizEj1; //Matriz para el ejercicio 1 del Laboratorio 4.
    private int[][] matrizEj2; //Matriz para el ejercicio 2 del Laboratorio 4.
    private int[][] matrizMultiplicada; //Matriz para el ejercicio 3 del Laboratorio 4.
    
    public Matriz(int _filaSize, int _columnaSize)
    {
        this.filaSize=_filaSize;
        this.columnaSize=_columnaSize;
        matrizEj1 = new int[filaSize][columnaSize];
    }
    public int[][] getMatrizEj1()
    {
        return matrizEj1;
    }
    public int[][] getMatrizEj2()
    {
        return matrizEj2;
    }
    public int[][] getMatrizMultiplicada()
    {
        return matrizMultiplicada;
    }
    /*
    * Funcion: se encarga de llenar la matriz en forma aspiral.
    */
    public void llenarMatrizAspiral()
    {
        int filaSize=matrizEj1.length; //Cantidad de filas de la matriz.
        int columnaSize=matrizEj1[0].length; //Cantidad de columnas de la matriz.
        int valorLlenar=1; //Numero con el que voy a ir llenando.
        
        int auxiliarA=0; //Me va ayudar a poder ir iniciando en la posicion correcta.
        int auxiliarB=filaSize-1; //Me va a ayudar a indicar los limites para las FILAS.
        int auxiliarC=columnaSize-1; //Me va a ayudar a indicar los limites para las COLUMNAS.
        int auxiliarD=auxiliarC; //Esta es una auxiliar especial que necesito varias SOLOS si Filas<Columnas, por eso aqui es igual.
        int auxiliarE=auxiliarC; //Esta auxiliar me va a ayudar en el codigo de llenar hacia la izquierda solo para el caso donde Filas<Columnas sino queda igual.
        
        if(filaSize<columnaSize)
        {
            auxiliarC=auxiliarB; //Para que no haga overflow.
            auxiliarD=auxiliarC+1; //Para que llegue hasta el verdadero limite porque de lo contrario deja un posicion sin tomar en cuenta.
            auxiliarE+=1; //Esto lo hago para que B a la hora de que se le reste 1 en la izquierda quede igual.
            auxiliarC=columnaSize-1;
        }
        
        //For para que se ejecute para toda la matriz.
        for(int j=0; j<matrizEj1.length; j++){
            
            //For para llenar hacia la DERECHA.
            for(int i=auxiliarA; i<=auxiliarC; i++)
            {
                matrizEj1[auxiliarA][i]=valorLlenar;
                valorLlenar++;
            }

            //For para llenar hacia ABAJO.
            for(int i=auxiliarA+1; i<=auxiliarB; i++) 
            {
                matrizEj1[i][auxiliarD]=valorLlenar;
                valorLlenar++;
            }

            //For para llenar hacia la IZQUIERDA.
            for(int i=auxiliarE-1; i>=auxiliarA; i--)
            {
                matrizEj1[auxiliarB][i]=valorLlenar;
                valorLlenar++;
            }

            //For para llenar hacia ARRIBA.
            for(int i=auxiliarB-1; i>=auxiliarA+1; i--)
            {
                matrizEj1[i][auxiliarA]=valorLlenar;
                valorLlenar++;
            }
            
            auxiliarA++; //Esto es para que a me inicie en la posicion que corresponde.
            //Estas demas se les restan para que haga la vuelta para la proxima matriz que queda adentro vacia.
            auxiliarB--; 
            auxiliarC--;
            auxiliarD--;
            auxiliarE--; 
        }
    }
    
    public void llenarMatrizEj2(int _sizeColumnas)
    {
        matrizEj2=new int[columnaSize][_sizeColumnas];
        int numeroLlenar=1; //Numero con el que se va a ir llenando la matriz.
        //Codigo para llenar la matriz inicialmente
        for(int filas=0; filas<matrizEj2.length; filas++) //Recorre todas las filas de matriz.
        {
            for (int columnas=0; columnas<matrizEj2[filas].length; columnas++) //Recorre todas las columnas de matriz.
            {
                matrizEj2[filas][columnas]=numeroLlenar;
                numeroLlenar++;
            }
        }
        //Codigo para que analice todas las posiciones de la matriz para saber si es primo o no.
        for (int filas=0; filas<matrizEj2.length; filas++) //Recorre todas las filas de matriz.
        {
            for (int columnas=0; columnas<matrizEj2[filas].length; columnas++) //Recorre todas las columnas de matriz.
            {
                if(esPrimo(matrizEj2[filas][columnas])==true) //Se da cuenta si el valor de la posicion es primo.
                {
                    matrizEj2[filas][columnas]=0; //En caso de ser primo lo reemplaza por un 0.
                }
            }
        }
        
    }
    /*
    * NOTA: saque este codigo de un ejercicio del Laboratorio 2.
    * Se encarga de averiguar si un numero es primo o no.
    * Return: retorna un boolean con la condicion.
    */
    private boolean esPrimo(int writedNumber)
    {
        boolean numberCondition=true;
        if(writedNumber==1 || writedNumber%2==0||writedNumber%3==0||writedNumber%5==0)
        {
            numberCondition=false;
        }
        switch(writedNumber) //Este switch es para manejar las excepciones mas comunes de los numeros primos.
        {
            case 2:
                numberCondition=true;
            break;
            case 3:
                numberCondition=true;
            break;
            case 5:
                numberCondition=true;
            break;
                
        }
        return numberCondition;
    }
    /*
    * NOTA: la multiplicacion se solo cuando el numero de columnas de la primera matriz==al numero de filas de la segunda matriz. 
    * IMPORTANTE: en la multiplicacion de matrices NO aplica la propiedad conmutativa. 
    * REUTILIZAR: en caso que desee reutilizar este codigo solo pongalo a recibir pametros como matrizEj1 para la matriz a multiplicar1 y matrizEj2 para la matriz a multiplicar 2; y que retorne la matriz multiplicada.
    * Este metodo se encarga de hacer la multiplicacion de las dos primeras matrices.
    */
    public void multiplicarMatrices()
    {
        int sizeFilasPrimeraMatriz=matrizEj1.length; //Obtiene el tamano de las filas de la PRIMERA matriz.
        int sizeColumnasPrimeraMatriz=matrizEj1[0].length; //Obtiene el tamano de las columnas de la PRIMERA matriz.
        int sizeFilasSegundaMatriz=matrizEj2.length; //Obtiene el tamano de las filas de la SEGUNDA matriz.
        int sizeColumnasSegundaMatriz=matrizEj2[0].length; //Obtiene el tamano de las columnas de la SEGUNDA matriz.
        
        matrizMultiplicada=new int[sizeFilasPrimeraMatriz][sizeColumnasSegundaMatriz]; //Crea la nueva matriz con las dimensiones algebraicas correctas.
        
        //Aunque en este caso no es necesario hacer la comprobacion de que las dimensiones sean correctas para poder crear la matriz lo voy a hacer para que el codigo sea reutilizable.
        if(sizeColumnasPrimeraMatriz==sizeFilasSegundaMatriz){ //Comprueba que pueda realizar la multiplicacion.
            //For para que se mueva en las filas.
            for (int filas=0; filas<sizeFilasPrimeraMatriz; filas++){ 
                //For para que se mueva en las columnas.
                for (int columnas=0; columnas<sizeColumnasSegundaMatriz; columnas++){
                    //For para que se vaya moviendo y sumando entre filas y columnas de ambas matrices.
                    for (int i=0; i<sizeColumnasPrimeraMatriz; i++){
                        // aquí se multiplica la matriz
                        matrizMultiplicada[filas][columnas]+=matrizEj1[filas][i] * matrizEj2[i][columnas];
                    }
                }
            }
        }
    }

    public int[][][] createRubickCube(int filas, int columnas, int interno) {
        int[][][] my_cube = new int[filas][columnas][interno];
        int relleno = 0;
        for(int iterador1 = 0; iterador1<filas; iterador1++){
            for(int iterador2 = 0; iterador2<columnas; iterador2++) {
                for(int iterador3 = 0; iterador3<interno; iterador3++) {
                    my_cube[iterador1][iterador2][iterador3] = relleno;
                    relleno++;
                }
            }
        }
        return my_cube;
    }
}
