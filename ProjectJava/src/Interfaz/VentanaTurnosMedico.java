package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import TPE.*;
import TPE.CriterioTurnos.*;

public class VentanaTurnosMedico extends JFrame {
	
	JTable tablaTurnos;
	Clinica clinica;
	Medico medico;
	Paciente paciente;
	VentanaPortalPacientes ventanaPaciente;
	JRadioButton radioBotManiana;
    JRadioButton radioBotTarde;
    JTextField cajaTextoFechaDesde;
	JTextField cajaTextoFechaHasta;
	JButton botBuscar;
	DefaultTableModel modeloTabla;
	JScrollPane jScrollPane1;

    public VentanaTurnosMedico(Clinica clinica, Medico medico, Paciente paciente, VentanaPortalPacientes ventanaPaciente) {
        this.clinica = clinica;
        this.medico = medico;
        this.paciente = paciente;
        this.ventanaPaciente = ventanaPaciente;
    	initComponents();
        this.setLocationRelativeTo(null);
    }
                        
    private void initComponents() {

    	FondoPanel panelTurnos = new FondoPanel("/FondoLogin1.jpg");
    	JScrollPane jScrollPane1 = new JScrollPane();
    	JButton botConfirmar = new JButton();
    	JPanel heap2 = new JPanel();
    	JLabel etiNombreClinica2 = new JLabel();
    	this.cajaTextoFechaDesde = new JTextField();
    	this.cajaTextoFechaHasta = new JTextField();
    	JLabel etiDesde = new JLabel();
    	JLabel etiHasta = new JLabel();
        this.radioBotManiana = new JRadioButton();
        this.radioBotTarde = new JRadioButton();
        this.botBuscar = new JButton();
    	this.tablaTurnos = new JTable();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        this.tablaTurnos.setFont(new Font("Book Antiqua", 0, 14));
        this.modeloTabla = new DefaultTableModel() {
        	public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        ArrayList<Turno> turnos = new ArrayList<>();
        turnos = medico.getTurnosDisponibles();
        
        modeloTabla.addColumn("Medico");
        modeloTabla.addColumn("Dia");
        modeloTabla.addColumn("Hora");
        for (Turno t: turnos) {
        	modeloTabla.addRow(new Object[] {t.getMedico().getNombre()+ " " + t.getMedico().getApellido(),t.getFecha().getYear() + "-" + t.getFecha().getMonthValue() + "-" + t.getFecha().getDayOfMonth(),t.getFecha().getHour() + ":" + t.getFecha().getMinute()});
        }
        this.tablaTurnos.setModel(modeloTabla);
        
        this.tablaTurnos.setMaximumSize(new Dimension(225, 600));
        this.tablaTurnos.setMinimumSize(new Dimension(100, 300));
        this.tablaTurnos.setPreferredSize(new Dimension(225, 600));
        this.tablaTurnos.setShowGrid(false);
        jScrollPane1.setViewportView(this.tablaTurnos);

        botConfirmar.setFont(new Font("Book Antiqua", 0, 18));
        botConfirmar.setText("Confirmar turno");
        botConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botConfirmarActionPerformed(evt);
            }
        });
        
        heap2.setBackground(new Color(3, 123, 139));
        heap2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));

        etiNombreClinica2.setFont(new Font("Book Antiqua", 1, 36));
        etiNombreClinica2.setText(clinica.getNombre());

        GroupLayout Heap2Layout = new GroupLayout(heap2);
        heap2.setLayout(Heap2Layout);
        Heap2Layout.setHorizontalGroup(
            Heap2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(Heap2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(etiNombreClinica2, GroupLayout.PREFERRED_SIZE, 713, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        Heap2Layout.setVerticalGroup(
            Heap2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(etiNombreClinica2, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
        );

        etiDesde.setFont(new Font("Book Antiqua", 0, 14));
        etiDesde.setHorizontalAlignment(SwingConstants.RIGHT);
        etiDesde.setText("Desde:");

        etiHasta.setFont(new Font("Book Antiqua", 0, 14));
        etiHasta.setHorizontalAlignment(SwingConstants.RIGHT);
        etiHasta.setText("Hasta:");

        radioBotManiana.setText("Ma�ana");
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
        
        botBuscar.setText("Buscar");
        botBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botBuscarActionPerformed(evt);
            }
        });

        GroupLayout panelTurnosLayout = new GroupLayout(panelTurnos);
        panelTurnos.setLayout(panelTurnosLayout);
        panelTurnosLayout.setHorizontalGroup(
            panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelTurnosLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(panelTurnosLayout.createSequentialGroup()
                .addGroup(panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(heap2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTurnosLayout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(botConfirmar, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelTurnosLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(etiDesde, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                        .addComponent(etiHasta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(cajaTextoFechaDesde, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cajaTextoFechaHasta, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
                    .addGap(47, 47, 47)
                    .addGroup(panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(radioBotTarde, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelTurnosLayout.createSequentialGroup()
                            .addComponent(radioBotManiana, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(botBuscar)))
                    .addGap(0, 163, Short.MAX_VALUE))
        );
        panelTurnosLayout.setVerticalGroup(
                panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panelTurnosLayout.createSequentialGroup()
                    .addGroup(panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelTurnosLayout.createSequentialGroup()
                            .addComponent(heap2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cajaTextoFechaDesde)
                                .addComponent(etiDesde, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addComponent(radioBotManiana))
                            .addGap(18, 18, 18))
                        .addGroup(GroupLayout.Alignment.TRAILING, panelTurnosLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(botBuscar)
                            .addGap(3, 3, 3)))
                    .addGroup(panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelTurnosLayout.createSequentialGroup()
                            .addGroup(panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cajaTextoFechaHasta)
                                .addComponent(etiHasta, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12))
                        .addGroup(panelTurnosLayout.createSequentialGroup()
                            .addComponent(radioBotTarde)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(botConfirmar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23))
            );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelTurnos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelTurnos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        pack();
    }
    
    private void botConfirmarActionPerformed(ActionEvent evt) {                                             
    	int fila = this.tablaTurnos.getSelectedRow();
    	if (fila != -1) {
	    	Turno turno = medico.getTurnosDisponibles().get(fila);
	    	VentanaRegistro ventanaRegistro = new VentanaRegistro(this.clinica, this.paciente, turno, "Confirmar");
	    	ventanaRegistro.setVisible(true);
	    	this.ventanaPaciente.dispose();
	        this.dispose();
    	}
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
    
    private void botBuscarActionPerformed(ActionEvent evt) {                                          
    	Pattern pattern = Pattern.compile("^((20|2[0-9])[0-9]{2})-(0[1-9]|[1-9]|1[012])-(0[1-9]|[1-9]|[12][0-9]|3[01])$"); // (2001-01-01)
        Matcher matcher = pattern.matcher(this.cajaTextoFechaDesde.getText());
        Matcher matcher2 = pattern.matcher(this.cajaTextoFechaHasta.getText());
        
        int rowCount = this.modeloTabla.getRowCount();
    	for (int i = rowCount - 1; i >= 0; i--) {
    		this.modeloTabla.removeRow(i);
    	}
    	
    	CriterioTurnos Fecha = new CriterioTurnosVerdadero();
    	CriterioTurnos Horario = new CriterioTurnosVerdadero();
    	
    	boolean Desde = matcher.find();
    	boolean Hasta = matcher2.find();
    	
    	System.out.println(Desde);
    	
    	if(!Desde && !this.cajaTextoFechaDesde.getText().isEmpty())
    		this.cajaTextoFechaDesde.setBorder(new LineBorder(Color.RED));
    	if(!Hasta && !this.cajaTextoFechaHasta.getText().isEmpty())
    		this.cajaTextoFechaHasta.setBorder(new LineBorder(Color.RED));
    	
    	
    	if (Desde && Hasta) {
    		this.cajaTextoFechaDesde.setBorder(new LineBorder(Color.black));
    		this.cajaTextoFechaHasta.setBorder(new LineBorder(Color.black));
        	String [] FechaDesde = this.cajaTextoFechaDesde.getText().split("-");
        	LocalDateTime FechaDesdeL = LocalDateTime.of(Integer.parseInt(FechaDesde[0]),Integer.parseInt(FechaDesde[1]),Integer.parseInt(FechaDesde[2]),0,0);
        	
        	String [] FechaHasta = this.cajaTextoFechaHasta.getText().split("-");
        	LocalDateTime FechaHastaL = LocalDateTime.of(Integer.parseInt(FechaHasta[0]),Integer.parseInt(FechaHasta[1]),Integer.parseInt(FechaHasta[2]),0,0);
        	
        	Fecha = new CriterioTurnosRango(FechaDesdeL,FechaHastaL);
    		
    	} else if (Desde && this.cajaTextoFechaHasta.getText().isEmpty()) {
    		this.cajaTextoFechaDesde.setBorder(new LineBorder(Color.black));
    		String [] FechaDesde = this.cajaTextoFechaDesde.getText().split("-");
        	LocalDateTime FechaDesdeL = LocalDateTime.of(Integer.parseInt(FechaDesde[0]),Integer.parseInt(FechaDesde[1]),Integer.parseInt(FechaDesde[2]),0,0);
        	
        	Fecha = new CriterioTurnosMayor(FechaDesdeL);
    		
    	} else if (this.cajaTextoFechaDesde.getText().isEmpty() && Hasta) {
    		this.cajaTextoFechaHasta.setBorder(new LineBorder(Color.black));
    		String [] FechaHasta = this.cajaTextoFechaHasta.getText().split("-");
        	LocalDateTime FechaHastaL = LocalDateTime.of(Integer.parseInt(FechaHasta[0]),Integer.parseInt(FechaHasta[1]),Integer.parseInt(FechaHasta[2]),0,0);
        	
        	Fecha = new CriterioTurnosMenor(FechaHastaL);
    	}
    	
    	
    	
    	if (this.radioBotManiana.isSelected()) {
    		Horario = new CriterioTurnosManiana();
    	} else if (this.radioBotTarde.isSelected()){
    		Horario = new CriterioTurnosNot(new CriterioTurnosManiana());
    	}
    	
    	CriterioTurnos general = new CriterioTurnosAnd(Fecha,Horario);
    	
    	ArrayList<Turno> turnos = this.clinica.devolverTurnosMedico(medico,general);
    	this.modeloTabla.setRowCount(0);
    	for (Turno t: turnos) {
    		modeloTabla.addRow(new Object[] {t.getMedico().getNombre()+ " " + t.getMedico().getApellido(),t.getFecha().getYear() + "-" + t.getFecha().getMonthValue() + "-" + t.getFecha().getDayOfMonth() ,t.getFecha().getHour() + ":" + t.getFecha().getMinute()});
        }
    	this.tablaTurnos.setModel(modeloTabla);
    	
    	

    } 
}
