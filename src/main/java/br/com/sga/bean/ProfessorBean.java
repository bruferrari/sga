package br.com.sga.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.sga.DAO.ProfessorDAO;
import br.com.sga.domain.Professor;
import br.com.sga.util.JSFUtil;

@ManagedBean(name = "MBProfessor")
@ViewScoped
public class ProfessorBean {

	private Professor professor;

	public Professor getProfessor() {
		return professor;
	}

	private ListDataModel<Professor> itens;
	private List<Professor> itensFiltrados;

	public ListDataModel<Professor> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Professor> itens) {
		this.itens = itens;
	}

	public List<Professor> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(List<Professor> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			ProfessorDAO pDAO = new ProfessorDAO();
			List<Professor> lista = pDAO.listar();
			itens = new ListDataModel<Professor>(lista);
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao preparar a pesquisa");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void prepararNovo() {
		professor = new Professor();
	}

	public void novo() {

		try {

			ProfessorDAO pDAO = new ProfessorDAO();
			pDAO.salvar(professor);
			List<Professor> lista = pDAO.listar();
			itens = new ListDataModel<Professor>(lista);
			JSFUtil.adicionarMensagemSucesso("Cadastro efetuado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao inserir um novo Professor.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void prepararExcluir() {
		professor = itens.getRowData();
	}

	public void excluir() {
		try {
			ProfessorDAO pDAO = new ProfessorDAO();
			pDAO.excluir(professor);

			List<Professor> lista = pDAO.listar();
			itens = new ListDataModel<Professor>(lista);

			JSFUtil.adicionarMensagemSucesso("Professor excluído com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao excluir o professor.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void prepararEditar() {
		professor = itens.getRowData();
	}

	public void editar() {
		try {

			ProfessorDAO pDAO = new ProfessorDAO();
			pDAO.editar(professor);

			List<Professor> lista = pDAO.listar();
			itens = new ListDataModel<Professor>(lista);

			JSFUtil.adicionarMensagemSucesso("Professor editado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao editar o professor.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}
}
