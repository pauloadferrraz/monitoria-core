package br.unb.cic.monitoria.dominio;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.monitoria.util.HibernateUtil;

public class GerenteMonitoria {

	public Integer solicitarPedido(Aluno Aluno, Oferta oferta, String tipo) {
		EntityManager em = HibernateUtil.instance().em();

		Aluno aluno = em.find(Aluno.class, Aluno);
		// Oferta oferta = em.find(Oferta.class, idTurma)

		// deve retornar o ID do pedido de monitoria.
		return 123;
	}

	public List<Monitoria> listarMonitoria(String turma) {

		EntityManager em = HibernateUtil.instance().em();

		return em
				.createQuery("SELECT m FROM Monitoria m INNER JOIN Oferta o ON "
						+ "	m.CD_OFERTA = o.CD_OFERTA WHERE o.OFERTA = :pturma")
				.setParameter("pturma", turma).getResultList();
	}

	public void atualizaMonitoria(Monitoria monitoria) {
		EntityManager em = HibernateUtil.instance().em();
		em.merge(monitoria);
	}

}
