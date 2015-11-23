package br.com.sga.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sga.DAO.DisciplinaDAO;
import br.com.sga.DAO.TopicoDAO;
import br.com.sga.domain.Disciplina;
import br.com.sga.domain.Topico;
import br.com.sga.util.JSFUtil;

@ManagedBean(name = "MBTopico")
@ViewScoped
public class TopicoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Topico> itens;
	private List<Topico> itensFiltrados;

	private Topico topico;
	private List<Disciplina> comboDisciplinas;

	public List<Topico> getItens() {
		return itens;
	}

	public void setItens(List<Topico> itens) {
		this.itens = itens;
	}

	public List<Topico> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(List<Topico> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public Topico getTopico() {
		return topico;
	}

	public void setTopico(Topico topico) {
		this.topico = topico;
	}

	public List<Disciplina> getComboDisciplinas() {
		return comboDisciplinas;
	}

	public void setComboDisciplinas(List<Disciplina> comboDisciplinas) {
		this.comboDisciplinas = comboDisciplinas;
	}

	public void carregarListagem() {

		try {
			TopicoDAO tDAO = new TopicoDAO();
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
			topico = new Topico();
			DisciplinaDAO dDAO = new DisciplinaDAO();

			comboDisciplinas = dDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao preparar novo, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void novo() {
		try {
			TopicoDAO tDAO = new TopicoDAO();
			tDAO.salvar(topico);
			itens = tDAO.listar();
			JSFUtil.adicionarMensagemSucesso("Tópico cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao inserir um novo registro, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void excluir() {
		try {
			TopicoDAO tDAO = new TopicoDAO();
			tDAO.excluir(topico);

			itens = tDAO.listar();
			JSFUtil.adicionarMensagemSucesso("Tópico excluÃ­da com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao excluir o tópico, "
					+ "Por favor contate o administrador do sistema.");
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
			TopicoDAO tDAO = new TopicoDAO();
			tDAO.editar(topico);
			itens = tDAO.listar();
			JSFUtil.adicionarMensagemSucesso("Tópico alterado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao tentar editar o tópico");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}
}
