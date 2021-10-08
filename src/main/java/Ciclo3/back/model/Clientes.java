package Ciclo3.back.model;

public class Clientes {

	Long cedula;
	String direccion;
	String correo;
	String nombre;
	String telefono;
	
	
	
	public Clientes(Long cedula, String direccion, String correo, String nombre, String telefono) {
		super();
		this.cedula = cedula;
		this.direccion = direccion;
		this.correo = correo;
		this.nombre = nombre;
		this.telefono = telefono;
		
		
	}
	public Long getCedula() {
		return cedula;
	}
	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return "Clientes [cedula=" + cedula + ", direccion=" + direccion + ", correo=" + correo + ", nombre=" + nombre
				+ ", telefono=" + telefono + "]";
	}
	
	
}
