/*
Debe poseer los atributos necesarios para almacenar la información de ambos tableros de juego para el jugador
    (la flota del jugador + disparos recibidos; y los disparos realizados). 

Cada jugador posee dos tableros de tamaño 10 x 10: uno con el que llevan el control de su propia flota y los tiros disparados por el enemigo;
    y otro para llevar el control de sus propios disparos y los posibles daños ocasionados a la flota enemiga. El tablero generalmente suele utilizar un sistema de coordenadas donde las letras de la A a la J representan el número de fila y los números del 1 al 10 las columnas.
	
Cada jugador a su vez posee 5 barcos: 
    Portaaviones 5 casillas.
    Buque 4 casillas.
    Submarino 3 casillas.
    Nave 3 casillas.
    Lancha 2 casillas.
    
Al iniciar el juego cada jugador debe posicionar los barcos en su tablero, sin decirle al rival en que posición los ubicó.

Metodos: 
posicionar que inicializará los barcos en posiciones al azar pero válidas (ninguna parte del barco puede estar fuera del tablero) y con orientación aleatoria (vertical/horizontal).
Listo	◦Método validar_coordenada que recibe una fila (1-10) y una columna (1-10) y retorne si el jugador NO ha disparado previamente a esa posición.
Listo	◦Método anotar_disparo que recibe una fila (1-10), una columna (1-10) y si el disparo dio en un objetivo o no; 
            esta información debe almacenarse en el tablero de disparos del jugador.
Listo	◦Método recibir_impacto que recibe una fila (1-10) y una columna (1-10), este método debe modificar los valores en el tablero de barcos para
            el jugador y retornar si el disparo golpeo un barco o no. Además debe imprimir “agua” o “tocado” dependiendo de si el disparo recibido golpeó algún barco.
Listo	◦Método perdio que debe retornar verdadero si el jugador perdió el juego (un jugador pierde el juego si todos sus barcos se encuentran hundidos).
Listo	◦Método imprimir que debe imprimir de manera legible ambos tableros del jugador. (En ambos casos los tableros deben mostrar
            la guía para filas 1-10 y la guía para columnas 1-10).

Falta el metodo para posicionar los barcos.

Recomendación: utilice lo siguiente para los tableros.
    _: Espacios que no se han utilizado.
    B: los barcos.
    O: los disparos fallidos hacia el otro jugador.
    X: disparos exitosos.   
    
        ▪Utilizar una subfunción que permita imprimir una matriz podría ser útil.
    
 */
package ecci.examen1;

/**
 *
 * @author emma
 */
import javax.swing.JOptionPane;
public class Jugador {
    private char[][] disparos; //Matriz donde se lleva el control de los disparos que ha hecho en contra del otro jugador, y su condicion.
    private char[][] barcos; //Matriz donde se lleva el control de sus propios barcos y los disparos que ha recibido.
    
    public Jugador()
    {
        //Es el tamano de forma fija que tienen los tableros.
        disparos=new char[10][10];
        barcos=new char[10][10];
        
        //Llenar la matriz de barcos con '_'.
        for(int i=0; i<barcos.length; i++)
        {
            for(int j=0; j<barcos[0].length; j++)
            {
                barcos[i][j]='_';
            }
        }
        
        //Llenar la matriz de disparos con '_'.
        for(int i=0; i<disparos.length; i++)
        {
            for(int j=0; j<disparos[0].length; j++)
            {
                disparos[i][j]='_';
            }
        }
    }
    
    /*
    * Funcion: recibe una fila (1-10) y una columna (1-10) y retorne si el jugador NO ha disparado previamente a esa posición.
    * Ya debe venir con comprobado que las dimensiones no me generan overflow.
    */
    public boolean validarCoordenada(int fila, int columna)
    {
        boolean haDisparado=false;
        //Se les debe restar 1 a las coordenadas porque el jugador lo lee segun los indices normales.
        if(barcos[fila-1][columna-1]!='_') //'_' es el caracter escogido para representar que no se ha hecho nada ahi.
        {
            haDisparado=true;
        }
        
        return haDisparado;
    }
    
    /*
    * Funcion: recibe una fila (1-10), una columna (1-10) y si el disparo dio en un objetivo o no
               esta información debe almacenarse en el tablero de disparos del jugador.
    */
    public boolean anotarDisparo(int fila, int columna, boolean dioEnObjetivo)
    {   
        //En caso que el dispara caiga en el agua. Ademas restar 1 a fila y columna por como los lee el usuario.
        if(dioEnObjetivo==false)
        {
            disparos[fila-1][columna-1]='O'; //'O' representa el agua.
        } else {
            //En caso que caiga en un barco.
            disparos[fila-1][columna-1]='X'; //'X' representa que golpeo un barco.
        }
        
        return dioEnObjetivo;
    }
    
    /*
    * Funcion: recibe una fila (1-10) y una columna (1-10), este método debe modificar los valores en el tablero de barcos para el jugador y retornar 
               si el disparo golpeo un barco o no. Además debe imprimir “agua” o “tocado” dependiendo de si el disparo recibido golpeó algún barco.
    */
    public boolean recibirImpacto(int fila, int columna)
    {
        boolean golpeoBarco=false; //Se convierte en true si las coordenadas recibidas han golpeado un barco.
        
        //Comprueba en el tablero "barcos". Les resta 1 a las coordenadas porque asi lo lee el usuario.
        if(barcos[fila-1][columna-1]=='B') //B indica que alli hay un barco y que este no ha sido golpeado.
        {
            golpeoBarco=true;
            JOptionPane.showMessageDialog(null, "tocado");
        } else {
            JOptionPane.showMessageDialog(null, "agua");
        }
        
        return golpeoBarco;
    }
    
    /*
    * Funcion: retornar verdadero si el jugador perdió el juego (un jugador pierde el juego si todos sus barcos se encuentran hundidos).
    */
    public boolean perdio()
    {
        boolean juegoPerdido=true; //Si recorro toda la matriz y encuentro al menos una 'B' significa que no ha perdido y por ende cambio esta.
        
        //Recorro toda la matriz "barcos".
        for(int i=0; i<barcos.length; i++)
        {
            for(int j=0; j<barcos[i].length; j++)
            {
                if(barcos[i][j]=='B') //'B' representa el barco, que exista uno significa que no ha perdido.
                {
                    juegoPerdido=false;
                    break; //Para salirme del ciclo si ya encontro uno.
                }
            }
        }
        
        return juegoPerdido;
    }
    
    /*
    * Funcion: generar y retornar un String con el tablero barcos.
    */
    public String toStringBarcos()
    {
        String barcosTablero="";
        int indiceAgregar = 0; //Solo es para enumerar
        String indicesArriba = "\nBarcos:\n 1 2 3 4 5 6 7 8 9";
        
        //Con esto consigo enumerar las columnas;
        for(int i=1; i==barcos[0].length; i++)
        {
            barcosTablero+=i+" ";
        }
        barcosTablero+="\n"; //Para cambiar de linea luego de haber asignada los indices.
        
        //Recorrer toda la matriz.
        for(int i=0; i<barcos.length; i++)
        {
            indiceAgregar=i+1;
            barcosTablero+=indiceAgregar+"    "; //Con esto consigo enumerar cada fila.
            for(int j=0; j<barcos[i].length; j++)
            {
                barcosTablero+=barcos[i][j]+"";
            }
            barcosTablero+="\n";
        }
        indicesArriba+=barcosTablero;
        
        return indicesArriba;
    }
    
    /*
    * Funcion: generar y retornar un String con el tablero disparos.
    */
    public String toStringDisparos()
    {
        String disparosTablero="";
        int indiceAgregar = 0; //Solo es para enumerar
        String indicesArriba = "Disparos:\n 1 2 3 4 5 6 7 8 9";
        
        //Con esto consigo enumerar las filas;
        for(int i=1; i==disparos[0].length; i++)
        {
            disparosTablero+=i+" ";
        }
        disparosTablero+="\n"; //Para cambiar de linea luego de haber asignada los indices.*/
        
        //Recorrer toda la matriz.
        for(int i=0; i<disparos.length; i++)
        {
            indiceAgregar=i+1;
            disparosTablero+=indiceAgregar+"    "; //Con esto consigo enumerar cada fila.
            for(int j=0; j<disparos[i].length; j++)
            {
                disparosTablero+=disparos[i][j]+"";
            }
            disparosTablero+="\n";
        }
        indicesArriba+=disparosTablero;
        
        return indicesArriba;
    }
    
    /*
    * Funcion: debe imprimir de manera legible ambos tableros del jugador. (En ambos casos los tableros deben mostrar
               la guía para filas 1-10 y la guía para columnas 1-10).
    */
    public void imprimir()
    {
        JOptionPane.showMessageDialog(null, toStringDisparos()+toStringBarcos());
    }
    
    /*
    * Funcion: se encarga de posicionar los barcos en el tablero. 
               Lo hace tomando una posicion al azar del tablero y si esa posicion esta libre y las demas casillas que ocuparia segun el size del barco 
               y segun la orientacion entonces lo coloca ahi, sino entonces vuelve a generar el random hasta que se de un caso.
    
    Barcos: 
        0. Portaaviones 5 casillas.
        1. Buque 4 casillas.
        2. Submarino 3 casillas.
        3. Nave 3 casillas.
        4. Lancha 2 casillas.
    */
    public void posicionarBarcos()
    {
        int filaAzar=-1;
        int columnaAzar=-1;
        int orientacion=-1; //0 horizontal, 1 vertical.
        boolean sePuedePoner=true; //Es para saber si desde esa posicion la puedo colocar.
        int tipoBarco=0; //Es el tipo de barco que debo asignar.
        int sizeBarco=0; //Segun el tipo de barco ese va a ser el size que se aumente.
        
        //Repetir para todos los barcos
        for(int j=0; j<5; j++) //Esto porque solo hay cuatro tipos de barcos.
        {
            //Fase 1: seleccionar el tipo de barco que voy a trabajar.
            tipoBarco=j;
            switch(tipoBarco)
            {
                //A cada uno le resto una unidad porque ya tengo una posicion.
                case 0: //Portaviones, 5 casillas.
                    sizeBarco=4;
                    break;
                case 1: //Buque, 4 casillas.
                    sizeBarco=3;
                    break;
                case 2: //Submarino, 3 casillas.
                    sizeBarco=2;
                    break;
                case 3: //Nave, 3 casillas.
                    sizeBarco=2;
                    break;
                case 4: //Lancha, 2 casillas.
                    sizeBarco=1;
                    break;
            }
            
            
            //Fase 2: encontrar una posicion en la que pueda colocar el barco.
            do
            {
                sePuedePoner=true; //Cada vuelta soy optimista y pienso que si se puede poner.
                
                filaAzar=(int)(Math.random()*barcos.length);
                columnaAzar=(int)(Math.random()*barcos[filaAzar].length);
                orientacion=(int)(Math.random()*2); //0 horizontal, 1 vertical.

                //Comprobar que todas las demas casillas esten vacias y que no se de un overflow.
                if(orientacion==0) //Debo comprobar de forma horizontal, asi que me muevo en columnas.
                {
                    for(int i=columnaAzar; i==i+sizeBarco; i++)
                    {
                        if(i>=barcos[0].length) //En caso que el barco se vaya a colocar fuera de los limites.
                        {
                            sePuedePoner=false;
                        } else {
                            char auxiliar=barcos[filaAzar][i];
                            if(auxiliar!='_') //Si es distinto a eso significa que ya esta ocupado.
                            {
                                sePuedePoner=false;
                            }
                        }
                        if(sePuedePoner==true)
                        {
                            this.barcos[filaAzar][i]='B'; //'B' indica que hay un barco alli.
                        }
                    }
                } else { //Debo comprobar de forma vertical, asi que me muevo en las filas.
                    for(int i=filaAzar; i==i+sizeBarco; i++)
                    {
                        if(i>=barcos.length) //En caso que el barco se vaya a colocar fuera de los limites.
                        {
                            sePuedePoner=false;
                        } else {
                            char auxiliar=barcos[i][columnaAzar];
                            if(auxiliar!='_') //Si es distinto a eso significa que ya esta ocupado.
                            {
                                sePuedePoner=false;
                            }
                        }
                        if(sePuedePoner==true)
                        {
                            this.barcos[i][columnaAzar]='B'; //'B' indica que hay un barco alli.
                        }
                    }
                }
            } while (sePuedePoner!=true); //Me detengo cuando ya se que lo puedo poner alli.
            //Fase 3: colocar el barco cuando ya encontre una posicion que me permite ponerlo.
            
            /*if(orientacion==0) //Me muevo en las columnas.
            {
                for(int i=columnaAzar; i==i+sizeBarco; i++)
                {
                    this.barcos[filaAzar][i]='B'; //'B' indica que hay un barco alli.
                }
            } else { //Me muevo en las columnas.
                for(int i=filaAzar; i==i+sizeBarco; i++)
                {
                    this.barcos[i][columnaAzar]='B'; //'B' indica que hay un barco alli.
                }
            }*/
            //Fase 4: repetir el proceso para todos los barcos.
        } 
    }
}