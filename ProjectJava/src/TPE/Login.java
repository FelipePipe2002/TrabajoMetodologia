public class Login () {

    private String[] getDatosPersonales(){

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

        String dp[];
        Scanner read = new Scanner(System.in);   

        System.out.print("Por favor, ingrese su nombre: ");
		dp[0] = read.nextString();

        System.out.print("Por favor, ingrese su apellido: ");
		dp[1] = read.nextString();

        System.out.print("Por favor, ingrese su dni: ");
		dp[2] = read.nextString();

        System.out.print("Por favor, ingrese su calle: ");
		dp[3] = read.nextString();

        System.out.print("Por favor, ingrese su numero de calle: ");
		dp[4] = read.nextString();

        System.out.print("Por favor, ingrese su piso: ");
		dp[5] = read.nextString();

        System.out.print("Por favor, ingrese su depto: ");
		dp[6] = read.nextString();

        System.out.print("Por favor, ingrese su telefono: ");
		dp[7] = read.nextString();

        System.out.print("Por favor, ingrese su email: ");
		dp[8] = read.nextString();

        System.out.print("Por favor, ingrese su obra social: ");
		dp[9] = read.nextString();

        System.out.print("Por favor, ingrese su obra social: ");
		dp[10] = read.nextString();

        return dp;
    }

    private void loguearPaciente(Usuario u, Clinica c) {
        
        	Paciente p = clinica.getPaciente(dni);
			
			if ( p != null ) { //Parte de verificar si existe paciente 
				u = new Paciente(p); 
			} else {
				System.out.println("Usted no se encuentra en el sistema.");

				//System.out.print("Desea registrarse? (y/n) : ");
				String items [] = this.getDatosPersonales();
				u = new Paciente(items[0],items[1],items[2], new Direccion(items[3], items[4], items[5], items[6]), items[7],items[8],items[9], items[10]);
				clinica.addPaciente((Paciente) usuario);
				
			}
    }

    public static void loguear(Usuario u, Clinica c){
        
        int option;
		String dni; 
		Scanner read = new Scanner(System.in);

		System.out.print("Por favor, ingrese en que forma quiere ingresar al sistema: ");
		option = read.nextInt();

		/* 
			option 0	-	Paciente
			option 1 	-	No paciente
		*/

        if( option == "0" ){ 

			this.logearPaciente(usuario, clinica);

		} else {
			//Parte de los medicos y secretarias
		}
    }

}
