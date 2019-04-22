package sistema;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Contiene los atributos que se muestran en el muro y en el perfil de la cuenta filtrada.
 */
public class CuentaFiltrada {
	private int tipo;
	private String nombre, genero, instrumento, facultad, descripcion;
	
	/**
	 * Construye la {@code CuentaFiltrada} con cada atributo especificado.
	 */
	public CuentaFiltrada(int tipo, String nombre, String genero, String instrumento, String facultad, String descripcion) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.genero = genero;
		this.instrumento = instrumento;
		this.facultad = facultad;
		this.descripcion = descripcion;
	}
	
	/**
	 * Construye la {@code CuentaFiltrada} a partir de el resultado de una consulta a la base de datos.
	 * @param cuenta {@code ResultSet} del cual se usar�n solo los atributos que se mostrar�n.
	 * @throws SQLException 
	 */
	public CuentaFiltrada(ResultSet cuenta) throws SQLException {
		this.tipo = cuenta.getInt("tip_usu");
		this.nombre = cuenta.getString("nom_usu");
		this.genero = cuenta.getString("gen_usu");
		this.instrumento = cuenta.getString("ins_usu");
		this.facultad = cuenta.getString("fac_usu");
		this.descripcion = cuenta.getString("des_usu");
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
