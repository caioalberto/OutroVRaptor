package br.mackenzie.ec.lp2.websalao.persist.dao;

import static org.hibernate.criterion.MatchMode.ANYWHERE;
import static org.hibernate.criterion.Order.asc;
import static org.hibernate.criterion.Restrictions.ilike;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.mackenzie.ec.lp2.websalao.model.Produto;

/**
 * The Class ProdutoDAO.
 */
@Component
public class ProdutoDAO implements GenericoDAO<Produto>{
	
	/** The session. */
	private Session session;
	
	/** The transaction. */
	private Transaction transaction;

	/**
	 * Instantiates a new produto dao.
	 *
	 * @param session the session
	 */
	public ProdutoDAO(Session session) {
		this.session = session;
	}

	/**
	 * Save.
	 *
	 * @param produto the produto
	 */
	public void save(Produto produto) {
		transaction = session.beginTransaction();
		session.save(produto);
		transaction.commit();
		session.close();
	}

	/**
	 * List all.
	 *
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Produto> listAll() {
		return session.createCriteria(Produto.class).addOrder(asc("id")).list();
	}

	/**
	 * Load.
	 *
	 * @param id the id
	 * @return the produto
	 */
	public Produto load(Long id) {
		return (Produto) session.get(Produto.class, id);
	}

	/**
	 * Update.
	 *
	 * @param produto the produto
	 */
	public void update(Produto produto) {
		transaction = session.beginTransaction();
		session.update(produto);
		transaction.commit();
		session.close();
	}

	/**
	 * Delete.
	 *
	 * @param produto the produto
	 */
	public void delete(Produto produto) {
		transaction = session.beginTransaction();
		session.delete(produto);
		transaction.commit();
		session.close();
	}

	/**
	 * Search.
	 *
	 * @param nome the nome
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Produto> search(String nome) {
		return session.createCriteria(Produto.class).add(ilike("nome", nome, ANYWHERE)).list();
	}

	/**
	 * Reload.
	 *
	 * @param produto the produto
	 */
	public void reload(Produto produto) {
		session.refresh(produto);
	}

}
