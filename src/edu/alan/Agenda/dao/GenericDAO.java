package edu.alan.Agenda.dao;

public interface GenericDAO<D> {

    public D get(int id);

    public void delete(D entity);

    public void update(D entity);

    public void create(D entity);
	
}
