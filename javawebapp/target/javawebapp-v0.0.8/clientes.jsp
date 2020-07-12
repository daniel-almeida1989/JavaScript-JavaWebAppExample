<%--
The dynamic webpage for the Clientes registration, exclusion and modification.
--%>
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
          location.href="clientes?i=" + indice + "&acao=del";
        }
      }
      function editar(indice)
      {
        location.href="clientes?i=" + indice + "&acao=edit";
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
          String ind = "";
          String cli = (String) request.getAttribute("cli");
          if (cli != "")
          {
            System.out.println(cli);
            ind = (String) request.getAttribute("ind");
          }
        %>
      </div>
      <h1>Cliente</h1>
      <form method="post" action="clientes">
        <input type="hidden" value="<%=ind %>" name="ind">
        e-mail:
        <input type="text" value="<%=cli %>" name="email">
        <input type="submit" value="Enviar"><br>
      </form>
      <table border="1">
      <%
        List<Cliente> lista = (List<Cliente>)request.getAttribute("reqLista");
        int i = 0;
        if (!lista.isEmpty())
        {
          %>
            <tr>
              <th>E-mail</th><th>Ação</th>
            </tr>
          <%
        }
        for (Cliente c: lista)
        {
      %>
      <tr>
        <td><%=c.getEmail()%></td><td><a href='javascript:editar(<%=i%>)'>editar</a> | <a href='javascript:confirmar(<%=i%>)'>excluir</a></td>
      </tr>
      <%
          i++;
        }
      %>
      </table>
    </body>
</html>