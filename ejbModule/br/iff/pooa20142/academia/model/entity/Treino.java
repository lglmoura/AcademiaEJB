package br.iff.pooa20142.academia.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the treino database table.
 * 
 */
@Entity
@NamedQuery(name="Treino.findAll", query="SELECT t FROM Treino t")
public class Treino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String dia;

	private Timestamp horainicio;

	@Column(name="\"uidAluno\"")
	private String uidAluno;

	@Column(name="\"uidModalidade\"")
	private String uidModalidade;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumns({
		})
	private Aluno aluno;

	//bi-directional many-to-one association to Modalidade
	@ManyToOne
	@JoinColumns({
		})
	private Modalidade modalidade;

	public Treino() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDia() {
		return this.dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Timestamp getHorainicio() {
		return this.horainicio;
	}

	public void setHorainicio(Timestamp horainicio) {
		this.horainicio = horainicio;
	}

	public String getUidAluno() {
		return this.uidAluno;
	}

	public void setUidAluno(String uidAluno) {
		this.uidAluno = uidAluno;
	}

	public String getUidModalidade() {
		return this.uidModalidade;
	}

	public void setUidModalidade(String uidModalidade) {
		this.uidModalidade = uidModalidade;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Modalidade getModalidade() {
		return this.modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

}