package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import negocio.Empleado;
import negocio.Mensajero;
import util.RHException;
import util.ServiceLocator;

public class MensajeroDAO {
	
	public void incluirEmpleado(Mensajero mensajero) throws RHException {
	      try {
	      
	        String strSQL = "INSERT INTO Mensajero VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	        Connection conexion = ServiceLocator.getInstance().tomarConexion();
	        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	        prepStmt.setLong(1,mensajero.getId()); 
	        prepStmt.setString(2, mensajero.getTipoID()); 
	        prepStmt.setString(3, mensajero.getNombres()); 
	        prepStmt.setString(4, mensajero.getApellidos()); 
	        prepStmt.setDate(5, java.sql.Date.valueOf(mensajero.getFechaNacimiento()));   
	        prepStmt.setLong(6, mensajero.getNumeroCelular());
	        prepStmt.setString(7, mensajero.getCorreo());
	        prepStmt.setString(8, mensajero.getSexo());
	        prepStmt.setString(9, mensajero.getnSeguridadSocial());
	        prepStmt.setString(10, mensajero.getPlacaVehiculo());
	        prepStmt.setString(11, mensajero.getTipoVehiculo());
	        prepStmt.setString(12, mensajero.getDireccion());
	        prepStmt.setString(13, mensajero.getNacionalidad());

	        prepStmt.executeUpdate();
	        prepStmt.close();
	        ServiceLocator.getInstance().commit();
	      } catch (SQLException e) {
	           ServiceLocator.getInstance().rollback();
	           throw new RHException( "EmpleadoDAO", "No pudo crear el empleado"+ e.getMessage());
	      }  finally {
	         ServiceLocator.getInstance().liberarConexion();
	      }
	      
	    }

}
