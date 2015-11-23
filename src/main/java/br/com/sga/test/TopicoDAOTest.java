package br.com.sga.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sga.DAO.DisciplinaDAO;
import br.com.sga.DAO.TopicoDAO;
import br.com.sga.domain.Disciplina;
import br.com.sga.domain.Topico;

public class TopicoDAOTest {

	@Test
	@Ignore
	public void salvar() {

		DisciplinaDAO dDAO = new DisciplinaDAO();
		Disciplina disciplina = dDAO.buscarPorCodigo(3L);

		Topico topico = new Topico();
		topico.setDescricao("teste é nois");
		topico.setDisciplina(disciplina);

		TopicoDAO tDAO = new TopicoDAO();
		tDAO.salvar(topico);
	}
}
