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
    String i = req.getParameter("i");
    RequestDispatcher dispatcher = req.getRequestDispatcher("clientes.jsp");
    if ((i!="" ) && (i!= null))
    {
      clienteService.excluir(Integer.parseInt(i));
      req.setAttribute("msg", "Removido com sucesso!");
    }
    req.setAttribute("reqLista", clienteService.getClientes());
    dispatcher.forward(req, resp);

    //super.doGet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    System.out.println("MÉTODO POST");

    Cliente cli = new Cliente();
    String email = req.getParameter("email");
    cli.setEmail(email);
    clienteService.cadastrar(cli);
    RequestDispatcher dispatcher = req.getRequestDispatcher("clientes.jsp");
    req.setAttribute("msg", "Cadastrado com sucesso!");
    req.setAttribute("reqLista", clienteService.getClientes());
    dispatcher.forward(req, resp);

    resp.sendRedirect("clientes");
    //resp.setContentType("text/html;charset=UTF-8");
    //resp.getWriter().print("Chamou pelo método POST enviando email: \"" + email + "\"");
    //super.doPost(req, resp);
  }

}
