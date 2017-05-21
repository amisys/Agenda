package edu.alan.Agenda.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.alan.Agenda.model.Usuario;
import edu.alan.Agenda.util.DBConn;

public class UsuarioDAO implements GenericDAO<Usuario> {
	
	Session db = null;
	
	public UsuarioDAO() {
		super();
		db = new DBConn().createSession();
	}

	@Override
	public Usuario get(int id) {
		Usuario usuario = (Usuario) db.load(Usuario.class, id);
		return usuario;
	}

	@Override
	public void delete(Usuario entity) {
		Transaction tx = db.beginTransaction();
		Usuario usuario = (Usuario) db.load(Usuario.class, entity.get_idusuarios());
		db.delete(usuario);
		tx.commit();
	}

	@Override
	public void update(Usuario entity) {
		Transaction tx = db.beginTransaction();
		Usuario usuario = (Usuario) db.load(Usuario.class, entity.get_idusuarios());
		usuario.set_username(entity.get_username());
		usuario.set_user_type(entity.get_user_type());
		usuario.set_password(entity.get_password());
		usuario.set_id_contato_user(entity.get_id_contato_user());
		tx.commit();
	}

	@Override
	public void create(Usuario entity) {
		Transaction tx = db.beginTransaction();
		db.save(entity);
		tx.commit();
	}
	
	public Usuario findByUsername(String username) {
		  String hql = "from Usuario where username = :nome";
		  return (Usuario) db.createQuery(hql).setParameter("nome", username).uniqueResult();
		}
	
	public void finish() {
		db.close();
	}
	
}