package tareatema4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class FuncionalidadTest {

	@Test
	public void testVerificar() {
		int[] stock = new int[30];
		Producto p = new Producto();

		Producto.rellenarStock(stock);

		Producto.verificar(stock, p);

		int resultado = 20;
		int esperado = p.getCantidad();

		assertEquals(resultado, esperado);
	}


	@Test
	public void testConsultaInsert() throws SQLException {
		String telefono = "878776799";
		String nombre = "hector";
		String apellidos = "cases";
		String direccion = "qweqw";
		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;

		try {
			// Llamar al método a probar
			TestConexion.consulta_insert(telefono, nombre, apellidos, direccion);

			cn = conexion.conectar();
			// Verificar que el registro se ha insertado correctamente en la base de datos
			ps = cn.prepareStatement("INSERT INTO cliente (telefono,nombre,apellidos,direccion) VALUES (?,?,?,?)");
			ResultSet resultSet = ps.executeQuery();
			assertTrue(resultSet.next());
			assertEquals(telefono, resultSet.getString("telefono"));
			assertEquals(nombre, resultSet.getString("nombre"));
			assertEquals(apellidos, resultSet.getString("apellidos"));
			assertEquals(direccion, resultSet.getString("direccion"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
