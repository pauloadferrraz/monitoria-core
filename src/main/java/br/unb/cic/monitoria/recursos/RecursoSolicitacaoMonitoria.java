package br.unb.cic.monitoria.recursos;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import br.unb.cic.monitoria.dominio.GerenteMonitoria;
import br.unb.cic.monitoria.dominio.Monitoria;
import br.unb.cic.spark.Capacidade;
import br.unb.cic.spark.CodigoDeRetorno;
import br.unb.cic.spark.JSONUtil;
import br.unb.cic.spark.Metodo;
import br.unb.cic.spark.Recurso;
import spark.Request;
import spark.Response;

public class RecursoSolicitacaoMonitoria extends Recurso {

	@Override
	protected void carregarCapacidades() {

		capacidades.add(new Capacidade(Metodo.POST, "/solicitacaoMonitoria") {

			@Override
			public Object handle(Request req, Response resp) throws Exception {
				System.out.println(req.body());

				try {
					ObjectMapper om = new ObjectMapper();

					SolicitacaoMonitoria sm = om.readValue(req.body(), SolicitacaoMonitoria.class);
					resp.status(200);

					GerenteMonitoria repositorio = new GerenteMonitoria();

					return repositorio.solicitarPedido(sm.idAluno, sm.idTurma, sm.opcao);
				} catch (Exception e) {
					e.printStackTrace();
					resp.status(500);
					return e.getMessage();
				}
			}
		});

		capacidades.add(new Capacidade(Metodo.GET, "/solicitacaoMonitoria") {

			@Override
			public Object handle(Request request, Response response) throws Exception {

				try {

					String turma = request.queryParams("turma");

					GerenteMonitoria repositorio = new GerenteMonitoria();

					List<Monitoria> monitoria = repositorio.listarMonitoria(turma);
					SolicitacaoMonitoria responseData[] = new SolicitacaoMonitoria[monitoria.size()];
					int i = 0;
					for (Monitoria moni : monitoria) {
						responseData[i++] = new SolicitacaoMonitoria(moni.getMatricula(), moni.getCodTurma(),
								moni.getOpcao());
					}

					response.status(200);
					response.type("application/json");
					return JSONUtil.dataToJson(responseData);

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					response.status(500);
					return "Internal Server error";
				}

			}

		});

		capacidades.add(new Capacidade(Metodo.PUT, "/atualizaMonitoria") {

			@Override
			public Object handle(Request request, Response response) throws Exception {

				try {

					String id = request.queryParams("id");
					String matricula = request.queryParams("matricula");
					String disciplina = request.queryParams("disciplina");
					String turma = request.queryParams("turma");
					String status = request.queryParams("status");
					String dataSol = request.queryParams("datasolicitacao");
					String prioridade = request.queryParams("prioridade");
					String opcao = request.queryParams("opcao");

					GerenteMonitoria repositorio = new GerenteMonitoria();

					Monitoria monitoria = new Monitoria(id, matricula, disciplina, turma, status, dataSol, prioridade,
							opcao);
					
					repositorio.atualizaMonitoria(monitoria);
										
					response.status(CodigoDeRetorno.SUCESSO.codigo);
					response.type("application/json");
					return JSONUtil.dataToJson(response);

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					response.status(403);
					return "Acess Negated";
				}

			}

		});

	}

	static class SolicitacaoMonitoria {
		String idAluno;
		String idTurma;
		String opcao;

		public SolicitacaoMonitoria() {

		}

		public SolicitacaoMonitoria(String idAluno, String idTurma, String opcao) {
			this.idAluno = idAluno;
			this.idTurma = idTurma;
			this.opcao = opcao;
		}

		public String getIdAluno() {
			return idAluno;
		}

		public void setIdAluno(String idAluno) {
			this.idAluno = idAluno;
		}

		public String getIdTurma() {
			return idTurma;
		}

		public void setIdTurma(String idTurma) {
			this.idTurma = idTurma;
		}

		public String getOpcao() {
			return opcao;
		}

		public void setOpcao(String opcao) {
			this.opcao = opcao;
		}

	}

}