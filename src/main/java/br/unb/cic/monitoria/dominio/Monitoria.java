package br.unb.cic.monitoria.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MONITORIA")
public class Monitoria {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "CD_ALUNO")
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "CD_OFERTA")
	private Oferta oferta;

	@Column
	private Integer ranking;

	@Column
	private String tipo;

	@Column
	private String status;

	public Monitoria() {

	}

	public Monitoria(Integer id, Aluno aluno, Oferta oferta, Integer ranking, String tipo, String status) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.oferta = oferta;
		this.ranking = ranking;
		this.tipo = tipo;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
