package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
import javax.swing.table.DefaultTableModel;

import TPE.*;

public class VentanaTurnosMedico extends JFrame {
	
	JTable tablaTurnos;
	Clinica clinica;
	Medico medico;
	Paciente paciente;
	VentanaPortalPacientes ventanaPaciente;
	//atributos de fecha (desde, hasta) y filtro manana o tarde
	
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
    	JTextField cajaTextoFechaDesde = new JTextField();
    	JTextField cajaTextoFechaHasta = new JTextField();
    	JLabel etiDesde = new JLabel();
    	JLabel etiHasta = new JLabel();
        JRadioButton radioBotManiana = new JRadioButton();
        JRadioButton radioBotTarde = new JRadioButton();
    	this.tablaTurnos = new JTable();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        this.tablaTurnos.setFont(new Font("Book Antiqua", 0, 14));
        DefaultTableModel modeloTabla = new DefaultTableModel() {
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
        	modeloTabla.addRow(new Object[] {t.getMedico().getNombre()+ " " + t.getMedico().getApellido(),t.getFecha().getDayOfMonth() + "/" + t.getFecha().getMonthValue(),t.getFecha().getHour() + ":" + t.getFecha().getMinute()});
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
        heap2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        etiNombreClinica2.setFont(new Font("Book Antiqua", 1, 36)); // NOI18N
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

        cajaTextoFechaDesde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cajaTextoFechaDesdeActionPerformed(evt);
            }
        });

        cajaTextoFechaHasta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cajaTextoFechaHastaActionPerformed(evt);
            }
        });

        etiDesde.setFont(new Font("Book Antiqua", 0, 14)); // NOI18N
        etiDesde.setHorizontalAlignment(SwingConstants.RIGHT);
        etiDesde.setText("Desde:");

        etiHasta.setFont(new Font("Book Antiqua", 0, 14)); // NOI18N
        etiHasta.setHorizontalAlignment(SwingConstants.RIGHT);
        etiHasta.setText("Hasta:");

        radioBotManiana.setText("Mañana");
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
                        .addComponent(botConfirmar, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelTurnosLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(etiDesde, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(etiHasta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelTurnosLayout.createSequentialGroup()
                        .addComponent(cajaTextoFechaHasta, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radioBotTarde, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTurnosLayout.createSequentialGroup()
                        .addComponent(cajaTextoFechaDesde, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addComponent(radioBotManiana, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelTurnosLayout.setVerticalGroup(
            panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelTurnosLayout.createSequentialGroup()
                .addComponent(heap2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaTextoFechaDesde)
                    .addComponent(etiDesde, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioBotManiana))
                .addGap(18, 18, 18)
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

    private void cajaTextoFechaDesdeActionPerformed(ActionEvent evt) {                                                    
        
    }                                                   

    private void cajaTextoFechaHastaActionPerformed(ActionEvent evt) {                                                    
        
    }                                                   

    private void radioBotManianaActionPerformed(ActionEvent evt) {                                                
        
    }                                               

    private void radioBotTardeActionPerformed(ActionEvent evt) {                                              
        
    }         
}
