package br.com.sga.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sga.domain.Professor;
import br.com.sga.util.HibernateUtil;

public class ProfessorDAO {

	public void salvar(Professor professor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(professor);
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
	public List<Professor> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Professor> professores = null;

		try {
			Query consulta = sessao.getNamedQuery("Professor.listar");
			professores = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return professores;
	}

	public Professor buscarPorCodigo(Long profCod) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Professor professor = null;

		try {
			Query consulta = sessao.getNamedQuery("Professor.buscarPorCodigo");
			consulta.setLong("profCod", profCod);

			professor = (Professor) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return professor;
	}

	public void excluir(Professor professor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(professor);
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

	public void editar(Professor professor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();

			sessao.update(professor);
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
}
/*
 * public void salvar(Professor p) throws SQLException { StringBuilder sql = new
 * StringBuilder(); sql.append("INSERT INTO professor ");
 * sql.append("(profNome, profAreaAtuacao, profCampus, profSenha) ");
 * sql.append("VALUES (?,?,?,MD5(?))");
 * 
 * Connection conexao = ConexaoFactory.conectar();
 * 
 * PreparedStatement comando = conexao.prepareStatement(sql.toString());
 * 
 * comando.setString(1, p.getProfNome()); comando.setString(2,
 * p.getProfAreaAtuacao()); comando.setString(3, p.getProfCampus());
 * comando.setString(4, p.getProfSenha());
 * 
 * comando.executeUpdate(); }
 * 
 * public void excluir(Professor p) throws SQLException { StringBuilder sql =
 * new StringBuilder(); sql.append("DELETE FROM professor WHERE profCod=? ");
 * 
 * Connection conexao = ConexaoFactory.conectar();
 * 
 * PreparedStatement comando = conexao.prepareStatement(sql.toString());
 * comando.setLong(1, p.getProfCod());
 * 
 * comando.executeUpdate(); }
 * 
 * public void editar(Professor p) throws SQLException { StringBuilder sql = new
 * StringBuilder();
 * 
 * sql.append(
 * "UPDATE professor SET profNome=?, profAreaAtuacao=?, profCampus=?, profSenha=MD5(?)"
 * + " WHERE profCod=?");
 * 
 * Connection conexao = ConexaoFactory.conectar();
 * 
 * PreparedStatement comando = conexao.prepareStatement(sql.toString());
 * 
 * comando.setString(1, p.getProfNome()); comando.setString(2,
 * p.getProfAreaAtuacao()); comando.setString(3, p.getProfCampus());
 * comando.setString(4, p.getProfSenha()); comando.setLong(5, p.getProfCod());
 * 
 * 
 * comando.executeUpdate(); }
 * 
 * public Professor buscarPorCodigo(Professor p) throws SQLException {
 * StringBuilder sql = new StringBuilder();
 * 
 * sql.append(
 * "SELECT profNome, profAreaAtuacao, profCampus, profSenha FROM professor" +
 * " WHERE profCod=?");
 * 
 * Connection conexao = ConexaoFactory.conectar();
 * 
 * PreparedStatement comando = conexao.prepareStatement(sql.toString());
 * comando.setLong(1, p.getProfCod());
 * 
 * ResultSet resultado = comando.executeQuery();
 * 
 * Professor retorno = null;
 * 
 * if (resultado.next()) { retorno = new Professor();
 * 
 * retorno.setProfCod(resultado.getLong("profCod"));
 * retorno.setProfNome(resultado.getString("profNome"));
 * retorno.setProfAreaAtuacao(resultado.getString("profAreaAtuacao"));
 * retorno.setProfCampus(resultado.getString("profCampus"));
 * retorno.setProfSenha(resultado.getString("profSenha")); } return retorno; }
 * 
 * public ArrayList<Professor> listar() throws SQLException { StringBuilder sql
 * = new StringBuilder();
 * 
 * sql.append(
 * "SELECT profCod ,profNome, profAreaAtuacao, profCampus, profSenha FROM professor "
 * ); sql.append("ORDER BY profNome ASC ");
 * 
 * Connection conexao = new ConexaoFactory().conectar();
 * 
 * PreparedStatement comando = conexao.prepareStatement(sql.toString());
 * 
 * ResultSet resultado = comando.executeQuery();
 * 
 * ArrayList<Professor> lista = new ArrayList<Professor>();
 * 
 * while (resultado.next()) { Professor p = new Professor();
 * 
 * p.setProfCod(resultado.getLong("profCod"));
 * p.setProfNome(resultado.getString("profNome"));
 * p.setProfAreaAtuacao(resultado.getString("profAreaAtuacao"));
 * p.setProfCampus(resultado.getString("profCampus"));
 * p.setProfSenha(resultado.getString("profSenha"));
 * 
 * lista.add(p); } return lista; }
 */

