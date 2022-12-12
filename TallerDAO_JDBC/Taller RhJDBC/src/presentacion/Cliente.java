package presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import negocio.ManejoDatos;
import util.RHException;

public class Cliente {
    public Cliente() {
        JFrame frame = new Ventana();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation( ( screenSize.width - frameSize.width ) / 2, ( screenSize.height - frameSize.height ) / 2 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible(true);
    }

    public static void main(String[] args) throws RHException {
		/*
		 * try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
		 * catch (Exception e) { e.printStackTrace(); } 
		 * new Cliente();
		 */
    	
    	ManejoDatos md = new ManejoDatos(); 
    	
    	String[] listaS = new String[] {"F","M"};
    	String[] listaTipoId = new String[] {"TI","CC","CE","NIP"};
    	String[] listaTipoV = new String[] {"A","B","C"};
    	String[] opcionesBool = new String[] {"SI","NO"};
    	
    	
    	long id = Long.valueOf(JOptionPane.showInputDialog(null, "introduzca su numero de identificacion", "Identificacion", 0));
    	String tipoID = (String) JOptionPane.showInputDialog(null, "introduzca el tipo de identificacion", "Identificacion", 0,null, listaTipoId,listaTipoId[0]);
    	String nombres = JOptionPane.showInputDialog(null,"introduzca sus nombres", "Nombres", 0);
    	String apellidos = JOptionPane.showInputDialog(null,"introduzca sus apellidos", "Nombres", 0);
    	String fechaNacimiento = JOptionPane.showInputDialog(null,"introduzca su fecha de nacimiento (dd/mm/yyyy)", "Nombres", 0); 
    	//manejar la introduccion de la fecha
    	
    	String[] fechaLista = fechaNacimiento.split("/");
    	LocalDate fecha = LocalDate.of(Integer.valueOf(fechaLista[2]), Integer.valueOf(fechaLista[1]), Integer.valueOf(fechaLista[0]));
   
    	
    	long numeroCelular = Long.valueOf(JOptionPane.showInputDialog(null, "introduzca su numero de celular", "Numero celular", 0));;
    	String direccion = JOptionPane.showInputDialog(null,"introduzca su Direccion de residencia", "Direccion", 0);
    	String correo = JOptionPane.showInputDialog(null,"introduzca su Correo", "Correo", 0);
    	String sexo = (String) JOptionPane.showInputDialog(null, "introduzca su Sexo", "Sexo", 0,null, listaS,listaS[0]);
    	String nSeguridadSocial = (String) JOptionPane.showInputDialog(null,"Tiene usted seguridad social ?", "Seguridad social", 0,null,opcionesBool,opcionesBool[0]);
    	String placaVehiculo = JOptionPane.showInputDialog(null,"introduzca la placa de su vehiculo", "Vehiculo", 0);
    	String tipoVehiculo = (String) JOptionPane.showInputDialog(null, "introduzca la Categoria de su Vehiculo", "Tipo Vehiculo", 0,null, listaTipoV,listaTipoV[0]);
    	String nacionalidad = JOptionPane.showInputDialog(null,"introduzca su Nacionalidad", "Nacionalidad", 0);
    	
    	md.incluirMensajero(id, tipoID, nombres, apellidos, fecha, numeroCelular, direccion, correo, sexo, nSeguridadSocial, placaVehiculo, tipoVehiculo, nacionalidad);
    }
}
