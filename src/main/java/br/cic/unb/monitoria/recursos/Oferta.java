package br.cic.unb.monitoria.recursos;

import spark.Request;
import spark.Response;
import br.cic.unb.monitoria.dominio.GerenteDeOferta;
import br.unb.cic.spark.Capacidade;
import br.unb.cic.spark.JSONUtil;
import br.unb.cic.spark.Metodo;
import br.unb.cic.spark.Recurso;

public class Oferta extends Recurso {

	@Override
	protected void carregarRotas() {
		capacidades.add(new Capacidade(Metodo.GET, "/oferta") {
			public Object handle(Request req, Response resp) throws Exception {
				resp.status(200);
				
				GerenteDeOferta oferta = new GerenteDeOferta();
				return JSONUtil.dataToJson(oferta.listarOferta());
				//return "Hello world";
			}
		});
	}

}
