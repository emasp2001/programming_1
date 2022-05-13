/*
 * Class use to create a random int number.
 */

/**
 *
 * @author emma
 */
package Laboratory2;
public class AdivinaNumero {
    private int generatedNumber;
    private int writedNumber;
    private boolean guessed;
    private boolean isBigger;
    private boolean isSmaller;
    
    public AdivinaNumero()
    {
        generatedNumber=(int)(Math.random()*100)+1;
        writedNumber=-1;
        guessed=false;
        isBigger=false;
        isSmaller=false;
    }
    public void setWritedNumber(int number)
    {
        this.writedNumber=number; 
    }
    public void findOutGuess()
    {
        if(writedNumber==generatedNumber) {
            guessed=true;
        } else {
            if(generatedNumber<writedNumber){
                isSmaller=true;
                isBigger=false;
            } else {
                isSmaller=false;
                isBigger=true;
            }
        }
    }
    public boolean getGuessedCondition()
    {
        return guessed;
    }
    public boolean getIsBigger()
    {
        return isBigger;
    }
    public boolean getIsSmaller()
    {
        return isSmaller;
    }
}
