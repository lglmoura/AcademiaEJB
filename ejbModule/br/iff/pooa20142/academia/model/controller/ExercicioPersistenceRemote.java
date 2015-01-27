package br.iff.pooa20142.academia.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20142.academia.model.entity.Exercicio;

@Remote
public interface ExercicioPersistenceRemote {


	public Exercicio insert(String uid, String nome,String areaatuacao);

	public Exercicio update(String uid, String nome,String areaatuacao);

	public Exercicio delete( String uid);

	@XmlElement(name = "exercicio")
	public List<Exercicio> findAll();

	public Exercicio find(String uid);

}
