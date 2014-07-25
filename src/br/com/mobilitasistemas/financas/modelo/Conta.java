package br.com.mobilitasistemas.financas.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



// Entity signigica que a classe vai representar uma tabela!

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titular;
    private String banco;
    private String agencia;
    private String numero;

    @OneToMany(mappedBy = "conta")
    private List<Movimentacao> movimentacao;

    public List<Movimentacao> getMovimentacao() {
        return this.movimentacao;
    }

    public void setMovimentacao(final List<Movimentacao> movimentacao) {
        this.movimentacao = movimentacao;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(final String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public void setAgencia(final String agencia) {
        this.agencia = agencia;
    }

    public String getBanco() {
        return this.banco;
    }

    public void setBanco(final String banco) {
        this.banco = banco;
    }

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(final String titular) {
        this.titular = titular;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }



}
