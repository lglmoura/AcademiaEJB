package br.iff.pooa20142.academia.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.pooa20142.academia.model.entity.Professor;

@Stateless
@LocalBean
public class ProfessorPersistence extends AbstractPersistence implements
		ProfessorPersistenceRemote {

	@Override
	public Professor insert(String uid, String nome, Integer idade) {

		Professor professor = new Professor();
		professor.setNome(nome);
		professor.setUid(uid);
		professor.setIdade(idade);


		super.insert(professor);

		return professor;
	}

	@Override
	public Professor update(String uid, String nome, Integer idade) {

		Professor professor = super.find(Professor.class, uid);
		professor.setNome(nome);
		professor.setUid(uid);
		professor.setIdade(idade);

		super.update(professor);


		return professor;
	}

	@Override
	public Professor delete(String uid) {
		super.delete(Professor.class, uid);
		return null;
	}

	@Override
	public List<Professor> findAll() {

		return super.findAll(Professor.class);
	}

	@Override
	public Professor find(String uid) {

		return super.find(Professor.class, uid);
	}

}
