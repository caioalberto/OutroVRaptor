package br.com.caioribeiro.produto.service;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.caioribeiro.produto.model.Produto;
import br.com.caioribeiro.produto.model.Tratamento;
import br.com.caioribeiro.produto.persist.dao.ProdutoDAO;

/**
 * The Class Utils.
 */
public final class Utils {

    /**
     * Instantiates a new utils.
     */
    private Utils() {
    }

    /**
     * Verify and set produto.
     *
     * @param tratamento the tratamento
     * @param produtoDao the produto dao
     */
    public static void verifyAndSetProduto(Tratamento tratamento, ProdutoDAO produtoDao) {
        List<Produto> produtos = produtoDao.listAll();

        for(Produto produto : produtos) {
            if (produto.getId() == tratamento.getProduto().getId()) {
                tratamento.setProduto(produto);
            }
        }
    }

    /**
     * Verify initial and final tratamento time.
     *
     * @param tratamento the tratamento
     * @return true, if successful
     
    public static boolean verifyInitialAndFinalTratamentoTime(Tratamento tratamento) {
        if (tratamento.getHoraFim() > tratamento.getHoraInicio(). {
            return false;
        }

        return true;
    }*/

}
