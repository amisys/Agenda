package edu.alan.Agenda.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.alan.Agenda.dao.ContatoDAO;
import edu.alan.Agenda.dao.UsuarioDAO;
import edu.alan.Agenda.model.Usuario;

public class AgendaServlet extends HttpServlet {

	private static final long serialVersionUID = -2756896413585846084L;
	
	private ContatoDAO cdao = new ContatoDAO();
	private UsuarioDAO udao = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        if (request.getParameter("login") != null) {
        	Usuario postUser = udao.findByUsername(request.getParameter("username"));
        	RequestDispatcher rd = null;
        	if (postUser.get_username().equals(request.getParameter("username"))) {
        		if (postUser.get_password().equals(request.getParameter("password"))) {
        			rd = request.getRequestDispatcher("resp.html");
        		} else {
        			rd = request.getRequestDispatcher("erro.jsp");
        		}
        	} else {
    			rd = request.getRequestDispatcher("erro.jsp");
        	}
            rd.forward(request, response);
        }
        
    }
	
}
