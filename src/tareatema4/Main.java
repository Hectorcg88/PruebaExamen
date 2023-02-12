package tareatema4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int menu, elec, elige, pagar, seleccion3;
		double total = 0, total2, total3;
		String telef, telef1 = "", telef2 = "", telef3 = "", tarj, seleccion1, seleccion2;
		java.util.Date fecha = new Date();
		DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

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
		 * Menu para crear los clientes y los productos
		 */

		System.out.println("Menu:");
		System.out.println("1. Crear 3 Clientes");
		System.out.println("2. Crear 5 Productos");
		System.out.println("Escoge una opcion:");
		menu = sc.nextInt();

		/**
		 * Funcion donde se ponen los datos a los clientes o productos
		 */

		switch (menu) {

		case 1:
			/** Esto es la creacion del 1º Cliente */
			System.out.println("Dime el nombre del Cliente:");
			c.setNombre(sc.next());
			System.out.println("Indica el apellido:");
			c.setApellidos(sc.next());
			System.out.println("Indica la direccion:");
			sc.nextLine();
			c.setDireccion(sc.nextLine());

			c.setTelefono(telef1);
			telef1 = c.getTelefono();
			System.out.println("La fecha de alta es :" + formato.format(fecha));
			c.setHistorial(" ");
			System.out.println("Primer Cliente creado correctamente");

			/** Esto es la creacion del 2º Cliente */
			System.out.println("Dime el nombre del Cliente:");
			c1.setNombre(sc.next());
			System.out.println("Indica el apellido:");
			c1.setApellidos(sc.next());
			System.out.println("Indica la direccion:");
			sc.nextLine();
			c1.setDireccion(sc.nextLine());

			c1.setTelefono(telef2);
			telef2 = c1.getTelefono();
			System.out.println("La fecha de alta es :" + formato.format(fecha));
			c1.setHistorial(" ");
			System.out.println("Segundo Cliente creado correctamente");

			/** Esto es la creacion del 3º Cliente */
			System.out.println("Dime el nombre del Cliente:");
			c2.setNombre(sc.next());
			System.out.println("Indica el apellido:");
			c2.setApellidos(sc.next());
			System.out.println("Indica la direccion:");
			sc.nextLine();
			c2.setDireccion(sc.nextLine());

			c2.setTelefono(telef3);
			telef3 = c2.getTelefono();
			System.out.println("La fecha de alta es :" + formato.format(fecha));
			c2.setHistorial(" ");
			System.out.println("Tercer cliente creado correctamente");
			break;

		case 2:
			/** Creacion del primer Producto */
			System.out.println("Indica e nombre del primer Producto:");
			sc.nextLine();
			p.setNombre(sc.nextLine());
			System.out.println("Indica el precio del Producto:");
			p.setPrecio(sc.nextDouble());
			System.out.println("Dime la cantidad de Producto");
			p.setCantidad(sc.nextInt());
			System.out.println("El primer Producto ha sido creado correctamente");

			/** Creacion del segundo Producto */
			System.out.println("Indica el nombre del segundo Producto:");
			sc.nextLine();
			p1.setNombre(sc.nextLine());
			System.out.println("Indica el precio del Producto:");
			p1.setPrecio(sc.nextDouble());
			System.out.println("Dime la cantidad de Producto");
			p1.setCantidad(sc.nextInt());
			System.out.println("El segundo Producto ha sido creado correctamente ");

			/** Creacion del tercer Producto */
			System.out.println("Indica el nombre del tercer Producto:");
			sc.nextLine();
			p2.setNombre(sc.nextLine());
			System.out.println("Indica el precio del Producto:");
			p2.setPrecio(sc.nextDouble());
			System.out.println("Dime la cantidad de Producto");
			p2.setCantidad(sc.nextInt());
			System.out.println("El tercer Producto ha sido creado correctamente");

			/** Creacion del cuarto Producto */
			System.out.println("Indica el nombre del cuarto Producto:");
			sc.nextLine();
			p3.setNombre(sc.nextLine());
			System.out.println("Indica el precio del Producto:");
			p3.setPrecio(sc.nextDouble());
			System.out.println("Dime la cantidad de Producto");
			p3.setCantidad(sc.nextInt());
			System.out.println("El cuarto Producto ha sido creado correctamente");

			/** Creacion del quinto Producto */
			System.out.println("Indica el nombre del quinto Producto:");
			sc.nextLine();
			p4.setNombre(sc.nextLine());
			System.out.println("Indica el precio del Producto:");
			p4.setPrecio(sc.nextDouble());
			System.out.println("Dime la cantidad de Producto");
			p4.setCantidad(sc.nextInt());
			System.out.println("El quinto Producto ha sido creado correctamente");
			break;

		default:
			System.out.println("Error");

		}
		/**
		 * Estos if sirven para crear los productos o los clientes, dependiendo de la
		 * eleccion anterior
		 */

		if (menu == 1) {
			/** Creacion del primer Producto */
			System.out.println("Indica e nombre del primer Producto:");
			sc.nextLine();
			p.setNombre(sc.nextLine());
			System.out.println("Indica el precio del Producto:");
			p.setPrecio(sc.nextDouble());
			System.out.println("Dime la cantidad de Producto");
			p.setCantidad(sc.nextInt());
			System.out.println("El primer Producto ha sido creado correctamente");

			/** Creacion del segundo Producto */
			System.out.println("Indica el nombre del segundo Producto:");
			sc.nextLine();
			p1.setNombre(sc.nextLine());
			System.out.println("Indica el precio del Producto:");
			p1.setPrecio(sc.nextDouble());
			System.out.println("Dime la cantidad de Producto");
			p1.setCantidad(sc.nextInt());
			System.out.println("El segundo Producto ha sido creado correctamente ");

			/** Creacion del tercer Producto */
			System.out.println("Indica el nombre del tercer Producto:");
			sc.nextLine();
			p2.setNombre(sc.nextLine());
			System.out.println("Indica el precio del Producto:");
			p2.setPrecio(sc.nextDouble());
			System.out.println("Dime la cantidad de Producto");
			p2.setCantidad(sc.nextInt());
			System.out.println("El tercer Producto ha sido creado correctamente");

			/** Creacion del cuarto Producto */
			System.out.println("Indica el nombre del cuarto Producto:");
			sc.nextLine();
			p3.setNombre(sc.nextLine());
			System.out.println("Indica el precio del Producto:");
			p3.setPrecio(sc.nextDouble());
			System.out.println("Dime la cantidad de Producto");
			p3.setCantidad(sc.nextInt());
			System.out.println("El cuarto Producto ha sido creado correctamente");

			/** Creacion del quinto Producto */
			System.out.println("Indica el nombre del quinto Producto:");
			sc.nextLine();
			p4.setNombre(sc.nextLine());
			System.out.println("Indica el precio del Producto:");
			p4.setPrecio(sc.nextDouble());
			System.out.println("Dime la cantidad de Producto");
			p4.setCantidad(sc.nextInt());
			System.out.println("El quinto Producto ha sido creado correctamente");

		}

		if (menu == 2) {
			/** Esto es la creacion del 1º Cliente */
			System.out.println("Dime el nombre del Cliente:");
			c.setNombre(sc.next());
			System.out.println("Indica el apellido:");
			c.setApellidos(sc.next());
			System.out.println("Indica la direccion:");
			sc.nextLine();
			c.setDireccion(sc.nextLine());

			c.setTelefono(telef1);
			telef1 = c.getTelefono();
			System.out.println("La fecha de alta es :" + formato.format(fecha));
			c.setHistorial(" ");
			System.out.println("Primer Cliente creado correctamente");

			/** Esto es la creacion del 2º Cliente */
			System.out.println("Dime el nombre del Cliente:");
			c1.setNombre(sc.next());
			System.out.println("Indica el apellido:");
			c1.setApellidos(sc.next());
			System.out.println("Indica la direccion:");
			sc.nextLine();
			c1.setDireccion(sc.nextLine());

			c1.setTelefono(telef2);
			telef2 = c1.getTelefono();
			System.out.println("La fecha de alta es :" + formato.format(fecha));
			c1.setHistorial(" ");
			System.out.println("Segundo Cliente creado correctamente");

			/** Esto es la creacion del 3º Cliente */
			System.out.println("Dime el nombre del Cliente:");
			c2.setNombre(sc.next());
			System.out.println("Indica el apellido:");
			c2.setApellidos(sc.next());
			System.out.println("Indica la direccion:");
			sc.nextLine();
			c2.setDireccion(sc.nextLine());

			c2.setTelefono(telef3);
			telef3 = c2.getTelefono();
			System.out.println("La fecha de alta es :" + formato.format(fecha));
			c2.setHistorial(" ");
			System.out.println("Tercer cliente creado correctamente");
		}

		/**
		 * Esta funcion sirve para que el Cliente se registre con su numero de telefono
		 * y pueda hacer su compra
		 */

		boolean tupadre = false;

		while (!tupadre) {
			System.out.println("Registrate indicando tu numero de telefono, dado anteriormente:");
			telef = sc.next();
			if (telef.equalsIgnoreCase(telef1) || telef.equalsIgnoreCase(telef2) || telef.equalsIgnoreCase(telef3)) {

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
			 */

			if (elec == 1) {
				System.out.println("Producto añadido correctamente.");
				seleccion1 = p.getNombre();
				total = p.getCantidad() * p.getPrecio();

				System.out.println("\t Menu de pedidos");
				System.out.println("2. " + p1.getNombre());
				System.out.println("3. " + p2.getNombre());
				System.out.println("4. " + p3.getNombre());
				System.out.println("5. " + p4.getNombre());
				System.out.println("Seleccione otro pedido:");
				seleccion3 = sc.nextInt();

				if (seleccion3 == 2) {
					seleccion2 = p1.getNombre();
					total2 = p1.getPrecio() * p1.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

				if (seleccion3 == 3) {
					seleccion2 = p2.getNombre();
					total2 = p2.getPrecio() * p2.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

				if (seleccion3 == 4) {
					seleccion2 = p3.getNombre();

					total2 = p3.getPrecio() * p3.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

				if (seleccion3 == 5) {
					seleccion2 = p4.getNombre();

					total2 = p4.getPrecio() * p4.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

			}

			if (elec == 2) {
				System.out.println("Producto añadido correctamente.");
				seleccion1 = p1.getNombre();
				total = p1.getCantidad() * p1.getPrecio();

				System.out.println("\t Menu de pedidos");
				System.out.println("1. " + p.getNombre());
				System.out.println("3. " + p2.getNombre());
				System.out.println("4. " + p3.getNombre());
				System.out.println("5. " + p4.getNombre());
				System.out.println("Seleccione otro pedido:");
				seleccion3 = sc.nextInt();

				if (seleccion3 == 1) {
					seleccion2 = p.getNombre();
					total2 = p.getPrecio() * p.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

				if (seleccion3 == 3) {
					seleccion2 = p2.getNombre();
					total2 = p2.getPrecio() * p2.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

				if (seleccion3 == 4) {
					seleccion2 = p3.getNombre();

					total2 = p3.getPrecio() * p3.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

				if (seleccion3 == 5) {
					seleccion2 = p4.getNombre();

					total2 = p4.getPrecio() * p4.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

			}

			if (elec == 3) {
				System.out.println("Producto añadido correctamente.");
				seleccion1 = p2.getNombre();
				total = p2.getCantidad() * p2.getPrecio();

				System.out.println("\t Menu de pedidos");
				System.out.println("1. " + p.getNombre());
				System.out.println("2. " + p1.getNombre());
				System.out.println("4. " + p3.getNombre());
				System.out.println("5. " + p4.getNombre());
				System.out.println("Seleccione otro pedido:");
				seleccion3 = sc.nextInt();

				if (seleccion3 == 2) {
					seleccion2 = p1.getNombre();
					total2 = p1.getPrecio() * p1.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

				if (seleccion3 == 1) {
					seleccion2 = p.getNombre();
					total2 = p.getPrecio() * p.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

				if (seleccion3 == 4) {
					seleccion2 = p3.getNombre();
					total2 = p3.getPrecio() * p3.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

				if (seleccion3 == 5) {
					seleccion2 = p4.getNombre();
					total2 = p4.getPrecio() * p4.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

			}

			if (elec == 4) {
				System.out.println("Producto añadido correctamente.");
				seleccion1 = p3.getNombre();
				total = p3.getCantidad() * p3.getPrecio();

				System.out.println("\t Menu de pedidos");
				System.out.println("1. " + p.getNombre());
				System.out.println("2. " + p1.getNombre());
				System.out.println("3. " + p2.getNombre());
				System.out.println("5. " + p4.getNombre());
				System.out.println("Seleccione otro pedido:");
				seleccion3 = sc.nextInt();

				if (seleccion3 == 2) {
					seleccion2 = p1.getNombre();
					total2 = p1.getPrecio() * p1.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

				if (seleccion3 == 3) {
					seleccion2 = p2.getNombre();
					total2 = p2.getPrecio() * p2.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

				if (seleccion3 == 1) {
					seleccion2 = p.getNombre();
					total2 = p.getPrecio() * p.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

				if (seleccion3 == 5) {
					seleccion2 = p4.getNombre();
					total2 = p4.getPrecio() * p4.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

			}

			if (elec == 5) {
				System.out.println("Producto añadido correctamente.");
				seleccion1 = p4.getNombre();
				total = p4.getCantidad() * p4.getPrecio();

				System.out.println("\t Menu de pedidos");
				System.out.println("1. " + p.getNombre());
				System.out.println("2. " + p1.getNombre());
				System.out.println("3. " + p2.getNombre());
				System.out.println("4. " + p3.getNombre());
				System.out.println("Seleccione otro pedido:");
				seleccion3 = sc.nextInt();

				if (seleccion3 == 2) {
					seleccion2 = p1.getNombre();
					total2 = p1.getPrecio() * p1.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

				if (seleccion3 == 3) {
					seleccion2 = p2.getNombre();
					total2 = p2.getPrecio() * p2.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

				if (seleccion3 == 4) {
					seleccion2 = p3.getNombre();
					total2 = p3.getPrecio() * p3.getCantidad();
					total3 = total + total2;

					System.out.println("Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
				}

				if (seleccion3 == 1) {
					seleccion2 = p.getNombre();
					total2 = p.getPrecio() * p.getCantidad();
					total3 = total + total2;

					System.out.println("\t Tus pedidos");
					System.out.println("1." + seleccion1);
					System.out.println("2. " + seleccion2);
					System.out.println("El importe total es: " + total3);
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
			PasarelaDePago.Efectivo(total);
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
