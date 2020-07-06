package javawebapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns={"/clientes", "/clientes.do"})
public class ClienteServlet extends HttpServlet
{
	
	public ClienteServlet() 
	{
		System.out.println("Construindo Servlet...");
	}
	
	@Override
	public void init() throws ServletException 
	{
		System.out.println("Inicializando Servlet...");
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("Chamando Service...");
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("Teste método GET");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("CHAMOU PELO MÉTODO GET");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email = req.getParameter("email");
		System.out.println("Teste método POST");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("CHAMOU PELO MÉTODO POST ENVIANDO E-MAIL " + email);
	}
}
