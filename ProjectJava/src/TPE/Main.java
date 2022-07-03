package TPE;

//import java.util.ArrayList;//import java.time.LocalDateTime;
import Interfaz.*;
import TPE.Read.*;
import TPE.Write.*;

public class Main {

	public static void main(String[] args) {

		Clinica clinica = new Clinica("Clinica Chacabuco", new Direccion("Chacabuco", "340"));
    	
		// Inicializacion de archivos
		ReadPacientes pacientes = new ReadPacientes();
		ReadMedico medicos = new ReadMedico();
		ReadSecretaria secretarias = new ReadSecretaria();
		ReadTurnos turnos = new ReadTurnos();

		pacientes.agregarClinica(clinica); //lee el archivo que guarda la info. de pacientes
		medicos.agregarClinica(clinica); //lee el archivo que guarda la info. de medicos
		secretarias.agregarClinica(clinica); //lee el archivo que guarda la info. de secretarias
		turnos.agregarClinica(clinica); // lee el archivo que guarda la info. de turnos
			
		//Codigo
		VentanaLogin login = new VentanaLogin(clinica);
		login.setVisible(true);
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        public void run() {
	        	WriteCSV archivoPacientes = new WritePacientes(clinica);
	    		archivoPacientes.generarArchivoCSV(pacientes.getCsvFile());
	    		WriteCSV archivoMedicos = new WriteMedicos(clinica);
	    		archivoMedicos.generarArchivoCSV(medicos.getCsvFile());
	    		WriteCSV archivoSecretarias = new WriteSecretarias(clinica);
	    		archivoSecretarias.generarArchivoCSV(secretarias.getCsvFile());
	    		WriteCSV archivoTurnos = new WriteTurnos(clinica);
	    		archivoTurnos.generarArchivoCSV(turnos.getCsvFile());
	        }
	    }, "Shutdown-thread"));
	}
}
