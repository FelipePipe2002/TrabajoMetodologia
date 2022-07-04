package TPE.Write;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import TPE.*;

public class WritePacientes extends WriteCSV{
	
	public WritePacientes(Clinica clinica) {
		super(clinica);
	}

	public void WriteUsuario(BufferedWriter bw) {
		try {
			ArrayList<Paciente> pacientes = clinica.getPacientes();
			for(Paciente u:pacientes) {
				bw.write(u.toString());
				bw.newLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
