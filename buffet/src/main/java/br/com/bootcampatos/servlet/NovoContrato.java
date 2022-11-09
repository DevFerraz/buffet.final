package br.com.bootcampatos.servlet;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/novoContrato")
public class NovoContrato extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDao(JPAUtil.getEntityManager()).getAll();

        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("/front/orcamento.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long clienteById = Long.parseLong(request.getParameter("clienteById"));
        Boolean isWithDessert = Boolean.valueOf(request.getParameter("isWithDessert"));
        Integer qtdConvidados = Integer.valueOf(request.getParameter("qtdConvidados"));

        
		ContratoDao contratoDao = new ContratoDao(JPAUtil.getEntityManager());
		
		
		
		request.setAttribute("mensagem", "Orçamento cadastrado com sucesso!");
		request.getRequestDispatcher("/front/index.jsp").forward(request, response);
		
        Cliente cliente = new ClienteDao(JPAUtil.getEntityManager()).findById(clienteById);
        Contrato contrato = new Contrato(qtdConvidados, isWithDessert, cliente);

        contratoDao.insert(contrato);
        
        request.setAttribute("contrato", contrato);

        request.getRequestDispatcher("/front/proposta_comercial.jsp")
                .forward(request, response);
    }
}
