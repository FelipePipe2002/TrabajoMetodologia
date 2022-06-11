package TPE;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
	
	private static boolean verificarExistencia(Clinica c, String dni, String nroAfiliado) {	
		
		if(c.getPaciente(dni) != null) {
			return true;
		}
		
		for(Paciente p: c.getPacientes()){
			if(p.getNroAfiliado().equals(nroAfiliado)) {
				return true;
			}
		}
		
		return false;
	}
	
	private static boolean verificarCampos(String [] dp) {

		Pattern pattern = Pattern.compile("[\\s]");
		
		for( int i = 0 ; i < dp.length ; i++ ) {
			Matcher matcher = pattern.matcher(dp[i]);
			if( matcher.find() )
				return true;
		}
		
		return false;
	}
	
	public static boolean verificarCampoNotificacion(String t, String e) {
		
		Pattern patternEmail = Pattern.compile("[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", Pattern.CASE_INSENSITIVE);
		Matcher matcherEmail = patternEmail.matcher(e);
		
		Pattern patternTelefono = Pattern.compile("/\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})/");
		Matcher matcherTelefono = patternTelefono.matcher(t);
		
		if(matcherEmail.find() || matcherTelefono.find())
			return true;
		
		return false;
	}
	
    private static String[] getDatosPersonales(Clinica c){

    /* 
        Datos que el usuario debera ingresar

        [0] String nombre
        [1] String apellido
        [2] String dni
        (
        [3] String calle
        [4]  String numero
        [5]  String piso
        [6] String depto
        )
        [7]  String telefono
        [8]  String email
        [9]  String obraSocial
        [10]  String nroAfiliado

    */

        String [] dp = {"", "", "", "", "", "", "", "", "", "", ""};
        Scanner read = new Scanner(System.in);   

        System.out.println('\n' + " A continuacion se le solicitara sus datos.");
        
        System.out.print(" >>> Por favor, ingrese su nombre: ");
		dp[0] = read.nextLine();

        System.out.print(" >>> Por favor, ingrese su apellido: ");
		dp[1] = read.nextLine();

        System.out.print(" >>> Por favor, ingrese su dni: ");
		dp[2] = read.nextLine();

        System.out.print(" >>> Por favor, ingrese su calle: ");
		dp[3] = read.nextLine();

        System.out.print(" >>> Por favor, ingrese su numero de calle: ");
		dp[4] = read.nextLine();

        System.out.print(" >>> Por favor, ingrese su piso: ");
		dp[5] = read.nextLine();

        System.out.print(" >>> Por favor, ingrese su depto: ");
		dp[6] = read.nextLine();

        System.out.print(" >>> Por favor, ingrese su telefono: ");
		dp[7] = read.nextLine();

        System.out.print(" >>> Por favor, ingrese su email: ");
		dp[8] = read.nextLine();

        System.out.print(" >>> Por favor, ingrese su obra social: ");
		dp[9] = read.nextLine();

        System.out.print(" >>> Por favor, ingrese su nroAfiliado: ");
		dp[10] = read.nextLine();

		if(  verificarExistencia(c, dp[2] ,dp[10]) || !verificarCampoNotificacion(dp[7], dp[8]) || verificarCampos(dp) )
			return null;
		
        return dp;
    }

    private static void loguearPaciente(Usuario u, Clinica c) {

    		System.out.println('\n' + " Ha ingresado como paciente.");
    	
            String option;
            Scanner read = new Scanner(System.in);
            
            System.out.print(" >>> Por favor, ingrese su DNI: ");
		    option = read.nextLine();

        	Paciente p = c.getPaciente(option);
        	
            //Parte de verificar si existe paciente
			if ( p != null ) {  

				System.out.print('\n' +" Bienvenido al sistema " + p.getApellido() + ", " + p.getNombre());
        
				u = p; 
				
			} else {
				
				System.out.println('\n' + " Usted no se encuentra en el sistema.");
				
				System.out.print(" >>> Desea registrarse? (y/n) : ");
				option = read.nextLine();
				
				if ( option.equals("y") ) {
					
					boolean bucle = true;
					
					while(bucle) {
						
						String items [] = getDatosPersonales(c);
						
						if( items != null) {
							
							System.out.print('\n' + " Se ha registrado con exito. ");
							
							u = new Paciente(items[0],items[1],items[2], new Direccion(items[3], items[4], items[5], items[6]), items[7],items[8],items[9], items[10]);
							c.addPaciente((Paciente) u);

							bucle = false;	
						}
						else {
							
							System.out.print('\n' + " El dni ingresado o numero de afiliado ya pertenece al sistema. ");
							System.out.print('\n' + " O bien, usted a ingresado los campos de forma incorrecta. ");
							
							System.out.print('\n' + " >>> Desea registrarse nuevamente? (y/n) : ");
								option = read.nextLine();
								
							if( !option.equals("y") )
								bucle = false;
						}
					}
				}
				
			}
			
			System.out.println('\n' + " Fin del logueo. ");
    }

    public static void loguear(Usuario u, Clinica c){
    	
    	System.out.println('\n' + " Bienvenido usuario" + '\n');
    	
    	System.out.println(" Para acceder como Paciente ingrese 0");
    	System.out.println(" Para acceder como no Paciente ingrese 1");
    	
        int option;
		Scanner read = new Scanner(System.in);

		System.out.print(" >>> Por favor, ingrese en que forma quiere ingresar al sistema: ");
		option = read.nextInt();

		/* 
			option 0	-	Paciente
			option 1 	-	No paciente
		*/

        if( option == 0 ){ 

			loguearPaciente(u, c);

		} else {

			//Parte de los medicos y secretarias

		}
    }

}
