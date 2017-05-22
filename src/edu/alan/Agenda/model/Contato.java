package edu.alan.Agenda.model;

import javax.persistence.*;

@Entity
@Table(name="contatos")
public class Contato {

	@Id
	@Column(name="idcontatos")
	private int _idcontatos;
	
	@Column(name="nome")
	private String _nome;
	
	@Column(name="telefone_1")
	private String _telefone_1;
	
	@Column(name="telefone_2")
	private String _telefone_2;
	
	@Column(name="endereco")
	private String _endereco;
	
	@Column(name="cidade")
	private String _cidade;
	
	@Column(name="estado")
	private String _estado;
	
	@Column(name="cep")
	private String _cep;
	
	public Contato() {
		super();
	}

	public Contato(String _nome, String _telefone_1, String _telefone_2, String _endereco,
			String _cidade, String _estado, String _cep) {
		super();
		this._nome = _nome;
		this._telefone_1 = _telefone_1;
		this._telefone_2 = _telefone_2;
		this._endereco = _endereco;
		this._cidade = _cidade;
		this._estado = _estado;
		this._cep = _cep;
	}

	public int get_idcontatos() {
		return _idcontatos;
	}

	public void set_idcontatos(int _idcontatos) {
		this._idcontatos = _idcontatos;
	}

	public String get_nome() {
		return _nome;
	}

	public void set_nome(String _nome) {
		this._nome = _nome;
	}

	public String get_telefone_1() {
		return _telefone_1;
	}

	public void set_telefone_1(String _telefone_1) {
		this._telefone_1 = _telefone_1;
	}

	public String get_telefone_2() {
		return _telefone_2;
	}

	public void set_telefone_2(String _telefone_2) {
		this._telefone_2 = _telefone_2;
	}

	public String get_endereco() {
		return _endereco;
	}

	public void set_endereco(String _endereco) {
		this._endereco = _endereco;
	}

	public String get_cidade() {
		return _cidade;
	}

	public void set_cidade(String _cidade) {
		this._cidade = _cidade;
	}

	public String get_estado() {
		return _estado;
	}

	public void set_estado(String _estado) {
		this._estado = _estado;
	}

	public String get_cep() {
		return _cep;
	}

	public void set_cep(String _cep) {
		this._cep = _cep;
	}
	
}
