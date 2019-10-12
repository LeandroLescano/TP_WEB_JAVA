package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Seguro;
import Dominio.TipoSeguro;
import Negocio.SeguroNegocio;
import Negocio.TipoSeguroNegocio;

/**
 * Servlet implementation class servletSeguro
 */
@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("btnAgregar") != null)
		 {
		 	SeguroNegocio negocioS = new SeguroNegocio();
		 	Seguro nuevo = new Seguro();
		 	TipoSeguro tipo = new TipoSeguro();
		 	nuevo.setDescripcion(request.getParameter("txtDescripcion"));
		 	//Validar que vengan con punto y no coma
		 	nuevo.setCostoContratacion(Float.parseFloat(request.getParameter("txtCostoContratacion")));
		 	nuevo.setCostoAsegurado(Float.parseFloat(request.getParameter("txtCostoAsegurado")));
		 	tipo.setID(Integer.parseInt(request.getParameter("tipos")));
		 	nuevo.setTipo(tipo);
		 	negocioS.agregarSeguro(nuevo);
		 }
		 
		 RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");		 
		 rd.forward(request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnActualizar") != null)
		{			
			SeguroNegocio negocioS = new SeguroNegocio();
			ArrayList<Seguro> listado = negocioS.listarSeguros();
			TipoSeguroNegocio negocioT = new TipoSeguroNegocio(); 
			
			String tabla ="";
			int Tipo = Integer.parseInt(request.getParameter("tipos"));
			for(Seguro s : listado)
			{
				if(Tipo == s.getTipo().getID() || Tipo == 0)
				{
				   tabla += "<tr>" + 
				   	"<th class='thID' scope='row'>" + s.getID() + "</th>" + 
				   "<td class ='tdDesc'>" + s.getDescripcion()  + "</td>" + 
				   "<td class='align-middle'>" + s.getTipo().getDescripcion()  + "</td>" + 
				   "<td class='align-middle'>"  + s.getCostoContratacion()  + "</td>" + 
				   "<td class='align-middle'>" +  s.getCostoAsegurado()  + "</td>" + 				
				   "</tr>";
				}
			}	
			
			if(Tipo != 0)
			{
				request.setAttribute("IDTipo", Tipo);
				request.setAttribute("DescTipo", negocioT.obtenerTipo(Tipo));
			}
			request.setAttribute("tablaSeguro", tabla);
		} 
		
		 RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");		 
		 rd.forward(request, response);
		 
		
	}

}
