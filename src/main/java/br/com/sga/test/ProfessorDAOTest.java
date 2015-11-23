package br.com.sga.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sga.DAO.ProfessorDAO;
import br.com.sga.domain.Professor;

public class ProfessorDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Professor p1 = new Professor();
		p1.setProfNome("Teste1");
		p1.setProfAreaAtuacao("Area de Atuação teste");
		p1.setProfCampus("Fatec Ourinhos");
		p1.setProfSenha("teste");

		Professor p2 = new Professor();
		p2.setProfNome("Teste2");
		p2.setProfAreaAtuacao("Area de Atuação teste");
		p2.setProfCampus("Fatec Ourinhos");
		p2.setProfSenha("testeasdasdsadsa");

		ProfessorDAO dao = new ProfessorDAO();
		dao.salvar(p1);
		dao.salvar(p2);
	}

	@Test
	@Ignore
	public void listar() {
		ProfessorDAO dao = new ProfessorDAO();
		List<Professor> professores = dao.listar();

		for (Professor professor : professores) {
			System.out.println(professor);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ProfessorDAO dao = new ProfessorDAO();

		Professor p1 = dao.buscarPorCodigo(36L);

		System.out.println(p1);

	}
}
