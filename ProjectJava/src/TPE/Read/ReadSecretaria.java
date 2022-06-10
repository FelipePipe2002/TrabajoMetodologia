package TPE.Read;

import TPE.*;

public class ReadSecretaria extends ReadCSV{
	public ReadSecretaria() {
		super("./Secretarias.csv");
	}
	
	@Override
	public void CargarUsuario(String[] items, Clinica clinica) {	
		Secretaria nuevo = new Secretaria(items[0],items[1],items[2], items[3], items[4]);
        int i = 5;
        while (i < items.length) {
			Medico medico = clinica.getMedico(items[i]);
        	if (medico != null)
				nuevo.addMedico(medico);
			i++;
		}
		clinica.addSecretaria(nuevo);
	}
}
