package br.unb.cic.spark;

public enum CodigoDeRetorno {
	
	SUCESSO(200),
	RECURSO_NAO_ENCONTRADO(404),
	NAO_AUTORIZADO(401);
	
	public int codigo;
	
	CodigoDeRetorno(int codigo) {
		this.codigo = codigo;
	}
}
