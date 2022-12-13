package negocio;

public class Indicacion {
	String direccion;
	String descripcion;
	
	
	public Indicacion(String direccion, String descripcion) {
		super();
		this.direccion = direccion;
		this.descripcion = descripcion;
	}
	public Indicacion() {
		// TODO Auto-generated constructor stub
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
