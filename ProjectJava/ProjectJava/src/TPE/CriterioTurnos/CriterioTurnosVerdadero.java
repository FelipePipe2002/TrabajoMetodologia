package TPE.CriterioTurnos;

import java.time.LocalDateTime;

public class CriterioTurnosVerdadero extends CriterioTurnos {

	@Override
	public boolean cumple(LocalDateTime Fecha) {
		return true;
	}

}
