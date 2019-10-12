package Negocio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import AccesoDatos.AccesoDatosManager;
import Dominio.TipoSeguro;

public class TipoSeguroNegocio {

	
	public TipoSeguro obtenerTipo(int ID)
	{
		AccesoDatosManager accesoDatos = new AccesoDatosManager();
		String buscar = "SELECT * FROM TIPOSEGUROS WHERE IDTIPO = "+ ID;
		ResultSet rs = accesoDatos.executeConsulta(buscar);
		TipoSeguro tipo = new TipoSeguro();
		try {
			if(rs.next())
			{
				tipo.setID(ID);
				tipo.setDescripcion(rs.getString("Descripcion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tipo;
	}
	
	public ArrayList<TipoSeguro> listarSeguros()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		ArrayList<TipoSeguro> lista = new ArrayList<TipoSeguro>();
		AccesoDatosManager accesoDatos = new AccesoDatosManager();
		String listar = "SELECT * FROM TIPOSEGUROS";
		ResultSet rs = accesoDatos.executeConsulta(listar);
		try {
			while(rs.next())
			{
				TipoSeguro t = new TipoSeguro();
				t.setID(rs.getInt("idTipo"));
				t.setDescripcion(rs.getString("Descripcion"));
				lista.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return lista;
	}
	
}
