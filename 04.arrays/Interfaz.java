/*
 * 
 */

/**
 *
 * @author emma
 */
import javax.swing.JOptionPane;
public class Interfaz {
    
    public int askForNumber(int position)
    {
        int number=-1;
        int posicion=position+1;
        try{
            number=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero que desea guardar en la posicion "+posicion+".", "Solo puede digitar numeros enteros."));
        } catch (NumberFormatException error){
            JOptionPane.showMessageDialog(null, "SOLO PUEDE DIGITAR NUMEROS ENTEROS.", "ERROR", JOptionPane.WARNING_MESSAGE);
            number=askForNumber(position);
        }
        return number;
    }
    public int askForArraySize()
    {
        int size=-1;
        try{
            size=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de numeros que desea almacenar.", "Escriba solo numeros enteros", JOptionPane.PLAIN_MESSAGE));
        } catch(NumberFormatException error){
            JOptionPane.showMessageDialog(null, "SOLO PUEDE DIGITAR NUMEROS ENTEROS.", "ERROR", JOptionPane.WARNING_MESSAGE);
            size=askForArraySize();
        }
        return size;
    }
    public void printArray(int[] array, String kindArray)
    {
        String arrayText="";
        for(int i=0; i<array.length; i++){
            arrayText+=array[i]+", ";
        }
        JOptionPane.showMessageDialog(null, "Estos son los elementos del Array "+kindArray+"\n"+arrayText);
    }
    public void printAverage(double average)
    {
        JOptionPane.showMessageDialog(null, "El promedio de los numeros digitados es: "+average);
    }
    public void printStandarDeviation(double standarDeviation)
    {
        JOptionPane.showMessageDialog(null, "La Desviacion Estandar es: "+standarDeviation);
    }
    public void printArrayMultiplicado(int[] array)
    {
        String arrayText="";
        for(int i=0; i<array.length; i++){
            arrayText+=array[i]+", ";
        }
        JOptionPane.showMessageDialog(null, "Estos son los elementos del Array, multiplicados por 4 si es par y por 3 si es impar.\n"+arrayText);
    }
    public int pedirCantidadDeDadosDeseados()
    {
        int cantidadDeseada=-1;
        try{
            cantidadDeseada=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de dados con los que desea hacer la simulacion.", "Escriba solo numeros enteros. El ejercicio sugeria 4 dados.", JOptionPane.PLAIN_MESSAGE));
        } catch(NumberFormatException error){
            JOptionPane.showMessageDialog(null, "SOLO PUEDE DIGITAR NUMEROS ENTEROS.", "ERROR", JOptionPane.WARNING_MESSAGE);
            cantidadDeseada=pedirCantidadDeDadosDeseados();
        }
        return cantidadDeseada;
    }
    public int pedirCantidadDeCarasDeLosDados()
    {
        int cantidadDeseada=-1;
        try{
            cantidadDeseada=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de caras que desea que tengan los dados.", "Escriba solo numeros enteros. El ejercicio sugeria 8 caras.", JOptionPane.PLAIN_MESSAGE));
        } catch(NumberFormatException error){
            JOptionPane.showMessageDialog(null, "SOLO PUEDE DIGITAR NUMEROS ENTEROS.", "ERROR", JOptionPane.WARNING_MESSAGE);
            cantidadDeseada=pedirCantidadDeCarasDeLosDados();
        }
        return cantidadDeseada;
    }
    public int pedirCantidadDeSimulacionesDeseadas()
    {
        int cantidadDeseada=-1;
        try{
            cantidadDeseada=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de simulaciones que desea realizar.", "Escriba solo numeros enteros. El ejercicio sugeria 100.000 simulaciones.", JOptionPane.PLAIN_MESSAGE));
        } catch(NumberFormatException error){
            JOptionPane.showMessageDialog(null, "SOLO PUEDE DIGITAR NUMEROS ENTEROS.", "ERROR", JOptionPane.WARNING_MESSAGE);
            cantidadDeseada=pedirCantidadDeSimulacionesDeseadas();
        }
        return cantidadDeseada;
    }
    public void printNumeroMasPosible(int numero)
    {
        JOptionPane.showMessageDialog(null, "El numero m\u00e1s posible que salga es el: "+numero);
    }
}
