package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import TPE.*;

public class VentanaPortalSecretarias extends JFrame {
	
	Clinica clinica;
	Secretaria secretaria;
	JCheckBox jCheckBox1;
    JCheckBox jCheckBox2;
    JCheckBox jCheckBox3;
    JCheckBox jCheckBox4;
    JCheckBox jCheckBox5;
    JCheckBox jCheckBox6;
    JCheckBox jCheckBox7;

	public VentanaPortalSecretarias(Clinica clinica, String nombreUsuario) {
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
		this.secretaria = clinica.getSecretariaUsuario(nombreUsuario);
        initComponents();
        this.setLocationRelativeTo(null);
    }
	
    private void initComponents() {

    	JTabbedPane TablaPortal = new JTabbedPane();
    	FondoPanel panelAsignarHorarios = new FondoPanel("/FondoLogin1.jpg");
    	JButton botVerHorarios = new JButton();
    	JPanel Heap1 = new JPanel();
    	JLabel EtiNombreClinica1 = new JLabel();
    	JButton BotonCerrarSesion1 = new JButton();
    	JPanel PieDePagina1 = new JPanel();
    	JScrollPane TablaMedicos = new JScrollPane();
    	JTable TablaDeMedicos = new JTable();
    	JTextField jTextField1 = new JTextField();
        JLabel jLabel1 = new JLabel();
        JPanel jPanel1 = new JPanel();
        JCheckBox jCheckBox1 = new JCheckBox();
        JCheckBox jCheckBox2 = new JCheckBox();
        JCheckBox jCheckBox3 = new JCheckBox();
        JCheckBox jCheckBox4 = new JCheckBox();
        JCheckBox jCheckBox5 = new JCheckBox();
        JCheckBox jCheckBox6 = new JCheckBox();
        JCheckBox jCheckBox7 = new JCheckBox();
        JLabel etiHoraInicio = new JLabel();
        JTextField cajaTextoHoraCierre = new JTextField();
        JLabel etiHoraCierre = new JLabel();
        JTextField cajaTextoHoraInicio = new JTextField();
        JButton botAsignarHorario = new JButton();
        JLabel etiDuracionTurno = new JLabel();
        JTextField cajaTextoDuracionTurno = new JTextField();
        FondoPanel panelAdministrarTurnosMedicos = new FondoPanel("/FondoLogin1.jpg");
        JPanel Heap2 = new JPanel();
        JLabel EtiNombreClinica2 = new JLabel();
        JButton BotonCerrarSesion2 = new JButton();
        JPanel PieDePagina2 = new JPanel();
        JLabel etiDesde = new JLabel();
        JTextField cajaTextoFechaDesde = new JTextField();
        JLabel etiHasta = new JLabel();
        JTextField cajaTextoFechaHasta = new JTextField();
        JRadioButton radioBotManiana = new JRadioButton();
        JRadioButton radioBotTarde = new JRadioButton();
        JButton botFiltrar = new JButton();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTable tablaTurno = new JTable();
        JLabel etiNombre = new JLabel();
        JTextField cajaTextoNombre = new JTextField();
        JButton botAsignarTurno = new JButton();
        JButton botReagendarTurno = new JButton();
        JButton botCancelarTurno = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));

        panelAsignarHorarios.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        botVerHorarios.setFont(new Font("Book Antiqua", 0, 14));
        botVerHorarios.setText("Ver Horarios");
        botVerHorarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botVerHorariosActionPerformed(evt);
            }
        });

        Heap1.setBackground(new Color(3, 123, 139));
        Heap1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));

        EtiNombreClinica1.setFont(new Font("Book Antiqua", 1, 36));
        EtiNombreClinica1.setText("Nombre Clinica");

        BotonCerrarSesion1.setFont(new Font("Book Antiqua", 1, 18));
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
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 349, Short.MAX_VALUE)
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
                {null},
                {null}
            },
            new String [] {
                "Medico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaDeMedicos.setToolTipText("");
        TablaMedicos.setViewportView(TablaDeMedicos);

        jLabel1.setFont(new Font("Book Antiqua", 0, 18));
        jLabel1.setText("Nombre:");

        jPanel1.setBackground(new Color(3, 123, 139));
        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Medico", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Book Antiqua", 0, 36)));

        jCheckBox1.setFont(new Font("Book Antiqua", 0, 14));
        jCheckBox1.setText("Lunes");

        jCheckBox2.setFont(new Font("Book Antiqua", 0, 14));
        jCheckBox2.setText("Martes");

        jCheckBox3.setFont(new Font("Book Antiqua", 0, 14));
        jCheckBox3.setText("Miercoles");

        jCheckBox4.setFont(new Font("Book Antiqua", 0, 14));
        jCheckBox4.setText("Jueves");

        jCheckBox5.setFont(new Font("Book Antiqua", 0, 14));
        jCheckBox5.setText("Viernes");
        
        jCheckBox6.setFont(new Font("Book Antiqua", 0, 14));
        jCheckBox6.setText("Sabado");

        jCheckBox7.setFont(new Font("Book Antiqua", 0, 14));
        jCheckBox7.setText("Domingo");
        
        etiHoraInicio.setFont(new Font("Book Antiqua", 0, 14));
        etiHoraInicio.setHorizontalAlignment(SwingConstants.CENTER);
        etiHoraInicio.setText("Hora de inicio:");

        cajaTextoHoraCierre.setHorizontalAlignment(JTextField.CENTER);

        etiHoraCierre.setFont(new Font("Book Antiqua", 0, 14));
        etiHoraCierre.setHorizontalAlignment(SwingConstants.CENTER);
        etiHoraCierre.setText("Hora de cierre:");

        cajaTextoHoraInicio.setHorizontalAlignment(JTextField.CENTER);

        botAsignarHorario.setFont(new Font("Book Antiqua", 0, 18));
        botAsignarHorario.setText("Asignar horario");
        botAsignarHorario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	botAsignarHorarioActionPerformed(evt);
            }
        });
        
        etiDuracionTurno.setFont(new Font("Book Antiqua", 0, 14));
        etiDuracionTurno.setHorizontalAlignment(SwingConstants.CENTER);
        etiDuracionTurno.setText("Duracion Turnos:");

        cajaTextoDuracionTurno.setHorizontalAlignment(JTextField.CENTER);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox2, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox3, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox4, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox5, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
                                .addGap(110, 110, 110)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(etiHoraInicio, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cajaTextoHoraInicio, GroupLayout.Alignment.LEADING)
                                        .addComponent(etiHoraCierre, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                    .addComponent(etiDuracionTurno, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox6, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox7, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
                                .addGap(142, 142, 142)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(cajaTextoHoraCierre)
                                    .addComponent(cajaTextoDuracionTurno)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(botAsignarHorario, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jCheckBox1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox5, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox7, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(etiHoraInicio)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaTextoHoraInicio, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(etiHoraCierre)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaTextoHoraCierre, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(etiDuracionTurno)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaTextoDuracionTurno, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(40, 40, 40)
                .addComponent(botAsignarHorario, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        GroupLayout panelAsignarHorariosLayout = new GroupLayout(panelAsignarHorarios);
        panelAsignarHorarios.setLayout(panelAsignarHorariosLayout);
        panelAsignarHorariosLayout.setHorizontalGroup(
            panelAsignarHorariosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(Heap1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PieDePagina1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelAsignarHorariosLayout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addGroup(panelAsignarHorariosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TablaMedicos, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAsignarHorariosLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(botVerHorarios, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        panelAsignarHorariosLayout.setVerticalGroup(
            panelAsignarHorariosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelAsignarHorariosLayout.createSequentialGroup()
                .addComponent(Heap1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(panelAsignarHorariosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelAsignarHorariosLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(TablaMedicos, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botVerHorarios)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panelAsignarHorariosLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)))
                .addComponent(PieDePagina1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        TablaPortal.addTab("Asignar Horarios", panelAsignarHorarios);

        panelAdministrarTurnosMedicos.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Heap2.setBackground(new Color(3, 123, 139));
        Heap2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));

        EtiNombreClinica2.setFont(new Font("Book Antiqua", 1, 36));
        EtiNombreClinica2.setText("Nombre Clinica");

        BotonCerrarSesion2.setFont(new Font("Book Antiqua", 1, 18));
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
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 349, Short.MAX_VALUE)
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
        PieDePagina2.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));

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

        etiDesde.setFont(new Font("Book Antiqua", 0, 14));
        etiDesde.setHorizontalAlignment(SwingConstants.RIGHT);
        etiDesde.setText("Desde:");

        cajaTextoFechaDesde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cajaTextoFechaDesdeActionPerformed(evt);
            }
        });

        etiHasta.setFont(new Font("Book Antiqua", 0, 14));
        etiHasta.setHorizontalAlignment(SwingConstants.RIGHT);
        etiHasta.setText("Hasta:");

        cajaTextoFechaHasta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cajaTextoFechaHastaActionPerformed(evt);
            }
        });

        radioBotManiana.setText("Mañana");
        radioBotTarde.setText("Tarde");

        botFiltrar.setText("Filtrar");
        botFiltrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botFiltrarActionPerformed(evt);
            }
        });

        tablaTurno.setModel(new DefaultTableModel(
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
                {null, null, null}
            },
            new String [] {
                "Medico", "Dia", "Horario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTurno.setMaximumSize(new Dimension(225, 600));
        tablaTurno.setMinimumSize(new Dimension(100, 300));
        tablaTurno.setPreferredSize(new Dimension(225, 600));
        tablaTurno.setShowGrid(false);
        jScrollPane1.setViewportView(tablaTurno);

        etiNombre.setFont(new Font("Book Antiqua", 0, 18));
        etiNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        etiNombre.setText("Nombre:");

        botAsignarTurno.setFont(new Font("Book Antiqua", 0, 18));
        botAsignarTurno.setText("Asignar turno");
        botAsignarTurno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botAsignarTurnoActionPerformed(evt);
            }
        });

        botReagendarTurno.setFont(new Font("Book Antiqua", 0, 18));
        botReagendarTurno.setText("Reagendar turno");
        botReagendarTurno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botReagendarTurnoActionPerformed(evt);
            }
        });

        botCancelarTurno.setFont(new Font("Book Antiqua", 0, 18));
        botCancelarTurno.setText("Cancelar turno");
        botCancelarTurno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botCancelarTurnoActionPerformed(evt);
            }
        });

        GroupLayout panelAdministrarTurnosMedicosLayout = new GroupLayout(panelAdministrarTurnosMedicos);
        panelAdministrarTurnosMedicos.setLayout(panelAdministrarTurnosMedicosLayout);
        panelAdministrarTurnosMedicosLayout.setHorizontalGroup(
            panelAdministrarTurnosMedicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(Heap2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PieDePagina2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelAdministrarTurnosMedicosLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etiNombre, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cajaTextoNombre, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelAdministrarTurnosMedicosLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAdministrarTurnosMedicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, panelAdministrarTurnosMedicosLayout.createSequentialGroup()
                        .addGroup(panelAdministrarTurnosMedicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(etiDesde, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etiHasta, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAdministrarTurnosMedicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(cajaTextoFechaDesde, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaTextoFechaHasta, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(panelAdministrarTurnosMedicosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(radioBotManiana, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioBotTarde, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botFiltrar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                        .addGap(405, 405, 405))
                    .addGroup(GroupLayout.Alignment.TRAILING, panelAdministrarTurnosMedicosLayout.createSequentialGroup()
                        .addGroup(panelAdministrarTurnosMedicosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, panelAdministrarTurnosMedicosLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(botAsignarTurno, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(botReagendarTurno, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(botCancelarTurno, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE))
                        .addGap(347, 347, 347))))
        );
        panelAdministrarTurnosMedicosLayout.setVerticalGroup(
            panelAdministrarTurnosMedicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelAdministrarTurnosMedicosLayout.createSequentialGroup()
                .addComponent(Heap2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(panelAdministrarTurnosMedicosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaTextoNombre, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
                .addGroup(panelAdministrarTurnosMedicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelAdministrarTurnosMedicosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelAdministrarTurnosMedicosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaTextoFechaDesde)
                            .addComponent(etiDesde, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioBotManiana))
                        .addGap(18, 18, 18)
                        .addGroup(panelAdministrarTurnosMedicosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaTextoFechaHasta)
                            .addComponent(etiHasta, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioBotTarde))
                        .addGap(30, 30, 30))
                    .addGroup(panelAdministrarTurnosMedicosLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(botFiltrar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelAdministrarTurnosMedicosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(botAsignarTurno, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addComponent(botCancelarTurno, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addComponent(botReagendarTurno, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(PieDePagina2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        TablaPortal.addTab("Administrar Turnos Medicos", panelAdministrarTurnosMedicos);

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

    private void botAsignarTurnoActionPerformed(ActionEvent evt) {
    	
    }
    
    private void botReagendarTurnoActionPerformed(ActionEvent evt) {
        
    }

    private void botCancelarTurnoActionPerformed(ActionEvent evt) {
        
    }

    private void botFiltrarActionPerformed(ActionEvent evt) {
        
    }

    private void cajaTextoFechaHastaActionPerformed(ActionEvent evt) {
        
    }

    private void cajaTextoFechaDesdeActionPerformed(ActionEvent evt) {
        
    }

    private void BotonCerrarSesion2ActionPerformed(ActionEvent evt) {
    	VentanaLogin ventanaLogin = new VentanaLogin(this.clinica);
        ventanaLogin.setVisible(true);
        this.dispose();
    }

    private void BotonCerrarSesion1ActionPerformed(ActionEvent evt) {
    	VentanaLogin ventanaLogin = new VentanaLogin(this.clinica);
        ventanaLogin.setVisible(true);
        this.dispose();
    }

    private void botVerHorariosActionPerformed(ActionEvent evt) {
        
    }
    
    private void botAsignarHorarioActionPerformed(ActionEvent evt) {
        
    }
    
}
