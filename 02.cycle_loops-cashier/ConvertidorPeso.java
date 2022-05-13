/**
 *
 * @author emma
 */
public class ConvertidorPeso {
    private double estatura; //En metros
    private double peso; //En Kg
    
    public ConvertidorPeso()
    {
        estatura = (Math.random()*2.6);
        estatura = Math.rint(estatura*10)/10;
        peso = (int)(Math.random()*121);
    }
    
    public double calcularIMC()
    {
        double indiceMasaCorporal = peso/estatura;
        indiceMasaCorporal = Math.rint(indiceMasaCorporal*100)/100;
        return indiceMasaCorporal;
    }
    
    public String toString()
    {
        double indiceMasaCorporal = calcularIMC();
        String texto = "Su peso es: "+peso+"kg, su estatura: "+estatura+"m; asi que su Indice de Masa Corporal es: "+indiceMasaCorporal+".";
        return texto;
    }
    
}
