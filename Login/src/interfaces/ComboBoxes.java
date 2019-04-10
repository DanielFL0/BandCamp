package interfaces;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * Contiene los comboboxes de las facultades, de los g�neros y de los instrumentos.
 */
public class ComboBoxes {
	JComboBox<String> cmbFacultades, cmbGeneros, cmbInstrumentos;
	
	/**
	 * Define a los comboboxes, les agrega las opciones y deshabilita la edici�n.
	 */
	public ComboBoxes(){
		JComboBox<String> cmbFacultades = new JComboBox<String>();
		cmbFacultades.setModel(new DefaultComboBoxModel<String>(
				new String[] {"FIME", "FCQ", "FACPYA", "FCFM", "FARQ", "FACDYC", "FIC", "FAV", "FOD"}));
		cmbFacultades.setEditable(false);
		
		JComboBox<String> cmbGeneros = new JComboBox<String>();
		cmbGeneros.setModel(new DefaultComboBoxModel<String>(
				new String[] {"Rock", "Jazz", "Reggaeton", "Rap", "Metal", "Indie", "K-Pop", "Pop", "Cl�sica"}));
		cmbGeneros.setEditable(false);
				
		JComboBox<String> cmbInstrumentos = new JComboBox<String>();
		cmbInstrumentos.setModel(new DefaultComboBoxModel<String>(
				new String[] {"Guitarra", "Bater�a", "Piano", "Xil�fono", "Flauta",
						"Viol�n", "Trompeta", "Oboe", "Ocarina", "Bajo"}));
		cmbInstrumentos.setEditable(false);
	}
}
