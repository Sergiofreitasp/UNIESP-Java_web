package br.com.projeto.empresa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projeto.empresa.model.Empresa;
import br.com.projeto.empresa.model.Usuario;

/**
 * Servlet implementation class EmpresaController
 */
@WebServlet("/EmpresaController")
public class EmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Empresa empresa;
	
	public EmpresaController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario u1 = new Usuario();
		u1.setEmail(email);
		u1.setSenha(senha);
		
		
		if(u1.getEmail().equals("me") && u1.getSenha().equals("1234")) {
			
			HttpSession sessao = request.getSession();
			sessao.setAttribute("u1", u1);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else {
			response.sendRedirect("login.jsp");
		}

	}

}
