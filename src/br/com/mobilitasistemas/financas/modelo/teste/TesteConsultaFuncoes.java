package br.com.mobilitasistemas.financas.modelo.teste;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import util.JPAUtil;
import br.com.mobilitasistemas.financas.modelo.Conta;
import br.com.mobilitasistemas.financas.modelo.TipoMovimentacao;

public class TesteConsultaFuncoes {

    public static void main(final String[] args) {
        // TODO Auto-generated method stub

        final EntityManager manager = new JPAUtil().getEntityManager();

        final Conta conta = new Conta();
        conta.setId(5);

        /*
         * final EntityManager manager = new JPAUtil().getEntityManager();
         *
         * final Conta conta = new Conta(); conta.setId(5);
         *
         *
         *
         * final MovimentacaoDAO dao = new MovimentacaoDAO(manager);
         *
         * final Double media = dao.mediaDaContaPeloTipo(conta, TipoMovimentacao.SAIDA);
         *
         * System.out.println("Soma de todas as movimentações: " + media);
         */

        final TypedQuery<Double> query =
                        manager.createNamedQuery("mediaDaContaPeloTipoMovimentacao", Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        final Double media = query.getSingleResult();
        System.out.println(media);



    }

}
