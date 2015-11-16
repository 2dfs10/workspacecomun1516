<%@page import="java.sql.ResultSet"%>
<%@page import="database.DB"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP 02 - Ficha Alumno</title>
	<style>
		h3 {margin: 20px 0 5px;}
		img {float: left; height: 100px;}
		table {float: left; display: inline-table;}
		div{overflow: auto};
/* 		.clear{clear: both}; */
	</style>
</head>

<body>
<%
DB db = new DB();
String sql = "SELECT * FROM alumnos;";
ResultSet results = db.query(sql);
int num = 0;

// Si no falla la consulta (por sintaxis, error de conexion...)
if (results != null) {
	// Si results contiene al menos una fila y el puntero está delante de la primera fila
	if (results.isBeforeFirst()) {
		while (results.next()) {
			num++;
			String apellidos = results.getString("apellidos");
			String nombre = results.getString("nombre");
			String fecha = results.getString("fecha");
			String email = results.getString("email");
			String asignaturas = results.getString("asignaturas");
			String imagen = results.getString("imagen");
%>
		<div>
			<h3>Ficha nº <%= num %></h3>
			<img alt="foto" src="imagenes/<%= imagen %>" />
			<table>
			  <tr>
			    <td>Alumno:</td>
			    <td><%= apellidos %>, <%= nombre %></td>
			  </tr>
			  <tr>
			    <td>Fecha de nacimiento:</td>
			    <td><%= fecha %></td>
			  </tr>
			  <tr>
			    <td>Correo electrónico:</td>
			    <td><%= email %></td>
			  </tr>
			  <tr>
			    <td>Asignaturas matriculadas:</td>
			    <td><%= asignaturas %></td>
			  </tr>
			</table>
		</div>
<!-- 		<div class="clear"></div> -->
<%
		}
	}
	else { // results está vacío
%>
		<p>No hay ningún alumno en la base de datos</p>
<%
	}
}	
else {
// Error de sintaxis, conexion, etc
%>

<p>Ha ocurrido un error</p>

<%
}
db.close();
%>
<br>
<a href="index.html">Volver</a>
	
</body>
</html>