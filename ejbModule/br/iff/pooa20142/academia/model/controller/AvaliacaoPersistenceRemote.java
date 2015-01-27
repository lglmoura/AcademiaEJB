package br.iff.pooa20142.academia.model.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20142.academia.model.entity.Avaliacao;
import br.iff.pooa20142.academia.model.entity.Treino;


@Remote
public interface AvaliacaoPersistenceRemote {

	public Avaliacao insert(String uid, String avaliacaoP, Date dataavaliacao,
			Treino treino);

	public Avaliacao update(String uid, String avaliacaoP, Date dataavaliacao,
			Treino treino);

	public Avaliacao delete(String uid);

	@XmlElement(name = "avalia")
	public List<Avaliacao> findAll();

	public Avaliacao find(String uid);

}
