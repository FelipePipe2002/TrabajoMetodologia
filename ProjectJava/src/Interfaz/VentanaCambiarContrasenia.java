package Interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import TPE.Clinica;

public class VentanaCambiarContrasenia extends JFrame {
	
	Clinica clinica;
	JTextField cajaTextoContraseniaActual;
	JTextField cajaTextoContraseniaNueva;
	JTextField cajaTextoReingresarContrasenia;
	JButton botConfirmar;
	
    public VentanaCambiarContrasenia(Clinica clinica, String nombreUsuario) {
    	this.clinica = clinica;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

    	FondoPanel panelFondo = new FondoPanel("/FondoLogin1.jpg");
    	JLabel etiCambiarContrasenia = new JLabel();
    	JLabel etiContraseniaActual = new JLabel();
    	JLabel etiContraseniaNueva = new JLabel();
    	JLabel etiReingresarContrasenia = new JLabel();
    	this.cajaTextoContraseniaActual = new JTextField();
    	this.cajaTextoContraseniaNueva = new JTextField();
    	this.cajaTextoReingresarContrasenia = new JTextField();
    	this.botConfirmar = new JButton();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setResizable(false);

        etiCambiarContrasenia.setFont(new Font("Book Antiqua", 0, 24));
        etiCambiarContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
        etiCambiarContrasenia.setText("Cambiar contrasenia");

        etiContraseniaActual.setFont(new Font("Book Antiqua", 0, 14));
        etiContraseniaActual.setHorizontalAlignment(SwingConstants.CENTER);
        etiContraseniaActual.setText("Ingrese su contrasenia actual:");

        etiContraseniaNueva.setFont(new Font("Book Antiqua", 0, 14));
        etiContraseniaNueva.setHorizontalAlignment(SwingConstants.CENTER);
        etiContraseniaNueva.setText("Ingrese la contrasenia nueva:");

        etiReingresarContrasenia.setFont(new Font("Book Antiqua", 0, 14));
        etiReingresarContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
        etiReingresarContrasenia.setText("Vuelva a ingresar la contrasenia nueva:");

        botConfirmar.setIcon(new ImageIcon(getClass().getResource("/BotonRegistrar.png")));
        botConfirmar.setBorderPainted(false);
        botConfirmar.setContentAreaFilled(false);
        botConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botConfirmarActionPerformed(evt);
            }
        });

        GroupLayout panelLayout = new GroupLayout(panelFondo);
        panelFondo.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
        		panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(cajaTextoReingresarContrasenia, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiReingresarContrasenia, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(etiContraseniaNueva, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(cajaTextoContraseniaNueva, GroupLayout.Alignment.LEADING)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(etiContraseniaActual, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(cajaTextoContraseniaActual, GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(botConfirmar)
                        .addGap(140, 140, 140))
                    .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(etiCambiarContrasenia, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))))
        );
        panelLayout.setVerticalGroup(
        		panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(etiCambiarContrasenia, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etiContraseniaActual, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaTextoContraseniaActual, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiContraseniaNueva, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaTextoContraseniaNueva, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiReingresarContrasenia, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaTextoReingresarContrasenia, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botConfirmar)
                .addContainerGap(25, Short.MAX_VALUE))
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

    private void botConfirmarActionPerformed(ActionEvent evt) {                                             
    	//corroborar que contrasenia actual sea valida y corroborar que la contrasenia nueva cumpla con los caracteres minimos
    	//y que la contrasenia ingresada sea igual a la que volvio a escribir
    	
    	
    }
}
