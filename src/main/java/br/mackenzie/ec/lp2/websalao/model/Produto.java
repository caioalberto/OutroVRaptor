package br.mackenzie.ec.lp2.websalao.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * The Class Produto.
 */
@Entity
public class Produto {

	/**
	 * Instantiates a new produto.
	 */
	public Produto() {

	}

	/** The id. */
	@Id
	@GeneratedValue
	private Long id;

	/** The nome. */
	@NotBlank(message = "{campo.obrigatorio}")
	@Length(min = 3, message = "Nome deve ter no mínimo {min} caracteres!")
	private String nome;

	/** The descricao. */
	@NotBlank(message = "{campo.obrigatorio}")
	@Length(min = 5, message = "Descrição deve ter no mínimo {min} caracteres!")
	private String descricao;

	/** The preco. */
	@NotNull(message = "{campo.obrigatorio}")
	private BigDecimal preco;
	
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
	 * Gets the descricao.
	 *
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Sets the descricao.
	 *
	 * @param descricao the new descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Gets the preco.
	 *
	 * @return the preco
	 */
	public BigDecimal getPreco() {
		return preco;
	}

	/**
	 * Sets the preco.
	 *
	 * @param preco the new preco
	 */
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
