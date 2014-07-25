package br.com.mobilitasistemas.financas.modelo.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import util.JPAUtil;
import br.com.mobilitasistemas.financas.modelo.Conta;

public class TesteMovimentacaoConta {

    public static void main(final String[] args) {
        // TODO Auto-generated method stub

        final EntityManager manager = new JPAUtil().getEntityManager();

        // procura a movimentacao;

        manager.find(Conta.class, 2);

        // System.out.println("Titular da conta: " + conta.getMovimentacao().size());


        final Query query = manager.createQuery("select c from Conta c");

        final List<Conta> contas = query.getResultList();

        for (final Conta conta1 : contas) {
            System.out.println("Numero de movimentacoes: " + conta1.getMovimentacao().size());
        }

    }
}
