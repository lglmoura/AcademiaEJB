package br.iff.pooa20142.academia.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.pooa20142.academia.model.entity.Aluno;

@Stateless
@LocalBean
public class AlunoPersistence extends AbstractPersistence implements
		AlunoPersistenceRemote {

	@Override
	public Aluno insert(String uid, String nome, String endereco,
			Integer matricula, String telefone) {
		
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setUid(uid);
		aluno.setMatricula(matricula);
		aluno.setEndereco(endereco);
		aluno.setTelefone(telefone);
		
		super.insert(aluno);
		
		return aluno;
	}

	@Override
	public Aluno update(String uid, String nome, String endereco,
			Integer matricula, String telefone) {
		
		Aluno aluno = super.find(Aluno.class, uid);
		aluno.setNome(nome);
		aluno.setUid(uid);
		aluno.setMatricula(matricula);
		aluno.setEndereco(endereco);
		aluno.setTelefone(telefone);
		super.update(aluno);
		
		
		return aluno;
	}

	@Override
	public Aluno delete(String uid) {
		super.delete(Aluno.class, uid);
		return null;
	}

	@Override
	public List<Aluno> findAll() {
		
		return super.findAll(Aluno.class);
	}

	@Override
	public Aluno find(String uid) {
		
		return super.find(Aluno.class, uid);
	}

}
