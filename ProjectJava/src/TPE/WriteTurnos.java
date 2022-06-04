package TPE;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteTurnos extends WriteCSV {
	public WriteTurnos(Clinica clinica) {
		super(clinica);
	}

	public void WriteUsuario(BufferedWriter bw) {
		try {
			ArrayList<Turno> turno = clinica.getTurnos();
			for(Turno u:turno) {
				bw.write(u.toString());
				bw.newLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
