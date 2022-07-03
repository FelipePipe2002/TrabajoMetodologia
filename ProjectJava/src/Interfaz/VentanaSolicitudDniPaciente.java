package Interfaz;

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
    }
                    
    private void initComponents() {
    	
    	JPanel panel = new JPanel();
    	JButton botBuscar = new JButton();
    	JLabel etiIngresarDNI = new JLabel();
    	JLabel etiLogo = new JLabel();
    	cajaTextoDNI = new JTextField();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setMaximumSize(new Dimension(400, 500));
        setMinimumSize(new Dimension(400, 500));
        setPreferredSize(new Dimension(400, 500));

        panel.setPreferredSize(new Dimension(400, 500));

        botBuscar.setFont(new Font("Book Antiqua", 0, 14));
        botBuscar.setText("Buscar");
        botBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botBuscarActionPerformed(evt);
            }
        });

        cajaTextoDNI.setHorizontalAlignment(JTextField.CENTER);

        etiIngresarDNI.setFont(new Font("Book Antiqua", 0, 14));
        etiIngresarDNI.setHorizontalAlignment(SwingConstants.CENTER);
        etiIngresarDNI.setText("Por favor ingrese el DNI paciente:");

        etiLogo.setIcon(new ImageIcon(getClass().getResource("/logo.png")));

        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
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
                            .addComponent(cajaTextoDNI, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
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
                .addComponent(cajaTextoDNI, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botBuscar)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }
    
    private void botBuscarActionPerformed(ActionEvent evt) {
        //buscar si existe el dni ingresado en la clinica
    	
    	String dni = this.cajaTextoDNI.getText();
        //Si esta registrado
	    if (Login.verificarDNI(dni)) {
	    	if (clinica.getPaciente(dni) != null) {
	    		//asignar turno al paciente
	    		VentanaRegistro ventanaRegistro = new VentanaRegistro(this.clinica, clinica.getPaciente(dni), turno, "Confirmar");
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