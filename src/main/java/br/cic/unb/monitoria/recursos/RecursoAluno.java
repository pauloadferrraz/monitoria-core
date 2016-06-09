package br.cic.unb.monitoria.recursos;

import spark.Request;
import spark.Response;
import br.cic.unb.monitoria.dominio.Aluno;
import br.cic.unb.monitoria.dominio.GerenteDeAluno;
import br.unb.cic.spark.Capacidade;
import br.unb.cic.spark.CodigoDeRetorno;
import br.unb.cic.spark.JSONUtil;
import br.unb.cic.spark.Metodo;
import br.unb.cic.spark.Recurso;

public class RecursoAluno extends Recurso {

	@Override
	protected void carregarCapacidades() {
		capacidades.add(new Capacidade(Metodo.GET, "/aluno/autenticar") {
		
			public Object handle(Request req, Response resp) throws Exception {
				String matricula = req.queryParams("matricula");
				String senha = req.queryParams("senha");
				
				GerenteDeAluno repositorio = new GerenteDeAluno();
					
				Aluno aluno = repositorio.autenticar(matricula, senha);
					
				if(aluno == null) {
					resp.status(CodigoDeRetorno.NAO_AUTORIZADO.codigo);
					return "Unauthorized";
				}
				else {
					resp.status(CodigoDeRetorno.SUCESSO.codigo);
					resp.type("application/json");
					return JSONUtil.dataToJson(aluno);
				}
			}
		});	
	}

}
