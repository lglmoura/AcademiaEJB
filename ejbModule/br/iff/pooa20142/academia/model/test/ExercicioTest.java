package br.iff.pooa20142.academia.model.test;

import static org.junit.Assert.*;

import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20142.academia.model.controller.ExercicioPersistenceRemote;
import br.iff.pooa20142.academia.model.entity.Exercicio;

public class ExercicioTest {

	ExercicioPersistenceRemote exercicioPR;

	@Before
	public void setUp() throws Exception {

		Context context = null;
		exercicioPR = null;
		try {

			context = JNDILookupClass.getInitialContext();

			exercicioPR = (ExercicioPersistenceRemote) context
					.lookup("ejb:AcademiaEAR/AcademiaEJB/ExercicioPersistence!br.iff.pooa20142.academia.model.controller.ExercicioPersistenceRemote");

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

		Exercicio exercicio = exercicioPR.insert(uid, "nome", "area");
		assertEquals(exercicio.getUid(), uid);
		exercicioPR.delete(uid);

	}

	@Test
	public void testupdate() {

		String uid = UUID.randomUUID().toString();

		Exercicio exercicio = exercicioPR.insert(uid, "nome", "area");

		exercicio = exercicioPR.update(uid, "nome1", "area");

		assertEquals(exercicio.getNome(), "nome1");

		exercicioPR.delete(uid);

	}

	@Test
	public void testfind() {
		String uid = UUID.randomUUID().toString();

		exercicioPR.insert(uid, "nome", "area");

		Exercicio exercicioUp = exercicioPR.find(uid);

		assertEquals(exercicioUp.getNome(), "nome");

		exercicioPR.delete(uid);
	}

	@Test
	public void testdelete() {

		String uid = UUID.randomUUID().toString();

		exercicioPR.insert(uid, "nome", "area");

		exercicioPR.delete(uid);

		assertEquals(exercicioPR.find(uid), null);
	}

}
