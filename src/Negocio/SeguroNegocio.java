package Negocio;

import Dominio.Seguro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import AccesoDatos.AccesoDatosManager;

public class SeguroNegocio {
	
	public boolean agregarSeguro(Seguro s) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		AccesoDatosManager accesoDatos = new AccesoDatosManager();
		String insertar = "INSERT INTO SEGUROS (DESCRIPCION, IDTIPO ,COSTOCONTRATACION, COSTOASEGURADO) VALUES ('"+s.getDescripcion()+"', "+ s.getTipo().getID() +" ," + s.getCostoContratacion()+ ", " + s.getCostoAsegurado() +")";
		if(accesoDatos.executeAccion(insertar) > 0)
		{
			return true;			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar el seguro.");
			return false;
		}
	}
	
	public ArrayList<Seguro> listarSeguros()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		ArrayList<Seguro> lista = new ArrayList<Seguro>();
		TipoSeguroNegocio negocioT = new TipoSeguroNegocio();
		AccesoDatosManager accesoDatos = new AccesoDatosManager();
		String listar = "SELECT * FROM SEGUROS";
		ResultSet rs = accesoDatos.executeConsulta(listar);
		try {
			while(rs.next())
			{
				Seguro s = new Seguro();
				s.setID(rs.getInt("idSeguro"));
				s.setDescripcion(rs.getString("descripcion"));
				s.setTipo(negocioT.obtenerTipo(rs.getInt("idTipo")));
				s.setCostoContratacion(rs.getInt("costoContratacion"));
				s.setCostoAsegurado(rs.getInt("costoAsegurado"));
				lista.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public int nuevoID()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		AccesoDatosManager accesoDatos = new AccesoDatosManager();
		String ID = "SELECT ifnull((MAX(idSeguro)+1),1) as nuevoID FROM SEGUROS";
		int nuevoID = 1; 
		ResultSet rs = accesoDatos.executeConsulta(ID);
		try {
			if(rs.next())	
			{
				nuevoID = rs.getInt("nuevoID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nuevoID;
	}	
}
