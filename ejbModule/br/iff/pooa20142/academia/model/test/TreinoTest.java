package br.iff.pooa20142.academia.model.test;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20142.academia.model.controller.AlunoPersistenceRemote;
import br.iff.pooa20142.academia.model.controller.ModalidadePersistenceRemote;
import br.iff.pooa20142.academia.model.controller.TreinoPersistenceRemote;
import br.iff.pooa20142.academia.model.entity.Aluno;
import br.iff.pooa20142.academia.model.entity.Modalidade;
import br.iff.pooa20142.academia.model.entity.Treino;

public class TreinoTest {

	private AlunoPersistenceRemote alunoPR;
	private ModalidadePersistenceRemote modalidadePR;
	private TreinoPersistenceRemote treinoPR;

	Aluno aluno;
	String uidAluno = UUID.randomUUID().toString();

	Modalidade modalidade;
	String uidModalidade = UUID.randomUUID().toString();

	@Before
	public void setUp() throws Exception {
		Context context = null;

		alunoPR = null;
		treinoPR = null;
		modalidadePR = null;

		try {

			context = JNDILookupClass.getInitialContext();

			alunoPR = (AlunoPersistenceRemote) context
					.lookup("ejb:AcademiaEAR/AcademiaEJB/AlunoPersistence!br.iff.pooa20142.academia.model.controller.AlunoPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}


		try {

			context = JNDILookupClass.getInitialContext();

			modalidadePR = (ModalidadePersistenceRemote) context
					.lookup("ejb:AcademiaEAR/AcademiaEJB/ModalidadePersistence!br.iff.pooa20142.academia.model.controller.ModalidadePersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}

		try {

			context = JNDILookupClass.getInitialContext();

			treinoPR = (TreinoPersistenceRemote) context
					.lookup("ejb:AcademiaEAR/AcademiaEJB/TreinoPersistence!br.iff.pooa20142.academia.model.controller.TreinoPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}

		//uidAluno = UUID.randomUUID().toString();
		
		aluno = alunoPR.insert(uidAluno, "nome", "endereco", 1111, "telefone");

		uidModalidade = UUID.randomUUID().toString();
		modalidade = modalidadePR.insert(uidModalidade, "nome");
	}

	@After
	public void tearDown() throws Exception {
		modalidadePR.delete(uidModalidade);
		alunoPR.delete(uidAluno);
	}

	@Test
	public void testInserir() {
		String uid = UUID.randomUUID().toString();
		Treino treino = treinoPR.insert(uid, new Date(), "quarta",
				new Timestamp((new Date()).getTime()), aluno, modalidade);
		assertEquals(treino.getUid(), uid);
		treinoPR.delete(uid);
	}

	@Test
	public void testupdate() {
		String uid = UUID.randomUUID().toString();
		treinoPR.insert(uid, new Date(), "quarta", new Timestamp((new Date()).getTime()), aluno,
				modalidade);
		Treino treinoUp = treinoPR.update(uid, new Date(), "descricao1",
				new Timestamp((new Date()).getTime()), aluno, modalidade);
		assertEquals(treinoUp.getDia(), "descricao1");
		treinoPR.delete(uid);
	}

	@Test
	public void testfind() {
		String uid = UUID.randomUUID().toString();
		treinoPR.insert(uid, new Date(), "quarta", new Timestamp((new Date()).getTime()), aluno,
				modalidade);
		Treino treinoUp = treinoPR.find(uid);
		assertEquals(treinoUp.getDia(), "quarta");
		treinoPR.delete(uid);
	}

	@Test
	public void testdelete() {
		String uid = UUID.randomUUID().toString();
		treinoPR.insert(uid, new Date(), "quarta", new Timestamp((new Date()).getTime()), aluno,
				modalidade);
		treinoPR.delete(uid);
		assertEquals(treinoPR.find(uid), null);
	}

}
