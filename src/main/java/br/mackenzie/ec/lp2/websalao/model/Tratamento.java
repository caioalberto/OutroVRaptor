package br.mackenzie.ec.lp2.websalao.model;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.FetchType.EAGER;

import java.util.Calendar;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.mackenzie.ec.lp2.websalao.model.enums.Moeda;

/**
 * The Class Tratamento.
 */
@SessionScoped
@Component
@Entity
public class Tratamento {

    /** The id. */
    @Id
    @GeneratedValue
    private Long id;

    /** The produto. */
    @Valid
    @OneToOne(cascade = MERGE, fetch = EAGER)
    private Produto produto;

    /** The funcionario responsavel. */
    @Valid
    @OneToOne(cascade = MERGE, fetch = EAGER)
    private Funcionario responsavel;

    @Embedded
    private Dinheiro preco;
    
    /** The hora inicio. */
    private Integer horaInicio;

    /** The hora fim. */
    private Integer horaFim;

    /** The data. */
    @Future(message = "A data deve ser posterior ao dia atual!")
    private Calendar data;

    /** The dia nome. */
    private String diaNome;

    /** The data nome. */
    private String dataNome;

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
     * Gets the produto.
     *
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Sets the produto.
     *
     * @param produto the new produto
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * Gets the funcionario responsavel.
     *
     * @return the funcionario responsavel
     */
    public Funcionario getResponsavel() {
        return responsavel;
    }

    /**
     * Sets the funcionario responsavel.
     *
     * @param funcionarioResponsavel the new funcionario responsavel
     */
    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    /**
     * Gets the hora inicio.
     *
     * @return the hora inicio
     */
    public Integer getHoraInicio() {
        return horaInicio;
    }

    /**
     * Sets the hora inicio.
     *
     * @param horaInicio the new hora inicio
     */
    public void setHoraInicio(Integer horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Gets the hora fim.
     *
     * @return the hora fim
     */
    public Integer getHoraFim() {
        return horaFim;
    }

    /**
     * Sets the hora fim.
     *
     * @param horaFim the new hora fim
     */
    public void setHoraFim(Integer horaFim) {
        this.horaFim = horaFim;
    }

    /**
     * Gets the dia nome.
     *
     * @return the dia nome
     */
    public String getDiaNome() {
        return diaNome;
    }

    /**
     * Sets the dia nome.
     *
     * @param diaNome the new dia nome
     */
    public void setDiaNome(String diaNome) {
        this.diaNome = diaNome;
    }

    /**
     * Gets the data.
     *
     * @return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * Sets the data.
     *
     * @param data the new data
     */
    public void setData(Calendar data) {
        this.data = data;
    }

    /**
     * Gets the data nome.
     *
     * @return the data nome
     */
    public String getDataNome() {
        return dataNome;
    }

    /**
     * Sets the data nome.
     *
     * @param dataNome the new data nome
     */
    public void setDataNome(String dataNome) {
        this.dataNome = dataNome;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.data).append(this.horaInicio).append(this.horaFim).toHashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tratamento)) {
            return false;
        }
        Tratamento other = (Tratamento) obj;
        return new EqualsBuilder().append(this.data, other.data).append(this.horaInicio, other.horaInicio).append(this.horaFim, other.horaFim).isEquals();
    }

}
