package Interfaz;

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

	public VentanaPortalPacientes() {
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
        initComponents();
        this.setLocationRelativeTo(null);
    }
	
	private void initComponents() {
		JTabbedPane TablaPortal = new JTabbedPane();
		FondoPanel PanelSacarTurno = new FondoPanel("/FondoLogin1.jpg");
		JComboBox BoxObrasSociales = new JComboBox<>();
		JComboBox BoxEspecialidades = new JComboBox<>();
		JButton BotonBuscar = new JButton();
		JPanel Heap1 = new JPanel();
		JLabel EtiNombreClinica1 = new JLabel();
		JButton BotonCerrarSesion1 = new JButton();
		JPanel PieDePagina1 = new JPanel();
		JScrollPane TablaMedicos = new JScrollPane();
		JTable TablaDeMedicos = new JTable();
		FondoPanel PanelVerProximosTurnos = new FondoPanel("/FondoLogin1.jpg");
        JPanel Heap2 = new JPanel();
        JLabel EtiNombreClinica2 = new JLabel();
        JButton BotonCerrarSesion2 = new JButton();
        JPanel PieDePagina2 = new JPanel();
        JScrollPane TablaTurno = new JScrollPane();
        JTable TablaDeTurnos = new JTable();
        JButton BotonCancelarTurno = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(1200, 800));
        setMinimumSize(new Dimension(800, 600));

        PanelSacarTurno.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        BoxObrasSociales.setFont(new Font("Book Antiqua", 0, 14)); // NOI18N
        BoxObrasSociales.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BoxObrasSociales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BoxObrasSocialesActionPerformed(evt);
            }
        });

        BoxEspecialidades.setFont(new Font("Book Antiqua", 0, 14)); // NOI18N
        BoxEspecialidades.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BoxEspecialidades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BoxEspecialidadesActionPerformed(evt);
            }
        });

        BotonBuscar.setFont(new Font("Book Antiqua", 0, 14)); // NOI18N
        BotonBuscar.setText("Buscar");

        Heap1.setBackground(new Color(3, 123, 139));
        Heap1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));

        EtiNombreClinica1.setFont(new Font("Book Antiqua", 1, 36)); // NOI18N
        EtiNombreClinica1.setText("Nombre Clinica");

        BotonCerrarSesion1.setFont(new Font("Book Antiqua", 1, 18)); // NOI18N
        BotonCerrarSesion1.setText("Cerrar Sesion >>");
        BotonCerrarSesion1.setBorderPainted(false);
        BotonCerrarSesion1.setContentAreaFilled(false);
        BotonCerrarSesion1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonCerrarSesion1ActionPerformed(evt);
            }
        });

        GroupLayout Heap1Layout = new GroupLayout(Heap1);
        Heap1.setLayout(Heap1Layout);
        Heap1Layout.setHorizontalGroup(
            Heap1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(Heap1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(EtiNombreClinica1, GroupLayout.PREFERRED_SIZE, 713, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonCerrarSesion1)
                .addGap(35, 35, 35))
        );
        Heap1Layout.setVerticalGroup(
            Heap1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(EtiNombreClinica1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Heap1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(BotonCerrarSesion1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        PieDePagina1.setBackground(new Color(3, 123, 139));
        PieDePagina1.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(0, 0, 0)));

        GroupLayout PieDePagina1Layout = new GroupLayout(PieDePagina1);
        PieDePagina1.setLayout(PieDePagina1Layout);
        PieDePagina1Layout.setHorizontalGroup(
            PieDePagina1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PieDePagina1Layout.setVerticalGroup(
            PieDePagina1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 183, Short.MAX_VALUE)
        );

        TablaDeMedicos.setModel(new DefaultTableModel(
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
        TablaDeMedicos.setToolTipText("");
        TablaMedicos.setViewportView(TablaDeMedicos);

        GroupLayout PanelSacarTurnoLayout = new GroupLayout(PanelSacarTurno);
        PanelSacarTurno.setLayout(PanelSacarTurnoLayout);
        PanelSacarTurnoLayout.setHorizontalGroup(
            PanelSacarTurnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, PanelSacarTurnoLayout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(BoxEspecialidades, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191)
                .addComponent(BotonBuscar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(BoxObrasSociales, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
            .addComponent(Heap1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PieDePagina1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelSacarTurnoLayout.createSequentialGroup()
                .addGap(453, 453, 453)
                .addComponent(TablaMedicos, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSacarTurnoLayout.setVerticalGroup(
            PanelSacarTurnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(PanelSacarTurnoLayout.createSequentialGroup()
                .addComponent(Heap1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addGroup(PanelSacarTurnoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(BoxObrasSociales, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoxEspecialidades, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBuscar))
                .addGap(42, 42, 42)
                .addComponent(TablaMedicos, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(PieDePagina1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        TablaPortal.addTab("Sacar turno", PanelSacarTurno);

        PanelVerProximosTurnos.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        Heap2.setBackground(new Color(3, 123, 139));
        Heap2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));

        EtiNombreClinica2.setFont(new Font("Book Antiqua", 1, 36)); // NOI18N
        EtiNombreClinica2.setText("Nombre Clinica");

        BotonCerrarSesion2.setFont(new Font("Book Antiqua", 1, 18)); // NOI18N
        BotonCerrarSesion2.setText("Cerrar Sesion >>");
        BotonCerrarSesion2.setBorderPainted(false);
        BotonCerrarSesion2.setContentAreaFilled(false);
        BotonCerrarSesion2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonCerrarSesion2ActionPerformed(evt);
            }
        });

        GroupLayout Heap2Layout = new GroupLayout(Heap2);
        Heap2.setLayout(Heap2Layout);
        Heap2Layout.setHorizontalGroup(
            Heap2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(Heap2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(EtiNombreClinica2, GroupLayout.PREFERRED_SIZE, 713, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addComponent(BotonCerrarSesion2)
                .addGap(35, 35, 35))
        );
        Heap2Layout.setVerticalGroup(
            Heap2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(EtiNombreClinica2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Heap2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(BotonCerrarSesion2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        PieDePagina2.setBackground(new Color(3, 123, 139));
        PieDePagina2.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(0, 0, 0)));

        GroupLayout PieDePagina2Layout = new GroupLayout(PieDePagina2);
        PieDePagina2.setLayout(PieDePagina2Layout);
        PieDePagina2Layout.setHorizontalGroup(
            PieDePagina2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PieDePagina2Layout.setVerticalGroup(
            PieDePagina2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 183, Short.MAX_VALUE)
        );

        TablaDeTurnos.setFont(new Font("Book Antiqua", 0, 14)); // NOI18N
        TablaDeTurnos.setModel(new DefaultTableModel(
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
        TablaDeTurnos.setMaximumSize(new Dimension(225, 600));
        TablaTurno.setViewportView(TablaDeTurnos);

        BotonCancelarTurno.setText("Cancelar Turno");
        BotonCancelarTurno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonCancelarTurnoActionPerformed(evt);
            }
        });

        GroupLayout PanelVerProximosTurnosLayout = new GroupLayout(PanelVerProximosTurnos);
        PanelVerProximosTurnos.setLayout(PanelVerProximosTurnosLayout);
        PanelVerProximosTurnosLayout.setHorizontalGroup(
            PanelVerProximosTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(Heap2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PieDePagina2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelVerProximosTurnosLayout.createSequentialGroup()
                .addGroup(PanelVerProximosTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(PanelVerProximosTurnosLayout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(TablaTurno, GroupLayout.PREFERRED_SIZE, 575, GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelVerProximosTurnosLayout.createSequentialGroup()
                        .addGap(580, 580, 580)
                        .addComponent(BotonCancelarTurno, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelVerProximosTurnosLayout.setVerticalGroup(
            PanelVerProximosTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerProximosTurnosLayout.createSequentialGroup()
                .addComponent(Heap2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(TablaTurno, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonCancelarTurno, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(PieDePagina2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        TablaPortal.addTab("Ver proximos turnos", PanelVerProximosTurnos);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(TablaPortal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(TablaPortal)
        );

        pack();
    }                       

    private void BotonCerrarSesion1ActionPerformed(ActionEvent evt) {                                                   
    	VentanaLogin ventanaLogin = new VentanaLogin();
        ventanaLogin.setVisible(true);
        this.dispose();
    }                                                  

    private void BotonCerrarSesion2ActionPerformed(ActionEvent evt) {                                                   
    	VentanaLogin ventanaLogin = new VentanaLogin();
        ventanaLogin.setVisible(true);
        this.dispose();
    }                                                  

    private void BotonCancelarTurnoActionPerformed(ActionEvent evt) {                                                   
        //Debe borrar el turno seleccionado
    }                                                  

    private void BoxEspecialidadesActionPerformed(ActionEvent evt) {                                                  
        
    }                                                 

    private void BoxObrasSocialesActionPerformed(ActionEvent evt) {                                                 
        
    }
}
