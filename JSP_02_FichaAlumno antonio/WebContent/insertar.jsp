<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
		 import="database.*"
		 import="java.io.*"
		 import="java.util.*"
		 import="org.apache.commons.fileupload.*"
		 import="org.apache.commons.fileupload.disk.*"
		 import="org.apache.commons.fileupload.servlet.*"
%>
<%!	File file; %>
<% 
// 	System.out.println();
	response.setContentType("text/html");
	
	int maxFileSize = 5000 * 1024;
	int maxMemSize = 5000 * 1024;
	
	// Ruta donde guardar el archivo subido:
	// Usando un parametro de inicializacion (web.xml) 
		// ServletContext context = getServletContext();
		// String filePath = context.getInitParameter("file-upload");
	// Usando una ruta absoluta a un directorio local
		// String filePath = "D:\\prueba-jsp\\";
	// Usando una ruta absoluta hacia un directorio del proyecto (y tambien del servidor)
	ServletContext context = getServletContext();
	String filePath = context.getRealPath("/imagenes") + "\\";

	// Hashtable para guardar los campos del formulario
	Properties parametros = new Properties();
	
	// Objetos de commons.fileupload para parsear request y guardar el archivo
	DiskFileItemFactory factory = new DiskFileItemFactory();
	// maximum size that will be stored in memory
	factory.setSizeThreshold(maxMemSize);
	// Location to save data that is larger than maxMemSize.
	factory.setRepository(new File("c:\\temp"));
	
	// Create a new file upload handler
	ServletFileUpload upload = new ServletFileUpload(factory);
	// maximum file size to be uploaded
	upload.setSizeMax(maxFileSize);

	try {
		// Parse the request to get items (form fields and files)
		List<FileItem> items = upload.parseRequest(request);


		// Process the uploaded file items
		for (FileItem item : items) {
			// Process regular form field (input type="text|radio|checkbox|etc", select, etc)
			if (item.isFormField()) {
				String fieldName = item.getFieldName();
				String fieldValue = item.getString();
				
				if (fieldName.equals("asignaturas") && parametros.containsKey("asignaturas"))
					fieldValue = parametros.getProperty(fieldName) + " - " + fieldValue;

				parametros.setProperty(fieldName, fieldValue);
			}
			// Process form file field (input type="file")
			else {
				// Get the uploaded file parameters
				String fieldName = item.getFieldName();
				String fileName = item.getName();
				boolean isInMemory = item.isInMemory();
				long sizeInBytes = item.getSize();
				
				// Write the file
				if (fileName.lastIndexOf("\\") >= 0)
					file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
				else
					file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
				item.write(file);
			}
		}
		
	} catch (Exception ex) {
		System.out.println(ex);
	}
	
	// Insertar datos en la base de datos
	String sql = "INSERT INTO alumnos(apellidos, nombre, fecha, email, asignaturas, imagen) "
			   + "VALUES ('" + parametros.getProperty("apellidos") + "',"
			   + "'" + parametros.getProperty("nombre") + "',"
			   + "'" + parametros.getProperty("fecha") + "',"
			   + "'" + parametros.getProperty("mail") + "',"
			   + "'" + parametros.getProperty("asignaturas") + "',"
			   + "'" + file.getName() + "');";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP 02 - Ficha Alumno</title>
</head>

<body>
	<h2>Ficha Alumno</h2>
<%
	DB db = new DB();
	if (db.modify(sql)) {
%>
	<p><%= sql %></p>
	<p>Alumno insertado con éxito</p>
<%
	}
	else {
%>
	<p>No se ha podido realizar la operación</p>
<%		
	}
	db.close();
	response.setHeader("Refresh", "3;URL=index.html");
%>		
</body>
</html>
