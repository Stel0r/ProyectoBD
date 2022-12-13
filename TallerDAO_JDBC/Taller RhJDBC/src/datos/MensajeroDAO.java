package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

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

	public void incluirHorario(Mensajero mensajero, String[] dias, String horaI, String horaF) throws RHException {
		for(int i = 0; i< dias.length;i++) {
			try { 
				String strSQL = "INSERT INTO Horario VALUES(DEFAULT,?,?,?,?,?)";
		        Connection conexion = ServiceLocator.getInstance().tomarConexion();
		        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
		        prepStmt.setString(1,dias[i]);
		        String[] listaHoraI = horaI.split(":");
		        prepStmt.setTime(2, Time.valueOf(LocalTime.of(Integer.valueOf(listaHoraI[0]), Integer.valueOf(listaHoraI[1]))));
		        String[] listaHoraF = horaF.split(":");
		        prepStmt.setTime(3, Time.valueOf(LocalTime.of(Integer.valueOf(listaHoraF[0]), Integer.valueOf(listaHoraF[1]))));
		        prepStmt.setLong(4, mensajero.getId());
		        prepStmt.setString(5, mensajero.getTipoID());
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

	public Mensajero obtenerMensajeroServicio() throws RHException {
		Mensajero mensajero = new Mensajero();
		try { 
			String strSQL = "SELECT k_documentomensajero,n_tipodocumentomensajero,n_nombres,n_apellidos,f_fechadenacimiento,k_numerodetelefono,o_correo,n_sexo,n_seguridadsocial,n_placavehiculo,i_tipovehiculo from (SELECT Mensajero.k_documentomensajero,Mensajero.n_tipodocumentomensajero,n_nombres,n_apellidos,f_fechadenacimiento,k_numerodetelefono,o_correo,n_sexo,n_seguridadsocial,n_placavehiculo,i_tipovehiculo, n_dia,f_horainicio,f_horafin FROM Mensajero,Horario where Mensajero.k_documentomensajero = Horario.k_documentomensajero and Mensajero.n_tipodocumentomensajero = Horario.n_tipodocumentomensajero and n_dia = ?)t;";
	        String hoy = LocalDate.now().getDayOfWeek().toString();
			Connection conexion = ServiceLocator.getInstance().tomarConexion();
	        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	        prepStmt.setString(1, hoy);
	        ResultSet rs = prepStmt.executeQuery();
	        if(rs.next()) {
	        	mensajero.setId(rs.getLong(1));
	        	mensajero.setTipoID(rs.getString(2));
	        	mensajero.setNombres(rs.getString(3));
	        	mensajero.setApellidos(rs.getString(4));
	        	mensajero.setFechaNacimiento(rs.getDate(5).toLocalDate());
	        	mensajero.setNumeroCelular(rs.getLong(6));
	        	mensajero.setCorreo(rs.getString(7));
	        	mensajero.setSexo(rs.getString(8));
	        	mensajero.setnSeguridadSocial(rs.getString(9));
	        	mensajero.setPlacaVehiculo(rs.getString(10));
	        	mensajero.setTipoVehiculo(rs.getString(11));
	        	return mensajero;
	        }else {
	        	return null;
	        }
	        
		} catch (SQLException e) {
	         ServiceLocator.getInstance().rollback();
	         throw new RHException( "EmpleadoDAO", "No pudo crear el empleado"+ e.getMessage());
	    }  finally {
	       ServiceLocator.getInstance().liberarConexion();
	    }
		
		
	}

}
