package Interfaz;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import TPE.Clinica;
import TPE.Medico;
import TPE.Paciente;
import TPE.Turno;

public class VentanaReagendarTurno extends JFrame {

	Clinica clinica;
	Medico medico;
	Paciente paciente;
	Turno turno;
	JTable tablaDeTurnos;
	DefaultTableModel modeloTablaTurnos;
	JButton botReagendar;
	
    public VentanaReagendarTurno(Clinica clinica, Turno turno) {
    	this.clinica = clinica;
    	this.turno = turno;
    	this.medico = turno.getMedico();
    	this.paciente = turno.getPaciente();
    	
        initComponents();
        this.setLocationRelativeTo(null);
    }
                
    private void initComponents() {

    	FondoPanel panelTurnos = new FondoPanel("/FondoLogin1.jpg");
    	JLabel etiTurnosDisponibles = new JLabel();
    	JScrollPane scrollTablaTurnos = new JScrollPane();
    	this.tablaDeTurnos = new JTable();
    	this.botReagendar = new JButton();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        etiTurnosDisponibles.setFont(new Font("Book Antiqua", 0, 18));
        etiTurnosDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
        etiTurnosDisponibles.setText("Turnos disponibles");

        this.tablaDeTurnos.setFont(new Font("Book Antiqua", 0, 14));       
        this.modeloTablaTurnos = new DefaultTableModel() {
        	public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        this.modeloTablaTurnos.addColumn("Medico");
        this.modeloTablaTurnos.addColumn("Dia");
        this.modeloTablaTurnos.addColumn("Hora");
        
        for (Turno t: this.medico.getTurnosDisponibles()) {
        	this.modeloTablaTurnos.addRow(new Object[] {t.getMedico().getNombre()+ " " + t.getMedico().getApellido(), t.getFecha().getDayOfMonth() + "/" + t.getFecha().getMonthValue() + "/" + t.getFecha().getYear(),t.getFecha().getHour() + ":" + t.getFecha().getMinute()});
        }
	    this.tablaDeTurnos.setModel(this.modeloTablaTurnos);  
        this.tablaDeTurnos.setMaximumSize(new Dimension(225, 600));
        scrollTablaTurnos.setViewportView(this.tablaDeTurnos);

        this.botReagendar.setFont(new Font("Book Antiqua", 0, 14));
        this.botReagendar.setText("Reagendar");
        this.botReagendar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botReagendarActionPerformed(evt);
            }
        });

        GroupLayout panelLayout = new GroupLayout(panelTurnos);
        panelTurnos.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(this.botReagendar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(etiTurnosDisponibles, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollTablaTurnos))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(etiTurnosDisponibles, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTablaTurnos, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(this.botReagendar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
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

    	private Turno obtenerTurnoMedico(int fila) {
			String fecha = (String) this.tablaDeTurnos.getValueAt(fila, 1);
	    	String [] arregloFecha = fecha.split("/");
	    	String hora = (String) this.tablaDeTurnos.getValueAt(fila, 2);
	    	String [] arregloHora = hora.split(":");
	    	LocalDateTime fechacompleta = LocalDateTime.of(Integer.parseInt(arregloFecha[2]),Integer.parseInt(arregloFecha[1]),Integer.parseInt(arregloFecha[0]),Integer.parseInt(arregloHora[0]),Integer.parseInt(arregloHora[1]));
    	return this.medico.getTurno(fechacompleta);
	}

    private void botReagendarActionPerformed(ActionEvent evt) {                                             
        this.paciente.eliminarTurno(this.turno);
        int fila = this.tablaDeTurnos.getSelectedRow();
        this.paciente.addTurno(this.obtenerTurnoMedico(fila));
        JOptionPane.showMessageDialog(null, "El turno ha sido reasignado");
        this.dispose();
    }
}