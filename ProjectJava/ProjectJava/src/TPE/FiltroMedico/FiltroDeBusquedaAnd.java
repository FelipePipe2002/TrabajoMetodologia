package TPE.FiltroMedico;

import TPE.*;

public class FiltroDeBusquedaAnd extends FiltroDeBusqueda {
	
	FiltroDeBusqueda f1;
	FiltroDeBusqueda f2;
	
	public FiltroDeBusquedaAnd(FiltroDeBusqueda f1, FiltroDeBusqueda f2) {
		super();
		this.f1 = f1;
		this.f2 = f2;
	}


	@Override
	public boolean filtrar(Medico medico) {
		return f1.filtrar(medico) && f2.filtrar(medico);
	}

}
