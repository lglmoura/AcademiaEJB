package br.iff.pooa20142.academia.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20142.academia.model.entity.Professor;

@Remote
public interface ProfessorPersistenceRemote {


	public Professor insert(String uid, String nome, Integer idade);

	public Professor update(String uid, String nome, Integer idade);

	public Professor delete( String uid);

	@XmlElement(name = "professor")
	public List<Professor> findAll();

	public Professor find(String uid);

}
