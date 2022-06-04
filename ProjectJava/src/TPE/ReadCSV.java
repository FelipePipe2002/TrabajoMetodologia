package TPE;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class ReadCSV {

    protected String csvFile = "";
    protected String line = "";
    protected String csvSplitBy = ",";
    
    public ReadCSV(String csvFile) { 
		this.csvFile = csvFile;
	}
    
	public void agregarClinica(Clinica clinica) {
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	    	 //br.readLine();
	    	 
	        while ((line = br.readLine()) != null) {
	            String[] items = line.split(csvSplitBy);
	            CargarUsuario(items, clinica);
	        }
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public String getCsvFile() {
		return csvFile;
	}

	public abstract void CargarUsuario(String[] items, Clinica clinica);
}
