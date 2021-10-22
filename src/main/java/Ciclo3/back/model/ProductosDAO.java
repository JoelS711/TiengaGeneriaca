package Ciclo3.back.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductosDAO {

	public void eliminarProductos() {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("DELETE FROM productos");

			estatuto.close();
			conex.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void unSafeUpdate() {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("SET SQL_SAFE_UPDATES = 0;");

			estatuto.close();
			conex.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public void safeUpdate() {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("SET SQL_SAFE_UPDATES = 1;");

			estatuto.close();
			conex.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public Productos registrarProducto(Productos p) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO productos VALUES ('" + p.getCodigo() + "', '" + p.getNitpro()
					+ "','" + p.getIvacompra() + "', '" + p.getNombre()  + "', '" + p.getPreciocompra()  + "', '" + p.getPrecioventa() + "');");

			estatuto.close();
			conex.close();

		} catch (SQLException e) {
			p = null;
			System.out.println(e.getMessage());
		}
		return p;
	}
	public Productos consultarProducto(Productos prod) {
		Conexion conex = new Conexion();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Productos ProdEnc = null;
		String sql = "SELECT * FROM productos WHERE codigo_producto=?";
		try {
			ps = conex.getConnection().prepareStatement(sql);
			ps.setLong(1, prod.getCodigo());
			rs = ps.executeQuery();
			while (rs.next()) {
				Integer codigo = rs.getInt("codigo_producto");
				Long proveedor = rs.getLong("proveedores_nitproveedores");
				Float iva = rs.getFloat("ivacompra");
				String nombre = rs.getString("nombre_produto"); //nombre de la columna se encuentra asi en la base de datos
				Float pcompra = rs.getFloat("precio_compra");
				Float pventa = rs.getFloat("precio_venta");
				ProdEnc = new Productos (codigo, proveedor, iva, nombre, pcompra,pventa);

			}

		} catch (SQLException e) {
			System.err.println(e);

		} finally {
			conex.close();

		}
		return ProdEnc;

	}
}
