/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emma
 */
public class Main {
    public static void main(String[] argv)
    {
        Interfaz interfaz = new Interfaz();
        NumberDepot deposit=new NumberDepot(interfaz.askForArraySize());
        
        deposit.fullingArray();
        interfaz.printAverage(deposit.calculatingAverage());
        interfaz.printStandarDeviation(deposit.calculatingStandarDeviation());
        interfaz.printArray(deposit.getArray(), "Sin Ordenar.");
        interfaz.printArray(deposit.bubbleSort(), "Ordenado, por Bubble Sort Algorithm.");
        interfaz.printArray(deposit.insertionSort(), "Ordenado, por Insertion Sort Algorithm.");
        interfaz.printArrayMultiplicado(deposit.multiplyArray());
        
        Dados simulacionDeDados=new Dados(interfaz.pedirCantidadDeDadosDeseados(), interfaz.pedirCantidadDeCarasDeLosDados() ,interfaz.pedirCantidadDeSimulacionesDeseadas());
        interfaz.printNumeroMasPosible(simulacionDeDados.getNumeroConMayorFrecuencia());
    }
    
}
