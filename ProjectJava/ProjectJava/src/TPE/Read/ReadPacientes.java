package TPE.Read;

import TPE.*;

public class ReadPacientes extends ReadCSV{
	
	public ReadPacientes() {
		super("./Pacientes.csv");
	}
	
	@Override
	public void CargarUsuario(String[] items, Clinica clinica) {	
		Paciente nuevo = new Paciente(items[0],items[1],items[2], new Direccion(items[3], items[4], items[5], items[6]), items[7],items[8],items[9], items[10]);
		clinica.addPaciente(nuevo);
	}

}