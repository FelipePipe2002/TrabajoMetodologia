package TPE.CriterioTurnos;

import java.time.LocalDateTime;

public class CriterioTurnosMañana extends CriterioTurnos {
	
	@Override
	public boolean cumple(LocalDateTime Fecha) {
		return (Fecha.getHour()<12);
	}
}