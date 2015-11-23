package br.com.sga.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sga.DAO.QuestaoDAO;
import br.com.sga.DAO.Questao_topicoDAO;
import br.com.sga.DAO.TopicoDAO;
import br.com.sga.domain.Questao;
import br.com.sga.domain.Questao_topico;
import br.com.sga.domain.Topico;
import br.com.sga.util.JSFUtil;

@ManagedBean(name = "MBQuestao_topico")
@ViewScoped
public class Questao_topicoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Questao> itensquestao = new ArrayList<Questao>();
	private List<Topico> itenstopico = new ArrayList<Topico>();
	private List<Questao_topico> itens = new ArrayList<Questao_topico>();
	private List<Questao_topico> itensFiltrados;
	private String assunto;
	private String descricao;

	private Questao_topico questao_topico;

	private List<Questao> comboquestao;
	private List<Topico> combotopico;

	public List<Questao> getItensquestao() {
		return itensquestao;
	}

	public void setItensquestao(List<Questao> itensquestao) {
		this.itensquestao = itensquestao;
	}

	public List<Topico> getItenstopico() {
		return itenstopico;
	}

	public void setItenstopico(List<Topico> itenstopico) {
		this.itenstopico = itenstopico;
	}

	public List<Questao_topico> getItens() {
		return itens;
	}

	public void setItens(List<Questao_topico> itens) {
		this.itens = itens;
	}

	public List<Questao_topico> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(List<Questao_topico> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Questao_topico getQuestao_topico() {
		return questao_topico;
	}

	public void setQuestao_topico(Questao_topico questao_topico) {
		this.questao_topico = questao_topico;
	}

	public List<Questao> getComboquestao() {
		return comboquestao;
	}

	public void setComboquestao(List<Questao> comboquestao) {
		this.comboquestao = comboquestao;
	}

	public List<Topico> getCombotopico() {
		return combotopico;
	}

	public void setCombotopico(List<Topico> combotopico) {
		this.combotopico = combotopico;
	}

	public void carregarListagem() {

		try {
			// parei aqui - pode dar erro
			Questao_topicoDAO qtDAO = new Questao_topicoDAO();
			itens = qtDAO.listar(assunto, descricao);
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao carregar a listagem, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void prepararNovo() {

		try {
			questao_topico = new Questao_topico();

			QuestaoDAO pDAO = new QuestaoDAO();
			TopicoDAO dDAO = new TopicoDAO();

			comboquestao = pDAO.listar();
			combotopico = dDAO.listar();

		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao preparar novo, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void novo() {
		try {
			QuestaoDAO pDAO = new QuestaoDAO();
			TopicoDAO dDAO = new TopicoDAO();
			Questao_topicoDAO ddDAO = new Questao_topicoDAO();
			ddDAO.salvar(questao_topico);
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
			QuestaoDAO pDAO = new QuestaoDAO();
			TopicoDAO dDAO = new TopicoDAO();
			Questao_topicoDAO ddDAO = new Questao_topicoDAO();

			ddDAO.excluir(questao_topico);

			itensquestao = pDAO.listar();
			itenstopico = dDAO.listar();

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
			QuestaoDAO pDAO = new QuestaoDAO();
			TopicoDAO dDAO = new TopicoDAO();

			comboquestao = pDAO.listar();
			combotopico = dDAO.listar();

		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro no prepararEditar, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void editar() {
		try {
			QuestaoDAO pDAO = new QuestaoDAO();
			TopicoDAO dDAO = new TopicoDAO();
			Questao_topicoDAO ddDAO = new Questao_topicoDAO();

			ddDAO.editar(questao_topico);

			itensquestao = pDAO.listar();
			itenstopico = dDAO.listar();

			JSFUtil.adicionarMensagemSucesso("Atribuição alterada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao tentar editar a atribuição, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

}
