package br.iff.pooa20142.academia.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the avaliacao database table.
 * 
 */
@Entity
@NamedQuery(name="Avaliacao.findAll", query="SELECT a FROM Avaliacao a")
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String avaliacao;

	@Temporal(TemporalType.DATE)
	private Date dataavaliacao;

	//bi-directional many-to-one association to Treino
	@ManyToOne
	@JoinColumn(name="uidtreino")
	private Treino treino;

	public Avaliacao() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAvaliacao() {
		return this.avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Date getDataavaliacao() {
		return this.dataavaliacao;
	}

	public void setDataavaliacao(Date dataavaliacao) {
		this.dataavaliacao = dataavaliacao;
	}

	public Treino getTreino() {
		return this.treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}

}