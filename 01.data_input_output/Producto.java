public class Producto {
	private String nombre;
	private double precio;
	private char diaHorneado;
	private boolean rancio;

	public String getNombre(){
		return nombre;
	}

	public double getPrecio(){
		return precio;
	}

	public char getDiaHorneado(){
		return diaHorneado;
	}

	public boolean getRancio(){
		return rancio;
	}

	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	public void setPrecio(double precio){
		this.precio=precio;
	}

	public void setDiaHorneado(char diaHorneado){
		this.diaHorneado=diaHorneado;
	}

	public void setRancio(boolean rancio){
		this.rancio=rancio;
	}

	public String toString(){
		return "Nombre de su producto escogido: "+nombre+ "\nEl mejor precio: "+precio+ "\nDia horneado: "+diaHorneado+ "Su producto esta rancio: " +rancio;
	}
}