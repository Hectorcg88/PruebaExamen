package tareatema4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConexion {

	private static String selectTableSQL;
	private static String insertTableSQL;
	private static String updateTableSQL;

	public static void cerrar_conexion3(Connection cn, Statement stm, ResultSet rs) {
		// Liberar recursos revisar el orden en el que se cierran, orden inverso
		try {
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (cn != null) {
				cn.close();
			}
			System.out.println("La conexión se ha cerrado con éxito");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}

	}

	public static void consulta_select() {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		selectTableSQL = "SELECT * FROM USUARIO";

		try {
			// Abrimos la conexion con la base de datos
			cn = conexion.conectar();
			stm = cn.createStatement();
			// Pasamos la consulta al ResultSet
			rs = stm.executeQuery(selectTableSQL);

			while (rs.next()) {
				int idUsuario = rs.getInt(1);
				String usuario = rs.getString(2);
				String clave = rs.getString(3);

				System.out.println(idUsuario + " " + usuario + " " + clave);
			}
		} catch (SQLException e) { // TODO: handle exception

		} finally {
			cerrar_conexion3(cn, stm, rs);
		}

	}

	public static void consulta_insert(String telefono, String nombre, String apellidos, String direccion) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;

		// int id_usuario=null;
		// Crear sentencia SQL para insertar en la base de datos
		insertTableSQL = "INSERT INTO cliente (telefono,nombre,apellidos,direccion) VALUES (?,?,?,?)";

		try {

			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);

			ps.setString(1, telefono);
			ps.setString(2, nombre);
			ps.setString(3, apellidos);
			ps.setString(4, direccion);
			ps.executeUpdate();

			System.out.println("El registro ha sido insertado con exito en la base de datos");

		} catch (SQLException e) { // TODO: handle exception

			e.printStackTrace();

		} finally { // Liberar recursos revisar el orden en el que se cierran
			try {

				if (ps != null) {
					ps.close();
				}

				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

	}

	public static void consulta_insert_producto(String id, String nombre, double precio, int cantidad) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;

		// int id_usuario=null;
		// Crear sentencia SQL para insertar en la base de datos
		insertTableSQL = "INSERT INTO producto (id_producto,nombre,precio,cantidad) VALUES (?,?,?,?)";

		try {

			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);

			ps.setString(1, id);
			ps.setString(2, nombre);
			ps.setDouble(3, precio);
			ps.setInt(4, cantidad);
			ps.executeUpdate();

			System.out.println("El registro ha sido insertado con exito en la base de datos");

		} catch (SQLException e) { // TODO: handle exception

			e.printStackTrace();

		} finally { // Liberar recursos revisar el orden en el que se cierran
			try {

				if (ps != null) {
					ps.close();
				}

				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

	}

	public static void consulta_insert_pedido(String id_pedido, String telefono, String id_producto) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;

		// int id_usuario=null;
		// Crear sentencia SQL para insertar en la base de datos
		insertTableSQL = "INSERT INTO pedido (id_pedido, telefono_cliente, id_producto) VALUES (?,?,?)";

		try {

			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);

			ps.setString(1, id_pedido);
			ps.setString(2, telefono);
			ps.setString(3, id_producto);
			ps.executeUpdate();

			System.out.println("El registro ha sido insertado con exito en la base de datos");

		} catch (SQLException e) { // TODO: handle exception

			e.printStackTrace();

		} finally { // Liberar recursos revisar el orden en el que se cierran
			try {

				if (ps != null) {
					ps.close();
				}

				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

	}

	public static void consulta_update(int id_usuario, String usuario, String clave) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;

		// Crear sentencia SQL para insertar en la base de datos
		updateTableSQL = "UPDATE usuario set usuario ='" + usuario + "', clave='" + clave + "' where idusuario="
				+ id_usuario;

		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			int valor = stm.executeUpdate(updateTableSQL);
			if (valor == 1) {
				System.out.println("El usuario ha sido actualizado correctamente");
			} else {
				System.out.println("No existe usuario con el id_usuario referido");
			}

		} catch (SQLException e) { // TODO: handle exception

			e.printStackTrace();

		} finally { // Liberar recursos revisar el orden en el que se cierran
			try {

				if (stm != null) {
					stm.close();
				}

				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

	}

	public static void main(String[] args) {

		consulta_select();
		// consulta_insert("Lucas", "123");
		// consulta_update(7, "alvaro", "123");

	}

}

