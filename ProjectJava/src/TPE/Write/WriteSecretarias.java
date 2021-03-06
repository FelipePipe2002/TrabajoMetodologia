package TPE.Write;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import TPE.*;

public class WriteSecretarias extends WriteCSV{
	
	public WriteSecretarias(Clinica clinica) {
		super(clinica);
	}

	public void WriteUsuario(BufferedWriter bw) {
		try {
			ArrayList<Secretaria> secretarias = clinica.getSecretarias();
			for(Secretaria u:secretarias) {
				bw.write(u.toString());
				bw.newLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
