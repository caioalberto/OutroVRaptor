package br.mackenzie.ec.lp2.websalao.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Class Usuario.
 */
@Entity
public class Usuario {

    /** The login. */
    @Id
    private String login;

    /** The senha. */
    private String senha;

    /** The nome. */
    private String nome;

    /**
     * Gets the login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login.
     *
     * @param login the new login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets the senha.
     *
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Sets the senha.
     *
     * @param senha the new senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the nome.
     *
     * @param nome the new nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

}
