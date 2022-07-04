package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import TPE.Clinica;
import TPE.Login;
import TPE.Turno;

public class VentanaSolicitudDniPaciente extends JFrame {
	
	Clinica clinica;
	Turno turno;
	JTextField cajaTextoDNI;
	
    public VentanaSolicitudDniPaciente(Clinica clinica, Turno turno) {
    	this.clinica = clinica;
    	this.turno = turno;
        initComponents();
        this.setLocationRelativeTo(null);
    }
                    
    private void initComponents() {
    	
    	FondoPanel panelFondo = new FondoPanel("/FondoLogin1.jpg");
    	JButton botBuscar = new JButton();
    	JLabel etiIngresarDNI = new JLabel();
    	JLabel etiLogo = new JLabel();
    	this.cajaTextoDNI = new JTextField();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setMaximumSize(new Dimension(500, 450));
        setMinimumSize(new Dimension(500, 450));
        setPreferredSize(new Dimension(500, 450));

        panelFondo.setPreferredSize(new Dimension(500, 450));

        botBuscar.setFont(new Font("Book Antiqua", 0, 14));
        botBuscar.setText("Buscar");
        botBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botBuscarActionPerformed(evt);
            }
        });

        this.cajaTextoDNI.setHorizontalAlignment(JTextField.CENTER);

        etiIngresarDNI.setFont(new Font("Book Antiqua", 0, 14));
        etiIngresarDNI.setHorizontalAlignment(SwingConstants.CENTER);
        etiIngresarDNI.setForeground(Color.black);
        etiIngresarDNI.setText("Ingrese el DNI del paciente:");

        etiLogo.setIcon(new ImageIcon(getClass().getResource("/logo.png")));

        GroupLayout panelLayout = new GroupLayout(panelFondo);
        panelFondo.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(etiLogo))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(this.cajaTextoDNI, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiIngresarDNI, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(botBuscar)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiLogo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiIngresarDNI, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.cajaTextoDNI, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botBuscar)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    
    private void botBuscarActionPerformed(ActionEvent evt) {
        //buscar si existe el dni ingresado en la clinica
    	String dni = this.cajaTextoDNI.getText();
        //Si esta registrado
	    if (Login.verificarDNI(dni)) {
	    	if (this.clinica.getPaciente(dni) != null) {
	    		//asignar turno al paciente
	    		VentanaRegistro ventanaRegistro = new VentanaRegistro(this.clinica, this.clinica.getPaciente(dni), this.turno, "Confirmar");
		    	ventanaRegistro.setVisible(true);
	        //Si no esta registrado
	    	} else {
	    		VentanaRegistro ventanaRegistro = new VentanaRegistro(this.clinica, dni,"Secretaria");
	    		ventanaRegistro.setVisible(true);
	    		this.dispose();
	    	}
	    }
    }
}