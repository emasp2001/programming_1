/**
 *
 * @author emma
 */
import javax.swing.JOptionPane;
public class Main {
    public static void main(String []argv)
    {
        ConvertidorTemperatura convertidorTemp = new ConvertidorTemperatura();
        ConvertidorPeso convertidorPeso = new ConvertidorPeso();
        MaquinaDeCambio maquinaDeCambio = new MaquinaDeCambio();
        
        //System.out.println(convertidorTemp.toString());
        JOptionPane.showMessageDialog(null, convertidorTemp.toString());
        //System.out.println(convertidorPeso.toString());
        JOptionPane.showMessageDialog(null, convertidorPeso.toString());
        maquinaDeCambio.calcularCambio();
        //System.out.println(maquinaDeCambio.toString());
        JOptionPane.showMessageDialog(null, maquinaDeCambio.toString());
        
        System.exit(0);
    }
}