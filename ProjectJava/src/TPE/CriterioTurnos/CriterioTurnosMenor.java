package TPE.CriterioTurnos;

import java.time.LocalDateTime;

public class CriterioTurnosMenor extends CriterioTurnos {
	LocalDateTime FechaFinal;
	
	public CriterioTurnosMenor(LocalDateTime fechaFinal) {
		super();
		FechaFinal = fechaFinal;
	}

	@Override
	public boolean cumple(LocalDateTime Fecha) {
		return (FechaFinal.compareTo(Fecha)>=0);
	}
}