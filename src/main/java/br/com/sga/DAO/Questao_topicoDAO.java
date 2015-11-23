package br.com.sga.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.sga.domain.Questao_topico;
import br.com.sga.util.HibernateUtil;

public class Questao_topicoDAO {

	public void salvar(Questao_topico questao_topico) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(questao_topico);
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
	public List<Questao_topico> listar(String questao, String topico) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Questao_topico> questao_topico = null;

		try {
			Criteria criteria = sessao.createCriteria(Questao_topico.class);
			criteria.createAlias("questao", "q");
			criteria.createAlias("topico", "t");
			criteria.add(Restrictions.ilike("q.assunto", questao+"%", MatchMode.ANYWHERE));
			criteria.add(Restrictions.ilike("t.descricao", topico+"%", MatchMode.ANYWHERE));
			return criteria.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
	}

	public Questao_topico buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Questao_topico questao_topico = null;

		try {
			Query consulta = sessao
					.getNamedQuery("Questao_topico.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			questao_topico = (Questao_topico) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return questao_topico;
	}

	public void excluir(Questao_topico questao_topico) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(questao_topico);
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

	public void editar(Questao_topico questao_topico) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();

			sessao.update(questao_topico);
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
