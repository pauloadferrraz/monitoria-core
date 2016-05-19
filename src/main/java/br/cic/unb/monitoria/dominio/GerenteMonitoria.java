package br.cic.unb.monitoria.dominio;

import java.util.ArrayList;
import java.util.List;

public class GerenteMonitoria {

	List<Monitoria> pedidosMonitoria; 
	
	private GerenteMonitoria() {
		pedidosMonitoria = new ArrayList<Monitoria>();
	}
	
	private static GerenteMonitoria instance;
	
	public static GerenteMonitoria instance() {
		if(instance == null) {
			instance = new GerenteMonitoria();
		}
		return instance;
	}
	public void adicionarPedido(Monitoria m) {
		pedidosMonitoria.add(m);
	}
	
	public List<Monitoria> listarPedidos() {
		return pedidosMonitoria;
	}
}
