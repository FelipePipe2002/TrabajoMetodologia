package TPE.CriterioTurnos;

import java.time.LocalDateTime;

public class CriterioTurnosNot extends CriterioTurnos {
	
	CriterioTurnos f1;
	
	public CriterioTurnosNot(CriterioTurnos f1) {
		super();
		this.f1 = f1;
	}

	@Override
	public boolean cumple(LocalDateTime Fecha) {
		return !f1.cumple(Fecha);
	}

}
