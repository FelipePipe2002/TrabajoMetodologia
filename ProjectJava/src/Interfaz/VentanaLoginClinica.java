package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class VentanaLoginClinica extends JFrame {

	public VentanaLoginClinica() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
                   
    private void initComponents() {

    	FondoPanel panelLogin = new FondoPanel("/FondoLogin.jpg");
    	JLabel EtiBienvenido = new JLabel();
        JLabel EtiUsuario = new JLabel();
        JTextField CajaTextoUsuario = new JTextField();
        JButton BotonIngresar = new JButton();
        JLabel EtiDesign = new JLabel();
        JLabel EtiIngreseSuDNI1 = new JLabel();
        JPasswordField CajaTextoContraseña = new JPasswordField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));
        setResizable(false);

        panelLogin.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        panelLogin.setMaximumSize(new Dimension(1200, 800));
        panelLogin.setMinimumSize(new Dimension(800, 600));

        EtiBienvenido.setFont(new Font("Book Antiqua", 1, 48));
        EtiBienvenido.setText("Bienvenido");

        EtiUsuario.setFont(new Font("Book Antiqua", 0, 18));
        EtiUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        EtiUsuario.setText("Usuario:");

        BotonIngresar.setIcon(new ImageIcon(getClass().getResource("/BotonIngresar.png")));
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

        EtiIngreseSuDNI1.setFont(new Font("Book Antiqua", 0, 18));
        EtiIngreseSuDNI1.setHorizontalAlignment(SwingConstants.CENTER);
        EtiIngreseSuDNI1.setText("Contraseña:");

        CajaTextoContraseña.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CajaTextoContraseñaActionPerformed(evt);
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
                        .addGroup(GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                            .addComponent(EtiBienvenido, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
                            .addGap(143, 143, 143))
                        .addGroup(panelLoginLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(EtiUsuario, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EtiIngreseSuDNI1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(CajaTextoUsuario, GroupLayout.Alignment.LEADING))
                        .addComponent(CajaTextoContraseña, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addComponent(BotonIngresar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181))))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(EtiBienvenido)
                .addGap(26, 26, 26)
                .addComponent(EtiUsuario)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CajaTextoUsuario, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EtiIngreseSuDNI1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CajaTextoContraseña, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonIngresar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
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
        
        //Si esta registrado
    	VentanaLoginClinica ventanaPortalClinica = new VentanaLoginClinica();
            ventanaPortalClinica.setVisible(true);
            this.dispose();
        //Si no esta registrado
//            Registro ventanaRegistro = new Registro();
//            ventanaRegistro.setVisible(true);
//            this.dispose();
    }                                             

    private void CajaTextoContraseñaActionPerformed(ActionEvent evt) {                                                    
        
    }
}
