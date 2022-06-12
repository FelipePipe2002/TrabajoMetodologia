package Interfaz;

import TPE.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaPortalPacientes extends JFrame {

	Clinica clinica;
	String dni;
	
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
		this.dni = dni;
        initComponents();
        this.setLocationRelativeTo(null);
    }
	
	private void initComponents() {
		JTabbedPane tablaPortal = new JTabbedPane();
		FondoPanel panelSacarTurno = new FondoPanel("/FondoLogin1.jpg");
		JComboBox boxObrasSociales = new JComboBox<>();
		JComboBox boxEspecialidades = new JComboBox<>();
		JButton botonBuscar = new JButton();
		JPanel heap1 = new JPanel();
		JLabel etiNombreClinica1 = new JLabel();
		JButton botonCerrarSesion1 = new JButton();
		JPanel pieDePagina1 = new JPanel();
		JScrollPane tablaMedicos = new JScrollPane();
		JTable tablaDeMedicos = new JTable();
		FondoPanel panelVerProximosTurnos = new FondoPanel("/FondoLogin1.jpg");
        JPanel heap2 = new JPanel();
        JLabel etiNombreClinica2 = new JLabel();
        JButton botonCerrarSesion2 = new JButton();
        JPanel pieDePagina2 = new JPanel();
        JScrollPane tablaTurno = new JScrollPane();
        JTable tablaDeTurnos = new JTable();
        JButton botonCancelarTurno = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(1200, 800));
        setMinimumSize(new Dimension(800, 600));

        panelSacarTurno.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        boxObrasSociales.setFont(new Font("Book Antiqua", 0, 14)); // NOI18N
        boxObrasSociales.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxObrasSociales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boxObrasSocialesActionPerformed(evt);
            }
        });

        boxEspecialidades.setFont(new Font("Book Antiqua", 0, 14)); // NOI18N
        boxEspecialidades.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxEspecialidades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boxEspecialidadesActionPerformed(evt);
            }
        });

        botonBuscar.setFont(new Font("Book Antiqua", 0, 14)); // NOI18N
        botonBuscar.setText("Buscar");

        heap1.setBackground(new Color(3, 123, 139));
        heap1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));

        etiNombreClinica1.setFont(new Font("Book Antiqua", 1, 36)); // NOI18N
        etiNombreClinica1.setText("Nombre Clinica");

        botonCerrarSesion1.setFont(new Font("Book Antiqua", 1, 18)); // NOI18N
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

        tablaDeMedicos.setModel(new DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
            },
            new String [] {
                "Medico"
            }
        ));
        tablaDeMedicos.setToolTipText("");
        tablaMedicos.setViewportView(tablaDeMedicos);

        GroupLayout PanelSacarTurnoLayout = new GroupLayout(panelSacarTurno);
        panelSacarTurno.setLayout(PanelSacarTurnoLayout);
        PanelSacarTurnoLayout.setHorizontalGroup(
            PanelSacarTurnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, PanelSacarTurnoLayout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(boxEspecialidades, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191)
                .addComponent(botonBuscar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(boxObrasSociales, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(boxObrasSociales, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxEspecialidades, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
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

        etiNombreClinica2.setFont(new Font("Book Antiqua", 1, 36)); // NOI18N
        etiNombreClinica2.setText("Nombre Clinica");

        botonCerrarSesion2.setFont(new Font("Book Antiqua", 1, 18)); // NOI18N
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

        tablaDeTurnos.setFont(new Font("Book Antiqua", 0, 14)); // NOI18N
        tablaDeTurnos.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                },
            new String [] {
                "Medico", "Dia", "Horario"
            }
        ));
        tablaDeTurnos.setMaximumSize(new Dimension(225, 600));
        tablaTurno.setViewportView(tablaDeTurnos);

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

    private void botonCerrarSesion2ActionPerformed(ActionEvent evt) {                                                   
    	VentanaLogin ventanaLogin = new VentanaLogin(this.clinica);
        ventanaLogin.setVisible(true);
        this.dispose();
    }                                                  

    private void botonCancelarTurnoActionPerformed(ActionEvent evt) {                                                   
        //Debe borrar el turno seleccionado
    }                                                  

    private void boxEspecialidadesActionPerformed(ActionEvent evt) {                                                  
        
    }                                                 

    private void boxObrasSocialesActionPerformed(ActionEvent evt) {                                                 
        
    }
}
