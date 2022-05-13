/**
 *
 * @author emma
 */
public class ConvertidorTemperatura {
    private double gradosCelsius;
    
    public ConvertidorTemperatura()
    {
        gradosCelsius = (int)(Math.random()*251); //La idea con esta formula es que sea capaz de generar tanto como numeros positivos como negativos en un rango considerable.
    }
    
    public double convertidorCelsiusKelvin()
    {
        double gradosKelvin = ((int)gradosCelsius + 273.15);
        return gradosKelvin;
    }
    
    public double convertidorCelsiusFahrenheit()
    {
        double gradosFahrenheit = gradosCelsius*(9/5)+32;
        gradosFahrenheit = (int) gradosFahrenheit;
        return gradosFahrenheit;
    }
    
    public String toString()
    {
        double numeroFahrenheit = convertidorCelsiusFahrenheit();
        double numeroKelvin = convertidorCelsiusKelvin();
        String texto = "El valor de prueba es: "+gradosCelsius+"C, en Kelvin es: "+numeroKelvin+"K, y en Fahrenheit es:"+numeroFahrenheit+"F."; 
        
        return texto;
    }
    
}
