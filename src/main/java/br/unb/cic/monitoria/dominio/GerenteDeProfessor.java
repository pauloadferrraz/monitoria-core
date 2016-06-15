package br.unb.cic.monitoria.dominio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenteDeProfessor {

	private static final String CONSULTA_POR_MATRICULA = "select p from Professor p "
			+ "where p.matricula = :pmat";

	public GerenteDeProfessor() {
	}

	public Professor autenticar(String matricula, String senha) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("hsqldb");
		EntityManager manager = factory.createEntityManager();

		List<Professor> res = manager.createQuery(CONSULTA_POR_MATRICULA)
				.setParameter("pmat", matricula).getResultList();

		if (res.size() != 0 && res.get(0).getSenha().equals(senha)) {
			return res.get(0);
		}
		return null;

	}
}
