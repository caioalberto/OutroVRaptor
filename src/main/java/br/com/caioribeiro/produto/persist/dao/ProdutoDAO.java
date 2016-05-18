package br.com.caioribeiro.produto.persist.dao;

import static org.hibernate.criterion.MatchMode.ANYWHERE;
import static org.hibernate.criterion.Order.asc;
import static org.hibernate.criterion.Restrictions.ilike;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caioribeiro.produto.model.Produto;

/**
 * The Class ProdutoDAO.
 */
@Component
public class ProdutoDAO {
	
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
		return this.session.createCriteria(Produto.class).addOrder(asc("id")).list();
	}

	/**
	 * Load.
	 *
	 * @param id the id
	 * @return the produto
	 */
	public Produto load(Long id) {
		return (Produto) this.session.get(Produto.class, id);
	}

	/**
	 * Update.
	 *
	 * @param produto the produto
	 */
	public void update(Produto produto) {
		this.transaction = session.beginTransaction();
		this.session.update(produto);
		transaction.commit();
	}

	/**
	 * Delete.
	 *
	 * @param produto the produto
	 */
	public void delete(Produto produto) {
		this.transaction = session.beginTransaction();
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
