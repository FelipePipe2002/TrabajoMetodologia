package Interfaz;

import TPE.*;
import TPE.Read.*;
import TPE.Write.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class VentanaRegistro extends JFrame {
	
	Clinica clinica;
	String funcion; //Registrar o Confirmar Datos
	Turno turno;
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
	
	public VentanaRegistro(Clinica clinica, String dni, String funcion) {
        
		this.clinica = clinica;
		this.funcion = funcion;
		this.turno = null;
		this.dni = dni;
		this.cajaTextoNombre = new JTextField("");
        this.cajaTextoApellido = new JTextField("");
        this.cajaTextoCalle = new JTextField("");
        this.cajaTextoNumero = new JTextField("");
        this.cajaTextoPiso = new JTextField("");
        this.cajaTextoDepto = new JTextField("");
        this.cajaTextoTelefono = new JTextField("");
        this.cajaTextoEmail = new JTextField("");
        this.cajaTextoObraSocial = new JTextField("");
        this.cajaTextoNroAfiliado = new JTextField("");
		initComponents();
        this.setLocationRelativeTo(null);
    }
	
	public VentanaRegistro(Clinica clinica, Paciente paciente, Turno turno,String funcion) {
        
		this.clinica = clinica;
		this.funcion = funcion;
		this.turno = turno;
		this.cajaTextoNombre = new JTextField(paciente.getNombre());
        this.cajaTextoApellido = new JTextField(paciente.getApellido());
        this.dni = paciente.getDni();
        this.cajaTextoCalle = new JTextField(paciente.getDireccion().getCalle());
        this.cajaTextoNumero = new JTextField(paciente.getDireccion().getNumero());
        this.cajaTextoPiso = new JTextField(paciente.getDireccion().getPiso());
        this.cajaTextoDepto = new JTextField(paciente.getDireccion().getDepto());
        this.cajaTextoTelefono = new JTextField(paciente.getTelefono());
        this.cajaTextoEmail = new JTextField(paciente.getEmail());
        this.cajaTextoObraSocial = new JTextField(paciente.getObraSocial());
        this.cajaTextoNroAfiliado = new JTextField(paciente.getObraSocial());
		initComponents();
        this.setLocationRelativeTo(null);
    }
	
	private void initComponents() {
		FondoPanel panelRegistro = new FondoPanel("/FondoDatosPaciente.jpg");
		JLabel etiNombre = new JLabel();
        JLabel etiApellido = new JLabel();
        JLabel etiCalle = new JLabel();
        JLabel etiNumero = new JLabel();
        JLabel etiPiso = new JLabel();
        JLabel etiDepto = new JLabel();
        JLabel etiTelefono = new JLabel();
        JLabel etiEmail = new JLabel();
        JLabel etiObraSocial = new JLabel();
        JLabel etiNroAfiliado = new JLabel();
        JLabel etiRegistrar = new JLabel();
        JButton botonRegistrar = new JButton();
        JScrollPane jScrollPanel = new JScrollPane();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(1200, 800));
        setMinimumSize(new Dimension(800, 600));

        etiNombre.setFont(new Font("Book Antiqua", 0, 14));
        etiNombre.setText("Nombre:");
        etiNombre.setForeground(Color.white);
        cajaTextoNombre.setFont(new Font("Book Antiqua", 0, 12));
        
        etiApellido.setFont(new Font("Book Antiqua", 0, 14));
        etiApellido.setText("Apellido:");
        etiApellido.setForeground(Color.white);
        cajaTextoApellido.setFont(new Font("Book Antiqua", 0, 12));
        
        etiCalle.setFont(new Font("Book Antiqua", 0, 14));
        etiCalle.setText("Calle:");
        etiCalle.setForeground(Color.white);
        cajaTextoCalle.setFont(new Font("Book Antiqua", 0, 12));
        
        etiNumero.setFont(new Font("Book Antiqua", 0, 14));
        etiNumero.setText("Numero:");
        etiNumero.setForeground(Color.white);
        cajaTextoNumero.setFont(new Font("Book Antiqua", 0, 12));
        
        etiPiso.setFont(new Font("Book Antiqua", 0, 14));
        etiPiso.setText("Piso:");
        etiPiso.setForeground(Color.white);
        cajaTextoPiso.setFont(new Font("Book Antiqua", 0, 12));
        
        etiDepto.setFont(new Font("Book Antiqua", 0, 14));
        etiDepto.setText("Depto:");
        etiDepto.setForeground(Color.white);
        cajaTextoDepto.setFont(new Font("Book Antiqua", 0, 12));
        
        etiTelefono.setFont(new Font("Book Antiqua", 0, 14));
        etiTelefono.setText("Telefono:");
        etiTelefono.setForeground(Color.white);
        cajaTextoTelefono.setFont(new Font("Book Antiqua", 0, 12));
        
        etiEmail.setFont(new Font("Book Antiqua", 0, 14));
        etiEmail.setText("Email:");
        etiEmail.setForeground(Color.white);
        cajaTextoEmail.setFont(new Font("Book Antiqua", 0, 12));
        
        etiObraSocial.setFont(new Font("Book Antiqua", 0, 14));
        etiObraSocial.setText("ObraSocial:");
        etiObraSocial.setForeground(Color.white);
        cajaTextoObraSocial.setFont(new Font("Book Antiqua", 0, 12));
        
        etiNroAfiliado.setFont(new Font("Book Antiqua", 0, 14));
        etiNroAfiliado.setText("NroAfiliado:");
        etiNroAfiliado.setForeground(Color.white);
        cajaTextoNroAfiliado.setFont(new Font("Book Antiqua", 0, 12));
        
        etiRegistrar.setFont(new Font("Book Antiqua", 1, 48));
        etiRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
        etiRegistrar.setForeground(Color.white);
        if (this.funcion.equals("Registrar")) {
        	etiRegistrar.setText(this.funcion);
        	botonRegistrar.setIcon(new ImageIcon(getClass().getResource("/BotonRegistrar.png")));
        } else {
        	etiRegistrar.setText("Confirmar Datos");
        	botonRegistrar.setIcon(new ImageIcon(getClass().getResource("/BotonConfirmar.png")));
        }
        etiRegistrar.setHorizontalTextPosition(SwingConstants.CENTER);

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

        jScrollPanel.setViewportView(panelRegistro);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }                    

    private void botonRegistrarActionPerformed(ActionEvent evt) {                                               
    	
    	
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
    		if (turno == null) {
    			Paciente paciente = new Paciente(dp[0],dp[1],dp[2], new Direccion(dp[3], dp[4], dp[5], dp[6]), dp[7],dp[8],dp[9],dp[10]);
    			this.clinica.addPaciente(paciente);
    		} else {
    			Paciente paciente = clinica.getPaciente(dni);
    			paciente.setNombre(dp[0]);
    			paciente.setApellido(dp[1]);
    			paciente.setDireccion(new Direccion(dp[3], dp[4], dp[5], dp[6]));
    			paciente.setTelefono(dp[7]);
    			paciente.setEmail(dp[8]);
    			paciente.setObraSocial(dp[9]);
    			paciente.setNroAfiliado(dp[10]);
    			paciente.addTurno(turno);
    			
    			String doctor = "Dr. " + turno.getMedico().getApellido() + " " + turno.getMedico().getNombre() ;
    			String pacient = paciente.getApellido() + " " + paciente.getNombre();   
    	        DateTimeFormatter formatoFecha = DateTimeFormatter .ofPattern("EEEE dd 'de' MMMM 'de' yyyy 'a las' hh:mm:ss").withLocale(new Locale("es", "ES"));
    	        String fecha = turno.getFecha().format(formatoFecha);
    	        fecha = fecha.substring(0, 1).toUpperCase() + fecha.substring(1);

	    			SendEmail.send(paciente.getEmail(), pacient, doctor, clinica.getDireccion(), fecha);
	    			JOptionPane.showMessageDialog(null, "Turno Confirmado");
    		}
    		ReadPacientes pacientes = new ReadPacientes();
    		WriteCSV archivoPacientes = new WritePacientes(this.clinica);
    		archivoPacientes.generarArchivoCSV(pacientes.getCsvFile());
    		ReadTurnos turnos = new ReadTurnos();
    		WriteCSV archivoTurnos = new WriteTurnos(clinica);
    		archivoTurnos.generarArchivoCSV(turnos.getCsvFile());
    		VentanaPortalPacientes ventanaPortalPaciente = new VentanaPortalPacientes(this.clinica, this.dni);
            ventanaPortalPaciente.setVisible(true);
            this.dispose();
    	} else {
    		JOptionPane.showMessageDialog(null, "Los campos no son correctos");
    	}
			
    }
}
