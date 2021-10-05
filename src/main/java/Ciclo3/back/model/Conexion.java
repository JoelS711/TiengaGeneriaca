package Ciclo3.back.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
	Connection con;
	
    public Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda","root","admin");
        }catch(Exception e){
            System.err.println("Error"+e);
        }
    }
    public Connection getConnection(){
        return con;
    }
    public void close(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
