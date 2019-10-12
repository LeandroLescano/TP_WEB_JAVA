package Dominio;

public class TipoSeguro {
	
	private int ID;
	private String Descripcion;
	
	public TipoSeguro()
	{
		
	}
	
	public TipoSeguro(int iD, String descripcion) {
		ID = iD;
		Descripcion = descripcion;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
	
}
