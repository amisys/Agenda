package edu.alan.Agenda.model;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@Column(name="idusuarios")
	private int _idusuarios;
	
	@Column(name="username")
	private String _username;
	
	@Column(name="password")
	private String _password;
	
	@Column(name="user_type")
	private String _user_type;
	
	@Column(name="id_contato_user")
	private int _id_contato_user;
	
	public Usuario(int _idusuarios, String _username, String _password, String _user_type, int _id_contato_user) {
		super();
		this._idusuarios = _idusuarios;
		this._username = _username;
		this._password = _password;
		this._user_type = _user_type;
		this._id_contato_user = _id_contato_user;
	}

	public Usuario(){
		super();
	}
	
	public int get_idusuarios() {
		return _idusuarios;
	}

	public void set_idusuarios(int _idusuarios) {
		this._idusuarios = _idusuarios;
	}

	public String get_username() {
		return _username;
	}

	public void set_username(String _username) {
		this._username = _username;
	}

	public String get_password() {
		return _password;
	}

	public void set_password(String _password) {
		this._password = _password;
	}

	public String get_user_type() {
		return _user_type;
	}

	public void set_user_type(String _user_type) {
		this._user_type = _user_type;
	}

	public int get_id_contato_user() {
		return _id_contato_user;
	}

	public void set_id_contato_user(int _id_contato_user) {
		this._id_contato_user = _id_contato_user;
	}
	
	
}
