package br.com.sga.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sga.DAO.DisciplinaDAO;
import br.com.sga.domain.Disciplina;
import br.com.sga.util.JSFUtil;

@ManagedBean(name = "MBDisciplina")
@ViewScoped
public class DisciplinaBean {

	private List<Disciplina> itens;
	private List<Disciplina> itensFiltrados;

	private Disciplina disciplina;
	private List<Disciplina> comboDisciplinas;

	public List<Disciplina> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Disciplina> itens) {
		this.itens = itens;
	}

	public List<Disciplina> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(List<Disciplina> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Disciplina> getComboDisciplinas() {
		return comboDisciplinas;
	}

	public void setComboDisciplinas(ArrayList<Disciplina> comboDisciplinas) {
		this.comboDisciplinas = comboDisciplinas;
	}

	public void carregarListagem() {

		try {
			DisciplinaDAO dDAO = new DisciplinaDAO();
			itens = dDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao carregar a listagem de disciplinas");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void prepararNovo() {

		try {
			disciplina = new Disciplina();

			DisciplinaDAO dDAO = new DisciplinaDAO();

			comboDisciplinas = dDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao preparar novo");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void novo() {
		try {
			DisciplinaDAO dDAO = new DisciplinaDAO();
			dDAO.salvar(disciplina);
			itens = dDAO.listar();
			JSFUtil.adicionarMensagemSucesso("Disciplina incluída com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao incluir uma nova disciplina");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void excluir() {
		try {
			DisciplinaDAO dDAO = new DisciplinaDAO();
			dDAO.excluir(disciplina);

			itens = dDAO.listar();
			JSFUtil.adicionarMensagemSucesso("Disciplina excluída com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao excluir a disciplina");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void prepararEditar() {
		try {
			DisciplinaDAO dDAO = new DisciplinaDAO();
			comboDisciplinas = dDAO.listar();

		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro no prepararEditar");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void editar() {
		try {
			DisciplinaDAO dDAO = new DisciplinaDAO();
			dDAO.editar(disciplina);
			itens = dDAO.listar();
			JSFUtil.adicionarMensagemSucesso("Disciplina editada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao tentar editar a disciplina");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}
}
