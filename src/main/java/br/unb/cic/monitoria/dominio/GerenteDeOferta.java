package br.unb.cic.monitoria.dominio;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.monitoria.util.HibernateUtil;

public class GerenteDeOferta {

	public List<Oferta> listarOferta(Integer idDisciplina, Integer semestre) {
		EntityManager em = HibernateUtil.instance().em();
		return em.createQuery("SELECT o FROM Oferta o WHERE o.semestre = :pSemestre")
				.setParameter("pSemestre", semestre).getResultList();
	}

	
	public List<Oferta> listarOfertaTurma(String turma) {
		EntityManager em = HibernateUtil.instance().em();
		return em.createQuery("SELECT o FROM Oferta o WHERE o.turma = :pturma")
				.setParameter("pturma", turma).getResultList();
	}

}
