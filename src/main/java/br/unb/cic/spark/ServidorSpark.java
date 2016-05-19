package br.unb.cic.spark;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.cic.unb.monitoria.recursos.Oferta;
import spark.Spark;

/**
 * Classe que representa o container de 
 * micro-servicos baseado no SparkFramework, 
 * 
 * @author rbonifacio
 */
public class ServidorSpark extends Spark {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		ListaDeRecursos listaDeRecursos = (ListaDeRecursos)context.getBean("listaDeRecursos");
		List<Recurso> recursos = listaDeRecursos.getRecursos();
		
		for (Recurso recurso : recursos) {
			for(Capacidade c : recurso.capacidades) {
				System.out.println(c.getPath());
			}
		}
		Oferta o = new Oferta();
		o.definirCapacidades();
		Iterator<Capacidade> it = GerenciadorDeRotas.instance().iterator();
		
		while(it.hasNext()) {
			Capacidade c = it.next();
			if(c.getMetodo() == Metodo.GET) {
				get(c.getPath(), c);
			}
		}
	}
}
