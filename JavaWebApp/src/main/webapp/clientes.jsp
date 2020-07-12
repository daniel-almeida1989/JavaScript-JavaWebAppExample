<%@page import="net.dex.javawebapp.model.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Cadastro de Clientes</title>
    <script>
      function confirmar(indice)
      {
        if (window.confirm("Tem certeza que deseja excluir o e-mail cadastrado?"))
        {
          location.href="clientes?i=" + indice;
        }
      }
    </script>
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
          String emailCli = "";
          Integer ind = 0;
          Cliente cli = (Cliente) request.getAttribute("cli");
          if (cli != null)
          {
            emailCli = cli.getEmail();
            ind = (Integer) request.getAttribute("ind");
          }
        %>
      </div>
      <h1>Cliente</h1>
      <form method="post" action="clientes">
        <input type="hidden" value="<%=ind %>" name="ind">
        e-mail:
        <input type="text" value="<%=emailCli %>" name="email">
        <input type="submit" value="Enviar">
      </form>
      <%
        List<Cliente> lista = (List<Cliente>)request.getAttribute("reqLista");
        int i = 0;
        for (Cliente c: lista)
        {
          out.print(c.getEmail());
          out.print("<a href='cliente?=" + i + "'> editar </a> | ");
          out.print("<a href='javascript:confirmar("+ i +")'> excluir </a><br/>");
          i++;
        }
      %>
    </body>
</html>