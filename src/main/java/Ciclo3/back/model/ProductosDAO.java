package Ciclo3.back.model;

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
}
