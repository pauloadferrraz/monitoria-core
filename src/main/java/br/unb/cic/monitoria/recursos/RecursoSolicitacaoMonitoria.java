package br.unb.cic.monitoria.recursos;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.unb.cic.monitoria.dominio.Aluno;
import br.unb.cic.monitoria.dominio.GerenteDeAluno;
import br.unb.cic.monitoria.dominio.GerenteMonitoria;
import br.unb.cic.monitoria.dominio.Monitoria;
import br.unb.cic.monitoria.dominio.Oferta;
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

					return repositorio.solicitarPedido(sm.aluno, sm.oferta, sm.tipo);
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
						responseData[i++] = new SolicitacaoMonitoria(moni.getId(), moni.getAluno(), moni.getOferta(),
								moni.getRanking(), moni.getTipo(), moni.getStatus());
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

					Integer id = Integer.getInteger(request.queryParams("id"));
					String status = request.queryParams("status");
					Integer rank = Integer.getInteger(request.queryParams("ranking"));
					String tipo = request.queryParams("tipo");

					Aluno aluno = new Aluno();
					Oferta oferta = new Oferta();

					GerenteMonitoria repositorio = new GerenteMonitoria();

					Monitoria monitoria = new Monitoria(id, aluno, oferta, rank, tipo, status);

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
		private Integer id;
		private Aluno aluno;
		private Oferta oferta;
		private Integer ranking;
		private String tipo;
		private String status;

		public SolicitacaoMonitoria() {

		}

		public SolicitacaoMonitoria(Integer id, Aluno aluno, Oferta oferta, Integer ranking, String tipo,
				String status) {
			super();
			this.id = id;
			this.aluno = aluno;
			this.oferta = oferta;
			this.ranking = ranking;
			this.tipo = tipo;
			this.status = status;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Aluno getAluno() {
			return aluno;
		}

		public void setAluno(Aluno aluno) {
			this.aluno = aluno;
		}

		public Oferta getOferta() {
			return oferta;
		}

		public void setOferta(Oferta oferta) {
			this.oferta = oferta;
		}

		public Integer getRanking() {
			return ranking;
		}

		public void setRanking(Integer ranking) {
			this.ranking = ranking;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

	}

}