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
import javax.swing.JOptionPane;
public class Interfaz {
    private final String MENSAJETIPOENTRADADATOS;
    private int numeroDeEjercicio; //Variable para contar que ejercicio estoy realizando.
    
    public Interfaz()
    {
        MENSAJETIPOENTRADADATOS = "Solo puede escribir numeros enteros.";
        numeroDeEjercicio=1;
    }
    /*
    * Obtiene el tamano de las FILAS para inicializar la matriz en el ejercicio1
    * Return: un int con el tamano deseado
    */
    public int getFilaSize()
    {
        final String MENSAJEFILAS = "Ingrese la cantidad de filas que desea que tenga su matriz.";
        int filaSize=-1;
        try{
            filaSize=Integer.parseInt(JOptionPane.showInputDialog(null, MENSAJEFILAS, MENSAJETIPOENTRADADATOS));
        } catch (NumberFormatException e){
            filaSize=getFilaSize();            
        }
        return filaSize;
    }
    /*
    * Obtiene el tamano de las COLUMNAS para inicializar la matriz en el ejercicio1
    * Return: un int con el tamano deseado
    */
    public int getColumnaSize()
    {
        final String MENSAJECOLUMNAS = "Ingrese la cantidad de columnas que desea que tenga su matriz.";
        int columnaSize=-1;
        try{
            columnaSize=Integer.parseInt(JOptionPane.showInputDialog(null, MENSAJECOLUMNAS, MENSAJETIPOENTRADADATOS));
        } catch (NumberFormatException e){
            columnaSize=getColumnaSize();
        }
        return columnaSize;
    }
    /*
    * Funcion: imprime una matriz recibida.
    * Param: recibe la matriz que se desea imprimir
    */
    public void printMatriz(int[][] matriz)
    {
        String matrizTexto="";
        for(int filas=0; filas<matriz.length; filas++) //Recorre todas las filas de la matriz.
        {
            matrizTexto+="\n";
            for (int columnas=0; columnas<matriz[filas].length; columnas++) //Recorre todas las columnas de la matriz para poder recorrerla toda.
            {
                matrizTexto+=matriz[filas][columnas]+", ";
            }
        }
        JOptionPane.showMessageDialog(null, "La matriz es:\n\n"+matrizTexto);
    }
    /*
    * Este codigo es solo para mostrar cual ejercicio del laboratorio esta realizando.
    */
    public void contadorDeEjercicio()
    {
        JOptionPane.showMessageDialog(null, "Ejercicio "+numeroDeEjercicio);
        numeroDeEjercicio++;
    }
    
}
