package TPE;
//import java.util.ArrayList;//import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {
		
		// Inicializacion de archivos
		ReadPacientes pacientes = new ReadPacientes();
		ReadMedico medicos = new ReadMedico();
		ReadSecretaria secretarias = new ReadSecretaria();
		ReadTurnos turnos = new ReadTurnos();
		
		//Codigo
		System.out.println("Secretaria:");
		System.out.println(clinica.getSecretaria());
		
		//Guardado de datos
		WriteCSV archivoPacientes = new WritePacientes(clinica);
		archivoPacientes.generarArchivoCSV(pacientes.getCsvFile());
		WriteCSV archivoMedicos = new WriteMedicos(clinica);
		archivoMedicos.generarArchivoCSV(medicos.getCsvFile());
		WriteCSV archivoSecretarias = new WriteSecretarias(clinica);
		archivoSecretarias.generarArchivoCSV(secretarias.getCsvFile());
		WriteCSV archivoTurnos = new WriteTurnos(clinica);
		archivoTurnos.generarArchivoCSV(turnos.getCsvFile());
	}
}
