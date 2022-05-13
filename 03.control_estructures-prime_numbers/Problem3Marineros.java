/*
 * Reto opcional donde deberiamos averiguar cuantas monedas iniciales tenian los mineros.
/**
 *
 * @author emma
 */
package Laboratory2;
public class Problem3Marineros {
    public int amountGaveAway;
    
    public Problem3Marineros()
    {
        amountGaveAway=-1;
    }
    public int findOutQuantity()
    {
        int primerNumero=-1;
        int segundoNumero=-1;
        int tercerNumero=-1;
        int cuartoNumero=-1;
        int contador=200;
        boolean encontrado=false;
        while(encontrado==false)
        {
            primerNumero=contador;
            segundoNumero=((primerNumero-1)-((primerNumero-1)/3));
            tercerNumero=((segundoNumero-1)-((segundoNumero-1)/3));
            cuartoNumero=((tercerNumero-1)-((tercerNumero-1)/3));
            if((primerNumero-1)%3==0 && (segundoNumero-1)%3==0 && (tercerNumero-1)%3==0 && (cuartoNumero-1)%3==0)
            {
                encontrado=true;
            }
            contador++;
        }
        amountGaveAway=primerNumero;
        
        return amountGaveAway;
    }
}
