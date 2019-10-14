<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Dominio.Seguro" %>
<%@page import="Dominio.TipoSeguro" %>
<%@page import="Negocio.SeguroNegocio" %>
<%@page import="Negocio.TipoSeguroNegocio" %>
<%@page import="java.util.ArrayList" %>
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
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
</head>
<body class="Formulario">
<div class="topnav">
  <a href="./Inicio.jsp">Inicio</a>
  <a class="active" href="./AgregarSeguro.jsp">Agregar seguro</a>
  <a href="./ListarSeguros.jsp">Listar seguros</a>
</div>

<div class="container body-content bg-light">
<h2>Agregar seguros</h2>
	  <form id="FormAgregar" method="get" action="servletSeguro">
		  <p>ID Seguro: </p> 
		  <% SeguroNegocio negocioS = new SeguroNegocio(); 
		     int nuevoID = 1;
		  	 nuevoID = negocioS.nuevoID();	
		  %>   
		  <!--<input type="text" required name="txtID" value="<%=nuevoID %>" readonly style="width: 50px; text-align:center;"> SIN BOOTSTRAP-->
		  <input type="text" required name="txtID" value="<%=nuevoID %>" readonly class="form-control" style="width: 50px; text-align:center;">
		  <br>
		  <p>Descripción:</p> <input type="text" class="form-control" name="txtDescripcion" value="" style="width: 500px;">
		  <br>
		  <p>Tipo de seguro:</p> 
		 		 	<select name="tipos" class="custom-select" style="width: 200px; margin-bottom: 10px;">
		 		 	<% 
		 		 	  TipoSeguroNegocio negocioT = new TipoSeguroNegocio();
					   ArrayList<TipoSeguro> tipos = negocioT.listarSeguros();
					   for (TipoSeguro ts : tipos)
					   {
					   		%><option value="<%= ts.getID()%>"> <%= ts.getDescripcion() %> </option><%
					   }	 		 	
		 		 	%> 
		 			 </select>
		    <br>
		  <p>Costo contratación: $</p>   <input type="text" class="form-control" onkeypress='return event.charCode == 46 || (event.charCode >= 48 && event.charCode <= 57)' name="txtCostoContratacion" placeholder="1000.00" style="width: 150px;">
		    <br>
		  <p>Costo máximo asegurado: $</p>   <input type="text" class="form-control" onkeypress='return event.charCode == 46 || (event.charCode >= 48 && event.charCode <= 57)' name="txtCostoAsegurado" placeholder="25000.00" style="width: 150px;">
		    <br>  <br>
		  <button class="btn btn-success" style="background-color: #4CAF50" type="submit" name="btnAgregar">Agregar</button>
	  </form>
  </div>
</body>

</html>