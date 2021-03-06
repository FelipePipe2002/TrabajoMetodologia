package Interfaz;

import TPE.*;
import TPE.Read.ReadPacientes;
import TPE.Read.ReadTurnos;
import TPE.Write.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaPortalPacientes extends JFrame {

	Clinica clinica;
	Paciente paciente;
	JTable tablaDeMedicos;
	DefaultTableModel modeloTablaMedicos;
	JTable tablaDeTurnos;
	DefaultTableModel modeloTablaTurnos;
	JComboBox boxObrasSociales;
	JComboBox boxEspecialidades;
	
	public VentanaPortalPacientes(Clinica clinica, String dni) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		this.clinica = clinica;
		this.paciente = clinica.getPaciente(dni);
        initComponents();
        this.setLocationRelativeTo(null);
    }
	
	private void initComponents() {
		JTabbedPane tablaPortal = new JTabbedPane();
		FondoPanel panelSacarTurno = new FondoPanel("/FondoLogin1.jpg");
		JButton botonBuscar = new JButton();
		JPanel heap1 = new JPanel();
		JLabel etiNombreClinica1 = new JLabel();
		JButton botonCerrarSesion1 = new JButton();
		JPanel pieDePagina1 = new JPanel();
		JScrollPane tablaMedicos = new JScrollPane();
		JLabel EtiEspecialidad = new JLabel();
		JLabel EtiObraSocial = new JLabel();
		FondoPanel panelVerProximosTurnos = new FondoPanel("/FondoLogin1.jpg");
        JPanel heap2 = new JPanel();
        JLabel etiNombreClinica2 = new JLabel();
        JButton botonCerrarSesion2 = new JButton();
        JPanel pieDePagina2 = new JPanel();
        JScrollPane tablaTurno = new JScrollPane();
        JButton botonCancelarTurno = new JButton();
        this.boxObrasSociales = new JComboBox(this.clinica.listarObraSocial());
        this.boxEspecialidades = new JComboBox(this.clinica.listarEspecialidades());
        this.tablaDeMedicos = new JTable();
        this.tablaDeTurnos = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(1200, 800));
        setMinimumSize(new Dimension(800, 600));

        panelSacarTurno.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        this.boxObrasSociales.setFont(new Font("Book Antiqua", 0, 14));
        this.boxEspecialidades.setFont(new Font("Book Antiqua", 0, 14));

        botonBuscar.setFont(new Font("Book Antiqua", 0, 14));
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {BotonBuscarActionPerformed(evt);}});
        
        heap1.setBackground(new Color(3, 123, 139));
        heap1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));

        etiNombreClinica1.setFont(new Font("Book Antiqua", 1, 36));
        etiNombreClinica1.setText(clinica.getNombre());

        botonCerrarSesion1.setFont(new Font("Book Antiqua", 1, 18));
        botonCerrarSesion1.setText("Cerrar Sesion >>");
        botonCerrarSesion1.setBorderPainted(false);
        botonCerrarSesion1.setContentAreaFilled(false);
        botonCerrarSesion1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonCerrarSesion1ActionPerformed(evt);
            }
        });

        GroupLayout Heap1Layout = new GroupLayout(heap1);
        heap1.setLayout(Heap1Layout);
        Heap1Layout.setHorizontalGroup(
            Heap1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(Heap1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(etiNombreClinica1, GroupLayout.PREFERRED_SIZE, 713, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonCerrarSesion1)
                .addGap(35, 35, 35))
        );
        Heap1Layout.setVerticalGroup(
            Heap1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(etiNombreClinica1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Heap1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(botonCerrarSesion1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pieDePagina1.setBackground(new Color(3, 123, 139));
        pieDePagina1.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(0, 0, 0)));

        GroupLayout PieDePagina1Layout = new GroupLayout(pieDePagina1);
        pieDePagina1.setLayout(PieDePagina1Layout);
        PieDePagina1Layout.setHorizontalGroup(
            PieDePagina1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PieDePagina1Layout.setVerticalGroup(
            PieDePagina1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 183, Short.MAX_VALUE)
        );
        //Tabla de medicos
        this.tablaDeMedicos.setFont(new Font("Book Antiqua", 0, 14));
        this.modeloTablaMedicos = new DefaultTableModel() {
        	public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.modeloTablaMedicos.addColumn("Nombre");
        this.modeloTablaMedicos.addColumn("Apellido");
        this.modeloTablaMedicos.addColumn("Dni");
        for (Medico m: this.clinica.getMedicos())
        	modeloTablaMedicos.addRow(new Object[] {m.getNombre(),m.getApellido(),m.getDni()});
        this.tablaDeMedicos.setModel(modeloTablaMedicos);
        
        this.tablaDeMedicos.setToolTipText("");
        this.tablaDeMedicos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                TablaDeMedicosMouseClicked(evt);
            }
        });
        tablaMedicos.setViewportView(this.tablaDeMedicos);
        
        EtiEspecialidad.setFont(new Font("Book Antiqua", 0, 18));
        EtiEspecialidad.setHorizontalAlignment(SwingConstants.CENTER);
        EtiEspecialidad.setText("Especialidad:");

        EtiObraSocial.setFont(new Font("Book Antiqua", 0, 18));
        EtiObraSocial.setHorizontalAlignment(SwingConstants.CENTER);
        EtiObraSocial.setText("Obra Social:");

        GroupLayout PanelSacarTurnoLayout = new GroupLayout(panelSacarTurno);
        panelSacarTurno.setLayout(PanelSacarTurnoLayout);
        PanelSacarTurnoLayout.setHorizontalGroup(
            PanelSacarTurnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, PanelSacarTurnoLayout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addGroup(PanelSacarTurnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(EtiEspecialidad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(this.boxEspecialidades, 0, 158, Short.MAX_VALUE))
                .addGap(191, 191, 191)
                .addComponent(botonBuscar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addGroup(PanelSacarTurnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(this.boxObrasSociales, 0, 158, Short.MAX_VALUE)
                    .addComponent(EtiObraSocial, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(263, 263, 263))
            .addComponent(heap1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pieDePagina1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelSacarTurnoLayout.createSequentialGroup()
                .addGap(453, 453, 453)
                .addComponent(tablaMedicos, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSacarTurnoLayout.setVerticalGroup(
            PanelSacarTurnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(PanelSacarTurnoLayout.createSequentialGroup()
                .addComponent(heap1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addGroup(PanelSacarTurnoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(EtiObraSocial, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(EtiEspecialidad, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelSacarTurnoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.boxObrasSociales, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.boxEspecialidades, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addGap(42, 42, 42)
                .addComponent(tablaMedicos, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(pieDePagina1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        tablaPortal.addTab("Sacar turno", panelSacarTurno);

        panelVerProximosTurnos.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        heap2.setBackground(new Color(3, 123, 139));
        heap2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));

        etiNombreClinica2.setFont(new Font("Book Antiqua", 1, 36));
        etiNombreClinica2.setText(this.clinica.getNombre());

        botonCerrarSesion2.setFont(new Font("Book Antiqua", 1, 18));
        botonCerrarSesion2.setText("Cerrar Sesion >>");
        botonCerrarSesion2.setBorderPainted(false);
        botonCerrarSesion2.setContentAreaFilled(false);
        botonCerrarSesion2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonCerrarSesion2ActionPerformed(evt);
            }
        });

        GroupLayout Heap2Layout = new GroupLayout(heap2);
        heap2.setLayout(Heap2Layout);
        Heap2Layout.setHorizontalGroup(
            Heap2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(Heap2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(etiNombreClinica2, GroupLayout.PREFERRED_SIZE, 713, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addComponent(botonCerrarSesion2)
                .addGap(35, 35, 35))
        );
        Heap2Layout.setVerticalGroup(
            Heap2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(etiNombreClinica2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Heap2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(botonCerrarSesion2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pieDePagina2.setBackground(new Color(3, 123, 139));
        pieDePagina2.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(0, 0, 0)));

        GroupLayout PieDePagina2Layout = new GroupLayout(pieDePagina2);
        pieDePagina2.setLayout(PieDePagina2Layout);
        PieDePagina2Layout.setHorizontalGroup(
            PieDePagina2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PieDePagina2Layout.setVerticalGroup(
            PieDePagina2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 183, Short.MAX_VALUE)
        );
        
        //Tabla de turnos
        this.tablaDeTurnos.setFont(new Font("Book Antiqua", 0, 14));
        ArrayList<Turno> turnos = new ArrayList<>();
        turnos = paciente.getTurnos();
        
        this.modeloTablaTurnos = new DefaultTableModel() {
        	public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        this.modeloTablaTurnos.addColumn("Medico");
        this.modeloTablaTurnos.addColumn("Dia");
        this.modeloTablaTurnos.addColumn("Hora");
        for (Turno t: turnos)
        	this.modeloTablaTurnos.addRow(new Object[] {t.getMedico().getNombre()+ " " + t.getMedico().getApellido(),t.getFecha().getDayOfMonth() + "/" + t.getFecha().getMonthValue() + "/" + t.getFecha().getYear(),t.getFecha().getHour() + ":" + t.getFecha().getMinute()});
        this.tablaDeTurnos.setModel(modeloTablaTurnos);
        
        this.tablaDeTurnos.setMaximumSize(new Dimension(225, 600));
        tablaTurno.setViewportView(this.tablaDeTurnos);

        botonCancelarTurno.setText("Cancelar Turno");
        botonCancelarTurno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonCancelarTurnoActionPerformed(evt);
            }
        });

        GroupLayout PanelVerProximosTurnosLayout = new GroupLayout(panelVerProximosTurnos);
        panelVerProximosTurnos.setLayout(PanelVerProximosTurnosLayout);
        PanelVerProximosTurnosLayout.setHorizontalGroup(
            PanelVerProximosTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(heap2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pieDePagina2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelVerProximosTurnosLayout.createSequentialGroup()
                .addGroup(PanelVerProximosTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(PanelVerProximosTurnosLayout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(tablaTurno, GroupLayout.PREFERRED_SIZE, 575, GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelVerProximosTurnosLayout.createSequentialGroup()
                        .addGap(580, 580, 580)
                        .addComponent(botonCancelarTurno, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelVerProximosTurnosLayout.setVerticalGroup(
            PanelVerProximosTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerProximosTurnosLayout.createSequentialGroup()
                .addComponent(heap2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(tablaTurno, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonCancelarTurno, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(pieDePagina2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        tablaPortal.addTab("Ver proximos turnos", panelVerProximosTurnos);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(tablaPortal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(tablaPortal)
        );

        pack();
    }                       

    private void botonCerrarSesion1ActionPerformed(ActionEvent evt) {                                                   
    	VentanaLogin ventanaLogin = new VentanaLogin(this.clinica);
        ventanaLogin.setVisible(true);
        this.dispose();
    }                                                  
    
    private void BotonBuscarActionPerformed(ActionEvent evt) {

    	String especialidad = this.boxEspecialidades.getSelectedItem().toString();
    	String obrasSocial = this.boxObrasSociales.getSelectedItem().toString();

    	int rowCount = this.modeloTablaMedicos.getRowCount();
    	for (int i = rowCount - 1; i >= 0; i--) {
    		this.modeloTablaMedicos.removeRow(i);
    	}
    	ArrayList<Medico> MedicosFiltrados = this.clinica.filtrarMedicos(especialidad, obrasSocial);
    	this.modeloTablaMedicos.setRowCount(0);
    	for (Medico m: MedicosFiltrados) {
    		this.modeloTablaMedicos.addRow(new Object[] {m.getNombre(),m.getApellido(),m.getDni()});
    	}
        this.tablaDeMedicos.setModel(this.modeloTablaMedicos);
    }  
    
    private void TablaDeMedicosMouseClicked(MouseEvent evt) {                                            
    	int fila = this.tablaDeMedicos.getSelectedRow();
        String dni = (String) this.tablaDeMedicos.getValueAt(fila, 2);
    	Medico medico = this.clinica.getMedico(dni);
    	VentanaTurnosMedico ventanaTurno = new VentanaTurnosMedico(this.clinica,medico,this.paciente, this);
    	ventanaTurno.setVisible(true);
    }
    
    private void botonCerrarSesion2ActionPerformed(ActionEvent evt) {                                                   
    	VentanaLogin ventanaLogin = new VentanaLogin(this.clinica);
    	ventanaLogin.setVisible(true);
    	this.dispose();
    }                                                  
    
    private void botonCancelarTurnoActionPerformed(ActionEvent evt) {                                                   
    	int fila = this.tablaDeTurnos.getSelectedRow();	
    	if (fila != -1) {
    		this.paciente.eliminarTurno(this.paciente.getTurnos().get(fila));
	    	this.modeloTablaTurnos.removeRow(fila);
	    	this.tablaDeTurnos.setModel(this.modeloTablaTurnos);
	    	ReadPacientes pacientes = new ReadPacientes();
	    	ReadTurnos turnos = new ReadTurnos();
	    	WriteCSV archivoPacientes = new WritePacientes(this.clinica);
			archivoPacientes.generarArchivoCSV(pacientes.getCsvFile());
			WriteCSV archivoTurnos = new WriteTurnos(this.clinica);
			archivoTurnos.generarArchivoCSV(turnos.getCsvFile());
			VentanaPortalPacientes ventanaPortalPacientes = new VentanaPortalPacientes(this.clinica, this.paciente.getDni());
			ventanaPortalPacientes.setVisible(true);
	    	this.dispose();
    	}
    }
}
