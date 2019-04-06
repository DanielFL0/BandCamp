package validaciones;

import javax.swing.JOptionPane;

public class ValidNum extends BoolIsNumber {
	
	/**
	 * Pide una entrada de tipo <code>String</code> para luego
	 * ser validada como entero mediante un cuadro de di�logo 
	 * de <code>JOptionPane</code>.
	 * @param request mensaje de solicitud que aparecer� en el di�logo.
	 * @param title t�tulo del di�logo.
	 * @return el valor <code>int</code> de la entrada.
	 */
	public static int validInt(String request, String title) {
		String input = JOptionPane.showInputDialog(null, request, title, JOptionPane.QUESTION_MESSAGE);
		
		if (isInt(input)) {
			return Integer.parseInt(input);
		}
		else {
			JOptionPane.showMessageDialog(null, "Introducir enteros solamente.", "Error", JOptionPane.ERROR_MESSAGE);
			return validInt(request, title);
		}
	}
}
