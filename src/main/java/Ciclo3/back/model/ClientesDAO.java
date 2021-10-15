package Ciclo3.back.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	
	public ArrayList<Clientes> listaClientes() {
		  ArrayList<Clientes> misClientes = new ArrayList<Clientes>();
		  Conexion conex= new Conexion();
		    
		  try {
		   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");
		   ResultSet res = consulta.executeQuery();
		   while(res.next()){
		    
		    Long cedula = Long.parseLong(res.getString("cedula_cliente"));
		    String nombre = res.getString("nombre_cliente");
		    String direccion = res.getString("direccion_cliente");
		    String telefono = res.getString("telefono_cliente");
		    String correo = res.getString("email_cliente");
		    Clientes persona= new Clientes(cedula, nombre, correo, direccion, telefono);
		    misClientes.add(persona);
		          }
		          res.close();
		          consulta.close();
		          con.close();
		   
		  } catch (Exception e) {
		   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
		  }
		  return misClientes;
		 }
}
