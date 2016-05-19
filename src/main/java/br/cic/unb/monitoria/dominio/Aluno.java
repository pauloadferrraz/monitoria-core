package br.cic.unb.monitoria.dominio;

public class Aluno {

	private String matricula;
	private String nome;
	private double ira;
	private String senha;
	
	public Aluno(String matricula, String nome, double ira, String senha) {
		this.matricula = matricula;
		this.nome = nome;
		this.ira = ira;
		this.senha = senha;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getIra() {
		return ira;
	}

	public void setIra(double ira) {
		this.ira = ira;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
