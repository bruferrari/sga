package br.com.sga.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sga.domain.Aluno;
import br.com.sga.util.HibernateUtil;

public class AlunoDAO {

	public void salvar(Aluno aluno) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(aluno);
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
	public List<Aluno> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Aluno> alunos = null;

		try {
			Query consulta = sessao.getNamedQuery("Aluno.listar");
			alunos = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return alunos;
	}

	public Aluno buscarPorCodigo(Long ra) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Aluno aluno = null;

		try {
			Query consulta = sessao.getNamedQuery("Professor.buscarPorCodigo");
			consulta.setLong("ra", ra);

			aluno = (Aluno) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return aluno;
	}

	public void excluir(Aluno aluno) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(aluno);
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

	public void editar(Aluno aluno) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();

			sessao.update(aluno);
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
