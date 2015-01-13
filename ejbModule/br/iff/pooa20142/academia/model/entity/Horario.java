package br.iff.pooa20142.academia.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the horario database table.
 * 
 */
@Entity
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String diadasemana;

	private String horario;

	//bi-directional many-to-one association to Modalidade
	@ManyToOne
	@JoinColumn(name="uidmodalidade")
	private Modalidade modalidade;

	//bi-directional many-to-one association to Professor
	@ManyToOne
	@JoinColumn(name="uidprofessor")
	private Professor professor;

	public Horario() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDiadasemana() {
		return this.diadasemana;
	}

	public void setDiadasemana(String diadasemana) {
		this.diadasemana = diadasemana;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Modalidade getModalidade() {
		return this.modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}