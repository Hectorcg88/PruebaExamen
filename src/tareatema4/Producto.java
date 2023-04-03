package tareatema4;

public class Producto {

	/**
	 * Variables de la clase producto
	 */
	String nombre;
	double precio;
	int cantidad, id;
	int[] stock = new int[30];
	/**
	 * Creacion de los constructores necesarios, con y sin atributos
	 * 
	 * @param nombre
	 * @param precio
	 * @param cantidad
	 */

	public Producto(String nombre, double precio, int cantidad, int id) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.id = id;

	}

	/**
	 * Constructor vacio
	 */

	public Producto() {

	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * Getters y setters
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String mostrar() {

		return getId() + "," + getNombre() + "," + getPrecio() + "," + getCantidad();
	}


}

