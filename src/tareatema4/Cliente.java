package tareatema4;

import java.util.Date;
import java.util.Scanner;

public class Cliente {

	/**
	 * Atributos de la clase cliente
	 */

	String nombre, apellidos, direccion, telefono, historial;
	Date fecha_alta = new Date();

	/**
	 * Constructor
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param direccion
	 * @param historial
	 * @param telefono
	 * @param fecha_alta
	 */

	public Cliente(String nombre, String apellidos, String direccion, String historial, String telefono,
			Date fecha_alta) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.historial = historial;
		this.telefono = telefono;
		this.fecha_alta = fecha_alta;
	}

	/**
	 * Constructor vacio
	 */

	public Cliente() {

	}

	/**
	 * Getters and Setters
	 */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toLowerCase();
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos.toUpperCase();
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHistorial() {
		return historial;
	}

	public void setHistorial(String historial) {
		this.historial = historial;
	}

	public String getTelefono() {
		return telefono;
	}

	/**
	 * Este Set sirve para validar el telefono
	 * 
	 * @param telefono
	 */

	public void setTelefono(String telefono) {
		boolean telefonito = false;
		Scanner sc = new Scanner(System.in);
		char uno;
		while (!telefonito) {
			System.out.println("Escriba tu numero de telefono");
			telefono = sc.next();
			uno = telefono.charAt(0);

			if (uno != '6' && uno != '7' && uno != '8' && uno != '9' || telefono.length() != 9) {
				System.out.println("Error con el numero, intentelo de nuevo");
				telefonito = false;
			} else {
				telefonito = true;

			}


		}
		this.telefono = telefono;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	/**
	 * Metodo para agregar un pedido al historial
	 * 
	 * @param pedido
	 */

	public void agregarPedido(Pedido pedido) {
		if (pedido != null) {
			this.historial = this.historial + 1;
		}
	}

}
