package net.dex.javawebapp.webapp;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.dex.javawebapp.model.Cliente;
import net.dex.javawebapp.service.ClienteService;

/**
 *
 * Servlet for Clientes page.
 */
@WebServlet(urlPatterns = {"/clientes"})
public class ClienteServlet extends HttpServlet
{

  ClienteService clienteService;

  @Override
  public void init() throws ServletException
  {
    System.out.println("INICIALIZANDO SERVLET...");
    clienteService = new ClienteService();
    super.init();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    System.out.println("CHAMANDO SERVICE...");
    super.service(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    System.out.println("MÉTODO POST");
    String i = req.getParameter("i");
    String acao = req.getParameter("acao");
    String cliOut = "";
    req.setAttribute("ind", i);
    if ((i!= null) && (!"".equals(i)))
    {
      if ("edit".equals(acao))
      {
        System.out.println("AÇÃO: " + acao);
        int indice = Integer.parseInt(i);
        Cliente cli = new Cliente();
        cli = clienteService.getUmCliente(indice);
        cliOut = cli.getEmail();
        req.setAttribute("acao", acao);
      }
      else if ("del".equals(acao))
      {
        System.out.println("AÇÃO: " + acao);
        clienteService.excluir(Integer.parseInt(i));
        req.setAttribute("msg", "Removido com sucesso!");
      }
    }
    req.setAttribute("cli", cliOut);
    req.setAttribute("reqLista", clienteService.getClientes());
    RequestDispatcher dispatcher = req.getRequestDispatcher("clientes.jsp");
    dispatcher.forward(req, resp);

    //super.doGet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    System.out.println("MÉTODO POST");

    Cliente cli = new Cliente();
    String email = req.getParameter("email");
    if ((email != null) && (!"".equals(email)))
    {
      cli.setEmail(email);
      String ind = req.getParameter("ind");
      if (!"".equals(ind))
      {
        int indexInd = Integer.parseInt(ind);
        clienteService.alterar(indexInd, cli);
        req.setAttribute("msg", "Editado com sucesso!");
      }
      else
      {
        clienteService.cadastrar(cli);
        req.setAttribute("msg", "Cadastrado com sucesso!");
      }
    }
    RequestDispatcher dispatcher = req.getRequestDispatcher("clientes.jsp");
    req.setAttribute("cli", "");
    req.setAttribute("reqLista", clienteService.getClientes());
    dispatcher.forward(req, resp);
    //resp.sendRedirect("clientes");
    //resp.setContentType("text/html;charset=UTF-8");
    //resp.getWriter().print("Chamou pelo método POST enviando email: \"" + email + "\"");
    //super.doPost(req, resp);
  }

}
