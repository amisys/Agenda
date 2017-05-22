package edu.alan.Agenda.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.alan.Agenda.dao.ContatoDAO;
import edu.alan.Agenda.dao.UsuarioDAO;
import edu.alan.Agenda.model.Contato;
import edu.alan.Agenda.model.Usuario;

public class AgendaServlet extends HttpServlet {

	private static final long serialVersionUID = -2756896413585846084L;
	
	private ContatoDAO cdao = new ContatoDAO();
	private UsuarioDAO udao = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        if (request.getParameter("login") != null) {
        	Usuario postUser = udao.findByUsername(request.getParameter("username"));
        	RequestDispatcher rd = null;
        	if (postUser.get_username().equals(request.getParameter("username"))) {
        		if (postUser.get_password().equals(request.getParameter("password"))) {
        			Cookie loginCookie = new Cookie("user", postUser.get_username());
        			loginCookie.setMaxAge(30*60);
        			response.addCookie(loginCookie);
        			List<Contato> contatos = new ArrayList();
        			contatos = cdao.showAll();
        			request.setAttribute("listaContatos", contatos);
        			rd = request.getRequestDispatcher("agendaView.jsp");
        		} else {
        			rd = request.getRequestDispatcher("erro.jsp");
        		}
        	} else {
    			rd = request.getRequestDispatcher("erro.jsp");
        	}
            rd.forward(request, response);
        }
        
        if (request.getParameter("logout") != null) {
        	Cookie loginCookie = null;
        	Cookie[] cookies = request.getCookies();
        	if(cookies != null){
        		for(Cookie cookie : cookies) {
        			if(cookie.getName().equals("user")) {
        				loginCookie = cookie;
        				break;
        			}
        		}
        	}
        	if(loginCookie != null){
        		loginCookie.setMaxAge(0);
            	response.addCookie(loginCookie);
        	}
        	response.sendRedirect("index.html");
        }
        
        if (request.getParameter("createContato") != null) {
        	RequestDispatcher rd = null;
        	Contato contato = new Contato(
        			request.getParameter("nome"),
        			request.getParameter("telefone1"),
        			request.getParameter("telefone2"),
        			request.getParameter("endereco"),
        			request.getParameter("cidade"),
        			request.getParameter("estado"),
        			request.getParameter("cep")
        			);
        	cdao.create(contato);
			List<Contato> contatos = new ArrayList();
			contatos = cdao.showAll();
			request.setAttribute("listaContatos", contatos);
			rd = request.getRequestDispatcher("agendaView.jsp");
            rd.forward(request, response);
        }
        
        if (request.getParameter("delete") != null) {
        	RequestDispatcher rd = null;
        	int id = Integer.parseInt(request.getParameter("iddel"));
        	Contato contato = cdao.get(id);
        	cdao.delete(contato);
			List<Contato> contatos = new ArrayList();
			contatos = cdao.showAll();
			request.setAttribute("listaContatos", contatos);
			rd = request.getRequestDispatcher("agendaView.jsp");
            rd.forward(request, response);
        }
        
        if (request.getParameter("updateContato") != null) {
        	RequestDispatcher rd = null;
        	int id = Integer.parseInt(request.getParameter("idupdreq"));
        	Contato contato = cdao.get(id);
        	contato.set_cep(request.getParameter("cep"));
        	contato.set_cidade(request.getParameter("cidade"));
        	contato.set_endereco(request.getParameter("endereco"));
        	contato.set_estado(request.getParameter("estado"));
        	contato.set_nome(request.getParameter("nome"));
        	contato.set_telefone_1(request.getParameter("telefone1"));
        	contato.set_telefone_2(request.getParameter("telefone2"));
        	cdao.update(contato);
			List<Contato> contatos = new ArrayList();
			contatos = cdao.showAll();
			request.setAttribute("listaContatos", contatos);
			rd = request.getRequestDispatcher("agendaView.jsp");
            rd.forward(request, response);
        }
        
        if (request.getParameter("update") != null) {
        	RequestDispatcher rd = null;
        	int id = Integer.parseInt(request.getParameter("idupd"));
        	Contato contato = cdao.get(id);
        	request.setAttribute("update", "1");
        	request.setAttribute("nome", contato.get_nome());
        	request.setAttribute("endereco", contato.get_endereco());
        	request.setAttribute("cidade", contato.get_cidade());
        	request.setAttribute("estado", contato.get_estado());
        	request.setAttribute("cep", contato.get_cep());
        	request.setAttribute("telefone_1", contato.get_telefone_1());
        	request.setAttribute("telefone_2", contato.get_telefone_2());
			List<Contato> contatos = new ArrayList();
			contatos = cdao.showAll();
			request.setAttribute("listaContatos", contatos);
			request.setAttribute("idupdresp", request.getParameter("idupd"));
			rd = request.getRequestDispatcher("agendaView.jsp");
            rd.forward(request, response);
        }
        
    }
	
}
