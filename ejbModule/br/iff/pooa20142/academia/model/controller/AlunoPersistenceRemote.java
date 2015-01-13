package br.iff.pooa20142.academia.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20142.academia.model.entity.Aluno;

@Remote
public interface AlunoPersistenceRemote {
	
	
	public Aluno insert(String uid, String nome,String endereco, Integer matricula, String telefone);
	
	public Aluno update(String uid, String nome,String endereco, Integer matricula, String telefone);
	
	public Aluno delete( String uid);
	
	@XmlElement(name = "aluno")
	public List<Aluno> findAll();
	
	public Aluno find(String uid);

}
