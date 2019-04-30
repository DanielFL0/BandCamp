package validaciones;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase para generar un hash del algoritmo MD5.
 */
public class MD5 {
	
	/**
	 * Crea el hash de una contrase�a de acuerdo al algoritmo MD5.
	 * @param message <code>String</code> que almacena la contrase�a del usuario
	 * 					y ser� encriptada.
	 * @return el <code>String</code> del hash encriptado de la contrase�a. 
	 */
	public static String hashPassword(String message) {
		try {
			// instancia para usar algoritmo MD5
			MessageDigest msgDigest = MessageDigest.getInstance("MD5");
			
			// se a�aden bytes de la contrase�a al digest
			msgDigest.update(message.getBytes());
			
			// obtener bytes del hash
			byte[] bytes = msgDigest.digest();
			
			// como los bytes est�n en decimal hay que pasarlo a hexadecimal
			StringBuilder stringBuilder = new StringBuilder();
			for (byte b : bytes) {
				// cada byte del arreglo se formatea a su equivalente hexadecimal
				String hex = String.format("%x", b);
				// y se va a�adiendo
				stringBuilder.append(hex);
			}
			
			// obtener hash en hexadecimal
			return stringBuilder.toString();
		}
		catch (NoSuchAlgorithmException error) {
			 error.printStackTrace();
		}
		
		return null;
	}
}
