package TPE.CriterioTurnos;

import java.time.LocalDateTime;

public class CriterioTurnosMayor extends CriterioTurnos {
	LocalDateTime FechaInicio;
	
	public CriterioTurnosMayor(LocalDateTime fechaInicio) {
		super();
		FechaInicio = fechaInicio;
	}

	@Override
	public boolean cumple(LocalDateTime Fecha) {
		return (FechaInicio.compareTo(Fecha)<=0);
	}
}
