package br.com.sga.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.sga.domain.Questao;
import br.com.sga.util.HibernateUtil;

public class QuestaoDAO {

	public void salvar(Questao questao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(questao);
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
	public List<Questao> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Questao> questoes = null;

		try {
			Query consulta = sessao.getNamedQuery("Questao.listar");
			questoes = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return questoes;
	}

	public Questao buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Questao questao = null;

		try {
			Query consulta = sessao.getNamedQuery("Professor.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			questao = (Questao) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return questao;
	}

	public void excluir(Questao questao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(questao);
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

	public void editar(Questao questao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();

			sessao.update(questao);
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
