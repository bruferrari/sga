package br.com.sga.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sga.DAO.DisciplinaDAO;
import br.com.sga.DAO.Docente_disciplinaDAO;
import br.com.sga.DAO.ProfessorDAO;
import br.com.sga.domain.Disciplina;
import br.com.sga.domain.Docente_disciplina;
import br.com.sga.domain.Professor;
import br.com.sga.util.JSFUtil;

@ManagedBean(name = "MBDocente_disciplina")
@ViewScoped
public class Docente_disciplinaBean {

	private List<Professor> itensProfessor = new ArrayList<Professor>();
	private List<Disciplina> itensDisciplina = new ArrayList<Disciplina>();
	private List<Docente_disciplina> itens = new ArrayList<Docente_disciplina>();
	private List<Docente_disciplina> itensFiltrados;
	private String professor;
	private String disciplina;

	private Docente_disciplina docente_disciplina;

	private List<Professor> comboProfessor;
	private List<Disciplina> comboDisciplina;

	public List<Professor> getItensProfessor() {
		return itensProfessor;
	}

	public void setItensProfessor(List<Professor> itensProfessor) {
		this.itensProfessor = itensProfessor;
	}

	public List<Disciplina> getItensDisciplina() {
		return itensDisciplina;
	}

	public void setItensDisciplina(List<Disciplina> itensDisciplina) {
		this.itensDisciplina = itensDisciplina;
	}

	public Docente_disciplina getDocente_disciplina() {
		return docente_disciplina;
	}

	public void setDocente_disciplina(Docente_disciplina docente_disciplina) {
		this.docente_disciplina = docente_disciplina;
	}

	public List<Professor> getComboProfessor() {
		return comboProfessor;
	}

	public void setComboProfessor(List<Professor> comboProfessor) {
		this.comboProfessor = comboProfessor;
	}

	public List<Disciplina> getComboDisciplina() {
		return comboDisciplina;
	}

	public void setComboDisciplina(List<Disciplina> comboDisciplina) {
		this.comboDisciplina = comboDisciplina;
	}

	public List<Docente_disciplina> getItens() {
		return itens;
	}

	public void setItens(List<Docente_disciplina> itens) {
		this.itens = itens;
	}

	public List<Docente_disciplina> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(List<Docente_disciplina> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public void carregarListagem() {

		try {
			Docente_disciplinaDAO ddDAO = new Docente_disciplinaDAO();
			itens = ddDAO.listar(professor, disciplina);
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao carregar a listagem, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void prepararNovo() {

		try {
			docente_disciplina = new Docente_disciplina();

			ProfessorDAO pDAO = new ProfessorDAO();
			DisciplinaDAO dDAO = new DisciplinaDAO();

			comboProfessor = pDAO.listar();
			comboDisciplina = dDAO.listar();

		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao preparar novo, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void novo() {
		try {
			ProfessorDAO pDAO = new ProfessorDAO();
			DisciplinaDAO dDAO = new DisciplinaDAO();
			Docente_disciplinaDAO ddDAO = new Docente_disciplinaDAO();
			ddDAO.salvar(docente_disciplina);
			carregarListagem();

			JSFUtil.adicionarMensagemSucesso("Atribuição vinculada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao inserir uma nova atribuição, "
					+ "por favor contate o administrador do sistema.");
		}
	}

	public void excluir() {
		try {
			ProfessorDAO pDAO = new ProfessorDAO();
			DisciplinaDAO dDAO = new DisciplinaDAO();
			Docente_disciplinaDAO ddDAO = new Docente_disciplinaDAO();

			ddDAO.excluir(docente_disciplina);

			itensProfessor = pDAO.listar();
			itensDisciplina = dDAO.listar();

			JSFUtil.adicionarMensagemSucesso("Atribuição desvinculada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao desvincular a atribuição, "
					+ "Por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void prepararEditar() {
		try {
			ProfessorDAO pDAO = new ProfessorDAO();
			DisciplinaDAO dDAO = new DisciplinaDAO();

			comboProfessor = pDAO.listar();
			comboDisciplina = dDAO.listar();

		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro no prepararEditar, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void editar() {
		try {
			ProfessorDAO pDAO = new ProfessorDAO();
			DisciplinaDAO dDAO = new DisciplinaDAO();
			Docente_disciplinaDAO ddDAO = new Docente_disciplinaDAO();

			ddDAO.editar(docente_disciplina);

			itensProfessor = pDAO.listar();
			itensDisciplina = dDAO.listar();

			JSFUtil.adicionarMensagemSucesso("Atribuição alterada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao tentar editar a atribuição, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

}
