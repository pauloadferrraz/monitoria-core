package br.cic.unb.monitoria.dominio;

/**
 * Classe que representa uma oferta de uma disciplina.
 * 
 * @author rbonifacio
 */
public class Oferta {

	private int codigoDisciplina;
	private String turma;
	private String semestre;
	private String professor;
	private int quantidadeDeAlunos;
	
	
	public Oferta(int codigoDisciplina, String turma, String semestre,
			String professor, int quantidadeDeAlunos) {
		this.codigoDisciplina = codigoDisciplina;
		this.turma = turma;
		this.semestre = semestre;
		this.professor = professor;
		this.quantidadeDeAlunos = quantidadeDeAlunos;
	}

	public int getCodigoDisciplina() {
		return codigoDisciplina;
	}
	
	public void setCodigoDisciplina(int codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}
	
	public String getTurma() {
		return turma;
	}
	
	public void setTurma(String turma) {
		this.turma = turma;
	}
	
	
	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getProfessor() {
		return professor;
	}
	
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	public int getQuantidadeDeAlunos() {
		return quantidadeDeAlunos;
	}
	
	public void setQuantidadeDeAlunos(int quantidadeDeAlunos) {
		this.quantidadeDeAlunos = quantidadeDeAlunos;
	}
	
}
