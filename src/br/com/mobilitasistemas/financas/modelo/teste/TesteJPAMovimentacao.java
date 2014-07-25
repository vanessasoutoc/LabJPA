package br.com.mobilitasistemas.financas.modelo.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import util.JPAUtil;
import br.com.mobilitasistemas.financas.modelo.Conta;
import br.com.mobilitasistemas.financas.modelo.Movimentacao;
import br.com.mobilitasistemas.financas.modelo.TipoMovimentacao;


public class TesteJPAMovimentacao {

    public static void main(final String[] args) {

        /*
         * criou conta e atribuiu movimentacao; final Conta conta = new Conta();
         * conta.setTitular("Ana Maria"); conta.setBanco("HSBC"); conta.setNumero("123456");
         * conta.setAgencia("0321");
         */

        final Conta conta = new Conta();
        conta.setId(2);

        final Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Conta de luz");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("88.9"));

        movimentacao.setConta(conta);


        final EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();

        // manager.persist(conta);
        manager.persist(movimentacao);
        manager.getTransaction().commit();

        manager.close();


    }
}
