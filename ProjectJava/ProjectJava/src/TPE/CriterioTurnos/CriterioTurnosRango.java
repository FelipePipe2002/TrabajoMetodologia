package TPE.CriterioTurnos;

import java.time.LocalDateTime;

public class CriterioTurnosRango extends CriterioTurnos {
	CriterioTurnosMayor FechaInicio;
	CriterioTurnosMenor FechaFinal;
	
	public CriterioTurnosRango(LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
		super();
		FechaInicio = new CriterioTurnosMayor(fechaInicio);
		FechaFinal = new CriterioTurnosMenor(fechaFinal);
	}

	@Override
	public boolean cumple(LocalDateTime Fecha) {
		return (FechaInicio.cumple(Fecha) && FechaFinal.cumple(Fecha));
	}
}
