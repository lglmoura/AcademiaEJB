package br.iff.pooa20142.academia.model.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.pooa20142.academia.model.entity.Avaliacao;
import br.iff.pooa20142.academia.model.entity.Treino;

@Stateless
@LocalBean
public class AvaliacaoPersistence extends AbstractPersistence implements
		AvaliacaoPersistenceRemote {

	@Override
	public Avaliacao insert(String uid, String avaliacaoP, Date dataavaliacao,
			Treino treino) {

		Avaliacao valiacao = new Avaliacao();
		valiacao.setDataavaliacao(dataavaliacao);
		valiacao.setUid(uid);
		valiacao.setAvaliacao(avaliacaoP);
		valiacao.setTreino(treino);

		super.insert(valiacao);

		return valiacao;
	}

	@Override
	public Avaliacao update(String uid, String avaliacaoP, Date dataavaliacao,
			Treino treino) {

		Avaliacao valiacao = super.find(Avaliacao.class, uid);
		valiacao.setDataavaliacao(dataavaliacao);
		valiacao.setUid(uid);
		valiacao.setAvaliacao(avaliacaoP);
		valiacao.setTreino(treino);

		super.update(valiacao);

		return valiacao;
	}

	@Override
	public Avaliacao delete(String uid) {
		super.delete(Avaliacao.class, uid);
		return null;
	}

	@Override
	public List<Avaliacao> findAll() {

		return super.findAll(Avaliacao.class);
	}

	@Override
	public Avaliacao find(String uid) {

		return super.find(Avaliacao.class, uid);
	}

}
