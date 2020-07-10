package net.dex.javawebapp.webapp;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MÉTODO HOME PAGE SERVLET - POST");
		RequestDispatcher dispatcher = req.getRequestDispatcher("clientes.jsp");
		dispatcher.forward(req, resp);
		//super.doPost(req, resp);
	}

}
