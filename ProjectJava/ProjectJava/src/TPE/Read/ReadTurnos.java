package TPE.Read;

import java.time.LocalDateTime;
import TPE.*;

public class ReadTurnos extends ReadCSV{
	public ReadTurnos() {
		super("./Turnos.csv");
	}
	
	public void CargarUsuario(String[] items, Clinica clinica) {
		Medico medico = clinica.getMedico(items[1]);
        String [] arrayFecha = items[3].split("-");
        LocalDateTime fecha = LocalDateTime.of(Integer.parseInt(arrayFecha[0]),Integer.parseInt(arrayFecha[1]),Integer.parseInt(arrayFecha[2].substring(0, 2)),Integer.parseInt(arrayFecha[2].substring(3, 5)),Integer.parseInt(arrayFecha[2].substring(6, 8)));
        Turno turno = new Turno(medico, fecha);
		if (items[0].equals("false")) {
			Paciente paciente = clinica.getPaciente(items[2]);
			turno.asignarPaciente(paciente);
			paciente.addTurno(turno);
		}
		medico.addTurno(turno);
	}
}
