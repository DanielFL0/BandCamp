package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import sistema.Login;
import sistema.Usuario;

@SuppressWarnings("serial")
public class UserLogin extends JFrame implements ActionListener {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JTextField txtCorreo;
	private JPasswordField passwordField;
	
	/**
	 * Create the frame.
	 */
	public UserLogin() {
		setTitle("Bandcamp - Iniciar sesi�n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 414);
		
		JPanel contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBandcampUanl = new JLabel("BandCamp UANL");
		lblBandcampUanl.setForeground(Color.ORANGE);
		lblBandcampUanl.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
		lblBandcampUanl.setBounds(204, 11, 175, 33);
		contentPane.add(lblBandcampUanl);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo electr\u00F3nico");
		lblCorreoElectrnico.setForeground(Color.WHITE);
		lblCorreoElectrnico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCorreoElectrnico.setBounds(63, 88, 113, 20);
		contentPane.add(lblCorreoElectrnico);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(101, 130, 75, 14);
		contentPane.add(lblContrasea);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(186, 90, 217, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JButton Iniciarbtn = new JButton("Iniciar sesi\u00F3n");
		Iniciarbtn.setFont(new Font("Verdana", Font.BOLD, 12));
		Iniciarbtn.setBounds(227, 216, 128, 25);
		contentPane.add(Iniciarbtn);
		Iniciarbtn.setActionCommand("Inicio");
		Iniciarbtn.addActionListener(this);
		
		JButton Registrarsebtn = new JButton("Registrarse");
		Registrarsebtn.setFont(new Font("Verdana", Font.BOLD, 12));
		Registrarsebtn.setBounds(227, 260, 128, 25);
		Registrarsebtn.setActionCommand("Registro");
		contentPane.add(Registrarsebtn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 129, 219, 20);
		contentPane.add(passwordField);
		Registrarsebtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {		
		//---botones
		String command = event.getActionCommand();
		if (command.contentEquals("Inicio")) {
			String correo = txtCorreo.getText();
			String password = String.valueOf(passwordField.getPassword());
			
			Usuario sesionIniciada = new Login().ingresar(correo, password);
			if (sesionIniciada != null) {
				Feed framefeed = new Feed(sesionIniciada);
				framefeed.setLocationRelativeTo(null);
				framefeed.setVisible(true);
				UserLogin.this.dispose();
			}
		}
		else if(command.contentEquals("Registro")) {
		    Registro frameregistro = new Registro();
		    frameregistro.setLocationRelativeTo(null);
			frameregistro.setVisible(true);
			UserLogin.this.dispose();
		}
	}
}