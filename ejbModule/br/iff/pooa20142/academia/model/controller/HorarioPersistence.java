package br.iff.pooa20142.academia.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.pooa20142.academia.model.entity.Horario;
import br.iff.pooa20142.academia.model.entity.Modalidade;
import br.iff.pooa20142.academia.model.entity.Professor;

@Stateless
@LocalBean
public class HorarioPersistence extends AbstractPersistence implements
		HorarioPersistenceRemote {

	@Override
	public Horario insert(String uid, String diadasemana, String horarioa,
			Modalidade modalidade, Professor professor) {

		Horario horario = new Horario();
		horario.setDiadasemana(diadasemana);
		horario.setUid(uid);
		horario.setHorario(horarioa);
		horario.setProfessor(professor);
		horario.setModalidade(modalidade);

		super.insert(horario);

		return horario;
	}

	@Override
	public Horario update(String uid, String diadasemana, String horarioa,
			Modalidade modalidade, Professor professor) {

		Horario horario = super.find(Horario.class, uid);
		horario.setDiadasemana(diadasemana);
		horario.setUid(uid);
		horario.setHorario(horarioa);
		horario.setProfessor(professor);
		horario.setModalidade(modalidade);

		super.update(horario);

		return horario;
	}

	@Override
	public Horario delete(String uid) {
		super.delete(Horario.class, uid);
		return null;
	}

	@Override
	public List<Horario> findAll() {

		return super.findAll(Horario.class);
	}

	@Override
	public Horario find(String uid) {

		return super.find(Horario.class, uid);
	}

}
