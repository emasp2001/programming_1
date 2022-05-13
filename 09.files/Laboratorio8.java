/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecci.laboratorio8;
import ecci.laboratorio8.DatosFlores;
/**
 *
 * @author emma
 */
public class Laboratorio8 {
    public static void main(String[] argv){
        DatosFlores datos = new DatosFlores();
        double[][] matrizPrueba = new double[3][3]; //Matriz para probar el codigo.
        double contador=1; //Para llenar la matriz;
        int contadorEjercicios = 1; //Solo es para contar el ejercicio que voy ejecutando. 
        
        for(int i=0; i<matrizPrueba.length; i++){
            for(int j=0; j<matrizPrueba[i].length; j++){
                matrizPrueba[i][j]=contador;
                contador+=1.0;
            }
        }
        String nombreArchivo = "Archivo de prueba";
        String direccionArchivo = "/Users/emma/Documents/ECCI/Programacion 1/Segundo intento/Practicas y tareas/Laboratorio8";
        
        System.out.println("Ejercicio "+contadorEjercicios);
        contadorEjercicios++;
        datos.cargarDocumento();
        
        System.out.println("Ejercicio "+contadorEjercicios);
        contadorEjercicios++;
        datos.escrbirDocumento(nombreArchivo, matrizPrueba);
        System.out.println("El documento '"+nombreArchivo+"' se ha creado correctamente.");
        
        System.out.println("Ejercicio "+contadorEjercicios);
        contadorEjercicios++;
        System.out.println("El documento '"+nombreArchivo+"' en la direccion: '"+direccionArchivo+"'\nExiste? " + datos.existeArchivo(direccionArchivo, nombreArchivo));
        
    }
}
