package Ciclo3.back.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class UsuariosDAO {
	
	Conexion con = new Conexion();
	
	public Usuarios validar(Usuarios usr) {
		Usuarios usuarioEnc = null;
		PreparedStatement ps = null;
		Usuarios usuarioRet = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM usuarios us WHERE usuario like ?";
		try {
			ps =  con.getConnection().prepareStatement(sql);
			ps.setString(1, usr.getUsuario());
			rs =  ps.executeQuery();
			while(rs.next()) {
				Long cedula = rs.getLong("cedula_usuario");
				String nombre =  rs.getString("nombre_usuario");
				String correo =  rs.getString("email_usuario");
				String usuario = rs.getString("usuario");
				String contrasena = rs.getString("password_2");
				usuarioEnc =  new Usuarios(cedula, nombre, correo, usuario, contrasena );
			}
			if(usuarioEnc != null) {
			if(usuarioEnc.getContrasena().equals(usr.getContrasena())) {
				usuarioRet = usuarioEnc;
			}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			con.close();
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return usuarioRet;
	}
	
	
//	public Usuarios validar(Usuarios usr) {
//        PreparedStatement ps;
//        ResultSet rs;
//        Usuarios usuarioEnc = null;
//        String sql = "SELECT * FROM usuarios WHERE usuario=? and password_2=?";
//        try {
//            ps = con.getConnection().prepareStatement(sql);
//            ps.setString(1, usr.getUsuario());
//            ps.setString(2, usr.getContraseña());
//            rs = ps.executeQuery();
//            while (rs.next()) {
//            	Long cedula = rs.getLong("cedula_usuario");
//				String nombre =  rs.getString("nombre_usuario");
//				String correo =  rs.getString("email_usuario");
//                String usuario = rs.getString("usuario");
//                String contrasena = rs.getString("password_2");
//                usuarioEnc =  new Usuarios(cedula, nombre, correo, usuario, contrasena );
//
//            }
//
//         
//        } catch (SQLException e) {
//            System.err.println(e);
//            
//        } finally {
//         con.close();
//      }
//		return usuarioEnc;
//    }
	
	
	
	public Usuarios ingresarUsuario(Usuarios usuario) {
      PreparedStatement ps = null;
      String sql = "INSERT INTO usuarios (cedula_usuario, nombre_usuario, email_usuario, usuario, password_2) VALUES(?,?,?,?,?)";
      try {
          ps = con.getConnection().prepareStatement(sql);
          ps.setLong(1, usuario.getCedula());
          ps.setString(2, usuario.getNombre());
          ps.setString(3, usuario.getCorreo());
          ps.setString(4, usuario.getUsuario());
          ps.setString(5, usuario.getContrasena());
          ps.execute();

         
      } catch (SQLException e) {
          System.err.println(e);
          
      } finally {
          con.close();
      }
	return usuario;
	

  }
	
	 public Usuarios actualizarUsuario(Usuarios usuario) {
       PreparedStatement ps = null;
       String sql = "UPDATE usuarios SET nombre_usuario=?, email_usuario=?, usuario=?, password_2=? WHERE cedula_usuario=?";
       try {
           ps = con.getConnection().prepareStatement(sql);
           ps.setString(1, usuario.getNombre());
           ps.setString(2, usuario.getCorreo());
           ps.setString(3, usuario.getUsuario());
           ps.setString(4, usuario.getContrasena());
           ps.setLong(5, usuario.getCedula());
           ps.execute();
           
       } catch (SQLException e) {
           System.err.println(e);
           
       } finally {
           con.close();
       }
	return usuario;

   }
	 
   public Usuarios consultarUsuario(Usuarios usuario) {
   PreparedStatement ps = null;
   ResultSet rs = null;
   String sql = "SELECT * FROM usuarios WHERE cedula_usuario=?";
   try {
       ps = con.getConnection().prepareStatement(sql);
       ps.setLong(1, usuario.getCedula());
       rs = ps.executeQuery();
       while (rs.next()) {
           usuario.setNombre(rs.getString("nombre_usuario"));
           usuario.setCorreo(rs.getString("email_usuario"));
           usuario.setUsuario(rs.getString("usuario"));
           usuario.setContrasena(rs.getString("password_2"));

       }

       
   } catch (SQLException e) {
       System.err.println(e);
       
   } finally {
       con.close();

   }
return usuario;

}
   
 public boolean borrarUsuario(Usuarios usuario) {
 PreparedStatement ps = null;
 String sql = "DELETE FROM usuarios WHERE cedula_usuario=?";
 try {
     ps = con.getConnection().prepareStatement(sql);
     ps.setLong(1, usuario.getCedula());
     ps.execute();

     return true;
 } catch (SQLException e) {
     System.err.println(e);
     return false;
 } finally {
     con.close();
 }

}
 
	public ArrayList<Usuarios> listaUsuarios() {
		  ArrayList<Usuarios> misUsuarios = new ArrayList<Usuarios>();
		  Conexion conex= new Conexion();
		    
		  try {
		   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
		   ResultSet res = consulta.executeQuery();
		   while(res.next()){
		    
		    Long cedula = Long.parseLong(res.getString("cedula_usuario"));
		    String nombre = res.getString("nombre_usuario");
		    String correo = res.getString("email_usuario");
		    String usuario = res.getString("usuario");
		    String contrasena = res.getString("password_2");
		    Usuarios persona= new Usuarios(cedula, nombre, correo, usuario, contrasena);
		    misUsuarios.add(persona);
		          }
		          res.close();
		          consulta.close();
		          con.close();
		   
		  } catch (Exception e) {
		   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
		  }
		  return misUsuarios;
		 }
   
}
