package TPE;

import java.time.LocalDateTime;
import java.util.Objects;

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
	
	public boolean IgualesEnFecha(LocalDateTime fecha,String Dni) { // se fija si el medico tiene un turno en esa fecha, es como el equals pero el equals normal se fija si toda la fecha es la misma y puede pasar que si tenga un turno en esa fecha pero la hora y minuto no coincidan
		return this.fecha.getYear() == fecha.getYear() && this.fecha.getMonth() == fecha.getMonth() && this.fecha.getDayOfMonth() == fecha.getDayOfMonth() && this.medico.getDni().equals(Dni);
	}
	
	@Override
	public String toString() {
		if (disponible == true)
			return disponible + "," + medico.getDni() + "," + "," + fecha;
		else
			return disponible + "," + medico.getDni() + "," + paciente.getDni() + "," + fecha;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Turno other = (Turno) obj;
        return Objects.equals(fecha, other.fecha) && Objects.equals(medico, other.medico);
	}
	
}
