package tareatema4;

public class Pedido {

	/**
	 * Atributos para la clase Pedido
	 */

	Cliente cliente;
	Producto producto_1, producto_2, producto;
	double importe_total;
	PasarelaDePago pago;
	String estado;

	/**
	 * Constructor de Pedido
	 * 
	 * @param producto
	 * @param pago
	 */

	public Pedido(Producto producto, PasarelaDePago pago) {

	}

	/**
	 * Getters and Setters
	 */

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto_1() {
		return producto_1;
	}

	public void setProducto_1(Producto producto_1) {
		this.producto_1 = producto_1;
	}

	public Producto getProducto_2() {
		return producto_2;
	}

	public void setProducto_2(Producto producto_2) {
		this.producto_2 = producto_2;
	}

	public double getImporte_total() {
		return importe_total;
	}

	public void setImporte_total(double importe_total) {
		this.importe_total = importe_total;
	}

	public PasarelaDePago getPago() {
		return pago;
	}

	public void setPago(PasarelaDePago pago) {
		this.pago = pago;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	/***
	 * Metodo para agregar un cliente
	 * 
	 * @param cliente
	 */

	public void agregarCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Metodo para agregar un producto
	 * 
	 * @param producto
	 */

	public void agregarProducto1(Producto producto) {
		this.producto_1 = producto;
		this.importe_total = importe_total + producto.getPrecio();
	}

	/**
	 * Metodo para agregar el segundo producto
	 * 
	 * @param producto
	 */

	public void agregarProducto_2(Producto producto) {

		if (this.producto_1 == null) {
			System.out.println("Error al añadir el producto 2, primero añada el 1");
		} else {
			this.producto_2 = producto;
			this.importe_total = importe_total + producto.getPrecio();
		}

	}

	/**
	 * Metodo para eliminar un producto añadido
	 * 
	 * @param producto
	 */

	public void eliminarProducto(Producto producto) {
		if (this.producto_1 == producto) {
			this.importe_total = importe_total - producto.getPrecio();
			this.producto_1 = null;
		} else if (this.producto_2 == producto) {
			this.importe_total = importe_total - producto.getPrecio();
		} else {
			System.out.println("Error al eliminar el producto, intentelo de nuevo");
		}
	}

	/**
	 * Metodo para devolver los nombres de los productos y el importe total
	 */

	@Override
	public String toString() {
		return "El producto 1 es " + this.producto_1.getNombre() + "\n" + "El producto 2 es "
				+ this.producto_2.getNombre() + ". El importe total de los productos es " + this.importe_total;
	}


}
