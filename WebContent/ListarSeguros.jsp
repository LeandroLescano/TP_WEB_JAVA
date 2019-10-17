<%@page import="Dominio.Seguro" %>
<%@page import="Dominio.TipoSeguro" %>
<%@page import="Negocio.SeguroNegocio" %>
<%@page import="Negocio.TipoSeguroNegocio" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seguros group</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body class="Formulario">
<div class="topnav">
  <a href="./Inicio.jsp">Inicio</a>
  <a href="./AgregarSeguro.jsp">Agregar seguro</a>
  <a class="active" href="./ListarSeguros.jsp">Listar seguros</a>
</div>

<div class="container body-content bg-light">
<h2>Listado de seguros</h2>
<form method="post" action="servletSeguro">
<div style="color: black; margin: 15px 10px 25px 0px; float: left;">Busqueda por tipo de Seguro:</div><select name="tipos" class="custom-select" style="width: 200px; margin-top: 8px;">
	 		 	<option value="0">Todos</option> 
	 		 	<% 
	 		 	  TipoSeguroNegocio negocioT = new TipoSeguroNegocio();
				   ArrayList<TipoSeguro> tipos = negocioT.listarSeguros();
				   for (TipoSeguro ts : tipos)
				   {
				   		%><option value="<%= ts.getID()%>"> <%= ts.getDescripcion() %> </option>
				   		<% 
				   }	 		 	
				   		%>
	 			 </select>
	 			 <input type="submit" class="btn btn-success" style="background-color: #4CAF50; margin-top: 8px;" value="Filtrar" name="btnActualizar" id="btnActualizar">
    <table id="Gridview" class="table table-hover">
        <thead class="thead-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Descripción</th>
                <th scope="col">Tipo de seguro</th>
                <th scope="col">Costo de contratación</th>
                <th scope="col">Costo máximo asegurado</th>
            </tr>
        </thead>
        <tbody id="grilla">
			<%
				String lista = null;
				if(request.getAttribute("tablaSeguro") != null)
				{
					lista = (String)request.getAttribute("tablaSeguro");			
				}
				else
				{
					SeguroNegocio negocioS = new SeguroNegocio();
					ArrayList<Seguro> listado = negocioS.listarSeguros();
					for(Seguro s : listado)
					{
					   %>
					   <tr>
					   	<th class='thID' scope='row'><%= s.getID() %> </th>
					   <td class ='tdDesc'><%= s.getDescripcion() %> </td>
					   <td class="align-middle"><%= s.getTipo().getDescripcion() %> </td>
					   <td class="align-middle">$<%= s.getCostoContratacion() %> </td>
					   <td class="align-middle">$<%= s.getCostoAsegurado() %> </td>				
					   </tr>
					   <%
					}				
				}
				
			 %>
			 <% if(lista != null)
			 {%> 
				<%= lista %>
			 <% }
			 		%>
			
        </tbody>
    </table>
		<!--<input type="submit" hidden name="btnActualizar" id="btnActualizar">-->
	</form>
</div>
</body>


<script type="text/javascript">
	 <%if(request.getAttribute("IDTipo") != null)
		{
 			int IDT = (int)request.getAttribute("IDTipo");%>
			$('select').val(<%=IDT%>);
		<%}
	%>
	
	//$('select').on('change', function() {
	//	$(btnActualizar).click();
 	//});
</script>	
</html>