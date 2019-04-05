package sistema;

import java.util.Scanner;

public class Login {
	
	//Metodo "ingresar", simplemente le pide al usuario que ingrese su correo electronico y contrase�a, despues se verifica si estan correctas.
	public Usuario ingresar() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingresa tu correo electronico: ");
		String correo = scanner.nextLine();
		
		System.out.println("Ingresa tu contrase�a: ");
		String contrase�a = scanner.nextLine();
		
		//Validacion en base de datos
		// aqu� se har�n los queries para comprobar que el correo y la contrase�a coinciden
//		if (cuenta.getCor_usu().equals(correo) && cuenta.getPas_usu().equals(contrase�a)) {
//			System.out.println("Correo correcto y contrase�a correcta");
//		}
		
		scanner.close();
		
		return null;
	}
}