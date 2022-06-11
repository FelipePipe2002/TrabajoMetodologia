package TPE.CriterioTurnos;

import java.time.LocalDateTime;

public class CriterioTurnosAnd extends CriterioTurnos{
	CriterioTurnos f1;
	CriterioTurnos f2;
	
	public CriterioTurnosAnd(CriterioTurnos f1, CriterioTurnos f2) {
		super();
		this.f1 = f1;
		this.f2 = f2;
	}

	@Override
	public boolean cumple(LocalDateTime Fecha) {
		return f1.cumple(Fecha) && f2.cumple(Fecha);
	}

}
