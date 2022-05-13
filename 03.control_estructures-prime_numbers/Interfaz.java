/*
 * Only class allowed to talk with the user.
 */

/**
 *
 * @author emma
 */
package Laboratory2;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Interfaz{
    private Scanner scan;
    private int ejercicioActual; //Es un contador para saber cual de los ejercicios esta ejecutando el programa.
    
    public Interfaz()
    {
        scan = new Scanner(System.in);
        ejercicioActual=1;
    }
    public int pedirAnyo()
    {
        int anyoRecibido = -1;
        try
        {
            anyoRecibido=Integer.parseInt(JOptionPane.showInputDialog(null, "Hola usuario.\nDigite el a\u00f1o que desea averiguar si es bisiesto."));
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Compa\u00f1ero vea, usted tiene que ingresar un a\u00f1o en formato num\u00e9rico, sin letras y sin decimales; por favor.");
            anyoRecibido=pedirAnyo();
        }
        return anyoRecibido;
    }
    public void decirCondicionAnyo(boolean condicion, int anyoCalculado)
    {
        if(condicion==true){
            JOptionPane.showMessageDialog(null, "El a\u00f1o "+anyoCalculado+" es bisiesto.");
        } else {
            JOptionPane.showMessageDialog(null, "El a\u00f1o "+anyoCalculado+" NO es bisiesto.");
        }
    }
    public int askForGuessNumber()
    {
        int writedNumber=-1;
        try{
        writedNumber=Integer.parseInt(JOptionPane.showInputDialog(null, "Se ha creado un numero aleatorio, trate de adivinarlo.", "Escriba un numero entero."));
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Eso no es un número, tramposo");
            writedNumber=askForGuessNumber();
        }
        return writedNumber;
    }
    public void giveClue(boolean isSmaller, boolean isBigger)
    {
        if(isSmaller==true)
        {
            JOptionPane.showMessageDialog(null, "PISTA: El numero es menor.");
        } else {
            JOptionPane.showMessageDialog(null, "PISTA: El numero es mayor");
        }
    }
    public void winnerMessage()
    {
        JOptionPane.showMessageDialog(null, "Ha adivinado! Felicidades");
    }
    public int askForPrimeNumber()
    {
        int number=-1;
        try{
            number=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el numero que desea averiguar si es primo o no.", "Digite solo numero enteros, por favor."));
        }catch(NumberFormatException error){
            JOptionPane.showMessageDialog(null, "Solo puede escribir numeros enteros, sin decimales.");
            number=askForPrimeNumber();
        }
        return number;
    }
    public void printNumberCondition(boolean condition, int number)
    {
        if(condition==true)
        {
            JOptionPane.showMessageDialog(null, "El numero "+number+" S\u00cd es primo.");
        } else{
            JOptionPane.showMessageDialog(null, "El numero "+number+" NO es primo.");
        }
    }
    public void printCurrentExercise()
    {
        JOptionPane.showMessageDialog(null, "Ejercicio "+ejercicioActual);
        ejercicioActual++;
    }
    public void printAmoutGaveAway(int quantity)//Para el problema de los tres marineros.
    {
        JOptionPane.showMessageDialog(null, "La cantidad INICIAL que le habian regalado a los marineros es: "+quantity);
    }
}
