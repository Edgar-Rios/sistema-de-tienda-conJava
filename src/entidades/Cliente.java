package entidades;

public class Cliente extends Actor{
	
	private String apellido;
	private String nombre;
	private int id;
	
	
	/**
	 * @param apellido
	 * @param nombre
	 * @param id
	 */
	public Cliente(int id, Contacto contacto, String apellido, String nombre, int dni) {
		super(id, contacto);
		this.apellido = apellido;
		this.nombre = nombre;
		this.id = id;
	}


	@Override
	protected boolean validarIdentificadorUnico() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
