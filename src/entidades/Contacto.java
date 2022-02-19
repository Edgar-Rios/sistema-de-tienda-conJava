package entidades;

public class Contacto {
	
	private String email;
	private String celular;
	private Ubicacion ubicacion;
	
	
	/**
	 * @param email
	 * @param celular
	 * @param ubicacion
	 */
	public Contacto(String email, String celular, Ubicacion ubicacion) {
		super();
		this.email = email;
		this.celular = celular;
		this.ubicacion = ubicacion;
	}
	
	
	
}
