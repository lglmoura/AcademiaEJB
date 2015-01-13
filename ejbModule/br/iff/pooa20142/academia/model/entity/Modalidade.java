package br.iff.pooa20142.academia.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the modalidade database table.
 * 
 */
@Entity
@NamedQuery(name="Modalidade.findAll", query="SELECT m FROM Modalidade m")
public class Modalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String descricao;

	//bi-directional many-to-one association to Treino
	@OneToMany(mappedBy="modalidade")
	private List<Treino> treinos;

	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="modalidade")
	private List<Horario> horarios;

	public Modalidade() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Treino> getTreinos() {
		return this.treinos;
	}

	public void setTreinos(List<Treino> treinos) {
		this.treinos = treinos;
	}

	public Treino addTreino(Treino treino) {
		getTreinos().add(treino);
		treino.setModalidade(this);

		return treino;
	}

	public Treino removeTreino(Treino treino) {
		getTreinos().remove(treino);
		treino.setModalidade(null);

		return treino;
	}

	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setModalidade(this);

		return horario;
	}

	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setModalidade(null);

		return horario;
	}

}