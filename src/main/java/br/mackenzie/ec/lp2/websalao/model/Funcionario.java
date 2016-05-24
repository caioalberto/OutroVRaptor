package br.mackenzie.ec.lp2.websalao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

/**
 * The Class Funcionario.
 */
@Entity
public class Funcionario {

    /** The id. */
    @Id
    @GeneratedValue
    private Long id;

    /** The nome. */
    @NotBlank(message = "{campo.obrigatorio}")
    private String nome;

    /** The profissao. */
    @NotBlank(message = "{campo.obrigatorio}")
    private String profissao;

    /** The usuario. */
    @Valid
    @OneToOne
    private Usuario usuario;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
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

    /**
     * Gets the profissao.
     *
     * @return the profissao
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * Sets the profissao.
     *
     * @param profissao the new profissao
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * Gets the usuario.
     *
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Sets the usuario.
     *
     * @param usuario the new usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
