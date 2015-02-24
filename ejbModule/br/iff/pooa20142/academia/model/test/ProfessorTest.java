package br.iff.pooa20142.academia.model.test;

import static org.junit.Assert.*;

import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20142.academia.model.controller.ProfessorPersistenceRemote;
import br.iff.pooa20142.academia.model.entity.Professor;

public class ProfessorTest {

	ProfessorPersistenceRemote professorPR;

	@Before
	public void setUp() throws Exception {

		Context context = null;
		professorPR = null;
		try {

			context = JNDILookupClass.getInitialContext();

			professorPR = (ProfessorPersistenceRemote) context
					.lookup("ejb:AcademiaEAR/AcademiaEJB/ProfessorPersistence!br.iff.pooa20142.academia.model.controller.ProfessorPersistenceRemote");

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

		Professor professor = professorPR.insert(uid, "nome",  1111);
		assertEquals(professor.getUid(), uid);
		professorPR.delete(uid);

	}

	@Test
	public void testupdate() {

		String uid = UUID.randomUUID().toString();

		Professor professor = professorPR.insert(uid, "nome",  1111);

		professor = professorPR.update(uid, "nome1",  222);

		assertEquals(professor.getNome(), "nome1");

		professorPR.delete(uid);

	}

	@Test
	public void testfind() {
		String uid = UUID.randomUUID().toString();

		professorPR.insert(uid, "nome",  1111);

		Professor professorUp = professorPR.find(uid);

		assertEquals(professorUp.getNome(), "nome");

		professorPR.delete(uid);
	}

	@Test
	public void testdelete() {

		String uid = UUID.randomUUID().toString();

		professorPR.insert(uid, "nome",  1111);

		professorPR.delete(uid);

		assertEquals(professorPR.find(uid), null);
	}

}
