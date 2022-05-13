/*
 * and open the template in the editor.
 */

/**
 *
 * @author emma
 */
package Laboratory2;
public class PrimeNumbers {
    private int writedNumber;
    private boolean numberCondition;
    
    public PrimeNumbers()
    {
        writedNumber=-1;
        numberCondition=true;
    }
    public void setWritedNumber(int number)
    {
        writedNumber=number;
    }
    public int getWritedNumber()
    {
        return writedNumber;
    }
    public boolean getNumberCondition()
    {
        return numberCondition;
    }
    public void findOutCondition()
    {
        if(writedNumber%2==0||writedNumber%3==0||writedNumber%5==0)
        {
            numberCondition=false;
        }
        switch(writedNumber) //Este switch es para manejar las excepciones mas comunes de los numeros primos.7
        {
            case 2:
                numberCondition=true;
            break;
            case 3:
                numberCondition=true;
            break;
            case 5:
                numberCondition=true;
            break;
                
        }
    }
}
