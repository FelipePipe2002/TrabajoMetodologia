package TPE.CriterioTurnos;

import java.time.LocalDateTime;

public class CriterioTurnosRango extends CriterioTurnos {
	LocalDateTime FechaInicio;
	LocalDateTime FechaFinal;
	
	public CriterioTurnosRango(LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
		super();
		FechaInicio = fechaInicio;
		FechaFinal = fechaFinal;
	}

	@Override
	public boolean cumple(LocalDateTime Fecha) {
		return (FechaInicio.compareTo(Fecha)>=0 && FechaFinal.compareTo(Fecha)<=0);
	}
}
