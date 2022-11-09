package br.com.bootcampatos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bootcampatos.dao.ClienteDao;
import br.com.bootcampatos.dao.ContratoDao;
import br.com.bootcampatos.model.Cliente;
import br.com.bootcampatos.model.Contrato;
import br.com.bootcampatos.util.JPAUtil;
import org.hibernate.annotations.Where;

/*
 * Servlet implementation class ListaClientes
 */
@WebServlet("/listaClientes")
public class ListaClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ClienteDao dao = new ClienteDao(JPAUtil.getEntityManager());
		List<Cliente> clientes = dao.getAll();
		

		
		RequestDispatcher rd = request.getRequestDispatcher("/front/consulta.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");

		ContratoDao dao = new ContratoDao(JPAUtil.getEntityManager());
		List<Contrato> contratos = dao.findByNome(nome);

		req.setAttribute("contratos", contratos);

		RequestDispatcher rd = req.getRequestDispatcher("/front/consulta.jsp");
		rd.forward(req, resp);
	}
}
