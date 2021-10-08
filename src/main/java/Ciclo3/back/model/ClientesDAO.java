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
}
