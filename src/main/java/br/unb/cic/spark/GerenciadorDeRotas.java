package br.unb.cic.spark;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe que mantem todas as rotas de uma aplicacao, 
 * de acordo com o framwork Spark e a customizacao 
 * da UnB. 
 * 
 * @author rbonifacio
 *
 */
public class GerenciadorDeRotas implements Iterable<Capacidade>{

	private List<Capacidade> rotas;
	
	/*
	 * Construtor privado de acordo com o padrao de 
	 * projeto Singleton. 
	 */
	private GerenciadorDeRotas() {
		rotas = new ArrayList<Capacidade>();
	}
	
	private static GerenciadorDeRotas instance;
	
	/**
	 * Retorna a unica instancia do gerenciador 
	 * de rotas. 
	 */
	public static GerenciadorDeRotas instance() {
		if(instance == null) {
			instance = new GerenciadorDeRotas();
		}
		return instance;
	}
	
	/**
	 * Adiciona uma nova rota. 
	 * @param rota nova rota a ser adicionada. 
	 */
	public void novaRota(Capacidade rota) {
		rotas.add(rota);
	}

	/**
	 * Retorna um iterador para as rotas 
	 * existentes. 
	 */
	public Iterator<Capacidade> iterator() {
		return rotas.iterator();
	}
}
