<%--
The dynamic webpage for the Clientes registration, exclusion and modification.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        ${requestScope.msg}
      </div>
      <h1>Cliente</h1>
      <form method="post" action="clientes">
        <input type="hidden" value="${requestScope.ind}" name="ind">
        e-mail:
        <input type="text" value="${requestScope.cli}" name="email">
        <input type="submit" value="Enviar"><br>
      </form>
      <table border="1">
        <c:choose>
          <c:when test="${requestScope.cli == ''}"></c:when>
          <c:otherwise>
            <tr>
              <th>E-mail</th><th>Ação</th>
            </tr>
          </c:otherwise>
        </c:choose>
        <c:set var="i" value="0"></c:set>
        <c:forEach items="${requestScope.reqLista}" var="c">
          <tr>
            <td>${c.email}</td><td><a href='javascript:editar(${i})'>editar</a> | <a href='javascript:confirmar(${i})'>excluir</a></td>
          </tr>
          <c:set var="i" value="${i+1}"></c:set>
        </c:forEach>
      </table>
    </body>
</html>