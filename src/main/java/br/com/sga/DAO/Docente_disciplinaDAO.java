package br.com.sga.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import sun.nio.cs.ext.MacHebrew;
import br.com.sga.domain.Docente_disciplina;
import br.com.sga.util.HibernateUtil;

public class Docente_disciplinaDAO {

	public void salvar(Docente_disciplina docente_disciplina) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(docente_disciplina);
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
	public List<Docente_disciplina> listar(String professor, String disciplina) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Docente_disciplina> docentes_disciplinas = null;

		try {
			//Query consulta = sessao.getNamedQuery("Docente_disciplina.listar");
			Criteria criteria = sessao.createCriteria(Docente_disciplina.class);
			criteria.createAlias("professor", "p");
			criteria.createAlias("disciplina", "d");
			criteria.add(Restrictions.ilike("p.profNome", professor+"%", MatchMode.ANYWHERE));
			criteria.add(Restrictions.ilike("d.descricao", disciplina+"%", MatchMode.ANYWHERE));
			return criteria.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
	}

	public Docente_disciplina buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Docente_disciplina docente_disciplina = null;

		try {
			Query consulta = sessao
					.getNamedQuery("Docente_disciplina.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			docente_disciplina = (Docente_disciplina) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return docente_disciplina;
	}

	public void excluir(Docente_disciplina docente_disciplina) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(docente_disciplina);
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

	public void editar(Docente_disciplina docente_disciplina) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();

			sessao.update(docente_disciplina);
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
