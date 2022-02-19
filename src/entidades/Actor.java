package entidades;

public abstract class Actor {
	private int id;
	protected Contacto contacto;
	
	/**
	 * @param id
	 * @param contacto
	 */
	protected Actor(int id, Contacto contacto) {
		super();
		this.id = id;
		this.contacto = contacto;
	}
	
	
	protected abstract boolean validarIdentificadorUnico();
	
}
