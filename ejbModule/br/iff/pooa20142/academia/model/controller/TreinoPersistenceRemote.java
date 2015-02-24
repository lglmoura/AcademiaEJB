package br.iff.pooa20142.academia.model.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20142.academia.model.entity.Aluno;
import br.iff.pooa20142.academia.model.entity.Modalidade;
import br.iff.pooa20142.academia.model.entity.Treino;

@Remote
public interface TreinoPersistenceRemote {


	public Treino insert(String uid, Date datainicio, String dia, 
			             Timestamp horainicio, Aluno aluno,Modalidade modalidade);

	public Treino update(String uid, Date datainicio, String dia, 
			             Timestamp horainicio, Aluno aluno,Modalidade modalidade);

	public Treino delete( String uid);

	@XmlElement(name = "treino")
	public List<Treino> findAll();

	public Treino find(String uid);

}
