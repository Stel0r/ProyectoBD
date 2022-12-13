package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
			 listaDias = new String[] {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY"};
		 }else {
			 listaDias = new String[] {"SUNDAY","SATURDAY"};
		 }
		 try {
			mensajeroDAO.incluirHorario(mensajero, listaDias,HoraI,HoraF);
		} catch (RHException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public void crearServicio(LocalDate fechaServicio, String horaiInicio, 
             String tipoPaquete, String estado, String idaYvuelta, String Ciudad, 
             long documentoCliente, String tipoDocumentoCliente,ArrayList<Indicacion> indiaciones) throws RHException{
         servicio=new Servicio();
         servicio.setFechaServicio(fechaServicio);
         servicio.setHoraiInicio(LocalTime.now());
         servicio.setHoraFinal(null);
         //manejar tipo paquete
         if(tipoPaquete.equals("PEQUEÑO")) {
        	 servicio.setTipoPaquete("P");
         }else if (tipoPaquete.equals("MEDIANO")) {
        	 servicio.setTipoPaquete("M");
         }else {
        	 servicio.setTipoPaquete("G");
         }
         servicio.setEstado(estado);
         servicio.setIdaYvuelta(idaYvuelta);
         servicio.setCodigoPostal(servicioDAO.obtenerCodigoPostal(Ciudad));
         servicio.setCosto(ServicioDAO.obtenerCosto(servicio.getTipoPaquete(),servicio.getCodigoPostal()));
         servicio.setDocumentoCliente(documentoCliente);
         servicio.setTipoDocumentoCliente(tipoDocumentoCliente);
         servicio.setMensajero(mensajeroDAO.obtenerMensajeroServicio());
         servicio.setIndicaciones(indiaciones);
         servicioDAO.crearServicio(servicio);
         JOptionPane.showMessageDialog(null, "Su pedido se ha creado con el numero de rastreo "+servicio.getId()+" y lo realizara el Mensajero "+servicio.getMensajero().getNombres()+" Y tendra un costo total de $"+servicio.getCosto());
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
