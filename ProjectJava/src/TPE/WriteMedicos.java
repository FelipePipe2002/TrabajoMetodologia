package TPE;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteMedicos extends WriteCSV{
	
	public WriteMedicos(Clinica clinica) {
		super(clinica);
	}

	public void WriteUsuario(BufferedWriter bw) {
		try {
			ArrayList<Medico> medicos = clinica.getMedico();
			for(Medico u:medicos) {
				bw.write(u.toString());
				bw.newLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
