package br.cic.unb.monitoria.dominio;

import java.util.ArrayList;
import java.util.List;

public class GerenteDeOferta {
	
	public List<Oferta> listarOferta() {
		List<Oferta> oferta = new ArrayList<Oferta>();
		
		oferta.add(new Oferta(123, "A" , "2016.1" , "Rodrigo Bonifacio" , 30));
		oferta.add(new Oferta(456, "B" , "2016.1" , "Rodrigo Bonifacio" , 25));
		oferta.add(new Oferta(789, "A" , "2016.1" , "Edna Canedo" , 40));
		
		
		return oferta;
	}

}
