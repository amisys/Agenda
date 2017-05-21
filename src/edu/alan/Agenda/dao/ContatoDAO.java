package edu.alan.Agenda.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.alan.Agenda.model.Contato;
import edu.alan.Agenda.util.DBConn;

public class ContatoDAO implements GenericDAO<Contato>{
	
	Session db = null;
	
	public ContatoDAO() {
		db = new DBConn().createSession();
	}

	@Override
	public Contato get(int id) {
		Contato contato = (Contato) db.load(Contato.class, id);
		return contato;
	}

	@Override
	public void delete(Contato entity) {
		Transaction tx = db.beginTransaction();
		Contato contato = (Contato) db.load(Contato.class, entity.get_idcontatos());
		db.delete(contato);
		tx.commit();
	}

	@Override
	public void update(Contato entity) {
		Transaction tx = db.beginTransaction();
		Contato contato = (Contato) db.load(Contato.class, entity.get_idcontatos());
		contato.set_cep(entity.get_cep());
		contato.set_cidade(entity.get_cidade());
		contato.set_endereco(entity.get_endereco());
		contato.set_estado(entity.get_estado());
		contato.set_nome(entity.get_nome());
		contato.set_telefone_1(entity.get_telefone_1());
		contato.set_telefone_2(entity.get_telefone_2());
		tx.commit();
	}

	@Override
	public void create(Contato entity) {
		Transaction tx = db.beginTransaction();
		db.save(entity);
		tx.commit();
	}
	
	public void finish() {
		db.close();
	}

}
