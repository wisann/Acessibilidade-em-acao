package br.edu.model;

public class Reclamacao {
	private String nomeEscola;
	private String cep;
	private String endereco;
	private String cidade;
	private String bairro;
	private String uf;
	private int nota;
	private String reclamacao;

	
	public Reclamacao() {
		
	}

	public Reclamacao(String nomeEscola, String cep, String endereco, String cidade, String bairro, String uf, int nota, String reclamacao) {
		super();
		this.nomeEscola = nomeEscola;
		this.cep = cep;
		this.endereco = endereco;
		this.cidade = cidade;
		this.bairro = bairro;
		this.uf = uf;
		this.nota = nota;
		this.reclamacao = reclamacao;
	

	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getReclamacao() {
		return reclamacao;
	}

	public void setReclamacao(String reclamacao) {
		this.reclamacao = reclamacao;
	}


	
	}

