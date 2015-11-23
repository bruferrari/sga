package br.com.sga.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sga.DAO.DisciplinaDAO;
import br.com.sga.domain.Disciplina;

public class DisciplinaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Disciplina d1 = new Disciplina();
		d1.setDescricao("TESTE HIBERNATE");

		Disciplina d2 = new Disciplina();
		d2.setDescricao("TESTE HIBERNATE 2");

		DisciplinaDAO dDAO = new DisciplinaDAO();
		dDAO.salvar(d1);
		dDAO.salvar(d2);
	}
	
	@Test
	@Ignore
	public void listar() {
		DisciplinaDAO dDAO = new DisciplinaDAO();
		List<Disciplina> disciplinas = dDAO.listar();

		System.out.println(disciplinas);
	}
}
