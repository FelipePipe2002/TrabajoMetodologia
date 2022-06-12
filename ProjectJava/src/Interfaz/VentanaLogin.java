package Interfaz;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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
import javax.swing.WindowConstants;

public class VentanaLogin extends JFrame {
	
    public VentanaLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void initComponents() {

    	FondoPanel panelLogin = new FondoPanel("/FondoLogin.jpg");
    	JLabel EtiBienvenido = new JLabel();
    	JLabel EtiIngreseSuDNI = new JLabel();
    	JTextField CajaTextoLogin = new JTextField();
    	JButton BotonIngresar = new JButton();
    	JLabel EtiDesign = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(1200, 800));
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(1200, 800));
        setResizable(false);

        panelLogin.setMaximumSize(new Dimension(1200, 800));
        panelLogin.setMinimumSize(new Dimension(800, 600));

        EtiBienvenido.setFont(new Font("Book Antiqua", 1, 48)); // NOI18N
        EtiBienvenido.setText("Bienvenido");

        EtiIngreseSuDNI.setFont(new Font("Book Antiqua", 0, 18)); // NOI18N
        EtiIngreseSuDNI.setText("Ingrese su DNI:");

        BotonIngresar.setIcon(new ImageIcon(getClass().getResource("/BotonIngresar.png"))); // NOI18N
        BotonIngresar.setBorderPainted(false);
        BotonIngresar.setContentAreaFilled(false);
        BotonIngresar.setPreferredSize(new Dimension(180, 40));
        BotonIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonIngresarActionPerformed(evt);
            }
        });

        EtiDesign.setFont(new Font("Book Antiqua", 0, 12)); // NOI18N
        EtiDesign.setText("Designed by the best team Scrum");

        GroupLayout panelLoginLayout = new GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap(798, Short.MAX_VALUE)
                .addGroup(panelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, panelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(EtiBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                                .addComponent(EtiIngreseSuDNI)
                                .addGap(207, 207, 207))
                            .addGroup(GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                                .addComponent(CajaTextoLogin, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
                                .addGap(143, 143, 143))))
                    .addGroup(GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addComponent(BotonIngresar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179))))
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(EtiDesign, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(EtiBienvenido)
                .addGap(60, 60, 60)
                .addComponent(EtiIngreseSuDNI)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CajaTextoLogin, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(BotonIngresar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 321, Short.MAX_VALUE)
                .addComponent(EtiDesign, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    
    private void BotonIngresarActionPerformed(ActionEvent evt) {                                              
        
        //logica para validar DNI
        
        //Si esta registrado
    		VentanaPortalPacientes ventanaPortalPaciente = new VentanaPortalPacientes();
            ventanaPortalPaciente.setVisible(true);
            this.dispose();
        //Si no esta registrado
//            VentanaRegistro ventanaRegistro = new VentanaRegistro();
//            ventanaRegistro.setVisible(true);
//            this.dispose();
    }   
}