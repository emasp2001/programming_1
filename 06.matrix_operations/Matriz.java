package ecci.laboratorio5;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emma
 */
import javax.swing.JOptionPane;
public class Matriz {
    /*
    * Funcion: multiplica la fila recibida por la constante recibida.
    * Param: 
    *   matriz1: la matriz a la cual le voy a aplicar el cambio.
    *   numeroFila: es la numero de la fila que quiere multiplicar.
    *   constante: el numero por cual voy a multiplicar la matriz.
    * Return: devuelve la matriz con los cambios hechos.
    */
    public double[][] multiplicarFila(double[][] matriz, int numeroFila, double constante)
    {
        //Recorre las posiciones de la fila para realizar la multiplicacion.
        for(int j=0; j<matriz[numeroFila].length; j++)
        {
            matriz[numeroFila][j]*=constante;
        }
        return matriz; //La regresa ya con la matriz con los cambios realizados.
    }   
    
    /*
    * Funcion: realiza el intercambio de dos filas de una matriz.
    * Param: matriz, fila1, fila2.
    * Return: devuelve la matriz modificada.
    */
    public double[][] intercambiarFilas(double[][] matriz, int fila1, int fila2)
    {
        double temp=-1; //Valor que me permite hacer el interecambio como auxiliar.
        //Se encarga de cambiar las respectivas filas, valor por valor.
        for (int j=0; j<matriz[fila1].length; j++)
        {
            temp=matriz[fila1][j];
            matriz[fila1][j]=matriz[fila2][j];
            matriz[fila2][j]=temp;
        }
        return matriz; //La regresa ya con la matriz con los cambios realizados.
    }
    
    /*
    * Funcion: se encarga de sumarle a la fila1 la (fila2*constanteRecibida).
    * Param: matriz, fila1, fila2, constante a multiplicar.
    * Return: regresa la matriz con las modificaciones hechas.
    */
    public double[][] sumarFilas(double[][] matriz, int fila1, int fila2, double constante)
    {
        //Se encarga de moverse a travez de la fila para realizar la operacion.
        for (int j=0; j<matriz[fila1].length; j++)
        {
            matriz[fila1][j]+=(matriz[fila2][j]*constante);
        }
        return matriz; //La regresa ya con la matriz con los cambios realizados.
    }
    
    /*
    * Funcion: resuelve el S.E.L usando el metodo de reduccion Gaussiana.
    * Param: recibe una matriz de tamano n*(n+1) la cual es la que tiene que averiguar su solucion.
    * Return: retorna un vector con el conjuto de soluciones respectivas.
    */
    public double[] reduccionGaussiana(double[][] matriz) //FALTA EL CODIGO EN CASO QUE ENCUENTRE 0 EN EL VALOR [fila][auxiliar].
    {
        int filas=matriz.length; //Para simplificar en vez de usar tanto .length.
        int columnas=matriz[filas].length; //Para simplificar en vez de usar tanto .length.
        double[] soluciones=new double[filas]; //En este vector van a ir almacenadas las soluciones del S.E.L.
        
        //Compruebo que la matriz tenga las dimensiones correctas.
        if(columnas==filas+1)
        {
            int auxiliar=0; //Me va a ayudar a ir trabajando los indices de las columnas.
            double a=-1; //Valor de la posicion que necesito convertir a uno.
            double b=-1; //Valor de la posicion que necesito convertir a cero.
            double x=-1; //Incognita que debo averiguar con a, y b. Usando la formula x = (-(a))/b para convertir a ceros; y x=b/a para convertir a uno.
            
            //Ciclo donde va a repetir el mismo proceso para todas las columnas hasta columnas-1 para hallar la solucion.
            for(int i=0; i<filas; i++)
            {
                //Para convertir en unos.
                a=matriz[i][auxiliar];
                b=1; //Dado que necesito convertir la uno entonces b vale uno.
                x=(b)/(a); //Ecuacion que me permite averiguar el valor por el que debo multiplicar.
                multiplicarFila(matriz, i, x); //Le paso a i porque es en esa fila donde necesito convertir a uno, y x es la constante que encontro.            
                
                //Para covertir en ceros.
                for(int k=0; k<filas; k++) //Este for es para que ejecute el codigo de convertir a ceros en todas las filas menos en la que estoy trabajando, 'i'.
                {
                    if(k!=i) //Esto me permite asegurar que no me toque la fila en la que estoy trabajando, 'i'.
                    {
                        b=matriz[i][auxiliar]; //Valor que converti a uno.
                        a=matriz[k][auxiliar]; //Valor que necesito convertir.
                        x=(-(a))/b; //Formula para averiguar el valor de x.
                        
                        sumarFilas(matriz, k, i, x); //Aqui es donde mando a que se haga toda la operacion. En este caso fila1 es 'k' porque es la que necesito variar en base a 'i'.
                    }
                }
                auxiliar++;            
            }
            
            //Copiar la ultima fila de la matriz, las soluciones, en el vector soluciones.
            for(int i=0; i<filas; i++)
            {
                soluciones[i]=matriz[i][columnas-1]; //Copia cada solucion.
            }
            
        } else {
        //Codigo para indicar que ingreso una matriz con dimensiones NO validas.
        }
        return soluciones;
    }
    
    /*
    * Funcion: imprime una matriz en texto.
    * Param: recibe la matriz que se desea imprimir, de tipo Double.
    */
    public void imprimirMatriz(double[][] matriz)
    {
        String matrizEnTexto="";
        for(int i=0; i<matriz.length; i++) //Recorre todas las filas.
        {
            matrizEnTexto+="\n";
            for(int j=0; j<matriz[i].length; j++) //Recorre todas las columnas.
            {
                matrizEnTexto+=matriz[i][j]+", ";
            }
        }
        JOptionPane.showMessageDialog(null, "La matriz resultante es :\n"+matrizEnTexto);
    }
}
