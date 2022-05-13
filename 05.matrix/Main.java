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
import laboratorio4.Interfaz; //Indica de donde estoy sacando las clase.
import laboratorio4.Matriz; //Indica de donde estoy sacando la clase.
public class Main {
    public static void main(String[] argv)
    {
        
        Interfaz interfaz = new Interfaz();
        Matriz matrices = new Matriz(interfaz.getFilaSize(), interfaz.getColumnaSize());

        int[][][] my_cube = matrices.createRubickCube(10, 50, 25);

        for(int iterador1 = 0; iterador1<my_cube.length; iterador1++){
            for(int iterador2 = 0; iterador2<my_cube[iterador1].length; iterador2++) {
                for(int iterador3 = 0; iterador3<my_cube[iterador1][iterador2].length; iterador3++) {
                    System.out.println(my_cube[iterador1][iterador2][iterador3]);
                }
                System.out.println();
            }
            System.out.println();
        }
        
        /*
        //Ejercicio 1.
        interfaz.contadorDeEjercicio();
        matrices.llenarMatrizAspiral();
        interfaz.printMatriz(matrices.getMatrizEj1());
        
        //Ejercicio 2.
        interfaz.contadorDeEjercicio();
        matrices.llenarMatrizEj2(interfaz.getColumnaSize());
        interfaz.printMatriz(matrices.getMatrizEj2());
        
        //Ejercicio 3.
        interfaz.contadorDeEjercicio();
        matrices.multiplicarMatrices();
        interfaz.printMatriz(matrices.getMatrizMultiplicada());*/
    }
}
