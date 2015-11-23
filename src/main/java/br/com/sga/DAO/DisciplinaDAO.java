package br.com.sga.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sga.domain.Disciplina;
import br.com.sga.util.HibernateUtil;

public class DisciplinaDAO {
	
	
	public void salvar(Disciplina disciplina) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(disciplina);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Disciplina> disciplinas = null;

		try {
			Query consulta = sessao.getNamedQuery("Disciplina.listar");
			disciplinas = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return disciplinas;
	}
	
	public Disciplina buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Disciplina disciplina = null;

		try {
			Query consulta = sessao.getNamedQuery("Disciplina.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			disciplina = (Disciplina) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return disciplina;
	}
	
	public void excluir(Disciplina disciplina) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(disciplina);
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
	
	public void editar(Disciplina disciplina) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();

			sessao.update(disciplina);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}

	/*public void salvar(Disciplina d) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO disciplina ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, d.getDescricao());

		comando.executeUpdate();
	}

	public void excluir(Disciplina d) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM disciplina WHERE codigo=? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, d.getCodigo());

		comando.executeUpdate();
	}

	public void editar(Disciplina d) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE disciplina SET descricao=?" + " WHERE codigo=?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, d.getDescricao());
		comando.setLong(2, d.getCodigo());

		comando.executeUpdate();
	}

	public ArrayList<Disciplina> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT codigo ,descricao FROM disciplina ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = new ConexaoFactory().conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Disciplina> lista = new ArrayList<Disciplina>();

		while (resultado.next()) {
			Disciplina d = new Disciplina();

			d.setCodigo(resultado.getLong("codigo"));
			d.setDescricao(resultado.getString("descricao"));

			lista.add(d);
		}
		return lista;
	} */

}
