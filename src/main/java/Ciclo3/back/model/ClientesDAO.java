package Ciclo3.back.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientesDAO {

	Conexion con = new Conexion();
	
	public Clientes actualizarCliente(Clientes cliente) {
	       PreparedStatement ps = null;
	       String sql = "UPDATE clientes SET direccion_cliente=?, email_cliente=?, nombre_cliente=?, telefono_cliente=? WHERE cedula_cliente=?";
	       try {
	           ps = con.getConnection().prepareStatement(sql);
	           ps.setString(1, cliente.getDireccion());
	           ps.setString(2, cliente.getCorreo());
	           ps.setString(3, cliente.getNombre());
	           ps.setString(4, cliente.getTelefono());
	           ps.setLong(5, cliente.getCedula());
	           ps.execute();
	           
	       } catch (SQLException e) {
	           System.err.println(e);
	           
	       } finally {
	           con.close();
	       }
		return cliente;
		

	   }
	public Clientes borrarCliente(Clientes cli) {
		PreparedStatement ps = null;
		String sql = "DELETE FROM clientes WHERE cedula_cliente=?";
		try {
			ps = con.getConnection().prepareStatement(sql);
			ps.setLong(1,cli.getCedula());
			ps.execute();

		} catch (SQLException e) {
			System.err.println(e);

		} finally {
			con.close();
		}
		return cli;

	}
	public Clientes consultarCliente(Clientes cliente) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Clientes clienteEnc = null;
		String sql = "SELECT * FROM clientes WHERE cedula_cliente=?";
		try {
			ps = con.getConnection().prepareStatement(sql);
			ps.setLong(1, cliente.getCedula());
			rs = ps.executeQuery();
			while (rs.next()) {
				Long cedula = rs.getLong("cedula_cliente");
				String direccion = rs.getString("direccion_cliente");
				String correo = rs.getString("email_cliente");
				String nombre = rs.getString("nombre_cliente");
				String telefono = rs.getString("telefono_cliente");
				clienteEnc = new Clientes(cedula, direccion, correo, nombre, telefono);

			}

		} catch (SQLException e) {
			System.err.println(e);

		} finally {
			con.close();

		}
		return clienteEnc;

	}
}
