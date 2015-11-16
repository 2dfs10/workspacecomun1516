<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%
	Connection conexion = null;
			try {

			// Cargar y registrar el controlador JDBC
			String controlador = "com.mysql.jdbc.Driver";
			Class.forName(controlador).newInstance();
			// Conectar con la fuente de datos
			conexion = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/productos", "root", "");
		
		} catch (ClassNotFoundException e) {
			System.out.println("No se pudo cargar el controlador: "
					+ e.getMessage());
		} catch (SQLException e) {
			System.out.println("Excepción SQL: " + e.getMessage());
		} catch (InstantiationException e) {
			System.out.println("Objeto no creado. " + e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println("Acceso ilegal. " + e.getMessage());
		}
	%>

</body>
</html>