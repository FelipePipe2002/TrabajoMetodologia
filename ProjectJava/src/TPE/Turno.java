package TPE;

import java.time.LocalDateTime;
import TPE.CriterioTurnos.*;

public class Turno {
	private boolean disponible;
	private Medico medico;
	private Paciente paciente;
	private LocalDateTime fecha;
	
	public Turno(Medico medico, LocalDateTime fecha) {
		this.disponible = true;
		this.medico = medico;
		this.fecha = fecha;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Medico getMedico() {
		return medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void asignarPaciente(Paciente paciente) {
		this.paciente = paciente;
		this.disponible = false;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}
	
	public boolean cumple(CriterioTurnos f) {
		return f.cumple(this.getFecha());
	}
	@Override
	public String toString() {
		if (disponible == true)
			return disponible + "," + medico.getDni() + "," + "," + fecha;
		else
			return disponible + "," + medico.getDni() + "," + paciente.getDni() + "," + fecha;
	}
	
	
}
