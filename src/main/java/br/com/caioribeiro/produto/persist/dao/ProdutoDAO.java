package br.com.caioribeiro.produto.persist.dao;

import static org.hibernate.criterion.Restrictions.ilike;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caioribeiro.produto.model.Produto;

@Component
public class ProdutoDAO {
	private Session session;
	private Transaction transaction;

	public ProdutoDAO(Session session) {
		this.session = session;
	}

	public void save(Produto produto) {
		transaction = session.beginTransaction();
		session.save(produto);
		transaction.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listAll() {
		return this.session.createCriteria(Produto.class).list();
	}

	public Produto load(Long id) {
		return (Produto) this.session.get(Produto.class, id);
	}

	public void update(Produto produto) {
		this.transaction = session.beginTransaction();
		this.session.update(produto);
		transaction.commit();
	}

	public void delete(Produto produto) {
		this.transaction = session.beginTransaction();
		session.delete(produto);
		transaction.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> search(String nome) {
		return session.createCriteria(Produto.class).add(ilike("nome", nome, MatchMode.ANYWHERE)).list();
	}

	public void reload(Produto produto) {
		session.refresh(produto);
	}

}
