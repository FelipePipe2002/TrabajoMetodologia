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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import TPE.*;

public class VentanaTurnosMedico extends JFrame {
	
	JTable tablaTurnos;
	Clinica clinica;
	Medico medico;
	Paciente paciente;
	
    public VentanaTurnosMedico(Clinica clinica, Medico medico, Paciente paciente) {
        this.clinica = clinica;
        this.medico = medico;
        this.paciente = paciente;
    	initComponents();
        this.setLocationRelativeTo(null);
    }
                        
    private void initComponents() {

    	FondoPanel panelTurnos = new FondoPanel("/FondoLogin1.jpg");
    	JScrollPane jScrollPane1 = new JScrollPane();
    	JButton botConfirmar = new JButton();
    	JPanel Heap2 = new JPanel();
    	JLabel EtiNombreClinica2 = new JLabel();
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

        botConfirmar.setFont(new Font("Book Antiqua", 0, 18)); // NOI18N
        botConfirmar.setText("Confirmar turno");
        botConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botConfirmarActionPerformed(evt);
            }
        });
        
        Heap2.setBackground(new Color(3, 123, 139));
        Heap2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        EtiNombreClinica2.setFont(new Font("Book Antiqua", 1, 36)); // NOI18N
        EtiNombreClinica2.setText("Nombre Clinica");

        GroupLayout Heap2Layout = new GroupLayout(Heap2);
        Heap2.setLayout(Heap2Layout);
        Heap2Layout.setHorizontalGroup(
            Heap2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(Heap2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(EtiNombreClinica2, GroupLayout.PREFERRED_SIZE, 713, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        Heap2Layout.setVerticalGroup(
            Heap2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(EtiNombreClinica2, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
        );

        GroupLayout panelTurnosLayout = new GroupLayout(panelTurnos);
        panelTurnos.setLayout(panelTurnosLayout);
        panelTurnosLayout.setHorizontalGroup(
            panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelTurnosLayout.createSequentialGroup()
                .addGroup(panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(Heap2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTurnosLayout.createSequentialGroup()
                        .addGroup(panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panelTurnosLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTurnosLayout.createSequentialGroup()
                                .addGap(305, 305, 305)
                                .addComponent(botConfirmar, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTurnosLayout.setVerticalGroup(
            panelTurnosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelTurnosLayout.createSequentialGroup()
                .addComponent(Heap2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(botConfirmar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
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
    	int fila = tablaTurnos.getSelectedRow();
    	if (fila != -1) {
	    	Turno turno = medico.getTurnosDisponibles().get(fila);
	    	VentanaRegistro ventanaRegistro = new VentanaRegistro(this.clinica, this.paciente, turno, "Confirmar");
	    	ventanaRegistro.setVisible(true);
	        this.dispose();
    	}
    }   
    
}
