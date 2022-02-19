package entidades;

public class Ubicacion {
	private double latitud;
	private double longitud;
	/**
	 * @param latitud
	 * @param longitud
	 */
	protected Ubicacion(double latitud, double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}
	/**
	 * @return the latitud
	 */
	public double getLatitud() {
		return latitud;
	}
	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	/**
	 * @return the longitud
	 */
	public double getLongitud() {
		return longitud;
	}
	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	
	public boolean equals(Ubicacion ubicacion) {
		boolean respuesta = false;
		
		if(this.latitud == ubicacion.getLatitud() && this.longitud == ubicacion.getLongitud())
			respuesta = true;
		
		return respuesta;
	}
	
	
//	auxiliares
	
	
//	https://donnierock.com/2015/03/16/calculando-la-distancia-entre-doos-coordenadas-en-java/
	private double distanciaCoord(double lat1, double lng1, double lat2, double lng2, Ubicacion ubicacion) {  
        //double radioTierra = 3958.75;//en millas  
        double radioTierra = 6371;//en kilómetros  
        double dLat = Math.toRadians(ubicacion.getLatitud() - this.latitud);  
        double dLng = Math.toRadians(ubicacion.getLongitud() - this.longitud);  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);  
        double x = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));  
        double y = 2 * Math.atan2(Math.sqrt(x), Math.sqrt(1 - x));  
        
        return  radioTierra * y;  
    }  
	
}
