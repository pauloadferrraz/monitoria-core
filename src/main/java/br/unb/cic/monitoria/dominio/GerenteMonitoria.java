package br.unb.cic.monitoria.dominio;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.monitoria.util.HibernateUtil;

public class GerenteMonitoria {

	public Integer solicitarPedido(String idAluno, String idTurma, String opcao) {
		EntityManager em = HibernateUtil.instance().em();

		Aluno aluno = em.find(Aluno.class, idAluno);
		// Oferta oferta = em.find(Oferta.class, idTurma)

		// deve retornar o ID do pedido de monitoria.
		return 123;
	}

	public List<Monitoria> listarMonitoria(String turma) {
		EntityManager em = HibernateUtil.instance().em();
		return em.createQuery("SELECT o FROM Monitoria o WHERE o.COD_TURMA = :pturma").setParameter("pturma", turma)
				.getResultList();
	}

	public void atualizaMonitoria(Monitoria monitoria) {
		EntityManager em = HibernateUtil.instance().em();
		em.merge(monitoria);
	}

}
