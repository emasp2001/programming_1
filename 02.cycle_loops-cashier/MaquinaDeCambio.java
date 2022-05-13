/**
 *
 * @author emma
 */
public class MaquinaDeCambio {
    private final int CANTIDAD = 475;
    private int cantidadMonedas100;
    private int cantidadMonedas25;
    private int cantidadMonedas5;
    
    public MaquinaDeCambio()
    {
        cantidadMonedas100 = 0;
        cantidadMonedas25 = 0;
        cantidadMonedas5 = 0;
    }
    
    public void calcularCambio()
    {
        int cantidad = CANTIDAD;
        while (cantidad!=0)
        {
            if(cantidad>=100)
            {
                cantidad=cantidad-100;
                cantidadMonedas100++;
            } else{
                if(cantidad>=25)
                {
                    cantidad=cantidad-25;
                    cantidadMonedas25++;
                } else {
                    cantidad=cantidad-5;
                    cantidadMonedas5++;
                }
            }
        }
    }
    
    public String toString()
    {
        String cantidadDeCambio = "Debe dar de vuelto para: "+CANTIDAD
                +"\n"+cantidadMonedas100+" monedas de 100."
                +"\n"+cantidadMonedas25+" monedas de 25."
                +"\n"+cantidadMonedas5+" monedas de 5.";
        
        return cantidadDeCambio;
    }
    
}
