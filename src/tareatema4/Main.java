package tareatema4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Main {


	/** Hacer que se pueda elegir si hay que guardarlo en fichero o en bbdd */

	public static void main(String[] args) throws FileNotFoundException, IOException {
		int menu, elec, elige, pagar, seleccion3, cantidad, cantidad1, numeroUnos, numerosUnos2;
		double total = 0, total2, total3 = 0;
		String telef, telef1 = "", telef2 = "", telef3 = "", tarj, seleccion1, seleccion2;
		java.util.Date fecha = new Date();
		DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		int[] stock = new int[30];
		int [] stock2 = new int [30];
		String rutaCliente = "C:/Users/34666/eclipse-workspace/TareaTema4/Clientes.txt";
		String rutaProducto = "C:/Users/34666/eclipse-workspace/TareaTema4/Productos.txt";
		String rutaTicket = "C:/Users/34666/eclipse-workspace/TareaTema4/Ticket.txt";
		ArrayList<Cliente> miArrayCliente = new ArrayList<Cliente>();
		ArrayList<Producto> miArrayProducto = new ArrayList<Producto>();
		ArrayList<String> tickets = new ArrayList<String>();
		String id1, id2, id3, id4, id5;
		String ticket2;
		UUID id_pedido = UUID.randomUUID();


		/**
		 * Creacion de la pasarela de pago
		 */

		PasarelaDePago pas = new PasarelaDePago(total, fecha);

		Scanner sc = new Scanner(System.in);

		/**
		 * Creacion de 3 Clientes necesarios
		 */
		Cliente c = new Cliente();
		Cliente c1 = new Cliente();
		Cliente c2 = new Cliente();
		/**
		 * Creacion de 5 productos
		 */
		Producto p = new Producto();
		Producto p1 = new Producto();
		Producto p2 = new Producto();
		Producto p3 = new Producto();
		Producto p4 = new Producto();

		/**
		 * Metodo para rellenar todos los stocks
		 */
		Producto.rellenarStock(stock);
		
		Producto.rellenarStock(stock2);


		System.out.println("Crea 3 Cliente:");
		Cliente.crearCliente(c);
		Cliente.crearCliente(c1);
		Cliente.crearCliente(c2);

		miArrayCliente.add(c);
		miArrayCliente.add(c1);
		miArrayCliente.add(c2);

		System.out.println("Crea 5 productos");
		Producto.crearProducto(p);
		Producto.crearProducto(p1);
		Producto.crearProducto(p2);
		Producto.crearProducto(p3);
		Producto.crearProducto(p4);


		System.out.println("Donde quieres guardar los clientes y los productos?");
		System.out.println("1. Fichero");
		System.out.println("2. Base de datos");

		int opcionEscribir = sc.nextInt();

		switch (opcionEscribir) {

		case 1:
			Fichero.escribeFichero(rutaCliente, miArrayCliente);
			Fichero.escribeFicheroProducto(rutaProducto, miArrayProducto);
			Fichero.escribeFicheroTicket(rutaTicket, tickets);
			break;

		case 2:
			TestConexion.consulta_insert(c.getTelefono(), c.getNombre(), c.getApellidos(), c.getDireccion());
			TestConexion.consulta_insert(c1.getTelefono(), c1.getNombre(), c1.getApellidos(), c1.getDireccion());
			TestConexion.consulta_insert(c2.getTelefono(), c2.getNombre(), c2.getApellidos(), c2.getDireccion());
			TestConexion.consulta_insert_producto(p.getId(), p.getNombre(), p.getPrecio(), p.getCantidad());
			TestConexion.consulta_insert_producto(p1.getId(), p1.getNombre(), p1.getPrecio(), p1.getCantidad());
			TestConexion.consulta_insert_producto(p2.getId(), p2.getNombre(), p2.getPrecio(), p2.getCantidad());
			TestConexion.consulta_insert_producto(p3.getId(), p3.getNombre(), p3.getPrecio(), p3.getCantidad());
			TestConexion.consulta_insert_producto(p4.getId(), p4.getNombre(), p4.getPrecio(), p4.getCantidad());
			break;

		default:
			System.err.println("Error, seleccione 1 o 2");
		}



		/**
		 * Esta funcion sirve para que el Cliente se registre con su numero de telefono
		 * y pueda hacer su compra
		 */

		boolean tupadre = false;

		while (!tupadre) {
			System.out.println("Registrate indicando tu numero de telefono, dado anteriormente:");
			telef = sc.next();
			if (telef.equalsIgnoreCase(c.getTelefono()) || telef.equalsIgnoreCase(c1.getTelefono())
					|| telef.equalsIgnoreCase(c2.getTelefono())) {

				System.out.println("El registro ha sido exitoso");
				tupadre = true;
			} else {
				System.out.println("Error, vuelva a intentarlo");
				tupadre = false;
			}

		}

		/**
		 * Menu con los nombres de los productos para que los elija el Cliente
		 */

			System.out.println("\t Menu de pedidos");
			System.out.println("1. " + p.getNombre());
			System.out.println("2. " + p1.getNombre());
			System.out.println("3. " + p2.getNombre());
			System.out.println("4. " + p3.getNombre());
			System.out.println("5. " + p4.getNombre());

			System.out.println("Seleccione un pedido:");
			elec = sc.nextInt();

			/**
			 * Estos if seleccionan los productos elegidos por el cliente y calculan el
			 * precio total para que sea pagado posteriormente
			 * 
			 * 
			 * Solo he puesto el stock en dos productos, porque para añadirlos a los demas
			 * es copiar y pegar todo el rato, no se me ocurria otra forma
			 */

			if (elec == 1) {
				Producto.verificar(stock, p);
					
				total = p.getCantidad() * p.getPrecio();

				System.out.println("\t Menu de pedidos");
				System.out.println("2. " + p1.getNombre());
				System.out.println("3. " + p2.getNombre());
				System.out.println("4. " + p3.getNombre());
				System.out.println("5. " + p4.getNombre());
				System.out.println("Seleccione otro pedido:");
				seleccion3 = sc.nextInt();

				if (seleccion3 == 2) {
					Producto.verificar(stock2, p1);

					total2 = p1.getPrecio() * p1.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p.getNombre(), p1.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

				if (seleccion3 == 3) {
					Producto.verificar(stock2, p2);

					total2 = p2.getPrecio() * p2.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p.getNombre(), p2.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

				if (seleccion3 == 4) {
					Producto.verificar(stock2, p3);

					total2 = p3.getPrecio() * p3.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p.getNombre(), p3.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

				if (seleccion3 == 5) {
					Producto.verificar(stock2, p4);

					total2 = p4.getPrecio() * p4.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p.getNombre(), p4.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);

				}

			}

			if (elec == 2) {
				Producto.verificar(stock, p1);
				System.out.println("Producto añadido correctamente.");
				total = p1.getCantidad() * p1.getPrecio();

				System.out.println("\t Menu de pedidos");
				System.out.println("1. " + p.getNombre());
				System.out.println("3. " + p2.getNombre());
				System.out.println("4. " + p3.getNombre());
				System.out.println("5. " + p4.getNombre());
				System.out.println("Seleccione otro pedido:");
				seleccion3 = sc.nextInt();

				if (seleccion3 == 1) {
					Producto.verificar(stock2, p);

					total2 = p.getPrecio() * p.getCantidad();
					total3 = total + total2;
					PasarelaDePago.ticket(p1.getNombre(), p.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

				if (seleccion3 == 3) {
					Producto.verificar(stock2, p2);
					total2 = p2.getPrecio() * p2.getCantidad();
					total3 = total + total2;
					PasarelaDePago.ticket(p1.getNombre(), p2.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

				if (seleccion3 == 4) {
					Producto.verificar(stock2, p3);

					total2 = p3.getPrecio() * p3.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p1.getNombre(), p3.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

				if (seleccion3 == 5) {
					Producto.verificar(stock2, p4);
					total2 = p4.getPrecio() * p4.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p1.getNombre(), p4.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

			}

			if (elec == 3) {
				Producto.verificar(stock, p2);
				System.out.println("Producto añadido correctamente.");
				total = p2.getCantidad() * p2.getPrecio();

				System.out.println("\t Menu de pedidos");
				System.out.println("1. " + p.getNombre());
				System.out.println("2. " + p1.getNombre());
				System.out.println("4. " + p3.getNombre());
				System.out.println("5. " + p4.getNombre());
				System.out.println("Seleccione otro pedido:");
				seleccion3 = sc.nextInt();

				if (seleccion3 == 2) {
					Producto.verificar(stock2, p2);
					total2 = p1.getPrecio() * p1.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p2.getNombre(), p1.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

				if (seleccion3 == 1) {
					Producto.verificar(stock2, p);
					total2 = p.getPrecio() * p.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p2.getNombre(), p.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

				if (seleccion3 == 4) {
					Producto.verificar(stock2, p2);
					total2 = p3.getPrecio() * p3.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p2.getNombre(), p3.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

				if (seleccion3 == 5) {
					Producto.verificar(stock2, p4);
					total2 = p4.getPrecio() * p4.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p2.getNombre(), p4.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

			}

			if (elec == 4) {
				Producto.verificar(stock, p3);
				System.out.println("Producto añadido correctamente.");
				total = p3.getCantidad() * p3.getPrecio();

				System.out.println("\t Menu de pedidos");
				System.out.println("1. " + p.getNombre());
				System.out.println("2. " + p1.getNombre());
				System.out.println("3. " + p2.getNombre());
				System.out.println("5. " + p4.getNombre());
				System.out.println("Seleccione otro pedido:");
				seleccion3 = sc.nextInt();

				if (seleccion3 == 2) {
					Producto.verificar(stock2, p1);
					seleccion2 = p1.getNombre();
					total2 = p1.getPrecio() * p1.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p3.getNombre(), p1.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

				if (seleccion3 == 3) {
					Producto.verificar(stock2, p2);
					total2 = p2.getPrecio() * p2.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p3.getNombre(), p2.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);

				}

				if (seleccion3 == 1) {
					Producto.verificar(stock2, p);
					total2 = p.getPrecio() * p.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p3.getNombre(), p.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

				if (seleccion3 == 5) {
					Producto.verificar(stock2, p4);
					total2 = p4.getPrecio() * p4.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p3.getNombre(), p4.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

			}

			if (elec == 5) {
				Producto.verificar(stock, p4);
				System.out.println("Producto añadido correctamente.");
				total = p4.getCantidad() * p4.getPrecio();

				System.out.println("\t Menu de pedidos");
				System.out.println("1. " + p.getNombre());
				System.out.println("2. " + p1.getNombre());
				System.out.println("3. " + p2.getNombre());
				System.out.println("4. " + p3.getNombre());
				System.out.println("Seleccione otro pedido:");
				seleccion3 = sc.nextInt();

				if (seleccion3 == 2) {
					Producto.verificar(stock2, p1);
					total2 = p1.getPrecio() * p1.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p4.getNombre(), p1.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);

				}

				if (seleccion3 == 3) {
					Producto.verificar(stock2, p2);
					total2 = p2.getPrecio() * p2.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p4.getNombre(), p2.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

				if (seleccion3 == 4) {
					Producto.verificar(stock2, p3);
					total2 = p3.getPrecio() * p3.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p4.getNombre(), p3.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

				if (seleccion3 == 1) {
					Producto.verificar(stock2, p);
					total2 = p.getPrecio() * p.getCantidad();
					total3 = total + total2;

					PasarelaDePago.ticket(p4.getNombre(), p.getNombre(), total3, tickets);
					Fichero.escribeFicheroTicket(rutaTicket, tickets);
				}

			}


			/**
			 * Menu para elegir el metodo de pago
			 */
		System.out.println("PAGO");
		System.out.println("1. En efectivo");
		System.out.println("2. Con tarjeta");
		System.out.println("3. Transferencia bancaria");
		System.out.println("Selecione como quieres pagar:");
		pagar = sc.nextInt();

		/**
		 * Este switch elige el metodo de pago y llama a la clase donde estan los
		 * metodos para realizar el pago
		 */
		switch (pagar) {

		case 1:
			PasarelaDePago.Efectivo(total3);
			break;
		case 2:
			PasarelaDePago.Tarjeta();
			break;
		case 3:
			PasarelaDePago.Cuenta();
			break;
		default:
			System.out.println("Error al pagar");
		}

	}

}
