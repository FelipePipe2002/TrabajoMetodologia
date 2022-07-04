package TPE.FiltroMedico;

import java.util.ArrayList;

import TPE.Medico;

public class FiltroPorMedico extends FiltroDeBusqueda{
	private ArrayList<Medico> medicos;
	
	public FiltroPorMedico(ArrayList<Medico> medicos) {
		super();
		this.medicos = new ArrayList<>(medicos);
	}

	@Override
	public boolean filtrar(Medico medico) {
		return medicos.contains(medico);
	}

}
