/*
 * Implemente su propia clase Diccionario que utilice una estructura de árbol binario para hacer lo siguiente:

    1. Implemente un método “leerArchivo” que reciba el nombre de un archivo de texto y retorne todo su contenido como una String de texto. Elimine todos los
        signos de puntuación del texto y convierta el texto a minúsculas.
    2. Implemente un método “cargarDiccionario” que recibe una hilera de texto, separa el texto en palabras (usando como separador los espacios entre las
        palabras) y carga el diccionario con cada palabra diferente (no se deben insertar repeticiones).
    3. Implemente su Diccionario de una manera que además almacene la cantidad de veces que aparece cada palabra en los textos cargados al diccionario y
        asigne un identificador único a la palabra.
            a. El método str.compareTo(String s) compara la hilera “str” con la hilera “s”: retorna un número negativo si str es menor a s, un número positivo
                si str es mayor a s y 0 si son iguales.
            b. (Pista: Considere que datos le serviría que se almacenen en cada nodo).
    4. Implemente un método “contiene” que recibe una hilera de texto y retorna la cantidad de apariciones que tuvo la palabra en los textos cargados o retorne
        “0” si la palabra no está en el Diccionario.
    5. Implemente un método “convertir” que recibe una hilera de texto y retorna una hilera de texto con las palabras sustituidas por sus identificadores.

 */
package ecci.lab10;
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
public class Diccionario {
    private Arbol arbol; //El arbol donde voy a guardar todo.
    
    public Diccionario(){
        arbol = new Arbol();
    }
    
    /*
    Function: reciba el nombre de un archivo de texto y retorne todo su contenido como una String de texto. Elimine todos los
        signos de puntuación del texto y convierta el texto a minúsculas.
    */
    public String leerArchivo(String nombreArchivo){
        String direccionArchivo = null; //Direccion de memoria del archivo.
        File archivo = new File(direccionArchivo);
        String informacion = null; //Es la informacion que esta en el archivo.
        try{
            FileReader lector = new FileReader(archivo);
            char[] datos = new char[6024];
            try{
                Scanner escaner = new Scanner(archivo);
               
                //Cargo los datos del documento.
                lector.read(datos); //Leo el archivo.
                informacion = new String(datos); //Creo el String con los datos.

                lector.close(); //Cierro el flujo de datos.
                
            } catch(IOException err){
                System.out.println("Error en lectura de archivo.");
            }
            
        } catch(FileNotFoundException error){
            System.out.println("El archivo: '"+nombreArchivo+"' no existe");
        }
        informacion = informacion.toLowerCase(); //Lo convierto a minusculas.
        //Esto es para eliminar los signos de puntuacion.
        informacion = informacion.replace(".", "");
        informacion = informacion.replace(",", "");
        informacion = informacion.replace(";", "");
        
        return informacion;
    }
    
    /*
    Function: recibe una hilera de texto, separa el texto en palabras (usando como separador los espacios entre las palabras)
        y carga el diccionario con cada palabra diferente (no se deben insertar repeticiones).
    */
    public void cargarDiccionario(String hilera){
        String[] palabras = hilera.split(" ");
        for(int i=0; i<palabras.length; i++){
            arbol.add(hilera, i+1);
        }
    }
    
    /*
    Function: recibe una hilera de texto y retorna la cantidad de apariciones que tuvo la palabra en los textos cargados o retorne
        “0” si la palabra no está en el Diccionario.
    */
    public int contiene(String hilera){
        return arbol.contiene(hilera);
    }
    
    /*
    Function: recibe una hilera de texto y retorna una hilera de texto con las palabras sustituidas por sus identificadores.
    */
    public String convertir(String hilera){
        Arbol arbolSecundario = new Arbol();
        String[] hileraTexto = hilera.split(" ");
        for(int i=0; i<hileraTexto.length; i++){
            arbolSecundario.add(hileraTexto[i], i+1);
        }
        
        return arbolSecundario.toStringArbol(arbolSecundario.getCabeza(), "");
    }
}
