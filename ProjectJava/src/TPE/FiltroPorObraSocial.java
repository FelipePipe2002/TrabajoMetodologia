package TPE;

public class FiltroPorObraSocial extends FiltroDeBusqueda{
	
	private String obraSocial;
	
	public boolean filtrar(Medico medico) {
		for (String e:medico.getObrasSociales()) {
			if (e.equalsIgnoreCase(obraSocial))
				return true;
		}
		return false;
	}
}
