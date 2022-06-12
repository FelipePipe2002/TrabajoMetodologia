package Interfaz;

import TPE.*;
import TPE.Read.ReadPacientes;
import TPE.Write.WriteCSV;
import TPE.Write.WritePacientes;

import java.awt.Dimension;
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

public class VentanaRegistro extends JFrame {
	
	Clinica clinica;
	JTextField cajaTextoNombre;
	JTextField cajaTextoApellido;
	String dni;
	JTextField cajaTextoCalle;
	JTextField cajaTextoNumero;
	JTextField cajaTextoPiso;
	JTextField cajaTextoDepto;
	JTextField cajaTextoTelefono;
	JTextField cajaTextoEmail;
	JTextField cajaTextoObraSocial;
	JTextField cajaTextoNroAfiliado;
	
	public VentanaRegistro(Clinica clinica, String dni) {
        
		this.clinica = clinica;
		this.dni = dni;
		initComponents();
        this.setLocationRelativeTo(null);
    }
	
	private void initComponents() {
		FondoPanel panelRegistro = new FondoPanel("/FondoRegistro.jpg");
		JLabel etiNombre = new JLabel();
		this.cajaTextoNombre = new JTextField();
        JLabel etiApellido = new JLabel();
        this.cajaTextoApellido = new JTextField();
        JLabel etiCalle = new JLabel();
        this.cajaTextoCalle = new JTextField();
        JLabel etiNumero = new JLabel();
        this.cajaTextoNumero = new JTextField();
        JLabel etiPiso = new JLabel();
        this.cajaTextoPiso = new JTextField();
        JLabel etiDepto = new JLabel();
        this.cajaTextoDepto = new JTextField();
        JLabel etiTelefono = new JLabel();
        this.cajaTextoTelefono = new JTextField();
        JLabel etiEmail = new JLabel();
        this.cajaTextoEmail = new JTextField();
        JLabel etiObraSocial = new JLabel();
        this.cajaTextoObraSocial = new JTextField();
        JLabel etiNroAfiliado = new JLabel();
        this.cajaTextoNroAfiliado = new JTextField();
        JLabel etiRegistrar = new JLabel();
        JButton botonRegistrar = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(1200, 800));
        setMinimumSize(new Dimension(800, 600));

        etiNombre.setFont(new Font("Book Antiqua", 0, 14));
        etiNombre.setText("Nombre:");
        cajaTextoNombre.setFont(new Font("Book Antiqua", 0, 12));
        
        etiApellido.setFont(new Font("Book Antiqua", 0, 14));
        etiApellido.setText("Apellido:");
        cajaTextoApellido.setFont(new Font("Book Antiqua", 0, 12));
        
        etiCalle.setFont(new Font("Book Antiqua", 0, 14));
        etiCalle.setText("Calle:");
        cajaTextoCalle.setFont(new Font("Book Antiqua", 0, 12));
        
        etiNumero.setFont(new Font("Book Antiqua", 0, 14));
        etiNumero.setText("Numero:");
        cajaTextoNumero.setFont(new Font("Book Antiqua", 0, 12));
        
        etiPiso.setFont(new Font("Book Antiqua", 0, 14));
        etiPiso.setText("Piso:");
        cajaTextoPiso.setFont(new Font("Book Antiqua", 0, 12));
        
        etiDepto.setFont(new Font("Book Antiqua", 0, 14));
        etiDepto.setText("Depto:");
        cajaTextoDepto.setFont(new Font("Book Antiqua", 0, 12));
        
        etiTelefono.setFont(new Font("Book Antiqua", 0, 14));
        etiTelefono.setText("Telefono:");
        cajaTextoTelefono.setFont(new Font("Book Antiqua", 0, 12));
        
        etiEmail.setFont(new Font("Book Antiqua", 0, 14));
        etiEmail.setText("Email:");
        cajaTextoEmail.setFont(new Font("Book Antiqua", 0, 12));
        
        etiObraSocial.setFont(new Font("Book Antiqua", 0, 14));
        etiObraSocial.setText("ObraSocial:");
        cajaTextoObraSocial.setFont(new Font("Book Antiqua", 0, 12));
        
        etiNroAfiliado.setFont(new Font("Book Antiqua", 0, 14));
        etiNroAfiliado.setText("NroAfiliado:");
        cajaTextoNroAfiliado.setFont(new Font("Book Antiqua", 0, 12));
        
        etiRegistrar.setFont(new Font("Book Antiqua", 1, 48));
        etiRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
        etiRegistrar.setText("Registrar");
        etiRegistrar.setHorizontalTextPosition(SwingConstants.CENTER);

        botonRegistrar.setIcon(new ImageIcon(getClass().getResource("/BotonRegistrar.png")));
        botonRegistrar.setBorderPainted(false);
        botonRegistrar.setContentAreaFilled(false);
        botonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        GroupLayout panelRegistroLayout = new GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addContainerGap(453, Short.MAX_VALUE)
                .addGroup(panelRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                        .addComponent(botonRegistrar)
                        .addGap(485, 485, 485))
                    .addGroup(GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                        .addGroup(panelRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(cajaTextoNroAfiliado, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(etiObraSocial, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiNroAfiliado, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaTextoEmail, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(cajaTextoObraSocial, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(etiEmail, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiTelefono, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiNumero, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiCalle, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiApellido, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiNombre, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaTextoTelefono, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(cajaTextoNumero, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(cajaTextoCalle, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(cajaTextoApellido, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(cajaTextoNombre, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                                .addGroup(panelRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(cajaTextoPiso, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etiPiso, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(etiDepto, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cajaTextoDepto, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                            .addComponent(etiRegistrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(433, 433, 433))))
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(etiRegistrar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiNombre, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaTextoNombre, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiApellido, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaTextoApellido, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiCalle, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaTextoCalle, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiNumero, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaTextoNumero, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(etiDepto, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiPiso, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaTextoPiso, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaTextoDepto, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiTelefono, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaTextoTelefono, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiEmail, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaTextoEmail, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiObraSocial, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaTextoObraSocial, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiNroAfiliado, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaTextoNroAfiliado, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonRegistrar)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelRegistro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelRegistro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                    

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {                                               
    	
    	String [] dp = {"", "", "", "", "", "", "", "", "", "", ""};
    	
    	dp[0] = this.cajaTextoNombre.getText();
    	dp[1] = this.cajaTextoApellido.getText();
    	dp[2] = this.dni;
    	dp[3] = this.cajaTextoCalle.getText();
    	dp[4] = this.cajaTextoNumero.getText();
    	dp[5] = this.cajaTextoPiso.getText();
    	dp[6] = this.cajaTextoDepto.getText();
    	dp[7] = this.cajaTextoTelefono.getText();
    	dp[8] = this.cajaTextoEmail.getText();
    	dp[9] = this.cajaTextoObraSocial.getText();
    	dp[10] = this.cajaTextoNroAfiliado.getText();
    	
    	if( !Login.verificarExistencia(this.clinica, dp[2] ,dp[10]) && Login.verificarCampoNotificacion(dp[7], dp[8]) || Login.verificarCampos(dp) ) {
    		Paciente paciente = new Paciente(dp[0],dp[1],dp[2], new Direccion(dp[3], dp[4], dp[5], dp[6]), dp[7],dp[8],dp[9],dp[10]);
    		this.clinica.addPaciente(paciente);
    		ReadPacientes pacientes = new ReadPacientes();
    		WriteCSV archivoPacientes = new WritePacientes(clinica);
    		archivoPacientes.generarArchivoCSV(pacientes.getCsvFile());
    		VentanaPortalPacientes ventanaPortalPaciente = new VentanaPortalPacientes(this.clinica, this.dni);
            ventanaPortalPaciente.setVisible(true);
            this.dispose();
    	} else {
    		System.out.println("Mallllll");
    	}
			
    }
}
