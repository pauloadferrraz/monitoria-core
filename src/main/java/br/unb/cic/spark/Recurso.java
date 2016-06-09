package br.unb.cic.spark;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstrata que define um recurso REST contendo 
 * uma lista de capacidades acessiveis pelo protocolo 
 * HTTP. 
 * 
 * @author rbonifacio
 */
public abstract class Recurso {
	protected List<Capacidade> capacidades;
	
	public Recurso() {
		capacidades = new ArrayList<Capacidade>();
	}
	
	public void definirCapacidades() {
		carregarCapacidades();
		for(Capacidade r: capacidades) {
			GerenciadorDeRotas.instance().novaRota(r);
		}
	}
	
	protected abstract void carregarCapacidades();
}
