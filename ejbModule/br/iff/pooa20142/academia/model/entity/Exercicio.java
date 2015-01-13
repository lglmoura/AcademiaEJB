package br.iff.pooa20142.academia.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the exercicio database table.
 * 
 */
@Entity
@NamedQuery(name="Exercicio.findAll", query="SELECT e FROM Exercicio e")
public class Exercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String areaatuacao;

	private String nome;

	//bi-directional many-to-one association to Treinoexercicio
	@OneToMany(mappedBy="exercicio")
	private List<Treinoexercicio> treinoexercicios;

	public Exercicio() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAreaatuacao() {
		return this.areaatuacao;
	}

	public void setAreaatuacao(String areaatuacao) {
		this.areaatuacao = areaatuacao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Treinoexercicio> getTreinoexercicios() {
		return this.treinoexercicios;
	}

	public void setTreinoexercicios(List<Treinoexercicio> treinoexercicios) {
		this.treinoexercicios = treinoexercicios;
	}

	public Treinoexercicio addTreinoexercicio(Treinoexercicio treinoexercicio) {
		getTreinoexercicios().add(treinoexercicio);
		treinoexercicio.setExercicio(this);

		return treinoexercicio;
	}

	public Treinoexercicio removeTreinoexercicio(Treinoexercicio treinoexercicio) {
		getTreinoexercicios().remove(treinoexercicio);
		treinoexercicio.setExercicio(null);

		return treinoexercicio;
	}

}