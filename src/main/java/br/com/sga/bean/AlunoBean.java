package br.com.sga.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sga.DAO.AlunoDAO;
import br.com.sga.domain.Aluno;
import br.com.sga.util.JSFUtil;

@ManagedBean(name = "MBAluno")
@ViewScoped
public class AlunoBean {

	private List<Aluno> itens;
	private List<Aluno> itensFiltrados;

	private Aluno aluno;
	private List<Aluno> comboAluno;

	public List<Aluno> getItens() {
		return itens;
	}

	public void setItens(List<Aluno> itens) {
		this.itens = itens;
	}

	public List<Aluno> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(List<Aluno> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getComboAluno() {
		return comboAluno;
	}

	public void setComboAluno(List<Aluno> comboAluno) {
		this.comboAluno = comboAluno;
	}

	public void carregarListagem() {

		try {
			AlunoDAO aDAO = new AlunoDAO();
			itens = aDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao carregar a listagem, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void prepararNovo() {

		try {
			aluno = new Aluno();

			AlunoDAO aDAO = new AlunoDAO();

			comboAluno = aDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao preparar novo, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void novo() {
		try {
			AlunoDAO aDAO = new AlunoDAO();
			aDAO.salvar(aluno);
			itens = aDAO.listar();
			JSFUtil.adicionarMensagemSucesso("Aluno cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao inserir um novo registro, "
					+ "por favor contate o administrador do sistema.");
		}
	}

	public void excluir() {
		try {
			AlunoDAO aDAO = new AlunoDAO();
			aDAO.excluir(aluno);

			itens = aDAO.listar();
			JSFUtil.adicionarMensagemSucesso("Aluno excluído com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao excluir o Aluno, "
					+ "Por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void prepararEditar() {
		try {
			AlunoDAO aDAO = new AlunoDAO();
			comboAluno = aDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro no prepararEditar, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}

	public void editar() {
		try {
			AlunoDAO aDAO = new AlunoDAO();
			aDAO.editar(aluno);
			itens = aDAO.listar();
			JSFUtil.adicionarMensagemSucesso("Aluno alterado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Ocorreu um erro ao tentar editar o aluno, "
					+ "por favor contate o administrador do sistema.");
			JSFUtil.adicionarMensagemErro("ERRO: " + e.getMessage());
		}
	}
}
