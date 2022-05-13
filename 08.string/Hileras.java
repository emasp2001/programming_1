/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecci.laboratorio7;

import java.util.Arrays;

/**
 *
 * @author emma
 */
public class Hileras {
    
    /*
    * Funcion:  función iterativa que permita identificar si una hilera es palíndromo o no (ignore los espacios de la hilera). Un palíndromo es una
                palabra que se lee igual de izquierda a derecha que de derecha a izquierda.
    */
    public boolean esPalindromo(String hilera){
        boolean condicionPalindromo=true; //Asumo que si es palindromo.
        int auxiliarA=hilera.length(); //Auxiliar que me dice el size de la hilera.
        String hileraSinEspacios="";
        
        hilera.toLowerCase(); //Convierto la hilera en una de solo letras minusculas para poder hacer la comparacion.
        
        //Quito los espacios de la hilera.
        for (int x=0; x < hilera.length(); x++){
            if (hilera.charAt(x) != ' '){
            hileraSinEspacios += hilera.charAt(x);
            }
        } 
        //Reinicio las variables.
        hilera=hileraSinEspacios;
        auxiliarA=hilera.length();
        
        //Comparalo las mini cadenas.
        for (int i=0 ;i < (hilera.length()); i++){
            if (hilera.substring(i, i+1).equals(hilera.substring(auxiliarA-1, auxiliarA)) == false){
            //Si solo una letra no es igual entonces ya se que no es palindromo y por lo tanto me salgo.
                condicionPalindromo=false;
                break;
            }
            auxiliarA--;
        }
        
        return condicionPalindromo;
    }
    
    /*
    * Funcion:  identificar si dos hileras son anagramas la una de la otra. Una palabra es un anagrama de una segunda palabra si existe
                una manera de reordenar sus caracteres y obtener la segunda.
    */
    public boolean esAnagrama(String hilera1, String hilera2){
        //Creo vectores para poder luego compararlos cuando los ordene.
        /*char[] vector1=new char[hilera1.length()];
        char[] vector2=new char[hilera2.length()];
        boolean condicionAnagrama;
        
        //Copio el primer vector.
        for(int i=0; i<vector1.length; i++)
        {
            vector1[i]=hilera1.charAt(i);
        }
        
        //Copio el segundo vector.
        for(int i=0; i<vector2.length; i++)
        {
            vector2[i]=hilera2.charAt(i);
        }*/
        
        char[] vector1=hilera1.toCharArray();
        char[] vector2=hilera2.toCharArray();
        
        //Ordeno los vectores.
        Arrays.sort(vector1);
        Arrays.sort(vector2);
        
        //String cadena1 = new String(vector1);
        //String cadena2 = new String(vector2);
        //condicionAnagrama = cadena1.equals(hilera2);
        
        //return condicionAnagrama;
        boolean condicion=new String(vector1).equals(new String(vector2));
        return condicion;
    }
    /*
    * Funcion: recibe por parámetro dos hileras: la hilera a separar y la hilera separador. Luego retorne el arreglo de hileras correspondiente a dicha separación.
               (Para verificar su resultado, puede comparar el resultado que se obtendría al utilizar el método split).
    */
    public String[] splitHileras(String hilera, String separador){
        //Fase 1: contar cuantos espacios existen en la hilera.
        int cantEspacios=0; //La cantidad de espacios que existen.
        for(int i=0; i<hilera.length(); i++){
            if(hilera.charAt(i)==' '){
                cantEspacios++;
            }
        }
        
        //Fase 2: crear vector para las posiciones de los espacios y colocarlos ahi. 
        int[] posEspacios = new int[cantEspacios]; //Aqui almaceno los indices de la hilera donde estan los espacios.
        int auxiliarA=0; //Auxiliar que me permite ir contando la posicion en que voy del vector de pos.
        for(int i=0; i<hilera.length(); i++){ //Recorro la hilera en busca de los espacios.
            if(hilera.charAt(i) == ' ')
            {
                posEspacios[auxiliarA]=i; //Guardo su posicion.
                auxiliarA++;
            }
        }
        
        //Fase 3: crear vector para los subStrings, ignorando las pos donde esten los espacios.
        int cantPalabras = cantEspacios+1; //Por lo general si no hay espacios al inicio a final esta es la formula para la cantPalabras.
        //En caso que haya espacios al inicio.
        if(hilera.startsWith(" ")){
            cantPalabras++;
        } 
        //En caso que haya espacios al final.
        if(hilera.endsWith(" ")){
            cantPalabras++;
        }
        
        String[] hileraSeparada = new String[cantPalabras]; //Creo el vector con la cantidad de palabras que se que existen.
        for(int i=1; i<hileraSeparada.length; i++){
            hileraSeparada[i]=hilera.substring(posEspacios[i-1], posEspacios[1]);
        }
        
        //Fase 4: agregar los separadores.
        for(int i=0; i<hileraSeparada.length; i++){
            hileraSeparada[i] = separador+hileraSeparada[i]+separador;
        }
        
        return hileraSeparada; 
    }
    
    /*
    * Funcion: consiste en “desplazar” las letras del alfabeto una cantidad de espacios. 
               a. Un mensaje como “hola mundoz” utilizando un desplazamiento de +3 daría como resultado el texto “krod pxqgrc”.
               b. Note que los espacios permanecen igual y solo los caracteres alfabéticos cambian y el desplazamiento por el alfabeto
                  es “circular” (la ‘z’ se convirtió en ‘c’).
               c. También note que para descifrar un mensaje solo es necesario aplicar el mismo algoritmo con el negativo del número usado para cifrar.
               d. Implemente una función cifrar que recibe como parámetros un texto y un desplazamiento y realiza la transformación sobre el texto.
    */
    public String cifrar(String texto, int desplazamiento){
        char[] abecedario = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; //Para poder hacer intercambio de letras.
        char[] textoCodificado = new char[texto.length()];
        texto.toLowerCase(); //Lo convierto a minusculas.
        
        
        //Forma de buscar el indice de la letra que quiero modificar.
        for(int posicionActual=0; posicionActual<texto.length(); posicionActual++){
            int indice=0;
            if(texto.charAt(posicionActual) != ' '){ //Debo ignorar los espacios de la hilera.
                //Busco la posicion de la letra en el abecedario.
                while(indice<abecedario.length){
                    if(texto.charAt(posicionActual) == abecedario[indice]){
                        break;
                    } else {
                        indice++;
                    }
                }
                
                indice+=desplazamiento;
                
                if(indice>=abecedario.length){ //Para darle vuelta al abecedario en caso de salirme.
                    indice -= (abecedario.length);
                }
                if(indice<0){
                    indice=abecedario.length + indice;
                }
                
                textoCodificado[posicionActual]=abecedario[indice];
            } else {
                textoCodificado[posicionActual]=' ';
            }
        }
        
        //Convertir el textoCodificado[] en un texto.
        String textoSecreto = "";
        for(int i=0; i<textoCodificado.length; i++){
            textoSecreto += Character.toString(textoCodificado[i]);
        }
        
        return textoSecreto;
    }
}
