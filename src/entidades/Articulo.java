package entidades;

public class Articulo {
	private int id;
	private String nombre;
	private String codBarras;
	private double precio;
	
	
	/**
	 * @param id
	 * @param nombre
	 * @param codBarras
	 * @param precio
	 * @throws Exception 
	 */
	public Articulo(int id, String nombre, String codBarras, double precio) throws Exception {
		super();
		this.id = id;
		this.nombre = nombre;
		setCodBarras(codBarras);
		this.precio = precio;
	}

	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	protected void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}


	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}


	/**
	 * @return the codBarras
	 */
	public String getCodBarras() {
		return codBarras;
	}


	public void setCodBarras(String codBarras) throws Exception {
		if(!validarCodBarras(codBarras))
			throw new Exception("Error codigo de barras invalido");
		
		this.codBarras = codBarras;
	}
	
	public boolean equals(Articulo articulo) {
		if (this == articulo)
			return true;
		if (articulo == null)
			return false;
		if (getClass() != articulo.getClass())
			return false;
		Articulo other = (Articulo) articulo;
		if (codBarras == null) {
			if (other.codBarras != null)
				return false;
		} else if (!codBarras.equals(other.codBarras))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
//	auxiliares
	private boolean validarCodBarras(String codBarras) {
		
		if(codBarras.length()>13)
			return false;
		
		char[] nros = codBarras.toCharArray();
		
		int suma = 0;
		
		for(int i=0; i<nros.length-1; i++) {
			int n = Character.getNumericValue(nros[i]);
			if(i%2 == 0 || i == 0)
				suma += n;
			else
				suma += (n*3);
		}
		
		int codigoControl = redondearDecena(suma) - (suma); 
		
		return codigoControl == Character.getNumericValue(nros.length-1);
	}
	
	
	private int redondearDecena(int n) {
		int redondeo = n;
		
		while(true) {
			char[] numero = String.valueOf(redondeo).toCharArray();
			
			if(numero[numero.length-1] == '0')
				break;
			
			redondeo++;
		}
		
		return redondeo;
	}
	
	
	
}
