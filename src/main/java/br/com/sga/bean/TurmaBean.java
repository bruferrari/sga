package br.com.sga.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sga.DAO.TurmaDAO;
import br.com.sga.domain.Turma;
import br.com.sga.util.JSFUtil;

@ManagedBean(name = "MBTurma")
@ViewScoped
public class TurmaBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Turma> itens;
	private List<Turma> itensFiltrados;

	private Turma turma;
	private List<Turma> comboTurma;

	public List<Turma> getItens() {
		return itens;
	}

	public void setItens(List<Turma> itens) {
		this.itens = itens;
	}

	public List<Turma> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(List<Turma> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Turma> getComboTurma() {
		return comboTurma;
	}

	public void setComboTurma(ArrayList<Turma> comboTurma) {
		this.comboTurma = comboTurma;
	}

	public void carregarListagem() {

		try {
			TurmaDAO tDAO = new TurmaDAO();
			itens = tDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao carregar a listagem, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void prepararNovo() {

		try {
			turma = new Turma();

			TurmaDAO tDAO = new TurmaDAO();

			comboTurma = tDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao preparar novo, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void novo() {
		try {
			TurmaDAO tDAO = new TurmaDAO();
			tDAO.salvar(turma);
			itens = tDAO.listar();
			JSFUtil.adicionarMensagemSucesso("Turma cadastrada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao inserir um novo registro, "
					+ "por favor contate o administrador do sistema.");
		}
	}
	
	public void excluir() {
		try {
			TurmaDAO tDAO = new TurmaDAO();
			tDAO.excluir(turma);

			itens = tDAO.listar();
			JSFUtil.adicionarMensagemSucesso("Turma excluída com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao excluir a Turma, "
					+ "Por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}
	
	public void prepararEditar() {
		try {
			TurmaDAO tDAO = new TurmaDAO();
			comboTurma = tDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro no prepararEditar");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}
	
	public void editar() {
		try {
			TurmaDAO tDAO = new TurmaDAO();
			tDAO.editar(turma);
			itens = tDAO.listar();
			JSFUtil.adicionarMensagemSucesso("Turma alterada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao tentar editar a turma");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}
}
