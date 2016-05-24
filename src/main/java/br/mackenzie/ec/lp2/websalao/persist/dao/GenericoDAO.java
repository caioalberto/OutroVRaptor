package br.mackenzie.ec.lp2.websalao.persist.dao;

import java.util.List;

/**
 * The Interface GenericoDAO.
 *
 * @param <T> the generic type
 */
public interface GenericoDAO<T> {

    /**
     * Save.
     *
     * @param t the t
     */
    public void save(T t);

    /**
     * List all.
     *
     * @return the list
     */
    public List<T> listAll();

    /**
     * Load.
     *
     * @param id the id
     * @return the t
     */
    public T load(Long id);

    /**
     * Update.
     *
     * @param t the t
     */
    public void update(T t);

    /**
     * Delete.
     *
     * @param t the t
     */
    public void delete(T t);

    /**
     * Search.
     *
     * @param campo the campo
     */
    public List<T> search(String campo);
}
