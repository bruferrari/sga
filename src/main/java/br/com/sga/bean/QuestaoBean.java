package br.com.sga.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.sga.DAO.QuestaoDAO;
import br.com.sga.domain.Questao;
import br.com.sga.util.JSFUtil;

@ManagedBean(name = "MBQuestao")
@ViewScoped
public class QuestaoBean {

	private List<Questao> itens;
	private List<Questao> itensFiltrados;

	private Questao questao;
	private List<Questao> comboQuestoes;

	private String enunciado;

	public List<Questao> getItens() {
		return itens;
	}

	public void setItens(List<Questao> itens) {
		this.itens = itens;
	}

	public List<Questao> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(List<Questao> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public List<Questao> getComboQuestoes() {
		return comboQuestoes;
	}

	public void setComboQuestoes(List<Questao> comboQuestoes) {
		this.comboQuestoes = comboQuestoes;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public void carregarListagem() {

		try {
			QuestaoDAO qDAO = new QuestaoDAO();
			itens = qDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao carregar a listagem, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void prepararNovo() {

		try {
			questao = new Questao();
			QuestaoDAO qDAO = new QuestaoDAO();
			comboQuestoes = qDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao preparar novo, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void novo() {
		try {
			QuestaoDAO qDAO = new QuestaoDAO();
			qDAO.salvar(questao);
			itens = qDAO.listar();
			JSFUtil.adicionarMensagemSucesso("Questão cadastrada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao inserir um novo registro, "
					+ "por favor contate o administrador do sistema.");
		}
	}

	public void excluir() {
		try {
			QuestaoDAO qDAO = new QuestaoDAO();
			qDAO.excluir(questao);

			itens = qDAO.listar();
			JSFUtil.adicionarMensagemSucesso("Questão excluída com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao excluir a Questão, "
					+ "Por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void prepararEditar() {
		try {
			QuestaoDAO qDAO = new QuestaoDAO();
			comboQuestoes = qDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro no prepararEditar, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void editar() {
		try {
			QuestaoDAO qDAO = new QuestaoDAO();
			qDAO.editar(questao);
			itens = qDAO.listar();
			JSFUtil.adicionarMensagemSucesso("Questão alterada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao tentar editar a Questão, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

}
