package br.iff.pooa20142.academia.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20142.academia.model.entity.Modalidade;

@Remote
public interface ModalidadePersistenceRemote {


	public Modalidade insert(String uid, String descricao);

	public Modalidade update(String uid, String descricao);

	public Modalidade delete( String uid);

	@XmlElement(name = "modalidade")
	public List<Modalidade> findAll();

	public Modalidade find(String uid);

}
