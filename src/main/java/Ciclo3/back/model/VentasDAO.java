package Ciclo3.back.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class VentasDAO {

	Conexion con = new Conexion();

	public Ventas validar(Ventas ven) {
		Ventas ventaEnc = null;
		PreparedStatement ps = null;
		Ventas ventaRet = null;
		ResultSet rs = null;
//configurar segun sea necesario el sql
		String sql = "SELECT * FROM ventas us WHERE codigo_venta like ?";
		try {
			ps = con.getConnection().prepareStatement(sql);
			ps.setLong(1, ven.getCodigo());
			rs = ps.executeQuery();
			while (rs.next()) {
				Long codigo = rs.getLong("codigo_venta");
				Long cedulaUsuario = rs.getLong("usuarios_cedula_usuario");
				Long cedulaCliente = rs.getLong("clientes_cedula_cliente");
				Long iva = rs.getLong("ivaventa");
				Long totalVenta = rs.getLong("total_venta");
				Long totalValor = rs.getLong("valor_venta");
				ventaEnc = new Ventas(codigo, cedulaUsuario, cedulaCliente, iva, totalVenta, totalValor);
			}
			if (ventaEnc != null) {
				if (ventaEnc.getCodigo().equals(ven.getCodigo())) {
					ventaRet = ventaEnc;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return ventaRet;
	}
	public Ventas ingresarVenta(Ventas venta) {
		PreparedStatement ps = null;
		String sql = "INSERT INTO ventas (codigo_venta, usuarios_cedula_usuario, clientes_cedula_cliente, ivaventa, total_venta, valor_venta) VALUES(?,?,?,?,?,?)";
		try {
			ps = con.getConnection().prepareStatement(sql);
			ps.setLong(1, venta.getCodigo());
			ps.setLong(2, venta.getCedula_usuario());
			ps.setLong(3, venta.getCedula_cliente());
			ps.setFloat(4, venta.getIva());
			ps.setFloat(5, venta.getTotal_venta());
			ps.setFloat(6, venta.getValor_venta());
			ps.execute();

		} catch (SQLException e) {
			System.err.println(e);

		} finally {
			con.close();
		}
		return venta;

	}
	
	public ArrayList<Reportes> listarVentas() {
		  ArrayList<Reportes> misReportes = new ArrayList<Reportes>();
		  Conexion conex= new Conexion();
		  

		try {
		   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT c.cedula_cliente, c.nombre_cliente, SUM(v.total_venta) FROM clientes c INNER JOIN ventas v ON c.cedula_cliente = v.clientes_cedula_cliente GROUP BY v.clientes_cedula_cliente");
		   ResultSet res = consulta.executeQuery();
		   while(res.next()){
			   Long cedula_cli = Long.parseLong(res.getString("cedula_cliente"));
			   String nombre = res.getString("nombre_cliente");
			   Float totalventas = Float.parseFloat(res.getString("SUM(v.total_venta)"));
			   Reportes report = new Reportes(cedula_cli, nombre, totalventas);
		    misReportes.add(report);
		          }
		          res.close();
		          consulta.close();
		          con.close();
		   
		  } catch (Exception e) {
			  System.out.print(e);
		  }
		return misReportes;
		
		 }
	

}