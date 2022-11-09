package br.com.bootcampatos.servlet;

import java.io.IOException;

import br.com.bootcampatos.dao.ClienteDao;
import br.com.bootcampatos.dao.DAO;
import br.com.bootcampatos.model.Cliente;
import br.com.bootcampatos.util.JPAUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet implementation class NovoCliente
 */
@WebServlet("/novoCliente")
public class NovoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramNome = request.getParameter("nome");
		String paramCpf = request.getParameter("cpf");
		String paramTelefone = request.getParameter("telefone");
		String paramEmail = request.getParameter("email");
		
		Cliente cliente = new Cliente(paramNome, paramCpf, paramTelefone,paramEmail);
		ClienteDao clienteDao = new ClienteDao(JPAUtil.getEntityManager());
		
		clienteDao.insert(cliente);
		
		request.setAttribute("mensagem", "Cliente cadastrado com sucesso!");
		request.getRequestDispatcher("/front/index.jsp").forward(request, response);
		//response.sendRedirect("front/index.jsp");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/front/cadastro.jsp")
				.forward(req, resp);
	}
}
