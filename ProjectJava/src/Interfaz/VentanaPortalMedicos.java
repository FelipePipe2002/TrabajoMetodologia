package Interfaz;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import TPE.*;

public class VentanaPortalMedicos extends JFrame {
	
	Clinica clinica;
	Medico medico;
	
	public VentanaPortalMedicos(Clinica clinica, String nombreUsuario) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		this.clinica = clinica;
		this.medico = clinica.getMedicoUsuario(nombreUsuario);
        initComponents();
        this.setLocationRelativeTo(null);
    }
	
	private void initComponents() {
		System.out.println("Portal de Medicos");
	}
}
