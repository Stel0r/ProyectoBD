package datos;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import negocio.Servicio;
import util.RHException;
import util.ServiceLocator;

public class ServicioDAO {

	   public ServicioDAO(){
	  
	   }
	   public void crearServicio(Servicio servicio) throws RHException {
	      try {
	      
	        String strSQL = "INSERT INTO Servicio VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?,?,? )";
	                //+ "first_name, last_name, job_id, email,salary, hire_date) VALUES(?,?,?,?,?,?,?)";
	        Connection conexion = ServiceLocator.getInstance().tomarConexion();
	        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	        prepStmt.setDate(1, java.sql.Date.valueOf(servicio.getFechaServicio()));
	        prepStmt.setTime(2, java.sql.Time.valueOf(servicio.getHoraiInicio()));
	        prepStmt.setTime(3, null);
	        prepStmt.setString(4, servicio.getTipoPaquete());
	        prepStmt.setString(5, servicio.getEstado());
	        prepStmt.setBigDecimal(6, servicio.getCosto());
	        prepStmt.setString(7, servicio.isIdaYvuelta());
	        prepStmt.setInt(8, servicio.getCodigoPostal());
	        prepStmt.setLong(9, servicio.getDocumentoCliente());
	        prepStmt.setString(10, servicio.getTipoDocumentoCliente());
	        prepStmt.setLong(11, servicio.getDocumentoMensajero());
	        prepStmt.setString(12, servicio.getTipoDocumentoMensajero());
	        prepStmt.executeUpdate();
	        prepStmt.close();
	        ServiceLocator.getInstance().commit();
	      } catch (SQLException e) {
	           ServiceLocator.getInstance().rollback();
	           throw new RHException( "ServicioDAO", "No pudo crear el servicio"+ e.getMessage());
	      }  finally {
	         ServiceLocator.getInstance().liberarConexion();
	      }
	      
	    }
	       
	       
	       
	       public void modificarServicio(){
	      //implementar
	    }
	    
	    public void eliminarServicio(){
	      //implementar
	    }
	    
	    public Servicio buscarServicio(Integer id) throws RHException {
	        boolean existe = false;
	        try {
	            Servicio s = new Servicio(); //Instancia el objeto para retornar los datos del servicio
	            String strSQL = "SELECT k_idServicio, f_fechaServicio, f_horaInicio, f_horaFin, n_tipoPaquete, i_estado, v_costo, i_idaVuelta, k_codPostal, k_documentoCliente, n_tipoDeDocumentoCliente, k_documentoMensajero, n_tipoDocumentoMensajero FROM employees WHERE employee_id = ?";
	            Connection conexion = ServiceLocator.getInstance().tomarConexion();
	            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	            prepStmt.setInt(1, id);
	            ResultSet rs = prepStmt.executeQuery();
	            while (rs.next()) {
	                s.setId(rs.getInt(1));
	                s.setTipoPaquete(rs.getString(5));
	                rs.getString(3);
	                rs.getString(4);
	                rs.getString(6);
	                rs.getDate(2);
	                rs.getDouble(7);
	                rs.getBoolean(8);
	                rs.getInt(9);
	                rs.getInt(10);
	                rs.getString(11);
	                rs.getInt(12);
	                rs.getString(13);
	                
	                
	                existe = true;
	            }
	            if (existe) 
	                return s;
	             else
	                return null;
	        } catch (SQLException s) {
	            throw new RHException("ServicioDAO", s.getMessage());
	        } finally {
	            ServiceLocator.getInstance().liberarConexion();
	        }
	    }
	       
	    public int obtenerCodigoPostal(String nombreCiudad) throws RHException {
	    	try {
	            String strSQL = "SELECT k_codpostal FROM Ciudad WHERE n_nombre = ?";
	            Connection conexion = ServiceLocator.getInstance().tomarConexion();
	            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	            prepStmt.setString(1, nombreCiudad);
	            ResultSet result = prepStmt.executeQuery();
	            if(result.next()) {
	            	return result.getInt(1);
	            }else {
	            	return -1;
	            }
	            
	    	} catch (SQLException s) {
	            throw new RHException("ServicioDAO", s.getMessage());
	        } finally {
	            ServiceLocator.getInstance().liberarConexion();
	        }
	    }
		public static BigDecimal obtenerCosto(String tipoP,int codPostal) throws RHException {
			// TODO Auto-generated method stub
			try {
	            String strSQL = "SELECT t_comision,v_tarifapaquete FROM (SELECT t_comision,v_tarifapaquete,Tarifa.k_codigo,n_tipopaquete,Ciudad.k_codpostal FROM Ciudad_Tarifa,Ciudad,Tarifa WHERE Ciudad_Tarifa.k_codpostal = Ciudad.k_codpostal and Ciudad_Tarifa.k_codigo = Tarifa.k_codigo and n_tipopaquete = ? and Ciudad.k_codpostal = ?)t;";
	            Connection conexion = ServiceLocator.getInstance().tomarConexion();
	            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	            prepStmt.setString(1, tipoP);
	            prepStmt.setInt(2, codPostal);
	            ResultSet result = prepStmt.executeQuery();
	            if(result.next()) {
	            	BigDecimal valorTarifa = result.getBigDecimal(1);
	            	BigDecimal valorComision = result.getBigDecimal(2);
	            	return valorTarifa.add(valorTarifa.multiply(valorComision));
	            }else {
	            	return BigDecimal.valueOf(-1);
	            }
	            
	    	} catch (SQLException s) {
	            throw new RHException("ServicioDAO", s.getMessage());
	        } finally {
	            ServiceLocator.getInstance().liberarConexion();
	        }
		}
	    
	    
	   }