/*
 * 
 */

/**
 *
 * @author emma
 */
public class NumberDepot {
    public int[] number;
    private Interfaz interfaz;
    private double average;
    
    public NumberDepot(int depotSize)
    {
        number = new int[depotSize];
        interfaz = new Interfaz();
        average=-1;
    }
    public void writeArrayPosition(int position, int writtenNumber)
    {
        number[position]=writtenNumber;
    }
    public double calculatingAverage()
    {
        double additionTotal=0;
        for(int i=0; i<number.length;i++)
        {
            additionTotal+=number[i];
        }
        average=additionTotal/number.length;
        
        return average;
    }
    public double calculatingStandarDeviation()
    {
        double variance=0;
        double standarDeviation=-1.0;
        int arraySize=number.length;
        for(int i=0; i<arraySize; i++)
        {
            variance+=(Math.pow((average-number[i]), 2));
        }
        variance/=(arraySize-1);
        standarDeviation=Math.pow(variance, 1.0/2.0);
        
        return standarDeviation;
    }
    public void fullingArray()
    {
        for(int i=0; i<number.length; i++){
            number[i]=interfaz.askForNumber(i);
        }
    }
    public int[] getArray()
    {
        return number;
    }
    public int[] bubbleSort()
    {
        int arraySize=number.length;
        int[] bubbleSortArray = new int[arraySize];
        int temporal;
        for(int i=0; i<arraySize; i++) //Copia el array
        {
            bubbleSortArray[i]=number[i];
        }
        for (int i=0; i<arraySize; i++){ //Esto asegura que recorra todo el array.
            for(int j=1; j<arraySize; j++){
                if(bubbleSortArray[j-1]>bubbleSortArray[j]){
                    temporal=bubbleSortArray[j-1];
                    bubbleSortArray[j-1]=bubbleSortArray[j];
                    bubbleSortArray[j]=temporal;
                }
            }
        }
        return bubbleSortArray;
    }
    public int[] insertionSort()
    {
        int arraySize=number.length;
        int[] insertionSortArray=new int[arraySize];
        int valorTemporal=-1;
        for (int i=0; i<arraySize; i++) //Copia el array.
        {
            insertionSortArray[i]=number[i];
        }
        for (int i=1; i<arraySize; i++) //Esto asegura que recorra todo el array.
        {
            for (int j=i-1; (insertionSortArray[j]<insertionSortArray[i]) || j==0; j--)
            {
                if(insertionSortArray[i]<insertionSortArray[i-1]) 
                {
                    //Intercambio de elementos.
                    valorTemporal=insertionSortArray[i-1];
                    insertionSortArray[i-1]=insertionSortArray[i];
                    insertionSortArray[i]=valorTemporal;
                }
            }
        }
        return insertionSortArray;
    }
    public int[] multiplyArray()
    {
        int originalArraySize=number.length;
        int[] arrayMultiplicado = new int[originalArraySize];
        for(int i=0; i<originalArraySize; i++)
        {
            if(number[i]%2==0){
                arrayMultiplicado[i] = number[i]*4;
            } else{
                arrayMultiplicado[i] = number[i]*3;
            }
        }
        return arrayMultiplicado;
    }
}
