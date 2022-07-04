package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import TPE.Clinica;
import TPE.Login;
import TPE.Medico;
import TPE.Secretaria;
import TPE.Usuario;
import TPE.Read.ReadMedico;
import TPE.Read.ReadPacientes;
import TPE.Read.ReadSecretaria;
import TPE.Write.WriteCSV;
import TPE.Write.WriteMedicos;
import TPE.Write.WritePacientes;
import TPE.Write.WriteSecretarias;

public class VentanaCambiarContrasenia extends JFrame {
	
	Clinica clinica;
	String nombreUsuario;
	JTextField cajaTextoContraseniaActual;
	JTextField cajaTextoContraseniaNueva;
	JTextField cajaTextoReingresarContrasenia;
	JButton botConfirmar;
	
    public VentanaCambiarContrasenia(Clinica clinica, String nombreUsuario) {
    	this.clinica = clinica;

    	this.nombreUsuario = nombreUsuario;
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
    	
    	Medico m = clinica.getMedicoUsuario(nombreUsuario);
    	Secretaria s = clinica.getSecretariaUsuario(nombreUsuario);
    	String contraseniaActual = this.cajaTextoContraseniaActual.getText();
    	String contraseniaNueva = this.cajaTextoContraseniaNueva.getText();
    	String reingresarContrasenia = this.cajaTextoReingresarContrasenia.getText();

    	if ( !((m != null && m.esContrasenia(contraseniaActual)) || ( s != null && s.esContrasenia(contraseniaActual)))) {
    		cajaTextoContraseniaActual.setBorder(new LineBorder(Color.RED));
    		JOptionPane.showMessageDialog(null, "La contrasenia actual no coincide.");
    	} else if ( !contraseniaNueva.equals(reingresarContrasenia) ) {
    		cajaTextoReingresarContrasenia.setBorder(new LineBorder(Color.RED));
        	cajaTextoContraseniaNueva.setBorder(new LineBorder(Color.RED));
    		JOptionPane.showMessageDialog(null, "La contrasenia nueva no coincide con su reingreso.");
    	} else if ( !Login.verificarContrasenia(contraseniaNueva) ) {
    		JOptionPane.showMessageDialog(null, "La contrasenia nueva no es correcta. La contrase�a debe tener al entre 8 y 16 caracteres, al menos un d�gito, al menos una min�scula y al menos una may�scula. ");
    	} else {
    		cajaTextoContraseniaActual.setBorder(new LineBorder(Color.GREEN));
    		cajaTextoReingresarContrasenia.setBorder(new LineBorder(Color.GREEN));
        	cajaTextoContraseniaNueva.setBorder(new LineBorder(Color.GREEN));
        	
        	if ( s == null ) {
        		m.setContrasenia(contraseniaNueva);
        		ReadMedico medicos = new ReadMedico();
        		WriteCSV archivoMedicos = new WriteMedicos(this.clinica);
        		archivoMedicos.generarArchivoCSV(medicos.getCsvFile());
        	} else {
        		s.setContrasenia(contraseniaNueva);     
        		ReadSecretaria secretarias = new ReadSecretaria();
        		WriteCSV archivoSecretarias = new WriteSecretarias(this.clinica);
        		archivoSecretarias.generarArchivoCSV(secretarias.getCsvFile());
        	}
        	
        	JOptionPane.showMessageDialog(null, "Cambios guardados con exito.");
        	this.dispose();
    	}
    }
}
