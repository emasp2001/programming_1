/*
 * Clase donde va todo lo importante respecto a los 3 ejercicios del Lab8. 
    1.
        a. Cree un código de Java que permita cargar todas las líneas del documento, cada línea corresponde a una muestra de flor.
        b. Cree una matriz para los valores flotantes (correspondientes a las mediciones del ancho y largo del sépalo y pétalo de la flor) y un arreglo
            de hileras dónde se almacenarán la categoría a la que pertenece cada flor.
        c. Cargue los datos del documento a la matriz y a la hilera.
        d. Imprima lo datos almacenados en la matriz y la hilera.

    2. Implemente un método que permita recibir un nombre de archivo y una matriz de números reales. Su método debe escribir dichos valores en un documento de texto.
        a. Separe los valores de las columnas utilizando comas.
        b. Separe las filas con saltos de línea en el documento.

    3. Implemente un método que reciba por parámetro la dirección a un directorio y el nombre de un archivo.
        a. Su método debe retornar si el archivo se encuentra o no en dicho directorio.
 */
package ecci.laboratorio8; //Paquete donde estan todos los archivos.

import java.io.File; //Para manejar archivos.
import java.io.FileNotFoundException;
import java.io.FileReader; //Para leer del documento
import java.io.FileWriter; //Para escribir en el documento.
import java.io.IOException; //Para las excepciones.
import java.util.Scanner; //Otra forma de leer en el documento.

/**
 *
 * @author emma
 */
public class DatosFlores {
    private File archivo; //Archivo en base al cual voy a trabajar.
    private final String direccionArchivo = "/Users/emma/Documents/ECCI/Programacion 1/Segundo intento/Practicas y tareas/Laboratorio8"; //Se refiere a la direccion donde esta almacenado el archivo con que deseo trabajar.
    private final String nombreDelArchivo = "iris"; //Es el nombre del .data que necesito cargar.
    private double[][] dimensionesFlores; //Correspondientes a las mediciones del ancho y largo del sépalo y pétalo de la flor
    private String[] categoriaFlores; //Se almacenarán la categoría a la que pertenece cada flor.
    private Scanner escaner;
    
    
    public DatosFlores(){
        archivo = new File(direccionArchivo+"/"+nombreDelArchivo); //Cargo la direccion de donde esta el archivo.
        dimensionesFlores = new double[150][4]; //Esas son las cantidades de datos que hay.
        categoriaFlores = new String[150];
    }
    
    /*
    * Funcion: Implemente un método que permita recibir un nombre de archivo y una matriz de números reales. Su método debe escribir dichos valores en un documento de texto.
        a. Separe los valores de las columnas utilizando comas.
        b. Separe las filas con saltos de línea en el documento.
    */
    public File escrbirDocumento(String nombreArchivo, double[][] matriz){
        File archivoNuevo = new File(nombreArchivo); //Creo el archivo en el cual quiero escribir.
        try{
            FileWriter escritor = new FileWriter(archivoNuevo); //Creo el escritor para poder trabajarlo.
            
            //Para recorrer todos los datos que deseo escribir de la matriz.
            for(int i=0; i<matriz.length; i++){
                for(int j=0; j<matriz[i].length; j++){
                    escritor.write(String.valueOf(matriz[i][j]) + ", "); //Convierto el valor del numero a un String y lo separo con una coma.
                }
                escritor.write("\n"); //Separe las filas con saltos de línea en el documento.
            }
            escritor.close(); //Cierro el flujo de datos.
            
        } catch(IOException error){
            System.out.println("Hubo un error al escribir el nuevo archivo.\nIntentelo nuevamente mas tarde, aunque la respuesta sera la misma :p.");
        }
        
        return archivoNuevo; //Devuelvo el archivo que se ha creado.
    }
    
    /*
    * Funcion: reciba por parámetro la dirección a un directorio y el nombre de un archivo.
        a. Su método debe retornar si el archivo se encuentra o no en dicho directorio.
    */
    public boolean existeArchivo(String direccion, String nombreArchivo){
        String direccionAbsoluta = direccion+"/"+nombreArchivo;
        File archivoNuevo = new File(direccionAbsoluta);
        
        return archivoNuevo.exists();
    }
    
    /*
    * Funcion: a. Cree un código de Java que permita cargar todas las líneas del documento, cada línea corresponde a una muestra de flor.
               b. Cree una matriz para los valores flotantes (correspondientes a las mediciones del ancho y largo del sépalo y pétalo de la flor) y un arreglo
                   de hileras dónde se almacenarán la categoría a la que pertenece cada flor.
               c. Cargue los datos del documento a la matriz y a la hilera.
               d. Imprima lo datos almacenados en la matriz y la hilera.
    */
    public void cargarDocumento(){
        try{
            FileReader lector = new FileReader(archivo);
            char[] datos = new char[6024];
            try{
                //Formo la matriz de las dimensiones y la hilera de las categorias.
                escaner = new Scanner(archivo);
                String[] archivoTexto = new String[150]; //Porque son solo 150 lineas del archivo.
                
                //Leeo todo el archivo.
                for(int i=0; i<archivoTexto.length; i++){
                    archivoTexto[i]=escaner.next();
                    archivoTexto[i] = archivoTexto[i].replace(",", " "); //Quito las comas.
                    archivoTexto[i] = archivoTexto[i].replace("Iris-", ""); //Quito lo que estorba a la categoria.
                }
                
                for(int i=0; i<dimensionesFlores.length; i++){
                    
                    Scanner escanerTexto = new Scanner(archivoTexto[i]); //Un escaner para leer de este texto.
                    dimensionesFlores[i][0] = escanerTexto.nextDouble();
                    dimensionesFlores[i][1] = escanerTexto.nextDouble();
                    dimensionesFlores[i][2] = escanerTexto.nextDouble();
                    dimensionesFlores[i][3] = escanerTexto.nextDouble();
                    categoriaFlores[i] = escanerTexto.next();
                }
                
                //Cargo los datos del documento.
                lector.read(datos); //Leo el archivo.
                String texto = new String(datos); //Creo el String con los datos.
                //JOptionPane.showMessageDialog(null, "Los datos leidos son:\n"+texto);
                System.out.println("Los datos leidos son:\n"+texto);

                lector.close(); //Cierro el flujo de datos.
                
            } catch(IOException err){
                System.out.println("Error en lectura de archivo.");
            }
            
        } catch(FileNotFoundException error){
            System.out.println("El archivo: '"+nombreDelArchivo+"' no existe");
        }
        
        //Imprimo los datos de la matriz y la hilera.
        System.out.println("La matriz de las dimensiones es:\n"+toStringMatrizDimensiones()+"\n");
        System.out.println("Las categorias de las flores son:\n"+toStringVectorCategoria()+"\n");
    }
    
    private String toStringMatrizDimensiones(){
        String matrizTexto="";
        
        for(int i=0; i<dimensionesFlores.length; i++){
            for(int j=0; j<dimensionesFlores[i].length; j++){
                matrizTexto+=dimensionesFlores[i][j]+" ";
            }
            matrizTexto+="\n";
        }
        
        return matrizTexto;
    }
    
    private String toStringVectorCategoria(){
        String vectorTexto="";
        
        for(int i=0; i<categoriaFlores.length; i++){
            vectorTexto+=categoriaFlores[i]+"\n";
        }
        
        return vectorTexto;
    }
}
