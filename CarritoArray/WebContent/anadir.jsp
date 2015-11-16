<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ page import="paquete.Carrito"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<br>

	<%
		Carrito c;

		String carro = request.getParameter("id");
		String [] todo = carro.split("-"); 	
			int precio = 0;

			// Obtener la sesión actual; crear una si fuera necesario.
			HttpSession sesionCli = request.getSession(true);

			if (sesionCli.getAttribute("cesta") != null) {

				c = (Carrito) sesionCli.getAttribute("cesta");
				c.setProducto(carro);
				
				sesionCli.setAttribute("cesta", c);
			} else {
				c = new Carrito();
				c.setProducto(carro);
				
				sesionCli.setAttribute("cesta", c);
			}

			out.print("El producto seleccionado es:<br>"+
			"Id producto:"+todo[0]+"<br>Descripcion: "+todo[1]+"<br>PVP :"+todo[2]);
			response.setHeader("Refresh","2;URL = Index.jsp");
	%>


</body>
</html>