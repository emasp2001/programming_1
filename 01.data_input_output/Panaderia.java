import java.util.Scanner;

public class Panaderia{
   public static void main(String [] v){
       Producto art1=new Producto();
       Producto art2=new Producto ();    

       Scanner entrada = new Scanner(System.in);

	   System.out.print("Digite el nombre del producto: ");
	   String nombre = entrada.next();
	 
	   System.out.print("\nDigite el precio del producto: ");
	   double precio = entrada.nextDouble();

	   System.out.print("\nDigite que dia de la semana fue horneado, usando los caracteres D, L, K, M, J, V, S: ");
	   char diaHorneado = entrada.next().charAt(0);
	   
	   System.out.print("\nDigite si el producto se encuentra rancio, usando true para si o false para no: ");
	   boolean rancio = entrada.nextBoolean();

	   art1.setNombre(nombre);
	   art1.setPrecio(precio);
	   art1.setDiaHorneado(diaHorneado);
	   art1.setRancio(rancio);


	   System.out.print("Digite el nombre del segundo producto: ");
	   String nombrea = entrada.next();
	 
	   System.out.print("\nDigite el precio del segundo producto: ");
	   double precioa = entrada.nextDouble();

	   System.out.print("\nDigite que dia de la semana fue horneado su segundo producto,\n usando los caracteres D, L, K, M, J, V, S: ");
	   char diaHorneadoa = entrada.next().charAt(0);
	   
	   System.out.print("\nDigite si el producto se encuentra rancio, usando true para si o false para no: ");
	   boolean rancioa = entrada.nextBoolean();

	   art2.setNombre(nombrea);
	   art2.setPrecio(precioa);
	   art2.setDiaHorneado(diaHorneadoa);
	   art2.setRancio(rancioa);

	   System.out.println("\nEl nombre del producto es: "+nombre);	   
	   System.out.println("\nEl precio de su producto es: "+precio);	   
	   System.out.println("\nEl dia que fue horneado fue: "+diaHorneado);
	   System.out.println("\nSu producto se encuentra rancio: "+rancio);

	   System.out.println("\nEl nombre de se segundo producto es: "+nombrea);	   
	   System.out.println("\nEl precio de su segundo producto es: "+precioa);	   
	   System.out.println("\nEl dia que fue horneado su segundo producto fue: "+diaHorneadoa);
	   System.out.println("\nSu segundo producto se encuentra rancio: "+rancioa);	   
  	   
	   System.exit(0);
   }
}