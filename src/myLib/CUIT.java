package myLib;

public class CUIT {
	
	private static final  int[] SERIE_PROD =  {5, 4, 3, 2, 7, 6, 5, 4, 3, 2}; 
	
	public static boolean test(long nroCuit) {
		
		String cuitStr = String.valueOf(nroCuit);
		
		if(cuitStr.length() != 11)
			return false;
		
		String x = cuitStr.substring(0, 2);
		if(x != "20" && x != "27")
			return false;
		x = x == "20"? "M" : "F";
		
		
		int producto = 0;
		int pos = 0;
		for(Character c : cuitStr.toCharArray()) {
			int n = Character.getNumericValue(c);
			producto += n*SERIE_PROD[pos];
			pos++;
		}
		
		producto %= 11;
		int z = 11 - producto;
		
		if(z == 11 && cuitStr.substring(10) == "0" )
			return true;
		
		if(z == 10 && cuitStr.substring(10) == "9")
			return true;
		
		if(z == Integer.parseInt(cuitStr.substring(10)))
			return true;
		
		
		return false;
	}
}
