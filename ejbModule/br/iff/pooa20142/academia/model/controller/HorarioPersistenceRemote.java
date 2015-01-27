package br.iff.pooa20142.academia.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20142.academia.model.entity.Horario;
import br.iff.pooa20142.academia.model.entity.Modalidade;
import br.iff.pooa20142.academia.model.entity.Professor;

@Remote
public interface HorarioPersistenceRemote {

	public Horario insert(String uid, String diadasemana, String horario,
			Modalidade modadidade, Professor professor);

	public Horario update(String uid, String diadasemana, String horario,
			Modalidade modadidade, Professor professor);

	public Horario delete(String uid);

	@XmlElement(name = "horario")
	public List<Horario> findAll();

	public Horario find(String uid);

}
