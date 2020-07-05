package net.dex.webapplication;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Daniel Almeida
 */
@WebServlet(urlPatterns={"/"})
public class WebAppServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res)
  {
    System.out.println("Chamou pelo método Get!");
  }
}
