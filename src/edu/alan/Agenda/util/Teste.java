package edu.alan.Agenda.util;

import edu.alan.Agenda.dao.UsuarioDAO;
import edu.alan.Agenda.model.Usuario;

public class Teste {

	public static void main(String[] args) {
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario user = new Usuario();
		user.set_username("alan");
		user.set_user_type(01);
		user.set_password("teste123");
		user.set_id_contato_user(12);
		dao.create(user);
		
		
		System.out.println("Pronto.");
		
	}
	
}
