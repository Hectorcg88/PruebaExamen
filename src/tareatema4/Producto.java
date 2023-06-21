package tareatema4;

import java.util.Scanner;

public class Producto {

	/**
	 * Variables de la clase producto
	 */
	String nombre;
	double precio;
	int cantidad;
	String id;
	int[] stock = new int[30];
	/**
	 * Creacion de los constructores necesarios, con y sin atributos
	 * 
	 * @param nombre
	 * @param precio
	 * @param cantidad
	 */

	public Producto(String id, String nombre, double precio, int cantidad) {
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String mostrar() {

		return getId() + "," + getNombre() + "," + getPrecio() + "," + getCantidad();
	}

	public static Producto crearProducto(Producto p) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Indica la id del producto");
		p.setId(sc.next());
		System.out.println("Indica el nombre del producto");
		p.setNombre(sc.next());
		System.out.println("Indica el precio del producto");
		p.setPrecio(sc.nextDouble());
		return p;

	}

	public static void rellenarStock(int stock[]) {
		for (int i = 1; i < stock.length; i++) {
			stock[i] = 1;
		}
	}

	public static void verificar(int[] stock, Producto p) {
		Scanner sc = new Scanner(System.in);
		boolean verCantidad = false;
		int contador = 0;

		for (int i = 0; i < stock.length; i++) {
			if (stock[i] == 1) {
				contador++;
			}
		}

		while (!verCantidad) {
			System.out.println("Indica la cantidad de producto que quieres:");
			int cantidad = sc.nextInt();
			p.setCantidad(contador - cantidad);

			if (cantidad <= contador && cantidad > 0) {
				System.out.println("Producto añadido");
				verCantidad = true;
			} else {
				System.out.println("No hay stock suficiente, prueba con un stock menor");
				verCantidad = false;
			}

		}
	}
}

