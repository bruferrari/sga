package br.com.sga.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sga.domain.Turma;
import br.com.sga.util.HibernateUtil;

public class TurmaDAO {

	public void salvar(Turma turma) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(turma);
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
	public List<Turma> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Turma> turmas = null;

		try {
			Query consulta = sessao.getNamedQuery("Turma.listar");
			turmas = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return turmas;
	}
	
	public Turma buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Turma turma = null;

		try {
			Query consulta = sessao.getNamedQuery("Turma.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			turma = (Turma) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return turma;
	}
	
	public void excluir(Turma turma) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(turma);
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
	
	public void editar(Turma turma) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();

			sessao.update(turma);
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
	
	/* public void salvar(Turma t) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO turma ");
		sql.append("(ciclo, ano, periodo) ");
		sql.append("VALUES (?,?,?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, t.getCiclo());
		comando.setLong(2, t.getAno());
		comando.setString(3, t.getPeriodo());

		comando.executeUpdate();
	}

	public void excluir(Turma t) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM turma WHERE codigo=? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, t.getCodigo());

		comando.executeUpdate();
	}

	public void editar(Turma t) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE turma SET ciclo=?, ano=?, periodo=? WHERE codigo=?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, t.getCiclo());
		comando.setLong(2, t.getAno());
		comando.setString(3, t.getPeriodo());
		comando.setLong(4, t.getCodigo());

		comando.executeUpdate();
	}

	public ArrayList<Turma> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT codigo, ciclo, ano, periodo FROM turma ");
		sql.append("ORDER BY ano ASC ");

		Connection conexao = new ConexaoFactory().conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Turma> lista = new ArrayList<Turma>();

		while (resultado.next()) {
			
			Turma t = new Turma();

			t.setCodigo(resultado.getLong("codigo"));
			t.setCiclo(resultado.getString("ciclo"));
			t.setAno(resultado.getLong("ano"));
			t.setPeriodo(resultado.getString("periodo"));

			lista.add(t);
		}
		return lista;
	} */
}
