package componentes;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * Contiene los comboboxes de las facultades, de los g�neros y de los instrumentos.
 */
public class ComboBoxes {
	public JComboBox<String> cmbFacultades, cmbGeneros, cmbInstrumentos;

	/**
	 * Define a los comboboxes, les agrega las opciones y deshabilita la edici�n.
	 */
	public ComboBoxes() {
		cmbFacultades = new JComboBox<String>();
		cmbFacultades.setModel(new DefaultComboBoxModel<String>(
				new String[] {"FIME", "FCQ", "FACPYA", "FCFM", "FARQ", "FACDYC", "FIC", "FAV", "FOD"}));
		cmbFacultades.setSize(158, 20);
		
		cmbGeneros = new JComboBox<String>();
		cmbGeneros.setModel(new DefaultComboBoxModel<String>(
				new String[] {"Rock", "Jazz", "Reggaeton", "Rap", "Metal", "Indie", "K-Pop", "Pop", "Cl�sica"}));
		cmbGeneros.setSize(158, 20);
				
		cmbInstrumentos = new JComboBox<String>();
		cmbInstrumentos.setModel(new DefaultComboBoxModel<String>(
				new String[] {"Guitarra", "Bater�a", "Piano", "Xil�fono", "Flauta",
						"Viol�n", "Trompeta", "Oboe", "Ocarina", "Bajo"}));
		cmbInstrumentos.setSize(158, 20);
	}
}
