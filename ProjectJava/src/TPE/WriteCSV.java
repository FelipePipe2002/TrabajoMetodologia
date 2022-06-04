package TPE;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class WriteCSV {

	protected Clinica clinica;
	
	public WriteCSV(Clinica clinica) {
		this.clinica = clinica;
	}
	
	public void generarArchivoCSV(String dirArchivo) {
		BufferedWriter bw = null;
		try {
			File file = new File(dirArchivo);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			WriteUsuario(bw);
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public abstract void WriteUsuario(BufferedWriter bw);
}
