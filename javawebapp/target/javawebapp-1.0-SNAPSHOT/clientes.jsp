<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastro de Clientes</title>
	</head>
	<body>
		<h1>Cliente</h1>
		<form method="post" action="clientes">
			e-mail:
			<input type="text" value="" name="email">
			<input type="submit" value="Enviar">
		</form>
                <%--
                <%
                  List<Cliente> saídaLista = (List<Cliente>)request.getAttribute("reqLista");
                  for (Cliente c: saídaLista)
                  {
                    
                  }
                %>
                --%>
                </body>
</html>