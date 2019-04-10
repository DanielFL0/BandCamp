package interfaces;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class ComboBoxes {
	JComboBox<String> cmbFacultades, cmbGeneros, cmbInstrumentos;
	
	public ComboBoxes(){
		cmbFacultades = new JComboBox<String>();
		cmbFacultades.setModel(new DefaultComboBoxModel<String>(
				new String[] {"FIME", "FCQ", "FACPYA", "FCFM", "FARQ", "FACDYC", "FIC", "FAV", "FOD"}));
		cmbFacultades.setEditable(false);
		
		cmbGeneros = new JComboBox<String>();
		cmbGeneros.setModel(new DefaultComboBoxModel<String>(
				new String[] {"Rock", "Jazz", "Reggaeton", "Rap", "Metal", "Indie", "K-Pop", "Pop", "Cl�sica"}));
		cmbGeneros.setEditable(false);
				
		cmbInstrumentos = new JComboBox<String>();
		cmbInstrumentos.setModel(new DefaultComboBoxModel<String>(
				new String[] {"Guitarra", "Bater�a", "Piano", "Xil�fono", "Flauta",
						"Viol�n", "Trompeta", "Oboe", "Ocarina", "Bajo"}));
		cmbInstrumentos.setEditable(false);
	}
}
