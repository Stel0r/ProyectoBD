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
        JFrame frame = new VentanaInicial();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); Dimension
		frameSize = frame.getSize(); if (frameSize.height > screenSize.height) {
		frameSize.height = screenSize.height; } if (frameSize.width >
		screenSize.width) { frameSize.width = screenSize.width; } frame.setLocation(
		( screenSize.width - frameSize.width ) / 2, ( screenSize.height -
		frameSize.height ) / 2 ); frame.setDefaultCloseOperation(
		JFrame.EXIT_ON_CLOSE ); frame.setVisible(true);
    }

    public static void main(String[] args) throws RHException {
		/*
		 * try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
		 * catch (Exception e) { e.printStackTrace(); } 
		 * 
		 */
    	
    	new Cliente();
    }
}
