package Interfaz;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class VentanaRegistro extends JFrame {

	public VentanaRegistro() {
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
