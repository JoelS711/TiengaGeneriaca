package Ciclo3.back.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProveedoresDAO {

Conexion con = new Conexion();
	
	public Proveedores ingresarProveedor(Proveedores proveedor) {
      PreparedStatement ps = null;
      String sql = "INSERT INTO proveedores (nitproveedores, ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor) VALUES(?,?,?,?,?)";
      try {
          ps = con.getConnection().prepareStatement(sql);
          ps.setLong(1, proveedor.getNit());
          ps.setString(2, proveedor.getCiudad());
          ps.setString(3, proveedor.getDireccion());
          ps.setString(4, proveedor.getNombre());
          ps.setString(5, proveedor.getTelefono());
          ps.execute();

         
      } catch (SQLException e) {
          System.err.println(e);
          
      } finally {
          con.close();
      }
	return proveedor;
	

  }
	
	 public Proveedores actualizarProveedor(Proveedores proveedor) {
       PreparedStatement ps = null;
       String sql = "UPDATE proveedores SET ciudad_proveedor=?, direccion_proveedor=?, nombre_proveedor=?, telefono_proveedor=? WHERE nitproveedores=? ";
       try {
           ps = con.getConnection().prepareStatement(sql);
           ps.setString(1, proveedor.getCiudad());
           ps.setString(2, proveedor.getDireccion());
           ps.setString(3, proveedor.getNombre());
           ps.setString(4, proveedor.getTelefono());
           ps.setLong(5, proveedor.getNit());
           ps.execute();
           
       } catch (SQLException e) {
           System.err.println(e);
           
       } finally {
           con.close();
       }
	return proveedor;

   }
	 
   public Proveedores consultarProveedor(Proveedores proveedor) {
   PreparedStatement ps = null;
   ResultSet rs = null;
   Proveedores proveedorEnc= null;
   String sql = "SELECT * FROM proveedores WHERE nitproveedores=?";
   try {
       ps = con.getConnection().prepareStatement(sql);
       ps.setLong(1, proveedor.getNit());
       rs = ps.executeQuery();
       while (rs.next()) {
    	   	Long nit = rs.getLong("nitproveedores");
			String ciudad =  rs.getString("ciudad_proveedor");
			String direccion =  rs.getString("direccion_proveedor");
			String nombre = rs.getString("nombre_proveedor");
			String telefono = rs.getString("telefono_proveedor");
			proveedorEnc =  new Proveedores(nit, ciudad, direccion, nombre, telefono);

       }

       
   } catch (SQLException e) {
       System.err.println(e);
       
   } finally {
       con.close();

   }
return proveedorEnc;

}
   
 public Proveedores borrarProveedor(Proveedores proveedor) {
 PreparedStatement ps = null;
 String sql = "DELETE FROM proveedores WHERE nitproveedores=?";
 try {
     ps = con.getConnection().prepareStatement(sql);
     ps.setLong(1, proveedor.getNit());
     ps.execute();

    
 } catch (SQLException e) {
     System.err.println(e);
    
 } finally {
     con.close();
 }
return proveedor;

}
 
	public ArrayList<Proveedores> listaProveedores() {
		  ArrayList<Proveedores> misProveedores = new ArrayList<Proveedores>();
		  Conexion conex= new Conexion();
		    
		  try {
		   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores");
		   ResultSet res = consulta.executeQuery();
		   while(res.next()){
		    
		    Long nit = Long.parseLong(res.getString("nitproveedores"));
		    String ciudad = res.getString("ciudad_proveedor");
		    String direccion = res.getString("direccion_proveedor");
		    String nombre = res.getString("nombre_proveedor");
		    String telefono = res.getString("telefono_proveedor");
		    Proveedores persona= new Proveedores(nit, ciudad, direccion, nombre, telefono);
		    misProveedores.add(persona);
		          }
		          res.close();
		          consulta.close();
		          con.close();
		   
		  } catch (Exception e) {
		   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
		  }
		  return misProveedores;
		 }
   
   
}
