package br.unb.cic.monitoria.recursos;

import java.util.List;

import spark.Request;
import spark.Response;
import br.unb.cic.monitoria.dominio.GerenteDeOferta;
import br.unb.cic.monitoria.dominio.Oferta;
import br.unb.cic.spark.Capacidade;
import br.unb.cic.spark.JSONUtil;
import br.unb.cic.spark.Metodo;
import br.unb.cic.spark.Recurso;

public class RecursoOferta extends Recurso {

	@Override
	protected void carregarCapacidades() {
		capacidades.add(new Capacidade(Metodo.GET, "/oferta") {
			public Object handle(Request req, Response resp) throws Exception {
				try {
					Integer idDisciplina = req.attribute("disciplina");
				
					Integer semestre = req.attribute("semestre");
					
					GerenteDeOferta repositorio  = new GerenteDeOferta();
					
					List<Oferta> oferta = repositorio.listarOferta(idDisciplina, semestre);
					
					resp.status(200);
					return "ok";
				}
				catch(Exception e) {
					resp.status(500);
					return "Internal server error";
				}
			}
		});
	}

}
