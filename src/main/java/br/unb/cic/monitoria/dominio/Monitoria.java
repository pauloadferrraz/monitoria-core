package br.unb.cic.monitoria.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MONITORIA")
public class Monitoria {

	@Id
	@GeneratedValue
	private String id;
	@Column(name = "NR_MATRICULA")
	private String matricula;
	@Column(name = "COD_DISCIPLICA")
	private String codDisciplina;
	@Column(name = "COD_TURMA")
	private String codTurma;
	@Column
	private String status;
	@Column
	private String dataSolicitacao;
	@Column
	private String prioridade;
	@Column
	private String opcao;

	public Monitoria() {

	}

	public Monitoria(String id, String matricula, String codDisciplina, String codTurma, String status,
			String dataSolicitacao, String prioridade, String opcao) {
		this.id = id;
		this.matricula = matricula;
		this.codDisciplina = codDisciplina;
		this.codTurma = codTurma;
		this.status = status;
		this.dataSolicitacao = dataSolicitacao;
		this.prioridade = prioridade;
		this.opcao = opcao;
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getCodTurma() {
		return codTurma;
	}

	public void setCodTurma(String codTurma) {
		this.codTurma = codTurma;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(String dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

}
