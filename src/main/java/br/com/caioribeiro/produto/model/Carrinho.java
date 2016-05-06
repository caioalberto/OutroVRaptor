package br.com.caioribeiro.produto.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class Carrinho {

    private List<Item> itens = new ArrayList<Item>();

    private BigDecimal total = new BigDecimal("0.0");

    private BigInteger totalItens = new BigInteger("0");

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void add(Item item) {
        itens.add(item);
        total = item.getProduto().getPreco().multiply(new BigDecimal(item.getQuantidade())).add(this.total);
        totalItens = this.totalItens.add(new BigInteger(item.getQuantidade()));
    }

    public BigInteger getTotalItens() {
        return totalItens;
    }

    public void remove(int indiceItem) {
        Item itemRemovido = itens.remove(indiceItem);
        total = total.subtract(new BigDecimal(itemRemovido.getQuantidade()).multiply(itemRemovido.getProduto().getPreco()));
        totalItens = this.totalItens.subtract(new BigInteger(itemRemovido.getQuantidade()));
        
    }

}
