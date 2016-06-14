package br.cic.unb.monitoria.dominio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.unb.cic.monitoria.dominio.Aluno;
import br.unb.cic.monitoria.dominio.GerenteDeAluno;

/**
 * Classe responsavel por implementar os testes unitarios 
 * da classe GerenteDeAluno. 
 * 
 * @author rbonifacio
 */
public class TesteGerenteDeAluno {
	
	@Before
	public void setUp() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();
		
		Aluno alunoTeste = new Aluno("123", "rbonifacio", 4.3, "123");
		manager.getTransaction().begin();
		manager.persist(alunoTeste);
		manager.getTransaction().commit();
		//manager.flush();
	}
	
	@After
	public void tearDown() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.createQuery("delete from Aluno where matricula = '123'").executeUpdate();
		manager.getTransaction().commit();
	}
 
	@Test
	public void testeMetodoAutenticacao() {
		GerenteDeAluno gerenteAluno = new GerenteDeAluno();
		Aluno aluno = gerenteAluno.autenticar("erro", "erro");
		Assert.assertNull(aluno);
		
		aluno = gerenteAluno.autenticar("123", "123");
		Assert.assertNotNull(aluno);
	}
	
	

}
