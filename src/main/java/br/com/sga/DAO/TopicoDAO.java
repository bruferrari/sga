package br.com.sga.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sga.domain.Topico;
import br.com.sga.util.HibernateUtil;

public class TopicoDAO {

	public void salvar(Topico topico) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(topico);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Topico> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Topico> itens = null;
		try {
			Query consulta = sessao.getNamedQuery("Topico.listar");
			itens = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return itens;
	}

	public Topico buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Topico item = null;

		try {
			Query consulta = sessao.getNamedQuery("Topico.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			item = (Topico) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return item;
	}

	public void excluir(Topico topico) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(topico);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}

	public void editar(Topico topico) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(topico);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}

	/*
	 * public void salvar(Topico t) throws SQLException { StringBuilder sql =
	 * new StringBuilder(); sql.append("INSERT INTO topico ");
	 * sql.append("(descricao, disciplina_codigo) ");
	 * sql.append("VALUES (?,?)");
	 * 
	 * Connection conexao = ConexaoFactory.conectar();
	 * 
	 * PreparedStatement comando = conexao.prepareStatement(sql.toString());
	 * 
	 * comando.setString(1, t.getDescricao()); comando.setLong(2,
	 * t.getDisciplina().getCodigo());
	 * 
	 * comando.executeUpdate(); }
	 * 
	 * public void excluir(Topico t) throws SQLException { StringBuilder sql =
	 * new StringBuilder(); sql.append("DELETE FROM topico WHERE codigo=? ");
	 * 
	 * Connection conexao = ConexaoFactory.conectar();
	 * 
	 * PreparedStatement comando = conexao.prepareStatement(sql.toString());
	 * comando.setLong(1, t.getCodigo());
	 * 
	 * comando.executeUpdate(); }
	 * 
	 * public void editar(Topico t) throws SQLException { StringBuilder sql =
	 * new StringBuilder();
	 * 
	 * sql.append("UPDATE topico SET descricao=? WHERE codigo=?");
	 * 
	 * Connection conexao = ConexaoFactory.conectar();
	 * 
	 * PreparedStatement comando = conexao.prepareStatement(sql.toString());
	 * 
	 * comando.setString(1, t.getDescricao()); comando.setLong(2,
	 * t.getCodigo());
	 * 
	 * comando.executeUpdate(); }
	 * 
	 * public ArrayList<Topico> listar() throws SQLException { StringBuilder sql
	 * = new StringBuilder();
	 * sql.append("SELECT t.codigo, t.descricao, d.codigo, d.descricao ");
	 * sql.append("FROM topico t ");
	 * sql.append("INNER JOIN disciplina d ON d.codigo = t.disciplina_codigo");
	 * 
	 * Connection conexao = ConexaoFactory.conectar();
	 * 
	 * PreparedStatement comando = conexao.prepareStatement(sql.toString());
	 * 
	 * ResultSet resultado = comando.executeQuery();
	 * 
	 * ArrayList<Topico> itens = new ArrayList<Topico>(); while
	 * (resultado.next()) { Disciplina d = new Disciplina();
	 * d.setCodigo(resultado.getLong("d.codigo"));
	 * d.setDescricao(resultado.getString("d.descricao"));
	 * 
	 * Topico t = new Topico(); t.setCodigo(resultado.getLong("t.codigo"));
	 * t.setDescricao(resultado.getString("t.descricao")); t.setDisciplina(d);
	 * 
	 * itens.add(t); } return itens; }
	 */
}
