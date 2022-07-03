package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;

import TPE.*;
import TPE.CriterioTurnos.CriterioTurnos;
import TPE.CriterioTurnos.CriterioTurnosAnd;
import TPE.CriterioTurnos.CriterioTurnosManiana;
import TPE.CriterioTurnos.CriterioTurnosMayor;
import TPE.CriterioTurnos.CriterioTurnosMenor;
import TPE.CriterioTurnos.CriterioTurnosNot;
import TPE.CriterioTurnos.CriterioTurnosRango;
import TPE.CriterioTurnos.CriterioTurnosVerdadero;
import TPE.Read.ReadPacientes;
import TPE.Read.ReadTurnos;
import TPE.Write.WriteCSV;
import TPE.Write.WritePacientes;
import TPE.Write.WriteTurnos;

public class VentanaPortalSecretarias extends JFrame {
	
	Clinica clinica;
	Secretaria secretaria;
	Medico medico;
	JTable tablaDeMedicos;
	JTable tablaDeTurnos;
	DefaultTableModel modeloTablaMedicos;
	DefaultTableModel modeloTablaTurnos;
	JScrollPane tablaTurnos;
	JCheckBox jCheckBox1;
    JCheckBox jCheckBox2;
    JCheckBox jCheckBox3;
    JCheckBox jCheckBox4;
    JCheckBox jCheckBox5;
    JCheckBox jCheckBox6;
    JCheckBox jCheckBox7;
    JRadioButton radioBotManiana;
    JRadioButton radioBotTarde;
    JTextField cajaTextoFechaDesde;
	JTextField cajaTextoFechaHasta;
	JTextField cajaTextoHoraInicio;
	JTextField cajaTextoHoraCierre;
	JTextField cajaTextoDuracionTurno;
	JTextField cajaTextoNombre;
	JButton botFiltrar;
	JButton botAsignarTurno;
    JButton botReagendarTurno;
    JButton botCancelarTurno;
    JButton botAsignarHorario;
    
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
    	JScrollPane tablaMedicos = new JScrollPane();
    	JTextField jTextField1 = new JTextField();
        FondoPanel panelAdministrarTurnosMedicos = new FondoPanel("/FondoLogin1.jpg");
        JPanel PieDePagina1 = new JPanel();
        JPanel jPanel1 = new JPanel();
        JPanel Heap1 = new JPanel();
        JPanel Heap2 = new JPanel();
        JButton botVerHorarios = new JButton();
        JButton BotonCerrarSesion1 = new JButton();
        JButton BotonCerrarSesion2 = new JButton();
        JLabel EtiNombreClinica1 = new JLabel();
        JLabel jLabel1 = new JLabel();
        JLabel etiHoraInicio = new JLabel();
        JLabel etiHoraCierre = new JLabel();
        JLabel etiDuracionTurno = new JLabel();
        JLabel EtiNombreClinica2 = new JLabel();
        JPanel PieDePagina2 = new JPanel();
        JLabel etiDesde = new JLabel();
        JLabel etiHasta = new JLabel();
        JLabel etiNombre = new JLabel();
        this.botAsignarHorario = new JButton();
        this.cajaTextoHoraCierre = new JTextField();
        this.cajaTextoHoraInicio = new JTextField();
        this.cajaTextoDuracionTurno = new JTextField();
        this.tablaDeMedicos = new JTable();
        this.jCheckBox1 = new JCheckBox();
        this.jCheckBox2 = new JCheckBox();
        this.jCheckBox3 = new JCheckBox();
        this.jCheckBox4 = new JCheckBox();
        this.jCheckBox5 = new JCheckBox();
        this.jCheckBox6 = new JCheckBox();
        this.jCheckBox7 = new JCheckBox();
        this.cajaTextoFechaDesde = new JTextField();
        this.cajaTextoFechaHasta = new JTextField();
        this.radioBotManiana = new JRadioButton();
        this.radioBotTarde = new JRadioButton();
        this.botFiltrar = new JButton();
        this.tablaTurnos = new JScrollPane();
        this.tablaDeTurnos = new JTable();
        this.cajaTextoNombre = new JTextField();
        this.botAsignarTurno = new JButton();
        this.botReagendarTurno = new JButton();
        this.botCancelarTurno = new JButton();
        	
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
        
        for (Medico m: this.secretaria.getMedicos())
        	modeloTablaMedicos.addRow(new Object[] {m.getNombre(),m.getApellido(),m.getDni()});
        this.tablaDeMedicos.setModel(modeloTablaMedicos);
        
        this.tablaDeMedicos.setToolTipText("");
        tablaMedicos.setViewportView(this.tablaDeMedicos);

        jLabel1.setFont(new Font("Book Antiqua", 0, 18));
        jLabel1.setText("Nombre:");

        jPanel1.setBackground(new Color(3, 123, 139));
        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Medico", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Book Antiqua", 0, 36)));

        jCheckBox1.setFont(new Font("Book Antiqua", 0, 14));
        jCheckBox1.setText("Lunes");
        jCheckBox1.setBackground(new ColorUIResource(96, 96, 96));
        	
        jCheckBox2.setFont(new Font("Book Antiqua", 0, 14));
        jCheckBox2.setText("Martes");
        jCheckBox2.setBackground(new ColorUIResource(96, 96, 96));
        
        jCheckBox3.setFont(new Font("Book Antiqua", 0, 14));
        jCheckBox3.setText("Miercoles");
        jCheckBox3.setBackground(new ColorUIResource(96, 96, 96));
        
        jCheckBox4.setFont(new Font("Book Antiqua", 0, 14));
        jCheckBox4.setText("Jueves");
        jCheckBox4.setBackground(new ColorUIResource(96, 96, 96));
        
        jCheckBox5.setFont(new Font("Book Antiqua", 0, 14));
        jCheckBox5.setText("Viernes");
        jCheckBox5.setBackground(new ColorUIResource(96, 96, 96));
        
        jCheckBox6.setFont(new Font("Book Antiqua", 0, 14));
        jCheckBox6.setText("Sabado");
        jCheckBox6.setBackground(new ColorUIResource(96, 96, 96));
        
        jCheckBox7.setFont(new Font("Book Antiqua", 0, 14));
        jCheckBox7.setText("Domingo");
        jCheckBox7.setBackground(new ColorUIResource(96, 96, 96));
        
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
                                	.addComponent(jCheckBox1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                	.addComponent(jCheckBox2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addGap(110, 110, 110)
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
                        .addGap(55, 55, 55)
                        .addComponent(jCheckBox1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(tablaMedicos, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(tablaMedicos, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
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

        etiHasta.setFont(new Font("Book Antiqua", 0, 14));
        etiHasta.setHorizontalAlignment(SwingConstants.RIGHT);
        etiHasta.setText("Hasta:");

        radioBotManiana.setText("Maniana");
        radioBotManiana.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radioBotManianaActionPerformed(evt);
            }
        });
        radioBotTarde.setText("Tarde");
        radioBotTarde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radioBotTardeActionPerformed(evt);
            }
        });

        botFiltrar.setText("Filtrar");
        botFiltrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botFiltrarActionPerformed(evt);
            }
        });

      //Tabla de turnos
        this.tablaDeTurnos.setFont(new Font("Book Antiqua", 0, 14));       
        this.modeloTablaTurnos = new DefaultTableModel() {
        	public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        this.modeloTablaTurnos.addColumn("Medico");
        this.modeloTablaTurnos.addColumn("Dia");
        this.modeloTablaTurnos.addColumn("Hora");
        this.modeloTablaTurnos.addColumn("Disponibilidad");
        
        for (Medico m: this.secretaria.getMedicos()) {
	        for (Turno t: m.getTurnos()) {
	        	String Disponibilidad = "Libre";
    			if (!t.isDisponible())
    				Disponibilidad = "Ocupado";
	        	this.modeloTablaTurnos.addRow(new Object[] {t.getMedico().getNombre()+ " " + t.getMedico().getApellido(),t.getFecha().getDayOfMonth() + "/" + t.getFecha().getMonthValue() + "/" + t.getFecha().getYear(),t.getFecha().getHour() + ":" + t.getFecha().getMinute(),Disponibilidad});
	        }
	    }
	    this.tablaDeTurnos.setModel(modeloTablaTurnos);  
        this.tablaDeTurnos.setMaximumSize(new Dimension(225, 600));
        this.tablaDeTurnos.setMinimumSize(new Dimension(100, 300));
        this.tablaDeTurnos.setPreferredSize(new Dimension(225, 600));
        this.tablaDeTurnos.setShowGrid(false);
        tablaTurnos.setViewportView(this.tablaDeTurnos);

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
                            .addComponent(tablaTurnos, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE))
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
                .addComponent(tablaTurnos, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
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
	//Panel asignar horarios
	private void botVerHorariosActionPerformed(ActionEvent evt) {
		int fila = this.tablaDeMedicos.getSelectedRow();	
		if (fila != -1) {
			String dni = (String) this.tablaDeMedicos.getValueAt(fila, 2);
		    Medico m= clinica.getMedico(dni); 

		    String DiasDeLaburo = m.getDiasDeLaburo();

		    if ( DiasDeLaburo.charAt(0) == '1' )
		    	jCheckBox1.setSelected(true);
		    else
		    	jCheckBox1.setSelected(false);
		    if ( DiasDeLaburo.charAt(1) == '1' )
			    jCheckBox2.setSelected(true);
		    else
		    	jCheckBox2.setSelected(false);
		    if ( DiasDeLaburo.charAt(2) == '1' )
		    	jCheckBox3.setSelected(true);
		    else
		    	jCheckBox3.setSelected(false);
		    if ( DiasDeLaburo.charAt(3) == '1' )
			    jCheckBox4.setSelected(true);
		    else
		    	jCheckBox4.setSelected(false);
		    if ( DiasDeLaburo.charAt(4) == '1' )
		    	jCheckBox5.setSelected(true);
		    else
		    	jCheckBox5.setSelected(false);
		    if ( DiasDeLaburo.charAt(5) == '1' )
			    jCheckBox6.setSelected(true);
		    else
		    	jCheckBox6.setSelected(false);
		    if ( DiasDeLaburo.charAt(6) == '1' )
		    	jCheckBox7.setSelected(true);
		    else
		    	jCheckBox7.setSelected(false);
		    
		    LocalDateTime Inicio = m.getHoraDeInicio();
		    this.cajaTextoHoraInicio.setText(Inicio.toString().substring(11, 16));
		    
		    LocalDateTime Cierre = m.getHoraDeCierre();
		    this.cajaTextoHoraCierre.setText(Cierre.toString().substring(11, 16));
		    
		    LocalDateTime Duracion = m.getDuracionDeTurno();
		    this.cajaTextoDuracionTurno.setText(Duracion.toString().substring(11, 16));
		}
	}
	
	private void botAsignarHorarioActionPerformed(ActionEvent evt) {
		//instancio variables
		int Dif = 8-LocalDateTime.now().getDayOfWeek().getValue();
		
		int fila = this.tablaDeMedicos.getSelectedRow();	
		Medico m= null;
		
		if (fila != -1) {
			String dni = (String) this.tablaDeMedicos.getValueAt(fila, 2);
			m = clinica.getMedico(dni); 
		}
	   
		LocalDateTime HorarioIL = LocalDateTime.of(0,1,1,0,0);
		LocalDateTime HorarioCL = LocalDateTime.of(0,1,1,0,0);
		LocalDateTime HorarioDL = LocalDateTime.of(0,1,1,0,0);
		
		ColorUIResource ColorDefault = new ColorUIResource(96, 96, 96);
		
		Color Rojo = Color.red;
		
		ArrayList<JCheckBox> CheckBox = new ArrayList<>();
		
		CheckBox.add(jCheckBox1);
		CheckBox.add(jCheckBox2);
		CheckBox.add(jCheckBox3);
		CheckBox.add(jCheckBox4);
		CheckBox.add(jCheckBox5);
		CheckBox.add(jCheckBox6);
		CheckBox.add(jCheckBox7);
		
		Pattern pattern = Pattern.compile("^(0[0-9]|[0-9]|[1][0-9]|2[0-3]):(0[0-9]|[1-5][0-9])$"); // (1:01 o 01:01 23:59)
        
		Matcher Hora = pattern.matcher(this.cajaTextoHoraInicio.getText());
        Matcher Hora2 = pattern.matcher(this.cajaTextoHoraCierre.getText());
        Matcher DuracionH = pattern.matcher(this.cajaTextoDuracionTurno.getText());
        
		boolean BoolInicio = false;
		boolean BoolCierre = false;
		boolean BoolDuracion = false;
		boolean BoolHorarioImC = false;
		
		
		
		//cargo los booleanos
		try {
			String [] HorarioI = this.cajaTextoHoraInicio.getText().split(":");
        	HorarioIL = LocalDateTime.of(0,1,1,Integer.parseInt(HorarioI[0]),Integer.parseInt(HorarioI[1]));
			BoolInicio = !this.cajaTextoHoraInicio.getText().isEmpty() && Hora.find() && HorarioIL.compareTo(LocalDateTime.of(0,1,1,0,0))>0;
		} catch (Exception e) {}
		
		try {
			String [] HorarioC = this.cajaTextoHoraCierre.getText().split(":");
        	HorarioCL = LocalDateTime.of(0,1,1,Integer.parseInt(HorarioC[0]),Integer.parseInt(HorarioC[1]));
			BoolCierre = !this.cajaTextoHoraCierre.getText().isEmpty() && Hora2.find() && HorarioCL.compareTo(LocalDateTime.of(0,1,1,0,0))>0;
		}catch (Exception e) {}
		
		try {
			String [] HorarioD = this.cajaTextoDuracionTurno.getText().split(":");
        	HorarioDL = LocalDateTime.of(0,1,1,Integer.parseInt(HorarioD[0]),Integer.parseInt(HorarioD[1]));
			BoolDuracion = !this.cajaTextoDuracionTurno.getText().isEmpty() && DuracionH.find() && HorarioDL.compareTo(LocalDateTime.of(0,1,1,0,5))>0; // los turnos tienen que durar mas de 5 min
		} catch (Exception e) {}
		
		boolean Boolcheck = CheckBox.get(0).isSelected() || CheckBox.get(1).isSelected() || CheckBox.get(2).isSelected() || CheckBox.get(3).isSelected() || CheckBox.get(4).isSelected() ||CheckBox.get(5).isSelected() || CheckBox.get(6).isSelected();
		
		
		//checkeo que cada capo este cargado y correctamente si no se marca con rojo los campos mal cargados
		for (JCheckBox j: CheckBox) {
			if (Boolcheck)
				j.setBackground(ColorDefault);
			else
				j.setBackground(Rojo);
		}
		
		if (BoolInicio) {
			this.cajaTextoHoraInicio.setBackground(ColorDefault);
		}else {
			this.cajaTextoHoraInicio.setBackground(Rojo);
		}
		
		if (BoolCierre) {
			this.cajaTextoHoraCierre.setBackground(ColorDefault);
		}else {
			this.cajaTextoHoraCierre.setBackground(Rojo);
		}
		
		if (HorarioIL.compareTo(HorarioCL)<0) {
			this.cajaTextoHoraInicio.setBackground(ColorDefault);
			this.cajaTextoHoraCierre.setBackground(ColorDefault);
			BoolHorarioImC = true;
		}else {
			this.cajaTextoHoraInicio.setBackground(Rojo);
			this.cajaTextoHoraCierre.setBackground(Rojo);
		}
        
		if (fila != -1) {
			this.tablaDeMedicos.setBackground(ColorDefault);
	    }
		else
			this.tablaDeMedicos.setBackground(Rojo);
		
		LocalDateTime DuracionIC = LocalDateTime.of(0,1,1,HorarioCL.minusHours(HorarioIL.getHour()).getHour(),HorarioCL.minusMinutes(HorarioIL.getMinute()).getMinute());
		
		if (HorarioDL.compareTo(DuracionIC) <=0 && BoolDuracion)
			this.cajaTextoDuracionTurno.setBackground(ColorDefault);
		else
			this.cajaTextoDuracionTurno.setBackground(Rojo);
		
		//cargo los turnos y valido cosas
		if (Boolcheck && BoolInicio && BoolCierre && BoolDuracion && BoolHorarioImC && m !=null && HorarioDL.compareTo(DuracionIC) <0) {        	
    		String DiasDeLaburo = "0000000";
    		String AuxD = "0000000";
    		
    		for (int i=0; i<7 ; i++) { //creo un string de 1 y 0 de un tamanio 7 de los dias que labura
    			if ( CheckBox.get(i).isSelected() ) {
        		    AuxD = DiasDeLaburo.substring(0,i) + "1" + DiasDeLaburo.substring(i+1,7);
        		    DiasDeLaburo = AuxD;
        		}
    		}
    		    
    		m.setDiasDeLaburo(DiasDeLaburo);    		    
    		m.setHoraDeInicio(HorarioIL);    		    
    		m.setHoraDeCierre(HorarioCL);    		    
    		m.setDuracionDeTurno(HorarioDL);
    		
    		LocalDateTime FechaTurno = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),LocalDateTime.now().getDayOfMonth(),HorarioIL.getHour(),HorarioIL.getMinute()).plusDays(8);
    		if (CheckBox.get(FechaTurno.getDayOfWeek().getValue()-1).isSelected()) {
    				ArrayList<Turno> aux = m.getTurnos();
    				boolean boolDiaLibre = true; // puede pasar que el mismo dia la secretaria cambia la configuracion, si lo hace tomara efecto al dia siguiente, ya que si no lo verifico va a tener varios turnos el mismo dia intercalados
    				for (Turno t : aux) { //verifico que este dia no tenga turnos por lo anterior
    					boolDiaLibre = !t.IgualesEnFecha(FechaTurno, m.getDni());
    					if (!boolDiaLibre) {
    						break;
    					}
    				}
    				
    				if (boolDiaLibre) {
	    				LocalDateTime HoraIni = FechaTurno;
	        			LocalDateTime HoraCierre = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),LocalDateTime.now().getDayOfMonth(),HorarioCL.getHour(),HorarioCL.getMinute()).plusDays(8);
	        			
	        			while (HoraIni.compareTo(HoraCierre)<=0) {
	        				Turno tnuevo = new Turno(m, HoraIni);  
	        				m.addTurno(tnuevo);
	        				HoraIni = HoraIni.plusHours(HorarioDL.getHour()).plusMinutes(HorarioDL.getMinute());
	        			}
	        			ArrayList<Turno> aux2 = m.getTurnos();
	        			System.out.println(aux2);
    				}
    			}
    		}
    }
	
	private void BotonCerrarSesion1ActionPerformed(ActionEvent evt) {
		VentanaLogin ventanaLogin = new VentanaLogin(this.clinica);
		ventanaLogin.setVisible(true);
		this.dispose();
	}
	
	//Panel administrar turnos medicos
    private void botAsignarTurnoActionPerformed(ActionEvent evt) {
    	
    }
    
    private void botReagendarTurnoActionPerformed(ActionEvent evt) {
        
    }

    private void botCancelarTurnoActionPerformed(ActionEvent evt) {
        
    }

    private void radioBotManianaActionPerformed(ActionEvent evt) {
   	 if (this.radioBotManiana.isSelected()) {
        	this.radioBotTarde.setSelected(false);
        }
    }
    
    private void radioBotTardeActionPerformed(ActionEvent evt) {
    	if (this.radioBotTarde.isSelected()) {
        	this.radioBotManiana.setSelected(false);
        }
    }
    
    private void botFiltrarActionPerformed(ActionEvent evt) {
    	Pattern pattern = Pattern.compile("^(0[1-9]|[1-9]|[12][0-9]|3[01])/(0[1-9]|[1-9]|[12][0-9]|3[01])/((20|2[0-9])[0-9]{2})$"); // (1/1/2001)
        Matcher matcher = pattern.matcher(this.cajaTextoFechaDesde.getText());
        Matcher matcher2 = pattern.matcher(this.cajaTextoFechaHasta.getText());
        
        int rowCount = this.modeloTablaTurnos.getRowCount();
    	for (int i = rowCount - 1; i >= 0; i--) {
    		this.modeloTablaTurnos.removeRow(i);
    	}
    	
    	CriterioTurnos Fecha = new CriterioTurnosVerdadero();
    	CriterioTurnos Horario = new CriterioTurnosVerdadero();
    	CriterioTurnos NombreApellido = new CriterioTurnosVerdadero();
    	
    	boolean Desde = matcher.find();
    	boolean Hasta = matcher2.find();
    	
    	if(!Desde && !this.cajaTextoFechaDesde.getText().isEmpty())
    		this.cajaTextoFechaDesde.setBorder(new LineBorder(Color.RED));
    	if(!Hasta && !this.cajaTextoFechaHasta.getText().isEmpty())
    		this.cajaTextoFechaHasta.setBorder(new LineBorder(Color.RED));
    	
    	
    	if (Desde && Hasta) {
    		this.cajaTextoFechaDesde.setBorder(new LineBorder(Color.black));
    		this.cajaTextoFechaHasta.setBorder(new LineBorder(Color.black));
        	String [] FechaDesde = this.cajaTextoFechaDesde.getText().split("/");
        	LocalDateTime FechaDesdeL = LocalDateTime.of(Integer.parseInt(FechaDesde[2]),Integer.parseInt(FechaDesde[1]),Integer.parseInt(FechaDesde[0]),0,0);
        	
        	String [] FechaHasta = this.cajaTextoFechaHasta.getText().split("/");
        	LocalDateTime FechaHastaL = LocalDateTime.of(Integer.parseInt(FechaHasta[2]),Integer.parseInt(FechaHasta[1]),Integer.parseInt(FechaHasta[0]),0,0);
        	
        	Fecha = new CriterioTurnosRango(FechaDesdeL,FechaHastaL);
    		
    	} else if (Desde && this.cajaTextoFechaHasta.getText().isEmpty()) {
    		this.cajaTextoFechaDesde.setBorder(new LineBorder(Color.black));
    		String [] FechaDesde = this.cajaTextoFechaDesde.getText().split("/");
        	LocalDateTime FechaDesdeL = LocalDateTime.of(Integer.parseInt(FechaDesde[2]),Integer.parseInt(FechaDesde[1]),Integer.parseInt(FechaDesde[0]),0,0);
        	
        	Fecha = new CriterioTurnosMayor(FechaDesdeL);
    		
    	} else if (this.cajaTextoFechaDesde.getText().isEmpty() && Hasta) {
    		this.cajaTextoFechaHasta.setBorder(new LineBorder(Color.black));
    		String [] FechaHasta = this.cajaTextoFechaHasta.getText().split("/");
        	LocalDateTime FechaHastaL = LocalDateTime.of(Integer.parseInt(FechaHasta[2]),Integer.parseInt(FechaHasta[1]),Integer.parseInt(FechaHasta[0]),0,0);
        	
        	Fecha = new CriterioTurnosMenor(FechaHastaL);
    	}
    	
    	if (this.radioBotManiana.isSelected()) {
    		Horario = new CriterioTurnosManiana();
    	} else if (this.radioBotTarde.isSelected()){
    		Horario = new CriterioTurnosNot(new CriterioTurnosManiana());
    	}
    	
    	CriterioTurnos general = new CriterioTurnosAnd(Fecha,Horario);
    	
    	String NombreS = this.cajaTextoNombre.getText().toLowerCase();
    	
    	ArrayList<Turno> turnos = this.secretaria.devolverTurnosDeMedicos(general);
    	
    	this.modeloTablaTurnos.setRowCount(0);
    	for (Turno t: turnos) {
    		if ((NombreS.equals(t.getMedico().getNombre().toLowerCase())) || NombreS.isEmpty()) {
    			String Disponibilidad = "Libre";
    			if (!t.isDisponible()) 
    				Disponibilidad = "Ocupado";
    			modeloTablaTurnos.addRow(new Object[] {t.getMedico().getNombre()+ " " + t.getMedico().getApellido(),t.getFecha().getDayOfMonth() + "/" + t.getFecha().getMonthValue() + "/" + t.getFecha().getYear(),t.getFecha().getHour() + ":" + t.getFecha().getMinute(),Disponibilidad});
    		}
    	}
    	this.tablaDeTurnos.setModel(modeloTablaTurnos);
    	
    	//habria que agregar un boton que sea guardar config para guardar la configuracion de turnos
    }
    
    private void BotonCerrarSesion2ActionPerformed(ActionEvent evt) {
    	VentanaLogin ventanaLogin = new VentanaLogin(this.clinica);
        ventanaLogin.setVisible(true);
        this.dispose();
    }

}
