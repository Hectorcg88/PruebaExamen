package tareatema4;

import java.util.Date;
import java.util.Scanner;

public class PasarelaDePago {

	/**
	 * Atributos de PasarelaDePago
	 */

	double importe;
	Date codigo_pago = new Date();

	/**
	 * Constructor
	 * 
	 * @param importe
	 * @param codigo_pago
	 */

	public PasarelaDePago(double importe, Date codigo_pago) {
		this.importe = importe;
		this.codigo_pago = codigo_pago;

	}

	/**
	 * Getters and Setters
	 */

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Date getCodigo_pago() {
		return codigo_pago;
	}

	public void setCodigo_pago(Date codigo_pago) {
		this.codigo_pago = codigo_pago;
	}

	/**
	 * Metodo para pagar en efectivo
	 *
	 * @param cuenta
	 */

	public static void Efectivo(double cuenta) {
		Scanner sc = new Scanner(System.in);

		/**
		 * Diferentes variables para realizar el pago
		 */
		double devol = 0, pagado = 0;
		int cont50 = 0, cont20 = 0, cont10 = 0, cont5 = 0, cont2 = 0, cont1 = 0, cont05 = 0, cont02 = 0, cont01 = 0,
				cont005 = 0, cont002 = 0, cont001 = 0;
		System.out.println("¿Cuanto has pagado?");
		pagado = sc.nextDouble();
		devol = pagado - cuenta;

		/**
		 * Te indica la devolucion justa, indicando monedaas y billetes que tienes que
		 * dar
		 */

		if (devol > 0) {
			while (devol >= 50) {
				devol -= 50;
				cont50++;
			}

			while (devol >= 20 && devol < 50) {
				devol -= 20;
				cont20++;
			}

			while (devol >= 10 && devol < 20) {
				devol -= 10;
				cont10++;
			}

			while (devol >= 5 && devol < 10) {
				devol -= 5;
				cont5++;
			}

			while (devol >= 2 && devol < 5) {
				devol -= 2;
				cont2++;
			}

			while (devol >= 1 && devol < 2) {
				devol -= 1;
				cont1++;
			}
			while (devol >= 0.5 && devol < 1) {
				devol -= 0.5;
				cont05++;
			}
			while (devol >= 0.2 && devol <= 0.5) {
				devol -= 0.2;
				cont02++;
			}
			while (devol >= 0.1 && devol <= 0.2) {
				devol -= 0.1;
				cont01++;
			}
			while (devol >= 0.05 && devol < 0.1) {
				devol -= 0.05;
				cont005++;
			}
			while (devol >= 0.02 && devol < 0.05) {
				devol -= 0.02;
				cont002++;
			}
			while (devol >= 0.01 && devol < 0.02) {
				devol -= 0.01;
				cont001++;
			}
			System.out.println("Su devolucion es: " + cont50 + " billetes de 50, " + cont20 + " billetes de 20, "
					+ cont10 + " billetes de 10, " + cont5 + " billetes de 5, " + cont2 + " monedas de 2, " + cont1
					+ " monedas de 1, " + cont05 + " monedas de 0.5, " + cont02 + " monedas de 0.2, " + cont01
					+ " moneda de 0.1, " + cont005 + " moneda de 0.05, " + cont002 + " moneda de 0.02, " + cont001
					+ " moneda de 0.01, ");
		} else if (devol == 0) {
			System.out.println("No hay devolución");
		} else if (devol < 0) {
			System.out.println("Falta dinero");
		}
		sc.close();
	}

	/**
	 * Este metodo sirve para pagar con tarjeta
	 */

	public static void Tarjeta() {
		Scanner sc = new Scanner(System.in);
		String tarj = null;

		boolean tumadre = false;
		while (!tumadre) {
			System.out.println("Indica el numero de tu trajeta:");
			tarj = sc.nextLine();
			Integer tamaño;
			tarj.length();
			tamaño = tarj.length();

			if (tamaño == 17 || tamaño == 19) {
				System.out.println("Su tarjeta es:" + tarj);
				System.out.println("Exito en el pago, gracias por la compra");
				tumadre = true;
			} else {
				System.out.println("Error con la tarjeta, Intentelo de nuevo");
				tumadre = false;
			}
		}
		sc.close();
	}

	/**
	 * Metodo para pagar atraves de transferencia bancaria
	 */
	public static void Cuenta() {

		System.out.println("Depositando el total a la siguiente cuenta: 7848721 36791200 79543851.");
		System.out.println("La transferencia ha sido exitosa. Gracias por la compra");
	}

}
