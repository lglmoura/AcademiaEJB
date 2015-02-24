package br.iff.pooa20142.academia.model.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.pooa20142.academia.model.entity.Aluno;
import br.iff.pooa20142.academia.model.entity.Modalidade;
import br.iff.pooa20142.academia.model.entity.Treino;

@Stateless
@LocalBean
public class TreinoPersistence extends AbstractPersistence implements
		TreinoPersistenceRemote {

	@Override
	public Treino insert(String uid, Date datainicio, String dia,
			             Timestamp horainicio, Aluno aluno,Modalidade modalidade) {

		Treino treino = new Treino();
		treino.setDatainicio(datainicio);
		treino.setUid(uid);
		treino.setDia(dia);
		treino.setHorainicio(horainicio);
		treino.setAluno(aluno);
		treino.setModalidade(modalidade);

		super.insert(treino);

		return treino;
	}

	@Override
	public Treino update(String uid, Date datainicio, String dia,
			             Timestamp horainicio, Aluno aluno,Modalidade modalidade) {

		Treino treino = super.find(Treino.class, uid);
		treino.setDatainicio(datainicio);
		treino.setUid(uid);
		treino.setDia(dia);
		treino.setHorainicio(horainicio);
		treino.setAluno(aluno);
		treino.setModalidade(modalidade);
		super.update(treino);


		return treino;
	}

	@Override
	public Treino delete(String uid) {
		super.delete(Treino.class, uid);
		return null;
	}

	@Override
	public List<Treino> findAll() {

		return super.findAll(Treino.class);
	}

	@Override
	public Treino find(String uid) {

		return super.find(Treino.class, uid);
	}

}
