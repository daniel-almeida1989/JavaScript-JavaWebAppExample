<%@page import="net.dex.javawebapp.model.Cliente"%>
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
      <div>
        <%
          Object mess = request.getAttribute("msg");
          if (mess!= null)
          {
            String msgStr = (String)mess;
            out.print(msgStr);
          }
        %>
      </div>
      <h1>Cliente</h1>
      <form method="post" action="clientes">
        e-mail:
        <input type="text" value="" name="email">
        <input type="submit" value="Enviar">
      </form>
      <%
        List<Cliente> lista = (List<Cliente>)request.getAttribute("reqLista");
        int i = 0;
        for (Cliente c: lista)
        {
          out.print(c.getEmail() + "<a href='clientes?i="+ i +"'> excluir </a><br/>");
          i++;
        }
      %>
    </body>
</html>