package br.iff.pooa20142.academia.model.test;

import static org.junit.Assert.*;

import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20142.academia.model.controller.ModalidadePersistenceRemote;
import br.iff.pooa20142.academia.model.entity.Modalidade;

public class ModalidadeTest {

	ModalidadePersistenceRemote modalidadePR;

	@Before
	public void setUp() throws Exception {

		Context context = null;
		modalidadePR = null;
		try {

			context = JNDILookupClass.getInitialContext();

			modalidadePR = (ModalidadePersistenceRemote) context
					.lookup("ejb:AcademiaEAR/AcademiaEJB/ModalidadePersistence!br.iff.pooa20142.academia.model.controller.ModalidadePersistenceRemote");

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

		Modalidade modalidade = modalidadePR.insert(uid, "descricao");
		assertEquals(modalidade.getUid(), uid);
		modalidadePR.delete(uid);

	}

	@Test
	public void testupdate() {

		String uid = UUID.randomUUID().toString();

		Modalidade modalidade = modalidadePR.insert(uid, "descricao");

		modalidade = modalidadePR.update(uid, "descricao1");

		assertEquals(modalidade.getDescricao(), "descricao1");

		modalidadePR.delete(uid);

	}

	@Test
	public void testfind() {
		String uid = UUID.randomUUID().toString();

		modalidadePR.insert(uid, "descricao");

		Modalidade modalidadeUp = modalidadePR.find(uid);

		assertEquals(modalidadeUp.getDescricao(), "descricao");

		modalidadePR.delete(uid);
	}

	@Test
	public void testdelete() {

		String uid = UUID.randomUUID().toString();

		modalidadePR.insert(uid, "descricao");

		modalidadePR.delete(uid);

		assertEquals(modalidadePR.find(uid), null);
	}

}
