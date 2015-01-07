package br.iff.pooa20142.academia.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aluno database table.
 * 
 */
@Entity
@NamedQuery(name="Aluno.findAll", query="SELECT a FROM Aluno a")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String endereco;

	private Integer matricula;

	private String nome;

	private String telefone;

	//bi-directional many-to-one association to Treino
	@OneToMany(mappedBy="aluno")
	private List<Treino> treinos;

	public Aluno() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Treino> getTreinos() {
		return this.treinos;
	}

	public void setTreinos(List<Treino> treinos) {
		this.treinos = treinos;
	}

	public Treino addTreino(Treino treino) {
		getTreinos().add(treino);
		treino.setAluno(this);

		return treino;
	}

	public Treino removeTreino(Treino treino) {
		getTreinos().remove(treino);
		treino.setAluno(null);

		return treino;
	}

}