package TPE;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteSecretarias extends WriteCSV{
	
	public WriteSecretarias(Clinica clinica) {
		super(clinica);
	}

	public void WriteUsuario(BufferedWriter bw) {
		try {
			ArrayList<Secretaria> secretarias = clinica.getSecretaria();
			for(Secretaria u:secretarias) {
				bw.write(u.toString());
				bw.newLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
