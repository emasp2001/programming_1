/*
 * Main class, the diferents excercises are running one by one in the single program.

/**
 *
 * @author emma
 */
package Laboratory2;
import Laboratory2.AdivinaNumero;
import Laboratory2.CalcularAnyoBisiesto;
import Laboratory2.Interfaz;
//import Laboratory2.Main;
import Laboratory2.PrimeNumbers;
import Laboratory2.Problem3Marineros;
public class Main {
    public static void main (String[] argv)
    {
        Laboratory2.Interfaz menu = new Interfaz();
        Laboratory2.AdivinaNumero juego = new AdivinaNumero();
        Laboratory2.CalcularAnyoBisiesto averiguarCondicion = new CalcularAnyoBisiesto();
        Laboratory2.PrimeNumbers primos = new PrimeNumbers();
        Laboratory2.Problem3Marineros marineros = new Problem3Marineros(); 
        /*Interfaz menu = new Interfaz();
        CalcularAnyoBisiesto averiguarCondicion = new CalcularAnyoBisiesto();
        AdivinaNumero juego = new AdivinaNumero();
        PrimeNumbers primos = new PrimeNumbers();
        Problem3Marineros marineros = new Problem3Marineros();*/
        
        menu.printCurrentExercise();
        int anyo=menu.pedirAnyo();
        averiguarCondicion.setAnyo(anyo);
        boolean condicion = averiguarCondicion.averiguarSiBisiesto();
        menu.decirCondicionAnyo(condicion, anyo);
        
        menu.printCurrentExercise();
        anyo=menu.pedirAnyo();
        averiguarCondicion.setAnyo(anyo);
        condicion=averiguarCondicion.averiguarSiBisiestoSwitch();
        menu.decirCondicionAnyo(condicion, anyo);
        
        menu.printCurrentExercise();
        do{
        juego.setWritedNumber(menu.askForGuessNumber());
        juego.findOutGuess();
        if(juego.getGuessedCondition()!=true){
            menu.giveClue(juego.getIsSmaller(), juego.getIsBigger());
        }
        } while(juego.getGuessedCondition()!=true);
        menu.winnerMessage();
        
        menu.printCurrentExercise();
        primos.setWritedNumber(menu.askForPrimeNumber());
        primos.findOutCondition();
        menu.printNumberCondition(primos.getNumberCondition(), primos.getWritedNumber());
        
        menu.printCurrentExercise();
        menu.printAmoutGaveAway(marineros.findOutQuantity());
    }
}
