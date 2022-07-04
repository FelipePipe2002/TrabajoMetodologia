package Interfaz;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class FondoPanel extends JPanel {
	
	private Image imagen;
	private String direccionImg;
	
	public FondoPanel(String direccionImg) {
		this.direccionImg = direccionImg;
	}
	
	public void paint(Graphics g) {
		imagen = new ImageIcon(getClass().getResource(direccionImg)).getImage();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
}