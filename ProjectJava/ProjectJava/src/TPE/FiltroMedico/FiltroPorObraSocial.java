package TPE.FiltroMedico;

import TPE.*;

public class FiltroPorObraSocial extends FiltroDeBusqueda{
	
	private String obraSocial;
	
	public FiltroPorObraSocial(String obraSocial) {
		super();
		this.obraSocial = obraSocial;
	}

	public boolean filtrar(Medico medico) {
		for (String e:medico.getObrasSociales()) {
			if (e.equalsIgnoreCase(obraSocial))
				return true;
		}
		return false;
	}
}
