 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%> 
	
	
	
<%@ page import="paquete.Carrito"%>
<%@ include file="Conexion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resumen de la Compra</title>
<body>


	<%
		int total = 0;
		HttpSession sesionCli = request.getSession();

		Carrito c = (Carrito) sesionCli.getAttribute("cesta");

		Double sum = 0.0;
		// leemos los atributos de la sesion
		// Obtener la sesión actual; crear una si fuera necesario.

		// Datos de la sesión
		//String idSesion = sesionCli.getId();
		
		Statement sentenciaSQL = null;
			// Crear una sentencia SQL
		sentenciaSQL = conexion.createStatement();
		Enumeration nombresParams = sesionCli.getAttributeNames();

		String libros = c.getCarro();
		String [] todo = libros.split("/");
		for (int i = 0; i < todo.length; i++) {
			String [] producto = todo[i].split("-");
			out.println("<p>Id:" + producto[0] + "<p><p>Descripcion:" + producto[1] + "<p><p>PVP:" + producto[2] + "<p>");
			String OrdenSQL = "insert into carrito (idproducto, descripcion, pvpneto) values ("+producto[0]+", '"+producto[1]+"',"+producto[2]+")";
			total = total + Integer.parseInt(producto[2]);		
			try {
				
				sentenciaSQL.execute(OrdenSQL);	
				out.println("TOTAL : "+total);
				
			} catch (SQLException e) {
				out.println("Excepción SQL: " + e.getMessage());
			}
		}

		
	%>
</body>
</html>