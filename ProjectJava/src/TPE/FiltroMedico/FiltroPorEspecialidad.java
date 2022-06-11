package TPE.FiltroMedico;

import TPE.*;

public class FiltroPorEspecialidad extends FiltroDeBusqueda{

	private String especialidad;
	
	public FiltroPorEspecialidad(String especialidad) {
		super();
		this.especialidad = especialidad;
	}

	public boolean filtrar(Medico medico) {
		for (String e:medico.getEspecialidades()) {
			if (e.equalsIgnoreCase(especialidad))
				return true;
		}
		return false;
	}
}
