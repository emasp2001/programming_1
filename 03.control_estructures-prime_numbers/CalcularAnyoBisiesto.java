/*
 * This is the class whos is gonna use the methods for solving the year problem.
 */

/**
 *
 * @author emma
 */
package Laboratory2;
public class CalcularAnyoBisiesto {
    private int anyo;
    private boolean esBisiesto;
    
    public CalcularAnyoBisiesto()
    {
        anyo = -1;
        esBisiesto = false;
    }
    public void setAnyo(int anyoRecibido)
    {
        this.anyo = anyoRecibido;
    }
    public int getAnyo()
    {
        return anyo;
    }
    public boolean getEsBisiesto()
    {
        return esBisiesto;
    }
    public boolean averiguarSiBisiesto()
    {
        if (anyo%4==0){
            esBisiesto=true;
            if(anyo%100==0){
                esBisiesto=false;
                if(anyo%400==0){
                    esBisiesto = true;
                }
            } 
        }
        return esBisiesto;
    }
    public boolean averiguarSiBisiestoSwitch()
    {
        int divido400=anyo%400;
        int divido100=anyo%100;
        int divido4=anyo%4;
        switch(divido4){
            case 0:
                esBisiesto=true;
                if(divido100==0){
                    esBisiesto=false;
                    if(divido400==0){
                        esBisiesto=true;
                    }
                }
            break;
        }
        return esBisiesto;
    }
}
