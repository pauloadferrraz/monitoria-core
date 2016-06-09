package br.cic.unb.monitoria.recursos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import spark.Request;
import spark.Response;
import br.cic.unb.monitoria.dominio.Aluno;
import br.unb.cic.spark.Capacidade;
import br.unb.cic.spark.Metodo;
import br.unb.cic.spark.Recurso;

public class RecursoPopulaDB extends Recurso {

	@Override
	protected void carregarCapacidades() {
		capacidades.add(new Capacidade(Metodo.POST, "/populaDB") {
			public Object handle(Request req, Response resp) throws Exception {
				resp.status(200);
				
				try {
					insereAlunosTeste();
					return "done";
				}
				catch(Exception e) {
					return e.getMessage();
				}
			}

			private void insereAlunosTeste() {
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
				EntityManager manager = factory.createEntityManager();
				
				manager.getTransaction().begin();
				manager.createQuery("delete from Aluno where matricula = '123'").executeUpdate();
				manager.createQuery("delete from Aluno where matricula = '456'").executeUpdate();
				
				Aluno alunoTeste1 = new Aluno("123", "rbonifacio", 4.3, "123");
				Aluno alunoTeste2 = new Aluno("456", "hbonifacio", 4.5, "456");
				
				manager.persist(alunoTeste1);
				manager.persist(alunoTeste2);
				
				manager.getTransaction().commit();
			}
		});
	}

}
