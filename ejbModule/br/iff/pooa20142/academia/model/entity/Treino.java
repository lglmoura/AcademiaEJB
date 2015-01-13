package br.iff.pooa20142.academia.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


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

	@Temporal(TemporalType.DATE)
	private Date datainicio;

	private String dia;

	private Timestamp horainicio;

	//bi-directional many-to-one association to Avaliacao
	@OneToMany(mappedBy="treino")
	private List<Avaliacao> avaliacaos;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="uidaluno")
	private Aluno aluno;

	//bi-directional many-to-one association to Modalidade
	@ManyToOne
	@JoinColumn(name="uidmodalidade")
	private Modalidade modalidade;

	//bi-directional many-to-one association to Treinoexercicio
	@OneToMany(mappedBy="treino")
	private List<Treinoexercicio> treinoexercicios;

	public Treino() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getDatainicio() {
		return this.datainicio;
	}

	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
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

	public List<Avaliacao> getAvaliacaos() {
		return this.avaliacaos;
	}

	public void setAvaliacaos(List<Avaliacao> avaliacaos) {
		this.avaliacaos = avaliacaos;
	}

	public Avaliacao addAvaliacao(Avaliacao avaliacao) {
		getAvaliacaos().add(avaliacao);
		avaliacao.setTreino(this);

		return avaliacao;
	}

	public Avaliacao removeAvaliacao(Avaliacao avaliacao) {
		getAvaliacaos().remove(avaliacao);
		avaliacao.setTreino(null);

		return avaliacao;
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

	public List<Treinoexercicio> getTreinoexercicios() {
		return this.treinoexercicios;
	}

	public void setTreinoexercicios(List<Treinoexercicio> treinoexercicios) {
		this.treinoexercicios = treinoexercicios;
	}

	public Treinoexercicio addTreinoexercicio(Treinoexercicio treinoexercicio) {
		getTreinoexercicios().add(treinoexercicio);
		treinoexercicio.setTreino(this);

		return treinoexercicio;
	}

	public Treinoexercicio removeTreinoexercicio(Treinoexercicio treinoexercicio) {
		getTreinoexercicios().remove(treinoexercicio);
		treinoexercicio.setTreino(null);

		return treinoexercicio;
	}

}