package Interfaz;

import TPE.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

public class VentanaLogin extends JFrame {
	
	Clinica clinica;
	JTextField CajaTextoLogin = new JTextField();
	
    public VentanaLogin(Clinica clinica) {
        this.clinica = clinica;
    	initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void initComponents() {

    	FondoPanel panelLogin = new FondoPanel("/FondoLogin.jpg");
    	JLabel EtiBienvenido = new JLabel();
    	JLabel EtiIngreseSuDNI = new JLabel();
    	JButton BotonIngresar = new JButton();
    	JLabel EtiDesign = new JLabel();
    	JButton BotonLoginClinica = new JButton();
    	this.CajaTextoLogin = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(1300, 800));
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(1200, 800));
        setResizable(false);

        panelLogin.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        panelLogin.setMaximumSize(new Dimension(1200, 800));
        panelLogin.setMinimumSize(new Dimension(800, 600));

        EtiBienvenido.setFont(new Font("Book Antiqua", 1, 48)); // NOI18N
        EtiBienvenido.setText("Bienvenido");
        EtiBienvenido.setForeground(Color.white);

        EtiIngreseSuDNI.setFont(new Font("Book Antiqua", 0, 18)); // NOI18N
        EtiIngreseSuDNI.setText("Ingrese su DNI:");
        EtiIngreseSuDNI.setForeground(Color.white);

        BotonIngresar.setIcon(new ImageIcon(getClass().getResource("/BotonIngresar.png"))); // NOI18N
        BotonIngresar.setBorderPainted(false);
        BotonIngresar.setContentAreaFilled(false);
        BotonIngresar.setPreferredSize(new Dimension(180, 40));
        BotonIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonIngresarActionPerformed(evt);
            }
        });

        EtiDesign.setFont(new Font("Book Antiqua", 0, 12));
        EtiDesign.setText("Designed by the best team Scrum");

        BotonLoginClinica.setFont(new Font("Book Antiqua", 1, 18));
        BotonLoginClinica.setText("Log-In >>");
        BotonLoginClinica.setBorderPainted(false);
        BotonLoginClinica.setContentAreaFilled(false);
        BotonLoginClinica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonLoginClinicaActionPerformed(evt);
            }
        });
        
        GroupLayout panelLoginLayout = new GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(EtiDesign, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addContainerGap(784, Short.MAX_VALUE)
                .addGroup(panelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, panelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(EtiBienvenido, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                                .addComponent(EtiIngreseSuDNI)
                                .addGap(207, 207, 207))
                            .addGroup(GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                                .addComponent(CajaTextoLogin, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
                                .addGap(143, 143, 143))))
                    .addGroup(GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addComponent(BotonIngresar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179))
                    .addGroup(GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addComponent(BotonLoginClinica)
                        .addGap(20, 20, 20))))
        );
        
        panelLoginLayout.setVerticalGroup(
                panelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panelLoginLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(BotonLoginClinica, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    .addGap(155, 155, 155)
                    .addComponent(EtiBienvenido)
                    .addGap(60, 60, 60)
                    .addComponent(EtiIngreseSuDNI)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(CajaTextoLogin, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)
                    .addComponent(BotonIngresar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                    .addComponent(EtiDesign, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        
        pack();
    }
    
    private void BotonIngresarActionPerformed(ActionEvent evt) {                                              
        
        //logica para validar DNI
    	String dni = this.CajaTextoLogin.getText();
        //Si esta registrado
	    if (Login.verificarDNI(dni)) {
	    	if (clinica.getPaciente(dni) != null) {
	    		VentanaPortalPacientes ventanaPortalPaciente = new VentanaPortalPacientes(this.clinica, dni);
	            ventanaPortalPaciente.setVisible(true);
	            this.dispose();
	        //Si no esta registrado
	    	} else {
	    		VentanaRegistro ventanaRegistro = new VentanaRegistro(this.clinica, dni,"Registrar");
	    		ventanaRegistro.setVisible(true);
	    		this.dispose();
	    	}
	    }
    }
    
    private void BotonLoginClinicaActionPerformed(ActionEvent evt) {
    	//Login para medicos y secretarias
    	VentanaLoginClinica ventanaLoginClinica = new VentanaLoginClinica(this.clinica);
    	ventanaLoginClinica.setVisible(true);
        this.dispose();
    }
}