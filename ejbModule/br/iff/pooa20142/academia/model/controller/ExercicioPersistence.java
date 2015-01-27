package br.iff.pooa20142.academia.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.pooa20142.academia.model.entity.Exercicio;

@Stateless
@LocalBean
public class ExercicioPersistence extends AbstractPersistence implements
		ExercicioPersistenceRemote {

	@Override
	public Exercicio insert(String uid, String nome, String areaatuacao) {

		Exercicio exercicio = new Exercicio();
		exercicio.setNome(nome);
		exercicio.setUid(uid);
		exercicio.setAreaatuacao(areaatuacao);

		super.insert(exercicio);

		return exercicio;
	}

	@Override
	public Exercicio update(String uid, String nome, String areaatuacao) {

		Exercicio exercicio = super.find(Exercicio.class, uid);
		exercicio.setNome(nome);
		exercicio.setUid(uid);
		exercicio.setAreaatuacao(areaatuacao);
		super.update(exercicio);


		return exercicio;
	}

	@Override
	public Exercicio delete(String uid) {
		super.delete(Exercicio.class, uid);
		return null;
	}

	@Override
	public List<Exercicio> findAll() {

		return super.findAll(Exercicio.class);
	}

	@Override
	public Exercicio find(String uid) {

		return super.find(Exercicio.class, uid);
	}

}
