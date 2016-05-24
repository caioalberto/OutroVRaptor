package br.mackenzie.ec.lp2.websalao.service;

import static java.util.Calendar.DAY_OF_WEEK;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import br.mackenzie.ec.lp2.websalao.model.Funcionario;
import br.mackenzie.ec.lp2.websalao.model.Produto;
import br.mackenzie.ec.lp2.websalao.model.Tratamento;
import br.mackenzie.ec.lp2.websalao.persist.dao.FuncionarioDAO;
import br.mackenzie.ec.lp2.websalao.persist.dao.ProdutoDAO;

/**
 * The Class TratamentoService.
 */
public class TratamentoService {
    
    /**
     * Verify tratamento dia.
     *
     * @param tratamento the tratamento
     */
    public static void verifyTratamentoDia(Tratamento tratamento) {
        if (tratamento.getData().get(DAY_OF_WEEK) == 2) {
            tratamento.setDiaNome("Segunda-Feira");
        } else if (tratamento.getData().get(DAY_OF_WEEK) == 3) {
            tratamento.setDiaNome("Terça-Feira");
        } else if (tratamento.getData().get(DAY_OF_WEEK) == 4) {
            tratamento.setDiaNome("Quarta-Feira");
        } else if (tratamento.getData().get(DAY_OF_WEEK) == 5) {
            tratamento.setDiaNome("Quinta-Feira");
        } else if (tratamento.getData().get(DAY_OF_WEEK) == 6) {
            tratamento.setDiaNome("Sexta-Feira");
        } else if (tratamento.getData().get(DAY_OF_WEEK) == 7) {
            tratamento.setDiaNome("Sábado");
        } else {
            tratamento.setDiaNome("Domingo");
        }
    }

    /**
     * Data formatter.
     *
     * @param tratamento the tratamento
     */
    public static void dataFormatter(Tratamento tratamento) {
        Date formatar = tratamento.getData().getTime();
        DateFormat formataData = DateFormat.getDateInstance();
        tratamento.setDataNome(formataData.format(formatar));
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
    
    public static void verifyAndSetFuncionario(Tratamento tratamento, FuncionarioDAO funcionarioDao) {
        List<Funcionario> funcionarios = funcionarioDao.listAll();
        
        for(Funcionario funcionario: funcionarios) {
            if(funcionario.getId() == tratamento.getResponsavel().getId()) {
                tratamento.setResponsavel(funcionario);
            }
        }
    }
}
