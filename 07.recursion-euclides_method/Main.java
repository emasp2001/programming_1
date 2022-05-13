/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecci.laboratorio6;

/**
 *
 * @author emma
 */
import ecci.laboratorio6.Ejercicios;
import ecci.laboratorio6.Interfaz;
public class Main {
    public static void main(String[] argv)
    {  
        Interfaz interfaz = new Interfaz();
        Ejercicios ejercicios = new Ejercicios();
        
        //Ejercicio 1.
        interfaz.anunciarEjercicio(1);
        interfaz.imprimirMCD(ejercicios.averiguarMCD(interfaz.pedirNumeroN(1), interfaz.pedirNumeroN(2)));
        
        //Ejercicio 2.
        interfaz.anunciarEjercicio(2);
        ejercicios.adivinarNumero(1, 0, 100, 0);
        
        //Ejercicio 3.
        interfaz.anunciarEjercicio(3);
        interfaz.printVector(ejercicios.getVectorArbitrario());
        ejercicios.ordenarVector(ejercicios.getVectorArbitrario()); //Bugs: tengo el problema que no puedo usar el paquete .util.Arrays.
        interfaz.printVector(ejercicios.getVectorArbitrario());
        
        System.exit(0);
    }    
}
