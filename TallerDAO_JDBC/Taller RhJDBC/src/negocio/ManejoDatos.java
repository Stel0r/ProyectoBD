package negocio;

import java.time.LocalDate;

import datos.MensajeroDAO;
import datos.ServicioDAO;
import util.RHException;

public class ManejoDatos {
	
	private Mensajero mensajero;
	private MensajeroDAO mensajeroDAO;
	private Servicio servicio;
	private ServicioDAO servicioDAO;
	
	
	public ManejoDatos() {
		servicioDAO = new ServicioDAO();
		mensajeroDAO = new MensajeroDAO();
	}
	
	 public void incluirMensajero(long id, String tipoID, String nombres, String apellidos, LocalDate fechaNacimiento,
				long numeroCelular, String direccion, String correo, String sexo, String nSeguridadSocial,
				String placaVehiculo, String tipoVehiculo, String nacionalidad) throws RHException {
	      mensajero = new Mensajero();
	      mensajero.setId(id);
	      mensajero.setTipoID(tipoID);
	      mensajero.setNombres(nombres);
	      mensajero.setApellidos(apellidos);
	      mensajero.setFechaNacimiento(fechaNacimiento);
	      mensajero.setNumeroCelular(numeroCelular);
	      mensajero.setDireccion(direccion);
	      mensajero.setCorreo(correo);
	      mensajero.setSexo(sexo);
	      mensajero.setnSeguridadSocial(nSeguridadSocial);
	      mensajero.setPlacaVehiculo(placaVehiculo);
	      mensajero.setTipoVehiculo(tipoVehiculo);
	      mensajero.setNacionalidad(nacionalidad);
	      mensajeroDAO.incluirEmpleado(mensajero);
	    }
	 
	 public void incluirHorario(Mensajero mensajero, String dias, String HoraI,String HoraF) {
		 String[] listaDias;
		 if(dias.equals("Lunes a Viernes")) {
			 listaDias = new String[] {"Lunes","Martes","Miercoles","Jueves","Viernes"};
		 }else {
			 listaDias = new String[] {"Sabado","Domingo"};
		 }
		 try {
			mensajeroDAO.incluirHorario(mensajero, listaDias,HoraI,HoraF);
		} catch (RHException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	public Mensajero getMensajero() {
		return mensajero;
	}

	public void setMensajero(Mensajero mensajero) {
		this.mensajero = mensajero;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	 
	 

}
