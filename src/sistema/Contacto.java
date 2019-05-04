package sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


/**
 * Clase que maneja la funcionalidad del contacto entre cuentas.
 */
public class Contacto {
	
	/**
	 * Notificaci�n rechazada.
	 */
	public static final int REJECT = 0;
	
	/**
	 * Notificaci�n pendiente.
	 */
	public static final int PENDING = 1;
	
	/**
	 * Notificaci�n aceptada.
	 */
	public static final int ACCEPT = 2;
	
	/**
	 * Crea un registro de notificaci�n en la tabla <i>Notificaciones</i> de la base de datos.
	 * @param id_remitente {@code int} que almacena el ID de la sesi�n iniciada.
	 * @param id_destinatario {@code int} que almacena el ID del {@code Usuario} destino.
	 * @see {@link Usuario}
	 */
	public static void crearNotificacion(int id_remitente, int id_destinatario) {
		try (Connection connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD)) {
			System.out.println("conectado notif");
			
			String insertNotifQuery = "INSERT INTO Notificaciones VALUES(?, ?, 1);";
			try (PreparedStatement insertNotifStatement = connection.prepareStatement(insertNotifQuery)) {
				insertNotifStatement.setInt(1, id_remitente);
				insertNotifStatement.setInt(2, id_destinatario);
				
				int rowsAdded = insertNotifStatement.executeUpdate();
				if (rowsAdded == 0) {
					JOptionPane.showMessageDialog(null, "Hubo un error al contactar al usuario.", 
							"No se cre� notificaci�n", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		} catch (SQLException error) {
			error.printStackTrace();
			JOptionPane.showMessageDialog(null, "Hubo un error al contactar al usuario.",
					"Error de servidor", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Verifica si ya ha sido enviada una notificaci�n para evitar duplicadas.
	 * @param id_remitente {@code int} del ID del {@code Usuario} que envi� la notificaci�n.
	 * @param id_destinatario {@code int} del ID del {@code Usuario} que la recibi�.
	 * @return {@code true} si ya exist�a un contacto entre ambos usuarios.
	 * @see {@link Usuario}
	 */
	public static boolean alreadyContacted(int id_remitente, int id_destinatario) {
		try (Connection connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD)) {
			System.out.println("conectado notif");
			
			String selectNotifQuery = "SELECT * FROM Notificaciones WHERE orig_not = ? AND dest_not = ? AND est_not = 1;";
			try (PreparedStatement selectNotifStatement = connection.prepareStatement(selectNotifQuery)) {
				selectNotifStatement.setInt(1, id_remitente);
				selectNotifStatement.setInt(2, id_destinatario);
				
				try (ResultSet selectedNotifSet = selectNotifStatement.executeQuery()) {
					while (selectedNotifSet.next()) {
						return true;
					}
				}
			}
		} catch (SQLException error) {
			error.printStackTrace();
		}
		
		return false;
	}
}