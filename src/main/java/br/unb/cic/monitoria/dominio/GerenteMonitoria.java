package br.unb.cic.monitoria.dominio;

import javax.persistence.EntityManager;

import br.unb.cic.monitoria.util.HibernateUtil;


public class GerenteMonitoria {

	public Integer solicitarPedido(Integer idAluno, Integer idTurma, int opcao) {
		EntityManager em = HibernateUtil.instance().em();
		
		Aluno aluno   = em.find(Aluno.class, idAluno);
		//Oferta oferta = em.find(Oferta.class, idTurma)
		
		
		//deve retornar o ID do pedido de monitoria.
		return 123;
	}
}
