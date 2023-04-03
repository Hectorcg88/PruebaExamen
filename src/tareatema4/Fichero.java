package tareatema4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Fichero {

	public static void leerFichero(String archivo, String buscaTelefono) throws FileNotFoundException, IOException {
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		String linea;
		boolean encontrado = false;
		while ((linea = b.readLine()) != null) {
			if (linea.contains(buscaTelefono)) {
				encontrado = true;
				break;
			}
		}
		b.close();
		if (encontrado) {
			System.out.println("Ya estaba registrado en la base de datos");
		} else {
			System.out.println("Se ha registrado correctamente en la base de datos");
		}

	}

	public static void escribeFichero(String archivo, ArrayList<Cliente> miArray) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			// Añadir flag a true para no machacar contenido del fichero de escritura
			fichero = new FileWriter(archivo, true);
			pw = new PrintWriter(fichero);

			for (int i = 0; i < miArray.size(); i++) {
				pw.println(miArray.get(i).mostrar());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero) {
					fichero.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void fileScanner(String archivo) {
		File f = new File(archivo);
		System.out.println("La ruta del fichero es: " + f.getAbsolutePath());
		Scanner s;
		try {
			s = new Scanner(f);
			while (s.hasNextLine()) {
				String linea = s.nextLine();
				Scanner sl = new Scanner(linea);
				sl.useDelimiter("\\s*,\\s*");
				System.out.println(sl.next());
				System.out.println(sl.next());
				System.out.println(sl.next());
				System.out.println(sl.next());
				System.out.println(sl.next());
			}
			s.close();

		} catch (FileNotFoundException e) {
			// PrintWriter pw = null;
			e.printStackTrace();
			// e.printStackTrace(pw);

		}
	}

	public static void escribeFicheroProducto(String archivo, ArrayList<Producto> miArray) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			// Añadir flag a true para no machacar contenido del fichero de escritura
			fichero = new FileWriter(archivo, true);
			pw = new PrintWriter(fichero);

			for (int i = 0; i < miArray.size(); i++) {
				pw.println(miArray.get(i).mostrar());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero) {
					fichero.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
