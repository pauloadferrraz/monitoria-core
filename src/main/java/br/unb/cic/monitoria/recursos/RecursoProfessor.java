package br.unb.cic.monitoria.recursos;

import br.unb.cic.monitoria.dominio.GerenteDeProfessor;
import br.unb.cic.monitoria.dominio.Professor;
import br.unb.cic.spark.Capacidade;
import br.unb.cic.spark.CodigoDeRetorno;
import br.unb.cic.spark.JSONUtil;
import br.unb.cic.spark.Metodo;
import br.unb.cic.spark.Recurso;
import spark.Request;
import spark.Response;

public class RecursoProfessor extends Recurso {

	@Override
	protected void carregarCapacidades() {
		capacidades.add(new Capacidade(Metodo.GET, "/professor/autenticar") {
		
			public Object handle(Request req, Response resp) throws Exception {
				try {
					String matricula = req.queryParams("matricula");
					
					String senha = req.queryParams("senha");
					
					GerenteDeProfessor repositorio = new GerenteDeProfessor();
						
					Professor professor = repositorio.autenticar(matricula, senha);
						
					if(professor == null) {
						resp.status(CodigoDeRetorno.NAO_AUTORIZADO.codigo);
						return "Unauthorized";
					}
					else {
						resp.status(CodigoDeRetorno.SUCESSO.codigo);
						resp.type("application/json");
						return JSONUtil.dataToJson(new ProfessorVO(professor.getId(), professor.getNome()));
					}
				}catch(Exception e) {
					e.printStackTrace();
					throw e;
				}
			}
		});	
	}
	
	static class ProfessorVO {
		private Integer id;
		private String nome;
		
		public ProfessorVO() {}
		
		public ProfessorVO(Integer id, String nome) {
			this.id = id;
			this.nome = nome;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		
		
		
	}

}
