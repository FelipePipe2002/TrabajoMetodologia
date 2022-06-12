package Interfaz;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class VentanaPortalPacientes extends JFrame {

	public VentanaPortalPacientes() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
	
	private void initComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(1200, 800));
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(1200, 800));
        setResizable(false);
	}
}
