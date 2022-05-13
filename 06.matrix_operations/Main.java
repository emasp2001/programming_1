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
public class Main {
    public static void main(String[] argv)
    {
        double[][] matriz=new double[3][3];
        Matriz objetoMatriz = new Matriz();
        
        //Llenar una matriz para probarla.
        matriz[0][0]=1.0;
        matriz[0][1]=2.0;
        matriz[0][2]=3.0;
        matriz[1][0]=4.0;
        matriz[1][1]=5.0;
        matriz[1][2]=6.0;
        matriz[2][0]=7.0;
        matriz[2][1]=8.0;
        matriz[2][2]=9.0;
        
        //Ejercicio 1.
        objetoMatriz.imprimirMatriz(objetoMatriz.multiplicarFila(matriz, 0, 2.0));
        
        //Ejercicio 2.
        objetoMatriz.imprimirMatriz(objetoMatriz.intercambiarFilas(matriz, 1, 2));
        
        //Ejercicio 3.
        objetoMatriz.imprimirMatriz(objetoMatriz.sumarFilas(matriz, 1, 2, 2.0));
        

        
        double[] soluciones=objetoMatriz.reduccionGaussiana(matriz);
        String solucionesTexto="";
        for(int i=0; i<soluciones.length; i++)
        {
            solucionesTexto+=soluciones[i]+", ";
        }
        JOptionPane.showMessageDialog(null, "Las soluciones son: "+solucionesTexto);
        
        System.exit(0);
    }
    
}
