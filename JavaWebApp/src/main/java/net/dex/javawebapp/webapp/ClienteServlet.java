package net.dex.javawebapp.webapp;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.dex.javawebapp.model.Cliente;


@WebServlet(urlPatterns = {"/clientes"})
public class ClienteServlet extends HttpServlet
{
	List<Cliente> lista = new ArrayList<>();

	@Override
	public void init() throws ServletException
	{
		System.out.println("INICIALIZANDO SERVLET...");
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
		RequestDispatcher dispatcher = req.getRequestDispatcher("clientes.jsp");
		req.setAttribute("reqLista", lista);
		dispatcher.forward(req, resp);
		//super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MÉTODO POST");

		String email = req.getParameter("email");
		Cliente cli = new Cliente();
		cli.setEmail(email);
		lista.add(cli);
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().print("Chamou pelo método POST enviando email: \"" + email + "\"");
		//super.doPost(req, resp);
	}

}
