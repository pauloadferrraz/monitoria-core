package br.cic.unb.monitoria.dominio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenteDeAluno {

	private static final String CONSULTA_POR_MATRICULA = "select a from Aluno a "
			+ "where a.matricula = :pmat";

	public GerenteDeAluno() {
	}

	public Aluno autenticar(String matricula, String senha) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();

		List<Aluno> res = manager.createQuery(CONSULTA_POR_MATRICULA)
				.setParameter("pmat", matricula).getResultList();

		if (res.size() != 0 && res.get(0).getSenha().equals(senha)) {
			return res.get(0);
		}
		return null;

	}
}
