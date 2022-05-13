/*
Debe poseer atributos dos jugadores.

Metodos:
Listo   ◦Debe poseer un método continua que debe retornar verdadero si ninguno de los dos jugadores ha perdido.
Listo   ◦Debe poseer un método iniciar que llama los métodos “posicionar” de ambos jugadores. Sin embargo, uno de los jugadores
            será el usuario por lo que debe preguntarle si le gusta su posicionamiento, de no gustarle debe generar otro hasta que el usuario esté satisfecho.
Listo   ◦Debe poseer un método pedir que le solicita al usuario la fila y la columna en la que quiere realizar su próximo disparo,
            estas coordenadas deben ser válidas. Luego debe realizar el disparo de parte del jugador hacia la computadora.
Listo   ◦Debe poseer un método pedir_computadora que genera una fila y una columna al azar a la cual la computadora desea disparar. Debe asegurarse de que
            dichas coordenadas sean válidas.
        ◦Método juego que inicializa el juego y luego entra en un ciclo de juego mientras ningún jugador haya perdido. En cada turno se debe iniciar con
            el disparo de parte del jugador, seguido del disparo por parte de la computadora. Cuando el ciclo acabe (algún jugador perdió) debe imprimir
            un mensaje de “GANÓ”, “PERDIÓ” o “EMPATÓ” dependiendo del resultado final del juego.

*/
package ecci.examen1;

/**
 *
 * @author emma
 */
import javax.swing.JOptionPane;
public class Juego {
    //El juego esta hecho para solo DOS jugadores.
    private Jugador jugador1; //Jugador Computadora
    private Jugador jugador2; //Jugador Humano.
    
    public Juego()
    {
        this.jugador1=new Jugador();
        this.jugador2=new Jugador();
    }
    
    /*
    * Funcion: retornar verdadero si ninguno de los dos jugadores ha perdido.
    */
    public boolean continua()
    {
        return jugador1.perdio()==false && jugador2.perdio()==false? true:false; //Para hacer toda la comprobacion de ambos jugadore en una sola linea.
    }
    
    /*
    * Funcion: llama los métodos “posicionar” de ambos jugadores. Sin embargo, uno de los jugadores será el usuario por lo que debe preguntarle
               si le gusta su posicionamiento, de no gustarle debe generar otro hasta que el usuario esté satisfecho.
    */
    public void iniciar()
    {
        jugador1.posicionarBarcos(); //Como es para la computadora no le debo preguntar nada.
        while(leGustaDistribucion()==false)
        {
            jugador2.posicionarBarcos();
        }
    }
    
    /*
    * Funcion: dado que al usuario debe gustarle la posicion de los barcos, este es para repetirlo hasta que a el le guste.
    */
    private boolean leGustaDistribucion()
    {
        boolean leGusta=true;
        
        //Imprime como quedo su juego.
        String tablero=jugador2.toStringDisparos()+jugador2.toStringBarcos()+"\n Le gusta? \n0: No. \n1: Si)"; //Le muestra como esta su juego
        int respuesta=-1;
        
        //En caso que digite algo distinto a un numero.
        try{
            respuesta=Integer.parseInt(JOptionPane.showInputDialog(null, tablero));
            //En caso que digite un numero que no es una opcion.
            if(respuesta<0 || respuesta>1)
            {
                JOptionPane.showMessageDialog(null, "Numero digitado no esta dentro de las opciones.");
                leGusta=leGustaDistribucion();
            } else {
                //Comprueba que opcion decidio. Solo debo comprobar si no le gusta, asumiendo que si le gustara.
                if(respuesta==0)
                {
                    leGusta=false;
                } else {
                    if(respuesta==1){
                        leGusta=true;
                    }
                }
            }
            
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Formato de numero incorrecto.");
            leGusta=leGustaDistribucion();
        }
        
        return leGusta;
    }
    
    /*
    * Funcion: solicita al usuario la fila y la columna en la que quiere realizar su próximo disparo,
               estas coordenadas deben ser válidas. Luego debe realizar el disparo de parte del jugador hacia la computadora.
    */
    public void pedir()
    {
        //Coordenadas donde se desea disparar.
        int fila=-1;
        int columna=-1;
        
        //Todo esto es para comprobar que las direcciones son validas.
        boolean noSeCae=true; //Es para comprobar que el usuario no me va a botar el programa con lo que digite, si todo esta bien da true.
        do{
            //Para capturar un posible error.
            try{
                fila=Integer.parseInt(JOptionPane.showInputDialog(null, "Fila a la que desea apuntar."));
                columna=Integer.parseInt(JOptionPane.showInputDialog(null, "Columa a la que desea apuntar."));
            } catch(NumberFormatException e){
                pedir();
                noSeCae=false;
            }
            
            if(fila<1 || fila>10 || columna<1 || columna>10) //Son los limites del tamano del tablero.
            {
                noSeCae=false;
            }
        }while(noSeCae==false);
        
        
        jugador2.anotarDisparo(fila, columna, jugador1.recibirImpacto(fila, columna)); //Realiza el disparo de parte del jugador hacia la computadora.
    }
    
    /*
    * Funcion: genera una fila y una columna al azar a la cual la computadora desea disparar. Debe asegurarse de que
               dichas coordenadas sean válidas.
    */
    public void pedirComputadora()
    {
        //Genera coordenadas en el ambito de posiciones [0, 9].
        int fila=(int)(Math.random()*10);
        int columna=(int)(Math.random()*10);
        
        //Realiza el disparo.
        jugador1.anotarDisparo(fila, columna, jugador2.recibirImpacto(fila, columna));
    }
    
    /*
    * Funcion: inicializa el juego y luego entra en un ciclo de juego mientras ningún jugador haya perdido. En cada turno se debe iniciar con
               el disparo de parte del jugador, seguido del disparo por parte de la computadora. Cuando el ciclo acabe (algún jugador perdió) debe imprimir
               un mensaje de “GANÓ”, “PERDIÓ” o “EMPATÓ” dependiendo del resultado final del juego.
    */
    public void juego()
    {
        //Inicializa el juego.
        iniciar();
        
        //Entran a competir hasta que uno gane.
        do{
            //Esta es la base del juego.
            pedir();
            pedirComputadora();
            jugador2.imprimir();
        }while(continua()==true);
        
        //Ya aqui uno de los dos gano, solo hay que saber quien.
        if(jugador1.perdio()==true)
        {
            JOptionPane.showMessageDialog(null, "Usted GANO el juego.");
        } else {
            JOptionPane.showMessageDialog(null, "Usted PERDIO el juego, gano la computadora.");
        }
    }
}
