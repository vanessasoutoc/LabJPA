package br.com.mobilitasistemas.financas.modelo.teste;

import javax.persistence.EntityManager;

import br.com.mobilitasistemas.financas.modelo.Conta;
import util.JPAUtil;

public class TesteJPA {

    public static void main(final String[] args) {
        // TODO Auto-generated method stub



        // final Conta conta = new Conta();
        // conta.setTitular("Flavio Albuquerque");
        // conta.setBanco("HSBC");
        // conta.setNumero("123456");
        // conta.setAgencia("0321");



        final EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();
        // procura conta pelo id
        final Conta conta = em.find(Conta.class, 4);

        // System.out.println(conta.getTitular());

        // altera nome do titular da conta;
        // conta.setTitular("Pedrinho");
        // Mostra nome do titular da conta
        System.out.println(conta.getTitular());

        // em.persist(conta);
        em.getTransaction().commit();

        em.close();


    }

}
