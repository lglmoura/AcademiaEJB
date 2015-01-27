package br.iff.pooa20142.academia.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.pooa20142.academia.model.entity.Modalidade;

@Stateless
@LocalBean
public class ModalidadePersistence extends AbstractPersistence implements
		ModalidadePersistenceRemote {

	@Override
	public Modalidade insert(String uid, String descricao) {

		Modalidade modalidade = new Modalidade();
		modalidade.setDescricao(descricao);
		modalidade.setUid(uid);


		super.insert(modalidade);

		return modalidade;
	}

	@Override
	public Modalidade update(String uid, String descricao) {

		Modalidade modalidade = super.find(Modalidade.class, uid);
		modalidade.setDescricao(descricao);
		modalidade.setUid(uid);

		super.update(modalidade);


		return modalidade;
	}

	@Override
	public Modalidade delete(String uid) {
		super.delete(Modalidade.class, uid);
		return null;
	}

	@Override
	public List<Modalidade> findAll() {

		return super.findAll(Modalidade.class);
	}

	@Override
	public Modalidade find(String uid) {

		return super.find(Modalidade.class, uid);
	}

}
