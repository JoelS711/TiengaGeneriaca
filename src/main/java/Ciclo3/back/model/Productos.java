package Ciclo3.back.model;

public class Productos {

	Integer codigo;
	Long nitpro;
	Float ivacompra;
	String nombre;
	Float preciocompra;
	Float precioventa;
	
	
	
	public Productos() {
		super();
	}
	
	public Productos(Integer codigo, Long nitpro, Float ivacompra, String nombre, Float preciocompra,
			Float precioventa) {
		super();
		this.codigo = codigo;
		this.nitpro = nitpro;
		this.ivacompra = ivacompra;
		this.nombre = nombre;
		this.preciocompra = preciocompra;
		this.precioventa = precioventa;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Long getNitpro() {
		return nitpro;
	}
	public void setNitpro(Long nitpro) {
		this.nitpro = nitpro;
	}
	public Float getIvacompra() {
		return ivacompra;
	}
	public void setIvacompra(Float ivacompra) {
		this.ivacompra = ivacompra;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getPreciocompra() {
		return preciocompra;
	}
	public void setPreciocompra(Float preciocompra) {
		this.preciocompra = preciocompra;
	}
	public Float getPrecioventa() {
		return precioventa;
	}
	public void setPrecioventa(Float precioventa) {
		this.precioventa = precioventa;
	}

	@Override
	public String toString() {
		return "Productos [codigo=" + codigo + ", nitpro=" + nitpro + ", ivacompra=" + ivacompra + ", nombre=" + nombre
				+ ", preciocompra=" + preciocompra + ", precioventa=" + precioventa + "]";
	}
	
	
}
