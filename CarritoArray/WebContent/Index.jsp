<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ include file="Conexion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		try {
					
			ResultSet cdr = null;
			Statement sentenciaSQL = null;
			// Crear una sentencia SQL
			sentenciaSQL = conexion.createStatement();
			String OrdenSQL = "Select * from producto";
			cdr = sentenciaSQL.executeQuery(OrdenSQL);
			
			if(cdr.next()){
				out.print("<table border='1'><tr><th>Id producto</th><th>Descripcion</th><th>PVP</th></tr>");
				cdr.beforeFirst();
				while (cdr.next()) {
		
				out.println("<tr><form action='anadir.jsp' method='post' ENCTYPE='text/html'><td><input type='hidden' name='id' value='"+cdr.getString("idproducto")+"-"+ cdr.getString("descripcion")+"-"+ cdr.getString("pvpneto")+"'>"+ cdr.getString("idproducto")+ "</td><td>"+ cdr.getString("descripcion")+ "</td><td>"+ cdr.getString("pvpneto")+ "</td><td><input type='submit' name='id' value='Añadir carrito'/></form></td></tr>");
				}
				out.println("</table><form action='carrito.jsp' method='post' ENCTYPE='text/html'><input type='submit' name='id' value='Comprar el carrito'/></form>");
			}else{
				out.println("datos incorrectos o no existen<br><br>");				
			}
			
		} catch (SQLException e) {
			out.println("Excepción SQL: " + e.getMessage());
		}
	%>
</body>
</html>