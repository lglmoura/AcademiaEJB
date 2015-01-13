package br.iff.pooa20142.academia.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the treinoexercicio database table.
 * 
 */
@Entity
@NamedQuery(name="Treinoexercicio.findAll", query="SELECT t FROM Treinoexercicio t")
public class Treinoexercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private Integer quantidadeserie;

	private Integer serie;

	//bi-directional many-to-one association to Exercicio
	@ManyToOne
	@JoinColumn(name="uidexercicio")
	private Exercicio exercicio;

	//bi-directional many-to-one association to Treino
	@ManyToOne
	@JoinColumn(name="uidtreino")
	private Treino treino;

	public Treinoexercicio() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getQuantidadeserie() {
		return this.quantidadeserie;
	}

	public void setQuantidadeserie(Integer quantidadeserie) {
		this.quantidadeserie = quantidadeserie;
	}

	public Integer getSerie() {
		return this.serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}

	public Exercicio getExercicio() {
		return this.exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public Treino getTreino() {
		return this.treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}

}