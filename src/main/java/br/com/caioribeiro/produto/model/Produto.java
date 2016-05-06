package br.com.caioribeiro.produto.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

@Entity
public class Produto {

	public Produto() {

	}

	@Id
	@GeneratedValue
	private Long id;

	@NotBlank(message = "Nome não deve estar vazio!")
	@Length(min = 3, message = "Nome deve ter no mínimo {min} caracteres!")
	private String nome;

	@NotBlank(message = "Descrição não deve estar vazia!")
	@Length(min = 5, message = "Descrição deve ter no mínimo {min} caracteres!")
	private String descricao;

	@NotNull(message = "Preço não deve estar vazio!")
	private BigDecimal preco;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
