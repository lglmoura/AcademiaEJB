package br.iff.pooa20142.academia.model.test;

import static org.junit.Assert.*;

import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20142.academia.model.controller.AlunoPersistenceRemote;
import br.iff.pooa20142.academia.model.entity.Aluno;

public class AlunoTest {

	AlunoPersistenceRemote alunoPR;

	@Before
	public void setUp() throws Exception {

		Context context = null;
		alunoPR = null;
		try {

			context = JNDILookupClass.getInitialContext();

			alunoPR = (AlunoPersistenceRemote) context
					.lookup("ejb:AcademiaEAR/AcademiaEJB/AlunoPersistence!br.iff.pooa20142.academia.model.controller.AlunoPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testinserir() {

		String uid = UUID.randomUUID().toString();

		Aluno aluno = alunoPR.insert(uid, "nome", "endereco", 1111, "telefone");
		assertEquals(aluno.getUid(), uid);
		alunoPR.delete(uid);

	}

	@Test
	public void testupdate() {

		String uid = UUID.randomUUID().toString();

		Aluno aluno = alunoPR.insert(uid, "nome", "endereco", 1111, "telefone");

		aluno = alunoPR.update(uid, "nome1", "endereco1", 222, "telefone11");

		assertEquals(aluno.getNome(), "nome1");

		alunoPR.delete(uid);

	}

	@Test
	public void testfind() {
		String uid = UUID.randomUUID().toString();
		
		alunoPR.insert(uid, "nome", "endereco", 1111, "telefone");
		
		Aluno alunoUp = alunoPR.find(uid);
		
		assertEquals(alunoUp.getNome(), "nome");
		
		alunoPR.delete(uid);
	}

	@Test
	public void testdelete() {
		
		String uid = UUID.randomUUID().toString();
		
		alunoPR.insert(uid, "nome", "endereco", 1111, "telefone");
		
		alunoPR.delete(uid);
		
		assertEquals(alunoPR.find(uid), null);
	}

}
