package negocio;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Servicio {
	
	private Mensajero mensajero;
	private int id;
	private LocalDate fechaServicio;
	private ArrayList<Indicacion> indicaciones;
	private LocalTime horaiInicio;
	private LocalTime horaFinal;
	private String tipoPaquete;
	private String estado;
	private BigDecimal costo;
	private String idaYvuelta;
	private int codigoPostal;
	private long documentoCliente;
	private String tipoDocumentoCliente;

    public Servicio(){
        indicaciones = new ArrayList<Indicacion>();
    }

    
        
    public String getIdaYvuelta() {
		return idaYvuelta;
	}



	public void setIndicaciones(ArrayList<Indicacion> indicaciones) {
		this.indicaciones = indicaciones;
	}




	public ArrayList<Indicacion> getIndicaciones() {
		return indicaciones;
	}


	public Mensajero getMensajero() {
        return mensajero;
    }

    public int getId() {
        return id;
    }
    
    public void agregarIndicacion(Indicacion i) {
    	indicaciones.add(i);
    }

    public LocalDate getFechaServicio() {
        return fechaServicio;
    }

    public LocalTime getHoraiInicio() {
        return horaiInicio;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public String getTipoPaquete() {
        return tipoPaquete;
    }

    public String getEstado() {
        return estado;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public String isIdaYvuelta() {
        return idaYvuelta;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public long getDocumentoCliente() {
        return documentoCliente;
    }

    public String getTipoDocumentoCliente() {
        return tipoDocumentoCliente;
    }

    public long getDocumentoMensajero() {
        return mensajero.getId();
    }

    public String getTipoDocumentoMensajero() {
        return mensajero.getTipoID();
    }

    public void setMensajero(Mensajero mensajero) {
        this.mensajero = mensajero;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaServicio(LocalDate fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public void setHoraiInicio(LocalTime horaiInicio) {
        this.horaiInicio = horaiInicio;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public void setTipoPaquete(String tipoPaquete) {
        this.tipoPaquete = tipoPaquete;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public void setIdaYvuelta(String idaYvuelta) {
        this.idaYvuelta = idaYvuelta;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setDocumentoCliente(long documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public void setTipoDocumentoCliente(String tipoDocumentoCliente) {
        this.tipoDocumentoCliente = tipoDocumentoCliente;
    }

	

}
