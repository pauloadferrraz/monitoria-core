package br.cic.unb.monitoria.recursos;

import spark.Request;
import spark.Response;
import br.unb.cic.spark.Capacidade;
import br.unb.cic.spark.Metodo;
import br.unb.cic.spark.Recurso;

public class Aluno extends Recurso {

	@Override
	protected void carregarRotas() {
		capacidades.add(new Capacidade(Metodo.GET, "aluno/autenticar") {
			public Object handle(Request req, Response resp) throws Exception {
				return null;
			}
		});	
	}

}
