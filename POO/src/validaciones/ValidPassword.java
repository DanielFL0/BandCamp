package validaciones;

import javax.swing.JOptionPane;

/**
 * Clase para validar si la contrase�a ingresada cumple con los requisitos mencionados en su m�todo.
 */
public class ValidPassword {
	
	/**
	 * M�todo que valida mediante expresiones regulares si el <code>String</code> de entrada cumple con:
	 * <br> Tiene entre 8 y 16 caracteres.
	 * <br> Tiene al menos un d�gito.
	 * <br> Tiene al menos un caracter especial.
	 * <br> No tiene espacios.
	 * @param input <code>String</code> a ser validado seg�n los requisitos anteriores.
	 * @return <code>true</code> si la contrase�a es v�lida, de lo contrario <code>false</code>.
	 */
	public static boolean isValidPassword(String input) {
		if (input.matches("(?=.*\\d)((?=.*[a-z])|(?=.*[A-Z]))(?=.*[!?_@#$%^&+=])(?=\\S+$).{8,16}")) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null,
					"La contrase�a debe incluir al menos un n�mero, al menos un caracter especial,\n"
					+ "y ser entre 8 y 16 caracteres de largo.",
					"Contrase�a inv�lida", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}
