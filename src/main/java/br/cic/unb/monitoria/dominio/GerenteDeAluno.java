package br.cic.unb.monitoria.dominio;

import java.util.ArrayList;
import java.util.List;

public class GerenteDeAluno {

	private List<Aluno> alunos;
	 
	public GerenteDeAluno() {
		alunos = new ArrayList<Aluno>();
		
		alunos.add(new Aluno("1234", "JOAO", 4.5, "abc"));
		alunos.add(new Aluno("5678", "MARIA",5.0, "maria"));
		alunos.add(new Aluno("4321", "HUGO", 3.0, "malu"));
		alunos.add(new Aluno("8765", "CAIO", 2.0, "hugo"));
	}
	public Aluno autenticar(String matricula, String senha) {
		for(Aluno aluno: alunos) {
			if(aluno.getMatricula().equals(matricula) && aluno.getSenha().equals(senha)) {
				return aluno;
			}
		}
		return null;
	}
}
