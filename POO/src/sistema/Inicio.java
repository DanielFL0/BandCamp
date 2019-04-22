package sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import interfaces.UserLogin;

/**
 * Primera clase en ejecutarse al iniciar el sistema.
 * Hace una conexi�n inicial a la base de datos para verificar que se pueda seguir usando el sistema.
 * Redirige al inicio de sesi�n.
 */
class Inicio {
	public static void main(String[] args) {
		
		// test de conexi�n al servidor
		try {
			Connection connection = DriverManager.getConnection(DBInfo.url, DBInfo.usuario, DBInfo.password);
			System.out.println("Conexi�n establecida");
			
			UserLogin logIn = new UserLogin();
			logIn.setLocationRelativeTo(null);
			logIn.setVisible(true);
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lo sentimos, parece que nuestros servidores fallaron.\n�Int�ntalo en unos minutos!",
					"Error de servidor", JOptionPane.ERROR_MESSAGE);
		}
	}
}
