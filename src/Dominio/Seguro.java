package Dominio;

public class Seguro {

	private int ID;
	private String Descripcion;
	private TipoSeguro Tipo;
	private float CostoContratacion;
	private float CostoAsegurado;
	
	public Seguro()
	{
		
	}	
	
	public Seguro(TipoSeguro tipo, float contratacion, float asegurado) {
		this.Tipo = tipo;
		this.CostoContratacion = contratacion;
		this.CostoAsegurado = asegurado;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public TipoSeguro getTipo() {
		return Tipo;
	}

	public void setTipo(TipoSeguro tipo) {
		Tipo = tipo;
	}

	public float getCostoContratacion() {
		return CostoContratacion;
	}

	public void setCostoContratacion(float costoContratacion) {
		CostoContratacion = costoContratacion;
	}

	public float getCostoAsegurado() {
		return CostoAsegurado;
	}

	public void setCostoAsegurado(float costoAsegurado) {
		CostoAsegurado = costoAsegurado;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}


	
}
