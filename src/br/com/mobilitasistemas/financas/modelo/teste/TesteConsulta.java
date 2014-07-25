package br.com.mobilitasistemas.financas.modelo.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.mobilitasistemas.financas.modelo.Conta;
import br.com.mobilitasistemas.financas.modelo.Movimentacao;
import br.com.mobilitasistemas.financas.modelo.TipoMovimentacao;
import util.JPAUtil;

public class TesteConsulta {

    public static void main(final String[] args) {
        // TODO Auto-generated method stub

        final EntityManager manager = new JPAUtil().getEntityManager();

        final Conta conta = new Conta();
        conta.setId(5);


        final Query query =
                        manager.createQuery("select m from Movimentacao m where m.conta=:pConta"
                                        + " and m.tipoMovimentacao=:pTipo"
                                        + " order by m.valor desc");

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        final List<Movimentacao> movimentacoes = query.getResultList();

        for (final Movimentacao m : movimentacoes) {
            System.out.println("\nDescricao..: " + m.getDescricao());
            System.out.println("Valor......: " + m.getValor());
        }

    }
}
