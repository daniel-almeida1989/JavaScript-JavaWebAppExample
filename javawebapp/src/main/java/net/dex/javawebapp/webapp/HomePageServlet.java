package net.dex.javawebapp.webapp;
/**
 *
 * @author Daniel Augusto Monteiro de Almeida
 * @version v0.2.0-20200712-188
 */
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Servlet for the Home Page.
 */
@WebServlet(urlPatterns = {"/home", "/index", "/inicio"})
public class HomePageServlet extends HttpServlet
{

  @Override
  public void init() throws ServletException
  {
    System.out.println("INICIALIZANDO HOME PAGE SERVLET...");
    super.init();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    System.out.println("CHAMANDO HOME PAGE SERVICE...");
    super.service(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    System.out.println("MÉTODO HOME PAGE SERVLET - GET");
    RequestDispatcher dispatcher = req.getRequestDispatcher("clientes");
    dispatcher.forward(req, resp);
    //super.doGet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    System.out.println("MÉTODO HOME PAGE SERVLET - POST");
    //super.doPost(req, resp);
  }

}
