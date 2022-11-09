package br.com.bootcampatos.servlet;

import br.com.bootcampatos.dao.ContratoDao;
import br.com.bootcampatos.dao.DAO;
import br.com.bootcampatos.model.Contrato;
import br.com.bootcampatos.util.JPAUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.jar.JarEntry;

@WebServlet("/mostraContrato")
public class MostraContrato extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Long contratoId = Long.parseLong(request.getParameter("id"));
        ContratoDao dao = new ContratoDao(JPAUtil.getEntityManager());
        Contrato contrato = dao.findById(contratoId);

        request.setAttribute("contrato", contrato);

        request.getRequestDispatcher("/front/proposta_comercial.jsp")
                .forward(request, response);
    }
}
